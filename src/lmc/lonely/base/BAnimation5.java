package lmc.lonely.base;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import lmc.lonely.R;
public class BAnimation5 extends Activity implements OnClickListener {
	private int index = 0;
	private int[]aIds = new int[]{R.anim.ani_anima_5mysim,R.anim.ani_anima_5a,R.anim.ani_anima_5s,R.anim.ani_anima_5t,R.anim.ani_anima_5r,
		R.anim.ani_anima_5as,R.anim.ani_anima_5at,R.anim.ani_anima_5ar,R.anim.ani_anima_5st,R.anim.ani_anima_5sr,R.anim.ani_anima_5tr,
		R.anim.ani_anima_53ast,R.anim.ani_anima_53asr,R.anim.ani_anima_53atr,R.anim.ani_anima_53str,
		R.anim.ani_anima_54astr,R.anim.ani_anima_5mycox
	};
	public static String[]datas = new String[]{"简单自定义","透明","伸缩","移动","旋转",
		"透明_伸缩","透明_移动","透明_旋转","伸缩_移动","伸缩_旋转","移动_旋转",
		"透明_伸缩_移动","透明_伸缩_旋转","透明_移动_旋转","伸缩_移动_旋转",
		"透明_伸缩_移动_旋转","复杂自定义"
	};
	private Button anim_5first = null;
	private Button anim_5pre = null;
	private Button anim_5replay = null;
	private Button anim_5next = null;
	private Button anim_5last = null;
	private Button anim_5list = null;
	private Button anim_5power = null;
	private TextView anima_5msg = null;
	private View anim_5star = null;
	protected Animation anim = null;
	private int reqCode = 110;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.base_anima5);
		anim_5first = (Button) super.findViewById(R.id.anima_5first);
		anim_5pre = (Button) super.findViewById(R.id.anima_5pre);
		anim_5replay = (Button) super.findViewById(R.id.anima_5replay);
		anim_5next = (Button) super.findViewById(R.id.anima_5next);
		anim_5last = (Button) super.findViewById(R.id.anima_5last);
		anim_5list = (Button) super.findViewById(R.id.anima_5list);
		anim_5power = (Button) super.findViewById(R.id.anima_5power);
		anim_5star = super.findViewById(R.id.anima_5star);
		anima_5msg = (TextView) super.findViewById(R.id.anima_5msg);
		anim_5first.setOnClickListener(this);
		anim_5pre.setOnClickListener(this);
		anim_5replay.setOnClickListener(this);
		anim_5next.setOnClickListener(this);
		anim_5last.setOnClickListener(this);
		anim_5list.setOnClickListener(this);
		anim_5power.setOnClickListener(this);
		anim_5star.setOnClickListener(this);
		anima_5msg.setText(datas[index]);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0,Menu.FIRST+1,1,"上一个动画").setIcon(R.drawable.icob_anima_5mpre);
		menu.add(0,Menu.FIRST+2,2,"下一个动画").setIcon(R.drawable.icob_anima_5mnext);
		menu.add(0,Menu.FIRST+3,3,"重新播放").setIcon(R.drawable.icob_anima_5mreplay);
		menu.add(0,Menu.FIRST+4,4,"选择动画").setIcon(R.drawable.icob_anima_5mselect);
		menu.add(0,Menu.FIRST+5,5,"退出").setIcon(R.drawable.icob_anima_5mpower);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case Menu.FIRST+1:this.doAnim(-1);break;
			case Menu.FIRST+2:this.doAnim(1);break;
			case Menu.FIRST+3:this.doAnim(999);break;
			case Menu.FIRST+4:this.startActivityForResult(new Intent(this,BAnimation5List.class),reqCode);break;
			case Menu.FIRST+5:super.onBackPressed();break;
			default:break;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onActivityResult(int req, int res, Intent data) {
		if(req==reqCode){
			if(res==RESULT_OK){
				try{
					index = data.getExtras().getInt("index");
					this.doAnim(999);
				}catch(Exception e){
					Toast.makeText(this,"请求出错",Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.anima_5first){
			index = 0;
			this.doAnim(999);
		}else if(v.getId()==R.id.anima_5pre){
			this.doAnim(-1);
		}else if(v.getId()==R.id.anima_5replay){
			this.doAnim(999);
		}else if(v.getId()==R.id.anima_5next){
			this.doAnim(1);
		}else if(v.getId()==R.id.anima_5last){
			index = aIds.length-1;
			this.doAnim(999);
		}else if(v.getId()==R.id.anima_5list){
			this.startActivityForResult(new Intent(this,BAnimation5List.class),reqCode);
		}else if(v.getId()==R.id.anima_5power){
			super.onBackPressed();
		}
	}
	private void doAnim(int incre){
		if(incre!=999){
			index += incre;
		}
		if(index<0){
			index = aIds.length-1;
		}
		if(index>=aIds.length){
			index = 0;
		}
		anima_5msg.setText(datas[index]);
		anim = AnimationUtils.loadAnimation(this,aIds[index]);
		anim_5star.startAnimation(anim);
	}
}