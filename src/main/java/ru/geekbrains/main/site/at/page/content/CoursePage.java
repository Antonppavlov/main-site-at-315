package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.block.CourseNavigation;
import ru.geekbrains.main.site.at.block.Header;
import ru.geekbrains.main.site.at.block.LeftNavigation;

import java.util.List;

public class CoursePage extends BasePage {

    @FindBy(css = "[class=\"list-group\"] label")
    private List<WebElement> filterList;

    private LeftNavigation leftNavigation;
    private CourseNavigation courseNavigation;
    private Header header;

    public CoursePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.leftNavigation = new LeftNavigation(driver);
        this.courseNavigation = new CourseNavigation(driver);
        this.header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    public LeftNavigation getLeftNavigation() {
        return leftNavigation;
    }

    public Header getHeader() {
        return header;
    }

    public CourseNavigation getCourseNavigation() {
        return courseNavigation;
    }

    @Override
    public CoursePage closedPopUp() {
        super.closedPopUp();
        return this;
    }

    public CoursePage clickFilter(String... filer) {
        for (String text : filer) {
            for (WebElement element : filterList) {
                if (element.getText().equals(text)) {
                    element.click();
                }
            }
        }
        return this;
    }
}
