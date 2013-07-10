package lmc.lonely.file;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.lonely.SysConts;
public class FOper extends Activity {
	private String fName = "lonely.txt";
	private TextView oper_msg = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_oper);
        oper_msg = (TextView) super.findViewById(R.id.oper_msg);
        StringBuffer sb = new StringBuffer();
        sb.append("是否安装SD卡:"+Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)+"\n");
        sb.append("SD卡绝对路径:"+Environment.getExternalStorageDirectory().getAbsolutePath()+"\n");
        File app = new File(SysArgs.getAppHome());
        sb.append("应用目录相对路径:"+app.getPath()+"\n");
        sb.append("应用目录绝对路径:"+app.getAbsolutePath()+"\n");
        sb.append("应用私有目录路径:"+super.getFilesDir()+"\n");
        try{
			FileOutputStream fos = super.openFileOutput(fName,Activity.MODE_APPEND);
			fos.write((System.currentTimeMillis()+SysConts.appName+"欢迎你\n").getBytes());
			fos.flush();
			fos.close();
			sb.append("创建应用文件成功,存于"+super.getFilesDir()+"/lonely.txt\n");
		}catch(Exception e){
			e.printStackTrace();
			sb.append("创建应用文件失败\n");
		}
        try{
			FileInputStream fis = super.openFileInput(fName);
			ByteArrayOutputStream bais = new ByteArrayOutputStream();
			byte[]data = new byte[1024];
			int len = 0;
			while((len=fis.read(data))!=-1){
				bais.write(data,0,len);
			}
			sb.append("读取应用文件成功\n");
			sb.append(bais.toString());
			bais.close();
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
			sb.append("读取应用文件失败");
		}
        oper_msg.setText(sb.toString());
        oper_msg.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}