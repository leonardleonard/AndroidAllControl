package lmc.lonely.base;
import java.util.List;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import lmc.lonely.R;
import lmc.lonely.SysConts;
public class BCheckBox1 extends Activity implements OnClickListener {
	private List<CheckBox>cbs = new ArrayList<CheckBox>();
	private Button box_con = null;
	private ImageButton box_next = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout lay = (LinearLayout) super.getLayoutInflater().inflate(R.layout.base_box,null);
        for(int i=0;i<SysConts.datao.length;i++){
        	CheckBox cb = (CheckBox) super.getLayoutInflater().inflate(R.layout.base_box1view,null);
        	cb.setText(SysConts.datao[i]);
        	cbs.add(cb);
        	lay.addView(cb,i);
        }
        super.setContentView(lay);
        box_con = (Button) super.findViewById(R.id.box_con);
        box_next = (ImageButton) super.findViewById(R.id.box_next);
        box_con.setOnClickListener(this);
        box_next.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.box_con){
			StringBuffer sb = new StringBuffer();
			for(CheckBox cb:cbs){
				sb.append(cb.getText().toString()+" ±»Ñ¡ÖÐ:"+cb.isChecked()+"\n");
			}
			Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.box_next){
			this.startActivity(new Intent(this,BCheckBox2.class));
		}
	}
}