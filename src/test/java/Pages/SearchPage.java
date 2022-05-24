package Pages;

import Pages.Elements.TopToolbar;
import Utils.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchPage extends BasePage
{
    private static final By SEARCH_FILTERS = new By.ByXPath(".//*[contains(@class,\"search-filters\")]");
    private final User user;
    public final TopToolbar topToolbar = new TopToolbar();

    public SearchPage(User user)
    {
        this.user = user;
    }

    @Step("Проверка страницы \"Поиск\"")
    @Override
    public boolean checkCorrectPage()
    {
        return isDisplayed(SEARCH_FILTERS);
    }
}
