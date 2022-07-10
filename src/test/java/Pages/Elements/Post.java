package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static Pages.BasePage.STANDARD_WAIT_TIME_MILLIS;
import static com.codeborne.selenide.Selenide.$;

public class Post
{
    private static final By TEXT = new By.ByXPath(".//div[@class=\"media-text_cnt\"]/div");
    private static final By MENU = new By.ByXPath(".//span[@class=\"new_topic_icodown\"]");
    private static final By EDIT = new By.ByXPath(".//div[@id=\"hook_Block_ShortcutMenu\"]//a[contains(@hrefattrs,\"StatusLayer_editButton\")]");
    private static final By POST_TEXT_FIELD = new By.ByXPath(".//div[@data-module=\"postingForm/mediaText\"]/div");
    private static final By SUBMIT = new By.ByXPath(".//div[@data-l=\"t,button.submit\"]");
    private static final By CLOSE_TEXT_FIELD = new By.ByXPath(".//div[@class=\"ic media-layer_close_ico\"]");
    private static final By DELETE = new By.ByXPath(".//div[@id=\"hook_Block_ShortcutMenu\"]//a[contains(@hrefattrs,\"StatusLayer_deleteButton\")]");
    private final SelenideElement item;

    public Post(SelenideElement item)
    {
        this.item = item;
    }

    @Step("Прочитать заметку")
    @Attachment
    public String getText()
    {
        return item.find(TEXT).getText();
    }

    @Step("Редактировать заметку")
    public void edit(String newText)
    {
        if ($(CLOSE_TEXT_FIELD).isDisplayed())
            $(CLOSE_TEXT_FIELD).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        item.find(MENU).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        $(EDIT).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        $(POST_TEXT_FIELD).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).setValue(newText);
        $(SUBMIT).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
    }

    @Step("Удалить заметку")
    public void delete()
    {
        if ($(CLOSE_TEXT_FIELD).isDisplayed())
            $(CLOSE_TEXT_FIELD).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        item.find(MENU).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        $(DELETE).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
    }
}
