package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import com.codeborne.selenide.Selenide;

@Epic("ავტორიზაციის მოდული")
@Feature("სისტემაში შესვლა")
public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(description = "TC: ავტორიზაცია (sign in) სწორი იმეილით და პაროლით")
    @Severity(SeverityLevel.BLOCKER)
    @Description("ვამოწმებთ, შევალთ თუ არა სისტემაში მომხმარებლის სწორი მეილით და პაროლით")
    public void testSuccessfulLogin() {

        loginPage
                .clickMyAccountMenu()
                .waitForForm()
                .enterEmail("Ana.Barns@gmail.com")
                .enterPassword("Teodetoto123")
                .clickSignInButton();

        // Assert
        loginPage.verifySuccessfulLogin();
        //დეშბორდი რომ დავინახო, დავაყოვნებ ბრაუზერს
        Selenide.sleep(5000);
    }
}