package Pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class BasePage
{
    public boolean isDisplayed(By by)
    {
        return $(by).isDisplayed();
    }
}
