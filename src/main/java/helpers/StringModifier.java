package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringModifier {
    public static String replaceNewLines(String str){
        return str.replace("\n", " ").replace("\r", " ").trim();
    }
    public static String getUniqueString(String str){
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}
