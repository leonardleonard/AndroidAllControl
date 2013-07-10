package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import lmc.adater.BGalley8Adapter;
import lmc.lonely.R;
public class BGalley8 extends Activity {
	private GridView gal_8grid = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal8);
        gal_8grid = (GridView) super.findViewById(R.id.gal_8grid);
        gal_8grid.setAdapter(new BGalley8Adapter(this,BGalley0.pics));
        gal_8grid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?>par, View v, int index, long id) {
				Toast.makeText(BGalley8.this,"index="+index,Toast.LENGTH_SHORT).show();
			}
		});
    }
}