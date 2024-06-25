package steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;


public class RegisterSteps {
    private static RegisterPage registePage = new RegisterPage();

    @Step
    public  void loginOnLoginPage(){
        registePage.fillFirstNameField("misticcat2018@gmail.com");
        registePage.fillLasNameField("misticcat2018@gmail.com");

    }
}
