package Pages;

import Utils.User;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage
{
    private static final By LOGIN_BUTTON = new By.ByXPath(".//*[@type=\"submit\"]");
    private static final By PASSWORD_FIELD = new By.ByXPath(".//*[@name=\"st.password\"]");
    private static final By EMAIL_FIELD = new By.ByXPath(".//*[@name=\"st.email\"]");

    @Step("Вход")
    public MainPage login(User user)
    {
        $(EMAIL_FIELD).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).sendKeys(user.getLogin());
        $(PASSWORD_FIELD).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).sendKeys(user.getPassword());
        $(LOGIN_BUTTON).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        return new MainPage(user);
    }

    @Step("Проверка страницы \"Логин\"")
    @Override
    public boolean checkCorrectPage()
    {
        return $(EMAIL_FIELD).shouldBe(Condition.visible).isDisplayed()
            && $(PASSWORD_FIELD).shouldBe(Condition.visible).isDisplayed()
            && $(LOGIN_BUTTON).shouldBe(Condition.visible).isDisplayed();
    }
}
