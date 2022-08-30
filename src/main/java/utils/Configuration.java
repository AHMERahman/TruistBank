package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private static Properties properties;
	private static String defaultpath = "configuration/config.properties";

	public Configuration(String path) {
		if (path == null) {
			loadProperty(defaultpath);
		} else {
			loadProperty(path);
		}
	}

	private void loadProperty(String path) {
		properties = new Properties();
		try {
			InputStream iStream = new FileInputStream(path);
			properties.load(iStream);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public String getConfiguration(String key) {
		if (key != null) {
			return properties.getProperty(key);
		} else {
			return null;
		}

	}

}
