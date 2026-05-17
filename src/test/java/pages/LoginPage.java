package pages;

import org.openqa.selenium.By;

public class LoginPage {
	public By emailInput = By.xpath("//input[@id = \"email\"]");
	public By passwordInput = By.xpath("//input[@id = \"password\"]");
	public By signInButton = By.xpath("//button[@type = \"submit\"]");
	public By superAdmin = By.xpath("//a[text() = \"Super Admin\"]");
	public By admin = By.xpath("//a[text() = \"Admin\"]");
	public By doctor = By.xpath("//a[text() = \"Doctor\"]");
	public By pharmacist = By.xpath("//a[text() = \"Pharmacist\"]");
	public By pathologist = By.xpath("//a[text() = \"Pathologist\"]");
	public By radiologist = By.xpath("//a[text() = \"Radiologist\"]");
	public By accountant = By.xpath("//a[text() = \"Accountant\"]");
	public By receptionist = By.xpath("//a[text() = \"Receptionist\"]");
	public By nurse = By.xpath("//a[text() = \"Nurse\"]");
	public By usernameErrorMessage = By.xpath("//input[@name='username']/parent::div/descendant::p");
	public By passwordErrorMessage = By.xpath("//input[@name='password']/parent::div/descendant::p");
	public By invalidErrorMessage = By.xpath("//div[@class = \"alert alert-danger\"]");
}
