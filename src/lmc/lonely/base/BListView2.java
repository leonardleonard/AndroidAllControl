package lmc.lonely.base;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import lmc.lonely.R;
import lmc.lonely.SysConts;
public class BListView2 extends Activity {
	private String[][]datas = new String[][]{{"Oracle数据库","韩顺平"},{"J2EE开发","韩顺平"},{"Android开发","李兴华"},{SysConts.appName,SysConts.owner}};
	private List<HashMap<String,String>>dList = null;
	private SimpleAdapter sAd = null;
	private ListView list_2view = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_list2);
        list_2view = (ListView) super.findViewById(R.id.list_2view);
        dList = new ArrayList<HashMap<String,String>>();
        for(int j=0;j<datas.length;j++){
        	HashMap<String,String>data = new HashMap<String,String>();
        	data.put("ico",String.valueOf(R.drawable.icob_list2));
        	data.put("title",datas[j][0]);
        	data.put("auth",datas[j][1]);
        	data.put("type","免费");
        	data.put("score",String.valueOf(R.drawable.icob_list3));
        	dList.add(data);
        }
        sAd = new SimpleAdapter(this,dList,R.layout.base_list2view,new String[]{"ico","title","auth","type","score"},
        	new int[]{R.id.list_2bkico,R.id.list_2bktitle,R.id.list_2bkauth,R.id.list_2bktype,R.id.list_2bkscore});
        list_2view.setAdapter(sAd);
    }
}