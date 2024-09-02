package ecomm.composantAbst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CompoAbst {
	
	WebDriver driver;
	public CompoAbst(WebDriver driver) {
		
		this.driver = driver;		
		PageFactory.initElements(driver, this);		
	}
	
	public void waitForElementsDis(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void waitForElementsDiss(WebElement ele) {		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public  void waitForElement(WebElement ele){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public  void waitForElements(By findBy){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
			
	public void waitForClick(By ele) {		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement goProd;
	
	@FindBy(xpath="//h2[@class='title text-center']/b")
	WebElement ordSuc;
		
	public void goProd() {
		goProd.click();
	}
	
	public void finals() {
		String y = ordSuc.getText();
		Assert.assertEquals(y,"ORDER PLACED!");
		System.out.println(y);
	}	
}