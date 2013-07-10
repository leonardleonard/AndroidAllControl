package lmc.lonely.thread;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import lmc.lonely.Main;
import lmc.lonely.R;
public class ThAjaxCheck extends Activity implements OnClickListener {
	private String res = "";
	private Handler hdler = null;
	private Runnable succ = new Runnable() {
		@Override
		public void run() {
			Toast.makeText(ThAjaxCheck.this,res,Toast.LENGTH_SHORT).show();
			ThAjaxCheck.this.startActivity(new Intent(ThAjaxCheck.this,Main.class));
			ThAjaxCheck.this.finish();
		}
	};
	private EditText ajchk_user = null;
	private EditText ajchk_pwd = null;
	private Button ajchk_enter = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_ajchk);
        ajchk_user = (EditText) super.findViewById(R.id.ajchk_user);
        ajchk_pwd = (EditText) super.findViewById(R.id.ajchk_pwd);
        ajchk_enter = (Button) super.findViewById(R.id.ajchk_enter);
        ajchk_enter.setOnClickListener(this);
        hdler = new Handler();
    }
    @Override
	public void onClick(View v) {
		if(v.getId()==R.id.ajchk_enter){
			String user = ajchk_user.getText().toString().trim();
	    	String pwd = ajchk_pwd.getText().toString().trim();
	    	if(user.equals("")){
	    		ajchk_user.setError("请输入用户名");
	    		return;
	    	}
	    	if(pwd.equals("")){
	    		ajchk_pwd.setError("请输入密码");
	    		return;
	    	}
			new Thread() {
				@Override
				public void run() {
					res = "登录成功";
				}
			}.start();
			final ProgressDialog prog = new ProgressDialog(this);
			prog.setTitle("登录验证中...");
			prog.setIcon(R.drawable.ico_logo);
	    	prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	    	prog.setMax(100);
			prog.setProgress(1);
			prog.setButton("后台",new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dia, int which) {
					prog.dismiss();
				}
			});
			prog.onStart();
			prog.show();
			new Thread(){
				@Override
				public void run() {
					try{
						for(int i=0;i<100;i++){
							Thread.sleep(20);
							prog.incrementProgressBy(1);
						}
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						prog.dismiss();
					}
					hdler.post(succ);
				}
			}.start();
		}
	}
}