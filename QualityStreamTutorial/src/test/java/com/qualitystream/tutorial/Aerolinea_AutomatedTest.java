package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aerolinea_AutomatedTest {
	
	private WebDriver driver;
	//login	
	By userLocator = By.name("username");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("signIn");
	// confirmacion de ingreso a la app
	By homePageLocator = By.name("titulo");
		
	
	// registrar una nueva reserva
	By registerBtnLocator =By.name("registrarReserva");
	By registerPageLocator = By.id("tipIdentificacion");
	By uservueloLocator = By.name("numeroVuelo");
	By ccLocator = By.name("numeroIdentificacion");
	By nameLocator = By.name("nombres");
	By lastnameLocator = By.name("apellidos");
	By usermillasLocator = By.name("millasAcumuladas");
	By creareservaBtnLocator = By.name("crearReserva");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8081");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
// login
	@Test
	public void signIn() throws InterruptedException {
		if(driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("pepito");
			driver.findElement(passLocator).sendKeys("12345");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			//saber si ya entramos al pag con el titulo 'listado de reservas'
			assertTrue(driver.findElement(homePageLocator).isDisplayed());
		}
		else 
			System.out.println("username textbox was no present");
		}
		
	
	@Test 
	public void registerReserva() throws InterruptedException {
		driver.findElement(registerBtnLocator).click();
		
	// el titulo que queremos confirmar apare en el link del registro
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(uservueloLocator).sendKeys("42424");
			driver.findElement(ccLocator).sendKeys("23452345");
			driver.findElement(nameLocator).sendKeys("cata");
			driver.findElement(lastnameLocator).sendKeys("rios");
			driver.findElement(usermillasLocator).sendKeys("1");
			driver.findElement(creareservaBtnLocator).click();
		}
		else {
			System.out.print("Registro pagina no fue encontrado");
		}
	
	//WebElement fonts = (WebElement) driver.findElements(By.tagName("font"));
	//assertEquals("42424",fonts.get(5).getText());	
	
	//WebElement fonts = driver.findElement(By.tagName("42424"));
	
	}

}