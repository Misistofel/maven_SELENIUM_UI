package e2e.practice_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import e2e.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import steps.MainPageSteps;

import java.time.Duration;

import static pages.PagesFactory.app;

@Slf4j
public class MyFirstTest extends BaseTest {

    @Test
    public void mainHeaderOnTheMainPageTest() {
        Selenide.open(navigation.getURL());
        var currentURL = WebDriverRunner.url();
        Assertions.assertThat(currentURL).as("Checking of current URL of Practice page").isEqualTo(navigation.getURL());
        MainPageSteps.selectFirstAndSecondCheckBoxes();
    }

    @Test
    public void getCheckBoxElementsAutomationPageViaLogin() {
        Selenide.open(navigation.getURLRahulShettyAutomation());
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
    public void getAlertTextWhenAddToCartOnAutomationPage()  {
        System.out.println("Opening URL: " + navigation.getURLRahulShettyAutomation());//URLRahulShettyAutomation);
        Selenide.open(navigation.getURLRahulShettyAutomation());

        System.out.println("Filling login details");
        app().getLoginPage()
                .fillEmailField("misticcat2018@gmail.com")
                .fillPasswordField("EduvGruziju804")
                .pushLoginButton()
                .checkThatUserIsLogedIn();

        System.out.println("Pressing Add to Cart button");
        String title = app().getAutomationPage()
                .addToCardOfFirstProduct();
        var listOfCartProducts = app().getAutomationPage()
                .checkAddToCardToast()
                .checkCartCounter(1)
                .clickCartButton()
                .isDisplayedContinueShoppingButton()
                .getCartProductsCollection();
        System.out.println("Size of the list " + listOfCartProducts .size());
        for (int i = 0; i < listOfCartProducts.size(); i++) {
            System.out.println(listOfCartProducts.get(i).text());
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



