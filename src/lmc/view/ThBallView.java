package lmc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
public class ThBallView extends View {
	private float x = 40;
	private boolean direct = false;
	private int color = 0xFF000000;
	public ThBallView(Context con, int color) {
		super(con);
		this.color = color;
	}
	@Override
	protected void onDraw(Canvas can) {
		super.onDraw(can);
		if(x==250){
			direct = true;
		}
		if(x==40){
			direct = false;
		}
		x = direct?x-10:x+10;
		Paint p = new Paint();
		p.setAntiAlias(true);
		p.setColor(color);
		can.drawCircle(x,40,40,p);
	}
}