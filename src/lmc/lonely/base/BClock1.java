package lmc.lonely.base;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker.OnTimeChangedListener;
import lmc.lonely.R;
public class BClock1 extends Activity implements OnClickListener {
	private Chronometer clock_chr = null;
	private Button clock_start = null;
	private Button clock_stop = null;
	private Button clock_again = null;
	private Button clock_format = null;
	private TextView clock_msg = null;
	private DatePicker clock_date = null;
	private TimePicker clock_time = null;
	private Button clock_ple = null;
	private Button clock_cal = null;
	private Button clock_dia = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_clock);
        clock_chr = (Chronometer) super.findViewById(R.id.clock_chr);
        clock_start = (Button) super.findViewById(R.id.clock_start);
        clock_stop = (Button) super.findViewById(R.id.clock_stop);
        clock_again = (Button) super.findViewById(R.id.clock_again);
        clock_format = (Button) super.findViewById(R.id.clock_format);
        clock_msg = (TextView) super.findViewById(R.id.clock_msg);
        clock_date = (DatePicker) super.findViewById(R.id.clock_date);
        clock_time = (TimePicker) super.findViewById(R.id.clock_time);
        clock_ple = (Button) super.findViewById(R.id.clock_please);
        clock_cal = (Button) super.findViewById(R.id.clock_cal);
        clock_dia = (Button) super.findViewById(R.id.clock_dia);
        clock_chr.setBase(SystemClock.elapsedRealtime());
        clock_start.setOnClickListener(this);
        clock_stop.setOnClickListener(this);
        clock_again.setOnClickListener(this);
        clock_format.setOnClickListener(this);
        clock_date.init(clock_date.getYear(),clock_date.getMonth(),clock_date.getDayOfMonth(),new OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker v, int year, int month, int day) {
				BClock1.this.setTime();
			}
		});
        clock_time.setIs24HourView(true);
        clock_time.setOnTimeChangedListener(new OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker v, int hour, int minute) {
				BClock1.this.setTime();
			}
		});
        this.setTime();
        clock_ple.setOnClickListener(this);
        clock_cal.setOnClickListener(this);
        clock_dia.setOnClickListener(this);
    }
	@Override
	protected void onActivityResult(int reqCode, int resCode, Intent data) {
		if(reqCode==2){
			if(resCode==RESULT_OK){
				String start = data.getCharSequenceExtra("start").toString();
				String end = data.getCharSequenceExtra("end").toString();
				clock_msg.setText("开始时间:"+start+" 结束时间:"+end);
			}
		}
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.clock_start:clock_chr.start();break;
			case R.id.clock_stop:clock_chr.stop();break;
			case R.id.clock_again:
				clock_chr.stop();
				clock_chr.setBase(SystemClock.elapsedRealtime());
				break;
			case R.id.clock_format:clock_chr.setFormat("格式化:%s");break;
			case R.id.clock_please:this.startActivityForResult(new Intent(this,BClockPlease.class),2);break;
			case R.id.clock_cal:this.startActivity(new Intent(this,BClock2.class));break;
			case R.id.clock_dia:
				new DatePickerDialog(this,new OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int month, int day) {
						clock_msg.setText("设置时间:"+year+"-"+(month+1)+"-"+day);
					}
		        },2013,0,27).show();
				break;
			default:break;
		}
	}
	private void setTime(){
    	clock_msg.setText("当前时刻:"+clock_date.getYear()+"-"+(clock_date.getMonth()+1)+"-"+
    		clock_date.getDayOfMonth()+" "+clock_time.getCurrentHour()+":"+clock_time.getCurrentMinute());
    }
}