package lmc.adater;
import java.util.List;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
public class BGalley5Adapter extends BaseAdapter {
	private Context con = null;
	private List<String>paths = null;
	public BGalley5Adapter(Context con, List<String>paths) {
		this.con = con;
		this.paths = paths;
	}
	@Override
	public int getCount(){
		return paths.size();
	}
	@Override
	public Object getItem(int posi) {
		return posi;
	}
	@Override
	public long getItemId(int posi) {
		return posi;
	}
	@Override
	public View getView(int posi, View v, ViewGroup par) {
		ImageView iv = new ImageView(con);
		iv.setImageBitmap(BitmapFactory.decodeFile(paths.get(posi)));
		iv.setLayoutParams(new Gallery.LayoutParams(40,Gallery.LayoutParams.MATCH_PARENT));
		iv.setPadding(2,2,2,2);
		iv.setBackgroundColor(0xFFFFFFFF);
		iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		return iv;
	}
}