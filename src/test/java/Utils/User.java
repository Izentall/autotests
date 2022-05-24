package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class User
{
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password)
    {
        this.setName(name);
        this.setLogin(login);
        this.setPassword(password);
    }

    public User(User user)
    {
        this(user.name, user.login, user.password);
    }

    public User() {}

    public static String getMyPassword() throws IOException
    {
        FileReader reader = new FileReader("src\\test\\resources\\password.txt");
        Scanner scanner = new Scanner(reader);
        String password = scanner.nextLine();
        reader.close();
        return password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
