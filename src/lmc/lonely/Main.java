package lmc.lonely;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import lmc.lonely.base.*;
import lmc.lonely.db.*;
import lmc.lonely.file.*;
import lmc.lonely.http.*;
import lmc.lonely.lay.*;
import lmc.lonely.sys.*;
import lmc.lonely.thread.*;
public class Main extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.app_main);
        ((AppMgr) super.getApplication()).add(this);
        super.findViewById(R.id.app_laymian).setBackgroundColor(SysArgs.getBgColor());
        super.findViewById(R.id.app_mcopy).setOnClickListener(this);
        super.findViewById(R.id.base_anima).setOnClickListener(this);
        super.findViewById(R.id.base_bar).setOnClickListener(this);
        super.findViewById(R.id.base_box).setOnClickListener(this);
        super.findViewById(R.id.base_but).setOnClickListener(this);
        super.findViewById(R.id.base_clock).setOnClickListener(this);
        super.findViewById(R.id.base_col).setOnClickListener(this);
        super.findViewById(R.id.base_edit).setOnClickListener(this);
        super.findViewById(R.id.base_dia).setOnClickListener(this);
        super.findViewById(R.id.base_gal).setOnClickListener(this);
        super.findViewById(R.id.base_list).setOnClickListener(this);
        super.findViewById(R.id.base_men).setOnClickListener(this);
        super.findViewById(R.id.base_myv).setOnClickListener(this);
        super.findViewById(R.id.base_popup).setOnClickListener(this);
        super.findViewById(R.id.base_radio).setOnClickListener(this);
        super.findViewById(R.id.base_spin).setOnClickListener(this);
        super.findViewById(R.id.base_tabh).setOnClickListener(this);
        super.findViewById(R.id.base_txt).setOnClickListener(this);
        super.findViewById(R.id.base_touch).setOnClickListener(this);
        super.findViewById(R.id.base_widg).setOnClickListener(this);
        super.findViewById(R.id.file_fil).setOnClickListener(this);
        super.findViewById(R.id.file_json).setOnClickListener(this);
        super.findViewById(R.id.file_lok).setOnClickListener(this);
        super.findViewById(R.id.file_mus).setOnClickListener(this);
        super.findViewById(R.id.file_oper).setOnClickListener(this);
        super.findViewById(R.id.file_prop).setOnClickListener(this);
        super.findViewById(R.id.file_raw).setOnClickListener(this);
        super.findViewById(R.id.file_sd).setOnClickListener(this);
        super.findViewById(R.id.file_share).setOnClickListener(this);
        super.findViewById(R.id.file_sharelay).setOnClickListener(this);
        super.findViewById(R.id.file_xml).setOnClickListener(this);
        super.findViewById(R.id.db_par).setOnClickListener(this);
        super.findViewById(R.id.db_sqli).setOnClickListener(this);
        super.findViewById(R.id.lay_abs).setOnClickListener(this);
        super.findViewById(R.id.lay_comx).setOnClickListener(this);
        super.findViewById(R.id.lay_frame).setOnClickListener(this);
        super.findViewById(R.id.lay_line).setOnClickListener(this);
        super.findViewById(R.id.lay_relat).setOnClickListener(this);
        super.findViewById(R.id.lay_tab).setOnClickListener(this);
        super.findViewById(R.id.thread_ajax).setOnClickListener(this);
        super.findViewById(R.id.thread_ajchk).setOnClickListener(this);
        super.findViewById(R.id.thread_ball).setOnClickListener(this);
        super.findViewById(R.id.thread_data).setOnClickListener(this);
        super.findViewById(R.id.thread_fjxc).setOnClickListener(this);
        super.findViewById(R.id.thread_jump).setOnClickListener(this);
        super.findViewById(R.id.thread_mgr).setOnClickListener(this);
        super.findViewById(R.id.thread_nhd).setOnClickListener(this);
        super.findViewById(R.id.sys_apk).setOnClickListener(this);
        super.findViewById(R.id.sys_bdcast).setOnClickListener(this);
        super.findViewById(R.id.sys_chgbg).setOnClickListener(this);
        super.findViewById(R.id.sys_hsqp).setOnClickListener(this);
        super.findViewById(R.id.sys_serv).setOnClickListener(this);
        super.findViewById(R.id.sys_xtcx).setOnClickListener(this);
        super.findViewById(R.id.http_apache).setOnClickListener(this);
        super.findViewById(R.id.http_net).setOnClickListener(this);
        super.findViewById(R.id.http_updown).setOnClickListener(this);
        if(SysArgs.isShow()){
        	final Dialog hello = new Dialog(this);
        	hello.setContentView(R.layout.app_hello);
        	hello.setTitle(SysConts.appName+"欢迎你");
        	Button app_oset = (Button) hello.findViewById(R.id.app_oset);
			app_oset.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					CheckBox app_oshow = (CheckBox) hello.findViewById(R.id.app_oshow);
					SysArgs.setShow(app_oshow.isChecked());
					SysArgs.save(Main.this);
					hello.dismiss();
				}
			});
			Button app_ohelp = (Button) hello.findViewById(R.id.app_ohelp);
			app_ohelp.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Main.this.startActivity(new Intent(Main.this,Help.class));
					hello.dismiss();
				}
			});
			hello.show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE,Menu.FIRST+1,1,"退出");
		menu.add(Menu.NONE,Menu.FIRST+2,2,"设置");
		menu.add(Menu.NONE,Menu.FIRST+3,3,"赞助");
		return super.onCreateOptionsMenu(menu);
    }
    @Override
	public boolean onOptionsItemSelected(MenuItem item){
    	if(item.getItemId()==Menu.FIRST+1){
    		Dialog eixt = new AlertDialog.Builder(this).setTitle("退出").setIcon(R.drawable.ico_logo).
	            setMessage("你要退出"+SysConts.appName+"?").setPositiveButton("退出",new DialogInterface.OnClickListener() {
	            	@Override
	    			public void onClick(DialogInterface dia, int which) {
	            		((AppMgr) Main.this.getApplication()).finish();
	    			}
	    		}).setNegativeButton("取消",new DialogInterface.OnClickListener() {
	    			@Override
	    			public void onClick(DialogInterface dia, int which) {
	    				dia.dismiss();
	    			}
	    		}).create();
            eixt.show();
    	}else if(item.getItemId()==Menu.FIRST+2){
    		Intent it = new Intent(this,FProp.class);
			it.putExtra("title","设置");
			this.startActivity(it);
    	}else if(item.getItemId()==Menu.FIRST+3){
    		this.startActivity(new Intent(this,Help.class));
    	}
		return true;
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.app_mcopy:this.startActivity(new Intent(this,Help.class));break;
			case R.id.base_anima:this.startActivity(new Intent(this,BAnimation0.class));break;
			case R.id.base_bar:this.startActivity(new Intent(this,BSeekBar.class));break;
			case R.id.base_box:this.startActivity(new Intent(this,BCheckBox1.class));break;
			case R.id.base_but:this.startActivity(new Intent(this,BButton.class));break;
			case R.id.base_clock:this.startActivity(new Intent(this,BClock1.class));break;
			case R.id.base_col:this.startActivity(new Intent(this,BColor.class));break;
			case R.id.base_edit:this.startActivity(new Intent(this,BEditText.class));break;
			case R.id.base_dia:this.startActivity(new Intent(this,BDialog.class));break;
			case R.id.base_gal:this.startActivity(new Intent(this,BGalley0.class));break;
			case R.id.base_list:this.startActivity(new Intent(this,BListView0.class));break;
			case R.id.base_men:this.startActivity(new Intent(this,BMenu1.class));break;
			case R.id.base_myv:this.startActivity(new Intent(this,BView.class));break;
			case R.id.base_popup:this.startActivity(new Intent(this,BPopup.class));break;
			case R.id.base_radio:this.startActivity(new Intent(this,BRadioButton.class));break;
			case R.id.base_spin:this.startActivity(new Intent(this,BSpinner.class));break;
			case R.id.base_tabh:this.startActivity(new Intent(this,BTabHost0.class));break;
			case R.id.base_txt:this.startActivity(new Intent(this,BTextView.class));break;
			case R.id.base_touch:this.startActivity(new Intent(this,BTouch.class));break;
			case R.id.base_widg:Toast.makeText(this,"窗口小部件",Toast.LENGTH_SHORT).show();break;
			case R.id.file_fil:this.startActivity(new Intent(this,FApp.class));break;
			case R.id.file_json:this.startActivity(new Intent(this,FJson.class));break;
			case R.id.file_lok:this.startActivity(new Intent(this,FLkFiles.class));break;
			case R.id.file_mus:this.startActivity(new Intent(this,FMp3.class));break;
			case R.id.file_oper:this.startActivity(new Intent(this,FOper.class));break;
			case R.id.file_prop:this.startActivity(new Intent(this,FProp.class));break;
			case R.id.file_raw:this.startActivity(new Intent(this,FRaw.class));break;
			case R.id.file_sd:this.startActivity(new Intent(this,FSd.class));break;
			case R.id.file_share:this.startActivity(new Intent(this,FShare.class));break;
			case R.id.file_sharelay:this.startActivity(new Intent(this,FShalay.class));break;
			case R.id.file_xml:this.startActivity(new Intent(this,FXml.class));break;
			case R.id.db_par:this.startActivity(new Intent(this,DbParDo.class));break;
			case R.id.db_sqli:this.startActivity(new Intent(this,DbSqliDo.class));break;
			case R.id.lay_abs:this.startActivity(new Intent(this,LayAbs.class));break;
			case R.id.lay_comx:this.startActivity(new Intent(this,LayComx.class));break;
			case R.id.lay_frame:this.startActivity(new Intent(this,LayFrame1.class));break;
			case R.id.lay_line:this.startActivity(new Intent(this,LayLine1.class));break;
			case R.id.lay_relat:this.startActivity(new Intent(this,LayRelat1.class));break;
			case R.id.lay_tab:this.startActivity(new Intent(this,LayTab1.class));break;
			case R.id.thread_ajax:this.startActivity(new Intent(this,ThAjaxDown.class));break;
			case R.id.thread_ajchk:this.startActivity(new Intent(this,ThAjaxCheck.class));break;
			case R.id.thread_ball:this.startActivity(new Intent(this,ThBall.class));break;
			case R.id.thread_data:this.startActivity(new Intent(this,ThDMain.class));break;
			case R.id.thread_fjxc:this.startActivity(new Intent(this,ThFjxc.class));break;
			case R.id.thread_jump:this.startActivity(new Intent(this,ThJumpMain.class));break;
			case R.id.thread_mgr:this.startActivity(new Intent(this,ThMgr.class));break;
			case R.id.thread_nhd:this.startActivity(new Intent(this,ThNhd.class));break;
			case R.id.sys_apk:this.startActivity(new Intent(this,SysApk.class));break;
			case R.id.sys_bdcast:this.startActivity(new Intent(this,SysBdc.class));break;
			case R.id.sys_chgbg:this.startActivity(new Intent(this,SysChgbg.class));break;
			case R.id.sys_hsqp:this.startActivity(new Intent(this,SysHsqp.class));break;
			case R.id.sys_serv:this.startActivity(new Intent(this,SysServ.class));break;
			case R.id.sys_xtcx:this.startActivity(new Intent(this,SysXtcxMain.class));break;
			case R.id.http_apache:this.startActivity(new Intent(this,HttpApacheImpl.class));break;
			case R.id.http_net:this.startActivity(new Intent(this,HttpNetImpl.class));break;
			case R.id.http_updown:this.startActivity(new Intent(this,HttpImgImpl.class));break;
			default:break;
		}
	}
}