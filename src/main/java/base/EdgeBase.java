package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Base;
import util.DriverManager;

public class EdgeBase extends Base implements DriverManager {

    public EdgeBase () {
        super("webdriver.edge.driver","C:\\Users\\kaan-\\Documents\\EdgeDriver\\msedgedriver.exe");
        initialize();
    }

    @Override
    public void initialize() {
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 10);
        javascriptExecutor = (JavascriptExecutor) webDriver;
    }
}
