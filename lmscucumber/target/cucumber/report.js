$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/parallel_project_workspace/lmscucumber/src/main/java/com/capgemini/lmscucumber/features/admin.feature");
formatter.feature({
  "line": 2,
  "name": "Admin is able to add,update,delete and issue books",
  "description": "",
  "id": "admin-is-able-to-add,update,delete-and-issue-books",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.before({
  "duration": 8898779700,
  "status": "passed"
});
formatter.before({
  "duration": 5648488500,
  "status": "passed"
});
formatter.before({
  "duration": 6929805799,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Admin is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Admin enters \"ammu@gmail.com\",\"Admin@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Login_page()"
});
formatter.result({
  "duration": 5131700100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ammu@gmail.com",
      "offset": 14
    },
    {
      "val": "Admin@123",
      "offset": 31
    }
  ],
  "location": "AdminSteps.admin_enters(String,String)"
});
formatter.result({
  "duration": 463587600,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "duration": 3015981700,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Admin should be able to update books",
  "description": "",
  "id": "admin-is-able-to-add,update,delete-and-issue-books;admin-should-be-able-to-update-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Admin is on updating book page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Admin enters values \"algebra\",\"ramanujan\",\"mathematics\",\"carous\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Book updated successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_updating_book_page()"
});
formatter.result({
  "duration": 5022859201,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "algebra",
      "offset": 21
    },
    {
      "val": "ramanujan",
      "offset": 31
    },
    {
      "val": "mathematics",
      "offset": 43
    },
    {
      "val": "carous",
      "offset": 57
    }
  ],
  "location": "AdminSteps.admin_enters_values(String,String,String,String)"
});
formatter.result({
  "duration": 3804701999,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_updated_successfully()"
});
formatter.result({
  "duration": 67098300,
  "status": "passed"
});
formatter.after({
  "duration": 60853200,
  "status": "passed"
});
formatter.after({
  "duration": 120233900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 14,
  "name": "Admin should be able to add books",
  "description": "",
  "id": "admin-is-able-to-add,update,delete-and-issue-books;admin-should-be-able-to-add-books",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 15,
  "name": "Admin is on adding book page",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Admin enters \u003cbookName\u003e,\u003cauthor\u003e,\u003ccategory\u003e,\u003cpublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "Book \u003cstatus\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "admin-is-able-to-add,update,delete-and-issue-books;admin-should-be-able-to-add-books;",
  "rows": [
    {
      "cells": [
        "bookName",
        "author",
        "category",
        "publisher",
        "status"
      ],
      "line": 20,
      "id": "admin-is-able-to-add,update,delete-and-issue-books;admin-should-be-able-to-add-books;;1"
    },
    {
      "cells": [
        "\"wings of fire\"",
        "\"Ramanujan\"",
        "\"Novels\"",
        "\"computing\"",
        "\"Record is inserted Successfully\""
      ],
      "line": 21,
      "id": "admin-is-able-to-add,update,delete-and-issue-books;admin-should-be-able-to-add-books;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5722032900,
  "status": "passed"
});
formatter.before({
  "duration": 5630940000,
  "status": "passed"
});
formatter.before({
  "duration": 6127991200,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Admin is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Admin enters \"ammu@gmail.com\",\"Admin@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Login_page()"
});
formatter.result({
  "duration": 5009547401,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ammu@gmail.com",
      "offset": 14
    },
    {
      "val": "Admin@123",
      "offset": 31
    }
  ],
  "location": "AdminSteps.admin_enters(String,String)"
});
formatter.result({
  "duration": 530579100,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "duration": 3006089101,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Admin should be able to add books",
  "description": "",
  "id": "admin-is-able-to-add,update,delete-and-issue-books;admin-should-be-able-to-add-books;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "Admin is on adding book page",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Admin enters \"wings of fire\",\"Ramanujan\",\"Novels\",\"computing\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "Book \"Record is inserted Successfully\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_adding_book_page()"
});
formatter.result({
  "duration": 5017036600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "wings of fire",
      "offset": 14
    },
    {
      "val": "Ramanujan",
      "offset": 30
    },
    {
      "val": "Novels",
      "offset": 42
    },
    {
      "val": "computing",
      "offset": 51
    }
  ],
  "location": "AdminSteps.admin_enters(String,String,String,String)"
});
formatter.result({
  "duration": 1607928700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Record is inserted Successfully",
      "offset": 6
    }
  ],
  "location": "AdminSteps.book(String)"
});
formatter.result({
  "duration": 7154199,
  "status": "passed"
});
formatter.after({
  "duration": 6873711499,
  "status": "passed"
});
formatter.after({
  "duration": 3068641800,
  "status": "passed"
});
formatter.before({
  "duration": 8702474900,
  "status": "passed"
});
formatter.before({
  "duration": 9520806099,
  "status": "passed"
});
formatter.before({
  "duration": 12088100201,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Admin is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Admin enters \"ammu@gmail.com\",\"Admin@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Login_page()"
});
formatter.result({
  "duration": 5018692599,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ammu@gmail.com",
      "offset": 14
    },
    {
      "val": "Admin@123",
      "offset": 31
    }
  ],
  "location": "AdminSteps.admin_enters(String,String)"
});
formatter.result({
  "duration": 528929200,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "duration": 3004371100,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Admin should be able to remove books",
  "description": "",
  "id": "admin-is-able-to-add,update,delete-and-issue-books;admin-should-be-able-to-remove-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "Admin is on removing book page",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "Admin enters 3502",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "Book  deleted successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_removing_book_page()"
});
formatter.result({
  "duration": 5016472000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3502",
      "offset": 13
    }
  ],
  "location": "AdminSteps.admin_enters(int)"
});
formatter.result({
  "duration": 1576904100,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_deleted_successfully()"
});
formatter.result({
  "duration": 5800201,
  "status": "passed"
});
formatter.after({
  "duration": 11779023300,
  "status": "passed"
});
formatter.after({
  "duration": 8164309499,
  "status": "passed"
});
formatter.before({
  "duration": 11021866600,
  "status": "passed"
});
formatter.before({
  "duration": 10219535500,
  "status": "passed"
});
formatter.before({
  "duration": 24934603800,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Admin is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Admin enters \"ammu@gmail.com\",\"Admin@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Admin should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_Login_page()"
});
formatter.result({
  "duration": 5026458299,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ammu@gmail.com",
      "offset": 14
    },
    {
      "val": "Admin@123",
      "offset": 31
    }
  ],
  "location": "AdminSteps.admin_enters(String,String)"
});
formatter.result({
  "duration": 729594900,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_logged_in()"
});
formatter.result({
  "duration": 3016192301,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Admin should be able to issue books",
  "description": "",
  "id": "admin-is-able-to-add,update,delete-and-issue-books;admin-should-be-able-to-issue-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 29,
  "name": "Admin is on issuing book page",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "Admin enters 100102,2902",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Book issued successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_issuing_book_page()"
});
formatter.result({
  "duration": 5107751300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100102",
      "offset": 13
    },
    {
      "val": "2902",
      "offset": 20
    }
  ],
  "location": "AdminSteps.admin_enters(int,int)"
});
formatter.result({
  "duration": 9415134100,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_issued_successfully()"
});
formatter.result({
  "duration": 2796643700,
  "status": "passed"
});
formatter.after({
  "duration": 10537353800,
  "status": "passed"
});
formatter.after({
  "duration": 409718699,
  "status": "passed"
});
});