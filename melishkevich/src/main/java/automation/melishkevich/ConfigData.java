package automation.melishkevich;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigData {


	/*
	 *  That class provides static methods for getting values from Config and UI mapping files
	 */

	    public static String cfgFile = "./src/main/java/config.properties";
	    public static String uiMappingFile = "src/UIMapping.properties";
	// public static String dataBaseProperties = "way to db config file"
	    /*
	     *  Return value from .properties file
	     */
	    public static String getValueFromFile(String key, String fileName) throws IOException {
	        Properties p = new Properties();
	        // Create stream for reading from file
	        FileInputStream cfg = new FileInputStream(fileName);
	        // Load Properties from input stream
	        p.load(cfg);
	        cfg.close();

	        // Return value for the property
	        return(p.getProperty(key));
	    }


	    /*
	    *  Return value from config file.
	    *  Note, please, that returned value is String.
	    *  We should take care of value's type by himself when will use config data value in the test.
	    */
	    public static String getCfgValue(String key) throws IOException {

	        return(getValueFromFile(key, cfgFile));
	    }
}
