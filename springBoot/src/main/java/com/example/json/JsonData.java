package com.example.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.model.Emp;

public class JsonData {

	// json 파일 위치
	static String path = "D:\\workspace\\springBoot\\src\\main\\webapp\\json\\";
	
	public static String jsonData() {
		
		String data = "", temp = "";
		
        try {
        	File file = new File(path + "emp.json");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while((temp = br.readLine()) != null){
				data += temp + "\n";
			}
			//System.out.println("jsonData : "+ data);
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return data;
        
	}
	
	public static String jsonData2() throws ParseException {
		
		File file = new File(path + "emp2.json");
		JSONParser parser = new JSONParser();
		String data = "";
		
		try {

			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray empInfoArray = (JSONArray) jsonObject.get("emp");
			
			for(int i=0; i < empInfoArray.size(); i++){
                //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
                JSONObject empObject = (JSONObject) empInfoArray.get(i);
                data += empObject + "\n";
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
	
	public static String jsonData3() throws ParseException {
		
		File file = new File(path + "empTest.json");
		JSONParser parser = new JSONParser();
		String data = "";

		try {
			
			JSONArray jsonArr = (JSONArray) parser.parse(new FileReader(file));
			data = jsonArr.toJSONString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
	
	public static String jsonDataWrite(Emp emp) throws ParseException {
		
		String data = "";
		ObjectMapper objMapper = new ObjectMapper();
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
        try {
        	
        	hm.put("empno", emp.getEmpno());
			hm.put("ename", emp.getEname());
			hm.put("job", emp.getJob());
			hm.put("mgr", emp.getMgr());
			hm.put("hiredate", emp.getHiredate());
			hm.put("sal", emp.getSal());
			hm.put("comm", "");
			hm.put("deptno", emp.getDeptno());
			
			File file = new File(path + "empTest.json");
			
			JSONParser parser = new JSONParser();
			JSONArray jsonArr = (JSONArray) parser.parse(new FileReader(file));
			jsonArr.add(hm);
			
        	File wfile = new File(path + "empTest.json");
			BufferedWriter bw = new BufferedWriter(new FileWriter(wfile));
			
			data = objMapper.writeValueAsString(jsonArr);
			System.out.println("data : "+ data);
			
			bw.write(data);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return data;
        
	}
	
	public static String jsonDataUpdate(Emp emp) throws ParseException {
		
		String data = "";
		ObjectMapper objMapper = new ObjectMapper();
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
        try {
        	
        	hm.put("empno", emp.getEmpno());
			hm.put("ename", emp.getEname());
			hm.put("job", emp.getJob());
			hm.put("mgr", emp.getMgr());
			hm.put("hiredate", emp.getHiredate());
			hm.put("sal", emp.getSal());
			hm.put("comm", "");
			hm.put("deptno", emp.getDeptno());
			
			File file = new File(path + "empTest.json");
			
			JSONParser parser = new JSONParser();
			JSONArray jsonArr = (JSONArray) parser.parse(new FileReader(file));
			jsonArr.add(hm);
			
        	File wfile = new File(path + "empTest.json");
			BufferedWriter bw = new BufferedWriter(new FileWriter(wfile));
			
			data = objMapper.writeValueAsString(jsonArr);
			System.out.println("data : "+ data);
			
			bw.write(data);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return data;
        
	}
	
	
	public static void main(String[] args) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		ObjectMapper objMapper = new ObjectMapper();
		String data = "";
		
		try {
			//jsonDataWrite();
			
			hm.put("empno", "7999");
			hm.put("ename", "BAEKCM");
			hm.put("job", "DEVELOPER");
			hm.put("mgr", "7839");
			hm.put("hiredate", "1981-01-25");
			hm.put("sal", "4000");
			hm.put("comm", "");
			hm.put("deptno", "10");
			
			JSONArray jsonArr = new JSONArray();
			jsonArr.add(hm);
			
			data = objMapper.writeValueAsString(jsonArr);
			System.out.println("jsonArr.writeValueAsString() : "+ data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}