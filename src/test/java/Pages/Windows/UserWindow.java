package Pages.Windows;

import Pages.Elements.TopToolbar;
import Pages.LoginPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static Pages.BasePage.STANDARD_WAIT_TIME_MILLIS;
import static com.codeborne.selenide.Selenide.$;

public class UserWindow
{
    private static final By EXIT_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"logout\")]");
    private static final By LOGOUT_FORM_EXIT_BUTTON = new By.ByXPath(".//*[contains(@id,\"hook_FormButton_logoff\")]");
    public final TopToolbar topToolbar = new TopToolbar();

    @Step("Выйти")
    public LoginPage logout()
    {
        $(EXIT_BUTTON).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        $(LOGOUT_FORM_EXIT_BUTTON).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        return new LoginPage();
    }
}
