package utilities.java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtils {

    public RegExpUtils() {
    }


    /**
     *
     * @return : List<String[]> : returns the list of all the groups found with the match
     * */
    public static List<String[]> getMatchGroupList(String text, String regExp) {

        List<String[]> res = new ArrayList<>();
        Pattern pattern = Pattern.compile(regExp, 42);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String[] s = new String[matchCount(text,regExp)];
            for (int i = 1; i < s.length; i++) {
                s[i - 1] = matcher.group(i);
            }
            res.add(s);
        }
        return res;
    }


    public static String replaceAll(String text, String regExp, String replcement){

        Pattern pattern = Pattern.compile(regExp,42);
        return pattern.matcher(text).replaceAll(replcement);

    }

    /**
     * @param regExp : passed the sub string that you want to find out in the given String
     * @param givenString : is the string in which you want to find out the sub string.
     * @return ArrayList<Integer></> that will return the list of start index of the all the sub string in a Given String
     *
     * */
    public static ArrayList<Integer> startIndexOfPatternMatch(String regExp, String givenString){

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(givenString);

        ArrayList<Integer> startIndexList = new ArrayList<>();
        while(matcher.find()){
            startIndexList.add(matcher.start());
        }
        return startIndexList;
    }

    /**
     * @param regExp : passed the sub string that you want to find out in the given String
     * @param givenString : is the string in which you want to find out the sub string.
     * @return ArrayList<Integer></> that will return the list of end index of the sub string in a Given String
     *
     * */
    public static ArrayList<Integer> endIndexOfPatternMatch(String regExp, String givenString){

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(givenString);
        ArrayList<Integer> endIndexList = new ArrayList<>();
        while(matcher.find()){
            endIndexList.add(matcher.end());
        }
        return endIndexList;
    }


    /**
    * @return the total number of matches of the regex in the givenString
    * */
    public static int matchCount(String givenString, String regExp){

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(givenString);
        int count = 0;
        while(matcher.find()) count++;
        return count;
    }

}
