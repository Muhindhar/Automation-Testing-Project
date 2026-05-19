package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.HelperClass;

public class DownloadPdfpage {
	//public By recbtn = By.cssSelector(".btn.btn-primary.width50[href='#'][onclick=\"copy('maria@gmail.com', 'password')\"]");
	public By recbtn = By.xpath("//div[@class = 'form-bottom']//a[text() = 'Receptionist']");
	public By signin = By.xpath("//button[@type='submit']");
	public By appbtn = By.xpath("//li//a//span[text() = 'Appointment']");
	public By tdyapp = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//li[1]");
	public By tdyxcel = By.xpath("//div[@id='DataTables_Table_0_wrapper']//div//i[@class='fa fa-file-excel-o']");
	public By upcapp = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//li[2]");
	public By upcsv = By.xpath("//div[@id='DataTables_Table_1_wrapper']//div//a[@title='CSV']");
	public By oldapp = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//li[3]");
	public By oldpdf = By.xpath("//div[@id='DataTables_Table_2_wrapper']//div//a[@title='PDF']");
}
