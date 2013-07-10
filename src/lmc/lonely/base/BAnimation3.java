package lmc.lonely.base;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import lmc.lonely.R;
public class BAnimation3 extends ListActivity implements OnClickListener {
	private Button anima_abjdh = null;
	private ListView anima_alist = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_anima3);
        anima_abjdh = (Button) super.findViewById(R.id.anima_3bjdh);
        anima_alist = super.getListView();
        anima_abjdh.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.anima_3bjdh){
			anima_alist.setAdapter(this.init());
			Animation anim = AnimationUtils.loadAnimation(this,R.anim.ani_anima_lay_list);
			LayoutAnimationController con = new LayoutAnimationController(anim);
			con.setOrder(LayoutAnimationController.ORDER_NORMAL);
			con.setDelay(2.0f);
			anima_alist.setLayoutAnimation(con);
		}
	}
	private ListAdapter init(){
		List<HashMap<String,String>>datas = new ArrayList<HashMap<String,String>>();
		HashMap<String,String>datay = new HashMap<String,String>();
		datay.put("user_name","张三");
		datay.put("user_sex","女");
		datas.add(datay);
		HashMap<String,String>datae = new HashMap<String,String>();
		datae.put("user_name","李四");
		datae.put("user_sex","女");
		datas.add(datae);
		HashMap<String,String>datat = new HashMap<String,String>();
		datat.put("user_name","王五");
		datat.put("user_sex","男");
		datas.add(datat);
		return new SimpleAdapter(this,datas,R.layout.base_anima3_item,new String[]{"user_name","user_sex"},new int[]{R.id.anima_3name,R.id.anima_3sex});
	}
}