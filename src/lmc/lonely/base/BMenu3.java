package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import lmc.lonely.R;
public class BMenu3 extends Activity {
	private ImageView menu_3xml = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_men3);
        menu_3xml = (ImageView) super.findViewById(R.id.menu_3xml);
        super.registerForContextMenu(menu_3xml);
    }
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo info) {
		super.onCreateContextMenu(menu, v, info);
		super.getMenuInflater().inflate(R.menu.menu_3men,menu);
	}
}