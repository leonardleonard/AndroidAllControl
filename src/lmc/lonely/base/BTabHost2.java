package lmc.lonely.base;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import lmc.lonely.R;
import lmc.lonely.SysConts;
public class BTabHost2 extends TabActivity {
	private int[]lays = new int[]{R.id.tabh_lay21,R.id.tabh_lay22,R.id.tabh_lay23};
	private TabHost tabh = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabh = super.getTabHost();
        LayoutInflater.from(this).inflate(R.layout.base_tabh2,tabh.getTabContentView(),true);
        for(int i=0;i<lays.length;i++){
        	TabSpec ts = tabh.newTabSpec("lmc"+i);
        	ts.setIndicator(SysConts.owner+"-"+i);
        	ts.setContent(lays[i]);
        	tabh.addTab(ts);
        }
        tabh.setCurrentTab(1);
    }
}