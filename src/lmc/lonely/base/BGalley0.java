package lmc.lonely.base;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import lmc.lonely.R;
public class BGalley0 extends Activity implements OnClickListener {
	public static int[]pics = new int[]{
	    R.drawable.icob_gal01,R.drawable.icob_gal02,R.drawable.icob_gal03,R.drawable.icob_gal04,
	    R.drawable.icob_gal05,R.drawable.icob_gal06,R.drawable.icob_gal07,R.drawable.icob_gal08,
		R.drawable.icob_gal09,R.drawable.icob_gal10,R.drawable.icob_gal11,R.drawable.icob_gal12,
	};
	private Button gal_item1 = null;
	private Button gal_item2 = null;
	private Button gal_item3 = null;
	private Button gal_item4 = null;
	private Button gal_item5 = null;
	private Button gal_item6 = null;
	private Button gal_item7 = null;
	private Button gal_item8 = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal);
        gal_item1 = (Button) super.findViewById(R.id.gal_item1);
        gal_item2 = (Button) super.findViewById(R.id.gal_item2);
        gal_item3 = (Button) super.findViewById(R.id.gal_item3);
        gal_item4 = (Button) super.findViewById(R.id.gal_item4);
        gal_item5 = (Button) super.findViewById(R.id.gal_item5);
        gal_item6 = (Button) super.findViewById(R.id.gal_item6);
        gal_item7 = (Button) super.findViewById(R.id.gal_item7);
        gal_item8 = (Button) super.findViewById(R.id.gal_item8);
        gal_item1.setOnClickListener(this);
        gal_item2.setOnClickListener(this);
        gal_item3.setOnClickListener(this);
        gal_item4.setOnClickListener(this);
        gal_item5.setOnClickListener(this);
        gal_item6.setOnClickListener(this);
        gal_item7.setOnClickListener(this);
        gal_item8.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.gal_item1){
			this.startActivity(new Intent(this,BGalley1.class));
		}else if(v.getId()==R.id.gal_item2){
			this.startActivity(new Intent(this,BGalley2.class));
		}else if(v.getId()==R.id.gal_item3){
			this.startActivity(new Intent(this,BGalley3.class));
		}else if(v.getId()==R.id.gal_item4){
			this.startActivity(new Intent(this,BGalley4.class));
		}else if(v.getId()==R.id.gal_item5){
			this.startActivity(new Intent(this,BGalley5.class));
		}else if(v.getId()==R.id.gal_item6){
			this.startActivity(new Intent(this,BGalley6.class));
		}else if(v.getId()==R.id.gal_item7){
			this.startActivity(new Intent(this,BGalley7.class));
		}else if(v.getId()==R.id.gal_item8){
			this.startActivity(new Intent(this,BGalley8.class));
		}
	}
}