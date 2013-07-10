package lmc.lonely.sys;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import lmc.lonely.R;
public class SysHsqp extends Activity implements OnClickListener {
	private TextView hsqp_msg = null;
	private ImageView hsqp_ico = null;
	private Button hsqp_qp = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.sys_hsqp);
        hsqp_msg = (TextView) super.findViewById(R.id.hsqp_msg);
        hsqp_ico = (ImageView) super.findViewById(R.id.hsqp_ico);
        hsqp_qp = (Button) super.findViewById(R.id.hsqp_qp);
        hsqp_qp.setOnClickListener(this);
	}
	@Override
	public void onConfigurationChanged(Configuration con) {
		super.onConfigurationChanged(con);
		if(con.orientation==Configuration.ORIENTATION_LANDSCAPE){
			hsqp_ico.setImageResource(R.drawable.icos_hsqp2);
		}else if(con.orientation==Configuration.ORIENTATION_PORTRAIT){
			hsqp_ico.setImageResource(R.drawable.icos_hsqp1);
		}
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.hsqp_qp){
			if(super.getRequestedOrientation()==ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED){
				hsqp_msg.setText("没有切屏权限");
				return;
			}
			if(super.getRequestedOrientation()==ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
				super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				hsqp_msg.setText("当前为竖屏");
			}else if(super.getRequestedOrientation()==ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
				super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				hsqp_msg.setText("当前为横屏");
			}
		}
	}
}