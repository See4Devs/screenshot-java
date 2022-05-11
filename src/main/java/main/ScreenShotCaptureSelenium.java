package main;
import java.io.IOException;
import services.UrlSelenium;
import org.openqa.selenium.WebDriver;

public class ScreenShotCaptureSelenium {
    static int screenshotNum=0;
    static WebDriver driver=null;
    public static void main(String[] args) throws IOException {
        UrlSelenium selenium = new UrlSelenium(0, null);
        selenium.initDriver();
        selenium.capture("https://www.google.com");
        selenium.capture("https://facebook.com");
        selenium.destroy();
      }
}