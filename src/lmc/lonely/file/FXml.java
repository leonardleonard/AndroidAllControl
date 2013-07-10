package lmc.lonely.file;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import lmc.entity.Person;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.lonely.SysConts;
import lmc.utils.OtherUtils;
import lmc.utils.FXmlPullHelper;
import lmc.utils.FXmlSaxHelper;
public class FXml extends Activity implements OnClickListener {
	private String fName = null;
	private Button xml_dcreate = null;
	private Button xml_dread = null;
	private Button xml_dread2 = null;
	private Button xml_saxread = null;
	private Button xml_pullread = null;
	private TextView xml_res = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.file_xml);
        xml_dcreate = (Button) super.findViewById(R.id.xml_dcreate);
        xml_dread = (Button) super.findViewById(R.id.xml_dread);
        xml_dread2 = (Button) super.findViewById(R.id.xml_dread2);
        xml_saxread = (Button) super.findViewById(R.id.xml_saxread);
        xml_pullread = (Button) super.findViewById(R.id.xml_pullread);
        xml_res = (TextView) super.findViewById(R.id.xml_res);
        xml_dcreate.setOnClickListener(this);
        xml_dread.setOnClickListener(this);
        xml_dread2.setOnClickListener(this);
        xml_saxread.setOnClickListener(this);
        xml_pullread.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.xml_dcreate){
			try{
				fName = SysArgs.getAppHome()+OtherUtils.getLsh()+".xml";
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				Element address = doc.createElement("address");
				Element linker = doc.createElement("linker");
				Element name = doc.createElement(SysConts.datak[0][0]);
				name.appendChild(doc.createTextNode(SysConts.datak[0][1]));
				linker.appendChild(name);
				Element phone = doc.createElement(SysConts.datak[1][0]);
				phone.appendChild(doc.createTextNode(SysConts.datak[1][1]));
				linker.appendChild(phone);
				Element qq = doc.createElement(SysConts.datak[2][0]);
				qq.appendChild(doc.createTextNode(SysConts.datak[2][1]));
				linker.appendChild(qq);
				address.appendChild(linker);
				doc.appendChild(address);
				DOMSource sour = new DOMSource(doc);
				StreamResult res = new StreamResult(new File(fName));
				Transformer tf = TransformerFactory.newInstance().newTransformer();
				tf.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
				tf.transform(sour,res);
				xml_res.setText("Dom创建XML成功\n存于:"+fName);
			}catch(Exception e){
				xml_res.setText("Dom创建XML失败");
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.xml_dread){
			try{
				File dom = new File(fName);
				if(!dom.exists()){
					xml_res.setText("XML文件不存在");
					return;
				}
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(dom);
				NodeList nls = doc.getElementsByTagName("linker");
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<nls.getLength();i++){
					Element e = (Element)nls.item(i);
					sb.append("--开发者:"+e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue()+"\n");
					sb.append("--联系电话:"+e.getElementsByTagName("phone").item(0).getFirstChild().getNodeValue()+"\n");
					sb.append("--QQ:"+e.getElementsByTagName("qq").item(0).getFirstChild().getNodeValue()+"\n");
				}
				sb.deleteCharAt(sb.length()-1);
				xml_res.setText(sb.toString());
			}catch(Exception e){
				xml_res.setText("Dom解析XML失败!请确认XML文件已创建");
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.xml_dread2){
			try{
				InputStream is = this.getResources().openRawResource(R.raw.person);
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
				NodeList nls = doc.getDocumentElement().getElementsByTagName("person");
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<nls.getLength();i++){
					Element ele = (Element)nls.item(i);
					String id = ele.getAttribute("id");
					String name = null;
					String age = null;
					NodeList cnls = ele.getChildNodes();
					for(int j=0;j<cnls.getLength();j++){
						Node node = cnls.item(j);
						if(node.getNodeType()==Node.ELEMENT_NODE){
							if(node.getNodeName().equals("name")){
								name = node.getFirstChild().getNodeValue();
							}else if(node.getNodeName().equals("age")){
								age = node.getFirstChild().getNodeValue();
							}
						}
					}
					sb.append("Person[id="+id+",name="+name+",age="+age+"]\n");
				}
				sb.append("共"+nls.getLength()+"条记录");
				xml_res.setText(sb.toString());
			}catch(Exception e){
				xml_res.setText("Dom解析XML失败");
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.xml_saxread){
			try{
	        	InputStream is = this.getResources().openRawResource(R.raw.person);
	        	FXmlSaxHelper helper = new FXmlSaxHelper("person");
				SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
				parser.parse(is,helper);
	        	List<HashMap<String,String>>res = helper.getList();
	        	StringBuffer sb = new StringBuffer();
	        	for(HashMap<String,String>map:res){
	        		sb.append(map.toString()+"\n");
	        	}
	        	sb.append("共"+res.size()+"条记录");
	        	is.close();
	        	xml_res.setText(sb.toString());
			}catch(Exception e){
				xml_res.setText("Sax解析XML失败");
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.xml_pullread){
			try{
				InputStream is = this.getResources().openRawResource(R.raw.person);
				List<Person>res = FXmlPullHelper.parse(is,"UTF-8");
				StringBuffer sb = new StringBuffer();
				for(Person person:res){
					sb.append(person.toString()+"\n");
				}
				sb.append("共"+res.size()+"条记录");
				is.close();
				xml_res.setText(sb.toString());
			}catch(Exception e){
				xml_res.setText("Pull解析XML失败");
				e.printStackTrace();
			}
		}
	}
}