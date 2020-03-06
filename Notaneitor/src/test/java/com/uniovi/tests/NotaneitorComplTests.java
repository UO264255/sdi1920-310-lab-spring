package com.uniovi.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.*;
import com.uniovi.tests.util.SeleniumUtils;

import org.junit.runners.MethodSorters;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorComplTests {

	// En Windows (Debe ser la versión 65.0.1 y desactivarlas actualizacioens
	// automáticas)):
	static String PathFirefox65 = "C:\\Users\\roxex\\Desktop\\Clase\\3er_Curso\\2ndoTrimestre\\SDI\\Session Selenium\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\roxex\\Desktop\\Clase\\3er_Curso\\2ndoTrimestre\\SDI\\Session Selenium\\Materiales\\geckodriver024win64.exe";

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

	// PR01. Añadir un nuevo alumno /
	@Test
	public void PR01() {
		//We login as an admin
		PO_PrivateView.loginAsAdmin(driver);

		//We click on the user administration
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'users-menu')]/a");
		elementos.get(0).click();
		// Esperamos a aparezca la opción de añadir nota: //a[contains(@href,
		// 'mark/add')]
		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'user/add')]");
		// Pinchamos en agregar Usuario.
		elementos.get(0).click();		
		PO_PrivateView.fillFormAddUser(driver, PO_PrivateView.ROL_ALUMNO ,"123412", "Jose", "Matas", "password");		
		elementos = PO_View.checkElement(driver, "text", "123412");
		// Ahora nos desconectamos
		PO_PrivateView.clickOption(driver, "logout", "text", "Identifícate");
	}

	// PR02. Datos invalidos /
	// PR02. Este test no puede ser realizado por la falta de restricciones en añadir usuario
	// Pero el test correcto seria el siguiente
		@Test
		public void PR02() {
			//We login as an admin
			PO_PrivateView.loginAsAdmin(driver);

			//We click on the user administration
			List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'users-menu')]/a");
			elementos.get(0).click();
			// Esperamos a aparezca la opción de añadir nota: //a[contains(@href,
			// 'mark/add')]
			elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'user/add')]");
			// Pinchamos en agregar Usuario.
			elementos.get(0).click();	
			//Dni duplicado
			PO_PrivateView.fillFormAddUser(driver, PO_PrivateView.ROL_ALUMNO ,"123412", "Jose", "Matas", "password");		
			PO_RegisterView.checkKey(driver, "Error.user.add.dni.duplicate", PO_Properties.getSPANISH());
			//Nombre corto
			PO_PrivateView.fillFormAddUser(driver, PO_PrivateView.ROL_ALUMNO ,"123412", "J", "Matas", "password");		
			PO_RegisterView.checkKey(driver, "Error.user.add.name.length", PO_Properties.getSPANISH());
			//Apellido corto
			PO_PrivateView.fillFormAddUser(driver, PO_PrivateView.ROL_ALUMNO ,"123412", "Josea", "s", "password");		
			PO_RegisterView.checkKey(driver, "Error.user.add.lastName.length", PO_Properties.getSPANISH());
			//Contraseña corta
			PO_PrivateView.fillFormAddUser(driver, PO_PrivateView.ROL_ALUMNO ,"123412", "Josea", "Matas", "p");		
			PO_RegisterView.checkKey(driver, "Error.user.add.password.length", PO_Properties.getSPANISH());
			
			//Desconectamos
			PO_PrivateView.clickOption(driver, "logout", "text", "Identifícate");
		}
		
		//Try adding a new user being a user
		@Test
		public void PR03() {
			//We login as an admin
			PO_PrivateView.startTest(driver, "99999990A", "Notas del usuario");
			
			//We click on the user administration
			List<WebElement> elementos = PO_View.checkElement(driver, "free", "//div[@id = 'myNavbar']/*[1]/li");
			// Comprobamos que el tamaño de la lista es cero
			Assert.assertTrue(elementos.size() == 2);
			
		}


	
	}