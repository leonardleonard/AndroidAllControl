package lmc.lonely.base;
import lmc.lonely.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
public class BTouch extends Activity {
	private TextView touch_msg = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_touch);
        touch_msg = (TextView) super.findViewById(R.id.touch_msg);
    }
	@Override
    public boolean onTouchEvent(MotionEvent e) {
    	float screenX = e.getRawX();
    	float screenY = e.getRawY();
    	float vX = e.getX();
    	float vY = e.getY();
    	switch(e.getAction()){
	    	case MotionEvent.ACTION_DOWN:touch_msg.setText("触摸屏幕:("+screenX+","+screenY+") ("+vX+","+vY+")");break;
	    	case MotionEvent.ACTION_MOVE:touch_msg.setText("触摸移动:("+screenX+","+screenY+") ("+vX+","+vY+")");break;
	    	case MotionEvent.ACTION_UP:touch_msg.setText("停止触摸:("+screenX+","+screenY+") ("+vX+","+vY+")");break;
    	}
    	StringBuffer sb = new StringBuffer();
    	int count = e.getPointerCount();
    	for(int i=0;i<count;i++){
    		sb.append("第"+(i+1)+"个触控点:"+e.getPointerId(i)+" ("+e.getX(i)+","+e.getY(i)+
    			")\n手指压力:"+e.getPressure(i)+"\n事件开始时间:"+e.getDownTime()+"\n事件结束时间:"+e.getEventTime()+
    			"\n事件耗时:"+(e.getEventTime()-e.getDownTime())+"毫秒");
    	}
    	sb.append("\n共计"+count+"个触控点");
    	Toast.makeText(this,sb.toString(),50).show();
    	return true;
    }
}