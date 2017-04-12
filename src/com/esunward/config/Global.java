package com.esunward.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//��Ŀ��ȫ�ֱ�������
public class Global {
	
	public static String connectionJavaWebIp;
	
	public static String connectionJavaWebPort;
	
	public static String connectionUrlLocation;
	
	static{
		InputStream in = Global.class.getClassLoader().getResourceAsStream("inspectSystem.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			connectionJavaWebIp = prop.getProperty("connectionJavaWebIp");
			connectionJavaWebPort = prop.getProperty("connectionJavaWebPort");
			connectionUrlLocation = connectionJavaWebIp+":"+connectionJavaWebPort;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
