package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uniovi.tests.util.SeleniumUtils;

public class PO_PrivateView extends PO_NavView {

	public static final int ROL_ALUMNO = 0;
	public static final int ROL_PROFESOR = 1;
	public static final int ROL_ADMIN = 2;

	static public void startTest(WebDriver driver, String user, String target) {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, user, "123456");
		// COmprobamos que entramos en la pagina privadade Alumno
		PO_View.checkElement(driver, "text", target);
	}

	static public void loginAsAdmin(WebDriver driver) {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "99999988F", "123456");
		// COmprobamos que entramos en la pagina privada de Administrador
		PO_View.checkElement(driver, "text", "Notas del usuario");
	}

	static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
		// Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);
		// Seleccionamos el alumnos userOrder
		new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
		// Rellenemos el campo de descripción
		WebElement description = driver.findElement(By.name("description"));
		description.clear();
		description.sendKeys(descriptionp);
		WebElement score = driver.findElement(By.name("score"));
		score.click();
		score.clear();
		score.sendKeys(scorep);
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}

	static public void fillFormAddUser(WebDriver driver, int rolep, String dnip, String namep, String lastnamep,
			String passwordp) {

		WebElement role = driver.findElement(By.name("role"));
		role.click();
		if (rolep == ROL_ADMIN)
			driver.findElement(By.xpath("/html/body/div/form/div[1]/div/select/option[3]")).click();
		else if (rolep == ROL_ALUMNO)
			driver.findElement(By.xpath("/html/body/div/form/div[1]/div/select/option[1]")).click();
		else
			driver.findElement(By.xpath("/html/body/div/form/div[1]/div/select/option[2]")).click();
		
		WebElement dni = driver.findElement(By.name("dni"));
		dni.click();
		dni.clear();
		dni.sendKeys(dnip);
		WebElement name = driver.findElement(By.name("name"));
		name.click();
		name.clear();
		name.sendKeys(namep);
		WebElement lastname = driver.findElement(By.name("lastName"));
		lastname.click();
		lastname.clear();
		lastname.sendKeys(lastnamep);
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.clear();
		password.sendKeys(passwordp);
		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}

}
