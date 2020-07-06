package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop = null;

	public ReadConfig() {

		File fs = new File(".//Configuration//config.properties");

		try {
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);

		} catch (Exception e) {
			System.out.println("File not exist and exception is :" + e.getMessage());
		}

	}

	public String getAppUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}

	public String getUserName() {
		String uname = prop.getProperty("username");
		return uname;
	}

	public String getUserPass() {
		String upass = prop.getProperty("password");
		return upass;
	}

	public String getChromePath() {
		String cromepath = prop.getProperty("crompath");
		return cromepath;
	}

	public String getIEPath() {
		String iepath = prop.getProperty("iepath");
		return iepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}

}