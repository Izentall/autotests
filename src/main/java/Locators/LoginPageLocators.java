package Locators;

import org.openqa.selenium.By;

public class LoginPageLocators
{
    public static final By EMAIL_FIELD = new By.ById("field_email");
    public static final By PASSWORD_FIELD = new By.ById("field_password");
    public static final By LOGIN_BUTTON = new By.ByXPath(".//*[@type=\"submit\"]");
    public static final By LOGIN_ERROR = new By.ByXPath(".//*[contains(@class,\"input-e\")]");
}
