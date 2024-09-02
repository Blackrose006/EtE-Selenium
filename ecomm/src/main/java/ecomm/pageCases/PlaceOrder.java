package ecomm.pageCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm.composantAbst.CompoAbst;

public class PlaceOrder extends CompoAbst {
	
	WebDriver driver;
	public PlaceOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(driver, this);			
	}
	
	@FindBy(xpath="//textarea[@class='form-control']")
	WebElement comm;
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement order;
	
	public void comment(String com) {
		comm.sendKeys(com);
	}
	
	public void placeOrd() {
		order.click();
	}

}
