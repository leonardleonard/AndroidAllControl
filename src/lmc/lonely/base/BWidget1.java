package lmc.lonely.base;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;
import lmc.lonely.R;
import lmc.lonely.Wel;
public class BWidget1 extends AppWidgetProvider {
	@Override
	public void onUpdate(Context con, AppWidgetManager mgr, int[]ids) {
		super.onUpdate(con, mgr, ids);
		Toast.makeText(con,"执行更新A",Toast.LENGTH_SHORT).show();
		for(int i=0;i<ids.length;i++){
			Intent it = new Intent(con,Wel.class);
			RemoteViews rViews = new RemoteViews(con.getPackageName(),R.layout.base_widg);
			PendingIntent pIt = PendingIntent.getActivity(con,0,it,0);
			rViews.setOnClickPendingIntent(R.id.widg_call,pIt);
			mgr.updateAppWidget(ids[i],rViews);
		}
	}
	@Override
	public void onDeleted(Context con, int[]ids) {
		super.onDeleted(con, ids);
		Toast.makeText(con,"移除桌面应用A",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onEnabled(Context con) {
		super.onEnabled(con);
		Toast.makeText(con,"执行启用A",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onDisabled(Context con) {
		super.onDisabled(con);
		Toast.makeText(con,"执行禁用A",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onReceive(Context con, Intent it) {
		super.onReceive(con, it);
		Toast.makeText(con,"接受广播事件A",Toast.LENGTH_SHORT).show();
	}
}