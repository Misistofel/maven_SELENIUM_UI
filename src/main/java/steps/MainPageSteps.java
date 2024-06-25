package steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Condition.visible;

public class MainPageSteps {

   private static MainPage mainPage = new MainPage();

    @Step
    public static void selectFirstAndSecondCheckBoxes(){
        ElementsCollection listOfCheckBoxes =  mainPage.getCheckBoxesList();
        listOfCheckBoxes.get(0).shouldBe(visible).click();
        listOfCheckBoxes.get(1).shouldBe(visible).click();
    }
}
