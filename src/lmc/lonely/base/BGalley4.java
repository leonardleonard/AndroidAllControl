package lmc.lonely.base;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ViewSwitcher.ViewFactory;
import lmc.lonely.R;
public class BGalley4 extends Activity {
	private SimpleAdapter adapter = null;
	private Gallery gal_4show = null;
	private ImageSwitcher gal_4is = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal4);
        gal_4show = (Gallery) super.findViewById(R.id.gal_4show);
        gal_4is = (ImageSwitcher) super.findViewById(R.id.gal_4is);
        this.init();
        gal_4show.setAdapter(adapter);
        gal_4show.setOnItemClickListener(new OnItemClickListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void onItemClick(AdapterView<?> ad, View v, int index, long id) {
				Map<String,String>m = (Map<String,String>) adapter.getItem(index);
				gal_4is.setImageResource(Integer.parseInt(m.get("img")));
			}
        });
        gal_4is.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView iv = new ImageView(BGalley4.this);
				iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
				iv.setPadding(2,2,2,2);
				iv.setBackgroundColor(0xFF00FFFF);
				iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				return iv;
			}
		});
        gal_4is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        gal_4is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        gal_4is.setImageResource(R.drawable.icob_gal01);
    }
	private void init(){
    	List<Map<String,String>>imgs = new ArrayList<Map<String,String>>();
		Field[]fds = R.drawable.class.getDeclaredFields();
		for(int i=0;i<fds.length;i++){
			if(fds[i].getName().startsWith("icob_gal")){
				try{
					Map<String,String>img = new HashMap<String,String>();
					img.put("img",String.valueOf(fds[i].getInt(R.drawable.class)));
					imgs.add(img);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		adapter = new SimpleAdapter(this,imgs,R.layout.base_gal4view,new String[]{"img"},new int[]{R.id.gal_4img});
    }
}