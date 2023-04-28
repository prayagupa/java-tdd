
<h4>Standards</h4>

- IT(Integration Testing, Component Testing) is used to test the multiple modules/components together.
-
<h4>2.1 Narrow IT</h4>
- Narrow IT exercises only portion of the code in my service that talks to a separate service using test doubles of those services.
  Ex. If a ad-server microservice has ad-serving module which uses budget capping module and SKU availablity module in order to serve an ad.
- Use "Test Doubles" in place of dependencies which could be external microservices. Test Doubles could be Stubs, Fakes, Dummies, Spies or Mocks.

```
Stub -> pre-defined behaviour
Fake -> service replacement using closer or similar tech. Ex instead of actual postgresdb use in memory database. Or in stead of testing a dependency service write a Double REST service.  
Dummy -> Service replica does not do anything or returns nothing

## coupling 
Spy -> To verify the right message is sent to the Double
Mock -> To verify the right message is sent to the Double in a certain way
```

<b>2.2 Broad IT</b>
Broad IT requires live versions of all services, requiring substantial test environment and network access.

- FT is Application Under Test(AUT).
- FT should start testing the most popular positive user scenarios/ workflows.
- FT should test the service boundaries. Ex. user-id can be of max length 16 letters
- FT should test the decisional flows. Ex. respond profile page if user is loggedd in.
- FT should verify service response and the data states for command (`POST`, `PUT`) requests.
- FT should verify service response for query (`GET`) requests.

<b>References</b>
- https://medium.com/docplanner-tech/test-doubles-eeacc380e049
- https://martinfowler.com/bliki/IntegrationTest.html
- https://martinfowler.com/bliki/ComponentTest.html
- e2e: https://martinfowler.com/bliki/BroadStackTest.html
- https://www.pagerduty.com/blog/end-to-end-e2e-testing-best-practices/
