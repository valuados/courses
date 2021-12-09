package com.customertimes.cucumber.hooks;


import com.customertimes.framework.config.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.customertimes.framework.driver.WebDriverRunner.closeWebDriver;
import static com.customertimes.framework.driver.WebDriverRunner.getWebDriver;

public class WebDriverHooks {

    @Before
    public void setUp() {
        getWebDriver().get(TestConfig.CONFIG.baseUrl());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
