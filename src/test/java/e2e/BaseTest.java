package e2e;

import actions.Navigation;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private final String URLRahulShettyAutomation = "https://rahulshettyacademy.com/client/";
    private final String URLRahulShettyLoginPage = "https://rahulshettyacademy.com/client/auth/login";

    protected final Navigation navigation = new Navigation();

    @BeforeMethod
    public void openApp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Selenide.open();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
