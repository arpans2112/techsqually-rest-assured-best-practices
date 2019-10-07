package test.utilities.file;


import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.file.PropertyFileActionsUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PropertyFileActionsUtilTest {



    @Test
    public void getPropertiesFileAsMapTest(){

      HashMap<String,String> actualproperties = PropertyFileActionsUtil.getPropertiesFileAsMap("test/api","default-api");

      HashMap<String,String> expectedData = new HashMap(){{

          put("resource.baseUrl","http://dummy.restapiexample.com");
          put("dummyapi.user.name","arpan");
          put("dummyapi.password","techsqually");

      }};

        Assert.assertEquals(actualproperties,expectedData);

    }


    @Test

    public void updatePropertiesTest() throws ConfigurationException {

        HashMap<String,String> updateData = new HashMap(){{
            put("dummyapi.user.name","saini");
        }};

        PropertyFileActionsUtil.updateProperties("test/api","default-api", updateData);

        HashMap<String,String> actualproperties = PropertyFileActionsUtil.getPropertiesFileAsMap("test/api","default-api");

        HashMap<String,String> expectedData = new HashMap(){{

            put("resource.baseUrl","http://dummy.restapiexample.com");
            put("dummyapi.user.name","saini");
            put("dummyapi.password","techsqually");

        }};

        Assert.assertEquals(actualproperties,expectedData);

        HashMap<String,String> revertData = new HashMap(){{
            put("dummyapi.user.name","arpan");
        }};

        PropertyFileActionsUtil.updateProperties("test/api","default-api", revertData);


    }


    @Test

    public void clearPropertiesTest() throws ConfigurationException {

        List<String> clearProperty = new ArrayList<>(Arrays.asList("dummyapi.user.name"));

        PropertyFileActionsUtil.clearProperties("test/api","default-api", clearProperty);

        HashMap<String,String> actualproperties = PropertyFileActionsUtil.getPropertiesFileAsMap("test/api","default-api");

        HashMap<String,String> expectedData = new HashMap(){{

            put("resource.baseUrl","http://dummy.restapiexample.com");
            put("dummyapi.password","techsqually");

        }};

        Assert.assertEquals(actualproperties,expectedData);

        updatePropertiesTest();

    }


}
