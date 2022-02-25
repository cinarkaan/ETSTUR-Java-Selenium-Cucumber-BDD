package stepdefinations;

import base.BaseFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.HotelReservations;
import pageobject.Hotels;
import pageobject.ReservationInformation;
import pageobject.SearchHotels;
import util.Base;

public class Reservation {

    BaseFactory baseFactory = new BaseFactory();
    Base base;

    public Reservation () {
        base = baseFactory.getBase("Chrome");
    }

    @Given("HomePage will be opened and search hotels")
    public void homePage () throws Exception{
        SearchHotels searchHotels = new SearchHotels(base.webDriver,base.javascriptExecutor);
        searchHotels.getUrl();
        searchHotels.getHotelList();
    }

    @When("From that list will be selected a hotel")
    public void selectHotel () throws Exception{
        Hotels hotels = new Hotels(base.webDriver);
        Thread.sleep(2250);
        hotels.selectHotel();
    }

    @And("Select room from selected hotel")
    public void selectRoom () throws Exception{
        Thread.sleep(4300);
        HotelReservations hotelReservations = new HotelReservations(base.webDriver);
        hotelReservations.getCurrentPage();
        hotelReservations.selectRandomRoom();
        hotelReservations.selectRoom();
    }

    @Then("Personnel data and pay information will be filled and complete reservation")
    public void payAndGetReservation () throws Exception{
        ReservationInformation reservationInformation = new ReservationInformation(base.webDriver, base.javascriptExecutor);
        Thread.sleep(2400);
        reservationInformation.fillPersonalData();
        Thread.sleep(2500);
        reservationInformation.fillPayInformationAndComplete();
        base.after();
    }







}
