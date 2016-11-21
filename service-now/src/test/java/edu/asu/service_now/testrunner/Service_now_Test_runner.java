package edu.asu.service_now.testrunner;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.runner.RunWith;
import  org.junit.Assert.*;
import  org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;


import java.util.regex.*;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/java/service_now_sprints/sprint1.feature",glue="edu.asu.service_now_tests",format = {"html:target"})
public class Service_now_Test_runner {
	
  }

 