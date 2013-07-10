package lmc.lonely.thread;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import lmc.lonely.R;
import lmc.lonely.SysConts;
public class ThJumpSonO extends Activity implements OnClickListener {
	private Button jump_doub2=null;
	private TextView jump_res2 = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_jump2);
        jump_doub2 = (Button) super.findViewById(R.id.jump_doub2);
        jump_res2 = (TextView) super.findViewById(R.id.jump_res2);
        String name = super.getIntent().getStringExtra("name");
        boolean enable = super.getIntent().getBooleanExtra("enable",false);
    	if(!enable){
        	jump_doub2.setEnabled(false);
        	jump_res2.setText("读取单向跳转参数\n开发者:"+name+"\n按钮是否可用:"+enable);
        }else{
        	jump_doub2.setEnabled(true);
        	jump_doub2.setOnClickListener(this);
        	jump_res2.setText("读取双向跳转参数\n开发者:"+name+"\n按钮是否可用:"+enable);
        }
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.jump_doub2){
			Intent it = super.getIntent();
			it.putExtra("return",SysConts.datao[2]);
			this.setResult(RESULT_OK,it);
			this.finish();
		}
	}
}