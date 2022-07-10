package Pages;

import Pages.Elements.Post;
import Pages.Elements.TopToolbar;
import Utils.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PostPage extends BasePage
{
    private static final By WRITE_POST = new By.ByXPath(".//div[@class=\"pf-head_itx\"]");
    private static final By POST_TEXT_FIELD = new By.ByXPath(".//div[@data-module=\"postingForm/mediaText\"]");
    private static final By SUBMIT = new By.ByXPath(".//div[@data-l=\"t,button.submit\"]");
    private static final By POSTS = new By.ByXPath(".//div[contains(@id,\"hook_Block_mediatopic\")]");

    private final User user;
    public TopToolbar topToolbar;

    public PostPage(User user)
    {
        this.user = user;
        this.topToolbar = new TopToolbar();
    }

    @Step("Обновить страницу \"Заметки\"")
    public PostPage refresh()
    {
        Selenide.refresh();
        return new PostPage(user);
    }

    @Step("Создать заметку")
    public PostPage createPost(String postText)
    {
        $(WRITE_POST).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        $(POST_TEXT_FIELD).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).sendKeys(postText);
        $(SUBMIT).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        return this;
    }

    @Step("Получить список заметок")
    public List<Post> getPostList()
    {
        List<Post> postList = new ArrayList<>();
        $(POSTS).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS));
        ElementsCollection collection = $$(POSTS);
        for (SelenideElement item: collection)
        {
            postList.add(new Post(item));
        }
        return postList;
    }

    @Override
    public boolean checkCorrectPage()
    {
        return $(WRITE_POST).shouldBe(Condition.visible).isDisplayed();
    }
}
