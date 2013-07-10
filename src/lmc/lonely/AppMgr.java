package lmc.lonely;
import java.util.ArrayList;
import android.app.Activity;
import android.app.Application;
public class AppMgr extends Application {
	private String appName = null;
	private static ArrayList<Activity>acts = null;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		appName = SysConts.appName;
		acts = new ArrayList<Activity>();
	}
	public void add(Activity act){
		if(acts==null){
			acts = new ArrayList<Activity>();
		}
		if(!acts.contains(act)){
			acts.add(act);
		}
	}
	public void finish(){
		for(Activity act:acts){
			if(!act.isFinishing()){
				act.finish();
			}
		}
		acts = null;
		System.exit(0);
	}
}