package Pages.Windows;

import Pages.LoginPage;
import Utils.TopToolbar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserWindow
{
    private static final By EXIT_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"logout\")]");
    public final TopToolbar topToolbar = new TopToolbar();

    public LoginPage logout()
    {
        $(EXIT_BUTTON).click();
        return new LoginPage();
    }
}
