package Utils;

import Pages.*;
import Pages.Windows.*;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopToolbar
{
    private static final By TO_MAIN_PAGE_BUTTON = new By.ByXPath(".//*[contains(@id,\"topPanelLeftCorner\")]");
    private static final By HELP_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"help\")]");
    private static final By MESSAGES_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"messages\")]");
    private static final By DISCUSSIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"discussions\")]");
    private static final By NOTIFICATIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"notifications\")]");
    private static final By FRIENDS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"friends\")]");
    private static final By GUESTS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"guests\")]");
    private static final By MARKS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"marks\")]");
    private static final By VIDEO_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"video\")]");
    private static final By MUSIC_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"music\")]");
    private static final By SEARCH_FIELD = new By.ByXPath(".//*[contains(@id,\"toolbar_search\")]");
    private static final By USER_BUTTON = new By.ByXPath(".//*[contains(@class,\"toolbar_dropdown\")]");

    public MainPage clickOnMainPageButton(User user)
    {
        $(TO_MAIN_PAGE_BUTTON).click();
        return new MainPage(user);
    }

    public HelpWindow clickOnHelpButton()
    {
        $(HELP_BUTTON).click();
        return new HelpWindow();
    }

    public MessagesWindow clickOnMessagesButton()
    {
        $(MESSAGES_BUTTON).click();
        return new MessagesWindow();
    }

    public DiscussionsWindow clickOnDiscussionsButton()
    {
        $(DISCUSSIONS_BUTTON).click();
        return new DiscussionsWindow();
    }

    public NotificationsWindow clickOnNotificationsButton()
    {
        $(NOTIFICATIONS_BUTTON).click();
        return new NotificationsWindow();
    }

    public FriendsPage clickOnFriendsButton(User user)
    {
        $(FRIENDS_BUTTON).click();
        return new FriendsPage(user);
    }

    public GuestsPage clickOnGuestsButton(User user)
    {
        $(GUESTS_BUTTON).click();
        return new GuestsPage(user);
    }

    public MarksWindow clickOnMarksButton()
    {
        $(MARKS_BUTTON).click();
        return new MarksWindow();
    }

    public VideosPage clickOnVideosPage(User user)
    {
        $(VIDEO_BUTTON).click();
        return new VideosPage(user);
    }

    public MusicWindow clickOnMusicButton()
    {
        $(MUSIC_BUTTON).click();
        return new MusicWindow();
    }

    public SearchPage search(String string, User user)
    {
        $(SEARCH_FIELD).setValue(string).pressEnter();
        return new SearchPage(user);
    }

    public UserWindow clickOnUserButton()
    {
        $(USER_BUTTON).click();
        return new UserWindow();
    }
}
