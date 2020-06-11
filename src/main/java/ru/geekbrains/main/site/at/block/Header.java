package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.page.content.SearchPage;

public class Header extends BasePage {

    @FindBy(css = "h2[class=\"gb-header__title\"]")
    private WebElement textNamePage;    
    
    @FindBy(css = "[id='top-menu'] [class='show-search-form'] svg")
    private WebElement buttonSearch;    
  
    @FindBy(css = "[class='search-panel__search-field']")
    private WebElement inputSearch;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("проверка что отображается страница: {expectedNamePage}")
    public Header checkNamePage(String expectedNamePage) {
        wait10second.until(ExpectedConditions.textToBePresentInElement(textNamePage, expectedNamePage));
        return this;
    }

    @Step("поиск по сайту по слову: {expectedNamePage}")
    public SearchPage searchInSite(String searchText) {
        buttonSearch.click();
        inputSearch.sendKeys(searchText);
        return new SearchPage(driver);
    }
}
