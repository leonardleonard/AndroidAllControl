package lmc.view;
import lmc.utils.OtherUtils;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
public class BViewPaint extends View {
	public BViewPaint(Context con,AttributeSet attrs) {
		super(con, attrs);
	}
	@Override
	protected void onDraw(Canvas can) {
		Paint p = new Paint();
		p.setColor(OtherUtils.getColor(60,135,113));
		p.setTextSize(18.0f);
		can.drawLine(60,210,200,250,p);
		can.drawText("自定义视图",10,210,p);
		can.drawText("上而求索",200,40,p);
		super.onDraw(can);
	}
}