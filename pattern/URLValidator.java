package pattern;

import java.util.regex.*;

public class URLValidator {
    public static void main(String[] args) {
        String[] testUrls = {
            "http://example.com",
            "https://www.example.com/path?query=123#fragment",
            "http://subdomain.example.co.uk",
            "ftp://example.com",
            "http://example",
            "https://",
            "http://192.168.1.1"
        };

        for (String url : testUrls) {
            System.out.println(url + " : " + isValidHttpUrl(url));
        }
    }

    public static boolean isValidHttpUrl(String url) {
        // Regular expression for validating HTTP/HTTPS URLs
        String regex = "^(http:\\/\\/|https:\\/\\/)?([\\w\\d\\-]+\\.)+[\\w\\d\\-]+(:\\d+)?(\\/\\S*)?$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        
        return matcher.matches();
    }
}

