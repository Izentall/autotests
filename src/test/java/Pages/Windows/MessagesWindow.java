package Pages.Windows;

import Pages.Elements.Interlocutor;
import Pages.Elements.Message;
import Pages.Elements.TopToolbar;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static Pages.BasePage.STANDARD_WAIT_TIME_MILLIS;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagesWindow
{
    private static final By CLOSE_BUTTON = new By.ByXPath(".//*[contains(@id,\"hook_Block_MessagesLayer\")]/div/div/div[contains(@data-l,\"closeLayer\")]");
    private static final By INTERLOCUTORS = new By.ByXPath(".//msg-chats-list-item");
    private static final By MESSAGES = new By.ByXPath(".//msg-message");
    private static final By MESSAGE_FIELD = new By.ByXPath(".//msg-input");
    private static final By MORE_ACTIONS = new By.ByXPath(".//*[@data-l=\"t,messageActionmore\"]");
    private static final By DELETE = new By.ByXPath(".//*[@key=\"message-action-remove\"]");
    private static final By CONFIRM = new By.ByXPath("//*[@data-tsid=\"confirm-primary\"]");

    public final TopToolbar topToolbar = new TopToolbar();
    private final List<Interlocutor> interlocutorList;

    public MessagesWindow()
    {
        interlocutorList = new ArrayList<>();
        $(INTERLOCUTORS).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS));
        ElementsCollection collection = $$(INTERLOCUTORS);
        for (SelenideElement item: collection)
        {
            interlocutorList.add(new Interlocutor(item));
        }
    }

    public Interlocutor getInterlocutor(String name)
    {
        for (Interlocutor interlocutor: interlocutorList)
        {
            if (interlocutor.getName().equals(name))
            {
                return interlocutor;
            }
        }
        throw new NoSuchElementException("Собеседник " + name + " не найден");
    }

    @Step("Отправить сообщение")
    public MessagesWindow sendMessage(Interlocutor interlocutor, String message)
    {
        interlocutor.click();
        $(MESSAGE_FIELD).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).setValue(message).pressEnter();
        return this;
    }

    @Step("Получить список сообщений")
    public List<Message> getMessages(Interlocutor interlocutor)
    {
        interlocutor.click();
        List<Message> messageList = new ArrayList<>();
        $(MESSAGES).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS));
        ElementsCollection collection = $$(MESSAGES);
        for (SelenideElement item: collection)
        {
            messageList.add(new Message(item));
        }
        return messageList;
    }

    @Step("Удалить сообщение")
    public void deleteMessage(Interlocutor interlocutor, List<Message> messageList, int index)
    {
        interlocutor.click();
        Message message = messageList.get(index);
        message.click();
        $(MORE_ACTIONS).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        $(DELETE).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        $(CONFIRM).should(Condition.visible, Duration.ofMillis(STANDARD_WAIT_TIME_MILLIS)).click();
        messageList.remove(index);
    }

    @Step("Закрыть сообщения")
    public void close()
    {
        $(CLOSE_BUTTON).click();
    }
}
