package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.block.Header;
import ru.geekbrains.main.site.at.block.LeftNavigation;

public class HomePage extends BasePage {

    private LeftNavigation leftNavigation;
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.leftNavigation = new LeftNavigation(driver);
        this.header = new Header(driver);
        PageFactory.initElements(driver, this);
    }

    public LeftNavigation getLeftNavigation() {
        return leftNavigation;
    }

    public Header getHeader() {
        return header;
    }

    @Override
    public HomePage closedPopUp() {
        super.closedPopUp();
        return this;
    }
}
