package lmc.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TimeUtils {
	public static final String TIP = "yyyyMM";
	public static final String SIM = "yyyy-MM-dd";
	public static final String COX = "yyyy-MM-dd HH:mm:ss";
	public static final String COM = "yyyyMMddHHmmss";
	private static SimpleDateFormat sdf = null;
	public static String getTime(String type){
		sdf = new SimpleDateFormat(type);
		return sdf.format(new Date());
	}
	public static Date getStrTime(String time,String type) throws Exception{
		sdf = new SimpleDateFormat(type);
		return sdf.parse(time);
	}
	public static String getStrFormat(int year,int month,int day){
		if(year>0&&month>0&&day>0){
			return String.format("%04d-%02d-%02d",year,month,day);
		}
		return null;
	}
}