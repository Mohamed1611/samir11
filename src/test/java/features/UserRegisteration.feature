Feature: User Registeration
 I want to check that user can register in our e-commerce website.
 
 Scenario Outline: User Registeration
 Given The User is On Home Page
 When User Click on Register Link text
 And User Entered the "<FirstName>" , "<LastName>" , "<Email>" ,"<Password>"
 Then Registeration Result Page displayed 
 
 Examples:
 | FirstName | LastName | Email | Password |
 | Mohamed | Hamo | Shehhk12773mmo@test.com | 123456789| 
 | Mohamed | tokaaar | Toky1gg23ggyaar@test.com | 123456789|