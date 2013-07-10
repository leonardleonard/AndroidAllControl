package lmc.lonely.base;
import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import lmc.lonely.R;
public class BSeekBar extends Activity {
	private SeekBar bar_seek = null;
    private TextView bar_msg = null;
	private SeekBar bar_show = null;
	private ImageView bar_img = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_bar);
        bar_seek = (SeekBar) super.findViewById(R.id.bar_seek);
        bar_msg = (TextView) super.findViewById(R.id.bar_msg);
        bar_show = (SeekBar) super.findViewById(R.id.bar_show);
        bar_img = (ImageView) super.findViewById(R.id.bar_img);
        bar_seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar bar) {
				bar_msg.append("停止拖拽;刻度:"+bar.getProgress()+"\n");
			}
			@Override
			public void onStartTrackingTouch(SeekBar bar) {
				bar_msg.append("开始拖拽;刻度:"+bar.getProgress()+"\n");
			}
			@Override
			public void onProgressChanged(SeekBar bar, int prog, boolean formUser) {
				bar_msg.append("正在拖拽;刻度:"+prog+" 是否为用户滑动:"+formUser+"\n");
			}
		});
        bar_msg.setMovementMethod(ScrollingMovementMethod.getInstance());
        bar_show.setMax(11);
        bar_show.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar bar) {}
			@Override
			public void onStartTrackingTouch(SeekBar bar) {}
			@Override
			public void onProgressChanged(SeekBar bar, int prog, boolean fromUser) {
				bar_img.setImageResource(BGalley0.pics[bar.getProgress()]);
			}
		});
    }
}