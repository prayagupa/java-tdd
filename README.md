Java TDD
=============

Unit Testing
-----------------

[xUnit Test Patterns: Refactoring Test Code](http://xunitpatterns.com/Code%20Refactorings.html)

![TDD xunit](TDD_xunit.gif)

[stub vs mock](http://stackoverflow.com/a/3459491/432903)

```
Every class or object created is a fake. It is a mock<> if you verify() calls against it. 

Otherwise its a stub<>, stub has the behaviour pre-determined. stub also referred to as state-based
```

eg.

```java
class SubjectToTest {
  private Dependency dependency;
  
  public String doSomething(){
      dependency.doSomething() + "-something else"; //dependency.doSomething() is already defined, so its mock[]ed
  }
}

interface DependencyStub {
    String doSomething();
}

class DependencyStubImpl implements DependencyStub {

  public String doSomething(){
     return "something";
  }
}
```

https://8thlight.com/blog/uncle-bob/2014/05/14/TheLittleMocker.html

https://www.amazon.com/dp/0321146530/?tag=stackoverfl08-20

[Using Mockito's ArgumentCaptor in Scala](http://blog.themillhousegroup.com/2013/11/using-mockitos-argumentcaptor-in-scala.html)

[ScalaTest and Mockito: Functions](http://bleibinha.us/blog/2013/11/scalatest-and-mockito-functions)

[Testing styles in ScalaTest : PropSpec with TableDrivenPropertyChecks with Matchers, WordSpec etc](http://yeghishe.github.io/2015/05/31/scalatest-testing-styles.html)

[Suite with ShouldMatchers, FunSuite, FeatureSpec with GivenWhenThen](https://blog.knoldus.com/2011/05/16/working-with-scala-test/)

![image](https://phithoughts.files.wordpress.com/2011/05/core-traits.png?w=640)

[scalamock, native scala testing](https://github.com/paulbutcher/scalamock#features)

Code coverage
-------------

[s-coverage plugin](https://github.com/nihil-os/scoverage-maven-plugin)

```bash
sbt test
```

using maven
---------------------

```bash
mvn clean test
```

test HTML reports
--

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

FIXME
------

fix mockito version with powermockito

```bash
java.lang.NoSuchMethodError: 
org.mockito.internal.creation.MockSettingsImpl.setMockName(Lorg/mockito/mock/MockName;)
Lorg/mockito/internal/creation/settings/CreationSettings;
```

