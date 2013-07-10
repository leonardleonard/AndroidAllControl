package lmc.utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class FXmlSaxHelper extends DefaultHandler {
	private HashMap<String,String>map = null;
	private List<HashMap<String,String>>list = null;
	private String currNode = null;
	private String currTag = null;
	private String currVal = null;
	public FXmlSaxHelper(String currNode) {
		this.currNode = currNode;
	}
	public List<HashMap<String,String>> getList() {
		return list;
	}
	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<HashMap<String,String>>();
	}
	@Override
	public void startElement(String uri, String locName, String preName, Attributes attrs) throws SAXException {
		if(preName.equals(currNode)){
			map = new HashMap<String,String>();
		}
		if(attrs!=null&&map!=null){
			for(int i=0;i<attrs.getLength();i++){
				map.put(attrs.getQName(i),attrs.getValue(i));
			}
		}
		currTag = preName;
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(currTag!=null&&map!=null){
			currVal = new String(ch,start,length);
			if(currVal!=null&&!currVal.trim().equals("")&&!currVal.trim().equals("\n")){
				map.put(currTag,currVal);
			}
		}
		currTag = null;
		currVal = null;
	}
	@Override
	public void endElement(String uri, String locName, String qName) throws SAXException {
		if(qName.equals(currNode)){
			list.add(map);
			map = null;
		}
		super.endElement(uri, locName, qName);
	}
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}
}