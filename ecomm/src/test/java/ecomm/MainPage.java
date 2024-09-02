package ecomm;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ecomm.pageCases.*;
import ecomm.composantAbst.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		
		String nomProd = "Rose Pink Embroidered Maxi Dress";
		
		Login login = new Login(driver);
		login.goTo();
		login.loginsite("cro@crocay.com", "crocoo123");
		
		Produits produits = new Produits(driver);
		produits.goProd();
		produits.clickOnProduct(nomProd);
		produits.AjoutProd();
		produits.goToCart();
		
		VerifyProd verifyProd = new VerifyProd(driver);
		verifyProd.VerifierProd(nomProd);
		verifyProd.gopaie();
		
		PlaceOrder placeOrder = new PlaceOrder(driver);
		placeOrder.comment("nice");
		placeOrder.placeOrd();
		
		Payment payment = new Payment(driver);
		payment.payAndConfirm("test", "123456789", "333", "99", "9999");
		
		CompoAbst compoAbst = new CompoAbst(driver);
		compoAbst.finals();
		
	}
}
