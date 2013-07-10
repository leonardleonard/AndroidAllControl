package lmc.lonely.sys;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.lonely.SysConts;
import lmc.utils.OtherUtils;
public class SysXtcxMain extends Activity implements OnClickListener {
	private Intent it = null;
	private Button xtcx_bd = null;
	private Button xtcx_jjbh = null;
	private Button xtcx_zjbh = null;
	private Button xtcx_dx = null;
	private Button xtcx_cx = null;
	private Button xtcx_yjno = null;
	private Button xtcx_yjyes = null;
	private Button xtcx_yjmul = null;
	private Button xtcx_tpll = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.sys_xtcx);
        xtcx_bd = (Button) super.findViewById(R.id.xtcx_bd);
        xtcx_jjbh = (Button) super.findViewById(R.id.xtcx_jjbh);
        xtcx_zjbh = (Button) super.findViewById(R.id.xtcx_zjbh);
        xtcx_dx = (Button) super.findViewById(R.id.xtcx_dx);
        xtcx_cx = (Button) super.findViewById(R.id.xtcx_cx);
        xtcx_yjno = (Button) super.findViewById(R.id.xtcx_yjno);
        xtcx_yjyes = (Button) super.findViewById(R.id.xtcx_yjyes);
        xtcx_yjmul = (Button) super.findViewById(R.id.xtcx_yjmul);
        xtcx_tpll = (Button) super.findViewById(R.id.xtcx_tpll);
        xtcx_bd.setOnClickListener(this);
        xtcx_jjbh.setOnClickListener(this);
        xtcx_zjbh.setOnClickListener(this);
        xtcx_dx.setOnClickListener(this);
        xtcx_cx.setOnClickListener(this);
        xtcx_yjno.setOnClickListener(this);
        xtcx_yjyes.setOnClickListener(this);
        xtcx_yjmul.setOnClickListener(this);
        xtcx_tpll.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.xtcx_bd){
			it = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
			this.startActivity(it);
		}else if(v.getId()==R.id.xtcx_jjbh){
			it = new Intent();
			it.setAction(Intent.ACTION_DIAL);
			it.setData(Uri.parse("tel:"+SysConts.phone));
			this.startActivity(it);
		}else if(v.getId()==R.id.xtcx_zjbh){
			it = new Intent();
			it.setAction(Intent.ACTION_CALL);
			it.setData(Uri.parse("tel:"+SysConts.phone));
			this.startActivity(it);
		}else if(v.getId()==R.id.xtcx_dx){
			it = new Intent(Intent.ACTION_SENDTO);
			it.setType("vnd.android-dir/mms-sms");
			it.setData(Uri.parse("smsto:"+SysConts.phone));
			it.putExtra("sms_body",SysConts.appName+"由"+SysConts.owner+"开发,敬请赞助开发者");
			this.startActivity(it);
		}else if(v.getId()==R.id.xtcx_cx){
			it = new Intent(Intent.ACTION_SEND);
			it.setType("image/*");
			it.putExtra("address",SysConts.phone);
			it.putExtra("sms_body",SysConts.appName+"由"+SysConts.owner+"开发,敬请赞助开发者");
			ArrayList<String>imgs = OtherUtils.getSdFile(SysArgs.SD,SysConts.fms);
			if(imgs.size()>0){
				it.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://"+imgs.get(0)));
			}
			this.startActivity(it);
		}else if(v.getId()==R.id.xtcx_yjno){
			it = new Intent(Intent.ACTION_SENDTO);
			it.setType("plain/text");
			it.setData(Uri.parse("mailto:"+SysConts.mail));
			it.putExtra(Intent.EXTRA_EMAIL,new String[]{SysConts.mail});
			it.putExtra(Intent.EXTRA_SUBJECT,"谢谢你赞助"+SysConts.appName);
			it.putExtra(Intent.EXTRA_TEXT,SysConts.appName+"由"+SysConts.owner+"开发,敬请赞助开发者");
			this.startActivity(it);
		}else if(v.getId()==R.id.xtcx_yjyes){
			it = new Intent(Intent.ACTION_SEND);
			it.setType("image/*");
			it.setType("message/rfc882");
			//设置收件者/抄送这/迷送者
			it.putExtra(Intent.EXTRA_EMAIL,new String[]{SysConts.mail});
			it.putExtra(Intent.EXTRA_CC,new String[]{SysConts.mail});
			it.putExtra(Intent.EXTRA_BCC,new String[]{SysConts.mail});
			it.putExtra(Intent.EXTRA_SUBJECT,"谢谢你赞助"+SysConts.appName);
			it.putExtra(Intent.EXTRA_TEXT,SysConts.appName+"由"+SysConts.owner+"开发,敬请赞助开发者");
			ArrayList<String>imgs = OtherUtils.getSdFile(SysArgs.SD,SysConts.fms);
			if(imgs.size()>0){
				it.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://"+imgs.get(0)));
			}
			Intent.createChooser(it,"请选择邮件客户端");
			this.startActivity(it);
		}else if(v.getId()==R.id.xtcx_yjmul){
			it = new Intent(Intent.ACTION_SEND_MULTIPLE);
			it.setType("image/*");
			it.setType("message/rfc882");
			it.putExtra(Intent.EXTRA_EMAIL,new String[]{SysConts.mail});
			it.putExtra(Intent.EXTRA_CC,new String[]{SysConts.mail});
			it.putExtra(Intent.EXTRA_BCC,new String[]{SysConts.mail});
			it.putExtra(Intent.EXTRA_SUBJECT,"谢谢你赞助"+SysConts.appName);
			it.putExtra(Intent.EXTRA_TEXT,SysConts.appName+"由"+SysConts.owner+"开发,敬请赞助开发者");
			ArrayList<Uri>pics = new ArrayList<Uri>();
			ArrayList<String>imgs = OtherUtils.getSdFile(SysArgs.SD,SysConts.fms);
			if(imgs.size()>1){
				pics.add(Uri.parse("file://"+imgs.get(0)));
				pics.add(Uri.parse("file://"+imgs.get(1)));
			}
			it.putParcelableArrayListExtra(Intent.EXTRA_STREAM,pics);
			Intent.createChooser(it,"请选择邮件客户端");
			this.startActivity(it);
		}else if(v.getId()==R.id.xtcx_tpll){
			it = new Intent(Intent.ACTION_GET_CONTENT);
			it.setType("image/*");
			this.startActivity(Intent.createChooser(it,"请选择"));
		}
	}
}