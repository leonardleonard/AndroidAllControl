package lmc.lonely.base;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import lmc.lonely.AppMgr;
import lmc.lonely.R;
public class BListView0 extends Activity implements OnClickListener {
	private Button list_item1 = null;
	private Button list_item2 = null;
	private Button list_item3 = null;
	private Button list_item4 = null;
	private Button list_item5 = null;
	private Button list_item6 = null;
	private Button list_item7 = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_list);
        ((AppMgr) super.getApplication()).add(this);
        list_item1 = (Button) super.findViewById(R.id.list_item1);
        list_item2 = (Button) super.findViewById(R.id.list_item2);
        list_item3 = (Button) super.findViewById(R.id.list_item3);
        list_item4 = (Button) super.findViewById(R.id.list_item4);
        list_item5 = (Button) super.findViewById(R.id.list_item5);
        list_item6 = (Button) super.findViewById(R.id.list_item6);
        list_item7 = (Button) super.findViewById(R.id.list_item7);
        list_item1.setOnClickListener(this);
        list_item2.setOnClickListener(this);
        list_item3.setOnClickListener(this);
        list_item4.setOnClickListener(this);
        list_item5.setOnClickListener(this);
        list_item6.setOnClickListener(this);
        list_item7.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.list_item1){
			this.startActivity(new Intent(this,BListView1.class));
		}else if(v.getId()==R.id.list_item2){
			this.startActivity(new Intent(this,BListView2.class));
		}else if(v.getId()==R.id.list_item3){
			this.startActivity(new Intent(this,BListView3.class));
		}else if(v.getId()==R.id.list_item4){
			this.startActivity(new Intent(this,BListView4.class));
		}else if(v.getId()==R.id.list_item5){
			this.startActivity(new Intent(this,BListView5.class));
		}else if(v.getId()==R.id.list_item6){
			this.startActivity(new Intent(this,BListView6.class));
		}else if(v.getId()==R.id.list_item7){
			this.startActivity(new Intent(this,BListView7.class));
		}
	}
}