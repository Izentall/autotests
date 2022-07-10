package Pages;

import Pages.Elements.TopToolbar;
import Utils.User;

import static com.codeborne.selenide.WebDriverRunner.url;

public class GuestsPage extends BasePage
{
    private final User user;
    public final TopToolbar topToolbar = new TopToolbar();

    public GuestsPage(User user)
    {
        this.user = user;
    }

    @Override
    public boolean checkCorrectPage()
    {
        return url().contains("ok.ru/guests");
    }
}
