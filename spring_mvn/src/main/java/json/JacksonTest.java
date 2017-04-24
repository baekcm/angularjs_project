package json;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
	
	// Map => Json
	public void objectToJson() {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		ObjectMapper objMapper = new ObjectMapper();
		String json = "";
		
		try {
			
			hm.put("id", "baeckwind");
			hm.put("name", "πÈ√·∏∏");
			hm.put("phone", "010-7248-9201");
			
			json = objMapper.writeValueAsString(hm);
			System.out.println("json = "+ json);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Json => Map
	public void jsonToObject() {
		
		ObjectMapper objMapper = new ObjectMapper();
		HashMap<String, String> hm = new HashMap<String, String>();
		
		String json = "";
		
		try {
			
			json = "{\"Key1\":\"Value1\",\"Key2\":\"Value2\",\"Key3\":\"Value3\"}";
			System.out.println("json = "+ json);
			
			hm = objMapper.readValue(json, new TypeReference<HashMap<String, String>>(){});
			
			System.out.println("hm = "+ hm);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// List<Map> => Json
	public void listMapToJson() {
		
		ObjectMapper objMapper = new ObjectMapper();
		HashMap<String, String> hm = new HashMap<String, String>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		ArrayList<HashMap<String, String>> strList = new ArrayList<HashMap<String, String>>();
		
		String json = "";
		
		
		try {
			
			hm.put("id", "baeckwind");
			hm.put("name", "πÈ√·∏∏");
			hm.put("phone", "010-7248-9201");
			list.add(hm);
			
			// List<Map> => Json
			json = objMapper.writeValueAsString(list);
			
			System.out.println("json : "+ json);
			
			// Json => List<Map>
			strList = objMapper.readValue(json, new TypeReference<ArrayList<HashMap<String, String>>>(){});
			System.out.println("List<Map> : "+ strList);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		JacksonTest jt = new JacksonTest();
		jt.objectToJson();
		//jt.jsonToObject();
		jt.listMapToJson();
		
	}
	
}