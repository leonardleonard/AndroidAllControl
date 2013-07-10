package lmc.lonely.file;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import lmc.lonely.R;
import lmc.lonely.SysConts;
import lmc.utils.OtherUtils;
public class FShare extends Activity implements OnClickListener {
	private String fName = null;
	private SharedPreferences share = null;
	private Button share_create = null;
	private Button share_read = null;
	private TextView share_res = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_share);
        share_create = (Button) super.findViewById(R.id.share_create);
        share_read = (Button) super.findViewById(R.id.share_read);
        share_res = (TextView) super.findViewById(R.id.share_res);
        share_create.setOnClickListener(this);
        share_read.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.share_create){
			fName = OtherUtils.getLsh();
	        share = super.getSharedPreferences(fName,Activity.MODE_PRIVATE);
			SharedPreferences.Editor edit = share.edit();
	        edit.putString(SysConts.datak[0][0],SysConts.datak[0][1]);
	        edit.putString(SysConts.datak[1][0],SysConts.datak[1][1]);
	        edit.putString(SysConts.datak[2][0],SysConts.datak[2][1]);
	        edit.commit();
	        share_res.setText("创建共享文件成功\n存于:/data/data/"+super.getApplication().getPackageName()+"/shared_prefs/"+fName+".xml");
		}else if(v.getId()==R.id.share_read){
			if(fName!=null){
				share_res.setText("--开发者:"+share.getString("name","默认值")+"\n--联系电话:"+share.getString("phone","默认值")+"\n--QQ:"+share.getString("qq","默认值"));
			}else{
				share_res.setText("共享文件未创建");
			}
		}
	}
}