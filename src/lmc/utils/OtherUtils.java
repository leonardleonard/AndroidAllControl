package lmc.utils;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import android.graphics.Color;
public class OtherUtils {
	public static ArrayList<String>getSdFile(String folder,String[]fms){
		ArrayList<String>res = new ArrayList<String>();
		File[]fs = null;
		File find = new File(folder);
		if(!find.exists()||find.isFile()){
			return res;
		}
		fs = find.listFiles();
		if(fs==null||fs.length<1){
			return res;
		}
		for(int i=0;i<fs.length;i++){
			if(fs[i].isFile()){
				String path = fs[i].getAbsolutePath();
				String end = path.toLowerCase();
				for(String fm:fms){
					if(end.endsWith(fm)){
						res.add(path);
						break;
					}
				}
			}else if(fs[i].isDirectory()){
				res.addAll(OtherUtils.getSdFile(fs[i].getAbsolutePath(),fms));
			}
		}
		return res;
	}
	public static String getLsh(){
		String res = UUID.randomUUID().toString();
		res = res.substring(res.length()-12).toUpperCase();
		return res;
	}
	public static int getColor(int r,int g,int b){
		return Color.rgb(r,g,b);
	}
}