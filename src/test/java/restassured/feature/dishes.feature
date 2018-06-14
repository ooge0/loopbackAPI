Feature: Create some items and modify DB

  Scenario: I create, delete several items and invoke parameters and work with them.
    Given I check Dishes list
    And I print information about Dishes list
    Then I delete all dishes from the list and it contains 0 item
    And I check response of the statusCode is 200
    And I add one item as juce, 3, RUB
    And I check that list contains 1 items
    Then I add several dishes
      | name   | price | currency |
      | plum   | 1     | EU       |
      | tea    | 2     | USD      |
      | meat   | 3     | UAH      |
      | banana | 2     | USD      |

    And I check list after adding a new items and it contains 5 items
    And I check the statusCode is 200
    And I check that 1 st items has name, price and currency
      | juce | 3 | RUB |
    When I delete 3 and 4 item from the list
    Then I check that the list contains only 3 item
    When I add new dishes
      | name | price | currency |
      | bean | 3     | UAH      |
    And I check that final list contains 4 items