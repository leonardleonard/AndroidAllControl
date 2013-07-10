package lmc.lonely.base;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import lmc.lonely.R;
public class BMenu1 extends Activity implements OnClickListener{
	private ImageView menu_1con = null;
	private ImageButton menu_1pre = null;
	private ImageButton menu_1next = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_men);
        menu_1con = (ImageView) super.findViewById(R.id.menu_1con);
        menu_1pre = (ImageButton) super.findViewById(R.id.menu_1pre);
        menu_1next = (ImageButton) super.findViewById(R.id.menu_1next);
        super.registerForContextMenu(menu_1con);
        menu_1pre.setOnClickListener(this);
        menu_1next.setOnClickListener(this);
    }
	@Override
	public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu,v,menuInfo);
		menu.setHeaderTitle("请选择");
		menu.add(Menu.NONE,Menu.FIRST+1,1,"查看");
		menu.add(Menu.NONE,Menu.FIRST+2,2,"编辑");
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case Menu.FIRST+1:Toast.makeText(this,"选择查看",Toast.LENGTH_SHORT).show();break;
			case Menu.FIRST+2:Toast.makeText(this,"选择编辑",Toast.LENGTH_SHORT).show();break;
		}
		return super.onContextItemSelected(item);
	}
	@Override
	public void onContextMenuClosed(Menu menu) {
		Toast.makeText(this,"关闭上下文菜单",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.menu_1pre){
			this.startActivity(new Intent(this,BMenu2.class));
		}else if(v.getId()==R.id.menu_1next){
			this.startActivity(new Intent(this,BMenu3.class));
		}
	}
}