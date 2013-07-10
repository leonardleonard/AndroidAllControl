package lmc.lonely.sys;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import lmc.lonely.R;
public class SysServ extends Activity implements OnClickListener {
	private Button serv_start = null;
	private Button serv_end = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.sys_serv);
        serv_start = (Button) super.findViewById(R.id.serv_start);
        serv_end = (Button) super.findViewById(R.id.serv_end);
        serv_start.setOnClickListener(this);
        serv_end.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.serv_start){
			Intent it = new Intent();
			it.setClass(this,SysServMgr.class);
			this.startService(it);
		}else if(v.getId()==R.id.serv_end){
			Intent it = new Intent();
			it.setClass(this,SysServMgr.class);
			this.stopService(it);
		}
	}
}