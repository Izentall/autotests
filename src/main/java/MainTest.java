import Utils.User;
import Pages.LoginPage;
import Pages.MainPage;
import Utils.UserBuilder;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;


public class MainTest
{
    private static final String OK_RU_URL = "https://ok.ru/";

    @Test
    public void testLogin()
    {
        try
        {
            open(OK_RU_URL);
            User user = new UserBuilder()
                    .setName("Юрий Кичигин")
                    .setLogin("+79022715570")
                    .setPassword(User.getMyPassword())
                    .build();
            MainPage mainPage = new LoginPage().login(user);
            assert mainPage.getUserName().equals(user.getName());
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
            open(OK_RU_URL);
            User user = new UserBuilder()
                    .setName("Юрий Кичигин")
                    .setLogin("+79022715570")
                    .setPassword(User.getMyPassword())
                    .build();
            new LoginPage().login(user);
            closeWindow();
            assert false;
        }
        catch (Exception exception)
        {
            closeWindow();
            assert exception.getMessage().equals("Wrong login or password");
        }
    }

    @Test
    public void testLogout()
    {
        try
        {
            open(OK_RU_URL);
            User user = new UserBuilder()
                    .setName("Юрий Кичигин")
                    .setLogin("+79022715570")
                    .setPassword(User.getMyPassword())
                    .build();
            MainPage mainPage = new LoginPage().login(user);
            LoginPage loginPage = mainPage.topToolbar.clickOnUserButton().logout();
            assert loginPage.checkCorrectPage();
        }
        catch (Exception exception)
        {
            System.err.println(exception.getMessage());
            assert false;
        }
        closeWindow();
    }
}
