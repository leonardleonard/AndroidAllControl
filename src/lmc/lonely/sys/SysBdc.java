package lmc.lonely.sys;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import lmc.lonely.R;
public class SysBdc extends Activity implements OnClickListener {
	private Button bdcast_bd = null;
	private Button bdcast_set = null;
	private Button bdcast_unset = null;
	private SysBdcSmsRcver bdmr = null;
	private String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.sys_bdcast);
        bdcast_set = (Button) super.findViewById(R.id.bdcast_set);
        bdcast_unset = (Button) super.findViewById(R.id.bdcast_unset);
        bdcast_bd = (Button) super.findViewById(R.id.bdcast_bd);
        bdcast_set.setOnClickListener(this);
        bdcast_unset.setOnClickListener(this);
        bdcast_bd.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.bdcast_set){
			Toast.makeText(this,"可使用Emulator Control模拟器发送短信",Toast.LENGTH_SHORT).show();
			bdmr = new SysBdcSmsRcver();
			IntentFilter fIt = new IntentFilter();
			fIt.addAction(SMS_ACTION);
			this.registerReceiver(bdmr,fIt);
		}else if(v.getId()==R.id.bdcast_unset){
			this.unregisterReceiver(bdmr);
		}else if(v.getId()==R.id.bdcast_bd){
			Intent it = new Intent();
			it.setAction(Intent.ACTION_EDIT);
			this.sendBroadcast(it);
		}
	}
}