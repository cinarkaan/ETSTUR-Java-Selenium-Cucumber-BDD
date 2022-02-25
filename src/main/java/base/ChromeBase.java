package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Base;
import util.DriverManager;

public class ChromeBase extends Base implements DriverManager {

    public ChromeBase() {
        super("webdriver.chrome.driver","C:\\Users\\kaan-\\Documents\\ChromeDriver\\chromedriver.exe");
        initialize();
    }

    @Override
    public void initialize() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 15);
        javascriptExecutor = (JavascriptExecutor) webDriver;
    }
}
