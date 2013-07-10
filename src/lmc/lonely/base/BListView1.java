package lmc.lonely.base;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import lmc.lonely.R;
import lmc.lonely.SysConts;
public class BListView1 extends Activity {
	private ArrayList<HashMap<String,String>>dList = null;
	private SimpleAdapter sAd = null;
	private ListView list_1view = null;
	private TextView list_1msg = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_list1);
        list_1view = (ListView) super.findViewById(R.id.list_1view);
        list_1msg = (TextView) super.findViewById(R.id.list_1msg);
        dList = new ArrayList<HashMap<String,String>>();
        for(int i=0;i<SysConts.datat.length;i++){
        	HashMap<String,String>data = new HashMap<String,String>();
        	data.put("title",SysConts.datat[i][0]);
        	data.put("cont",SysConts.datat[i][1]);
        	dList.add(data);
        }
        sAd = new SimpleAdapter(this,dList,R.layout.base_list1view,new String[]{"title","cont"},new int[]{R.id.list_1title,R.id.list_1cont});
        list_1view.setAdapter(sAd);
        list_1view.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> ad, View v, int index, long id) {
				@SuppressWarnings("unchecked")
				HashMap<String,String>data = (HashMap<String,String>)sAd.getItem(index);
				list_1msg.setText(data.get("title")+data.get("cont"));
			}
		});
    }
}