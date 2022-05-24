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

public class DeleteMessageTest extends BaseTest
{
    @Tag("Messages")
    @Test
    @DisplayName("Тест удаления сообщений")
    @Description("Отправляет сообщение, затем удаляет его и проверяет его отсутствие после обновления страницы")
    public void testDeleteMessage()
    {
        String interlocutorName = "Евгений Буровников";
        String message = "Удалить";
        MainPage mainPage = new LoginPage().login(user);
        MessagesWindow messagesWindow = mainPage.topToolbar.clickOnMessagesButton();
        Interlocutor interlocutor = messagesWindow.getInterlocutor(interlocutorName);
        messagesWindow.sendMessage(interlocutor, message);
        List<Message> messageList = messagesWindow.getMessages(interlocutor);
        int prevAmountOfMessages = messageList.size();
        messagesWindow.deleteMessage(interlocutor, messageList, prevAmountOfMessages - 1);
        messagesWindow.close();
        mainPage = mainPage.refresh();
        messagesWindow = mainPage.topToolbar.clickOnMessagesButton();
        interlocutor = messagesWindow.getInterlocutor(interlocutorName);
        int currentAmountOfMessages = messagesWindow.getMessages(interlocutor).size();
        Assertions.assertEquals(prevAmountOfMessages - 1, currentAmountOfMessages);
    }
}
