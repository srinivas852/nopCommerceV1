package com.nopcommerceV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String basURL = pro.getProperty("basURL");
		return basURL;
	}
	
	public String getEmail()
	{
		String Email = pro.getProperty("Email");
		return Email;
	}
	
	public String getPassWord()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromPath()
	{
		String chrompath = pro.getProperty("chrompath");
		return chrompath;
	}
	
	public String getedgePath()
	{
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}




}
