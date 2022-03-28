package Pages;

import Bots.User;
import Locators.LoginPageLocators;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage
{
    private static final String URL = "https://ok.ru/";

    public LoginPage()
    {
        open(URL);
    }

    public MainPage login(User user)
    {
        $(LoginPageLocators.EMAIL_FIELD).sendKeys(user.login);
        $(LoginPageLocators.PASSWORD_FIELD).sendKeys(user.password);
        $(LoginPageLocators.LOGIN_BUTTON).click();
        if ($(LoginPageLocators.LOGIN_ERROR).isDisplayed())
        {
            throw new IllegalArgumentException("Wrong login or password");
        }
        return new MainPage();
    }
}
