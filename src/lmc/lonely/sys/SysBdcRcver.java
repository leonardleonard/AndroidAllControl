package lmc.lonely.sys;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
public class SysBdcRcver extends BroadcastReceiver {
	@Override
	public void onReceive(Context con, Intent it) {
		Toast.makeText(con,this.getClass().getName()+"->配置实现接收到"+SysBdc.class.getName()+"的广播",Toast.LENGTH_SHORT).show();
	}
}