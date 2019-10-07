package utilities.file;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertyFileActionsUtil {



    /**
    * @PREREQUISITE
    * Set Environment Variable : -Denv=devqe : to the environment in which you want to run your script
    * @param applicationName : is the name of the application/typeOfApplication for which you want to read the property file
    * @param resource : is the file name you want to read
    * @param isConf : if true : pass the absolute path of the file
    *                 if false : it will automatically find the path of the file
    *
    * */


    public static Properties read(String applicationName, String resource, boolean isConf){

        Properties properties = new Properties();
        String path = isConf ? resource : ResourceUtils.getResourceConfFilePath(applicationName,resource);

        try {
            properties.load(new StringReader(path));
        } catch (Exception ex) {
            System.out.println("Properties file not found: " + ex.toString());
            throw new RuntimeException(ex);
        }
        return properties;

    }


    public static HashMap<String,String> getPropertiesFileAsMap(String microServiceAppName, String fileName){
        ResourceUtils resourceUtils = new ResourceUtils();
        String completePath = resourceUtils.getResourceConfFilePath(microServiceAppName, fileName);
        Properties properties  = new Properties();
        File file = new File(completePath);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("There is no file found with name " + file);
        }

        HashMap<String,String> propertiesMap = new HashMap(properties);
        return propertiesMap;

    }

    public static Properties readFromAbsolutePath(String path) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(path));
            return props;
        } catch (Exception e) {
            System.out.println("Properties file not found: " + path);
            throw new RuntimeException(e);
        }
    }


    public static void updateProperties(String microServiceAppName, String fileName , Map<String, String> data) throws ConfigurationException {
        String completePath = ResourceUtils.getResourceConfFilePath(microServiceAppName, fileName);
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(new File(completePath));
        data.keySet().forEach(k -> propertiesConfiguration.setProperty(k, data.get(k)));
        propertiesConfiguration.save();
    }


    public static void clearProperties(String microServiceAppName, String fileName , List<String> keysList) throws ConfigurationException {
        String completePath = ResourceUtils.getResourceConfFilePath(microServiceAppName, fileName);
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(new File(completePath));
        keysList.forEach(propertiesConfiguration::clearProperty);
        propertiesConfiguration.save();
    }

}
