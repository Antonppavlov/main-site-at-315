package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;
import ru.geekbrains.main.site.at.page.content.TestPage;

import java.util.stream.Stream;

import static ru.geekbrains.main.site.at.block.LeftNavigation.Button;

@Feature("Навигация")
@Story("Переход на страницы")
@DisplayName("Переход на страницы")
public class LeftNavigationTest extends BeforeAndAfterStep {

    public static Stream<Button> stringProviderNotPopUp() {
        return Stream.of(
                Button.EVENTS,
                Button.TOPICS,
                Button.TESTS,
                Button.CAREER
        );

    }

    public static Stream<Button> stringProviderPopUp() {
        return Stream.of(
                Button.POSTS,
                Button.COURSES
        );
    }


    @Description("Тесты которые проверяют функционал без Pop-UP")
    @DisplayName("Нажатие на элемент навагации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProviderNotPopUp")
    public void checkNavigationNotPopUp(Button button) {
        new TestPage(driver)
                .openUrl()
                .getLeftNavigation().clickButton(button)
                .getHeader().checkNamePage(button.getText());
    }

    @Description("Тесты которые проверяют функционал Pop-UP")
    @DisplayName("Нажатие на элемент навагации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProviderPopUp")
    public void checkNavigationPopUp(Button button) {
        new TestPage(driver)
                .openUrl()
                .getLeftNavigation().clickButton(button)
                .closedPopUp()
                .getHeader().checkNamePage(button.getText());
    }
}