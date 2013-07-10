package lmc.view;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;
public class FLkPicsView extends Gallery {
	private Camera cam = new Camera();
	private int mRotAng = 60;
	private int mZoom = -120;
	private int center = -1;
	public FLkPicsView(Context con) {
		super(con);
		this.setStaticTransformationsEnabled(true);
	}
	public FLkPicsView(Context con, AttributeSet attrs) {
        super(con, attrs);
        this.setStaticTransformationsEnabled(true);
	}
	public FLkPicsView(Context con, AttributeSet attrs, int style) {
        super(con, attrs, style);
        this.setStaticTransformationsEnabled(true);
	}
	public int getMaxRotationAngle() {
        return mRotAng;
	}
	public void setMaxRotationAngle(int mRotAng) {
		this.mRotAng = mRotAng;
	}
	public int getMaxZoom() {
	    return mZoom;
	}
	public void setMaxZoom(int mZoom) {
		this.mZoom = mZoom;
	}
	@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    	super.onSizeChanged(w, h, oldw, oldh);
    	center = this.getCenterOfCoverflow();
    }
    private int getCenterOfCoverflow() {
    	return (this.getWidth()-this.getPaddingLeft()-this.getPaddingRight())/2+this.getPaddingLeft();
    }
    private int getCenterOfView(View v) {
    	return v.getLeft()+v.getWidth()/2;
    }
    protected boolean getChildStaticTransformation(View v, Transformation trans) {
    	int chCter = this.getCenterOfView(v);
    	int rotAng = 0;
    	trans.clear();
    	trans.setTransformationType(Transformation.TYPE_MATRIX);
    	if(chCter==center){
    		this.transImgBmp((ImageView)v,trans,0);
    	}else{
    		rotAng= (int)(((float)(center-chCter)/v.getWidth())*mRotAng);
    		if(Math.abs(rotAng)>mRotAng){
    			rotAng = (rotAng<0)?-mRotAng:mRotAng;
    		}
    		this.transImgBmp((ImageView)v,trans,rotAng);
    	}
    	return true;
    }
    private void transImgBmp(ImageView iv, Transformation trans, int rota) {
    	cam.save();
    	Matrix max = trans.getMatrix();
	    int hei = iv.getLayoutParams().height;
	    int wid = iv.getLayoutParams().width;
	    int rot = Math.abs(rota);
	    cam.translate(0.0f,0.0f,100.0f);
	    if(rot<mRotAng){
            cam.translate(0.0f,0.0f,(float)(mZoom+(rot*1.5)));
         }
	    cam.rotateY(rota);
	    cam.getMatrix(max);
	    max.preTranslate(-(wid/2),-(hei/2));
	    max.postTranslate((wid/2),(hei/2));
	    cam.restore();
    }
}