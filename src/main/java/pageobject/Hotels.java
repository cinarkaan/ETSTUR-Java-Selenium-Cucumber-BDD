package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class Hotels {

    WebDriver webDriver;
    Random random = new Random();

    @FindBy(how = How.ID, using = "selectedCountText")
    private WebElement count;

    public Hotels (WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void selectHotel (){
        int hotelCount = Integer.parseInt(count.getText());
        System.out.println("Hotel count : " + hotelCount);
        int selectedHotelNumber = random.nextInt(hotelCount - 1) + 1;
        webDriver.findElement(By.xpath("//*[@id='hotelList']/div["+selectedHotelNumber+"]")).click();
    }

}
