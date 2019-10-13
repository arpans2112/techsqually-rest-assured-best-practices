package utilities.file;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;

public class JsonUtil {

  private ObjectMapper mapper = new ObjectMapper();

    /**
     * @param : applicationFolderName (e.g dummy , google,jsons)
     * @param : FileName : "fileName without extension"
     * @return: returns the json as a string
     *
     * e.g : readJsonFileAsString("jsons" , "javainterviewpoint");
     *
     * */

    public static String readJsonFileAsString(String applicationFolderName, String FileName){

       String jsonFilePath = ResourceUtils.getResourceDataFilePath(applicationFolderName,FileName);

        try {

          return   FileUtils.readFileToString(new File(jsonFilePath) , "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There is File with name = " + jsonFilePath);
        }


    }


}
