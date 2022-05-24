package Tests.MessagesTests;

import Pages.Elements.Interlocutor;
import Pages.Elements.Message;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.Windows.MessagesWindow;
import Tests.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SendMessageTest extends BaseTest
{
    @Tag("Messages")
    @Test
    @DisplayName("Тест отправки сообщений")
    @Description("Отправляет сообщение и проверяет его существование после обновления страницы")
    public void testSendMessage()
    {
        String interlocutorName = "Евгений Буровников";
        String message = "Сообщение";
        MainPage mainPage = new LoginPage().login(user);
        MessagesWindow messagesWindow = mainPage.topToolbar.clickOnMessagesButton();
        Interlocutor interlocutor = messagesWindow.getInterlocutor(interlocutorName);
        int prevAmountOfMessages = messagesWindow.getMessages(interlocutor).size();
        messagesWindow.sendMessage(interlocutor, message).close();
        mainPage = mainPage.refresh();
        messagesWindow = mainPage.topToolbar.clickOnMessagesButton();
        interlocutor = messagesWindow.getInterlocutor(interlocutorName);
        List<Message> messageList = messagesWindow.getMessages(interlocutor);
        int currentAmountOfMessages = messageList.size();
        Assertions.assertEquals(prevAmountOfMessages + 1, currentAmountOfMessages);
        Assertions.assertEquals(message, messageList.get(currentAmountOfMessages - 1).getText());
    }
}
