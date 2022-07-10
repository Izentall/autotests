package Tests;

import Utils.ScreenshotExtension;
import Utils.User;
import Utils.UserBuilder;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

@ExtendWith(ScreenshotExtension.class)
public class BaseTest
{
    protected static User user;

    private static final String OK_RU_URL = "https://ok.ru/";
    @BeforeAll
    public static void setup()
    {
        Configuration.pageLoadTimeout = 300000;
    }

    @BeforeEach
    public void createUser()
    {
        try
        {
            user = new UserBuilder()
                    .setName("Юрий Кичигин")
                    .setLogin("+79022715570")
                    .setPassword(User.getMyPassword())
                    .build();
        } catch (IOException exception)
        {
            System.err.println(exception.getMessage());
            assert false;
        }
    }

    @BeforeEach
    public void openUrl()
    {
        open(OK_RU_URL);
        getWebDriver().manage().timeouts().pageLoadTimeout(100, SECONDS);
    }
}
