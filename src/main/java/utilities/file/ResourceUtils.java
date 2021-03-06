package utilities.file;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ResourceUtils implements RelativePathVariables , FileExtensionType{

    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());



    public static String getResourceConfFilePath(String microServiceAppName, String fileName){

        String rootDirectory = DEFAULT_DIR_CONF_PROPERTIES+"/"+System.getProperty("env")+"/"+microServiceAppName;
        String _r = fileName + (fileName.endsWith(PROPERTY) ? "" : ".properties");
        String relativePath = getRelativeResourcePath(rootDirectory,_r);
        String completePath = getResourcePathAsString(relativePath);
        return completePath;
    }


    public static String getResourceDataFilePath(String microServiceAppName, String fileName){
        String rootDirector = DEFAULT_DIR_DATA_JSON_RESOURCE + "/" + microServiceAppName;
        String _r = fileName + (fileName.endsWith(JSON) ? "" : ".json");
        String relativePath = getRelativeResourcePath(rootDirector,_r);
        String completePath = getResourcePathAsString(relativePath);
        return completePath;
    }


    public static <T> T readYamlResource(String microServiceAppName, String fileName , Class<T> clazz) throws IOException {
          return YAML_MAPPER.readValue(new File(getResourceTopicFilePath(microServiceAppName,fileName)),clazz);
    }


    public static String getResourceTopicFilePath(String microServiceAppName, String fileName){

        String rootDirector = DEFAULT_DIR_TOPICS_YAML_RESOURCE + "/" + microServiceAppName;
        String _r = fileName + (fileName.endsWith(YAML) ? "" : ".yaml");
        String relativePath = getRelativeResourcePath(rootDirector,_r);
        String completePath = getResourcePathAsString(relativePath);
        return completePath;

    }

    /*
    * @path : String path : gives the path of the json file after the resource folder
    * @return: it returns the full path for that file
    *   e.g : getResourcePathAsString("data/dummy/features/employee/createEmployee.json");
    *         returns : D:\Automation_Project\techsqually-rest-assured-best-practices\target\classes\data\dummy\features\employee\createEmployee.json
    * */
    public static String getResourcePathAsString(String path){

       URL url = Optional.ofNullable(ResourceUtils.class.getClassLoader().getResource(path)).orElseThrow(() -> {
             return new RuntimeException("There is no resouece by path " + path);
        });

        try {
          return Paths.get(url.toURI()).toString();
        } catch (URISyntaxException e) {
            throw  new RuntimeException("Resource Reading exception " + path);
        }

    }



    /*
    * @param : rootDirectory : directory name that has some files in the project anywhere from where
    *                          you want to read the file
    *          resourceName : file name
    * @returns: String : path of the file from the rootdirectory till file name passed
    *
    * e.g :  getRelativeResourcePath("topics","createEmployee.yaml")
    *            -> you want to get the path of the createEmployee.yaml from topics folder
    *            then it returns a string "topics/dummy/features/employee/createEmployee.yaml";
    * */
    public static String getRelativeResourcePath(String rootDirectory, String resourceName){

        //It gets the list of all the file from the given root Directories and sub directories
        try {
            LinkedList<String> fileList = FileUtils.listFiles(new File(ResourceUtils.class.getClassLoader().getResource(rootDirectory).getPath()),(String[])null,true)
                    .stream().filter(file -> {
                        return file.getName().equalsIgnoreCase(resourceName);
            }).map(File::toURI).map(URI::getPath).collect(Collectors.toCollection(LinkedList::new));

            if (fileList.isEmpty()){
                throw new RuntimeException("File " + StringUtils.defaultIfEmpty(resourceName,"null/empty") + " is not found in the rootdirectory " + rootDirectory);
            }else if (fileList.size() > 1){
                throw  new RuntimeException("There are multiple files in the root directory " + rootDirectory + " with name " + resourceName );
            }else{

                return fileList.getFirst().substring(fileList.getFirst().indexOf(rootDirectory));
            }
        } catch (NullPointerException e) {
             throw new RuntimeException("Root Directory " + rootDirectory + "is not found");
        }

    }

}
