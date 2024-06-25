package e2e.practice_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import e2e.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import steps.MainPageSteps;

import java.time.Duration;

import static pages.PagesFactory.app;

@Slf4j
public class MyFirstTest extends BaseTest {
    private final String URL = "https://rahulshettyacademy.com/AutomationPractice/";
    private final String URLRahulShetty = "https://rahulshettyacademy.com/client/";
    private final String URLRahulShettyAutomation = "https://rahulshettyacademy.com/client/";
    private final String URLRahulShettyLoginPage = "https://rahulshettyacademy.com/client/auth/login";
    private final String URLofPasswordNew = "https://rahulshettyacademy.com/client/auth/password-new";


    @Test
    public void mainHeaderOnTheMainPageTest() {
        Selenide.open(URL);
        var currentURL = WebDriverRunner.url();
        Assertions.assertThat(currentURL).as("Checking of current URL of Practice page").isEqualTo(URL);
        MainPageSteps.selectFirstAndSecondCheckBoxes();
    }

    @Test
    public void getCheckBoxElementsAutomationPageViaLogin() {
        Selenide.open(URLRahulShettyAutomation);
        app().getLoginPage()
                .fillEmailField("misticcat2018@gmail.com")
                .fillPasswordField("EduvGruziju804")
                .pushLoginButton()
                .checkThatUserIsLogedIn();

        var listOfCheckboxesAutomationPage = app().getAutomationPage()
                .getVisibleCheckboxFromCollection();
        for (int i = 0; i < listOfCheckboxesAutomationPage.size(); i++) {
            System.out.println(listOfCheckboxesAutomationPage.get(i).text());
        }

    }

    @Test
    public void getAlertTextWhenAddToCartOnAutomationPage() {
        System.out.println("Opening URL: " + URLRahulShettyAutomation);
        Selenide.open(URLRahulShettyAutomation);

        System.out.println("Filling login details");
        app().getLoginPage()
                .fillEmailField("misticcat2018@gmail.com")
                .fillPasswordField("EduvGruziju804")
                .pushLoginButton()
                .checkThatUserIsLogedIn();

        System.out.println("Pressing Add to Cart button");
        app().getAutomationPage().pressAddToCardButtonOfFirstProduct();

        // Introducing a small delay to debug timing issues
        try {
            Thread.sleep(2000); // 2-second delay for debugging purposes
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
        }

        // Wait for the alert to be present and switch to it
        try {
            WebDriverWait wait = new WebDriverWait(Selenide.webdriver().object(), Duration.ofSeconds(10));
            System.out.println("Waiting for alert to be present");
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            // Now that the alert is present, you can get its text
            System.out.println("Alert found, getting its text");
            System.out.println(alert.getText());

            // Accept the alert to proceed
            alert.accept();
            System.out.println("Alert accepted");
        } catch (Exception e) {
            System.out.println("Alert not found: " + e.getMessage());
        }


    }

    @Test
    public void searchProductViaSearchField() {
        login();
        var automationPage = app().getAutomationPage();
        automationPage.fillSearchFieldAndPressEnter("IPHONE 13 PRO");

        var listOfVisibleProductsAutomationPage = automationPage.getVisibleProductsFromCollection();
        for (int i = 0; i < listOfVisibleProductsAutomationPage.size(); i++) {
            System.out.println(listOfVisibleProductsAutomationPage.get(i).text());
        }
    }

}



