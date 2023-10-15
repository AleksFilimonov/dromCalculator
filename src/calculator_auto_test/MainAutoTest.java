package calculator_auto_test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class MainAutoTest {

    private AppiumDriver driver;
    public InputFields inputFields;
    public Operations operations;


    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Huawei P30 Pro");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.vbanthia.androidsampleapp");
        capabilities.setCapability("appActivity", "com.vbanthia.androidsampleapp.MainActivity");
        capabilities.setCapability("app", "Users/aleksandrfilimonov/Desktop/JavaAppiumAutomation/DromCalculator/apk/app-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        inputFields = new InputFields(driver);
        operations = new Operations(driver);
        operations.checkDialogExist();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    //Проверим сумму двух целых чисел
    public void sumTwoIntegers() {
        inputFields.enterFirstField("50"); //находим и вводим значение в левое поле ввода
        inputFields.enterSecondField("100"); //находим и вводим значение в правое поле ввода
        operations.addition(); //выбираем операцию с числами
        operations.resultOperation("50.00 + 100.00 = 150.00"); //получаем результат из textView и сравниваем
    }

    @Test
    //Проверим сумму, где первое число дробное
    public void sumFirstFieldFraction() {
        inputFields.enterFirstField("50.25");
        inputFields.enterSecondField("15");
        operations.addition();
        operations.resultOperation("50.25 + 15.00 = 65.25");
    }

    @Test
    //Проверим сумму, где второе число дробное
    public void sumSecondFieldFraction() {
        inputFields.enterFirstField("95");
        inputFields.enterSecondField("0.13");
        operations.addition();
        operations.resultOperation("95.00 + 0.13 = 95.13");
    }

    @Test
    //Проверим сумму, где оба числа дробные
    public void sumTwoFieldsFractions() {
        inputFields.enterFirstField("0.01");
        inputFields.enterSecondField("100.98");
        operations.addition();
        operations.resultOperation("0.01 + 100.98 = 100.99");
    }

    @Test
    //Проверим сумму, где первое число 0
    public void sumFirstFieldZero() {
        inputFields.enterFirstField("0");
        inputFields.enterSecondField("100");
        operations.addition();
        operations.resultOperation("0.00 + 100.00 = 100.00");
    }

    @Test
    //Проверим сумму, где второе число 0
    public void sumSecondFieldZero() {
        inputFields.enterFirstField("25");
        inputFields.enterSecondField("0");
        operations.addition();
        operations.resultOperation("25.00 + 0.00 = 25.00");
    }

    @Test
    //Проверим сумму, где оба числа 0
    public void sumTwoFieldsZero() {
        inputFields.enterFirstField("0");
        inputFields.enterSecondField("0");
        operations.addition();
        operations.resultOperation("0.00 + 0.00 = 0.00");
    }

    @Test
    //Проверим суммирование отрицательных значений
    public void sumNegativeIntegers() {
        inputFields.enterFirstField("-20");
        inputFields.enterSecondField("-10");
        operations.addition();
        operations.resultOperation("-20.00 + -10.00 = -30.00");
    }

    @Test
    //Проверим разницу двух целых чисел
    public void subTwoIntegers() {
        inputFields.enterFirstField("5");
        inputFields.enterSecondField("2");
        operations.subtract();
        operations.resultOperation("5.00 - 2.00 = 3.00");
    }

    @Test
    //Проверим разницу, где первое число дробное
    public void subFirstFieldFraction() {
        inputFields.enterFirstField("9.25");
        inputFields.enterSecondField("1.00");
        operations.addition();
        operations.resultOperation("9.25 - 1.00 = 8.25");
    }

    @Test
    //Проверим разницу, где второе число дробное
    public void subSecondFieldFraction() {
        inputFields.enterFirstField("1500");
        inputFields.enterSecondField("125.25");
        operations.addition();
        operations.resultOperation("1500.00 - 125.25 = 1374.75");
    }

    @Test
    //Проверим разницу, где оба числа дробные
    public void subTwoFieldsFractions() {
        inputFields.enterFirstField("654321.85");
        inputFields.enterSecondField("123.10");
        operations.subtract();
        operations.resultOperation("654321.85 - 123.10  = 654198.75");
    }

    @Test
    //Проверим разницу, где первое число 0
    public void subFirstFieldZero() {
        inputFields.enterFirstField("0");
        inputFields.enterSecondField("120");
        operations.subtract();
        operations.resultOperation("0.00 - 120.00 = -120.00");
    }

    @Test
    //Проверим разницу, где второе число 0
    public void subSecondFieldZero() {
        inputFields.enterFirstField("25");
        inputFields.enterSecondField("0");
        operations.subtract();
        operations.resultOperation("25.00 - 0.00 = 25.00");
    }

    @Test
    //Проверим разницу, где оба числа 0
    public void subTwoFieldsZero() {
        inputFields.enterFirstField("0");
        inputFields.enterSecondField("0");
        operations.subtract();
        operations.resultOperation("0.00 - 0.00 = 0.00");
    }

    @Test
    //Проверим разницу отрицательных значений
    public void subNegativeIntegers() {
        inputFields.enterFirstField("-20");
        inputFields.enterSecondField("-10");
        operations.subtract();
        operations.resultOperation("-20.00 - -10.00 = -30.00");
    }

    @Test
    //Проверим умножение двух целых чисел
    public void multiplyTwoIntegers() {
        inputFields.enterFirstField("15");
        inputFields.enterSecondField("10");
        operations.multiplication();
        operations.resultOperation("15.00 * 10.00 = 150.00");
    }

    @Test
    //Проверим умножение, где первое число дробное
    public void multiplyFirstFieldFraction() {
        inputFields.enterFirstField("10.25");
        inputFields.enterSecondField("100");
        operations.multiplication();
        operations.resultOperation("10.25 * 100.00 = 1025.00");
    }

    @Test
    //Проверим умножение, где второе число дробное
    public void multiplySecondFieldFraction() {
        inputFields.enterFirstField("50");
        inputFields.enterSecondField("100.50");
        operations.multiplication();
        operations.resultOperation("50.00 * 100.50 = 5025.00");
    }

    @Test
    //Проверим умножение, где оба числа дробные
    public void multiplyTwoFieldFraction() {
        inputFields.enterFirstField("5.50");
        inputFields.enterSecondField("12.50");
        operations.multiplication();
        operations.resultOperation("5.50 * 12.50 = 68.75");
    }

    @Test
    //Проверим умножение, где первое число 0
    public void multiplyFirstFieldZero() {
        inputFields.enterFirstField("0");
        inputFields.enterSecondField("120");
        operations.multiplication();
        operations.resultOperation("0.00 * 120.00 = 0.00");
    }

    @Test
    //Проверим умножение, где второе число 0
    public void multiplySecondFieldZero() {
        inputFields.enterFirstField("25");
        inputFields.enterSecondField("0");
        operations.multiplication();
        operations.resultOperation("25.00 * 0.00 = 0.00");
    }

    @Test
    //Проверим умножение, где оба числа 0
    public void multiplyTwoFieldsZero() {
        inputFields.enterFirstField("0");
        inputFields.enterSecondField("0");
        operations.multiplication();
        operations.resultOperation("0.00 * 0.00 = 0.00");
    }

    @Test
    //Проверим умножение отрицательных значений
    public void multiplyNegativeIntegers() {
        inputFields.enterFirstField("-20");
        inputFields.enterSecondField("-10");
        operations.multiplication();
        operations.resultOperation("-20.00 * -10.00 = 200.00");
    }

    @Test
    //Проверим деление двух целых чисел
    public void divideTwoIntegers() {
        inputFields.enterFirstField("10");
        inputFields.enterSecondField("2");
        operations.division();
        operations.resultOperation("10.00 / 2.00 = 5.00");
    }

    @Test
    //Проверим деление, где первое число дробное
    public void divideFirstFieldFraction() {
        inputFields.enterFirstField("25.25");
        inputFields.enterSecondField("5");
        operations.division();
        operations.resultOperation("25.25 / 5.00 = 5.05");
    }

    @Test
    //Проверим деление, где второе число дробное
    public void divideSecondFieldFraction() {
        inputFields.enterFirstField("5");
        inputFields.enterSecondField("0.5");
        operations.division();
        operations.resultOperation("5.00 / 0.50 = 10.00");
    }

    @Test
    //Проверим деление, где оба числа дробные
    public void divideTwoFieldFraction() {
        inputFields.enterFirstField("80.4");
        inputFields.enterSecondField("20.1");
        operations.division();
        operations.resultOperation("80.40 / 20.10 = 4.00");
    }

    @Test
    //Проверим деление, где первое число 0
    public void divideFirstFieldZero() {
        inputFields.enterFirstField("0");
        inputFields.enterSecondField("120");
        operations.division();
        operations.resultOperation("0.00 / 120.00 = 0.00");
    }

    @Test
    //Проверим деление, где второе число 0
    public void divideSecondFieldZero() {
        inputFields.enterFirstField("25");
        inputFields.enterSecondField("0");
        operations.division();
        operations.resultOperation("25.00 / 0.00 = Ошибка");
    }

    @Test
    //Проверим деление, где оба числа 0
    public void divideTwoFieldsZero() {
        inputFields.enterFirstField("0");
        inputFields.enterSecondField("0");
        operations.division();
        operations.resultOperation("0.00 / 0.00 = Ошибка");
    }

    @Test
    //Проверим деление отрицательных значений
    public void divideNegativeIntegers() {
        inputFields.enterFirstField("-20");
        inputFields.enterSecondField("-10");
        operations.division();
        operations.resultOperation("-20.00 / -10.00 = 2.00");
    }

    @Test
    //Проверим ввод отрицательного числа в первое поле ввода
    public void negativeIntegerInputFirstField() {
        inputFields.enterFirstField("-20");
        inputFields.checkResultFirstField("-20");
    }

    @Test
    //Проверим ввод отрицательного числа во второе поле ввода
    public void negativeIntegerInputSecondField() {
        inputFields.enterSecondField("-10000");
        inputFields.checkResultSecondField("-10000");
    }

    @Test
    //Проверим сброс введенного значения в первом поле
    public void resetFirstInputField() {
        inputFields.enterFirstField("500000");
        operations.reset();
        inputFields.checkResultFirstField("");
    }

    @Test
    //Проверим сброс введенного значения во втором поле
    public void resetSecondInputField() {
        inputFields.enterSecondField("1234567890");
        operations.reset();
        inputFields.checkResultSecondField("");
    }

    @Test
    //Проверим сброс введенных значений в полях ввода
    public void resetInputFields() {
        inputFields.enterFirstField("1500");
        inputFields.enterSecondField("2000");
        operations.reset();
        inputFields.checkResultFirstField("");
        inputFields.checkResultSecondField("");
    }

    @Test
    //Проверим сброс результата в textView
    public void resetInResultView() {
        inputFields.enterFirstField("12000");
        inputFields.enterSecondField("9000");
        operations.addition();
        operations.reset();
        operations.resultOperation("");
    }

    @Test
    //Проверим отображение ошибки, когда первое поле пустое
    public void errorMessageEmptyFirstField() {
        inputFields.enterSecondField("230");
        operations.subtract();
        operations.resultOperation("Please, fill the input fields correctly");
    }

    @Test
    //Проверим отображение ошибки, когда второе поле пустое
    public void errorMessageEmptySecondField() {
        inputFields.enterFirstField("320");
        operations.division();
        operations.resultOperation("Please, fill the input fields correctly");
    }

    @Test
    //Проверим отображение ошибки, когда оба поля пустые
    public void errorMessageEmptyTwoField() {
        operations.multiplication();
        operations.resultOperation("Please, fill the input fields correctly");
    }

    @Test
    //Проверим сброс данных из исходного состояния
    public void resetWithoutChanges() {
        operations.reset();
        operations.resultOperation("");
    }

    @Test
    //Проверим правильность результата при изменении первого значения
    public void sumChangeFirstField() {
        inputFields.enterFirstField("20");
        inputFields.enterSecondField("10");
        inputFields.clearFirstField();
        inputFields.enterFirstField("10");
        operations.addition();
        operations.resultOperation("10.00 + 10.00 = 20.00");
    }

    @Test
    //Проверим правильность результата при изменении второго значения
    public void divideChangeSecondField() {
        inputFields.enterFirstField("10");
        inputFields.enterSecondField("20");
        inputFields.clearSecondField();
        inputFields.enterSecondField("10");
        operations.division();
        operations.resultOperation("10.00 / 10.00 = 1.00");
    }

    @Test
    //Проверим правильность результата при изменении двух полей
    public void multiplyChangeTwoFields() {
        inputFields.enterFirstField("10");
        inputFields.enterSecondField("20");
        inputFields.clearFirstField();
        inputFields.enterFirstField("20");
        inputFields.clearSecondField();
        inputFields.enterSecondField("10");
        operations.multiplication();
        operations.resultOperation("20.00 * 10.00 = 200.00");
    }

    @Test
    //Проверим изменение результата в textView при выборе другой операции
    public void changeOperationResultInTextView() {
        inputFields.enterFirstField("10");
        inputFields.enterSecondField("5");
        operations.addition();
        operations.resultOperation("10.00 + 5.00 = 15.00");
        operations.subtract();
        operations.resultOperation("10.00 - 5.00 = 5.00");
    }
}
