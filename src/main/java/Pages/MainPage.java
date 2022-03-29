package Pages;

import Locators.MainPageLocators;
import Utils.User;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage
{
    private User user;

    MainPage(User user)
    {
        this.user = user;
    }
    public String getUserName()
    {
        return $(MainPageLocators.USER_NAME).getText();
    }
}
