package lmc.lonely.http;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
public class HttpImgFac {
	public static boolean upload(String url,String path){
		try{
			File img = new File(path);
			int pot = path.lastIndexOf(".");
			if(pot==-1){
				return false;
			}
			String ftype = path.substring(pot+1,path.length());
			if(img.exists()&&img.isFile()&&img.canRead()){
				HttpClient client = HttpApacheFac.getHttpClient();
				HttpPost post = new HttpPost(url+"?type=upload&ftype="+ftype);
				//import org.apache.http.entity.InputStreamEntity;
				//InputStreamEntity entity = new InputStreamEntity(new FileInputStream(img),-1);
				FileEntity entity = new FileEntity(img,"binary/octet-stream");
	            entity.setContentEncoding("binary/octet-stream");
	            entity.setChunked(true);
	            post.setEntity(entity);
	            HttpResponse resp = client.execute(post);
	            if(resp.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
	            	return true;
	            }else{
	            	post.abort();
	            }
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static boolean download(String url,String fName){
		try{
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setConnectTimeout(10000);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			if(conn.getResponseCode()==200){
				InputStream is = conn.getInputStream();
				if(is!=null){
					FileOutputStream fos = new FileOutputStream(fName);
					//import java.io.FileInputStream;
					/*byte[]data = new byte[1024];
					int len = 0;
					while((len=is.read(data))!=-1){
						fos.write(data,0,len);
					}
					fos.flush();
					fos.close();
					is.close();*/
					Bitmap bmp = BitmapFactory.decodeStream(is);
					if(fName.toLowerCase().equals(".png")){
						bmp.compress(Bitmap.CompressFormat.PNG,100,fos);
					}else{
						bmp.compress(Bitmap.CompressFormat.JPEG,100,fos);
					}
					fos.flush();
					fos.close();
					is.close();
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}