package Pages;

import Utils.TopToolbar;
import Utils.User;

public class SearchPage extends BasePage
{
    private final User user;
    public final TopToolbar topToolbar = new TopToolbar();

    public SearchPage(User user)
    {
        this.user = user;
    }
}
