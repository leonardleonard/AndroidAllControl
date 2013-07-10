package lmc.lonely;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;
import lmc.lonely.base.BListView6;
public class Wel extends Activity {
	private ImageView app_wlogo = null;
	private int alpha = 255;
	private int isRun = 0;
	private Handler hder = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			app_wlogo.setAlpha(alpha);
			app_wlogo.invalidate();
		}
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.app_wel);
        try{
    		SysArgs.read(this);
        	super.findViewById(R.id.app_laywel).setBackgroundColor(SysArgs.getBgColor());
			File home = new File(SysArgs.getAppHome());
			if(!home.exists()||!home.isDirectory()){
				home.mkdirs();
			}
			File readMe = new File(SysArgs.getAppHome()+"请阅读"+SysConts.appName+"使用说明.txt");
			if(!readMe.exists()||readMe.isDirectory()){
				readMe.createNewFile();
				InputStream is = super.getResources().openRawResource(R.raw.readme);
				FileOutputStream fos = new FileOutputStream(readMe);
				byte[]data = new byte[1024];
				int len = -1;
				while((len=is.read(data))!=-1){
					fos.write(data,0,len);
				}
				fos.flush();
				is.close();
				fos.close();
			}
		}catch(Exception e){
			Toast.makeText(this,"创建"+SysConts.appName+"应用目录失败!\n请确认安装了SD卡",Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
        app_wlogo = (ImageView) this.findViewById(R.id.app_wlogo);
		app_wlogo.setAlpha(alpha);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(isRun<2){
					try{
						if(isRun==0){
							Thread.sleep(1000);
							isRun=1;
						}else if(isRun==1){
							Thread.sleep(20);
						}
						Wel.this.sendMsg();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}).start();
    }
    private void sendMsg(){
		alpha -= 5;
		if(alpha<=0){
			isRun = 2;
			if(SysArgs.getMode()==0){
				this.startActivity(new Intent(this,Main.class));
			}else{
				Intent it = new Intent(this,BListView6.class);
				it.putExtra("title",SysConts.appName+"-树状模式");
				this.startActivity(it);
			}
			this.finish();
		}
		hder.sendMessage(hder.obtainMessage());
	}
}