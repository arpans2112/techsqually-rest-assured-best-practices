package utilities;

import jdk.nashorn.internal.runtime.regexp.RegExp;

public class EnvironmentNameTransformUtils {

    public EnvironmentNameTransformUtils() {
    }

   public static String clearName(String name){

       String envTails = "(?:qe|dev|sit|devqe|perf|e2e)";
       String separators = "(?:_|-|~)";
       String cleanEnvName = RegExpUtils.replaceAll(name,"^"+envTails + separators + "|" + separators + envTails + "$","");
       return RegExpUtils.replaceAll(cleanEnvName,"^~","");

   }
}
