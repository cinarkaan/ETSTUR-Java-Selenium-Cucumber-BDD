package pageobject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReservationInformation {

    JavascriptExecutor javascriptExecutor;

    @FindBy(how = How.ID, using = "tb-name_0_0")
    private WebElement name;

    @FindBy(how = How.ID, using = "tb-surname_0_0")
    private WebElement surname;

    @FindBy(how = How.ID, using = "tb-email_0_0")
    private WebElement email;

    @FindBy(how = How.ID, using = "tb-birthdate_0_0")
    private WebElement birthdate;

    @FindBy(how = How.ID, using = "contactFormPhoneNumber-g1")
    private WebElement phone;

    @FindBy(how = How.ID, using = "tckn_0_0")
    private WebElement tckn;

    @FindBy(how = How.ID, using = "btn-preBook")
    private WebElement clickPersonnelData;

    @FindBy(how = How.XPATH , using = "//*[@id=\"heading-CREDITCARD\"]/span/button")
    private WebElement selectCard;

    @FindBy(how = How.ID, using = "creditCardOwnerName")
    private WebElement cardOwner;

    @FindBy(how = How.ID, using = "tb-creditCardNumber")
    private WebElement cardNumber;

    @FindBy(how = How.NAME, using = "creditCardValidMonth")
    private WebElement cardValidationMonth;

    @FindBy(how = How.NAME, using = "creditCardValidYear")
    private WebElement getCardValidationYear;

    @FindBy(how = How.NAME, using = "creditCardCVC")
    private WebElement cardCVC;

    public ReservationInformation (WebDriver webDriver,JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
        PageFactory.initElements(webDriver,this);
    }


    public void fillPersonalData(){
        javascriptExecutor.executeScript("document.querySelector(\"#cb-female_0_0\").click()");
        name.sendKeys("AAA");
        surname.sendKeys("AAA");
        email.sendKeys("aaa@gmail.com");
        birthdate.sendKeys("02031991");
        phone.sendKeys("536 444 87 44");
        tckn.sendKeys("");
        clickPersonnelData.click();
    }

    public void fillPayInformationAndComplete(){
        selectCard.click();
        cardOwner.sendKeys("AAAAA");
        cardNumber.sendKeys("4444 4484 5146 4848");
        Select selectDate = new Select(cardValidationMonth);
        selectDate.selectByValue("04");
        Select selectYear = new Select(getCardValidationYear);
        selectYear.selectByValue("25");
        cardCVC.sendKeys("727");
        javascriptExecutor.executeScript("document.querySelector(\"#serviceAggrement\").click()");
        javascriptExecutor.executeScript("document.querySelector(\"#checkboxesContent > div:nth-child(2) > label\").click()");
        System.out.println("-----TEST WAS SUCCESSFULLY FINISHED-----");
    }


}
