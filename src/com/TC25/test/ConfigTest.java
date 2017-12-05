package com.TC25.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigTest {

	public static void main(String[] args) {
		
		try {
			Properties p = new Properties();
			File f = new File("config/config.properties");
			InputStream is = new FileInputStream(f);
			p.load(is);
			String driver =p.getProperty("DRIVER");
			String url =p.getProperty("URL");
			String user =p.getProperty("USER");
			String pwd =p.getProperty("PWD");
			System.out.println(driver+url+user+pwd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
