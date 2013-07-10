package lmc.lonely.thread;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import lmc.lonely.R;
public class ThJumpSonT extends Activity implements OnClickListener {
	private TextView jump_diaret = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_jump3);
        jump_diaret = (TextView) super.findViewById(R.id.jump_diaret);
        jump_diaret.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.jump_diaret){
			this.onBackPressed();
			this.finish();
		}
	}
}