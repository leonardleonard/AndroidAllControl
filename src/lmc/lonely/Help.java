package lmc.lonely;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
public class Help extends Activity {
	private TextView app_htcont = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.app_help);
        app_htcont = (TextView) super.findViewById(R.id.app_htcont);
        app_htcont.append("\n***详细说明请阅读文件:"+SysArgs.getAppHome()+"请阅读"+SysConts.appName+"使用说明.txt\n***敬请赞助开发者!");
    }
}