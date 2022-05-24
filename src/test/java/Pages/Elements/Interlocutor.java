package Pages.Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static Pages.BasePage.STANDARD_WAIT_TIME_MILLIS;

public class Interlocutor
{
    private static final By NAME = new By.ByXPath(".//*[@data-tsid=\"conversation_name\"]//msg-parsed-text");

    private final SelenideElement item;

    public Interlocutor(SelenideElement item)
    {
        this.item = item;
    }

    public String getName()
    {
        return item.find(NAME).getText();
    }

    public void click()
    {
        item.should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
    }
}
