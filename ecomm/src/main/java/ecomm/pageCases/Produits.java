package ecomm.pageCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecomm.composantAbst.CompoAbst;

public class Produits extends CompoAbst {
	//https://automationexercise.com/	
WebDriver driver;
	
	public Produits(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//div[@class='product-image-wrapper']")
	List<WebElement> produits;
	
	@FindBy(id="aswift_1")
	WebElement iframe;
	
	@FindBy(xpath="//button[@class='btn btn-default cart']")
	WebElement addProd;
	
	@FindBy(xpath="//p[@class='text-center']/a")
	WebElement goProd;
	
	public void clickOnProduct(String nomProd) {
	    for (int attempt = 1; attempt <= 3; attempt++) { 
	        try {
	            for (WebElement product : produits) {
	                String name = product.findElement(By.xpath(".//div/div/p")).getText();
	                if (name.equals(nomProd)) {
	                    System.out.println("Product found: " + nomProd);
	                    waitForElementsDiss(iframe);
	                    product.findElement(By.xpath(".//div/ul")).click();
	                    return; 
	                }
	            }
	            System.out.println("Product not found: " + nomProd);
	            return; 
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Retrying...");
	        }
	    }
	    System.out.println("Product not found after retrying: " + nomProd);
	}
	
	public void AjoutProd() {
		addProd.click();
	}
	
	public void goToCart() {
		goProd.click();
	}	
	
}	

