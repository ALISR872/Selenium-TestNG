package com.eurotech.Pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }



}

//Page Object Model --> Design pattern in Selenium
//Page Factory --> is class in Selenium using which we can create page object