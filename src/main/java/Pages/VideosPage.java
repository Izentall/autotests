package Pages;

import Utils.TopToolbar;
import Utils.User;

public class VideosPage extends BasePage
{
    private final User user;
    public final TopToolbar topToolbar = new TopToolbar();

    public VideosPage(User user)
    {
        this.user = user;
    }
}
