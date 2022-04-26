package Pages;

import Utils.TopToolbar;
import Utils.User;

public class FriendsPage extends BasePage
{
    private final User user;
    public final TopToolbar topToolbar = new TopToolbar();

    public FriendsPage(User user)
    {
        this.user = user;
    }
}
