package resources;

import java.util.ArrayList;

import pojo.Location;
import pojo.SerializationPayload;

public class TestDataBuild {

	public SerializationPayload AddplacePayload(String name, String Language, String Address)
	{
	SerializationPayload payload=new SerializationPayload();
	payload.setAccuracy(50);
	payload.setAddress(Address);
	payload.setLanguage(Language);
	payload.setName(name);
	payload.setPhone_number("(+91) 983 893 3937");
	payload.setWebsite("http://google.com");
	ArrayList<String> mylist=new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");
	payload.setTypes(mylist);
	Location l =new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	payload.setLocation(l);
	
	return payload;
}
	public String deleteplacepaylod(String Place_id) {
		return "{\r\n"
				+ "    \"place_id\":\""+Place_id+"\"\r\n"
				+ "}";
	}
}
