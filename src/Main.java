import java.util.*;

public class Main {

    public static void main(String[] args) {

        String sampleText =
                "POLICY NUMBER: P12345\n" +
                "DATE OF LOSS: 12/05/2024\n" +
                "LOCATION OF LOSS: New York\n" +
                "ESTIMATE AMOUNT: 12000\n" +
                "DESCRIPTION: Minor accident damage";

        Map<String, String> fields = FieldExtractor.extract(sampleText);

        ClaimResult result = Router.route(fields, sampleText);

        System.out.println(result.toJson());
    }
}

