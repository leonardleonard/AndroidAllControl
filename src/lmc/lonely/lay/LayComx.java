package lmc.lonely.lay;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import lmc.lonely.R;
import lmc.utils.OtherUtils;
public class LayComx extends Activity {
	private LinearLayout comx_layjh = null;
	private LinearLayout comx_layzh = null;
	private LinearLayout comx_layyf = null;
	private LinearLayout comx_layc = null;
	private TextView comx_jh = null;
	private TextView comx_zh = null;
	private TextView comx_yf = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.lay_comx);
        comx_layjh = (LinearLayout) super.findViewById(R.id.comx_layjh);
        comx_layzh = (LinearLayout) super.findViewById(R.id.comx_layzh);
        comx_layyf = (LinearLayout) super.findViewById(R.id.comx_layyf);
        comx_layc = (LinearLayout) super.findViewById(R.id.comx_layc);
        comx_jh = (TextView) super.findViewById(R.id.comx_jh);
        comx_zh = (TextView) super.findViewById(R.id.comx_zh);
        comx_yf = (TextView) super.findViewById(R.id.comx_yf);
        LayoutInflater fac = LayoutInflater.from(this);
        View fLay = fac.inflate(R.layout.lay_comx1lay,null);
		comx_layc.addView(fLay);
		comx_layjh.setOnClickListener(new TabListener(comx_layjh,comx_jh,fLay));
		comx_layzh.setOnClickListener(new TabListener(comx_layzh,comx_zh,fac.inflate(R.layout.lay_comx2lay,null)));
		comx_layyf.setOnClickListener(new TabListener(comx_layyf,comx_yf,fac.inflate(R.layout.lay_comx3lay,null)));
	}
	private class TabListener implements OnClickListener{
		private LinearLayout lay = null;
		private TextView title = null;
		private View cont = null;
		public TabListener(LinearLayout lay, TextView title, View cont) {
			this.lay = lay;
			this.title = title;
			this.cont = cont;
		}
		@Override
		public void onClick(View v) {
			this.clear();
			this.repaint();
		}
		private void clear(){
			LinearLayout[]lays = new LinearLayout[]{comx_layjh,comx_layzh,comx_layyf};
			TextView[]tvs = new TextView[]{comx_jh,comx_zh,comx_yf};
			for(int i=0;i<3;i++){
				lays[i].setBackgroundDrawable(null);
				tvs[i].setTextColor(OtherUtils.getColor(0,255,0));
			}
			comx_layc.removeAllViews();
		}
		private void repaint(){
			lay.setBackgroundDrawable(LayComx.this.getResources().getDrawable(R.drawable.icol_comx));
			title.setTextColor(OtherUtils.getColor(0,0,0));
			comx_layc.addView(cont);
		}
	}
}