package ecomm.pageCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm.composantAbst.CompoAbst;

public class Payment extends CompoAbst {
	
	WebDriver driver;
	public Payment(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(driver, this);			
	}
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement nom;
	
	@FindBy(xpath="//input[@class='form-control card-number']")
	WebElement numcart;
	
	@FindBy(xpath="//input[@name='cvc']")
	WebElement cvc;
	
	@FindBy(xpath="//input[@name='expiry_month']")
	WebElement exp;
	
	@FindBy(xpath="//input[@name='expiry_year']")
	WebElement ann;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement payer;
	
	public void payAndConfirm(String nomm, String cartnum, String cvcc, String expp, String anne) {
		nom.sendKeys(nomm);
		numcart.sendKeys(cartnum);
		cvc.sendKeys(cvcc);
		exp.sendKeys(expp);
		ann.sendKeys(anne);		
		payer.click();
	}
	

}
