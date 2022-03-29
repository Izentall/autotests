package Pages;

import Utils.User;
import Locators.LoginPageLocators;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage
{
    public MainPage login(User user)
    {
        $(LoginPageLocators.EMAIL_FIELD).sendKeys(user.login);
        $(LoginPageLocators.PASSWORD_FIELD).sendKeys(user.password);
        $(LoginPageLocators.LOGIN_BUTTON).click();
        if ($(LoginPageLocators.LOGIN_ERROR).isDisplayed())
        {
            throw new IllegalArgumentException("Wrong login or password");
        }
        return new MainPage(user);
    }
}
