package main;

import it.grabz.grabzit.GrabzItClient;
import it.grabz.grabzit.parameters.ImageOptions;

public class ScreenShotGrabzIt {

    // main method demos Example Usage of GrabzIt
    public static void main(String[] args) throws Exception {
        GrabzItClient grabzIt = new GrabzItClient("Your Application Key", "Your Application Secret");
        ImageOptions options = new ImageOptions();
        options.setBrowserHeight(1200);
        options.setBrowserWidth(1200);
        grabzIt.URLToImage("https://www.tesla.com", options);
        //Then call the Save or SaveTo method
        grabzIt.SaveTo("tesla-grabzIt.jpg");
    }
}
