package lmc.lonely.db;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
public class DbSqliDo extends Activity implements OnClickListener {
	private DbSqliHper db = null;
	private TextView sqli_msg = null;
	private Button sqli_ctable = null;
	private Button sqli_dtable = null;
	private Button sqli_insert = null;
	private Button sqli_detele = null;
	private Button sqli_update = null;
	private Button sqli_query = null;
	private Button sqli_queall = null;
	private Button sqli_maxid = null;
	private Button sqli_count = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.db_sqli);
        db = new DbSqliHper(this);
        sqli_msg = (TextView) super.findViewById(R.id.sqli_msg);
        sqli_ctable = (Button) super.findViewById(R.id.sqli_ctable);
        sqli_dtable = (Button) super.findViewById(R.id.sqli_dtable);
        sqli_insert = (Button) super.findViewById(R.id.sqli_insert);
        sqli_detele = (Button) super.findViewById(R.id.sqli_detele);
        sqli_update = (Button) super.findViewById(R.id.sqli_update);
        sqli_query = (Button) super.findViewById(R.id.sqli_query);
        sqli_queall = (Button) super.findViewById(R.id.sqli_queall);
        sqli_maxid = (Button) super.findViewById(R.id.sqli_maxid);
        sqli_count = (Button) super.findViewById(R.id.sqli_count);
        sqli_msg.setText("数据库文件存于:/data/data/"+super.getApplication().getPackageName()+"/databases/"+SysArgs.dbName);
        sqli_ctable.setOnClickListener(this);
        sqli_dtable.setOnClickListener(this);
        sqli_insert.setOnClickListener(this);
        sqli_detele.setOnClickListener(this);
        sqli_update.setOnClickListener(this);
        sqli_query.setOnClickListener(this);
        sqli_queall.setOnClickListener(this);
        sqli_maxid.setOnClickListener(this);
        sqli_count.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.sqli_ctable){
			Toast.makeText(this,db.create()?"创建表成功":"创建表失败",Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.sqli_dtable){
			Toast.makeText(this,db.drop()?"删除表成功":"删除表失败",Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.sqli_insert){
			int id = db.insert("lmc",(int)(Math.random()*1000),"上而求索");
			Toast.makeText(this,(id!=-1)?"插入数据成功,返回ID:"+id:"插入数据失败",Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.sqli_detele){
			Toast.makeText(this,db.delete(db.getMaxId())?"删除数据成功":"删除数据失败",Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.sqli_update){
			Toast.makeText(this,db.update(db.getMaxId(),"新值",100,"ok")?"更新数据成功":"更新数据失败",Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.sqli_query){
			int id = db.getMaxId();
			HashMap<String,Object>data = db.queryById(id);
			if(data!=null&&data.size()>0){
				StringBuffer sb = new StringBuffer("按ID查询:\n");
				sb.append("Id:"+id+"\n");
				sb.append("Name:"+data.get("lmc_name")+"\n");
				sb.append("Age:"+data.get("lmc_age")+"\n");
				sb.append("Msg:"+data.get("lmc_msg"));
				Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
			}
		}else if(v.getId()==R.id.sqli_queall){
			ArrayList<HashMap<String,Object>>datas = db.queryAll();
			if(datas!=null&&datas.size()>0){
				StringBuffer sb = new StringBuffer("查询所有:\n");
				HashMap<String,Object>data =null;
				for(int i=0;i<datas.size();i++){
					data = datas.get(i);
					sb.append("ID:"+data.get("lmc_id")+" ");
					sb.append("Name:"+data.get("lmc_name")+" ");
					sb.append("Age:"+data.get("lmc_age")+" ");
					sb.append("Msg:"+data.get("lmc_msg")+"\n");
				}
				sb.append("共计:"+datas.size()+"条");
				Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
			}
		}else if(v.getId()==R.id.sqli_maxid){
			Toast.makeText(this,"最大ID:"+db.getMaxId(),Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.sqli_count){
			Toast.makeText(this,"数据库有"+db.count()+"条记录",Toast.LENGTH_SHORT).show();
		}
	}
}