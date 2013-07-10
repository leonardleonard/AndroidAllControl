package lmc.lonely.lay;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import lmc.lonely.R;
public class LayRelat2 extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.lay_relat2);
        RelativeLayout lay = (RelativeLayout) super.findViewById(R.id.relat_lay2);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.FILL_PARENT);
        params.addRule(RelativeLayout.BELOW,R.id.relat_ltop);
        params.addRule(RelativeLayout.RIGHT_OF,R.id.relat_right);
        EditText et = new EditText(this);
        et.setText("³ÌÐòÉú³É");
        lay.addView(et,params);
	}
}