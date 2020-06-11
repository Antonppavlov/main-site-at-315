package ru.geekbrains.main.site.at.block;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BasePage;

public class CourseNavigation extends BasePage {

    @FindBy(css = "[id='prof-link']")
    private WebElement tabProfessions;

    @FindBy(css = "id=\"free-link\"")
    private WebElement tabFreeIntensive;

    @FindBy(css = "[id=\"cour-link\"]")
    private WebElement tabCourses;

//    @FindBy(css = "[id='prof-link']")
//    private WebElement tabCompanies;

    public CourseNavigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage clickTab(Tab tab) {
        switch (tab) {
            case Professions: {
                tabProfessions.click();
            }
            case FreeIntensive: {
                tabFreeIntensive.click();
            }
            case Courses: {
                tabCourses.click();
            }
//            case Companies: {
//                tabCompanies.click();
//            }
        }
        return this;
    }

   public enum Tab {
        Professions,
        FreeIntensive,
        Courses;
//        Companies;
    }
}
