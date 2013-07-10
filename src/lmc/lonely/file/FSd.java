package lmc.lonely.file;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.lonely.SysConts;
import lmc.utils.OtherUtils;
public class FSd extends Activity implements OnClickListener {
	private String fName = null;
	private Button sd_create = null;
	private Button sd_read = null;
	private TextView sd_res = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_sd);
        sd_create = (Button) super.findViewById(R.id.sd_create);
        sd_read = (Button) super.findViewById(R.id.sd_read);
        sd_res = (TextView) super.findViewById(R.id.sd_res);
        sd_create.setOnClickListener(this);
        sd_read.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.sd_create){
			try{
				fName = SysArgs.getAppHome()+OtherUtils.getLsh()+".txt";
				File oFile = new File(fName);
				if(!oFile.exists()){
					oFile.createNewFile();
				}
				PrintStream ps = new PrintStream(new FileOutputStream(oFile));
				ps.println(SysConts.datao[0]);
				ps.println(SysConts.datao[1]);
				ps.println(SysConts.datao[2]);
    			ps.close();
    			sd_res.setText("创建本地文件成功\n存于:"+fName);
			}catch(Exception e){
				sd_res.setText("创建本地文件失败");
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.sd_read){
			try{
				File iFile = new File(fName);
				if(!iFile.exists()){
					sd_res.setText("本地文件不存在");
					return;
				}
				FileInputStream fis = new FileInputStream(iFile);
				Scanner sc = new Scanner(fis);
				StringBuffer sb = new StringBuffer();
		        while(sc.hasNext()){
		        	sb.append("--"+sc.next()+"\n");
		        }
		        sc.close();
		        fis.close();
		        sd_res.setText(sb.deleteCharAt(sb.length()-1).toString());
			}catch(Exception e){
				sd_res.setText("读取本地文件失败!请确认本地文件已创建");
				e.printStackTrace();
			}
		}
	}
}