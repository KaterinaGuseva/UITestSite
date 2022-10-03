package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class MyConfiguration {
    private static ISettingsFile environment = new JsonSettingsFile("testdata.json");

    public static String getUrl(){
       return environment.getValue("/default_url").toString();
    }

    public static String getEmail(){
        return environment.getValue("/email").toString();
    }

    public static String getDomain(){
        return environment.getValue("/domain").toString();
    }

    public static String getChooseDomain(){
        return environment.getValue("/choose_domain").toString();
    }

    public static String getUploadPhotoPath(){
        return environment.getValue("/upload_photo_name").toString();
    }

    public static String getExpectedTimeForTimer(){
        return environment.getValue("/expected_time_for_timer").toString();
    }
}
