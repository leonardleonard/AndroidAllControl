package lmc.lonely.sys;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
public class SysServMgr extends Service {
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(super.getApplication().getApplicationContext(),"Service onCreate",Toast.LENGTH_SHORT).show();
	}
	@Override
	public int onStartCommand(Intent it, int flags, int startId) {
		Toast.makeText(super.getApplication().getApplicationContext(),
			"Service onStartCommand\nflags->"+flags+" startId->"+startId+" ->"+Service.START_NOT_STICKY,Toast.LENGTH_SHORT).show();
		return super.onStartCommand(it, flags, startId);
	}
	@Override
	public IBinder onBind(Intent it) {
		Toast.makeText(super.getApplication().getApplicationContext(),"Service onBind",Toast.LENGTH_SHORT).show();
		return null;
	}
	@Override
	public void onDestroy() {
		Toast.makeText(super.getApplication().getApplicationContext(),"Service onDestroy",Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}
}