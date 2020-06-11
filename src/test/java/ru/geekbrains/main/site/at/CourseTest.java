package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.block.ContentNavigationCourseBlock;
import ru.geekbrains.main.site.at.block.LeftNavigation;
import ru.geekbrains.main.site.at.page.content.CoursePage;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;

@Feature("Поиск")
@Story("Проверка отображения блоков")
@DisplayName("Страница Курсы")
public class CourseTest extends BeforeAndAfterStep {

    @DisplayName("Проверка работы фильтров")
    @Test
    void checkSingInValidLogin() {
        ((CoursePage)
                new CoursePage(driver)
                        .openUrl()
                        .closedPopUp()
                        .getLeftNavigation()
                        .clickButton(LeftNavigation.Button.COURSES)
        )
                .getContentNavigationCourseBlock().clickTab(ContentNavigationCourseBlock.Tab.Courses)
                .configFilter("Бесплатные", "Тестирование")
                .checkingDisplayedCourses(
                        "Тестирование ПО. Уровень 1",
                        "Тестирование ПО. Уровень 2"
                )
        ;

    }
}
