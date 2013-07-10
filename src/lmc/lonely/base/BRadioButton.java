package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import lmc.lonely.R;
public class BRadioButton extends Activity {
	private RadioGroup radio_sex = null;
	private RadioButton radio_nan = null;
	private RadioButton radio_nv = null;
	private RadioButton radio_no = null;
	private RadioButton radio_cus = null;
	private TextView radio_res = null;
	private Button radio_chs = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_radio);
        radio_sex = (RadioGroup) super.findViewById(R.id.radio_sex);
        radio_nan = (RadioButton) super.findViewById(R.id.radio_nan);
        radio_nv = (RadioButton) super.findViewById(R.id.radio_nv);
        radio_no = (RadioButton) super.findViewById(R.id.radio_no);
        radio_cus = (RadioButton) super.findViewById(R.id.radio_cus);
        radio_res = (TextView) super.findViewById(R.id.radio_res);
        radio_chs = (Button) super.findViewById(R.id.radio_chs);
        radio_sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId==radio_nan.getId()){
					radio_res.setText("选中了:"+radio_nan.getText().toString());
				}else if(checkedId==radio_nv.getId()){
					radio_res.setText("选中了:"+radio_nv.getText().toString());
				}else if(checkedId==radio_no.getId()){
					radio_res.setText("选中了:"+radio_no.getText().toString());
				}else if(checkedId==radio_cus.getId()){
					radio_res.setText("选中了:"+radio_cus.getText().toString());
				}
			}
		});
        radio_cus.setButtonDrawable(R.drawable.icob_radio);
        int pLeft = super.getResources().getDrawable(R.drawable.icob_radio).getIntrinsicWidth()+5;
        radio_cus.setPadding(pLeft,0,0,0);
        radio_chs.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				StringBuffer sb = new StringBuffer();
				int len = radio_sex.getChildCount();
				for(int i=0;i<len;i++){
					RadioButton rad = (RadioButton) radio_sex.getChildAt(i);
					sb.append(rad.getText().toString()+" 被选中:"+rad.isChecked()+"\n");
				}
				sb.append("单选按钮个数:"+len);
				Toast.makeText(BRadioButton.this,sb.toString(),Toast.LENGTH_SHORT).show();
			}
		});
    }
}