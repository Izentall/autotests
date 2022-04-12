package Pages.Windows;

import Utils.TopToolbar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MusicWindow
{
    private static final By CLOSE_BUTTON = new By.ByXPath(".//*[contains(@id,\"music_layer_holder\")]/div[contains(@class,\"toolbar-layer_close\")]");
    public final TopToolbar topToolbar = new TopToolbar();

    public void close()
    {
        $(CLOSE_BUTTON).click();
    }
}
