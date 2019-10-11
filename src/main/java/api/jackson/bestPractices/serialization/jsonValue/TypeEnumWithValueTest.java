package api.jackson.bestPractices.serialization.jsonValue;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TypeEnumWithValueTest {
   @Test
   public void whenSerializingUsingJsonValue_thenCorrectType1()
           throws JsonParseException, IOException {

       String enumAsString = new ObjectMapper()
               .writeValueAsString(TypeEnumWithValue.TYPE1);
       System.out.println(enumAsString);

       assertThat(enumAsString, is("\"Type A\""));
   }

    @Test
    public void whenSerializingUsingJsonValue_thenCorrectType2()
            throws JsonParseException, IOException {

        String enumAsString = new ObjectMapper()
                .writeValueAsString(TypeEnumWithValue.TYPE2);
        System.out.println(enumAsString);

        assertThat(enumAsString, is("\"Type 2\""));
    }

}
