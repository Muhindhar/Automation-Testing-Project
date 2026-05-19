package pages;

import org.openqa.selenium.By;

public class DownloadPdfpage {
	public By recbtn = By.xpath("//a[normalize-space()='Receptionist']");
	public By signin = By.xpath("//button[@type='submit']");
	public By appbtn = By.xpath("//span[normalize-space()='Appointment']");
	public By tdyapp = By.xpath("(//ul[@class='nav nav-tabs navlistscroll']//li)[1]");
	public By upcapp = By.xpath("(//ul[@class='nav nav-tabs navlistscroll']//li)[2]");
	public By oldapp = By.xpath("(//ul[@class='nav nav-tabs navlistscroll']//li)[3]");
	public By tdyxcel = By.xpath("(//a[@title='Excel'])[1]");
	public By upcsv = By.xpath("(//a[@title='CSV'])[1]");
	public By oldpdf = By.xpath("(//a[@title='PDF'])[1]");
}