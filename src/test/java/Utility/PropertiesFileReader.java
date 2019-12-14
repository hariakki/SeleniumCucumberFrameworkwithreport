package Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileReader {

    public Properties getProperty() {
        FileInputStream inputStream = null;
        Properties properties= new Properties();
        try {
            properties.load(new FileInputStream("Config/browser-config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
