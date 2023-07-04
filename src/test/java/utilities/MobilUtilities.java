package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

import static utilities.MDriver.getMDriver;

public class MobilUtilities {
    public static TouchAction touchAction = new TouchAction(getMDriver());
    public static void scrollDown(){

        int screenHeight = MDriver.getMDriver().manage().window().getSize().getHeight();
        int screenWidth = MDriver.getMDriver().manage().window().getSize().getWidth();

        int startX = screenWidth/2;
        int startY = (int) (screenHeight * 0.7);
        int endY = (int) (screenHeight * 0.5);


        touchAction.press(PointOption.point(startX,startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(startX,endY)).release().perform();

    }



    public static void scrollDown(double y1 , double y2 , int duration){

        int screenHeight = MDriver.getMDriver().manage().window().getSize().getHeight();
        int screenWidth = MDriver.getMDriver().manage().window().getSize().getWidth();

        int startX = screenWidth/2;
        int startY = (int) (screenHeight * y1);
        int endY = (int) (screenHeight * y2);


        touchAction.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(startX,endY)).release().perform();

    }


    public static void scrollDownToElement(By element) {
        while (getMDriver().findElements(element).isEmpty()){
         scrollDown();


        }


    }





}
