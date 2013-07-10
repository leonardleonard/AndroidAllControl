package lmc.lonely.base;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import lmc.lonely.R;
public class BAnimation2 extends Activity implements OnClickListener {
	private Button anima_2drdc = null;
	private Button anima_2sfxg = null;
	private Button anima_2xzxg = null;
	private Button anima_2ydxg = null;
	private Button anima_2hhdh = null;
	private Button anima_2lxdh = null;
	private ImageView anima_2img = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_anima2);
        anima_2drdc = (Button) super.findViewById(R.id.anima_2drdc);
        anima_2sfxg = (Button) super.findViewById(R.id.anima_2sfxg);
        anima_2xzxg = (Button) super.findViewById(R.id.anima_2xzxg);
        anima_2ydxg = (Button) super.findViewById(R.id.anima_2ydxg);
        anima_2hhdh = (Button) super.findViewById(R.id.anima_2hhdh);
        anima_2lxdh = (Button) super.findViewById(R.id.anima_2lxdh);
        anima_2img = (ImageView) super.findViewById(R.id.anima_2img);
        anima_2drdc.setOnClickListener(this);
        anima_2sfxg.setOnClickListener(this);
        anima_2xzxg.setOnClickListener(this);
        anima_2ydxg.setOnClickListener(this);
        anima_2hhdh.setOnClickListener(this);
        anima_2lxdh.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.anima_2drdc){
			anima_2img.startAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_anima_alpha));
		}else if(v.getId()==R.id.anima_2sfxg){
			anima_2img.startAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_anima_scale));
		}else if(v.getId()==R.id.anima_2xzxg){
			anima_2img.startAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_anima_rotate));
		}else if(v.getId()==R.id.anima_2ydxg){
			anima_2img.startAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_anima_trans));
		}else if(v.getId()==R.id.anima_2hhdh){
			anima_2img.startAnimation(AnimationUtils.loadAnimation(this,R.anim.ani_anima_comb));
		}else if(v.getId()==R.id.anima_2lxdh){
			anima_2img.setBackgroundResource(R.drawable.icob_anima_2run);
			AnimationDrawable draw = (AnimationDrawable) anima_2img.getBackground();
			draw.start();
		}
	}
}