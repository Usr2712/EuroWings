Feature: Flight booking



  @Euro
  @test1
  Scenario Outline: Verifiation of flight bookings

    Given User is on Eurowings website
    And user selects the airport for departure "<Departure>"
    And user selects the airport for destination "<Destination>"
    And Selects the Date for going "<Year>" and "<Month>" and "<Date>"
    And Selects the Date for return "<ReturnYear>" and "<ReturnMonth>" and "<ReturnDate>"
    Then Click on Search Flights


    Examples:
    |Departure|Destination |Year|Month|Date|ReturnYear|ReturnMonth|ReturnDate|
    |  London     |   Berlin         |2025|Nov|12   |2025|Dec       |23      |
    |  Edinburgh     |   Berlin         |2025|Oct|12   |2025|Oct       |27      |
