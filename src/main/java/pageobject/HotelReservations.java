package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HotelReservations {

    Random random = new Random();
    WebDriver webDriver;
    int selectedRoom;

    @FindBy(how = How.CLASS_NAME, using = "room-card")
    public List<WebElement> roomList;

    public HotelReservations (WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void getCurrentPage () {
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }
    }

    public void selectRandomRoom () {
        System.out.println("Room Size : " + roomList.size());
        selectedRoom = random.nextInt(roomList.size() - 1) + 1;
        selectedRoom += 3;
        System.out.println("Selected room : " + selectedRoom);
    }

    public void selectRoom () {
        roomList.get(selectedRoom - 3).findElement(By.xpath("//*[@id=\"hotelRoomList\"]/div["+selectedRoom+"]/div[3]/ul/li/div[2]/div/div[2]/a")).click();
    }

}
