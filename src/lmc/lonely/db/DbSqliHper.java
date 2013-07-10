package lmc.lonely.db;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import lmc.lonely.SysArgs;
public class DbSqliHper{
	private SQLiteDatabase db = null;
	public DbSqliHper(Context con) {
		db = con.openOrCreateDatabase(SysArgs.dbName,0,null);
	}
	public void close(){
		db.close();
	}
	public boolean create(){
		try{
			db.execSQL("create table if not exists lmc("
	                +"lmc_id integer primary key autoincrement,"
	                +"lmc_name varchar(30),"
	                +"lmc_age integer,"
	                +"lmc_msg varchar(100) not null);");
			 return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
    }
    public boolean drop(){
    	try{
    		db.execSQL("drop table if exists lmc");
    		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
    }
    public int insert(String name,int age,String msg){
    	try{
    		db.execSQL("insert into lmc values(null,'"+name+"','"+age+"','"+msg+"')");
    		return this.getMaxId();
        }catch(Exception e){
        	e.printStackTrace();
        	return -1;
        }
    }
    public boolean delete(int id){
    	if(id==-1){
    		return false;
    	}
		try{
    		db.execSQL("delete from lmc where lmc_id="+id);
    		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
    }
    public boolean update(int id,String name,int age,String msg){
    	if(id==-1){
    		return false;
    	}
    	try{
    		db.execSQL("update lmc set lmc_name='"+name+"',lmc_age='"+age+"',lmc_msg='"+msg+"' where lmc_id="+id);
    		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
    }
    public HashMap<String,Object>queryById(int id){
    	HashMap<String,Object>res = null;
    	try{
    		Cursor cur = db.query("lmc",new String[]{"lmc_name","lmc_age","lmc_msg"},"lmc_id="+id,null,null,null,null);
        	if(cur.getCount()>0){
        		res = new HashMap<String,Object>();
        		cur.moveToFirst();
    	    	res.put("lmc_name",cur.getString(0));
    	    	res.put("lmc_age",cur.getInt(1));
    	    	res.put("lmc_msg",cur.getString(2));
        	}
        	cur.close();
		}catch(Exception e){
			e.printStackTrace();
		}
    	return res;
    }
    public ArrayList<HashMap<String,Object>>queryAll(){
    	ArrayList<HashMap<String,Object>>res = null;
    	try{
    		Cursor cur = db.query("lmc",new String[]{"lmc_id","lmc_name","lmc_age","lmc_msg"},null,null,null,null,"lmc_id");
        	if(cur.getCount()>0){
        		res = new ArrayList<HashMap<String,Object>>();
        		HashMap<String,Object>data = null;
        		cur.moveToFirst();
        		while(!cur.isAfterLast()){
        	    	data = new HashMap<String,Object>();
        	    	data.put("lmc_id",cur.getInt(0));
        	    	data.put("lmc_name",cur.getString(1));
        	    	data.put("lmc_age",cur.getInt(2));
        	    	data.put("lmc_msg",cur.getString(3));
        	    	res.add(data);
        	    	cur.moveToNext(); 
        	    }
        	}
        	cur.close();
		}catch(Exception e){
			e.printStackTrace();
		}
    	return res;
    }
    public int getMaxId(){
    	try{
    		Cursor c = db.query("lmc",new String[]{"max(lmc_id)"},"lmc_id is not null and lmc_id>-1",null,null,null,null);
        	c.moveToFirst();
        	int max = c.getInt(0);
        	return max>0?max:-1;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
    }
    public int count(){
    	try{
    		Cursor cur = db.query("lmc",new String[]{"count(*)"},null,null,null,null,null);
        	cur.moveToFirst();
        	return cur.getInt(0);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
    }
}