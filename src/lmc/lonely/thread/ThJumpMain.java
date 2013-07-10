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
public class ThJumpMain extends Activity implements OnClickListener {
	private Button jump_sing = null;
	private Button jump_doub = null;
	private Button jump_dia = null;
	private TextView jump_res = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_jump);
        jump_sing = (Button) super.findViewById(R.id.jump_sing);
        jump_doub = (Button) super.findViewById(R.id.jump_doub);
        jump_dia = (Button) super.findViewById(R.id.jump_dia);
        jump_res = (TextView) super.findViewById(R.id.jump_res);
        jump_sing.setOnClickListener(this);
        jump_doub.setOnClickListener(this);
        jump_dia.setOnClickListener(this);
    }
    @Override
	protected void onActivityResult(int req, int res, Intent data) {
    	if(res==RESULT_OK){
    		StringBuffer sb = new StringBuffer("双向跳转返回结果\n");
    		sb.append("请求码:"+req+"\n");
    		sb.append("结果返回码:"+res+"\n");
    		sb.append(data.getStringExtra("return"));
			jump_res.setText(sb.toString());
    	}else if(res==RESULT_CANCELED){
    		StringBuffer sb = new StringBuffer("双向跳转操作取消\n");
    		sb.append("结果返回码:"+res+"\n");
    		sb.append("请求码:"+req);
    		jump_res.setText(sb.toString());
    	}
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.jump_sing){
			Intent it = new Intent(this,ThJumpSonO.class);
			it.putExtra("name",SysConts.owner);
			it.putExtra("enable",false);
			this.startActivity(it);
		}else if(v.getId()==R.id.jump_doub){
			Intent it = new Intent(this,ThJumpSonO.class);
			it.putExtra("name",SysConts.owner);
			it.putExtra("enable",true);
			this.startActivityForResult(it,10000);
		}else if(v.getId()==R.id.jump_dia){
			this.startActivity(new Intent(this,ThJumpSonT.class));
		}
	}
}