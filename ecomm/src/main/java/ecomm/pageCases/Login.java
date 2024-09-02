package ecomm.pageCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement go;
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement ndc;
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement mdp;
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement ok;
	
	public void goTo() {
		driver.get("https://automationexercise.com/");
	}
	
	public void loginsite(String mail, String mdps) {
		go.click();
		ndc.sendKeys(mail);
		mdp.sendKeys(mdps);
		ok.click();
	}

}
