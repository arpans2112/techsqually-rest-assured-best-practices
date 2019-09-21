package utilitiesTests;

import utilities.file.ResourceUtils;
import utilities.yaml.TopicMetaData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class YamlReadingTest {

    private static String name;
    private static String topicName;
    private static String schemaName;
    private static int partition;
    private static Map<String, String> headers;
    private static String body;
    private static String schemaNameKey;
    private static String bodyKey;
    private static String serviceName;


    public static void main(String[] args) throws IOException {

        TopicMetaData topicMetaData = ResourceUtils.readYamlResource("dummy", "createEmployee", TopicMetaData.class);

        headers = topicMetaData.getHeaders();
        body = topicMetaData.getDefaultBodyPath();
        bodyKey = topicMetaData.getDefaultBodyPathKey();
        partition = topicMetaData.getPartition();
        schemaName = topicMetaData.getSchemaName();
        serviceName = topicMetaData.getServiceName();

        System.out.println(headers);
        System.out.println(body);
        System.out.println(bodyKey);
        System.out.println(partition);
        System.out.println(schemaName);
        System.out.println(serviceName);

    }

}
