package utils;
import java.io.*;

import java.util.Properties;
public class ConfigReader {

	    private static Properties prop;

	    public static Properties readprop() {
	        prop = new Properties();
	        try {
	            FileInputStream fis = new FileInputStream("src/main/java/utils/Globaldata.properties");
	            prop.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return prop;
}
}
