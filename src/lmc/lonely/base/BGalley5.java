package lmc.lonely.base;
import java.util.List;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ViewSwitcher.ViewFactory;
import lmc.adater.BGalley5Adapter;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.lonely.SysConts;
import lmc.utils.OtherUtils;
public class BGalley5 extends Activity {
	private List<String>pList = null;
	private TextView gal_5path = null;
	private Gallery gal_5show = null;
	private ImageSwitcher gal_5is = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal5);
        gal_5path = (TextView) super.findViewById(R.id.gal_5path);
        gal_5show = (Gallery) super.findViewById(R.id.gal_5show);
        gal_5is = (ImageSwitcher) super.findViewById(R.id.gal_5is);
        pList = OtherUtils.getSdFile(SysArgs.SD,SysConts.fms);
		gal_5show.setAdapter(new BGalley5Adapter(this,pList));
	    gal_5show.setOnItemClickListener(new OnItemClickListener() {
	    	@Override
			public void onItemClick(AdapterView<?> adater, View v, int index, long id) {
				gal_5is.setImageURI(Uri.parse(pList.get(index)));
				gal_5path.setText(pList.get(index));
			}
	    });
        gal_5is.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView iv = new ImageView(BGalley5.this);
				iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
				iv.setPadding(2,2,2,2);
				iv.setBackgroundColor(0xFF00FFFF);
				iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				return iv;
			}
		});
        gal_5is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        gal_5is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        if(pList.size()>0){
        	gal_5is.setImageURI(Uri.parse(pList.get(0)));
        	gal_5path.setText(pList.get(0));
        }else{
        	gal_5is.setImageResource(R.drawable.icob_gal01);
        	gal_5path.setText("SD¿¨Ã»ÓÐÍ¼Æ¬");
        }
    }
}