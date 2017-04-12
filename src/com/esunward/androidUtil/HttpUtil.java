package com.esunward.androidUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	
	/*OkHttpClient client = new OkHttpClient();
	Request request = new Request.Builder().url(url).build();
    Response response = client.newCall(request).execute();
    if (response.isSuccessful()) {
        return response.body().string();
    } else {
        throw new IOException("Unexpected code " + response);
    }*/

	/*
	//ʹ��okhttp��������
	public static String okHttpRequest(String url) throws IOException {
		
		String str = "";
		
		//����okHttpClient����
		OkHttpClient mOkHttpClient = new OkHttpClient();
		//����һ��Request
		final Request request = new Request.Builder()
		                .url("https://github.com/hongyangAndroid")
		                .build();
		//new call
		Call call = mOkHttpClient.newCall(request); 
		//����������
		call.enqueue(new Callback()
		        {

					@Override
					public void onFailure(Request arg0, IOException arg1) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onResponse(Response response) throws IOException {
						// TODO Auto-generated method stub
						String htmlStr =  response.body().string();
						System.out.println(htmlStr);
						htmlStr = htmlStr;
					}

					
		        });        
		return str;
	}
	*/
	
	
	
	/**
	 * android�����������http��post����
	 * @param requestUrl  ����ĵ�ַ
	 * @param jsonStr	�����json�ַ���
	 */
	public static String androidHttpPostRequest(String requestUrl,String jsonStr){
		//String strUrl = "http://127.0.0.1:8080/jeeplus/a/phoneLoginPost";
		String result = "";
		URL url = null;
		try {
			url = new URL(requestUrl);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setDoInput(true);
			urlConn.setDoOutput(true);
			urlConn.setRequestMethod("POST");
			urlConn.setUseCaches(false);
			urlConn.setRequestProperty("Content-Type", "application/x-www-fom-urlencoded");
			urlConn.setRequestProperty("Charset", "utf-8");
			
			urlConn.connect();
			
			DataOutputStream dop = new DataOutputStream(urlConn.getOutputStream());
			//dop.writeBytes("username="+URLEncoder.encode("xjy003","utf-8")+"&password"+URLEncoder.encode("123456","UTF-8"));		//���Ͳ���
			//dop.writeBytes("{username:'xjy003',password:'123456'}");
			dop.writeBytes(jsonStr);
			dop.flush();
			dop.close();
			
			//���濪ʼ�����յĹ���
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String readLine = null;
			while((readLine = bufferReader.readLine())!=null){
				result += readLine;
			}
			urlConn.disconnect();
			bufferReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * android����http�������������������ķ�ʽ��get����
	 * @param requestUrl  �����ַURL
	 * 
	 */
	public static String androidHttpGetRequest(String requestUrl){
		//String strUrl = "http://192.168.29.66:8080/jeeplus/a/phoneLogin"+suffix;
		URL url = null;
		try {
			url = new URL(requestUrl);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
				
			InputStreamReader in = new InputStreamReader(urlConn.getInputStream());
			BufferedReader reader = new BufferedReader(in);
			String result = "";
			String readLine = null;
			while((readLine = reader.readLine())!=null){
				result += readLine;
			}
			in.close();
			urlConn.disconnect();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	public static String startGet(String path){
        BufferedReader in = null;        
        StringBuilder result = new StringBuilder(); 
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            //Get������ҪDoOutPut
            conn.setDoOutput(false);
            conn.setDoInput(true);
            //�������ӳ�ʱʱ��Ͷ�ȡ��ʱʱ��
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //���ӷ�����  
            conn.connect();  
            // ȡ������������ʹ��Reader��ȡ  
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            
            System.out.println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //�ر�������
        finally{
            try{
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

	
	
}
