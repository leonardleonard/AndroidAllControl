package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import lmc.lonely.SysConts;
import lmc.utils.OtherUtils;
public class BListView4 extends Activity {
	private ListView list_4view = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_4view = new ListView(this);
        list_4view.setBackgroundColor(OtherUtils.getColor(255,204,255));
        list_4view.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,SysConts.datao));
        super.setContentView(list_4view);
    }
}