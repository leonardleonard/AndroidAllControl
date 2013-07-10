package lmc.lonely.lay;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import lmc.lonely.R;
public class LayLine1 extends Activity implements OnClickListener {
	private ImageButton line_next = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.lay_line);
        line_next = (ImageButton) super.findViewById(R.id.line_next);
        line_next.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.line_next){
			this.startActivity(new Intent(this,LayLine2.class));
		}
	}
}