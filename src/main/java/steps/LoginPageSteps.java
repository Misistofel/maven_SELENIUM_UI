package steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static com.codeborne.selenide.Condition.visible;

public class LoginPageSteps {
    private static LoginPage loginPage = new LoginPage();

    @Step
    public static void loginOnLoginPage(){
        loginPage.fillEmailField("misticcat2018@gmail.com");
        loginPage.fillPasswordField("EduvGruziju804");
        loginPage.pushLoginButton();
    }

    @Step
    public static RegisterPage registerNewUser(){
        loginPage.pushRegisterLink();
        return new RegisterPage();
    }

}
