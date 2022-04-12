package Pages;

import Utils.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage
{
    private static final By LOGIN_ERROR = new By.ByXPath(".//*[contains(@class,\"input-e\")]");
    private static final By LOGIN_BUTTON = new By.ByXPath(".//*[@type=\"submit\"]");
    private static final By PASSWORD_FIELD = new By.ById("field_password");
    private static final By EMAIL_FIELD = new By.ById("field_email");

    public MainPage login(User user)
    {
        $(EMAIL_FIELD).sendKeys(user.getLogin());
        $(PASSWORD_FIELD).sendKeys(user.getPassword());
        $(LOGIN_BUTTON).click();
        if ($(LOGIN_ERROR).isDisplayed())
        {
            throw new IllegalArgumentException("Wrong login or password");
        }
        return new MainPage(user);
    }

    public boolean checkCorrectPage()
    {
        return isDisplayed(LOGIN_BUTTON) && isDisplayed(PASSWORD_FIELD) && isDisplayed(EMAIL_FIELD);
    }
}
