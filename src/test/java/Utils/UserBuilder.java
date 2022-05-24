package Utils;

public class UserBuilder
{
    private final User user = new User();

    public UserBuilder setName(String name)
    {
        user.setName(name);
        return this;
    }

    public UserBuilder setLogin(String login)
    {
        user.setLogin(login);
        return this;
    }

    public UserBuilder setPassword(String password)
    {
        user.setPassword(password);
        return this;
    }

    public User build()
    {
        return new User(user);
    }
}
