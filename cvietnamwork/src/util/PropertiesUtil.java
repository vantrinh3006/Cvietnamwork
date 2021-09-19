package util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties readProperties() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();			// .currentThread() : lấy tại luồng hiện tại
		Properties properties = new Properties();
		try {
			properties.load(classLoader.getResourceAsStream("/config/database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
