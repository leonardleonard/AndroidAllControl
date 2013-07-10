package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import lmc.adater.BListView3Adapter;
import lmc.lonely.R;
public class BListView3 extends Activity {
	private ExpandableListView list_3view = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_list3);
        list_3view = (ExpandableListView) super.findViewById(R.id.list_3view);
        list_3view.setAdapter(new BListView3Adapter(this));
        super.registerForContextMenu(list_3view);
        list_3view.setOnGroupClickListener(new OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView par, View v, int group, long id) {
				Toast.makeText(BListView3.this,"点击组节点\n组节点:"+group,Toast.LENGTH_SHORT).show();
				return false;
			}
		});
        list_3view.setOnGroupExpandListener(new OnGroupExpandListener() {
			@Override
			public void onGroupExpand(int group) {
				Toast.makeText(BListView3.this,"组展开\n组节点:"+group,Toast.LENGTH_SHORT).show();
			}
		});
        list_3view.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView par, View v, int group, int child, long id) {
				Toast.makeText(BListView3.this,"点击子节点\n组节点:"+group+",子节点:"+child,Toast.LENGTH_SHORT).show();
				return false;
			}
		});
        list_3view.setOnGroupCollapseListener(new OnGroupCollapseListener() {
			@Override
			public void onGroupCollapse(int group) {
				Toast.makeText(BListView3.this,"组关闭\n组节点:"+group,Toast.LENGTH_SHORT).show();
			}
		});
    }
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo info) {
		super.onCreateContextMenu(menu, v, info);
		ExpandableListContextMenuInfo eInfo = (ExpandableListContextMenuInfo) info;
		int type = ExpandableListView.getPackedPositionType(eInfo.packedPosition);
		int group = ExpandableListView.getPackedPositionGroup(eInfo.packedPosition);
		int child = ExpandableListView.getPackedPositionChild(eInfo.packedPosition);
		Toast.makeText(this,"上下文菜单\n类型:"+type+"\n组节点:"+group+"\n子节点:"+child,Toast.LENGTH_SHORT).show();
    }
}