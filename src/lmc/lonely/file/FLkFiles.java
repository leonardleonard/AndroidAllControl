package lmc.lonely.file;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import lmc.adater.FLkFilesAdapter;
import lmc.lonely.R;
import lmc.utils.FLkFilesCtor;
public class FLkFiles extends ListActivity {
	private final String root = "/";
	private List<String>paths = null;
	private List<String>names = null;
	private TextView lok_no = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_lok);
        lok_no = (TextView)findViewById(R.id.lok_no);
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
        	this.getDir(Environment.getExternalStorageDirectory().getAbsolutePath());
        }else{
        	Toast.makeText(this,"没有SD卡",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
	protected void onListItemClick(ListView lv, View v, int posi, long id) {
    	File file = new File(paths.get(posi));
    	if(file.isDirectory()){
			if(file.canRead()){
				this.getDir(file.getAbsolutePath());
			}else{
				Toast.makeText(this,file.getName()+"目录不可读",Toast.LENGTH_SHORT).show();
			}
		}
    }
    private void getDir(String dir){
    	lok_no.setText(dir);
    	names = new ArrayList<String>();
		paths = new ArrayList<String>();
		File fDir = new File(dir);
		if(!dir.equals(root)){
			names.add(root);
			names.add("../");
			paths.add(root);
			paths.add(fDir.getParent());
		}
		File[]files = fDir.listFiles();
		Arrays.sort(files,new FLkFilesCtor());
		File file = null;
		for(int i=0;i<files.length;i++){
			file = files[i];
			paths.add(file.getPath());
			if(file.isDirectory()){
				names.add(file.getName()+"/");
			}else{
				names.add(file.getName());
			}
		}
		this.setListAdapter(new FLkFilesAdapter(this,names));
    }
}