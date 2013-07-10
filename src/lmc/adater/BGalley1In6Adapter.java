package lmc.adater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
public class BGalley1In6Adapter extends BaseAdapter {
	private Context con = null;
	private int[]ids = null;
	public BGalley1In6Adapter(Context con, int[]ids) {
		this.con = con;
		this.ids = ids;
	}
	@Override
	public int getCount(){
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
		iv.setLayoutParams(new Gallery.LayoutParams(40,LayoutParams.MATCH_PARENT));
		iv.setPadding(2,2,2,2);
		iv.setBackgroundColor(0xFFFFFFFF);
		iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		return iv;
	}
}