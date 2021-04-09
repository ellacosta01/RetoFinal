Feature: Login

  Scenario: Succesful Login
    Given the client is in the home page
    When he attempts to login with his credentials
      | 1 |
    Then he should see the Cart icon