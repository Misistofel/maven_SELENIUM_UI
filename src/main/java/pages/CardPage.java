package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CardPage {
    private final SelenideElement byNowButton = $x("//div[@class='cartSection removeWrap']/button[@class='btn btn-primary']");//це найкращий варіант
    private final SelenideElement deleteButton = $x("//button[@class='btn btn-danger']");//виправила
    private final SelenideElement continueShoppingButton = $x("//button[@routerlink='/dashboard']");//виправила
    private final SelenideElement checkoutButton = $x("//button[text()='Checkout']");//виправила
    private final ElementsCollection productsList = $$x("//div[@class='cart']//div[@class='cartSection']");

    public OrderPage pressByNowButton (){
        byNowButton.shouldBe(visible).click();
        return new OrderPage();
    }

    public OrderPage pressCheckoutButton (){
        checkoutButton.shouldBe(visible).click();
        return new OrderPage();
    }

    public CardPage pressDeleteButton(String usersPhone){
        deleteButton.shouldBe(visible).sendKeys(usersPhone);
        return this;
    }

    public AutomationPage pressContinueShoppingButton(){
        continueShoppingButton.shouldBe(visible).click();
        return new AutomationPage();
    }

    public CardPage isDisplayedContinueShoppingButton(){
        new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10))
                .until(driver -> continueShoppingButton.isDisplayed());
        return new CardPage();
    }

    public List<SelenideElement> getCartProductsCollection(){
        var cartProducts = new ArrayList<SelenideElement>();

        int listSize = productsList.size();
        for (int i = 0; i < listSize; i++) {
            var currentElement = productsList.get(i).shouldBe(Condition.visible);
            if (currentElement.isDisplayed()){
                cartProducts.add(currentElement);
            }
        }
        return cartProducts;

    }

    public void checkProductCartIsNotEmpty(){
       productsList.shouldHave(CollectionCondition.sizeGreaterThan(0));
    }


}
