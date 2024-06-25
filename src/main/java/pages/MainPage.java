package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementsCondition;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class MainPage {
    private final SelenideElement checkBoxExampleOne = $x("//input[@id = 'checkBoxOption1']");
    private final ElementsCollection checkBoxesList = $$x("//div[@id='checkbox-example']//input");

    public void clickOnFirstCheckbox(){
        checkBoxExampleOne.shouldBe(visible).click();
    }

    public ElementsCollection getCheckBoxesList(){
        return checkBoxesList.shouldBe(CollectionCondition.size(3));
    }
}
