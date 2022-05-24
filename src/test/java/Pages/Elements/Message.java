package Pages.Elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class Message
{
    private static final By TEXT = new By.ByXPath(".//msg-parsed-text");

    private final SelenideElement item;

    public Message(SelenideElement item)
    {
        this.item = item;
    }

    @Step("Прочитать сообщение")
    @Attachment(value = "Сообщение", type = "text/plain")
    public String getText()
    {
        return item.find(TEXT).getText();
    }

    public void click()
    {
        item.click();
    }
}
