package lmc.lonely.base;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import lmc.lonely.R;
public class BAnimation0 extends Activity implements OnClickListener {
	private Button anima_item1 = null;
	private Button anima_item2 = null;
	private Button anima_item3 = null;
	private Button anima_item4 = null;
	private Button anima_item5 = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_anima);
        anima_item1 = (Button) super.findViewById(R.id.anima_item1);
        anima_item2 = (Button) super.findViewById(R.id.anima_item2);
        anima_item3 = (Button) super.findViewById(R.id.anima_item3);
        anima_item4 = (Button) super.findViewById(R.id.anima_item4);
        anima_item5 = (Button) super.findViewById(R.id.anima_item5);
        anima_item1.setOnClickListener(this);
        anima_item2.setOnClickListener(this);
        anima_item3.setOnClickListener(this);
        anima_item4.setOnClickListener(this);
        anima_item5.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.anima_item1){
			this.startActivity(new Intent(this,BAnimation1.class));
		}else if(v.getId()==R.id.anima_item2){
			this.startActivity(new Intent(this,BAnimation2.class));
		}else if(v.getId()==R.id.anima_item3){
			this.startActivity(new Intent(this,BAnimation3.class));
		}else if(v.getId()==R.id.anima_item4){
			this.startActivity(new Intent(this,BAnimation4.class));
		}else if(v.getId()==R.id.anima_item5){
			this.startActivity(new Intent(this,BAnimation5.class));
		}
	}
}