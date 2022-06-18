package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class openCardScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//Find number of images in the link
		List<WebElement> numberOfImages = driver.findElements(By.tagName("img"));
		System.out.println(numberOfImages.size());
		
		
		//Create a script to register new user in the above given link
		WebElement myAccount  = driver.findElement(By.xpath("//body/nav[@id='top']/div[2]/div[2]/ul[1]/li[2]/div[1]"));
		myAccount.click();
		
		WebElement register  = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
		register.click();
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Prakash");
		
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("H");
		
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("prakash@gamil.com");
		
		WebElement passWord = driver.findElement(By.id("input-password"));
		passWord.sendKeys("12345");
		
		WebElement SubscribeNo = driver.findElement(By.cssSelector("#input-newsletter-no"));
		boolean selected = SubscribeNo.isSelected();
		if( selected == true) {
			WebElement SubscribeYes = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/div[1]/input[1]"));
			SubscribeYes.click();
		}
	
		driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).submit();

		
		//Create a script to add items like laptop, mobiles, camera to the cart
		//Add card to Laptop
		WebElement Laptop = driver.findElement(By.linkText("Laptops & Notebooks"));
		Actions builder = new Actions(driver);
		builder.moveToElement(Laptop).perform();
		driver.findElement(By.linkText("Show All Laptops & Notebooks")).click();
		
		WebElement addCardLaptop = driver.findElement(By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[4]/div[2]/form[1]/div[1]/div[2]/div[2]/button[1]"));
		addCardLaptop.submit();
		
		//Add card to Mobile
		driver.findElement(By.linkText("Phones & PDAs")).click();
		WebElement addCardMobile = driver.findElement(By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[2]/button[1]"));
		addCardMobile.submit();
		
		//Add card to Camera
		driver.findElement(By.linkText("Cameras")).click();
		WebElement addCardCamera = driver.findElement(By.xpath("//body/main[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[2]/button[1]"));
		addCardCamera.submit();
		
		driver.close();
	}

}
