package lmc.lonely.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
public class DbParHper extends SQLiteOpenHelper {
	private static int Version = 1;
	private Context con = null;
	public DbParHper(Context con, String dbName, CursorFactory fac, int ver) {
		super(con, dbName, fac, ver);
		this.con = con;
	}
	public DbParHper(Context con, String dbName, int ver) {
		this(con, dbName, null, ver);
		this.con = con;
	}
	public DbParHper(Context con, String dbName) {
		this(con,dbName,Version);
		this.con = con;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists user(id int,name varchar(20))");
		Toast.makeText(con,"创建数据库",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Toast.makeText(con,"更新数据库",Toast.LENGTH_SHORT).show();
	}
}