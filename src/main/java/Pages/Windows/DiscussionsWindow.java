package Pages.Windows;

import Utils.TopToolbar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DiscussionsWindow
{
    private static final By CLOSE_BUTTON = new By.ByXPath(".//*[contains(@uid,\"closeDisc\")]");
    public final TopToolbar topToolbar = new TopToolbar();

    public void close()
    {
        $(CLOSE_BUTTON).click();
    }
}
