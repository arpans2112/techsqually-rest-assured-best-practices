package api.restassured.libarary.basics.json;

import utilities.file.JsonUtil;

import static io.restassured.path.json.JsonPath.from;

public class Collect {

    public static void main(String[] args) {

        String jsonString = JsonUtil.readJsonFileAsString("jsons","books");


        /*
        *
        * First we get all the authors (store.book.author) and invoke the collect method on the resulting list with the closure { it.length() }. What it does is to call the length() method on each author in the list and returns the result to a new list. On this list we simply call the sum() method to sum all the length's. The end result is 53 a
        *
        * */

        System.out.println(from(jsonString).getInt("store.book.author.collect { it.length() }.sum()"));

/*
*
*
* */


    }



}

