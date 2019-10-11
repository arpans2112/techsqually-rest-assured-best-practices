package api.jackson.bestPractices.serialization.jsonAnyGetter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.matchers.JUnitMatchers.containsString;

public class ClassObjectToJson {


    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect()
            throws JsonProcessingException {

        ExtendableBean bean = new ExtendableBean();
        bean.name = "My bean";
        bean.number = 10;
        bean.properties = new HashMap<>();
        bean.properties.put("attr2","val2");
        bean.properties.put("attr1","val1");

        /**Converting Class Object To Json*/
        String result = new ObjectMapper().writeValueAsString(bean);
        Assert.assertThat(result, containsString("val2"));
        Assert.assertThat(result, containsString("val1"));
    }

}
