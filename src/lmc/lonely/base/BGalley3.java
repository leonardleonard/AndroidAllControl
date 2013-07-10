package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import lmc.lonely.R;
public class BGalley3 extends Activity implements OnClickListener {
	private int index = 0;
	private ImageButton gal_3pre = null;
	private ImageSwitcher gal_3is = null;
	private ImageButton gal_3next = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal3);
        gal_3pre = (ImageButton) super.findViewById(R.id.gal_3pre);
        gal_3is = (ImageSwitcher) super.findViewById(R.id.gal_3is);
        gal_3next = (ImageButton) super.findViewById(R.id.gal_3next);
        gal_3is.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView iv = new ImageView(BGalley3.this);
				iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
				iv.setPadding(2,2,2,2);
				iv.setBackgroundColor(0xFF00FFFF);;
				iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				return iv;
			}
		});
        gal_3is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        gal_3is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        gal_3is.setImageResource(BGalley0.pics[index]);
        this.isEnable();
        gal_3pre.setOnClickListener(this);
        gal_3next.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.gal_3pre){
			index -= 1;
			gal_3is.setImageResource(BGalley0.pics[index]);
			this.isEnable();
		}else if(v.getId()==R.id.gal_3next){
			index += 1;
			gal_3is.setImageResource(BGalley0.pics[index]);
			this.isEnable();
		}
	}
	private void isEnable(){
    	if(index==0){
    		gal_3pre.setEnabled(false);
    		gal_3next.setEnabled(true);
    	}else if(index==BGalley0.pics.length-1){
    		gal_3pre.setEnabled(true);
    		gal_3next.setEnabled(false);
    	}else{
    		gal_3pre.setEnabled(true);
    		gal_3next.setEnabled(true);
    	}
    }
}