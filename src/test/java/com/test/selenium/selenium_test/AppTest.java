package com.test.selenium.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	// Initial Web Driver
    	WebDriver driver = new FirefoxDriver();
    	
    	// Open FB
    	driver.get("https://www.facebook.com/");
    	
    	WebDriverWait dWait = new WebDriverWait(driver, 10);
    	dWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='email']")));
    	
    	//Login
    	WebElement fEmail = driver.findElement(By.xpath(".//*[@id='email']"));
    	WebElement fPass = driver.findElement(By.xpath(".//*[@id='pass']"));
    	WebElement bLogin = driver.findElement(By.xpath(".//*[@id='u_0_2']"));
    	
    	
    	fEmail.sendKeys("a8_r0r@yahoo.co.id");
    	fPass.sendKeys("ulfamardiyah");
    	bLogin.click();
    	
    	dWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='u_0_1d']/div/div[2]/textarea")));
    	WebElement fSuccesLogin = driver.findElement(By.xpath(".//*[@id='u_0_1d']/div/div[2]/textarea"));

    	assertTrue(fSuccesLogin.isDisplayed());
    	if(fSuccesLogin.isDisplayed()){
    		System.out.println("Sukses");
    	}
    	driver.close();
    }
}
