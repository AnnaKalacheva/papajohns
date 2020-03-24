Feature: Tests for authorization

  Scenario Outline: a new scenario Authorization
    Given I am on menu page
    When I select region
    And I open Sign in pop-up
    And I enter Telephone: "<telephone>"
    And I enter Password: "<password>"
    And I click sign in
    Then I see authorized profile
      @working
      Examples:
        | telephone  | password |
        | 9999999321 | Papa19*  |
      @not_working
      Examples:
        | telephone  | password |
        | 9999999322 | Papa191  |