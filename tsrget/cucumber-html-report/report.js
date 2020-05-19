$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/UserRegisteration.feature");
formatter.feature({
  "name": "User Registeration",
  "description": " I want to check that user can register in our e-commerce website.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User Registeration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "The User is On Home Page",
  "keyword": "Given "
});
formatter.step({
  "name": "User Click on Register Link text",
  "keyword": "When "
});
formatter.step({
  "name": "User Entered the \"\u003cFirstName\u003e\" , \"\u003cLastName\u003e\" , \"\u003cEmail\u003e\" ,\"\u003cPassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Registeration Result Page displayed",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "FirstName",
        "LastName",
        "Email",
        "Password"
      ]
    },
    {
      "cells": [
        "Mohamed",
        "Hamo",
        "Shehhk12773mmo@test.com",
        "123456789"
      ]
    },
    {
      "cells": [
        "Mohamed",
        "tokaaar",
        "Toky1gg23ggyaar@test.com",
        "123456789"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User Registeration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "The User is On Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.UserRegisteration.The_User_is_On_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Click on Register Link text",
  "keyword": "When "
});
formatter.match({
  "location": "steps.UserRegisteration.User_Click_on_Register_Link_text()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Entered the \"Mohamed\" , \"Hamo\" , \"Shehhk12773mmo@test.com\" ,\"123456789\"",
  "keyword": "And "
});
formatter.match({
  "location": "steps.UserRegisteration.user_Entered_the_Email(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Registeration Result Page displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.UserRegisteration.Registeration_Result_Page_displayed()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\r\n\tat steps.UserRegisteration.Registeration_Result_Page_displayed(UserRegisteration.java:55)\r\n\tat ✽.Registeration Result Page displayed(file:///C:/Users/Admin/Desktop/selenium/Oxygen%20Workspace/NopCommerce/src/test/java/features/UserRegisteration.feature:8)\r\n",
  "status": "pending"
});
formatter.scenario({
  "name": "User Registeration",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "The User is On Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.UserRegisteration.The_User_is_On_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Click on Register Link text",
  "keyword": "When "
});
formatter.match({
  "location": "steps.UserRegisteration.User_Click_on_Register_Link_text()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Entered the \"Mohamed\" , \"tokaaar\" , \"Toky1gg23ggyaar@test.com\" ,\"123456789\"",
  "keyword": "And "
});
formatter.match({
  "location": "steps.UserRegisteration.user_Entered_the_Email(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Registeration Result Page displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.UserRegisteration.Registeration_Result_Page_displayed()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\r\n\tat steps.UserRegisteration.Registeration_Result_Page_displayed(UserRegisteration.java:55)\r\n\tat ✽.Registeration Result Page displayed(file:///C:/Users/Admin/Desktop/selenium/Oxygen%20Workspace/NopCommerce/src/test/java/features/UserRegisteration.feature:8)\r\n",
  "status": "pending"
});
});