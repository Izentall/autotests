package Tests.PostTests;

import Pages.Elements.Post;
import Pages.LoginPage;
import Pages.PostPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EditPostTest extends BaseTest
{
    @Tag("Posts")
    @Test
    @Flaky
    @DisplayName("Тест изменения поста")
    @Description("Создает пост, затем изменяет его и проверяет, что изменения вступили в силу после обновления страницы")
    public void testEditPost()
    {
        String postText = "Тестовый пост";
        String editedPostText = "Измененный тестовый пост";
        PostPage postPage = new LoginPage().login(user).clickOnPosts();
        postPage = postPage.createPost(postText).refresh();
        List<Post> postList = postPage.getPostList();
        int prevPostAmount = postList.size();
        postList.get(0).edit(editedPostText);
        postPage = postPage.refresh();
        postList = postPage.getPostList();
        int currentPostAmount = postList.size();
        Assertions.assertEquals(prevPostAmount, currentPostAmount);
        Assertions.assertEquals(editedPostText, postList.get(0).getText());
    }
}
