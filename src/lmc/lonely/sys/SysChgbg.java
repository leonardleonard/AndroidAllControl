package lmc.lonely.sys;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import lmc.lonely.R;
public class SysChgbg extends Activity implements OnLongClickListener {
	private TextView chgbg_bg = null;
	private ImageView chgbg_img = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.setContentView(R.layout.sys_chgbg);
        chgbg_bg = (TextView) super.findViewById(R.id.chgbg_bg);
        chgbg_img = (ImageView) super.findViewById(R.id.chgbg_img);
        chgbg_img.setOnLongClickListener(this);
        Toast.makeText(this,"全屏设置",Toast.LENGTH_SHORT).show();
	}
	@Override
	public boolean onLongClick(View v) {
		if(v.getId()==R.id.chgbg_img){
			try{
				this.clearWallpaper();
				this.setWallpaper(chgbg_img.getResources().openRawResource(R.drawable.icos_chgbg));
				chgbg_bg.setText("更改系统背景成功");
				return true;
			}catch(Exception e){
				chgbg_bg.setText("更改系统背景失败");
				e.printStackTrace();
			}
		}
		return false;
	}
}