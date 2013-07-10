package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ViewFlipper;
import lmc.lonely.R;
public class BPopup extends Activity implements OnClickListener {
	private Button popup_top = null;
	private Button popup_buttom = null;
	private PopupWindow win = null;
	private Button popup_hide = null;
	private ViewFlipper popup_rname = null;
	private ViewFlipper popup_rimg = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_popup);
        popup_top = (Button) super.findViewById(R.id.popup_top);
		popup_buttom = (Button) super.findViewById(R.id.popup_buttom);
		View lay = ((LayoutInflater) super.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.base_popupview,null);
		win = new PopupWindow(lay,480,350);
		popup_hide = (Button) lay.findViewById(R.id.popup_hide);
		popup_rname = (ViewFlipper) lay.findViewById(R.id.popup_rname);
		popup_rimg = (ViewFlipper) lay.findViewById(R.id.popup_rimg);
		popup_top.setOnClickListener(this);
		popup_buttom.setOnClickListener(this);
		popup_hide.setOnClickListener(this);
		popup_rname.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_popup_in));
		popup_rname.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_popup_out));
		popup_rimg.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_popup_in));
		popup_rimg.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_popup_out));
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.popup_top){
			win.showAsDropDown(v);
			popup_rname.startFlipping();
			popup_rimg.startFlipping();
		}else if(v.getId()==R.id.popup_buttom){
			win.showAtLocation(super.findViewById(R.id.popup_lay),Gravity.BOTTOM,0,0); 
			popup_rname.startFlipping();
			popup_rimg.startFlipping();
		}else if(v.getId()==R.id.popup_hide){
			win.dismiss();
		}
	}
}