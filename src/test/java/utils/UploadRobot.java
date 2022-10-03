package utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static utils.Constants.TIME_DELAY_FOR_ROBOT;

public class UploadRobot {
    public static void copyDate(String file) {
        StringSelection obj = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj,null);
    }

    public static void uploadFile(String filePath) {
        copyDate(filePath);
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        rb.delay(TIME_DELAY_FOR_ROBOT);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.delay(TIME_DELAY_FOR_ROBOT);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
