package lmc.lonely.thread;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import lmc.entity.Book;
import lmc.lonely.AppMgr;
import lmc.lonely.R;
import lmc.lonely.SysConts;
public class ThDMain extends Activity implements OnClickListener {
	private Button data_cm = null;
	private TextView data_sys = null;
	private TextView data_cmres = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_data);
        AppMgr app = (AppMgr) super.getApplication();
        data_cm = (Button) super.findViewById(R.id.data_cm);
        data_sys = (TextView) super.findViewById(R.id.data_sys);
        data_cmres = (TextView) super.findViewById(R.id.data_cmres);
        data_cm.setOnClickListener(this);
        data_sys.setText("全局参数:"+app.getAppName());
        ClipboardManager cbm = (ClipboardManager) super.getSystemService(Context.CLIPBOARD_SERVICE);
        String obj = cbm.getText().toString();
    	try{
    		if(obj!=null){
                byte[]data = Base64.decode(obj,Base64.DEFAULT);
                ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
                Book bk = (Book) ois.readObject();
                data_cmres.setText("读取剪切板中对象\n书名:"+bk.getBookName()+"\n价格:"+bk.getBookPrice());
                ois.close();
    		}
		}catch(Exception e){
			e.printStackTrace();
		}
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.data_cm){
			ClipboardManager cbm = (ClipboardManager) super.getSystemService(Context.CLIPBOARD_SERVICE);
			cbm.setText(SysConts.owner);
			this.startActivity(new Intent(this,ThDSon.class));
		}
	}
}