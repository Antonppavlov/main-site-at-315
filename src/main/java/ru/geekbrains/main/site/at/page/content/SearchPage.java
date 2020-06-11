package ru.geekbrains.main.site.at.page.content;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.ButtonNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchPage extends BasePage {

    @FindBy(css = "[class='search-page-tabs'] [class='search-page-tabs__item'][data-tab='all']")
    private WebElement tabsAll;

    @FindBy(css = "[class='search-page-tabs'] [class='search-page-tabs__item'][data-tab='professions']")
    private WebElement tabsProfessions;

    @FindBy(css = "[class='search-page-tabs'] [class='search-page-tabs__item'][data-tab='courses']")
    private WebElement tabsCourses;

    @FindBy(css = "[class='search-page-tabs'] [class='search-page-tabs__item'][data-tab='blogs']")
    private WebElement tabsWebinars;

    @FindBy(css = "[class='search-page-tabs'] [class='search-page-tabs__item'][data-tab='all']")
    private WebElement tabsBlogs;

    @FindBy(css = "[class='search-page-tabs'] [class='search-page-tabs__item'][data-tab='forums']")
    private WebElement tabsForums;

    @FindBy(css = "[class='search-page-tabs'] [class='search-page-tabs__item'][data-tab='tests']")
    private WebElement tabsTests;

    @FindBy(css = "[class='search-page-tabs'] [class='search-page-tabs__item'][data-tab='companies']")
    private WebElement tabsCompanies;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("проверяю что в {tab} контент {matcher}")
    public void checkContent(Tab tab, Matcher<Integer> matcher) {
        WebElement webElement = getTab(tab);
        String textElement = webElement.findElement(By.cssSelector("span")).getText();
        assertThat(Integer.valueOf(textElement),matcher);
    }

    public void clickButton(Tab tab){
        getTab(tab).click();
    }

    protected WebElement getTab(Tab tab) {
        switch (tab) {
            case All: {
                return tabsAll;
            }
            case Professions: {
                return tabsProfessions;
            }
            case Courses: {
                return tabsCourses;
            }
            case Webinars: {
                return tabsWebinars;
            }
            case Blogs: {
                return tabsBlogs;
            }
            case Forums: {
                return tabsForums;
            }
            case Tests: {
                return tabsTests;
            }
            case Companies: {
                return tabsCompanies;
            }
        }
        throw new ButtonNotFoundException();
    }

    public enum Tab {
        All,
        Professions,
        Courses,
        Webinars,
        Blogs,
        Forums,
        Tests,
        Companies
    }
}
