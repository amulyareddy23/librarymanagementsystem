Feature: Admin Book Services

  Background: 
    Given Admin is on login page
    When Admin gives "ammu@gmail.com", "Admin@123"
    Then Admin is logged in

  Scenario Outline: Admin is able to add the book
    Given Admin is adding book
    When Admin enters  <bookName>,<author>,<category>,<publisher>
    Then Book should be added

    Examples: 
      | bookName | author  | category      | publisher |
      | "maths"  | "karan" | "mathematics" | "goels"   |

  Scenario Outline: Admin is able to update the book
    Given Admin is updating book
    When Admin enters updated values <bId>, <bookName>,<author>,<category>,<publisher>
    Then Book will be updated

    Examples: 2
      | bId  | bookName | author  | category      | publisher |
      | 1802 | "maths"  | "mehta" | "mathematics" | "bakshi"  |

  Scenario Outline: Admin is able to remove the book
    Given Admin is deleting book
    When BookId is given <bId>
    Then Book is deleted

    Examples: 
      | bId  |
      | 2302 |

  Scenario Outline: Admin is able to issue the book
    Given Admin is in issue page
    When Bid and Uid are given <bId>, <uId>
    Then Book is issued successfully

    Examples: 
      | bId  | uId    |
      | 1802 | 100102 |
