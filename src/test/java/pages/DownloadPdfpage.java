package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.HelperClass;

public class DownloadPdfpage {

	public By recbtn = By.xpath("//a[normalize-space()='Receptionist']");
	public By signin = By.xpath("//button[@type='submit']");
	public By appbtn = By.xpath("//li[contains(@class,'treeview')][4]");
	public By tdyapp = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//li[1]");
	public By tdyxcel = By.xpath("//div[@id='DataTables_Table_0_wrapper']//div//i[@class='fa fa-file-excel-o']");
	public By upcapp = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//li[2]");
	public By upcsv = By.xpath("//div[@id='DataTables_Table_1_wrapper']//div//a[@title='CSV']");
	public By oldapp = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//li[3]");
	public By oldpdf = By.xpath("//div[@id='DataTables_Table_2_wrapper']//div//a[@title='PDF']");
}
