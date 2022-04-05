package Pages;

import Utils.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage
{
    private static final By USER_NAME = new By.ByXPath(".//div[contains(@class,\"tico ellip\")]");
    private User user;

    MainPage(User user)
    {
        this.user = user;
    }
    
    public String getUserName()
    {
        return $(USER_NAME).getText();
    }
}
