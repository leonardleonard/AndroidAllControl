package lmc.lonely.lay;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import lmc.lonely.R;
public class LayRelat1 extends Activity implements OnClickListener {
	private ImageButton relat_next = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.lay_relat);
        relat_next = (ImageButton) super.findViewById(R.id.relat_next);
        relat_next.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.relat_next){
			this.startActivity(new Intent(this,LayRelat2.class));
		}
	}
}