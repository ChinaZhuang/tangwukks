package com.esunward.androidUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils{

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*
	public static String object2Json(Object obj){
		JSONObject jsonObjectFromMap = JSONObject
	}
	*/
    /**
     * json�ַ���ת��Ϊjava�Ķ���
     * @description ת��Ϊjson��ʵ����,��ʵ���൱��ֻ�ܰ�����8�ֻ�����������  byte��short��int��long��float��double��boolean��char  �Լ� 2�ֶ�����������  String��Date    Date���͵�Ĭ�ϸ�ʽ��������  yyyy-MM-dd HH:mm:ss
     * @param jsonStr
     * @param clazz
     * @return
     */
    public static <T>T jsonStringToEntity(String jsonStr,Class<T> clazz){
    	
    	List<Field>fieldList = ReflectionUtils.getFields(clazz);
    	
    	JSONObject json = null;
    	try {
    		T t = clazz.newInstance();
    		json = new JSONObject(jsonStr);
			
			for(Field field:fieldList){
				field.setAccessible(true);
				if("byte,short,int,long,float,double,boolean,char".contains(field.getType().toString())){
					field.set(t, json.get(field.getName()));
				}else if("class java.lang.String".equals(field.getType().toString())){
					String fieldValue = json.get(field.getName()).toString().equals("null")?null:json.get(field.getName()).toString();
					field.set(t, fieldValue);
				}
				else if("class java.util.Date".equals(field.getType().toString())){
					String fieldnameStr = json.get(field.getName()).toString();
					Date date = json.get(field.getName()).toString().equals("null")? null:sdf.parse(json.get(field.getName()).toString());
					if(date!=null)
						field.set(t, date);
				}
			}
			return t;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    }
    
    
    
    
    
    
    /***
     * json�ַ���תjava List
     * @param jsonStr  ԭ����json�ַ���
     * @param clazz  ���϶��������ŵ��ֽ����ļ�
     * @return  ��ȡһ�����϶���
     * @throws Exception
     */
	public static <T>List<T> jsonStringToList(String jsonStr,Class<T> clazz) throws Exception
    {
    	List<T>tList = new ArrayList<T>();
    	JSONArray jsonArray;
    	try {
    		jsonArray = new JSONArray(jsonStr);
			for(int i=0;i<jsonArray.length();i++){
				
				T t = jsonStringToEntity(jsonArray.getJSONObject(i).toString(),clazz);
				tList.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    	return tList;
    }
	
	
	  /**
     * ��һ��json�ַ���ת����List<Map<String,Object>>���ϵ���ʽ���
     * @param jsonStr
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T>List<Map<String,Object>> jsonStringToListMap(String jsonStr,Class<T>clazz)throws Exception{
    	
    	List<Map<String,Object>>newmapList = new ArrayList<Map<String,Object>>();
    	
    	JSONArray jsonArray;
    	try {
    		jsonArray = new JSONArray(jsonStr);
			for(int i=0;i<jsonArray.length();i++){
				T t = jsonStringToEntity(jsonArray.getJSONObject(i).toString(),clazz);
				Map<String,Object> newmap = ReflectionUtils.entity2HashMap(t);
				newmapList.add(newmap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    	return newmapList;
    }
}
