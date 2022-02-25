@HomePage
Feature: Reservation

  Scenario: Normal Reservation
    Given HomePage will be opened and search hotels
    When From that list will be selected a hotel
    And Select room from selected hotel
    Then Personnel data and pay information will be filled and complete reservation



