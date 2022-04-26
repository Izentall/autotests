package Pages.Windows;

import Utils.TopToolbar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HelpWindow
{
    private static final By CLOSE_BUTTON = new By.ByXPath(".//*[contains(@id,\"hft_layer_close\")]");
    public final TopToolbar topToolbar = new TopToolbar();

    public void close()
    {
        $(CLOSE_BUTTON).click();
    }
}
