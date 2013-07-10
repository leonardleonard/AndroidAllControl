package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;
import lmc.lonely.R;
public class BMenu2 extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_men2);
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		SubMenu oper = menu.addSubMenu("操作");
		oper.setHeaderIcon(R.drawable.ico_logo);
		oper.setHeaderTitle("请选择");
		super.getMenuInflater().inflate(R.menu.menu_2men,oper);
		SubMenu other = menu.addSubMenu("其他");
		other.setHeaderIcon(R.drawable.ico_logo);
		other.setHeaderTitle("请选择");
		other.add(Menu.NONE,Menu.FIRST+1,1,"详情").setIcon(android.R.drawable.ic_menu_info_details);
		other.add(Menu.NONE,Menu.FIRST+2,2,"帮助").setIcon(android.R.drawable.ic_menu_help);
		other.add(Menu.NONE,Menu.FIRST+3,3,"发送").setIcon(android.R.drawable.ic_menu_send);
		menu.add(Menu.NONE,Menu.FIRST+4,4,"添加").setIcon(android.R.drawable.ic_menu_add);
		menu.add(Menu.NONE,Menu.FIRST+5,5,"编辑").setIcon(android.R.drawable.ic_menu_edit);
		menu.add(Menu.NONE,Menu.FIRST+6,6,"保存").setIcon(android.R.drawable.ic_menu_save);
		menu.add(Menu.NONE,Menu.FIRST+7,7,"删除").setIcon(android.R.drawable.ic_menu_delete);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this,"Id:"+item.getItemId()+"\nTitle:"+item.getTitle(),Toast.LENGTH_SHORT).show();
		return true;
	}
    @Override
	public void onOptionsMenuClosed(Menu menu) {
		Toast.makeText(this,"关闭菜单",Toast.LENGTH_SHORT).show();
	}
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		Toast.makeText(this,"打开菜单",Toast.LENGTH_SHORT).show();
		return true;
	}
}