package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    public JavascriptExecutor javascriptExecutor;

    private String Url = "https://www.etstur.com/";

    public Base (String key, String path) {
        System.setProperty(key, path);
    }

    public void after () {
        webDriver.quit();
    }

    public String getUrl () {
        return Url;
    }


}
