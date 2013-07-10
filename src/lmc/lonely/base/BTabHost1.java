package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import lmc.lonely.R;
import lmc.lonely.SysConts;
public class BTabHost1 extends Activity {
	private int[]lays = new int[]{R.id.tabh_lay11,R.id.tabh_lay12,R.id.tabh_lay13};
	private TabHost tabh = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_tabh1);
        tabh = (TabHost) super.findViewById(R.id.tabh_lay1);
        tabh.setup();
        for(int i=0;i<lays.length;i++){
        	TabSpec ts = tabh.newTabSpec("lmc"+i);
        	ts.setIndicator(SysConts.owner+"-"+i);
        	ts.setContent(lays[i]);
        	tabh.addTab(ts);
        }
        tabh.setCurrentTab(2);
    }
}