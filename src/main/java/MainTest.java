import Utils.User;
import Pages.LoginPage;
import Pages.MainPage;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
            User user = new User("Юрий Кичигин", "+79022715570", getPassword());
            MainPage mainPage = new LoginPage().login(user);
            assert mainPage.getUserName().equals(user.name);
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
            User user = new User("Юрий Кичигин", "+79022715570", "S");
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

    private static String getPassword() throws IOException
    {
        FileReader reader = new FileReader("src\\main\\resources\\password.txt");
        Scanner scanner = new Scanner(reader);
        String password = scanner.nextLine();
        reader.close();
        return password;
    }
}
