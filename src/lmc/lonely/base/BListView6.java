package lmc.lonely.base;
import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import lmc.entity.TreeData;
import lmc.entity.TreeEle;
import lmc.lonely.AppMgr;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
public class BListView6 extends ListActivity {
	private ArrayList<TreeEle>allNodes = null;
	private TreeViewAdapter tAd = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.getListView().setBackgroundColor(SysArgs.getBgColor());
        ((AppMgr) super.getApplication()).add(this);
        allNodes = new TreeData(this).getDataSource();
        tAd = new TreeViewAdapter(this,R.layout.base_list6,allNodes);
        super.setListAdapter(tAd);
        super.registerForContextMenu(super.getListView());
        String title = super.getIntent().getStringExtra("title");
        if(title!=null){
        	super.setTitle(title);
        }
    }
	@Override  
    protected void onListItemClick(ListView lv, View v, int posi, long id) {
    	super.onListItemClick(lv, v, posi, id);
    	TreeEle cNode = allNodes.get(posi);
        if(cNode.isHasChild()){
        	if(cNode.isOpen()){
        		cNode.setOpen(false);
                ArrayList<TreeEle>hNodes = new ArrayList<TreeEle>();
                for(int i=posi+1;i<allNodes.size();i++){
                    if(cNode.getLevel()>=allNodes.get(i).getLevel()){
                        break;
                    }else{
                    	hNodes.add(allNodes.get(i));
                    }
                }
                allNodes.removeAll(hNodes);
                tAd.notifyDataSetChanged();
            }else{
            	cNode.setOpen(true);
                int level = cNode.getLevel()+1;
                for(TreeEle ele:cNode.getChilds()){
                    ele.setLevel(level);
                    ele.setOpen(false);
                    allNodes.add(posi+1,ele);
                }
                tAd.notifyDataSetChanged();
            }
        }
    }
	@SuppressWarnings("rawtypes")
	public class TreeViewAdapter extends ArrayAdapter {
    	private Context con = null;
    	private int layId = -1;
        private ArrayList<TreeEle>nodes = null;
        private Bitmap oIco = null;
        private Bitmap cIco = null;
    	@SuppressWarnings("unchecked")
    	public TreeViewAdapter(Context con, int layId, ArrayList<TreeEle>nodes) {
            super(con, layId, nodes);
            this.con = con;
            this.layId = layId;
            this.nodes = nodes;
            this.oIco = BitmapFactory.decodeResource(con.getResources(),R.drawable.icob_list5);
            this.cIco = BitmapFactory.decodeResource(con.getResources(),R.drawable.icob_list6);
        }
    	@Override
        public int getCount() {
            return nodes.size();
        }
        @Override
        public Object getItem(int posi) {
            return posi;
        }
        @Override
        public long getItemId(int posi) {
            return posi;
        }
        @Override
        public View getView(int posi, View v, ViewGroup par) {
        	ViewTag tag = new ViewTag();
        	v = LayoutInflater.from(con).inflate(layId,null);
            tag.icon = (ImageView) v.findViewById(R.id.list_6title);
            tag.text = (TextView) v.findViewById(R.id.list_6cont);
            v.setTag(tag);
            final TreeEle node = nodes.get(posi);
            tag.icon.setPadding(20*(node.getLevel()+1),tag.icon.getPaddingTop(),0,tag.icon.getPaddingBottom());
            tag.text.setText(node.getTitle());
            tag.text.setTextColor(0xFF000000);
            tag.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                	node.forward(con);
                	if(node.getId().equals("00")){
                		//BListView6.this.finish();
                		((AppMgr) BListView6.this.getApplication()).finish();
                	}
                }
            });
            if(node.isHasChild()){
            	if(node.isOpen()){
            		tag.icon.setImageBitmap(cIco);
            	}else{
            		tag.icon.setImageBitmap(oIco);
            	}
            }else{
                tag.icon.setImageBitmap(oIco);
                tag.icon.setVisibility(View.INVISIBLE);
            }
            return v;
        }
        class ViewTag {
            TextView text;
            ImageView icon;
        }
    }
}