package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;
import ru.geekbrains.main.site.at.block.SearchTabsBlock;
import ru.geekbrains.main.site.at.page.content.TestPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

@Feature("Поиск")
@Story("Проверка отображения блоков")
public class SearchTest extends BeforeAndAfterStep {

    @BeforeEach
    void beforeSearchTest() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @DisplayName("Проверка количества контента")
    @Test
    void searchTest() {
        new TestPage(driver)
                .openUrl()
                .getHeader()
                .searchText("java")
                .getSearchTabsBlock()
                .checkCount(SearchTabsBlock.Tab.Professions, greaterThanOrEqualTo(2))
                .checkCount(SearchTabsBlock.Tab.Courses, greaterThan(15))
                .checkCount(SearchTabsBlock.Tab.Webinars, allOf(greaterThan(180), lessThan(300)))
                .checkCount(SearchTabsBlock.Tab.Blogs, greaterThan(300))
                .checkCount(SearchTabsBlock.Tab.Forums, not(350))
                .checkCount(SearchTabsBlock.Tab.Tests, not(0));
    }
}
