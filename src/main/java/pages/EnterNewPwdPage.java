package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EnterNewPwdPage {
    private final SelenideElement emailField = $x("//input[@type='email']");
    private final SelenideElement passwordField = $x("//input[@type='password']");
    private final SelenideElement confirmPasswordField = $x("//input[@id='confirmPassword']");
    private final SelenideElement saveNewPwdButton = $x("//button[@class='btn btn-custom btn-block']");//виправила
    private final SelenideElement loginLinc= $x("//*[text()='Login']");//заміни а на *
    private final SelenideElement registerLinc= $x("//*[@href='/client/auth/register']");//заміни текст на щось і заміниа на *

    public LoginPage  clickLoginLinc(){
        loginLinc.shouldBe(visible).click();
        return new LoginPage();
    }

    public RegisterPage  clickRegisterLinc(){
        registerLinc.shouldBe(visible).click();
        return new RegisterPage();
    }
    public EnterNewPwdPage fillEmailField(String usersEmail){
        emailField.shouldBe(visible).sendKeys(usersEmail);
        return this;
    }

    public EnterNewPwdPage fillPasswordField(String usersPwd){
        passwordField.shouldBe(visible).sendKeys(usersPwd);
        return this;
    }

    public EnterNewPwdPage confirmPasswordField(String usersPwd){
        confirmPasswordField.shouldBe(visible).sendKeys(usersPwd);
        return this;
    }
    public LoginPage pushSaveNewPwdButton(){
        saveNewPwdButton.shouldBe(visible).click();
        return new LoginPage();
    }

//Як описати появу на сторінці логіну зеленого поп-ап-повідомлення про те,що пароль оновлено
}
