package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.page.content.HomePage;
import ru.geekbrains.main.site.at.page.content.SearchPage;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@Feature("Поиск")
@Story("Проверка отображения блоков")
public class SearchTest extends BaseTest {

    @BeforeEach
    void beforeSearchTest() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @DisplayName("Проверка количества контента")
    @Test
    void events() {
        new HomePage(driver)
                .getHeader().searchInSite("java")
                .checkContent(SearchPage.Tab.Professions, greaterThanOrEqualTo(2));
    }
}
