package com.ccniit.model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

	private final static String hostKey = "host";
	private final static String portKey = "port";

	public static void initializ(String configPath){
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(configPath));
			Properties p = new Properties();   
			p.load(in); 
			if(p.getProperty(hostKey)!=null){
				Constant.SERVER_HOST = p.getProperty(hostKey);
			}
			if(p.getProperty(portKey)!=null){
				int port = -1;
				try{
					port = Integer.parseInt(p.getProperty(portKey));
				}catch(Exception e){
					e.printStackTrace();
				}
				if(port>=1&&port<=65535){
					Constant.SERVER_PORT = port;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}

}
