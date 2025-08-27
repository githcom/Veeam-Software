@storeAPI
Feature: Store via API

  Scenario: Verify getting inventory
    Given get store inventory
    Then verify inventory returned

  Scenario: Verify placing an order
    Given place an order
    Then verify order returned

  Scenario: Verify getting an order
    Given place an order
    When get an order
    Then verify order returned

  Scenario: Verify deleting an order
    Given place an order
    When delete an order







