import java.util.*;

public class ClaimResult {

    private Map<String,String> fields;
    private List<String> missing;
    private String route;
    private String reason;

    public ClaimResult(Map<String,String> f,
                       List<String> m,
                       String r,
                       String rs) {

        fields = f;
        missing = m;
        route = r;
        reason = rs;
    }

    public String toJson() {

        return "{\n" +
                "  \"extractedFields\": " + fields + ",\n" +
                "  \"missingFields\": " + missing + ",\n" +
                "  \"recommendedRoute\": \"" + route + "\",\n" +
                "  \"reasoning\": \"" + reason + "\"\n" +
                "}";
    }
}
