package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import lmc.lonely.R;
public class BAnimation1 extends Activity implements OnClickListener {
	private Button anima_1drdc = null;
	private Button anima_1sfxg = null;
	private Button anima_1xzxg = null;
	private Button anima_1ydxg = null;
	private ImageView anima_1img = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_anima1);
        anima_1drdc = (Button) super.findViewById(R.id.anima_1drdc);
        anima_1sfxg = (Button) super.findViewById(R.id.anima_1sfxg);
        anima_1xzxg = (Button) super.findViewById(R.id.anima_1xzxg);
        anima_1ydxg = (Button) super.findViewById(R.id.anima_1ydxg);
        anima_1img = (ImageView) super.findViewById(R.id.anima_1img);
        anima_1drdc.setOnClickListener(this);
        anima_1sfxg.setOnClickListener(this);
        anima_1xzxg.setOnClickListener(this);
        anima_1ydxg.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.anima_1drdc){
			AlphaAnimation alpha = new AlphaAnimation(1.0f,0.0f);
			alpha.setDuration(1000);
			alpha.setStartOffset(1000);
			//true:共享变化
			AnimationSet aSet = new AnimationSet(true);
			aSet.setInterpolator(new DecelerateInterpolator());
			aSet.addAnimation(alpha);
			anima_1img.startAnimation(aSet);
		}else if(v.getId()==R.id.anima_1sfxg){
			AnimationSet aSet = new AnimationSet(true);
			ScaleAnimation scale = new ScaleAnimation(1.0f,0.1f,1.0f,0.1f,
				Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
			scale.setDuration(3000);
			scale.setRepeatCount(2);
			aSet.addAnimation(scale);
			anima_1img.startAnimation(aSet);
		}else if(v.getId()==R.id.anima_1xzxg){
			AnimationSet aSet = new AnimationSet(true);
			RotateAnimation rotate = new RotateAnimation(0,360,
				Animation.RELATIVE_TO_PARENT,0.0f,Animation.RELATIVE_TO_PARENT,1.0f);
			rotate.setDuration(5000);
			aSet.addAnimation(rotate);
			anima_1img.startAnimation(aSet);
		}else if(v.getId()==R.id.anima_1ydxg){
			AnimationSet aSet = new AnimationSet(true);
			TranslateAnimation trans = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.5f,
				Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,1.0f);
			trans.setDuration(2000);
			aSet.addAnimation(trans);
			//设置恢复至开始状态,恢复至结束状态,执行次数
			aSet.setFillBefore(false);
			aSet.setFillAfter(true);
			anima_1img.startAnimation(aSet);
		}
	}
}