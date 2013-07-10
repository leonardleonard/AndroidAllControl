package lmc.view;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
public class BCalPicker extends View {
	private final int bg = 0xFFCCFFFF;
	private int padding_left = 20;
	private int padding_top = 100;
	private int padding_row = 0;
	private int padding_cell = 0;
	private Calendar cal = null;
	private Calendar today = null;
	private int year = -1;
	private int month = -1;
	private int day = -1;
	private Paint paint = null;
	private Paint currPaint = null;
	private GestureDetector touch = null;
	private List<DateRect>rects = null;
	public BCalPicker(final Context con) {
		super(con);
		super.setFocusable(true);
		super.setFocusableInTouchMode(true);
		super.setBackgroundColor(bg);
		cal = Calendar.getInstance();
		today = (Calendar) cal.clone();
		touch = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float vX, float vY) {
				if(e1.getX()>e2.getX()){
					cal.add(Calendar.MONTH,1);
					BCalPicker.this.invalidate();
				}
				if(e1.getX()<e2.getX()){
					cal.add(Calendar.MONTH,-1);
					BCalPicker.this.invalidate();
				}
				return true;
			}
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				day = BCalPicker.this.getDay(e.getX(),e.getY());
				if(day!=-1){
					Toast.makeText(con,"日期:"+year+"-"+month+"-"+day+"\n可添加其他处理的代码",Toast.LENGTH_SHORT).show();
				}
				return true;
			}
		});
	}
	@Override
	protected void onDraw(Canvas can) {
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		currPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		currPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		currPaint.setColor(Color.RED);
		currPaint.setTextSize(20f);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		paint.setColor(Color.BLACK);
		paint.setTextSize(20f);
		can.drawText(year+"年"+(month+1)+"月",(padding_cell*7)/2-35,50,paint);
		String[]days = new String[]{"一","二","三","四","五","六","日"};
		for(int i=0;i<days.length;i++){
			can.drawText(days[i],padding_left+i*padding_cell,padding_top,paint);
		}
		cal.set(Calendar.DATE,1);
		int curMonth = cal.get(Calendar.MONTH);
		int y = 1;
		rects = new ArrayList<DateRect>();
		while(cal.get(Calendar.MONTH)==curMonth){
			int day = cal.get(Calendar.DATE);
			int x = cal.get(Calendar.DAY_OF_WEEK);
			x = (x==1)?7:(x-1);
			int dx = padding_left+(x-1)*padding_cell;
			int dy = padding_top+y*padding_row;
			rects.add(new DateRect(dx,dy,day));
			if(cal.equals(today)){
				can.drawText(String.valueOf(day),dx,dy,currPaint);
			}else{
				can.drawText(String.valueOf(day),dx,dy,paint);
			}
			if(x==7){
				y=y+1;	
			}
			cal.add(Calendar.DATE,1);
		}
		cal.add(Calendar.DATE,-1);
	}
	@Override
	protected void onSizeChanged(int w, int h, int ow, int oh) {
		super.onSizeChanged(w, h, ow, oh);
		padding_cell = (w-padding_left)/7;
		padding_row = (h-padding_top)/7;
	}
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		 touch.onTouchEvent(e);
		 return true;
	}
	private int getDay(float x,float y){
		for(DateRect rect:rects){
			if(rect.isSelected(x,y)){
				return rect.getDay();
			}
		}
		return -1;
	}
	public static class DateRect {
		private int x = -1;
		private int y = -1;
		private int day = -1;
		public static int size = 20;
		public static int diff = 10;
		public DateRect(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getX() {
			return x;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getY() {
			return y;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public int getDay() {
			return day;
		}
		public boolean isSelected(float selX,float selY){
			if((selX>=x-diff&&selX<=x+size+diff)&&(selY>=y-size-diff&&selY<=y+diff)){
				return true;
			}
			return false;
		}
	}
}