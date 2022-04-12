package Pages.Windows;

import Utils.TopToolbar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MessagesWindow
{
    private static final By CLOSE_BUTTON = new By.ByXPath(".//*[contains(@id,\"hook_Block_MessagesLayer\")]/div/div/div[contains(@data-l,\"closeLayer\")]");
    public final TopToolbar topToolbar = new TopToolbar();

    public void close()
    {
        $(CLOSE_BUTTON).click();
    }
}
