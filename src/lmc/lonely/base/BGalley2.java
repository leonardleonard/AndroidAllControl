package lmc.lonely.base;
import java.util.ArrayList;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.lonely.SysConts;
import lmc.utils.OtherUtils;
public class BGalley2 extends Activity implements OnClickListener {
	private int index = 0;
	private String[]paths = null;
	private TextView gal_2path = null;
	private ImageButton gal_2pre = null;
	private ImageSwitcher gal_2is = null;
	private ImageButton gal_2next = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal2);
        gal_2path = (TextView) super.findViewById(R.id.gal_2path);
        gal_2pre = (ImageButton) super.findViewById(R.id.gal_2pre);
        gal_2is = (ImageSwitcher) super.findViewById(R.id.gal_2is);
        gal_2next = (ImageButton) super.findViewById(R.id.gal_2next);
        gal_2is.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView iv = new ImageView(BGalley2.this);
				iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
				iv.setPadding(2,2,2,2);
				iv.setBackgroundColor(0xFF00FFFF);;
				iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				return iv;
			}
		});
        ArrayList<String>pList = OtherUtils.getSdFile(SysArgs.SD,SysConts.fms);
        if(pList.size()>0){
        	paths = pList.toArray(new String[pList.size()]);
        	index = 0;
        	gal_2is.setImageURI(Uri.parse(paths[index]));
        	gal_2path.setText(paths[index]);
        }else{
        	gal_2is.setImageResource(R.drawable.icob_gal01);
        	gal_2path.setText("SD¿¨Ã»ÓÐÍ¼Æ¬");
        }
        gal_2is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        gal_2is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        gal_2pre.setOnClickListener(this);
        gal_2next.setOnClickListener(this);
        this.isEnable();
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.gal_2pre){
			index -= 1;
			gal_2is.setImageURI(Uri.parse(paths[index]));
			gal_2path.setText(paths[index]);
			this.isEnable();
		}else if(v.getId()==R.id.gal_2next){
			index += 1;
			gal_2is.setImageURI(Uri.parse(paths[index]));
			gal_2path.setText(paths[index]);
			this.isEnable();
		}
	}
	private void isEnable(){
		if(paths==null){
			gal_2pre.setEnabled(false);
			gal_2next.setEnabled(false);
			return;
		}
		if(paths.length<2){
			gal_2pre.setEnabled(false);
			gal_2next.setEnabled(false);
			return;
		}
    	if(index==0){
    		gal_2pre.setEnabled(false);
    		gal_2next.setEnabled(true);
    	}else if(index==paths.length-1){
    		gal_2pre.setEnabled(true);
    		gal_2next.setEnabled(false);
    	}else{
    		gal_2pre.setEnabled(true);
    		gal_2next.setEnabled(true);
    	}
    }
}