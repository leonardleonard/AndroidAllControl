package lmc.lonely.thread;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import lmc.lonely.R;
public class ThNhd extends Activity implements Runnable {
	private int[]colors = new int[]{0xFFFF0000,0xFF00FF00,0xFF0000FF,0xFFFF00FF,0xFF00FFFF};
	private int[]pointers = new int[]{1,2,3,4,0};
	private View[]vs = null;
	private int index = 0;
	private Handler hdler = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_nhd);
        vs = new View[]{
    		super.findViewById(R.id.nhd_div5),
    		super.findViewById(R.id.nhd_div4),
    		super.findViewById(R.id.nhd_div3),
    		super.findViewById(R.id.nhd_div2),
    		super.findViewById(R.id.nhd_div1)
        };
        hdler = new Handler();
        hdler.postDelayed(this,300);
    }
	@Override
	public void run() {
		int next = index;
		for(int i=vs.length-1;i>=0;i--){
			next = pointers[next];
			vs[i].setBackgroundColor(colors[next]);
		}
		index++;
		if(index==5){
			index = 0;
		}
		hdler.postDelayed(this,300);
	}
}