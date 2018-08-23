# new feature
# Tags: optional

Feature: User could be logged in via email due to his role

Background:
  User navigates to Bravuz login page
  Given I am on Bravuz login page

  Scenario: Recruiter
    When I enter username as "recruiter@mail.com"
    And I enter password as "password"
    Then Login should pass

  Scenario: Admin
    When I enter username as "admin@mail.com"
    And I enter password as "password"
    Then Login should pass

  Scenario: Agent
    When I enter username as "agent@mail.com"
    And I enter password as "password"
    Then Login should pass