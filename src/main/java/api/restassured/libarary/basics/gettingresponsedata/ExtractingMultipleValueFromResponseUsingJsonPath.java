package api.restassured.libarary.basics.gettingresponsedata;
import api.common.abstractapiutil.AbstractBaseZippopotamAPIUtil;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ExtractingMultipleValueFromResponseUsingJsonPath extends AbstractBaseZippopotamAPIUtil {


    /*
    *  JSON PATH BLOG:  JSON PATH REFERENCES
    *  https://blog.jayway.com/2013/04/12/whats-new-in-rest-assured-1-8/
    *  https://github.com/json-path/JsonPath
    * */


    @Test
    public void extractingMultipleValueFromResponseUsingJsonPath(){

       /**Getting Response as String*/


        String responseAsString =   given().
                                            spec(requestSpecification).log().all().
                                    when().
                                            get("us/90210").
                                    then().log().all().
                                            statusCode(200).
                                            contentType(ContentType.JSON).
                                            extract().body().asString();

        /**Getting Multiple Response from the Response and validating*/

        /* get direct Node*/


        JsonPath jsonPath = JsonPath.from(responseAsString);



        /**Returns the hashMap of String and Obect type of all root elements of the json*/
        Map<String,Object> data = jsonPath.get();

        /**Get the value as String from the Json*/
        String post_Code =  jsonPath.getString("'post code'");
        String country =  jsonPath.getString("country");
        String countryAbbreviation =  jsonPath.getString("'country abbreviation'");



        /** use of getList Method by passing json path that returns the list*/
        Map<String,String> firstPlacesData1  = (Map<String, String>) jsonPath.getList("places").get(0);
        System.out.println(firstPlacesData1);

        /**Use of getMap by passing the json path that returns the map*/
        Map<String,String> firstPlacesData2  =  jsonPath.getMap("places[0]");
        System.out.println(firstPlacesData2);


        /**You can set the root to specific element and then can move forward*/
        JsonPath placesMap = JsonPath.from(responseAsString).setRootPath("places");


        /**Returns the List all places(Hashmap)*/
        ArrayList<Object> pacesArrayList = placesMap.get();
        /**Get Element of First Map*/
        Map<String,String> firstPlacesData = (Map<String, String>) pacesArrayList.get(0);


        String placeName = firstPlacesData.get("place name");
        String longitude = firstPlacesData.get("longitude");
        String state = firstPlacesData.get("state");
        String stateAbbreviation = firstPlacesData.get("state abbreviation");
        String latitude = firstPlacesData.get("latitude");


        Assert.assertEquals(post_Code , "90210" );
        Assert.assertEquals(country , "United States" );
        Assert.assertEquals(countryAbbreviation , "US" );
        Assert.assertEquals(placeName , "Beverly Hills" );
        Assert.assertEquals(longitude , "-118.4065" );
        Assert.assertEquals(state , "California" );
        Assert.assertEquals(stateAbbreviation , "CA" );
        Assert.assertEquals(latitude , "34.0901" );

    }

}
