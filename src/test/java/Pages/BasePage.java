package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage
{
    public static int STANDARD_WAIT_TIME_MILLIS = 5000;

    public boolean isDisplayed(By by)
    {
        return $(by).isDisplayed();
    }

    public abstract boolean checkCorrectPage();
}
