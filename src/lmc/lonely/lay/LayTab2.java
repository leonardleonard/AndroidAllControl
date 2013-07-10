package lmc.lonely.lay;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import lmc.lonely.R;
import lmc.utils.OtherUtils;
public class LayTab2 extends Activity {
	private String[][]datas = new String[][]{{"开发者","联系电话","QQ"},{"上而求索","13669032128","1138789752"}};
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TableLayout lay = new TableLayout(this);
        lay.setBackgroundResource(R.drawable.icol_tab);
        lay.setStretchAllColumns(true);
        for(int i=0;i<datas.length;i++){
        	TableRow row = new TableRow(this);
        	for(int j=0;j<datas[i].length;j++){
        		TextView tv = new TextView(this);
        		tv.setText(datas[i][j]);
        		tv.setTextColor(OtherUtils.getColor(0,255,255));
        		row.addView(tv,j);
        	}
        	lay.addView(row);
        }
        super.setContentView(lay,new TableLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.FILL_PARENT));
	}
}