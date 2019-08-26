package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtils {

    public RegExpUtils() {
    }


    public static List<String[]> getMatches(String text, String regExp) {

        List<String[]> res = new ArrayList<>();
        Pattern pattern = Pattern.compile(regExp, 42);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String[] s = new String[matcher.groupCount()];
            for (int i = 1; i < matcher.groupCount(); i++) {
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
}
