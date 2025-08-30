package Utilities;

import org.openqa.selenium.*;
import stepDefs.BrowserDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Random;


import static org.testng.AssertJUnit.assertTrue;

public class ReusableMethods {


    public static String  FormatMonthToFullForm(String mn){

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
        TemporalAccessor parsed = parser.parse(mn);

        Month month = Month.from(parsed);
        String fullMonth = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);


        return fullMonth;
    }

    //Screenshots

    public static byte[] takesScreenshotAsByte() {
        byte[] screenshot = ((TakesScreenshot) BrowserDriver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public static File takesScreenshotAsFile() {
        File screenshot = ((TakesScreenshot) BrowserDriver.getWebDriver()).getScreenshotAs(OutputType.FILE);
        return screenshot;
    }

    public static String createRandomStringWithDateAndTime(int length) {
        String randomString = createRandomString(length);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddss");
        String FormattedNow = now.format(formatter);

        return randomString + FormattedNow;
    }

    public static String createRandomString(int length) {
        String alphabets = "abcdefghilmnopqrstuvwxxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabets.length());
            char randomChar = alphabets.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String createRandomNumbers(int size) {
        Random random = new Random();
        long randomNumber = Math.abs(random.nextLong());
        String randomString = Long.toString(randomNumber);
        return randomString.substring(0, size);
    }

    //Assertions

    public static void assertTrueExpectedTextContainsActualText(String expectedText, String actualText) {
        assertTrue("\n\n ******** ERROR ******** \n" +
                "\n NOT THE EXPECTED RESULT!! " + "\n EXPECTED : " + expectedText +
                "\n ACTUAL : " + actualText, actualText.contains(expectedText));
    }

    public static void assertTrueExpectedTextEqualsActualText(String expectedText, String actualText) {
        assertTrue("\n\n ******** ERROR ******** \n" +
                "\n NOT THE EXPECTED RESULT!! " + "\n EXPECTED : " + expectedText +
                "\n ACTUAL : " + actualText, actualText.equals(expectedText));
    }

// Scrolls


}