package lmc.lonely.base;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import lmc.lonely.R;
public class BTabHost0 extends Activity implements OnClickListener {
	private Button tabh_item1 = null;
	private Button tabh_item2 = null;
	private Button tabh_item3 = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_tabh);
        tabh_item1 = (Button) super.findViewById(R.id.tabh_item1);
        tabh_item2 = (Button) super.findViewById(R.id.tabh_item2);
        tabh_item3 = (Button) super.findViewById(R.id.tabh_item3);
        tabh_item1.setOnClickListener(this);
        tabh_item2.setOnClickListener(this);
        tabh_item3.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.tabh_item1){
			this.startActivity(new Intent(this,BTabHost1.class));
		}else if(v.getId()==R.id.tabh_item2){
			this.startActivity(new Intent(this,BTabHost2.class));
		}else if(v.getId()==R.id.tabh_item3){
			this.startActivity(new Intent(this,BTabHost3.class));
		}
	}
}