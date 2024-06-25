package e2e;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.PageFactory;
import pages.PagesFactory;

import static pages.PagesFactory.app;

public class BaseTest {

    private final String URLRahulShettyAutomation = "https://rahulshettyacademy.com/client/";
    private final String URLRahulShettyLoginPage = "https://rahulshettyacademy.com/client/auth/login";

    public void login(){
        Selenide.open(URLRahulShettyAutomation);
        var currentURLRahulShetty = WebDriverRunner.url();
        Assertions.assertThat(currentURLRahulShetty).as("Checking of current Rahul Shetty practice page URL").isEqualTo(URLRahulShettyLoginPage);
        System.out.println("This is it " + currentURLRahulShetty);
        app().getLoginPage()
                .fillEmailField("misticcat2018@gmail.com")
                .fillPasswordField("EduvGruziju804")
                .pushLoginButton()
                .checkThatUserIsLogedIn();
    }

}
