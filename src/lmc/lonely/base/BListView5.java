package lmc.lonely.base;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import lmc.lonely.R;
import lmc.lonely.SysConts;
import lmc.utils.OtherUtils;
public class BListView5 extends ListActivity {
	private List<Map<String,String>>dList = null;
	private SimpleAdapter sAd = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.getListView().setBackgroundColor(OtherUtils.getColor(255,204,255));
        dList = new ArrayList<Map<String,String>>();
        for(int i=0;i<SysConts.datat.length;i++){
         	Map<String,String>data = new HashMap<String,String>();
         	data.put("title",SysConts.datat[i][0]);
         	data.put("cont",SysConts.datat[i][1]);
         	dList.add(data);
        }
        sAd = new SimpleAdapter(this,dList,R.layout.base_list5,new String[]{"title","cont"},new int[]{R.id.list_5title,R.id.list_5cont});
        super.setListAdapter(sAd);
    }
	@Override
	protected void onListItemClick(ListView lv, View v, int pos, long id) {
		super.onListItemClick(lv, v, pos, id);
		Toast.makeText(this,"±»Ñ¡ID:"+id,Toast.LENGTH_SHORT).show();
	}
}