package lmc.utils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import lmc.entity.Person;
public class FXmlPullHelper {
	public static List<Person>parse(InputStream is,String charSet){
		List<Person>res = null;
		Person person = null;
		try{
			XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
			parser.setInput(is,charSet);
			int type = parser.getEventType();
			while(type!=XmlPullParser.END_DOCUMENT){
				switch(type){
					case XmlPullParser.START_DOCUMENT:res = new ArrayList<Person>();break;
					case XmlPullParser.START_TAG:
						if(parser.getName().equals("person")){
							person = new Person();
							person.setId(Integer.parseInt(parser.getAttributeValue(0)));
						}else if(parser.getName().equals("name")){
							person.setName(parser.nextText());
						}else if(parser.getName().equals("age")){
							person.setAge(Integer.parseInt(parser.nextText()));
						}
						break;
					case XmlPullParser.END_TAG:
						if(parser.getName().equals("person")){
							res.add(person);
							person = null;
						}
						break;
					default:break;
				}
				type = parser.next();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
}