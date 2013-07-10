package lmc.lonely.base;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import lmc.lonely.R;
public class BButton extends Activity implements OnClickListener,OnTouchListener,OnFocusChangeListener,OnKeyListener {
	private ToggleButton but_onoff = null;
	private Button but_clk = null;
	private Button but_tou = null;
	private Button but_focu = null;
	private Button but_key = null;
	private Button but_img = null;
	private TextView but_touch = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_but);
        but_onoff = (ToggleButton) super.findViewById(R.id.but_onoff);
        but_clk = (Button) super.findViewById(R.id.but_clk);
        but_tou = (Button) super.findViewById(R.id.but_tou);
        but_focu = (Button) super.findViewById(R.id.but_focu);
        but_key = (Button) super.findViewById(R.id.but_key);
        but_img = (Button) super.findViewById(R.id.but_img);
        but_touch = (TextView) super.findViewById(R.id.but_touch);
        final LinearLayout but_lay = (LinearLayout) super.findViewById(R.id.but_lay);
        
        but_onoff.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton v, boolean isChecked) {
				but_lay.setOrientation(isChecked?1:0);
			}
		});
        but_clk.setOnClickListener(this);
        but_tou.setOnTouchListener(this);
        but_focu.setOnFocusChangeListener(this);
        but_key.setOnKeyListener(this);
        ImageSpan is = new ImageSpan(BitmapFactory.decodeResource(this.getResources(),R.drawable.icob_but1),DynamicDrawableSpan.ALIGN_BOTTOM);
        SpannableString ss = new SpannableString("right");
        ss.setSpan(is,0,ss.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        but_img.append(ss);
        but_touch.setOnTouchListener(this);
    }
	@Override
	public void onClick(View v) {
		Toast.makeText(this,"点击事件\nID="+v.getId(),Toast.LENGTH_SHORT).show();
	}
	@Override
	public boolean onTouch(View v, MotionEvent e) {
		if(v.getId()==R.id.but_tou){
			if(e.getAction()==MotionEvent.ACTION_UP){
				Toast.makeText(this,"触屏事件(松开)\nID="+v.getId()+"\nAction="+e.getAction(),Toast.LENGTH_SHORT).show();
			}else if(e.getAction()==MotionEvent.ACTION_DOWN){
				Toast.makeText(this,"触屏事件(按下)\nID="+v.getId()+"\nAction="+e.getAction(),Toast.LENGTH_SHORT).show();
			}
		}else if(v.getId()==R.id.but_touch){
			but_touch.setText("x="+e.getX()+"\ny="+e.getY());
		}
		return false;
	}
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		Toast.makeText(this,"焦点事件\nID="+v.getId()+"\nHasFocus="+hasFocus,Toast.LENGTH_SHORT).show();
	}
	@Override
	public boolean onKey(View v, int keyCode, KeyEvent e) {
		if(e.getAction()==KeyEvent.ACTION_DOWN){
			Toast.makeText(this,"键盘事件\nID="+v.getId()+"\nAction="+e.getAction()+"\nKeyCode="+keyCode,Toast.LENGTH_SHORT).show();
		}
		return false;
	}
}