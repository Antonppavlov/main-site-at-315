package ru.geekbrains.main.site.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.OpenUrl;
import ru.geekbrains.main.site.at.page.content.HomePage;

public class AuthorizationPage extends BasePage implements OpenUrl {

    @FindBy(css = "[id=\"user_email\"]")
    private WebElement inputLogin;

    @FindBy(css = "[data-testid=\"login-password\"]")
    private WebElement inputPassword;

    @FindBy(css = "[data-testid=\"login-submit\"]")
    private WebElement buttonSubmit;


    public AuthorizationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        return new HomePage(driver);
    }

    @Override
    public AuthorizationPage openUrl() {
        driver.get("https://geekbrains.ru/login");
        return this;
    }
}
