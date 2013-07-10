package lmc.lonely.file;
import android.R.color;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import lmc.lonely.AppMgr;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.lonely.Wel;
import lmc.view.ColorPicker;
public class FProp extends Activity implements OnClickListener {
	private int bg = 0xFFFFCCFF;
	private EditText prop_url = null;
	private EditText prop_home = null;
	private TextView prop_bg = null;
	private RadioGroup prop_mode = null;
	private CheckBox prop_show = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_prop);
        super.findViewById(R.id.prop_lay).setBackgroundColor(SysArgs.getBgColor());
        ((AppMgr) super.getApplication()).add(this);
        String title = super.getIntent().getStringExtra("title");
        if(title!=null){
        	super.setTitle(title);
        }
        prop_url = (EditText) super.findViewById(R.id.prop_url);
        prop_home = (EditText) super.findViewById(R.id.prop_home);
        prop_bg = (TextView) super.findViewById(R.id.prop_bg);
        prop_mode = (RadioGroup) super.findViewById(R.id.prop_mode);
        prop_show = (CheckBox) super.findViewById(R.id.prop_show);
        prop_url.setText(SysArgs.getUrlheader());
        prop_home.setText(SysArgs.getAppHome());
        bg = SysArgs.getBgColor();
        prop_bg.setBackgroundColor(bg);
        prop_bg.setOnClickListener(this);
        prop_show.setChecked(SysArgs.isShow());
        prop_show.setOnClickListener(this);
    }
    @Override
    public void onBackPressed() {
    	Dialog dia = new AlertDialog.Builder(this).setIcon(R.drawable.ico_logo).
    		setTitle("保存设置").setMessage("选择保存操作?").
    	    setPositiveButton("设置",new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dia, int which) {
    				SysArgs.setUrlHeader(prop_url.getText().toString());
    				SysArgs.setAppHome(prop_home.getText().toString());
    				SysArgs.setBgColor(bg);
    				SysArgs.setMode((prop_mode.getCheckedRadioButtonId()==R.id.prop_mdef)?0:1);
    				SysArgs.setShow(prop_show.isChecked());
    				Toast.makeText(FProp.this,SysArgs.save(FProp.this)?"保存设置成功":"保存设置失败",Toast.LENGTH_SHORT).show();
    				FProp.this.startActivity(new Intent(FProp.this,Wel.class));
    				((AppMgr) FProp.this.getApplication()).finish();
    			}
    		}).setNeutralButton("默认",new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dia, int which) {
					SysArgs.init();
					Toast.makeText(FProp.this,SysArgs.save(FProp.this)?"恢复默认设置成功":"恢复默认设置失败",Toast.LENGTH_SHORT).show();
					FProp.this.startActivity(new Intent(FProp.this,Wel.class));
					((AppMgr) FProp.this.getApplication()).finish();
				}
    		}).setNegativeButton("取消",new DialogInterface.OnClickListener() {
    			@Override
    			public void onClick(DialogInterface dia, int which) {
    				FProp.this.startActivity(new Intent(FProp.this,Wel.class));
    				((AppMgr) FProp.this.getApplication()).finish();
    				dia.dismiss();
    			}
    		}).create();
    	dia.show();
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.prop_bg){
			ColorPicker colDia = new ColorPicker(this,color.white,"设置背景色",new ColorPicker.OnColorChangedListener() {
				@Override
				public void colorChanged(int color) {
					bg = color;
					prop_bg.setBackgroundColor(bg);
				}
			});
			colDia.show();
		}
	}
}