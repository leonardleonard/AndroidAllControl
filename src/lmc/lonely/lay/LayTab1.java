package lmc.lonely.lay;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import lmc.lonely.R;
public class LayTab1 extends Activity implements OnClickListener {
	private ImageButton tab_next = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.lay_tab);
        tab_next = (ImageButton) super.findViewById(R.id.tab_next);
        tab_next.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tab_next){
			this.startActivity(new Intent(this,LayTab2.class));
		}
	}
}