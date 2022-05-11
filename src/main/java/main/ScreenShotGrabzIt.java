package main;

import it.grabz.grabzit.GrabzItClient;
import it.grabz.grabzit.parameters.ImageOptions;

public class ScreenShotGrabzIt {

    // main method demos Example Usage of GrabzIt
    public static void main(String[] args) throws Exception {
        GrabzItClient grabzIt = new GrabzItClient("ZjY1OGM5ZWNjNjMzNDVmNmI5ZTAwMTkzM2VkZTRhOTg=", "VD81XT8/Px1APxE/Px9KPz8/Bj9iPxQlAD8JPz8MKAY=");
        ImageOptions options = new ImageOptions();
        options.setBrowserHeight(1200);
        options.setBrowserWidth(1200);
        grabzIt.URLToImage("https://www.tesla.com", options);
        //Then call the Save or SaveTo method
        grabzIt.SaveTo("tesla-grabzIt.jpg");
    }
}
