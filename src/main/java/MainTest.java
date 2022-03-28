import Bots.User;
import Locators.MainPageLocators;
import Pages.LoginPage;
import Pages.MainPage;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWindow;


public class MainTest
{
    @Test
    public void testLogin()
    {
        try
        {
            User user = new User("Юрий Кичигин", "+79022715570", "62e40c2fb$7cs");
            MainPage mainPage = new LoginPage().login(user);
            $(MainPageLocators.USER_NAME).shouldBe(visible).shouldHave(text(user.name));
        }
        catch (Exception exception)
        {
            System.err.println(exception.getMessage());
            assert false;
        }
        closeWindow();
    }

    @Test
    public void testNegativeLogin()
    {
        try
        {
            User user = new User("Юрий Кичигин", "s", "S");
            new LoginPage().login(user);
            assert false;
        }
        catch (Exception exception)
        {
            assert exception.getMessage().equals("Wrong login or password");
        }
    }
}
