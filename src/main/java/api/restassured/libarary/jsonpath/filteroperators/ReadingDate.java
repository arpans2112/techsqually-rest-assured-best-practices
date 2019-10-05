package api.restassured.libarary.jsonpath.filteroperators;

import com.jayway.jsonpath.JsonPath;

import java.util.Date;

public class ReadingDate {

    public static void main(String[] args) {


        String json = "{\"date_as_long\" : 1411455611975}";


        /**
         *  Returns date in format
         * Tue Sep 23 02:00:11 CDT 2014
         * */
        Date date = JsonPath.parse(json).read("$['date_as_long']", Date.class);
        System.out.println(date);

    }
}
