$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("deals.feature");
formatter.feature({
  "line": 1,
  "name": "Check the deals page",
  "description": "",
  "id": "check-the-deals-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 13943028700,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Accessing deals",
  "description": "",
  "id": "check-the-deals-page;accessing-deals",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am on CIMB page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I select CIMB Deals",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I would like to explore more for \"Dorsett Grand Subang\" under Travel \u0026 Fun",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I will be able to see its details and other similar deals",
  "keyword": "Then "
});
formatter.match({
  "location": "DealsPageDef.I_am_on_CIMB_page()"
});
formatter.result({
  "duration": 4723547100,
  "status": "passed"
});
formatter.match({
  "location": "DealsPageDef.I_select_CIMB_Deals()"
});
formatter.result({
  "duration": 14175584400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dorsett Grand Subang",
      "offset": 34
    }
  ],
  "location": "DealsPageDef.I_would_like_to_explore_more(String)"
});
formatter.result({
  "duration": 17374396000,
  "status": "passed"
});
formatter.match({
  "location": "DealsPageDef.I_will_be_able_to_see_its_details()"
});
formatter.result({
  "duration": 3622333700,
  "status": "passed"
});
formatter.after({
  "duration": 911253100,
  "status": "passed"
});
formatter.uri("propertycal.feature");
formatter.feature({
  "line": 1,
  "name": "Check the Property Affordability Calculator",
  "description": "",
  "id": "check-the-property-affordability-calculator",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 7,
  "name": "Accessing \u0026 using Property Affordability Calculator",
  "description": "",
  "id": "check-the-property-affordability-calculator;accessing-\u0026-using-property-affordability-calculator",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I access to Property Affordability Calculator",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I have inputted all necessary values as \"\u003cgrossmonthly\u003e\" \"\u003cmonthlynet\u003e\" \"\u003ctotalmonthly\u003e\" \"\u003cperiod\u003e\" \"\u003crate\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I will be able to know the \"\u003cestimated monthly payment\u003e\" and \"\u003cmaximum loan amount\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I will see Credit Card Payment Calculator, Auto Financing Affordability Calculator and Property Monthly Installment Calculator at the bottom",
  "keyword": "And "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "check-the-property-affordability-calculator;accessing-\u0026-using-property-affordability-calculator;",
  "rows": [
    {
      "cells": [
        "grossmonthly",
        "monthlynet",
        "totalmonthly",
        "period",
        "rate",
        "estimated monthly payment",
        "maximum loan amount"
      ],
      "line": 16,
      "id": "check-the-property-affordability-calculator;accessing-\u0026-using-property-affordability-calculator;;1"
    },
    {
      "cells": [
        "1000000",
        "800000",
        "500000",
        "5",
        "800",
        "2,189.85",
        "108,000.00"
      ],
      "line": 17,
      "id": "check-the-property-affordability-calculator;accessing-\u0026-using-property-affordability-calculator;;2"
    },
    {
      "cells": [
        "",
        "1000000",
        "4000",
        "9",
        "20",
        "0.00",
        "0.00"
      ],
      "line": 18,
      "id": "check-the-property-affordability-calculator;accessing-\u0026-using-property-affordability-calculator;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 11020526100,
  "status": "passed"
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
  "name": "I am on CIMB page for calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I navigate to Tools page from menu",
  "keyword": "And "
});
formatter.match({
  "location": "AffordablityCalDef.I_am_on_CIMB_page()"
});
formatter.result({
  "duration": 3006866000,
  "status": "passed"
});
formatter.match({
  "location": "AffordablityCalDef.navigate_to_Tools()"
});
formatter.result({
  "duration": 8379025000,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Accessing \u0026 using Property Affordability Calculator",
  "description": "",
  "id": "check-the-property-affordability-calculator;accessing-\u0026-using-property-affordability-calculator;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I access to Property Affordability Calculator",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I have inputted all necessary values as \"1000000\" \"800000\" \"500000\" \"5\" \"800\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I will be able to know the \"2,189.85\" and \"108,000.00\"",
  "matchedColumns": [
    5,
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I will see Credit Card Payment Calculator, Auto Financing Affordability Calculator and Property Monthly Installment Calculator at the bottom",
  "keyword": "And "
});
formatter.match({
  "location": "AffordablityCalDef.access_to_Property_Affordability_Calculator()"
});
formatter.result({
  "duration": 4292797600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000000",
      "offset": 41
    },
    {
      "val": "800000",
      "offset": 51
    },
    {
      "val": "500000",
      "offset": 60
    },
    {
      "val": "5",
      "offset": 69
    },
    {
      "val": "800",
      "offset": 73
    }
  ],
  "location": "AffordablityCalDef.inputted_all_necessary_values(String,String,String,String,String)"
});
formatter.result({
  "duration": 12135675300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2,189.85",
      "offset": 28
    },
    {
      "val": "108,000.00",
      "offset": 43
    }
  ],
  "location": "AffordablityCalDef.estimate_monthly_payment(String,String)"
});
formatter.result({
  "duration": 190605900,
  "status": "passed"
});
formatter.match({
  "location": "AffordablityCalDef.I_would_like_to_explore_more()"
});
formatter.result({
  "duration": 252383400,
  "status": "passed"
});
formatter.after({
  "duration": 825941200,
  "status": "passed"
});
formatter.before({
  "duration": 9817914200,
  "status": "passed"
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
  "name": "I am on CIMB page for calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I navigate to Tools page from menu",
  "keyword": "And "
});
formatter.match({
  "location": "AffordablityCalDef.I_am_on_CIMB_page()"
});
formatter.result({
  "duration": 3682324000,
  "status": "passed"
});
formatter.match({
  "location": "AffordablityCalDef.navigate_to_Tools()"
});
formatter.result({
  "duration": 8420829900,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Accessing \u0026 using Property Affordability Calculator",
  "description": "",
  "id": "check-the-property-affordability-calculator;accessing-\u0026-using-property-affordability-calculator;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I access to Property Affordability Calculator",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I have inputted all necessary values as \"\" \"1000000\" \"4000\" \"9\" \"20\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I will be able to know the \"0.00\" and \"0.00\"",
  "matchedColumns": [
    5,
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "I will see Credit Card Payment Calculator, Auto Financing Affordability Calculator and Property Monthly Installment Calculator at the bottom",
  "keyword": "And "
});
formatter.match({
  "location": "AffordablityCalDef.access_to_Property_Affordability_Calculator()"
});
formatter.result({
  "duration": 4273015200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 41
    },
    {
      "val": "1000000",
      "offset": 44
    },
    {
      "val": "4000",
      "offset": 54
    },
    {
      "val": "9",
      "offset": 61
    },
    {
      "val": "20",
      "offset": 65
    }
  ],
  "location": "AffordablityCalDef.inputted_all_necessary_values(String,String,String,String,String)"
});
formatter.result({
  "duration": 12297612600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.00",
      "offset": 28
    },
    {
      "val": "0.00",
      "offset": 39
    }
  ],
  "location": "AffordablityCalDef.estimate_monthly_payment(String,String)"
});
formatter.result({
  "duration": 172213000,
  "status": "passed"
});
formatter.match({
  "location": "AffordablityCalDef.I_would_like_to_explore_more()"
});
formatter.result({
  "duration": 250727900,
  "status": "passed"
});
formatter.after({
  "duration": 830301300,
  "status": "passed"
});
});