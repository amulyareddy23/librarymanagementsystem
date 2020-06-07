$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("admin.feature");
formatter.feature({
  "line": 1,
  "name": "Admin Book Services",
  "description": "",
  "id": "admin-book-services",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Admin is able to add the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Admin is adding book",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Admin enters  \u003cbookName\u003e,\u003cauthor\u003e,\u003ccategory\u003e,\u003cpublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Book should be added",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book;",
  "rows": [
    {
      "cells": [
        "bookName",
        "author",
        "category",
        "publisher"
      ],
      "line": 14,
      "id": "admin-book-services;admin-is-able-to-add-the-book;;1"
    },
    {
      "cells": [
        "\"maths\"",
        "\"karan\"",
        "\"mathematics\"",
        "\"goels\""
      ],
      "line": 15,
      "id": "admin-book-services;admin-is-able-to-add-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"ammu@gmail.com\", \"Admin@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 4117379700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ammu@gmail.com",
      "offset": 13
    },
    {
      "val": "Admin@123",
      "offset": 31
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 401139000,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 4774500,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Admin is able to add the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Admin is adding book",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Admin enters  \"maths\",\"karan\",\"mathematics\",\"goels\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Book should be added",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_adding_book()"
});
formatter.result({
  "duration": 45000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "maths",
      "offset": 15
    },
    {
      "val": "karan",
      "offset": 23
    },
    {
      "val": "mathematics",
      "offset": 31
    },
    {
      "val": "goels",
      "offset": 45
    }
  ],
  "location": "AdminSteps.admin_enters(String,String,String,String)"
});
formatter.result({
  "duration": 238882700,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_should_be_added()"
});
formatter.result({
  "duration": 599500,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 17,
  "name": "Admin is able to update the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Admin is updating book",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Admin enters updated values \u003cbId\u003e, \u003cbookName\u003e,\u003cauthor\u003e,\u003ccategory\u003e,\u003cpublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book will be updated",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book;",
  "rows": [
    {
      "cells": [
        "bId",
        "bookName",
        "author",
        "category",
        "publisher"
      ],
      "line": 23,
      "id": "admin-book-services;admin-is-able-to-update-the-book;;1"
    },
    {
      "cells": [
        "1802",
        "\"maths\"",
        "\"mehta\"",
        "\"mathematics\"",
        "\"bakshi\""
      ],
      "line": 24,
      "id": "admin-book-services;admin-is-able-to-update-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"ammu@gmail.com\", \"Admin@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 322277400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ammu@gmail.com",
      "offset": 13
    },
    {
      "val": "Admin@123",
      "offset": 31
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 3668000,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 12800,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Admin is able to update the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Admin is updating book",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Admin enters updated values 1802, \"maths\",\"mehta\",\"mathematics\",\"bakshi\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book will be updated",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_updating_book()"
});
formatter.result({
  "duration": 16000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1802",
      "offset": 28
    },
    {
      "val": "maths",
      "offset": 35
    },
    {
      "val": "mehta",
      "offset": 43
    },
    {
      "val": "mathematics",
      "offset": 51
    },
    {
      "val": "bakshi",
      "offset": 65
    }
  ],
  "location": "AdminSteps.admin_enters_updated_values(int,String,String,String,String)"
});
formatter.result({
  "duration": 30184800,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_will_be_updated()"
});
formatter.result({
  "duration": 33300,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Admin is able to remove the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-remove-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "Admin is deleting book",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "BookId is given \u003cbId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Book is deleted",
  "keyword": "Then "
});
formatter.examples({
  "line": 31,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-remove-the-book;",
  "rows": [
    {
      "cells": [
        "bId"
      ],
      "line": 32,
      "id": "admin-book-services;admin-is-able-to-remove-the-book;;1"
    },
    {
      "cells": [
        "2302"
      ],
      "line": 33,
      "id": "admin-book-services;admin-is-able-to-remove-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"ammu@gmail.com\", \"Admin@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 241921500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ammu@gmail.com",
      "offset": 13
    },
    {
      "val": "Admin@123",
      "offset": 31
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 2974800,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 16700,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Admin is able to remove the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-remove-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "Admin is deleting book",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "BookId is given 2302",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Book is deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_deleting_book()"
});
formatter.result({
  "duration": 14100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2302",
      "offset": 16
    }
  ],
  "location": "AdminSteps.bookid_is_given(int)"
});
formatter.result({
  "duration": 2355200,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_is_deleted()"
});
formatter.result({
  "duration": 1566400,
  "error_message": "org.opentest4j.AssertionFailedError: expected: \u003ctrue\u003e but was: \u003cfalse\u003e\r\n\tat org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:39)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:40)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:35)\r\n\tat org.junit.jupiter.api.Assertions.assertTrue(Assertions.java:162)\r\n\tat com.capgemini.librarymanagementsystemspringrest.stepdefinitions.AdminSteps.book_is_deleted(AdminSteps.java:94)\r\n\tat ✽.Then Book is deleted(admin.feature:29)\r\n",
  "status": "failed"
});
formatter.scenarioOutline({
  "line": 35,
  "name": "Admin is able to issue the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-issue-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 36,
  "name": "Admin is in issue page",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "Bid and Uid are given \u003cbId\u003e, \u003cuId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Book is issued successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 40,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-issue-the-book;",
  "rows": [
    {
      "cells": [
        "bId",
        "uId"
      ],
      "line": 41,
      "id": "admin-book-services;admin-is-able-to-issue-the-book;;1"
    },
    {
      "cells": [
        "1802",
        "100102"
      ],
      "line": 42,
      "id": "admin-book-services;admin-is-able-to-issue-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"ammu@gmail.com\", \"Admin@123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 219931600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ammu@gmail.com",
      "offset": 13
    },
    {
      "val": "Admin@123",
      "offset": 31
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 3506900,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 21700,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Admin is able to issue the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-issue-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 36,
  "name": "Admin is in issue page",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "Bid and Uid are given 1802, 100102",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Book is issued successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_in_issue_page()"
});
formatter.result({
  "duration": 38100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1802",
      "offset": 22
    },
    {
      "val": "100102",
      "offset": 28
    }
  ],
  "location": "AdminSteps.bid_and_Uid_are_given(int,int)"
});
formatter.result({
  "duration": 11142300,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_is_issued_successfully()"
});
formatter.result({
  "duration": 195500,
  "error_message": "org.opentest4j.AssertionFailedError: expected: \u003ctrue\u003e but was: \u003cfalse\u003e\r\n\tat org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:39)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:40)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:35)\r\n\tat org.junit.jupiter.api.Assertions.assertTrue(Assertions.java:162)\r\n\tat com.capgemini.librarymanagementsystemspringrest.stepdefinitions.AdminSteps.book_is_issued_successfully(AdminSteps.java:109)\r\n\tat ✽.Then Book is issued successfully(admin.feature:38)\r\n",
  "status": "failed"
});
formatter.uri("registration.feature");
formatter.feature({
  "line": 1,
  "name": "User Registration",
  "description": "",
  "id": "user-registration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "User Registration with given details",
  "description": "",
  "id": "user-registration;user-registration-with-given-details",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is on registration page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User enters \u003cfirstName\u003e, \u003clastName\u003e, \u003cemail\u003e, \u003cpassword\u003e, \u003cmobile\u003e, \u003crole\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User should be registered",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "user-registration;user-registration-with-given-details;",
  "rows": [
    {
      "cells": [
        "firstName",
        "lastName",
        "email",
        "password",
        "mobile",
        "role"
      ],
      "line": 9,
      "id": "user-registration;user-registration-with-given-details;;1"
    },
    {
      "cells": [
        "\"amulya\"",
        "\"bendhi\"",
        "\"amulya@gmail.com\"",
        "\"amulya@123\"",
        "9963917181",
        "\"student\""
      ],
      "line": 10,
      "id": "user-registration;user-registration-with-given-details;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "User Registration with given details",
  "description": "",
  "id": "user-registration;user-registration-with-given-details;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "User is on registration page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User enters \"amulya\", \"bendhi\", \"amulya@gmail.com\", \"amulya@123\", 9963917181, \"student\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User should be registered",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.user_is_on_registration_page()"
});
formatter.result({
  "duration": 434486000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "amulya",
      "offset": 13
    },
    {
      "val": "bendhi",
      "offset": 23
    },
    {
      "val": "amulya@gmail.com",
      "offset": 33
    },
    {
      "val": "amulya@123",
      "offset": 53
    },
    {
      "val": "9963917181",
      "offset": 66
    },
    {
      "val": "student",
      "offset": 79
    }
  ],
  "location": "Steps.user_enters(String,String,String,String,int,String)"
});
formatter.result({
  "duration": 737425000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_should_be_registered()"
});
formatter.result({
  "duration": 44200,
  "status": "passed"
});
formatter.uri("student.feature");
formatter.feature({
  "line": 1,
  "name": "Student Book Services",
  "description": "",
  "id": "student-book-services",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "User is able to request the book",
  "description": "",
  "id": "student-book-services;user-is-able-to-request-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Student is on request page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "BookId and UserId are given \u003cbId\u003e, \u003cuId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Book is Requested successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "student-book-services;user-is-able-to-request-the-book;",
  "rows": [
    {
      "cells": [
        "bId",
        "uId"
      ],
      "line": 14,
      "id": "student-book-services;user-is-able-to-request-the-book;;1"
    },
    {
      "cells": [
        "1802",
        "100102"
      ],
      "line": 15,
      "id": "student-book-services;user-is-able-to-request-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Student is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Student gives \"priya@gmail.com\", \"Priya@2323\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Student is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentSteps.student_is_on_login_page()"
});
formatter.result({
  "duration": 257429700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "priya@gmail.com",
      "offset": 15
    },
    {
      "val": "Priya@2323",
      "offset": 34
    }
  ],
  "location": "StudentSteps.student_gives(String,String)"
});
formatter.result({
  "duration": 20444000,
  "status": "passed"
});
formatter.match({
  "location": "StudentSteps.student_is_logged_in()"
});
formatter.result({
  "duration": 28400,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "User is able to request the book",
  "description": "",
  "id": "student-book-services;user-is-able-to-request-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Student is on request page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "BookId and UserId are given 1802, 100102",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Book is Requested successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentSteps.student_is_on_request_page()"
});
formatter.result({
  "duration": 23900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1802",
      "offset": 28
    },
    {
      "val": "100102",
      "offset": 34
    }
  ],
  "location": "StudentSteps.bookid_and_UserId_are_given(int,int)"
});
formatter.result({
  "duration": 7467200,
  "status": "passed"
});
formatter.match({
  "location": "StudentSteps.book_is_Requested_successfully()"
});
formatter.result({
  "duration": 214400,
  "error_message": "org.opentest4j.AssertionFailedError: expected: \u003ctrue\u003e but was: \u003cfalse\u003e\r\n\tat org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:39)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:40)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:35)\r\n\tat org.junit.jupiter.api.Assertions.assertTrue(Assertions.java:162)\r\n\tat com.capgemini.librarymanagementsystemspringrest.stepdefinitions.StudentSteps.book_is_Requested_successfully(StudentSteps.java:56)\r\n\tat ✽.Then Book is Requested successfully(student.feature:11)\r\n",
  "status": "failed"
});
formatter.scenarioOutline({
  "line": 17,
  "name": "User is able to return the book",
  "description": "",
  "id": "student-book-services;user-is-able-to-return-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Student is on return page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "bookId and userId are given \u003cbId\u003e, \u003cuId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book is returned successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "student-book-services;user-is-able-to-return-the-book;",
  "rows": [
    {
      "cells": [
        "bId",
        "uId"
      ],
      "line": 23,
      "id": "student-book-services;user-is-able-to-return-the-book;;1"
    },
    {
      "cells": [
        "1802",
        "100102"
      ],
      "line": 24,
      "id": "student-book-services;user-is-able-to-return-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Student is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Student gives \"priya@gmail.com\", \"Priya@2323\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Student is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentSteps.student_is_on_login_page()"
});
formatter.result({
  "duration": 211967500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "priya@gmail.com",
      "offset": 15
    },
    {
      "val": "Priya@2323",
      "offset": 34
    }
  ],
  "location": "StudentSteps.student_gives(String,String)"
});
formatter.result({
  "duration": 3703100,
  "status": "passed"
});
formatter.match({
  "location": "StudentSteps.student_is_logged_in()"
});
formatter.result({
  "duration": 13100,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "User is able to return the book",
  "description": "",
  "id": "student-book-services;user-is-able-to-return-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Student is on return page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "bookId and userId are given 1802, 100102",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book is returned successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentSteps.student_is_on_return_page()"
});
formatter.result({
  "duration": 25200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1802",
      "offset": 28
    },
    {
      "val": "100102",
      "offset": 34
    }
  ],
  "location": "StudentSteps.bookid_and_userId_are_given(int,int)"
});
formatter.result({
  "duration": 5724200,
  "status": "passed"
});
formatter.match({
  "location": "StudentSteps.book_is_returned_successfully()"
});
formatter.result({
  "duration": 413100,
  "error_message": "org.opentest4j.AssertionFailedError: expected: \u003ctrue\u003e but was: \u003cfalse\u003e\r\n\tat org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:39)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:40)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:35)\r\n\tat org.junit.jupiter.api.Assertions.assertTrue(Assertions.java:162)\r\n\tat com.capgemini.librarymanagementsystemspringrest.stepdefinitions.StudentSteps.book_is_returned_successfully(StudentSteps.java:71)\r\n\tat ✽.Then Book is returned successfully(student.feature:20)\r\n",
  "status": "failed"
});
});