package utils;

import static utils.Constants.FORMAT_FOR_SPLIT_TIMER;

public class TimerFormat {
    public static String getTimeFormat (String timeData){
        String arrayTime[] = timeData.split(FORMAT_FOR_SPLIT_TIMER);
        return arrayTime[0]+FORMAT_FOR_SPLIT_TIMER+arrayTime[1];
    }
}
