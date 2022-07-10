package Pages;

import Pages.Elements.TopToolbar;
import Utils.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage
{
    private static final By USER_NAME = new By.ByXPath(".//div[contains(@class,\"tico ellip\")]");
    private static final By LEFT_TOOLBAR = new By.ByXPath(".//div[contains(@class,\"user-main\")]");
    private static final By POSTS = new By.ByXPath(".//a[@data-l=\"t,userStatuses\"]");
    private final User user;
    public final TopToolbar topToolbar = new TopToolbar();

    public MainPage(User user)
    {
        this.user = user;
    }

    @Step("Посмотреть имя пользователя")
    public String getUserName()
    {
        return $(USER_NAME).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).getText();
    }

    @Step("Обновить главную страницу")
    public MainPage refresh()
    {
        Selenide.refresh();
        return new MainPage(user);
    }

    @Step("Нажать на кнопку \"Заметки\"")
    public PostPage clickOnPosts()
    {
        $(POSTS).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        return new PostPage(user);
    }

    @Step("Проверка главной страницы")
    @Override
    public boolean checkCorrectPage()
    {
        return isDisplayed(LEFT_TOOLBAR);
    }
}
