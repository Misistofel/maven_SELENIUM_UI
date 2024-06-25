package pages;

import com.codeborne.selenide.*;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement emailField = $x("//input[@id='userEmail']");
    private final SelenideElement passwordField = $x("//input[@id='userPassword']");
    private final SelenideElement loginButton = $x("//input[@id = 'login']");
    private final SelenideElement forgotPasswordLinc = $x("//*[@href='/client/auth/password-new']");
    private final SelenideElement registerButton = $x("//*[@href='/client/auth/register']");
//    private final SelenideElement successOrdersButton = $x("//p[text()= 'Successfull Orders']");
//    private final SelenideElement customersButton = $x("//p[text()= 'Customers']");
//    private final SelenideElement sellersButton = $x("//p[text()= 'Sellers']");
//    private final SelenideElement dailyOrdersButton = $x("//p[text()= 'Daily Orders']");
//    private final SelenideElement dailyNewCustomerJoiningButton = $x("//p[text()= 'Daily New Customer Joining']");

    public LoginPage fillEmailField(String usersEmail){
        emailField.shouldBe(visible).sendKeys(usersEmail);
        return this;
    }

    public LoginPage fillPasswordField(String usersPwd){
        passwordField.shouldBe(visible).sendKeys(usersPwd);
        return this;
    }

    public AutomationPage  pushLoginButton(){
        loginButton.shouldBe(visible).click();
        return new AutomationPage();
    }

    public EnterNewPwdPage pushForgetPwdButton(){
        forgotPasswordLinc.shouldBe(visible).click();
        return new EnterNewPwdPage();
    }

    public RegisterPage pushRegisterLink(){
        registerButton.shouldBe(visible).click();
        return new RegisterPage();
    }
}
