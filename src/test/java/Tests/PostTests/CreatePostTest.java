package Tests.PostTests;

import Pages.Elements.Post;
import Pages.LoginPage;
import Pages.PostPage;
import Tests.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreatePostTest extends BaseTest
{
    @Tag("Posts")
    @Test
    @DisplayName("Тест создания поста")
    @Description("Создает пост и проверяет его существование после обновления страницы")
    public void testCreatePost()
    {
        String postText = "Тестовый пост";
        PostPage postPage = new LoginPage().login(user).clickOnPosts();
        int prevPostAmount = postPage.getPostList().size();
        postPage = postPage.createPost(postText).refresh();
        List<Post> postList = postPage.getPostList();
        int currentPostAmount = postList.size();
        Assertions.assertEquals(prevPostAmount + 1, currentPostAmount);
        Assertions.assertEquals(postText, postList.get(0).getText());
    }
}
