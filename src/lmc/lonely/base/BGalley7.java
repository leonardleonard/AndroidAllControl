package lmc.lonely.base;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import lmc.lonely.R;
public class BGalley7 extends Activity {
	private SimpleAdapter adapter = null;
	private GridView gal_7grid = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal7);
        gal_7grid = (GridView) super.findViewById(R.id.gal_7grid);
        this.init();
        gal_7grid.setAdapter(adapter);
        gal_7grid.setOnItemClickListener(new OnItemClickListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void onItemClick(AdapterView<?>ad, View v, int index, long id) {
				Map<String,Integer>img = (Map<String,Integer>) ad.getAdapter().getItem(index);
				ImageView iv = new ImageView(BGalley7.this);
				iv.setImageResource(img.get("ico"));
				iv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
				iv.setScaleType(ImageView.ScaleType.CENTER);
				Dialog msgDia=new AlertDialog.Builder(BGalley7.this).setIcon(R.drawable.ico_logo).setTitle("查看").
					setPositiveButton("确定",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dia, int which) {
							dia.dismiss();
						}
				}).setView(iv).create();
				msgDia.show();
			}
		});
    }
	private void init(){
		List<Map<String,Integer>>imgs = new ArrayList<Map<String,Integer>>();
    	Field[]fds = R.drawable.class.getDeclaredFields();
    	for(int i=0;i<fds.length;i++){
    		if(fds[i].getName().startsWith("icob_gal")){
    			try{
    				Map<String,Integer>img = new HashMap<String,Integer>();
					img.put("ico",fds[i].getInt(R.drawable.class));
					imgs.add(img);
				}catch (Exception e){
					e.printStackTrace();
				}
    		}
    	}
    	adapter = new SimpleAdapter(this,imgs,R.layout.base_gal7grid,new String[]{"ico"},new int[]{R.id.gal_7img});
    }
}