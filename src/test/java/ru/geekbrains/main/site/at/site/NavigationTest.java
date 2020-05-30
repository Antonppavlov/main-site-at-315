package ru.geekbrains.main.site.at.site;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.main.site.at.page.HomePage;
import ru.geekbrains.main.site.at.site.base.BaseTest;

import java.util.stream.Stream;

@DisplayName("Проверка Навигации")
public class NavigationTest extends BaseTest {

    static Stream<String> stringProvider() {
        return Stream.of(
                "Вебинары",
                "Форум",
                "Блог",
                "Тесты",
                "Карьера",
                "Курсы"
        );
    }

    @DisplayName("Нажатие на элемент навагации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProvider")
    void checkNavigation(String name) {
        new HomePage(driver)
                .getNavigation().clickButton(name)
                .checkNamePage(name);
    }



    //    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы
//    Вебинары
//    Форум
//    Блог
//    Тесты
//    Карьера

    //Много кода
    //Сложно оптимизировать при изменениях
    //Повторяет одни и теже действия
    //тестовые данные в проперти файле
    //6 проверок в одном тесте
}
