package Pages.Elements;

import Pages.GuestsPage;
import Pages.MainPage;
import Pages.SearchPage;
import Pages.Windows.*;
import Utils.User;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static Pages.BasePage.STANDARD_WAIT_TIME_MILLIS;
import static com.codeborne.selenide.Selenide.$;

public class TopToolbar
{
    private static final By TO_MAIN_PAGE_BUTTON = new By.ByXPath(".//*[contains(@id,\"topPanelLeftCorner\")]");
    private static final By MESSAGES_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"messages\")]");
    private static final By DISCUSSIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"discussions\")]");
    private static final By NOTIFICATIONS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"notifications\")]");
    private static final By GUESTS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"guests\")]");
    private static final By MARKS_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"marks\")]");
    private static final By MUSIC_BUTTON = new By.ByXPath(".//*[contains(@data-l,\"music\")]");
    private static final By SEARCH_FIELD = new By.ByXPath(".//*[contains(@id,\"toolbar_search\")]");
    private static final By USER_BUTTON = new By.ByXPath("//div[contains(@id,\"hook_Block_ToolbarUserDropdown\")]//div[contains(@class,\"toolbar_dropdown\")]");

    @Step("Нажать на кнопку \"Одноклассники\"")
    public MainPage clickOnMainPageButton(User user)
    {
        $(TO_MAIN_PAGE_BUTTON).click();
        return new MainPage(user);
    }

    @Step("Нажать на кнопку \"Сообщения\"")
    public MessagesWindow clickOnMessagesButton()
    {
        $(MESSAGES_BUTTON).click();
        return new MessagesWindow();
    }

    @Step("Нажать на кнопку \"Обсуждения\"")
    public DiscussionsWindow clickOnDiscussionsButton()
    {
        $(DISCUSSIONS_BUTTON).click();
        return new DiscussionsWindow();
    }

    @Step("Нажать на кнопку \"Оповещения\"")
    public NotificationsWindow clickOnNotificationsButton()
    {
        $(NOTIFICATIONS_BUTTON).click();
        return new NotificationsWindow();
    }

    @Step("Нажать на кнопку \"Гости\"")
    public GuestsPage clickOnGuestsButton(User user)
    {
        $(GUESTS_BUTTON).click();
        return new GuestsPage(user);
    }

    @Step("Нажать на кнопку \"События\"")
    public MarksWindow clickOnMarksButton()
    {
        $(MARKS_BUTTON).click();
        return new MarksWindow();
    }

    @Step("Нажать на кнопку \"Музыка\"")
    public MusicWindow clickOnMusicButton()
    {
        $(MUSIC_BUTTON).click();
        return new MusicWindow();
    }

    @Step("Выполнить поиск строки \"{string}\"")
    public SearchPage search(String string, User user)
    {
        $(SEARCH_FIELD).setValue(string).pressEnter();
        return new SearchPage(user);
    }

    @Step("Нажать на кнопку \"Пользователь\"")
    public UserWindow clickOnUserButton()
    {
        $(USER_BUTTON).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        return new UserWindow();
    }
}
