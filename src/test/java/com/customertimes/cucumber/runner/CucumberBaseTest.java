package com.customertimes.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "smoke",
        glue = {"LoginToShop"},
        features = "src/test/java/io/customertimes/features/LoginToShop.feature"
)
public class CucumberBaseTest extends AbstractTestNGCucumberTests {
}
