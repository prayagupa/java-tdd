package com.golai.tdd.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.java8.En;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by prayagupd
 * on 2/14/17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"})
public class ServerIntSpecs implements En {

    public ServerIntSpecs() {
        Given("I have (\\d+) cupcakes in my bag", (Integer cukes) -> {
            System.out.format("Cukes: %n ", cukes);
        });
    }

}
