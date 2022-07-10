package Tests.AllureExamples;

import Tests.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UnknownTest extends BaseTest
{
    @Tag("Неизвестная проблема")
    @Test
    @DisplayName("Тест категории \"Неизвестная проблема\"")
    @Description("Должен попасть в категорию \"Неизвестная проблема\", имея в stacktrace фразу \"что-то пошло не так\"")
    public void testCategoryUnknown()
    {
        throw new IllegalArgumentException("что-то пошло не так");
    }
}
