Java TDD
=============

- [Software Testing](https://en.wikipedia.org/wiki/Software_testing#Testing_levels)


1 Unit Testing
-----------------


[xUnit Test Patterns: Refactoring Test Code](http://xunitpatterns.com/Code%20Refactorings.html)

![TDD xunit](TDD_xunit.gif)

[stub vs mock](http://stackoverflow.com/a/3459491/432903)

```
Every class or object created is a fake. 
It is a mock<> if you verify() calls against it. 

Its a stub<> if you don't verify the calls, only have the behaviour pre-determined. `stub` also referred to as state-based.
```

ex.

```java
class SubjectToTest {
  private Dependency dependency;
  
  public String doSomething(){
      //dependency.doSomething() is already defined, so its mock[]ed
      dependency.doSomething() + "-something else";
  }
}
```

```java
interface DependencyStub {
    String doSomething();
}

class DependencyStubImpl implements DependencyStub {

  public String doSomething(){
     return "something";
  }
}
```

<h3>UT Practices</h3>

- [Static Methods are Death to Testability, Google Inc](https://testing.googleblog.com/2008/12/static-methods-are-death-to-testability.html)

_The basic issue with static methods is they are procedural code. I have no idea how to unit-test procedural code. Unit-testing assumes that I can instantiate a piece of my application in isolation. During the instantiation I wire the dependencies with mocks/friendlies which replace the real dependencies. With procedural programing there is nothing to "wire" since there are no objects, the code and data are separate._

<h3>Code coverage</h3>

[s-coverage plugin](https://github.com/nihil-os/scoverage-maven-plugin)

```bash
sbt test
```

<h3>using maven</h3>

```bash
mvn clean test
```

<h3>test HTML reports</h3>

```bash
mvn surefire-report:report
```

![](test-report.png)

```bash
ls -l target/surefire-reports/
total 872
-rw-r--r--  1 prayagupd NA\Domain Users   9558 Sep  3 10:13 TEST-com.pseudo.tdd.CaseClassFunSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users  13170 Sep  3 10:13 TEST-com.pseudo.tdd.ExceptionInsideTrySuccess.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8995 Sep  3 10:13 TEST-com.pseudo.tdd.FunctionalMapSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users  12323 Sep  3 10:13 TEST-com.pseudo.tdd.FutureSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users  12230 Sep  3 10:13 TEST-com.pseudo.tdd.FutureTests.xml
-rw-r--r--  1 prayagupd NA\Domain Users  12341 Sep  3 10:13 TEST-com.pseudo.tdd.GenericsTests.xml
-rw-r--r--  1 prayagupd NA\Domain Users  19352 Sep  3 10:13 TEST-com.pseudo.tdd.IUseStaticClassSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8623 Sep  3 10:13 TEST-com.pseudo.tdd.ImplicitlySpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8964 Sep  3 10:13 TEST-com.pseudo.tdd.MaybeMonadSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8920 Sep  3 10:13 TEST-com.pseudo.tdd.MockitoTestSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8648 Sep  3 10:13 TEST-com.pseudo.tdd.ObjectMapperSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8978 Sep  3 10:13 TEST-com.pseudo.tdd.ServiceASpec.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8688 Sep  3 10:13 TEST-com.pseudo.tdd.ServiceASpecsUsingScalaMock.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8872 Sep  3 10:13 TEST-com.pseudo.tdd.ServiceAStepwiseSpec.xml
-rw-r--r--  1 prayagupd NA\Domain Users  12265 Sep  3 10:13 TEST-com.pseudo.tdd.ServiceATest.xml
-rw-r--r--  1 prayagupd NA\Domain Users  19399 Sep  3 10:13 TEST-com.pseudo.tdd.StaticClassSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8618 Sep  3 10:13 TEST-com.pseudo.tdd.ThreeSumSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8777 Sep  3 10:13 TEST-com.pseudo.tdd.e2e.TestE2E.xml
-rw-r--r--  1 prayagupd NA\Domain Users  12165 Sep  3 10:13 TEST-com.pseudo.tdd.integration.RunCukeTests.xml
-rw-r--r--  1 prayagupd NA\Domain Users  12167 Sep  3 10:13 TEST-com.pseudo.tdd.integration.ServerIntSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8894 Sep  3 10:13 TEST-com.pseudo.tdd.scalamock.FunctionStubSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8702 Sep  3 10:13 TEST-com.pseudo.tdd.scalamock.GameScalaMockSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8648 Sep  3 10:13 TEST-com.pseudo.tdd.scalamock.MultipleParamsStub.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8690 Sep  3 10:13 TEST-com.pseudo.tdd.scalamock.MyScalamockTrait.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8635 Sep  3 10:13 TEST-com.pseudo.tdd.scalamock.NoParamStub.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8648 Sep  3 10:13 TEST-com.pseudo.tdd.scalamock.ScalaMockJavaClass.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8666 Sep  3 10:13 TEST-com.pseudo.tdd.scalamock.ScalaStubTrait.xml
-rw-r--r--  1 prayagupd NA\Domain Users   9002 Sep  3 10:13 TEST-com.pseudo.tdd.strategy.ApplicationRouterSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8946 Sep  3 10:13 TEST-com.pseudo.tdd.strategy.EventDispatcherSpecs.xml
-rw-r--r--  1 prayagupd NA\Domain Users   8529 Sep  3 10:13 TEST-org.scalatest.tools.DiscoverySuite-bbd206b0-f9b5-4984-86ac-de02598ddae3.xml
-rw-r--r--  1 prayagupd NA\Domain Users    271 Sep  3 10:13 com.pseudo.tdd.FutureTests.txt
-rw-r--r--  1 prayagupd NA\Domain Users    273 Sep  3 10:13 com.pseudo.tdd.GenericsTests.txt
-rw-r--r--  1 prayagupd NA\Domain Users   7154 Sep  3 10:13 com.pseudo.tdd.IUseStaticClassSpecs.txt
-rw-r--r--  1 prayagupd NA\Domain Users    272 Sep  3 10:13 com.pseudo.tdd.ServiceASpec.txt
-rw-r--r--  1 prayagupd NA\Domain Users    272 Sep  3 10:13 com.pseudo.tdd.ServiceATest.txt
-rw-r--r--  1 prayagupd NA\Domain Users   7146 Sep  3 10:13 com.pseudo.tdd.StaticClassSpecs.txt
-rw-r--r--  1 prayagupd NA\Domain Users    284 Sep  3 10:13 com.pseudo.tdd.integration.RunCukeTests.txt
-rw-r--r--  1 prayagupd NA\Domain Users    286 Sep  3 10:13 com.pseudo.tdd.integration.ServerIntSpecs.txt
-rw-r--r--  1 prayagupd NA\Domain Users   5401 Sep  3 10:13 test-suite.log
```

<h5>References</h5>
- https://martinfowler.com/articles/mocksArentStubs.html#SoShouldIBeAClassicistOrAMockist
- https://martinfowler.com/bliki/TestCoverage.html


2 Functional Testing
--------------------

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


3 [Smoke Testing/ Sanity Testing](https://en.wikipedia.org/wiki/Smoke_testing_(software))/ build verification test
---------------------------------

- http://softwaretestingfundamentals.com/smoke-testing/
- https://medium.com/hootsuite-engineering/our-journey-in-smoke-test-frameworks-6a1fb30572e2

```
A smoke tester will select and run a subset of test cases that cover 
the most important functionality of a component or system.
```

_it is a set of tests run on each new build of a product to verify that the build is
testable before the build is released into the hands of the test team_

`mvn shakedown`


4 [Regression Testing](https://en.wikipedia.org/wiki/Regression_testing)
-------------

```
 verifies that software, which was previously developed and tested, still performs correctly after it was changed 
 or interfaced with other software.
```

- https://cucumber.io/docs/installation/java/

Non functional Testing/ Perf Testing
--------------------------------------

Practices

- should run single user flow tests in order to understand the baseline measurements.
- should run the Load Tests to understand the average and p90 metrics
- should run the Peak Load Tests to understand the service behaviour under peak load.
- should define the baseline concurrent requests, CPU utilization, Memory utilization, Latency(max, acceptable)
- should run Stress Testing
- should run Scalability Testing
- 
Further TDD reading
----

- https://www.testcontainers.org/#about

- https://github.com/vaquarkhan/vaquarkhan/blob/master/Design/building-microservices-designing-fine-grained-systems.pdf
- https://abseil.io/resources/swe-book/html/ch14.html#functional_testing_of_one_or_more_inter
- 
- [The Case Against TDD - Eric Smith](https://www.youtube.com/watch?v=nRdn5k5jKyY)

- [Real world mutation testing](http://pitest.org/)

_Faults (or mutations) are automatically seeded into your code,
then your tests are run._

_If your tests fail then the mutation is killed, if your tests pass then the mutation lived._

- [How Car Testing Works](http://auto.howstuffworks.com/car-driving-safety/safety-regulatory-devices/car-testing1.htm)

- https://8thlight.com/blog/uncle-bob/2014/05/14/TheLittleMocker.html

- https://www.amazon.com/dp/0321146530/?tag=stackoverfl08-20

- [Using Mockito's ArgumentCaptor in Scala](http://blog.themillhousegroup.com/2013/11/using-mockitos-argumentcaptor-in-scala.html)

- [ScalaTest and Mockito: Functions](http://bleibinha.us/blog/2013/11/scalatest-and-mockito-functions)

- [Testing styles in ScalaTest : PropSpec with TableDrivenPropertyChecks with Matchers, WordSpec etc](http://yeghishe.github.io/2015/05/31/scalatest-testing-styles.html)

- [Suite with ShouldMatchers, FunSuite, FeatureSpec with GivenWhenThen](https://blog.knoldus.com/2011/05/16/working-with-scala-test/)

![image](https://phithoughts.files.wordpress.com/2011/05/core-traits.png?w=640)

- [scalamock, native scala testing](https://github.com/paulbutcher/scalamock#features)


FIXME
------

fix mockito version with powermockito

```bash
java.lang.NoSuchMethodError: 
org.mockito.internal.creation.MockSettingsImpl.setMockName(Lorg/mockito/mock/MockName;)
Lorg/mockito/internal/creation/settings/CreationSettings;
```

implicits: https://github.com/paulbutcher/ScalaMock/issues/79
