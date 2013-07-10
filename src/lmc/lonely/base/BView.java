package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import lmc.lonely.R;
public class BView extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_view);
    }
}