package com.eurotech.Pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends BasePage {


    @FindBy(id = "dashboard-p1")
    public WebElement welcomeMessage;

    @FindBy(css = ".nav__menu-item")
    public List<WebElement> menuList;

    @FindBy(linkText = "All Posts")
    public WebElement allPosts;

    @FindBy(linkText = "Developers")
    public WebElement developers;

    @FindBy(linkText = "My Account")
    public WebElement myAccount;

    @FindBy(css = ".btn.btn-light")
    public List<WebElement> dashboardList;

    @FindBy(xpath = "//td[text()='Apple']/../td[2]")
    public WebElement AppleJobTitle;


    public void navigateMenu(String menuName) {
        Driver.get().findElement(By.xpath("//*[text()='" + menuName + "']")).click();
    }

    public void navigateSubMenu(String menuName) {
        Driver.get().findElement(By.xpath("//span[.='" + menuName + "']")).click();
    }

    public String getCurrentExperienceTitle(String title) {
       return Driver.get().findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
    }


}
