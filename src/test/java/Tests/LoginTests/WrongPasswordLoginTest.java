package Tests.LoginTests;

import Pages.LoginPage;
import Pages.MainPage;
import Tests.BaseTest;
import Utils.UserBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;


public class WrongPasswordLoginTest extends BaseTest
{
    @BeforeEach
    public void createUser()
    {
        user = new UserBuilder()
                .setName("Юрий Кичигин")
                .setLogin("+79022715570")
                .setPassword("1234567890")
                .build();
    }

    @Tag("Login")
    @Test
    @DisplayName("Негативный тест входа в Одноклассники")
    @Description("Проверяет вход в Одноклассники с неправильными данными")
    @Severity(SeverityLevel.MINOR)
    public void testNegativeLogin()
    {
        MainPage mainPage = new LoginPage().login(user);
        Assertions.assertFalse(mainPage.checkCorrectPage());
    }
}
