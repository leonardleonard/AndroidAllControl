package lmc.lonely.thread;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import lmc.lonely.R;
public class ThFjxc extends Activity implements OnClickListener{
	private Button fjxc_start = null;
	private Button fjxc_end = null;
	private TextView fjxc_msg = null;
	private Handler hdler = null;
	private Runnable upd = new Runnable() {
		@Override
		public void run() {
			fjxc_msg.append("线程"+Thread.currentThread().getName()+"时间:"+System.currentTimeMillis()+"\n");
			hdler.postDelayed(upd,3000);
		}
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_fjxc);
        fjxc_start = (Button) super.findViewById(R.id.fjxc_start);
        fjxc_end = (Button) super.findViewById(R.id.fjxc_end);
        fjxc_msg = (TextView) super.findViewById(R.id.fjxc_msg);
		fjxc_start.setOnClickListener(this);
		fjxc_end.setOnClickListener(this);
		fjxc_msg.setMovementMethod(ScrollingMovementMethod.getInstance());
		hdler = new Handler();
    }
    @Override
	public void onClick(View v) {
		if(v.getId()==R.id.fjxc_start){
			hdler.post(upd);
		}else if(v.getId()==R.id.fjxc_end){
			hdler.removeCallbacks(upd);
		}
	}
}