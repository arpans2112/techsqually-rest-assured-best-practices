package utilities.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;
import com.jayway.jsonpath.*;
import com.jayway.jsonpath.internal.JsonFormatter;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.junit.Assert;
import utilities.ValueTemplateUtil;
import utilities.java.RegExpUtils;

import java.io.IOException;
import java.util.*;

public class JsonUtil {


    private static final ObjectMapper  objectMapper = new ObjectMapper();


    private static DocumentContext parseJson(String json){

        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider()).mappingProvider(new JacksonMappingProvider()).build();
        return JsonPath.using(configuration).parse(json);

    }

    /**
     * Converting Json String into Class Object
     * */
    public static <T> T readJsonInClassObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);
        return objectMapper.readValue(json,clazz);
    }


    public static boolean isJsonPathExists(String json, String jsonPath){

        try {
            DocumentContext dc = JsonPath.using(Configuration.defaultConfiguration()).parse(json);
            dc.read(jsonPath, new Predicate[0]);
        } catch (PathNotFoundException var3) {
            return false;
        }
        return true;
    }


    public static String setJsonAttribute(String json, String jsonPath, Object value) {
        DocumentContext dc = parseJson(json);
        if (value == ValueTemplateUtil.TemplateAction.DELETE) {
            System.out.println("Going to delete: " + jsonPath);
            dc.delete(jsonPath, new Predicate[0]);
        } else if (value == ValueTemplateUtil.TemplateAction.DO_NOT_CHANGE) {
            System.out.println("Going to leave value as is: " + jsonPath);
        } else if (isJsonPathExists(json, jsonPath)) {
            System.out.println("Going to update: " + jsonPath + " value: " + (value == null ? "null" : value.toString()));
            dc.set(jsonPath, value, new Predicate[0]);
        } else {
            String[] elements = jsonPath.split("\\.");
            int i = 0;
            boolean delByMe = false;

            while(true) {
                while(true) {
                    if (i >= elements.length) {
                        dc.set(jsonPath, objectMapper.valueToTree(value), new Predicate[0]);
                        return dc.jsonString();
                    }

                    String path = String.join(".", (CharSequence[]) Arrays.copyOfRange(elements, 0, i + 1));
                    String pathPrev = i > 0 ? String.join(".", (CharSequence[])Arrays.copyOfRange(elements, 0, i)) : "$";
                    String[] e = (String[]) RegExpUtils.getMatchGroupList(elements[i], "(.*?)(?:\\[(\\d+)\\])?$").get(0);
                    if (isJsonPathExists(dc.jsonString(), path) && !delByMe) {
                        break;
                    }

                    System.out.println("Going to create: " + path);
                    if (e[1] == null) {
                        try {
                            if (getJsonValue(dc.jsonString(), pathPrev) instanceof NullNode) {
                                throw new InvalidModificationException("found null node");
                            }

                            dc.put(pathPrev, elements[i], objectMapper.createObjectNode(), new Predicate[0]);
                            break;
                        } catch (InvalidModificationException var11) {
                            dc.delete(pathPrev, new Predicate[0]);
                            delByMe = true;
                            --i;
                        }
                    } else {
                        if (isJsonPathExists(dc.jsonString(), pathPrev + "." + e[0]) && getJsonValue(dc.jsonString(), pathPrev + "." + e[0]) instanceof ArrayNode) {
                            dc.add(pathPrev + "." + e[0], objectMapper.createObjectNode(), new Predicate[0]);
                            break;
                        }

                        dc.put(pathPrev, e[0], objectMapper.createArrayNode(), new Predicate[0]);
                    }
                }

                ++i;
            }
        }

        return dc.jsonString();
    }


    public static <T> T getJsonValue(String json, String jsonPath) {
        Assert.assertTrue(isJsonPathExists(json, jsonPath));
        return parseJson(json).read(jsonPath, new Predicate[0]);
    }

    public static Map<String, List<Boolean>> compareJSONs(String json1, String json2) {

        return null;
    }


    public static Object convertType(Object value) {
        if (value instanceof TextNode) {
            return ((TextNode)value).asText();
        } else if (value instanceof IntNode) {
            return ((IntNode)value).asDouble();
        } else if (value instanceof DoubleNode) {
            return ((DoubleNode)value).asDouble();
        } else if (value instanceof LongNode) {
            return ((LongNode)value).asDouble();
        } else if (value instanceof BooleanNode) {
            return ((BooleanNode)value).asBoolean();
        } else {
            return value instanceof NullNode ? null : value;
        }
    }


    public static String convertMapToJsonString(Map<String, Object> map) {
        return JsonPath.using(Configuration.defaultConfiguration()).parse(map).jsonString();
    }


    public static String removeComments(String json) {
        return RegExpUtils.replaceAll(json, "((^|\\n)\\s*//[^\\n$]*)", "$2");
    }


    /**
     * Get Response as an Object
     *
     * */
    public static  Object readResponseAsObject(String jsonString){
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonString);
        return document;
    }


    /**
     * Get Response as an ReadContext
     *
     * */
    public static  ReadContext readResponseAsReadContext(String jsonString){
        ReadContext readContext = JsonPath.parse(jsonString);
        return readContext;
    }


    public static boolean isJsonStringprettify(String jsonString) {

        try {
             JsonFormatter.prettyPrint(jsonString);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String prettifyJson(String jsonString) {

        if (isJsonStringprettify(jsonString))
              return JsonFormatter.prettyPrint(jsonString);
        else{
            throw new RuntimeException(jsonString + " is not pritffyString");
        }
    }


}
