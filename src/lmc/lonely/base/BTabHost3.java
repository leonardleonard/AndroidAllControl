package lmc.lonely.base;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;
import lmc.lonely.R;
public class BTabHost3 extends TabActivity {
	private TabHost tabh = null;
	private ListView tabh_listyd = null;
	private ListView tabh_listjs = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabh = super.getTabHost();
        LayoutInflater.from(this).inflate(R.layout.base_tabh3,tabh.getTabContentView(),true);
        tabh.setBackgroundResource(R.drawable.icob_tabh1);
        tabh.addTab(tabh.newTabSpec("A").setIndicator("球类运动",this.getResources().getDrawable(R.drawable.icob_tabh2)).setContent(R.id.tabh_lay31));
		tabh.addTab(tabh.newTabSpec("B").setIndicator("水上项目",this.getResources().getDrawable(R.drawable.icob_tabh3)).setContent(R.id.tabh_lay32));
		tabh.addTab(tabh.newTabSpec("C").setIndicator("野外项目",this.getResources().getDrawable(R.drawable.icob_tabh4)).setContent(R.id.tabh_lay33));
		tabh.addTab(tabh.newTabSpec("D").setIndicator("专业健身",this.getResources().getDrawable(R.drawable.icob_tabh5)).setContent(R.id.tabh_lay34));
		tabh.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tab) {
				Toast.makeText(BTabHost3.this,"选项卡:"+tab,Toast.LENGTH_SHORT).show();
			}
		});
		tabh_listyd = (ListView) super.findViewById(R.id.tabh_3list1);
        tabh_listjs = (ListView) super.findViewById(R.id.tabh_3list2);
		String[]data = new String[]{"野外登山","高山蹦极","徒步远足","海滩沐浴"};
		tabh_listyd.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data));
		tabh_listjs.setAdapter(new SimpleAdapter(this,this.init(),R.layout.base_tabh3list,
			new String[]{"title","cont"},new int[]{R.id.tabh_3title,R.id.tabh_3cont}));
    }
	private ArrayList<HashMap<String,Object>>init(){
    	ArrayList<HashMap<String,Object>>res = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object>data = new HashMap<String,Object>();
		data.put("title",R.drawable.icob_tabh6);
		data.put("cont","器械运动(拉力器,俯卧撑等)");
		res.add(data);
		data = new HashMap<String,Object>();
		data.put("title",R.drawable.icob_tabh7);
		data.put("cont","有氧运动(跑步,健美操等)");
		res.add(data);
		data = new HashMap<String,Object>();
		data.put("title",R.drawable.icob_tabh8);
		data.put("cont","拉伸运动(瑜伽,普拉提等)");
		res.add(data);
		return res;
	}
}