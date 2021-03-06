package ru.geekbrains.main.site.at.block;

import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.page.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTabsBlock extends BasePageObject {

    @FindBy(css = "[class='search-page-tabs'] [data-tab='all']")
    private WebElement tabEveryWhere;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='professions']")
    private WebElement tabProfessions;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='courses']")
    private WebElement tabCourses;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='webinars']")
    private WebElement tabWebinars;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='blogs']")
    private WebElement tabBlogs;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='forums']")
    private WebElement tabForums;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='tests']")
    private WebElement tabTests;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='companies']")
    private WebElement tabCompanies;

    public SearchTabsBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickTab(Tab tab) {
        getTab(tab).click();
    }

    public SearchTabsBlock checkCount(Tab tab, Matcher<Integer> matcher) {
        String actualCount = getTab(tab).findElement(By.cssSelector("span")).getText();
        assertThat(Integer.parseInt(actualCount), matcher);
        return this;
    }

    private WebElement getTab(Tab tab) {
        switch (tab) {
            case Everywhere:
                return tabEveryWhere;
            case Professions:
                return tabProfessions;
            case Courses:
                return tabCourses;
            case Webinars:
                return tabWebinars;
            case Blogs:
                return tabBlogs;
            case Forums:
                return tabForums;
            case Tests:
                return tabTests;
            case Companies:
                return tabCompanies;
            default:
                throw new IllegalStateException("Unexpected value: " + tab);
        }
    }


//    Enum —  класс. Но он специально «заточен» на решение задач: создание некоторого ограниченного круга значений.
//    Список который имеет ограниченного, неизменяемый набор значений
//    В нашем случае позволяет определив в одном месте, использовать этот список везде в проекте.
//    И не дать возможность пользователю ошибится с названием кнопки

    public enum Tab {
        Everywhere("Везде"),
        Professions("Профессии"),
        Courses("Курсы"),
        Webinars("Вебинары"),
        Blogs("Блоги"),
        Forums("Форумы"),
        Tests("Тесты"),
        Companies("Компании");

        private String text;

        Tab(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}

