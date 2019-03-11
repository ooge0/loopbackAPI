Feature: Interaction with Records model

  @record
  Scenario: I create, delete several records. Invoke parameters and work with them.
    Given I'm working with Records entity
    And I add new 'Record' and store id for each entity
      | recordIdItem | recordLabelItem | recordCreationDataItem | recordRelationItem | recordOwnerItem | recordStatusItem |
      | 1            | cola            | 10 Apr 2019            | restorans          | boss            | true             |
      | 2            | tv              | 11/12/2005             | apollo 2           | slayer          | false            |


  @staff
  Scenario: I create, delete Staff. Invoke parameters and work with them.
    Given I'm working with Staff entity
    Then I add new 'Staff' and store id for each entity
      | first_name | last_name | staff_position | starship |
      | Wonder     | Woman     | hero           | apollo 1 |
      | Boba       | Fett      | actor          | apollo 2 |
    Then I check that StatusCode is '200'
#    Then I check that contentType is 'application/json; charset=utf-8'
#    Then I check that SuccessCode is 'OPERATION_SUCCESS'
#  Then I checked that collection isn't empty



#    When I check an existed Records




#  @example
#  Scenario: I create, delete several records. Invoke parameters and work with them.
#    When I add one records item in background
#    Then I check existing of the Staff list
#    And I check response and it has StatusCode 200 and contentType: application/json
#    And I print the Staff list
#    Then I delete all records from the Staff list
#    And I check that staff list and it contains 0 item
#    And I check the Staff list and statusCode is 200
#    And I add one staff record as Tony, Stark, hero , apollo888
#    And I add one staff item in background
#    And I add staff records
#      | first_name | last_name | staff_position | starship |
#      | Wonder     | Woman     | hero           | apollo 1 |
#      | Boba       | Fett      | actor          | apollo 2 |
#      | Luke       | Skywalker | actor          | tuna 009 |
#    When I add one staff item in background
#    And I check that list contains 6 items
#    And I check that last request has statusCode: 200
#    And I check that '3' record has info and positon
#      | first_name | last_name | staff_position |
#      | Wonder     | Woman     | hero           |
#    And I print the Staff list
#    When I delete 1 and 2 item from DB
#    Then I check that staff list contains 4 item
#    And I check that 'last' item has name and position
#      | first_name | last_name | staff_position |
#      | Wonder     | Woman     | hero           |



