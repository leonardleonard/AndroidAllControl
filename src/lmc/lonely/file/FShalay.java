package lmc.lonely.file;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.widget.Toast;
import lmc.lonely.R;
public class FShalay extends PreferenceActivity {
	private CheckBoxPreference sharelay_cb = null;
	private ListPreference sharelay_list = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addPreferencesFromResource(R.xml.file_sharelay);
        ((NotificationManager)super.getSystemService(NOTIFICATION_SERVICE)).cancel(1);
        PreferenceScreen screen = super.getPreferenceScreen();
        sharelay_cb = (CheckBoxPreference) screen.findPreference("sharelay_cb");
        sharelay_cb.setOnPreferenceClickListener(new OnPreferenceClickListener() {
        	@Override
        	public boolean onPreferenceClick(Preference pre) {
        		CheckBoxPreference chkbox = (CheckBoxPreference) pre;
				if(chkbox.isChecked()){
					SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(FShalay.this);
					int time = Integer.valueOf(share.getString("sharelay_list","60"));
					String web = share.getString("sharelay_et","Null");
					Toast.makeText(FShalay.this,"启用同步\n同步时间间隔:"+time+"分钟\n同步网址:"+web,Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(FShalay.this,"停用同步",Toast.LENGTH_SHORT).show();
				}
				return true;
    		}
    	});
        sharelay_list = (ListPreference) screen.findPreference("sharelay_list");
        sharelay_list.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
        	@Override
        	public boolean onPreferenceChange(Preference pre, Object obj) {
        		ListPreference lp = (ListPreference) pre;
        		Toast.makeText(FShalay.this,"同步时间间隔:"+Integer.valueOf(lp.getValue())+"分钟",Toast.LENGTH_SHORT).show();
     			return true;
     		}
     	});
    }
}