package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.HelperClass;

public class DownloadPdfpage {

	public By recbtn = By.xpath("//a[normalize-space()='Receptionist']");
	public By signin = By.xpath("//button[@type='submit']");
	public By appbtn = By.xpath("//span[normalize-space()='Appointment']");
	public By tdyapp = By.xpath("//a[normalize-space()='Today Appointment']");
	public By tdyxcel = By.xpath("//div[@id='DataTables_Table_0_wrapper']//div//i[@class='fa fa-file-excel-o']");
	public By upcapp = By.xpath("//a[normalize-space()='Upcoming Appointment']");
	public By upcsv = By.xpath("//div[@id='DataTables_Table_1_wrapper']//div//a[@title='CSV']");
	public By oldapp = By.xpath("//a[normalize-space()='Old Appointment']");
	public By oldpdf = By.xpath("//div[@id='DataTables_Table_2_wrapper']//div//a[@title='PDF']");
}
