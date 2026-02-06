import java.io.*;

public class PdfReaderUtil {

    // simple placeholder reader (no libraries needed)
    public static String readFile(String path) {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            return "";
        }

        return sb.toString();
    }
}
