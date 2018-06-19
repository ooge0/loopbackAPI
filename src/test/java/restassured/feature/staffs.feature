Feature: Create Staff records and modify them

  Scenario: I create, delete several items and invoke parameters and work with them.
    When I ADD one staff item in background_first
    Given I check existing of the Staff list
    And I check response and it has StatusCode 200 and contentType: application/json
    And I print the Staff list
    Then I delete all records from the Staff list
    And I check that staff list and it contains 0 item
    And I check the Staff list and statusCode is 200
    And I ADD one staff record as Tony, Stark, hero
    And I ADD one staff item in background
    And I ADD 3 staffs items
      | first_name | last_name | staff_position |
      | Wonder     | Woman     | hero           |
      | Boba       | Fett      | actor          |
      | Luke       | Skywalker | actor          |
    And  I ADD one staff item in background_second
    And I check that list contains 6 items
    And I check that last request has statusCode: 200
    And I check that 3 record has name and it has next positon
      | first_name | last_name | staff_position |
      | Wonder     | Woman     | hero           |
    And I print the Staff list
    When I delete 1 and 2 item from DB
    Then I check that staff list contains 4 item
    And I check that last item has name and position
      | first_name | last_name | staff_position |
      | Wonder     | Woman     | hero           |



