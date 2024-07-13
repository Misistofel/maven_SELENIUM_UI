package pages;

import com.codeborne.selenide.*;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    private final SelenideElement paymentMethod = $x("//div[text()=' Payment Method ']");
    private final SelenideElement creditCard = $x("//div[text()='Credit Card']");
    private final SelenideElement payPal = $x("//div[text()='Paypal']");
    private final SelenideElement sepa = $x("//div[text()='SEPA']");
    private final SelenideElement invoice = $x("//div[text()='Invoice']");
    private final SelenideElement cardNumberField = $x("//div[text()='Credit Card Number ']//following-sibling::input");
    private final SelenideElement monthOfExpiryDateField = $x("//div[text()='Expiry Date ']//following-sibling::select[1]");
    private final ElementsCollection monthsFromDropdown = $$x("//select[@class=\"input ddl\"][1]/option");
    private final ElementsCollection daysFromDropdown = $$x("//select[@class=\"input ddl\"][2]/option");
    private final SelenideElement dayOfExpiryDate = $x("//div[text()='Expiry Date ']//following-sibling::select[2]");
    private final SelenideElement cvvCode = $x("//div[text()='CVV Code ']/following-sibling::input");
    private final SelenideElement nameOfCard = $x("//div[text()='Name on Card ']/following-sibling::input");
    private final SelenideElement applyCouponField = $x("//div[text()='Apply Coupon ']/following-sibling::input");
    private final SelenideElement applyCouponButton = $x("//button[text()='Apply Coupon']");
    private final SelenideElement invalidCouponHint= $x("//input[@name='coupon']/following-sibling::p");
    private final SelenideElement emailField = $x("//div[@class='user__name mt-5']/label");
    private final SelenideElement countryField = $x("//input[@placeholder='Select Country']");
    private final SelenideElement countryFromDropdown = $x("//button[@class='ta-item list-group-item ng-star-inserted']");
    private final SelenideElement placeOrderButton = $x("//a[text()='Place Order ']");


    public void visibilityOfPaymentMethodHeader() {
         paymentMethod.shouldBe(visible);
    }

        public PaymentPage fillCrerditCardField(String cardNumber){
            cardNumberField.shouldBe(visible).clear();
            cardNumberField.shouldBe(visible).sendKeys(cardNumber);
            return this;
        }

        public PaymentPage chooseMonthFromDropdown (String month){
            var visibleMonthsElements = new ArrayList<SelenideElement>();
            int listMonthSize = monthsFromDropdown.size();
            for (int i = 0; i < listMonthSize; i++) {
                var currentMonth = monthsFromDropdown.get(i);
                if (currentMonth.isDisplayed()) {
                    visibleMonthsElements.add(currentMonth);
                }
            }
            for (int i = 0; i < listMonthSize; i++) {
                if (visibleMonthsElements.get(i).getText().equals(month)) {
                    visibleMonthsElements.get(i).click();
                }
            }
            return this;
        }

    public PaymentPage chooseDayFromDropdown (String day){
        var visibleDaysElements = new ArrayList<SelenideElement>();
        int listDaysSize = daysFromDropdown.size();
        for (int i = 0; i < listDaysSize; i++) {
            var currentDay = daysFromDropdown.get(i);
            if (currentDay.isDisplayed()) {
                visibleDaysElements.add(currentDay);
            }
        }
        for (int i = 0; i < listDaysSize; i++) {
            if (visibleDaysElements.get(i).getText().equals(day)) {
                visibleDaysElements.get(i).click();
            }
        }
        return this;
    }

    public PaymentPage  FillNameOnCard(String name) {
        nameOfCard.sendKeys(name);
        return this;
    }

    public PaymentPage FillApplyCouponField(String name) {
        applyCouponField.sendKeys(name);
        return this;
    }

    public PaymentPage  clickApplyCouponButton() {
        applyCouponButton.click();
        System.out.println(invalidCouponHint.shouldBe(visible).shouldHave(text("* Invalid Coupon")).getText());
        return this;
    }


    public PaymentPage FillSelectCountryField(String country) {
        countryField.sendKeys(country);
        System.out.println(countryFromDropdown.shouldBe(visible).shouldHave(text(country)).getText());
        countryFromDropdown.click();
        return this;
    }



    public PaymentPage  clickPlaceOrder() {
        placeOrderButton.click();
        return this;
    }

    }



