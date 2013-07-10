package lmc.lonely.base;
import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.view.ColorPicker;
public class BColor extends Activity {
	private EditText col_set = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_col);
        super.findViewById(R.id.col_lay).setBackgroundColor(SysArgs.getBgColor());
        col_set = (EditText) super.findViewById(R.id.col_set);
        col_set.setText(Integer.toHexString(SysArgs.getBgColor()).toUpperCase());
        col_set.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ColorPicker colDia = new ColorPicker(BColor.this,color.white,"…Ë÷√±≥æ∞…´",new ColorPicker.OnColorChangedListener() {
					@Override
					public void colorChanged(int color) {
						SysArgs.setBgColor(color);
						BColor.this.startActivity(new Intent(BColor.this,BColor.class));
						BColor.this.finish();
					}
				});
				colDia.show();
			}
		});
    }
}