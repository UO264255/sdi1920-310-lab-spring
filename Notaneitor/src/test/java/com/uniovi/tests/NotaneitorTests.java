package com.uniovi.tests;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.runners.MethodSorters;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorTests {

	// En Windows (Debe ser la versión 65.0.1 y desactivarlas actualizacioens
	// automáticas)):
	 static String PathFirefox65= "C:\\Users\\roxex\\Desktop\\Clase\\3er_Curso\\2ndoTrimestre\\SDI\\Session Selenium\\Mozilla Firefox\\firefox.exe";
	 static String Geckdriver024= "C:\\Users\\roxex\\Desktop\\Clase\\3er_Curso\\2ndoTrimestre\\SDI\\Session Selenium\\Materiales\\geckodriver024win64.exe";
	
	 // Comúna Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() throws Exception {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	@BeforeClass
	static public void begin() {
		
	}
	
	@AfterClass
	static public void end() {
		driver.quit();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}