//THIS TEST CASE CAN BE USED TO REPRODUCE BUG AFTER BUYING ITEM SHOULD BE SHOWING NOTIFICATION SUCCESSFULL PAYMENT
//THIS TEST CASE CAN BE USED TO TEST FLOW FOR BUYING AN ITEM

package saleStockTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.print.Printable;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class automationPractices {
  public WebDriver driver;
  String url = " http://www.practiceselenium.com";
	@Test
  public void main() throws InterruptedException {
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		//Choose Herbal tea
		WebElement tea = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000450914890"));
		tea.click();
		Thread.sleep(3000);
		//Choose Olong tea
		driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451959280")).click();
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("audi@tester.com");
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("audi");
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("bandung selatan indah");
		Select cardType = new Select(driver.findElement(By.id("card_type")));
		cardType.selectByIndex(1);
		WebElement cardNumber = driver.findElement(By.id("card_number"));
		cardNumber.sendKeys("4441144");
		WebElement cardName = driver.findElement(By.id("cardholder_name"));
		cardName.sendKeys("audi dharmawan");
		WebElement verificationCode = driver.findElement(By.id("verification_code"));
		verificationCode.sendKeys("12345");
		verificationCode.submit(); 
		Thread.sleep(5000);
		
//		Check place order button is working even if no value added to the field. << == WHICH WHERE THE BUG IS
		WebElement tea1 = driver.findElement(By.xpath("//a[@data-pageid='00000000-0000-0000-0000-000451986078']"));
		tea1.click();
		Thread.sleep(3000);
		try {
			WebElement placeOrder = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			placeOrder.click();
			String updatedUrl = driver.getCurrentUrl();
			System.out.println("your current url now is: "+ updatedUrl);
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		
//		Check if all link button is working
		WebElement welcomeButton = driver.findElement(By.xpath("//a[@data-pageid='00000000-0000-0000-0000-000000247216']"));
		welcomeButton.click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		WebElement passionButton = driver.findElement(By.xpath("//a[@data-pageid='00000000-0000-0000-0000-000000247425']"));
		passionButton.click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		WebElement menu = driver.findElement(By.xpath("//a[@data-pageid='00000000-0000-0000-0000-000009816342']"));
		menu.click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		WebElement moreMenu = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914883"));
		moreMenu.click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		WebElement moreMenu1 = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914882"));
		moreMenu1.click();
  }
	@BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get(url);
  }

	@AfterMethod
  public void afterMethod() {
      driver.close();
  }

}
