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



