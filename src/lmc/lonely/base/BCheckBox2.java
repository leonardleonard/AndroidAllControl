package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import lmc.lonely.R;
public class BCheckBox2 extends Activity {
	private CheckBox box_new = null;
	private CheckBox box_no = null;
	private CheckBox box_ev = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_box2);
        box_new = (CheckBox) super.findViewById(R.id.box_new);
        box_no = (CheckBox) super.findViewById(R.id.box_no);
        box_ev = (CheckBox) super.findViewById(R.id.box_ev);
        box_new.setText("程序设置内容及被选");
        box_new.setChecked(true);
        box_no.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				box_no.setText(box_no.isChecked()?"执行选择":"取消被选");
			}
		});
        box_ev.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton v, boolean isChecked) {
				box_ev.setText(isChecked?"执行选择":"取消被选");
			}
		});
    }
}