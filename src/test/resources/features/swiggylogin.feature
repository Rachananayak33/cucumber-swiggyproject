Feature: Login Module



Scenario: Valid Login
          Given user is on home page of www.swiggy.com
          When user enters mobile_number and otp
          |mobile_number|otp|
          |9483998490|540470|
          Then user should be logged in