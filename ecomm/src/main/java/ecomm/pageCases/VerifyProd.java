package ecomm.pageCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm.composantAbst.CompoAbst;

public class VerifyProd extends CompoAbst {
	
	WebDriver driver;
	public VerifyProd(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(driver, this);			
	}
	
	@FindBy(xpath="//td[@class='cart_description']/h4/a")
	List<WebElement> nomProd;
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement goPaie;
	
	public boolean VerifierProd(String prodNom) {
		for (WebElement produit : nomProd) {
	        if (produit.getText().equalsIgnoreCase(prodNom)) {
	        	System.out.println("true");
	            return true;
	        }
	    }
		System.out.println("false");
		driver.quit();
	    return false;
	}
	
	public void gopaie() {
		goPaie.click();
	}
		
}
