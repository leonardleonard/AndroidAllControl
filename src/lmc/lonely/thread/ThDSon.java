package lmc.lonely.thread;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
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
import lmc.lonely.R;
public class ThDSon extends Activity implements OnClickListener {
	private Button data_cmret = null;
	private TextView data_res = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thread_data2);
        data_cmret = (Button) super.findViewById(R.id.data_cmret);
        data_res = (TextView) super.findViewById(R.id.data_res);
        data_cmret.setOnClickListener(this);
        ClipboardManager cbm = (ClipboardManager) super.getSystemService(Context.CLIPBOARD_SERVICE);
        data_res.setText("读取剪切板中参数:"+cbm.getText());
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.data_cmret){
			try{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(new Book("《平凡的世界》",99.99f));
				String data = Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT);
				oos.close();
				ClipboardManager cbm = (ClipboardManager) super.getSystemService(Context.CLIPBOARD_SERVICE);
				cbm.setText(data);
				this.startActivity(new Intent(this,ThDMain.class));
				this.finish();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}