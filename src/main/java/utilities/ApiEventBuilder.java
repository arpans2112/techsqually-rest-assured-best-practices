package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ApiEventBuilder {


    private static final String PATH_TOPIC_METADATA = "topics";
    private static final Logger logger = LoggerFactory.getLogger(ApiEventBuilder.class);
    private String name;
    private String topicName;
    private String schemaName;
    private int partition;
    private Map<String, String> headers;
    private String body;
    private String schemaNameKey ;
    private String bodyKey;
    private String serviceName;

    public ApiEventBuilder() {
    }


}
