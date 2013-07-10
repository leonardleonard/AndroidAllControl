package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import lmc.lonely.R;
public class BAnimation4 extends Activity implements OnClickListener, AnimationListener {
	private ViewGroup anima_lay4 = null;
	private Button anima_4tjtp = null;
	private Button anima_4sctp = null;
	private ImageView anima_4img = null;
	private boolean isHas = true;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_anima4);
        anima_lay4 = (ViewGroup) super.findViewById(R.id.anima_lay4);
        anima_4tjtp = (Button) super.findViewById(R.id.anima_4tjtp);
        anima_4sctp = (Button) super.findViewById(R.id.anima_4sctp);
        anima_4img = (ImageView) super.findViewById(R.id.anima_4img);
        anima_4tjtp.setOnClickListener(this);
        anima_4sctp.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.anima_4tjtp){
			ImageView iv = new ImageView(this);
			iv.setImageResource(R.drawable.ico_logo);
			anima_lay4.addView(iv,new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
			AlphaAnimation anim = new AlphaAnimation(0.0f,1.0f);
			anim.setDuration(1000);
			anim.setStartOffset(500);
			iv.startAnimation(anim);
			isHas = false;
		}else if(v.getId()==R.id.anima_4sctp){
			AlphaAnimation anim = new AlphaAnimation(1.0f,0.0f);
			anim.setDuration(1000);
			anim.setStartOffset(500);
			anim.setAnimationListener(this);
			anima_4img.startAnimation(anim);
		}
	}
	@Override
	public void onAnimationStart(Animation anim) {
		Toast.makeText(this,"动画开始中...",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onAnimationEnd(Animation anim) {
		Toast.makeText(this,"动画结束中...",Toast.LENGTH_SHORT).show();
		if(isHas){
			anima_lay4.removeView(anima_4img);
			isHas = false;
		}
	}
	@Override
	public void onAnimationRepeat(Animation anim) {
		Toast.makeText(this,"动画重复中...",Toast.LENGTH_SHORT).show();
	}
}