package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.main.site.at.page.content.HomePage;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.stream.Stream;

import static ru.geekbrains.main.site.at.block.LeftNavigation.ButtonName;

@Feature("Навигация")
@Story("Переход на страницы")
@DisplayName("Переход на страницы")
public class LeftNavigationTest extends BaseTest {

    public static Stream<ButtonName> stringProviderNotPopUp() {
        return Stream.of(
                ButtonName.EVENTS,
                ButtonName.TOPICS,
                ButtonName.TESTS,
                ButtonName.CAREER
        );

    }

    public static Stream<ButtonName> stringProviderPopUp() {
        return Stream.of(
                ButtonName.POSTS,
                ButtonName.COURSES
        );
    }


    @Description("Тесты которые проверяют функционал без Pop-UP")
    @DisplayName("Нажатие на элемент навагации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProviderNotPopUp")
    public void checkNavigationNotPopUp(ButtonName button) {
        new HomePage(driver)
                .getLeftNavigation().clickButton(button);
//                .getHeader().checkNamePage(button.getText());
    }

    @Description("Тесты которые проверяют функционал Pop-UP")
    @DisplayName("Нажатие на элемент навагации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProviderPopUp")
    public void checkNavigationPopUp(ButtonName button) {
        new HomePage(driver)
                .getLeftNavigation().clickButton(button)
                .closedPopUp();
//                .getHeader().checkNamePage(button.getText());
    }
}