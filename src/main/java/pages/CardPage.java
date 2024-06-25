package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CardPage {
    private final SelenideElement byNowButton = $x("//div[@class='cartSection removeWrap']/button[@class='btn btn-primary']");//це найкращий варіант
    private final SelenideElement deleteButton = $x("//button[@class='btn btn-danger']");//виправила
    private final SelenideElement continueShoppingButton = $x("//button[@routerlink='/dashboard']");//виправила
    private final SelenideElement checkoutButton = $x("//i[@class='fa fa-sign-out']/ancestor::button");//виправила

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

}
