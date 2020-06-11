package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.page.AuthorizationPage;
import ru.geekbrains.main.site.at.base.BaseTest;

@Feature("Авторизация")
@Story("Проверка авторизации")
@DisplayName("Проверка авторизации")
public class AuthorizationTest extends BaseTest {

    @DisplayName("Проверка авторизации с корректными данными")
    @Test
    void events() {
        new AuthorizationPage(driver)
                .openUrl()
                .login("hao17583@bcaoo.com","hao17583")
                .getHeader().checkNamePage("Главная");
    }

}
