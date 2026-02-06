import java.util.*;
import java.util.regex.*;

public class FieldExtractor {

    public static Map<String, String> extract(String text) {

        Map<String, String> map = new HashMap<>();

        find(text, "POLICY NUMBER[:\\s]+(\\S+)", "policyNumber", map);
        find(text, "DATE OF LOSS[:\\s]+(.*)", "incidentDate", map);
        find(text, "LOCATION OF LOSS[:\\s]+(.*)", "location", map);
        find(text, "ESTIMATE AMOUNT[:\\s]+(\\d+)", "estimatedDamage", map);
        find(text, "DESCRIPTION[:\\s]+(.*)", "description", map);

        return map;
    }

    private static void find(String text, String regex, String key, Map<String,String> map) {

        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);

        if (m.find()) {
            map.put(key, m.group(1).trim());
        }
    }
}
