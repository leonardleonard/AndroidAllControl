package lmc.adater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
public class BGalley8Adapter extends BaseAdapter {
	private Context con = null;
	private int[]ids = null;
	public BGalley8Adapter(Context con, int[]ids) {
		this.con = con;
		this.ids = ids;
	}
	@Override
	public int getCount() {
		return ids.length;
	}
	@Override
	public Object getItem(int posi) {
		return ids[posi];
	}
	@Override
	public long getItemId(int posi) {
		return ids[posi];
	}
	@Override
	public View getView(int posi, View v, ViewGroup par) {
		ImageView iv = new ImageView(con);
		iv.setImageResource(ids[posi]);
		iv.setPadding(2,2,2,2);
		iv.setBackgroundColor(0xFF00FFFF);
		iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		return iv;
	}
}