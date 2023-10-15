package calculator_auto_test;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class InputFields {

    AppiumDriver driver;

    public InputFields(AppiumDriver driver) {
        this.driver = driver;
    }

    //Метод ввода значений в первое поле
    void enterFirstField(String firstNumber) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.vbanthia.androidsampleapp:id/inputFieldLeft").sendKeys(firstNumber);
    }

    //Метод ввода значений во второе поле
    void enterSecondField(String secondNumber) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.vbanthia.androidsampleapp:id/inputFieldRight").sendKeys(secondNumber);
    }

    //Метод очищает первое поле от введенных данных
    void clearFirstField() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.vbanthia.androidsampleapp:id/inputFieldLeft").clear();
    }

    //Метод очищает второе поле от введенных данных
    void clearSecondField() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.vbanthia.androidsampleapp:id/inputFieldRight").clear();
    }

    //Метод сравнивает ожидаемое значение в первом поле с фактическим
    void checkResultFirstField(String expectedResult) {
        WebElement actualResult = driver.findElementById("com.vbanthia.androidsampleapp:id/inputFieldLeft");
        Assert.assertEquals(expectedResult, actualResult.getText());
    }

    //Метод сравнивает ожидаемое значение во втором поле с фактическим
    void checkResultSecondField(String expectedResult) {
        WebElement actualResult = driver.findElementById("com.vbanthia.androidsampleapp:id/inputFieldRight");
        Assert.assertEquals(expectedResult, actualResult.getText());
    }
}
