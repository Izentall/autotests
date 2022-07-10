package Tests.LoginTests;

import Pages.LoginPage;
import Pages.MainPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class CorrectLoginTest extends BaseTest
{
    @Tag("Login")
    @Test
    @DisplayName("Тест входа в Одноклассники")
    @Description("Проверяет вход в Одноклассники с правильными данными")
    @Owner("Кичигин Юрий Сергеевич")
    public void testLogin()
    {
        MainPage mainPage = new LoginPage().login(user);
        Assertions.assertTrue(mainPage.checkCorrectPage());
        Assertions.assertEquals(mainPage.getUserName(), user.getName());
    }
}
