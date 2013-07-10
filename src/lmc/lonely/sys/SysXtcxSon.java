package lmc.lonely.sys;
import lmc.lonely.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
public class SysXtcxSon extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.icol_abs);
        super.setContentView(iv);
    }
}