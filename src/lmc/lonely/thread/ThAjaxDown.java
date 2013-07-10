package lmc.lonely.thread;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import lmc.lonely.R;
public class ThAjaxDown extends Activity implements OnClickListener {
	private Button ajax_down = null;
	private ProgressBar ajax_prog = null;
	private int precent = 0;
	private ProgHandler hdler = null;
	private Runnable prog = new Runnable() {
		@Override
		public void run() {
			try{
				precent += 5;
				Message msg = hdler.obtainMessage();
				msg.arg1 = precent;
				Thread.sleep(1000);
				hdler.sendMessage(msg);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_ajax);
        ajax_down = (Button) super.findViewById(R.id.ajax_down);
        ajax_prog = (ProgressBar) super.findViewById(R.id.ajax_prog);
		ajax_down.setOnClickListener(this);
		HandlerThread hthread = new HandlerThread("ProgThread");
		hthread.start();
		hdler = new ProgHandler(hthread.getLooper());
    }
    @Override
	public void onClick(View v) {
		if(v.getId()==R.id.ajax_down){
			precent = 0;
			ajax_prog.setVisibility(ProgressBar.VISIBLE);
			hdler.post(prog);
		}
	}
    private class ProgHandler extends Handler {
		public ProgHandler(Looper looper) {
			super(looper);
		}
		@Override
		public void handleMessage(Message msg) {
			ajax_prog.setProgress(msg.arg1);
			hdler.post(prog);
			if(msg.arg1>=99){
				hdler.removeCallbacks(prog);
			}
		}
	}
}