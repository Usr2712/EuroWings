Feature: Dropdown Field



  @DDtest0
  @test1
  Scenario: Working on Dropdown Field
    Given User opens application
    When User clicks on dropdown for catogeries



  @DDtest0
  @test1
  Scenario Outline: Working on Dropdown Field
    Given User opens application
    When User clicks on dropdown for "<catogeries>"
    Examples:
    |catogeries|
    | Beauty   |
    | Books    |



  @DDtest @test1
  Scenario: Working on Dropdown Field
    Given User opens application
    When User selects on dropdown :
      | Books |
      |Beauty|




