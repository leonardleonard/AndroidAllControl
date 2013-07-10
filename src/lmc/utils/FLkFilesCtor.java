package lmc.utils;
import java.io.File;
import java.util.Comparator;
public class FLkFilesCtor implements Comparator<File> {
	@Override
    public int compare(File fOne, File fTwo) {
    	boolean f1Dir = fOne.isDirectory()?true:false;
    	boolean f2Dir = fTwo.isDirectory()?true:false;
    	if(f1Dir&&!f2Dir){
    		return -1;
    	}else if(!f1Dir&&f2Dir){
    		return 1;
    	}
    	String f1n = fOne.getName();
    	String f2n = fTwo.getName();
    	int f1Len = f1n.length();
    	int f2Len = f2n.length();
    	int shorter = f1Len>f2Len?f2Len:f1Len;
    	for(int i=0;i<shorter;i++){
    		if(f1n.charAt(i)>f2n.charAt(i)){
    			return 1;
    		}else if(f1n.charAt(i)<f2n.charAt(i)){
    			return -1;
    		}	
    	}
    	return f1Len>f2Len?1:0;
    }
}