package lmc.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
public class ColorPicker extends Dialog {
	private Context con = null;
	private String title = "";
	private int initColor = -1;
    private OnColorChangedListener listener = null;
    public ColorPicker(Context con, int initColor, String title, OnColorChangedListener listener) {
        super(con);
        this.con = con;
        this.listener = listener;
        this.initColor = initColor;
        this.title = title;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(title);
        int wid = (int) (super.getWindow().getWindowManager().getDefaultDisplay().getWidth()*0.7f);
		int hei = (int) (super.getWindow().getWindowManager().getDefaultDisplay().getHeight()*0.5f);
		super.setContentView(new ColorPickerView(con,wid,hei));
    }
    public interface OnColorChangedListener {
        void colorChanged(int color);
    }
    private class ColorPickerView extends View {
    	private int hei = 0;
    	private int wid = 0;
    	//画笔:渐变色环h,中间圆y,分隔线x,渐变方块k
    	private Paint hPaint = null;
    	private Paint yPaint = null;
    	private Paint xPaint = null;
    	private Paint kPaint = null;
    	//渐变色环渐变图像,渐变方块渐变图像
    	private Shader hShd = null;
    	private Shader kShd = null;
    	//渐变方块坐标:左x,右x,上y,下y
    	private float kLeft = 0.0f;
    	private float kTop = 0.0f;
    	private float kRight = 0.0f;
    	private float kBottom = 0.0f;
    	//颜色:渐变色环,渐变方块
    	private final int[]hCols;
    	private final int[]kCols;
    	//色环半径,中心圆半径
    	private float hR = 0.0f;
    	private float yR = 0.0f;
    	//是否在渐变环上,是否在渐变方块上,是否高亮,是否微亮
    	private boolean isInH = true;
    	private boolean isInK = false;
    	private boolean isGLig = false;
    	private boolean isHLig = false;
		public ColorPickerView(Context con, int wid, int hei) {
			super(con);
			this.hei = hei-36;
			this.wid = wid;
			this.setMinimumHeight(hei-36);
			this.setMinimumWidth(wid);
			//色环参数
	    	hCols = new int[]{0xFFFF0000,0xFFFF00FF,0xFF0000FF,0xFF00FFFF,0xFF00FF00,0xFFFFFF00,0xFFFF0000};
	    	hShd = new SweepGradient(0,0,hCols,null);
            hPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            hPaint.setShader(hShd);
            hPaint.setStyle(Paint.Style.STROKE);
            hPaint.setStrokeWidth(50);
            hR = wid/2*0.7f-hPaint.getStrokeWidth()*0.5f;
            //中心圆参数
            yPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            yPaint.setColor(initColor);
            yPaint.setStrokeWidth(5);
            yR = (hR-hPaint.getStrokeWidth()/2)*0.7f;
            //边框线参数
            xPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            xPaint.setColor(Color.parseColor("#72A1D1"));
            xPaint.setStrokeWidth(4);
            //渐变方块参数
            kCols = new int[]{0xFF000000,yPaint.getColor(),0xFFFFFFFF};
            kPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            kPaint.setStrokeWidth(5);
            kLeft = -hR-hPaint.getStrokeWidth()*0.5f;
            kTop = hR+hPaint.getStrokeWidth()*0.5f+xPaint.getStrokeMiter()*0.5f+15;
            kRight = hR+hPaint.getStrokeWidth()*0.5f;
            kBottom = kTop+50;
		}
//		@SuppressLint({"DrawAllocation","DrawAllocation"})
		@Override
		protected void onDraw(Canvas can) {
            can.translate(wid/2,hei/2-50);
            can.drawCircle(0,0,yR,yPaint);
            if(isGLig||isHLig){
                int c = yPaint.getColor();
                yPaint.setStyle(Paint.Style.STROKE);
                yPaint.setAlpha(isGLig?0xFF:0x90);
                can.drawCircle(0,0,yR+yPaint.getStrokeWidth(),yPaint);
                yPaint.setStyle(Paint.Style.FILL);
                yPaint.setColor(c);
            }
            can.drawOval(new RectF(-hR,-hR,hR,hR),hPaint);
            kCols[1] = isInH?yPaint.getColor():kCols[1];
            kShd = new LinearGradient(kLeft,0,kRight,0,kCols,null,Shader.TileMode.MIRROR);
            kPaint.setShader(kShd);
            can.drawRect(kLeft,kTop,kRight,kBottom,kPaint);
            float off = xPaint.getStrokeWidth()/2;
            can.drawLine(kLeft-off,kTop-off*2,kLeft-off,kBottom+off*2,xPaint);
            can.drawLine(kLeft-off*2,kTop-off,kRight+off*2,kTop-off,xPaint);
            can.drawLine(kRight+off,kTop-off*2,kRight+off,kBottom+off*2,xPaint);
            can.drawLine(kLeft-off*2,kBottom+ off,kRight+off*2,kBottom+off,xPaint);
			super.onDraw(can);
		}
		@Override
		public boolean onTouchEvent(MotionEvent e) {
			float x = e.getX()-wid/2;
            float y = e.getY()-hei/2+50;
            boolean inHCir = this.isInHCir(x,y,hR+hPaint.getStrokeWidth()/2,hR-hPaint.getStrokeWidth()/2);
            boolean inYCir = Math.PI*(x*x+y*y)<Math.PI*yR*yR?true:false;
            boolean inKCir = (x<=kRight&&x>=kLeft&&y<=kBottom&&y>=kTop)?true:false;
            switch(e.getAction()){
                case MotionEvent.ACTION_DOWN:
                	isInH = inHCir;
                	isInK = inKCir;
                	isGLig = inYCir;
                case MotionEvent.ACTION_MOVE:
                	if(isInH&&inHCir){
                		float angle = (float) Math.atan2(y,x);
                        float unit = (float) (angle/(2*Math.PI));
                        unit = unit<0?(unit+1):unit;
	               		yPaint.setColor(this.pHCol(hCols,unit));
                	}else if(isInK&&inKCir){
                		yPaint.setColor(this.pKCol(kCols,x));
                	}
                	if((isGLig&&inYCir)||(isHLig&&inYCir)){
                		isGLig = true;
                		isHLig = false;
                	}else if(isGLig||isHLig){
                		isGLig = false;
                		isHLig = true;
                	}else{
                		isGLig = false;
                		isHLig = false;
                	}
                	this.invalidate();
                	break;
                case MotionEvent.ACTION_UP:
                	if(isGLig&&inYCir){
                		if(listener!=null){
                			listener.colorChanged(yPaint.getColor());
                    		ColorPicker.this.dismiss();
                		}
                	}
                	isInH = isInH?false:true;
                	isInK = isInK?false:true;
                	isGLig = isGLig?false:true;
                	isHLig = isHLig?false:true;
                	this.invalidate();
                    break;
            }
            return true;
		}
		@Override
		protected void onMeasure(int mWid, int mHei) {
			super.onMeasure(wid, hei);
		}
		private boolean isInHCir(float x,float y,float out,float in){
			double oCir = Math.PI*out*out;
			double iCir = Math.PI*in*in;
			double fCir = Math.PI*(x*x+y*y);
			return (fCir<oCir&&fCir>iCir)?true:false;
		}
		private int pHCol(int[]cols,float unit){
            if(unit<=0){
                return cols[0];
            }
            if(unit>=1){
                return cols[cols.length-1];
            }
            float p = unit*(cols.length-1);
            int i = (int)p;
            p -= i;
            int c0 = cols[i];
            int c1 = cols[i+1];
            int a = this.ave(Color.alpha(c0),Color.alpha(c1),p);
            int r = this.ave(Color.red(c0),Color.red(c1),p);
            int g = this.ave(Color.green(c0),Color.green(c1),p);
            int b = this.ave(Color.blue(c0),Color.blue(c1),p);
            return Color.argb(a,r,g,b);
        }
		private int pKCol(int[]cols,float x){
			int a,r,g,b,c0,c1;
        	float p;
        	if(x<0){
        		c0 = cols[0]; 
        		c1 = cols[1];
        		p = (x+kRight)/kRight;
        	}else{
        		c0 = cols[1];
        		c1 = cols[2];
        		p = x/kRight;
        	}
        	a = this.ave(Color.alpha(c0),Color.alpha(c1),p);
        	r = this.ave(Color.red(c0),Color.red(c1),p);
        	g = this.ave(Color.green(c0),Color.green(c1),p);
        	b = this.ave(Color.blue(c0),Color.blue(c1),p);
        	return Color.argb(a,r,g,b);
		}
		private int ave(int s,int d,float p){
            return s+Math.round(p*(d-s));
        }
    }
}