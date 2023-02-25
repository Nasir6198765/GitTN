package com.TN.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsletterPage {

	WebDriver driver;

	public NewsletterPage(WebDriver driver) {
		
		this.driver=driver;
	}

	By yesRadioBtn = By.xpath("//input[@name='newsletter'][@value='1']");
	By noRadioBtn = By.xpath("//input[@name='newsletter'][@value='0']");
	
	public Boolean getYesRadioButtonSelected() {
		Boolean text=driver.findElement(yesRadioBtn).isSelected();
		return text;
	}
	public Boolean getNoRadioButtonSelected() {
		Boolean text=driver.findElement(noRadioBtn).isSelected();
		return text;
	}


}
