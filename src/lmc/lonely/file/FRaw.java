package lmc.lonely.file;
import java.io.InputStream;
import java.util.Scanner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import lmc.lonely.R;
public class FRaw extends Activity implements OnClickListener{
	private Button raw_read = null;
	private TextView raw_res = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_raw);
        raw_read = (Button) super.findViewById(R.id.raw_read);
        raw_res = (TextView) super.findViewById(R.id.raw_res);
        raw_read.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		try{
			InputStream is = super.getResources().openRawResource(R.raw.lmc);
			StringBuffer sb = new StringBuffer();
			Scanner sc = new Scanner(is);
			while(sc.hasNext()){
            	sb.append("--"+sc.next()+"\n");
            }
			sb.append("RAW文件应以UTF-8编码保存\n存于应用路径:/res/raw/lmc.txt");
			sc.close();
            is.close();
            raw_res.setText(sb.toString());
		}catch(Exception e){
			raw_res.setText("读取RAW文件失败");
			e.printStackTrace();
		}
	}
}