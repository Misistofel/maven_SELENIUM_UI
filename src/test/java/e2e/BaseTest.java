package e2e;

import actions.Navigation;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.PageFactory;
import pages.PagesFactory;

import static pages.PagesFactory.app;

public class BaseTest {

    private final String URLRahulShettyAutomation = "https://rahulshettyacademy.com/client/";
    private final String URLRahulShettyLoginPage = "https://rahulshettyacademy.com/client/auth/login";

    protected final Navigation navigation = new Navigation();



}
