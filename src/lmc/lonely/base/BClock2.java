package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import lmc.view.BCalPicker;
public class BClock2 extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BCalPicker cal = new BCalPicker(this);
        cal.requestFocus();
        super.setContentView(cal);
    }
}