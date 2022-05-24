package Pages.Windows;

import Pages.Elements.TopToolbar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NotificationsWindow
{
    private static final By CLOSE_BUTTON = new By.ByXPath(".//*[contains(@id,\"ntf_layer\")]/div/div/div[contains(@data-l,\"close-control\")]");
    public final TopToolbar topToolbar = new TopToolbar();

    public void close()
    {
        $(CLOSE_BUTTON).click();
    }
}
