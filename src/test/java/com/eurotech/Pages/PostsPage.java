package com.eurotech.Pages;

import com.eurotech.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostsPage extends BasePage {

    @FindBy(css= "#post-form-btn")
    public WebElement submitBtn;

    @FindBy(id="post-form-title")
    public WebElement titleInput;

    @FindBy(id = "post-form-textarea")
    public WebElement postInput;

    @FindBy(xpath = "//*[contains(text(),'Created')]")
    public WebElement postCreatedMessage;

    public void postComment(String title, String post){

        titleInput.sendKeys(title);
        postInput.sendKeys(post);
        submitBtn.click();
    }

}
