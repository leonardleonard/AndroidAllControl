package lmc.adater;
import java.util.List;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import lmc.lonely.R;
public class FLkFilesAdapter extends ArrayAdapter<String> {
	private Activity con = null;
	private List<String>paths = null;
	public FLkFilesAdapter(Activity con, List<String>paths) {
		super(con,R.layout.file_lokrows,paths);
		this.con = con;
		this.paths = paths;
	}
	@Override
	public View getView(int posi, View v, ViewGroup par) {
		View res = v;
		ViewHolder vh = null;
		if(res==null){
			res = con.getLayoutInflater().inflate(R.layout.file_lokrows,null,true);
			vh = new ViewHolder();
			vh.iv = (ImageView) res.findViewById(R.id.lok_ico);
			vh.tv = (TextView) res.findViewById(R.id.lok_title);
			res.setTag(vh);
		}else{
			vh = (ViewHolder) res.getTag();
		}
		vh.tv.setText(paths.get(posi));
		vh.iv.setImageResource(paths.get(posi).endsWith("/")?R.drawable.icof_lok2:R.drawable.icof_lok1);
		return res;
	}
	class ViewHolder {
		public ImageView iv;
		public TextView tv;
	}
}