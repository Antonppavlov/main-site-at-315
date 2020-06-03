package ru.geekbrains.main.site.at.site;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.main.site.at.page.HomePage;
import ru.geekbrains.main.site.at.site.base.BaseTest;

import java.util.stream.Stream;

@Feature("Здесь Название тестируемого функционала")
@Story("Здесь Название Тестового-набора")
@DisplayName("Проверка Навигации")
public class NavigationTest extends BaseTest {

    public static Stream<String> stringProviderNotPopUp() {
        return Stream.of(
                "Вебинары",
                "Форум",
                "Тесты",
                "Карьера"
        );
    }

    public static Stream<String> stringProviderPopUp() {
        return Stream.of(
                "Блог",
                "Курсы"
        );
    }

    @Description("Тесты которые проверяют функционал без Pop-UP")
    @DisplayName("Нажатие на элемент навагации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProviderNotPopUp")
    public void checkNavigationNotPopUp(String name) {
        new HomePage(driver)
                .getNavigation().clickButton(name)
                .checkNamePage(name);
    }

    @Description("Тесты которые проверяют функционал Pop-UP")
    @DisplayName("Нажатие на элемент навагации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProviderPopUp")
    public void checkNavigationPopUp(String name) {
        new HomePage(driver)
                .getNavigation().clickButton(name)
                .closedPopUp()
                .checkNamePage(name);
    }
}
