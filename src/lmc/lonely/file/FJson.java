package lmc.lonely.file;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.utils.OtherUtils;
public class FJson extends Activity implements OnClickListener {
	private Button json_simp = null;
	private Button json_comx = null;
	private Button json_prase = null;
	private TextView json_res = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_json);
        json_simp = (Button) super.findViewById(R.id.json_simp);
        json_comx = (Button) super.findViewById(R.id.json_comx);
        json_prase = (Button) super.findViewById(R.id.json_prase);
        json_res = (TextView) super.findViewById(R.id.json_res);
        json_simp.setOnClickListener(this);
        json_comx.setOnClickListener(this);
        json_prase.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.json_simp){
			String[]data = new String[]{"姓名:lmc","QQ:1138789752"};
			JSONObject root = new JSONObject();
			JSONArray ja = new JSONArray();
			try{
				JSONObject jobj = null;
				for(int i=0;i<data.length;i++){
					jobj = new JSONObject();
					jobj.put("tag",data[i]);
					ja.put(jobj);
				}
				root.put("root",ja);
				File jFile = new File(SysArgs.getAppHome()+OtherUtils.getLsh()+".txt");
				if(!jFile.exists()){
					jFile.createNewFile();
				}
				PrintStream out = new PrintStream(new FileOutputStream(jFile));
				out.print(root.toString());
				out.flush();
				out.close();
				json_res.setText("简单创建JSON成功\n存于:"+jFile.getAbsolutePath());
			}catch(Exception e){
				json_res.setText("简单创建JSON失败");
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.json_comx){
			String[]names = new String[]{"lmc","zcf"};
			int[]ages = new int[]{24,21};
			boolean[]isMrgeds = new boolean[]{false,false};
			double[]sals = new double[]{11800,8500};
			Date[]births = new Date[]{new Date(),new Date(),new Date()};
			JSONObject root = new JSONObject();
			JSONArray ja = new JSONArray();
			try{
				JSONObject jobj = null;
				for(int i=0;i<names.length;i++){
					jobj = new JSONObject();
					jobj.put("name",names[i]);
					jobj.put("age",ages[i]);
					jobj.put("marraged",isMrgeds[i]);
					jobj.put("salery",sals[i]);
					jobj.put("birth",births[i]);
					ja.put(jobj);
				}
				root.put("root",ja);
				root.put("address","黄冈师范学院");
				root.put("profess","信息与计算科学");
				root.put("phone","13669032128");
				File jFile = new File(SysArgs.getAppHome()+OtherUtils.getLsh()+".txt");
				if(!jFile.exists()){
					jFile.createNewFile();
				}
				PrintStream out = new PrintStream(new FileOutputStream(jFile));
				out.print(root.toString());
				out.flush();
				out.close();
				json_res.setText("复杂创建JSON成功\n存于:"+jFile.getAbsolutePath());
			}catch(Exception e){
				json_res.setText("复杂创建JSON失败");
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.json_prase){
			try{
				String data = "[{\"name\":\"上而求索\",\"age\":20},{\"name\":\"lmc\",\"age\":30}]";
				JSONArray ja = new JSONArray(data);
				JSONObject jobj = null;
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<ja.length();i++){
					jobj = ja.getJSONObject(i);
					sb.append("name:"+jobj.getString("name")+" age:"+jobj.getInt("age")+"\n");
				}
				sb.append("共"+ja.length()+"条记录");
				json_res.setText(sb.toString());
			}catch(Exception e){
				json_res.setText("解析JSON数组失败");
				e.printStackTrace();
			}
		}
	}
}