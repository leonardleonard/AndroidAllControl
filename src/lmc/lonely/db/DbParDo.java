package lmc.lonely.db;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
public class DbParDo extends Activity implements OnClickListener {
	
	private int id = 1;
	private SQLiteDatabase db = null;
	private Button par_createdb = null;
	private Button par_updatedb = null;
	private Button par_insert = null;
	private Button par_update = null;
	private Button par_select = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.db_par);
        DbParHper helper = new DbParHper(this,SysArgs.dbName);
		db = helper.getWritableDatabase();
        par_createdb = (Button) super.findViewById(R.id.par_createdb);
        par_updatedb = (Button) super.findViewById(R.id.par_updatedb);
        par_insert = (Button) super.findViewById(R.id.par_insert);
        par_update = (Button) super.findViewById(R.id.par_update);
        par_select = (Button) super.findViewById(R.id.par_select);
        par_createdb.setOnClickListener(this);
        par_updatedb.setOnClickListener(this);
        par_insert.setOnClickListener(this);
        par_update.setOnClickListener(this);
        par_select.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.par_createdb){
			DbParHper helper = new DbParHper(this,SysArgs.dbName);
			db = helper.getWritableDatabase();
		}else if(v.getId()==R.id.par_updatedb){
			DbParHper helper = new DbParHper(this,SysArgs.dbName,2);
			db = helper.getWritableDatabase();
		}else if(v.getId()==R.id.par_insert){
			ContentValues vals = new ContentValues();
			vals.put("id",id++);
			vals.put("name","lmc");
			db.insert("user",null,vals);
		}else if(v.getId()==R.id.par_update){
			ContentValues vals = new ContentValues();
			vals.put("name","loumanchao");
			db.update("user",vals,"id=?",new String[]{String.valueOf(--id)});
		}else if(v.getId()==R.id.par_select){
			Cursor cur = db.query("user",new String[]{"id","name"},"id>?",new String[]{"0"},null,null,null);
			StringBuffer sb = new StringBuffer();
			int count = 0;
			while(cur.moveToNext()){
				int id = cur.getInt(cur.getColumnIndex("id"));
				String name = cur.getString(cur.getColumnIndex("name"));
				sb.append("ID:"+id+" Name:"+name+"\n");
				count++;
			}
			sb.append("¹²"+count+"Ìõ¼ÇÂ¼");
			Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
		}
	}
}