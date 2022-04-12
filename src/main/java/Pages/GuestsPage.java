package Pages;

import Utils.TopToolbar;
import Utils.User;

public class GuestsPage extends BasePage
{
    private final User user;
    public final TopToolbar topToolbar = new TopToolbar();

    public GuestsPage(User user)
    {
        this.user = user;
    }
}
