package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ViewSwitcher.ViewFactory;
import lmc.adater.BGalley1In6Adapter;
import lmc.lonely.R;
public class BGalley1 extends Activity {
	private ImageView curImg = null;
	private Gallery gal_1show = null;
	private ImageSwitcher gal_1is = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_gal1);
        gal_1show = (Gallery) super.findViewById(R.id.gal_1show);
        gal_1is = (ImageSwitcher) super.findViewById(R.id.gal_1is);
        gal_1show.setAdapter(new BGalley1In6Adapter(this,BGalley0.pics));
        gal_1show.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> ad, View v, int index, long id) {
				gal_1is.setImageResource(BGalley0.pics[index]);
				curImg = (ImageView) v;
			}
			@Override
			public void onNothingSelected(AdapterView<?> ad) {}
        });
        gal_1is.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView iv = new ImageView(BGalley1.this);
				iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
				iv.setPadding(2,2,2,2);
				iv.setBackgroundColor(0xFF00FFFF);;
				iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				return iv;
			}
		});
        gal_1is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        gal_1is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        super.registerForContextMenu(gal_1is);
    }
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo info) {
		super.onCreateContextMenu(menu, v, info);
    	menu.setHeaderIcon(R.drawable.ico_logo).setHeaderTitle("请选择");
    	menu.add(0,Menu.FIRST+1,1,"选定");
    	menu.add(0,Menu.FIRST+2,2,"取消");
	}
    @Override
	public boolean onContextItemSelected(MenuItem item) {
    	if(item.getItemId()==Menu.FIRST+1){
    		curImg.setAlpha(80);
    	}else if(item.getItemId()==Menu.FIRST+2){
    		curImg.setAlpha(255);
    	}
		return super.onContextItemSelected(item);
	}
}