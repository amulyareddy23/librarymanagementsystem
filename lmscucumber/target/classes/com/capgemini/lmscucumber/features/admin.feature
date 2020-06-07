@admin
Feature: Admin is able to add,update,delete and issue books

  Background: 
    Given Admin is on Login page
    When Admin enters "ammu@gmail.com","Admin@123"
    Then Admin should be logged in

  Scenario: Admin should be able to update books
    Given Admin is on updating book page
    When Admin enters values "algebra","ramanujan","mathematics","carous"
    Then Book updated successfully

  Scenario Outline: Admin should be able to add books
    Given Admin is on adding book page
    When Admin enters <bookName>,<author>,<category>,<publisher>
    Then Book <status>

    Examples: 
      | bookName | author      | category     | publisher   | status               |
      | "wings of fire"  | "Ramanujan" | "Novels" | "computing" | "Record is inserted Successfully" |

  Scenario: Admin should be able to remove books
    Given Admin is on removing book page
    When Admin enters 3502
    Then Book  deleted successfully

  Scenario: Admin should be able to issue books
    Given Admin is on issuing book page
    When Admin enters 100102,2902
    Then Book issued successfully
