Feature: Tests for authorization

  Scenario Outline: Authorization (valid account)
    Given I am on menu page
    When I select region
    And I open Sign in pop-up
    And I enter Telephone: "<telephone>"
    And I enter Password: "<password>"
    And I click sign in
    Then I see authorized profile
      Examples:
        | telephone  | password |
        | 9999999321 | Papa19*

  Scenario Outline: Authorization ()
    Given I am on menu page
    When I select region
    And I open Sign in pop-up
    And I enter Telephone: "<telephone>"
    And I enter Password: "<password>"
    And I click sign in
    Then I see the error: "<error>", "<xpath>"
    Examples:
      | telephone    | password | error               | xpath |
      | ''           | ''       | 'Обязательное поле' | '//div[@class='_3fgi_ _2mqm3 _2BnI1']//div[1]//div[2]'
      | '9999999321' | ''       | 'Обязательное поле' | '//div[@class='_2-ZTr']'

  Scenario Outline : Restore password ()
    Given I am on menu page
    When I select region
    And I open Sign in pop-up
    And I click Restore password
    And I enter Telephone: "<telephone>"
    And I click Continue
    Then I see the confirmation page
    And I enter SmsCode: "<sms>"
    And I enter  New password:
    And I repeat password:
    And I click restore
    Then I see the Message: "<message>"


    Examples:
      | telephone   | sms   | message|
      | '9999999321'| '1111'  | 'You have successfully recovered the password'|

