package com.pb.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Read the Attribute files
public class ConfigManager {
	private static ConfigManager configManager;
	//properties.load(InputStream);
	private static Properties properties; 
	
	private ConfigManager(){
		String configFile="database.properties";
		properties=new Properties();
		InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager=new ConfigManager();
		}
		return configManager;
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
}
