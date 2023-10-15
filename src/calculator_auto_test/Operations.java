package calculator_auto_test;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Operations {

    AppiumDriver driver;

    public Operations(AppiumDriver driver) {
        this.driver = driver;
    }

    //Метод сложения значений
    void addition() {
        driver.findElementById("com.vbanthia.androidsampleapp:id/additionButton").click();
    }

    //Метод разницы значений
    void subtract() {
        driver.findElementById("com.vbanthia.androidsampleapp:id/subtractButton").click();
    }

    //Метод умножения значений
    void multiplication() {
        driver.findElementById("com.vbanthia.androidsampleapp:id/multiplicationButton").click();
    }

    //Метод деления значений
    void division() {
        driver.findElementById("com.vbanthia.androidsampleapp:id/divisionButton").click();
    }

    //Метод сброса
    void reset() {
        driver.findElementById("com.vbanthia.androidsampleapp:id/resetButton").click();
    }

    //Метод проверки отображения диалога
    void checkDialogExist() {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElementById("android:id/parentPanel");
            driver.findElementById("android:id/button1").click();
        } catch (NoSuchElementException e) {
            System.out.println("No dialog found.");
        }
    }

    //Метод сравнения результата в textView
    void resultOperation(String expectedResult) {
        WebElement actualResult = driver.findElementById("com.vbanthia.androidsampleapp:id/resultTextView");
        Assert.assertEquals(expectedResult, actualResult.getText());
    }
}
