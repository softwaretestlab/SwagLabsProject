package PropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    public static String PropFile(String PropName) throws IOException {

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/PropertiesFile/PropertiesName.properties");
        Properties property = new Properties();
        property.load(fs);
        return property.getProperty(PropName);
    }
    public static String TestDataPropFile(String PropName) throws IOException {

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/PropertiesFile/TestData.properties");
        Properties property = new Properties();
        property.load(fs);
        return property.getProperty(PropName);
    }
}