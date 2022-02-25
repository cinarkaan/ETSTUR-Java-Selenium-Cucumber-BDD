package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchHotels {

    JavascriptExecutor javascriptExecutor;
    WebDriver webDriver;
    String Url = "https://www.etstur.com/";

    @FindBy(how = How.XPATH, using = "//*[@id=\"tb-autocomplete\"]")
    private WebElement searchLocation;

    @FindBy(how = How.ID, using = "range-date")
    private WebElement rangeDate;

    @FindBy(how = How.CLASS_NAME, using = "sf-guests")
    private WebElement personCount;

    @FindBy(how = How.XPATH, using = "//*[@id=\"sf-hotelSearchForm\"]/div[2]/div/div[2]/button")
    private WebElement searchButton;

    public SearchHotels(WebDriver webDriver, JavascriptExecutor javascriptExecutor) {
        this.webDriver = webDriver;
        this.javascriptExecutor = javascriptExecutor;
        PageFactory.initElements(webDriver,this);
    }

    public void getUrl () {
        webDriver.get(Url);
        Assert.assertEquals("Tatil, Etstur'dan sorulur! | Etstur",webDriver.getTitle());
    }

    public void getHotelList() throws Exception {
        searchLocation.sendKeys("Antalya");
        Thread.sleep(250);
        javascriptExecutor.executeScript("document.querySelector(\"#sf-hotelSearchForm > div.col-lg-8.search-autocomplete-date-area.autocomplete-area > div > div:nth-child(1) > div > div.sf-suggestion-container > div > ul > li:nth-child(1)\").click()");
        rangeDate.click();
        javascriptExecutor.executeScript("document.querySelector(\"#sf-hotelSearchForm > div.col-lg-8.search-autocomplete-date-area.autocomplete-area > div > div:nth-child(2) > div.vue-daterange-picker > div.daterangepicker.dropdown-menu.ltr.show-calendar.openscenter.linked > div.calendars.row.no-gutters > div > div.drp-calendar.col.left > div > table > thead > tr > th.next.available\").click();");
        javascriptExecutor.executeScript("document.querySelector(\"#sf-hotelSearchForm > div.col-lg-8.search-autocomplete-date-area.autocomplete-area > div > div:nth-child(2) > div.vue-daterange-picker > div.daterangepicker.dropdown-menu.ltr.show-calendar.openscenter.linked > div.calendars.row.no-gutters > div > div.drp-calendar.col.left > div > table > tbody > tr:nth-child(4) > td:nth-child(1)\").click();");
        javascriptExecutor.executeScript("document.querySelector(\"#sf-hotelSearchForm > div.col-lg-8.search-autocomplete-date-area.autocomplete-area > div > div:nth-child(2) > div.vue-daterange-picker > div.daterangepicker.dropdown-menu.ltr.show-calendar.openscenter.linked > div.calendars.row.no-gutters > div > div.drp-calendar.col.left > div > table > tbody > tr:nth-child(4) > td:nth-child(7)\").click();");
        personCount.click();
        javascriptExecutor.executeScript("document.querySelector(\"#guestAdultSpinner > span:nth-child(1) > button\").click()");
        searchButton.click();
    }

}
