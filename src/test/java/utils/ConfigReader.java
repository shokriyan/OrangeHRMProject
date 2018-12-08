package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	public ConfigReader() {

		String filePath = ConstanceClass.configFilePath;

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getUrl() {
		return prop.getProperty("url");
	}

	public long getImpWait() {
		String impWait = prop.getProperty("impwait");

		return Long.parseLong(impWait);
	}
	
	public long getLoadWait () {
		String loadWait = prop.getProperty("loadwait");
		return Long.parseLong(loadWait);
	}
	
	public String getChromePath() {
		return prop.getProperty("chromepath");
	}
	
	public String getFirePath() {
		return prop.getProperty("firefoxpath");
	}
	
	public String getExcelPath() {
		return prop.getProperty("excelFilePath");
	}

}
