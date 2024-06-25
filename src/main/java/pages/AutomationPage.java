package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AutomationPage {
    private final SelenideElement enterNewPasswordHeader = $x("//h3[text()='Automation']");
    private final SelenideElement searchFilterField = $x("//*[@id='sidebar']//input[@name='search']");
    private final SelenideElement minPriceField = $x("//*[@id='sidebar']//input[@name='minPrice']");
    private final SelenideElement maxPriceField = $x("//*[@id='sidebar']//input[@name='maxPrice']");
    private final SelenideElement fashionCategoryCheckBox = $x("//div[@class='py-2 border-bottom ml-3']//label[text()='fashion']//preceding-sibling::input");
    private final ElementsCollection headersCheckBoxesCollection = $$x("//h6");
    private final SelenideElement electronixCategoryCheckBox =  $x("//div[@class='py-2 border-bottom ml-3']//label[text()='electronics']//preceding-sibling::input");
    private final SelenideElement householdCategoryCheckBox = $x("//div[@class='py-2 border-bottom ml-3']//label[text()='household']//preceding-sibling::input");
    private final SelenideElement tShortsSubCategoryCheckBox = $x("//div[@class='py-2 border-bottom ml-3']//label[text()='t-shirts']//preceding-sibling::input");
    private final SelenideElement shortsSubCategoryCheckBox = $x("//div[@class='py-2 border-bottom ml-3']//label[text()='shirts']//preceding-sibling::input");
    private final SelenideElement shoesSubCategoryCheckBox = $x("//div[@class='py-2 border-bottom ml-3']//label[text()='shoes']//preceding-sibling::input");
    private final SelenideElement mobilesSubCategoryCheckBox = $x("//div[@class='py-2 border-bottom ml-3']//label[text()='mobiles']//preceding-sibling::input");
    private final SelenideElement laptopsSubCategoryCheckBox = $x("//div[@class='py-2 border-bottom ml-3']//label[text()='laptops']//preceding-sibling::input");
    private final SelenideElement menSearchForCheckBox = $x("//div[@class='py-2 ml-3']//label[text()='men']/preceding-sibling::input");
    private final SelenideElement womenSearchForCheckBox = $x("//div[@class='py-2 ml-3']//label[text()='women']/preceding-sibling::input");
    private final SelenideElement viewButtonOfFirstProduct = $x("//*[@id='products']//div[2]/div[1]/div/div/button[1]");//виправи локатор
    private final SelenideElement addToCardButtonOfFirstProduct = $x("//div[contains(@class,'ng-star-inserted')][1]//button[@class='btn w-10 rounded']");//без прив'язки до тексту та номеру блоку - ніяк
    private final SelenideElement homeButton = $x("//i[@class='fa fa-home']/ancestor::button");//виправила
    private final SelenideElement ordersButton = $x("//i[@class='fa fa-handshake-o']/ancestor::button");//виправила
    private final SelenideElement cartButton = $x("//i[@class='fa fa-shopping-cart']/ancestor::button");//виправила
    private final SelenideElement signOutButton = $x("//i[@class='fa fa-sign-out']/ancestor::button");//виправила

    public AutomationPage fillSearchField(String searchProduct){
        searchFilterField.shouldBe(visible).sendKeys(searchProduct);
        return this;
    }

    public AutomationPage fillMinMaxPriceRange(String min, String max){
        minPriceField.shouldBe(visible).sendKeys(min);
        minPriceField.shouldBe(visible).sendKeys(max);
        return this;
    }

    public AutomationPage setFashionCategoryCheckBox(){
        fashionCategoryCheckBox.shouldBe(visible).click();
        return this;
    }

    public AutomationPage setElectronixCategoryCheckBox(){
        electronixCategoryCheckBox.shouldBe(visible).click();
        return this;
    }
    public AutomationPage setHouseholdCategoryCheckBox(){
        householdCategoryCheckBox.shouldBe(visible).click();
        return this;
    }

    public AutomationPage settShortsSubCategoryCheckBox(){
        tShortsSubCategoryCheckBox.shouldBe(visible).click();
        return this;
    }

    public AutomationPage setshortsSubCategoryCheckBox(){
        shortsSubCategoryCheckBox.shouldBe(visible).click();
        return this;
    }

    public AutomationPage setShoesSubCategoryCheckBox(){
        shoesSubCategoryCheckBox.shouldBe(visible).click();
        return this;
    }

    public AutomationPage setMobilesSubCategoryCheckBox(){
        mobilesSubCategoryCheckBox.shouldBe(visible).click();
        return this;
    }

    public AutomationPage setLaptopsSubCategoryCheckBox(){
        laptopsSubCategoryCheckBox.shouldBe(visible).click();
        return this;
    }

    public AutomationPage setMenSearchForCheckBox(){
        menSearchForCheckBox.shouldBe(visible).click();
        return this;
    }

    public AutomationPage setWomenSearchForCheckBox(){
        womenSearchForCheckBox.shouldBe(visible).click();
        return this; 
    }

    public ProductDetailsPage pressViewButtonOfFirstProduct(){
        viewButtonOfFirstProduct.shouldBe(visible).click();
        return new ProductDetailsPage();
    }

    //Як перевірити, що після додавання товару в кошие з'явився зелений саксес попап і Cart в правому верхньому кутку відображає 1 товар?

    public AutomationPage pressAddToCardButtonOfFirstProduct(){
        addToCardButtonOfFirstProduct.shouldBe(visible).click();
        return this;
    }

    public MyOrdersPage ordersButton(){
        ordersButton.shouldBe(visible).click();
        return new MyOrdersPage();
    }

    public CardPage cartButton(){
        cartButton.shouldBe(visible).click();
        return new CardPage();
    }

    public LoginPage signOutButtonButton(){
        signOutButton.shouldBe(visible).click();
        return new LoginPage();
    }

    public List<SelenideElement> getVisibleCheckboxFromCollection(){
        var visibleElements = new ArrayList<SelenideElement>();
        int listSize = headersCheckBoxesCollection.size();
        for (int i = 0; i < listSize; i++) {
            var currentElement = headersCheckBoxesCollection.get(i);
            if (currentElement.isDisplayed()){
                visibleElements.add(currentElement);
            }
        }
        return visibleElements;
    }

    public AutomationPage checkThatUserIsLogedIn() {
        enterNewPasswordHeader.shouldBe(visible);
        return this;

    }
}
