package test.utilities.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.file.RelativePathVariables;
import utilities.file.ResourceUtils;
import utilities.yaml.TopicMetaData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ResourceUtilsTest  {



    @Test
    public void readYamlResourceTest() throws IOException {



        TopicMetaData topicMetaData = ResourceUtils.readYamlResource("test/api", "createEmployee", TopicMetaData.class);

        /**Actual Values Read from yaml File*/
          Map<String,String> headers = topicMetaData.getHeaders();
          String body = topicMetaData.getDefaultBodyPath();
          String bodyKey = topicMetaData.getDefaultBodyPathKey();
          int partition = topicMetaData.getPartition();
          String schemaName = topicMetaData.getSchemaName();
          String serviceName = topicMetaData.getServiceName();

       /**Expected Data */

        Map<String,String> expectedHeaders = new HashMap<String, String>(){{
            put("Content-Type","application/json");
            put("Accept","application/json");
            put("requestType","GET");
            put("apiServer","default");
        }};

        String expecteddefaultBodyPath = "data/dummy/features/employee/createEmployee.json";
        String expectedserviceName = "/api/v1/create";

        Assert.assertEquals(headers,expectedHeaders);
        Assert.assertEquals(body , expecteddefaultBodyPath);
        Assert.assertEquals(bodyKey , null);
        Assert.assertEquals(serviceName , expectedserviceName);
        Assert.assertEquals(partition , 0);
        Assert.assertEquals(schemaName , null);

    }





}
