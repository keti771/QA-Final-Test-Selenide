package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeClass
    public void setupAllure() {
        // Allure ლისენერის ჩართვა სქრინშოტებისთვის
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @BeforeMethod
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000; // იგივე 10 წამი

        // პირდაპირ მთავარ ლინკზე გადასვლა
        open("https://qatest-dev.indvp.com/");
    }

    @AfterMethod
    public void tearDown() {
        // ამით ყოველი ტესტის მერე ვხურავთ ბრაუზერს, რათა ქეშები არ აირიოს
        closeWebDriver();
    }
}