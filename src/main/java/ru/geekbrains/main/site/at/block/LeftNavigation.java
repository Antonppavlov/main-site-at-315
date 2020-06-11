package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.ButtonNotFoundException;
import ru.geekbrains.main.site.at.page.content.CoursePage;
import ru.geekbrains.main.site.at.page.content.HomePage;

public class LeftNavigation extends BasePage {

    @FindBy(css = "[id='nav'] [href='/courses']")
    private WebElement buttonCourses;

    @FindBy(css = "[id='nav'] [href='/events']")
    private WebElement buttonEvents;

    @FindBy(css = "[id='nav'] [href='/topics']")
    private WebElement buttonTopics;

    @FindBy(css = "[id='nav'] [href='/posts']")
    private WebElement buttonPosts;

    @FindBy(css = "[id='nav'] [href='/tests']")
    private WebElement buttonTests;

    @FindBy(css = "[id='nav'] [href='/career']")
    private WebElement buttonCareer;

    public LeftNavigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("нажатие кнопки '{name}'")
    public BasePage clickButton(ButtonName name) {
        switch (name) {
            case COURSES: {
                buttonCourses.click();
                return new CoursePage(driver);
            }
            case EVENTS: {
                buttonEvents.click();
                //TODO нужно реализовать страницу
                return new HomePage(driver);
            }
            case TOPICS: {
                buttonTopics.click();
                //TODO нужно реализовать страницу
                return new HomePage(driver);
            }
            case POSTS: {
                buttonPosts.click();
                //TODO нужно реализовать страницу
                return new HomePage(driver);
            }
            case TESTS: {
                buttonTests.click();
                //TODO нужно реализовать страницу
                return new HomePage(driver);
            }
            case CAREER: {
                buttonCareer.click();
                //TODO нужно реализовать страницу
                return new HomePage(driver);
            }
        }

        throw new ButtonNotFoundException();
    }

    public enum ButtonName {
        COURSES("Курсы"),
        EVENTS("Вебинары"),
        TOPICS("Форум"),
        POSTS("Блог"),
        TESTS("Тесты"),
        CAREER("Карьера");

        private String text;

        ButtonName(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

}
