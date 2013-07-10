package lmc.lonely.http;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
public class HttpNetFac {
	private static final String CharSet = "UTF-8";
	public static String doPost(String url,HashMap<String,Object>argVals){
		String res = null;
		try{
			StringBuffer args = null;
			if(argVals!=null&&argVals.size()>0){
				args = new StringBuffer("?");
				for(Entry<String,Object>en:argVals.entrySet()){
					args.append(en.getKey()+"="+URLEncoder.encode(en.getValue().toString(),CharSet)+"&");
				}
			}
			if(args!=null){
				args.deleteCharAt(args.length()-1);
				url += args.toString();
			}
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setConnectTimeout(3000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			byte[]send = url.getBytes();
			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length",String.valueOf(send.length));
			conn.getOutputStream().write(send);
			if(conn.getResponseCode()==200){
				InputStream is = conn.getInputStream();
				if(is!=null){
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[]data = new byte[1024];
					int len = 0;
					while((len=is.read(data))!=-1){
						baos.write(data,0,len);
					}
					res = new String(baos.toByteArray(),CharSet);
					baos.close();
					is.close();
				}
			}
			conn.disconnect();
		}catch(Exception e){
			e.printStackTrace();
			return "«Î«Û“Ï≥£";
		}
		return res;
	}
}