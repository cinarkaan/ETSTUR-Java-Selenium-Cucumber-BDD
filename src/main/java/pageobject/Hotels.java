package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class Hotels {
    
    Random random = new Random();

    @FindBy(how = How.ID, using = "selectedCountText")
    private WebElement count;

    @FindBy(how = How.CLASS_NAME, using = "hotelCardItem")
    private List<WebElement> hotels;

    public Hotels (WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
    }

    public void selectHotel (){
        int hotelCount = hotels.size();
        System.out.println("Hotel count : " + hotelCount);
        int selectedHotelNumber = random.nextInt(hotelCount - 1) + 1;
        System.out.println("Select Hotel Number : " + selectedHotelNumber);
        hotels.get(selectedHotelNumber).findElement(By.xpath("//*[@id=\"hotelList\"]/div["+selectedHotelNumber+"]/a/div/div/div[2]/div/div[2]/div[3]/ul/li[3]/i")).click();
    }

}
