package com.pseudo.tdd.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by prayagupd
 * on 2/14/17.
 */


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"})
public class RunCukeTests {

}