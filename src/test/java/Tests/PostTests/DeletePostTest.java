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

public class DeletePostTest extends BaseTest
{
    @Tag("Posts")
    @Test
    @Flaky
    @DisplayName("Тест удаления поста")
    @Description("Создает пост, затем удаляет его и проверяет, что пост не существует после обновления страницы")
    public void testDeletePost()
    {
        String postText = "Удалить";
        PostPage postPage = new LoginPage().login(user).clickOnPosts();
        postPage = postPage.createPost(postText).refresh();
        List<Post> postList = postPage.getPostList();
        int prevPostAmount = postList.size();
        postList.get(0).delete();
        postPage = postPage.refresh();
        postList = postPage.getPostList();
        int currentPostAmount = postList.size();
        Assertions.assertEquals(prevPostAmount - 1, currentPostAmount);
    }
}
