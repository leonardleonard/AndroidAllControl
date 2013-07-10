package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ViewSwitcher.ViewFactory;
import lmc.adater.BGalley1In6Adapter;
import lmc.lonely.R;
public class BGalley6 extends Activity implements OnClickListener {
	private int index = 0;
	private ImageButton gal_6pre = null;
	private Gallery gal_6show = null;
	private ImageButton gal_6next = null;
	private ImageSwitcher gal_6is = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal6);
        gal_6show = (Gallery) super.findViewById(R.id.gal_6show);
        gal_6pre = (ImageButton) super.findViewById(R.id.gal_6pre);
        gal_6next = (ImageButton) super.findViewById(R.id.gal_6next);
        gal_6is = (ImageSwitcher) super.findViewById(R.id.gal_6is);
        gal_6show.setAdapter(new BGalley1In6Adapter(this,BGalley0.pics));
        gal_6show.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapter, View v, int index, long id) {
				gal_6is.setImageResource(BGalley0.pics[index]);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
        });
        gal_6pre.setOnClickListener(this);
        gal_6next.setOnClickListener(this);
        gal_6is.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView iv = new ImageView(BGalley6.this);
				iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
				iv.setPadding(2,2,2,2);
				iv.setBackgroundColor(0xFF00FFFF);;
				iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				return iv;
			}
		});
        gal_6is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        gal_6is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        this.isEnable();
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.gal_6pre){
			index -= 1;
			gal_6show.setSelection(index);
			gal_6is.setImageResource(BGalley0.pics[index]);
			this.isEnable();
		}else if(v.getId()==R.id.gal_6next){
			index += 1;
			gal_6show.setSelection(index);
			gal_6is.setImageResource(BGalley0.pics[index]);
			this.isEnable();
		}
	}
	private void isEnable(){
    	if(index==0){
    		gal_6pre.setEnabled(false);
    		gal_6next.setEnabled(true);
    	}else if(index==BGalley0.pics.length-1){
    		gal_6pre.setEnabled(true);
    		gal_6next.setEnabled(false);
    	}else{
    		gal_6pre.setEnabled(true);
    		gal_6next.setEnabled(true);
    	}
    }
}