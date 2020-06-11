package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.block.CourseNavigation;
import ru.geekbrains.main.site.at.block.LeftNavigation;
import ru.geekbrains.main.site.at.page.content.CoursePage;
import ru.geekbrains.main.site.at.page.content.HomePage;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.concurrent.TimeUnit;

@Feature("Поиск")
@Story("Проверка отображения блоков")
public class CheckCurseTest extends BaseTest {

    @BeforeEach
    void beforeSearchTest() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @DisplayName("Проверка количества контента")
    @Test
    void events() {
        CoursePage page = (CoursePage) new HomePage(driver)
                .getLeftNavigation()
                .clickButton(LeftNavigation.ButtonName.COURSES);

        page
                .closedPopUp()
                .getCourseNavigation().clickTab(CourseNavigation.Tab.Courses);

        page.clickFilter("Бесплатные" , "Тестирование");
        System.out.println();
    }
}
