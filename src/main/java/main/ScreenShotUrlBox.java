package main;
import services.UrlBox;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ScreenShotUrlBox {
    // main method demos Example Usage
    public static void main(String[] args) {
        String urlboxKey = "OUSmbiW5EGLpoltN";
        String urlboxSecret = "181e38fab8974f8da1585223dbc71cd8";

        // Set request options
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("width", 1280);
        options.put("height", 1024);
        options.put("thumb_width", 240);
        options.put("full_page", "true");
        options.put("force", "false");

        // Create URL box object with API key and secret
        UrlBox urlbox = new UrlBox(urlboxKey, urlboxSecret);
        try {
            // Call generateUrl function of urlbox object
            String urlboxUrl = urlbox.generateUrl("https://draft.dev", options);
            // Now do something with urlboxUrl.. put in img tag, etc..
            System.out.println(urlboxUrl);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Problem with url encoding", ex);
        }
    }
}
