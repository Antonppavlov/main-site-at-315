package ru.geekbrains.main.site.at.block;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.page.BasePageObject;
import ru.geekbrains.main.site.at.utils.ButtonNotFoundException;
import ru.geekbrains.main.site.at.page.content.CoursePage;

public class ContentNavigationCourseBlock extends BasePageObject {

    @FindBy(css = "[class*='nav nav-tabs'] [id='prof-link']")
    private WebElement tabProfessions;

    @FindBy(css = "[class*='nav nav-tabs'] [id='free-link']")
    private WebElement tabFreeIntensive;

    @FindBy(css = "[class*='nav nav-tabs'] [id='cour-link']")
    private WebElement tabCourses;

    @FindBy(css = "[class*='nav nav-tabs'] [href*='https://forbusiness']")
    private WebElement tabCompanies;

    public ContentNavigationCourseBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CoursePage clickTab(Tab tab) {
        switch (tab) {
            case Professions: {
                tabProfessions.click();
                //TODO нужно реализовать для данного блока
            }
            case FreeIntensive: {
                tabFreeIntensive.click();
                //TODO нужно реализовать для данного блока
            }
            case Courses: {
                tabCourses.click();
                return new CoursePage(driver);
            }
            case Companies: {
                tabCompanies.click();
                //TODO нужно реализовать для данного блока
            }
        }
        throw new ButtonNotFoundException();
    }

   public enum Tab {
        Professions,
        FreeIntensive,
        Courses,
        Companies;
    }
}
