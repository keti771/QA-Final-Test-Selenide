package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    private final SelenideElement myAccountMenu = $x("//header//nav//div[2]/button");

    private final SelenideElement loginForm = $x("//header//nav//div[2]/div");

    private final SelenideElement emailInput = $x("//form[contains(@class,'Form')]//input[@id='email']");

    // პაროლის ველიც დავაზუსტოთ, რომ ქვემოთ სხვაგან არ ეძებოს
    private final SelenideElement passwordInput = $x("//form[contains(@class,'Form')]//input[@type='password']");

    // შესვლის ღილაკი (ზუსტად იმ ფორმიდან, სადაც ტექსტია "Sign in")
    private final SelenideElement signInButton = $x("//form[contains(@class,'Form')]//button[text()='Sign in']");
    //private final SelenideElement forgotPasswordLink = $x("//form[contains(@class,'Form')]//button[text()='Forgot password?']");
    private final SelenideElement successDashboard = $x("//button[contains(text(),'Logout')]");

    public LoginPage openPage() {
        open("https://qatest-dev.indvp.com/");
        return this;
    }
    public LoginPage waitForForm() {
        loginForm.shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("ზედა მენიუში Sign In-ზე დაკლიკება")
    public LoginPage clickMyAccountMenu() {
        // ჯერ ველოდებით, რომ მენიუ გამოჩნდეს და მერე ვაკლიკებთ
        myAccountMenu.shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("ვწერთ იმეილს")
    public LoginPage enterEmail(String email) {
        emailInput.shouldBe(visible).setValue(email);
        return this;
    }

    @Step("ვწერთ პაროლს")
    public LoginPage enterPassword(String password) {
        passwordInput.shouldBe(visible).setValue(password);
        return this;
    }

    @Step("ვაკლიკებთ Sign In ღილაკზე")
    public LoginPage clickSignInButton() {
        signInButton.shouldBe(visible).click();
        return this;
    }

    @Step("ვამოწმებთ სისტემაში წარმატებით შესვლას(Assertion)")
    public void verifySuccessfulLogin() {
        // Selenide-ის ჩაშენებული ასერტი, რომელიც ამოწმებს არის თუ არა ელემენტი ხილვადი
        successDashboard.shouldBe(visible, Duration.ofSeconds(15));
    }
}