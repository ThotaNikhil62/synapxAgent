import java.util.*;

public class Router {

    public static ClaimResult route(Map<String,String> fields, String text) {

        List<String> missing = new ArrayList<>();

        String[] required = {
                "policyNumber",
                "incidentDate",
                "location",
                "estimatedDamage"
        };

        for(String r : required) {
            if(!fields.containsKey(r)) {
                missing.add(r);
            }
        }

        if(!missing.isEmpty()) {
            return new ClaimResult(fields, missing,
                    "Manual Review",
                    "Mandatory fields missing");
        }

        int damage = Integer.parseInt(fields.get("estimatedDamage"));

        if(damage < 25000) {
            return new ClaimResult(fields, missing,
                    "Fast Track",
                    "Damage below 25000");
        }

        String lower = text.toLowerCase();

        if(lower.contains("fraud") ||
           lower.contains("staged") ||
           lower.contains("inconsistent")) {

            return new ClaimResult(fields, missing,
                    "Investigation",
                    "Suspicious keywords detected");
        }

        if(lower.contains("injury")) {
            return new ClaimResult(fields, missing,
                    "Specialist Queue",
                    "Injury related claim");
        }

        return new ClaimResult(fields, missing,
                "Normal Queue",
                "Standard processing");
    }
}
