package pages;

import org.openqa.selenium.By;

public class NoticeBoardPages {
	public By notice = By.xpath("(//div[contains(@class,'dashalert')]//a)[1]");
	public By noticedispl = By.xpath("//h3[contains(text(),'Notice Board')]");

}