package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

public class YamlReaderUtils {


    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());
    public YamlReaderUtils() {
    }

    public static <T> T readYamlResource(String path, Class<T> clazz) throws IOException {

        return YAML_MAPPER.readValue(path,clazz);

    }






}
