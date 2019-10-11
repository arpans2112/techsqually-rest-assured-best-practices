package api.jackson.bestPractices.serialization.jsonPropertyOrder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class MyBeanToJson {

    @Test
    public void whenSerializingUsingJsonGetter_thenCorrect()
            throws JsonProcessingException {

        MyBean bean = new MyBean(1,"BeanTest");


        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("BeanTest"));
        assertThat(result, containsString("1"));
    }

}
