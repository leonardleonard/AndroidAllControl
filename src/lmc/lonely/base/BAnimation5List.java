package lmc.lonely.base;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import lmc.lonely.R;
public class BAnimation5List extends Activity implements OnItemClickListener, OnItemSelectedListener {
	private ArrayAdapter<String>aAd = null;
	private ListView anim_5listview = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.base_anima5list);
		aAd = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,BAnimation5.datas);
		anim_5listview = (ListView) super.findViewById(R.id.anima_5listview);
		anim_5listview.setAdapter(aAd);
		anim_5listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		anim_5listview.setOnItemClickListener(this);
		anim_5listview.setOnItemSelectedListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> ad, View v, int index, long id) {
		Intent it = new Intent();
		Bundle data = new Bundle();
		data.putInt("index",index);
		it.putExtras(data);
		this.setResult(RESULT_OK,it);
		this.finish();
	}
	@Override
	public void onItemSelected(AdapterView<?> ad, View v, int posi,long id) {
		this.setTitle(aAd.getItem(posi));
		anim_5listview.setItemChecked(posi,true);
	}
	@Override
	public void onNothingSelected(AdapterView<?> ad) {}
}