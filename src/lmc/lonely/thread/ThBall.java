package lmc.lonely.thread;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import lmc.lonely.R;
import lmc.utils.OtherUtils;
import lmc.view.ThBallView;
public class ThBall extends Activity {
	private static final int flag = 0x01;
	private ThBallView view = null;
	private Handler hdler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch(msg.what){
				case flag:view.invalidate();break;
				default:break;
			}
		}
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.getWindow().setBackgroundDrawableResource(R.drawable.activitys);
        view = new ThBallView(this,OtherUtils.getColor(103,255,233));
        super.setContentView(view);
		new Thread(new ViewThread()).start();
    }
    class ViewThread implements Runnable {
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()){
				try{
					Message msg = new Message();
					msg.what = flag;
					hdler.sendMessage(msg);
					Thread.sleep(100);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}