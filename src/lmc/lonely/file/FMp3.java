package lmc.lonely.file;
import java.util.ArrayList;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.utils.OtherUtils;
public class FMp3 extends Activity implements OnClickListener {
	private Button mus_start = null;
	private Button mus_pause = null;
	private Button mus_end = null;
	private MediaPlayer player = null;
	private boolean isPlaying = false;
	private boolean isPause = false;
	private boolean isEnd = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_mus);
        mus_start = (Button) super.findViewById(R.id.mus_start);
        mus_pause = (Button) super.findViewById(R.id.mus_pause);
        mus_end = (Button) super.findViewById(R.id.mus_end);
        mus_start.setOnClickListener(this);
        mus_pause.setOnClickListener(this);
        mus_end.setOnClickListener(this);
    }
    @Override
    public void onBackPressed() {
    	super.onBackPressed();
    	if(isPlaying){
			if(!isEnd){
				player.stop();
				player.release();
				isPlaying = false;
				isPause = false;
				isEnd = true;
			}
		}
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.mus_start){
			ArrayList<String>mp3s = OtherUtils.getSdFile(SysArgs.SD,new String[]{".mp3"});
			if(mp3s.size()==0){
				Toast.makeText(this,"SD卡中不存在mp3文件",Toast.LENGTH_SHORT).show();
				return;
			}
			if(!isPlaying){
				player = MediaPlayer.create(this,Uri.parse("file://"+mp3s.get(0)));
				player.setLooping(false);
				player.start();
				isPlaying = true;
				isPause = false;
				isEnd = false;
			}else{
				Toast.makeText(this,"音乐在播放中",Toast.LENGTH_SHORT).show();
			}
		}else if(v.getId()==R.id.mus_pause){
			if(isPlaying&&!isEnd){
				if(!isPause){
					player.pause();
					mus_pause.setText("继续");
					isPause = true;
				}else{
					player.start();
					mus_pause.setText("暂停");
					isPause = false;
				}
			}else{
				Toast.makeText(this,"没有音乐在播放",Toast.LENGTH_SHORT).show();
			}
		}else if(v.getId()==R.id.mus_end){
			if(isPlaying){
				player.stop();
				player.release();
				mus_pause.setText("暂停");
				isPlaying = false;
				isPause = false;
				isEnd = true;
			}else{
				Toast.makeText(this,"没有音乐在播放",Toast.LENGTH_SHORT).show();
			}
		}
	}
}