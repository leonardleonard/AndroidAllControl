package lmc.lonely.base;
import java.util.Calendar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import lmc.lonely.R;
import lmc.utils.TimeUtils;
public class BClockPlease extends Activity implements OnClickListener {
	private DatePicker clock_cstart = null;
	private DatePicker clock_cstop = null;
	private Button clock_confirm = null;
	private Button clock_cancel = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        super.setContentView(R.layout.base_clockplease);
        super.getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,R.drawable.icob_clock);
        clock_cstart = (DatePicker) super.findViewById(R.id.clock_cstart);
		clock_cstop = (DatePicker) super.findViewById(R.id.clock_cstop);
		clock_confirm = (Button) super.findViewById(R.id.clock_confirm);
		clock_cancel = (Button) super.findViewById(R.id.clock_cancel);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,clock_cstop.getYear());
		cal.set(Calendar.MONTH,clock_cstop.getMonth());
		cal.set(Calendar.DATE,clock_cstop.getDayOfMonth());
		cal.add(Calendar.DATE,-7);
		clock_cstart.init(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE),null);	
		clock_confirm.setOnClickListener(this);
		clock_cancel.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.clock_confirm){
			String sd = TimeUtils.getStrFormat(clock_cstart.getYear(),clock_cstart.getMonth()+1,clock_cstart.getDayOfMonth());
			String ed = TimeUtils.getStrFormat(clock_cstop.getYear(),clock_cstop.getMonth()+1,clock_cstop.getDayOfMonth());
			Intent it = new Intent();
			it.putExtra("start",sd);
			it.putExtra("end",ed);
			this.setResult(RESULT_OK,it);
		}else if(v.getId()==R.id.clock_cancel){
			this.setResult(RESULT_CANCELED);
		}
		this.finish();
	}
}