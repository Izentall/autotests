package Tests.LogoutTests;

import Pages.LoginPage;
import Pages.MainPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class LogoutTest extends BaseTest
{
    @Tag("Logout")
    @Test
    @Flaky
    @DisplayName("Тест выхода из Одноклассников")
    @Description("Проверяет корректность выхода из Одноклассников")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogout()
    {
        MainPage mainPage = new LoginPage().login(user);
        LoginPage loginPage = mainPage.topToolbar.clickOnUserButton().logout();
        Assertions.assertTrue(loginPage.checkCorrectPage());
    }
}
