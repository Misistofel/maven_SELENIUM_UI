package pages;

import com.codeborne.selenide.*;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {
    private final SelenideElement firstNameName = $x("//input[@id = 'firstName']");
    private final SelenideElement lastNameField = $x("//input[@id = 'lastName']");
    private final SelenideElement emailField = $x("//input[@id = 'userEmail']");
    private final SelenideElement phoneField = $x("//input[@id = 'userMobile']");
    private final SelenideElement occupationDropDown = $x("//select[@formcontrolname= 'occupation']");
    private final SelenideElement occupationDropDownSecond = $x("//option[@value='2: Student']");
    private final SelenideElement maleRadioButton = $x("//input[@value='Male']");
    private final SelenideElement femaleRadioButton = $x("//input[@value='Female']");
    private final SelenideElement passwordField = $x("//input[@id='userPassword']");
    private final SelenideElement confirmPasswordField = $x("//input[@id='confirmPassword']");
    private final SelenideElement iAm18YearsCheckBox = $x("//input[@formcontrolname='required']");
    private final SelenideElement registerButton = $x("//input[@id='login']");

    public RegisterPage fillFirstNameField(String usersFirstName){
        firstNameName .shouldBe(visible).sendKeys(usersFirstName);
        return this;
    }

    public RegisterPage fillLasNameField(String usersLatName){
        lastNameField.shouldBe(visible).sendKeys(usersLatName);
        return this;
    }

    public RegisterPage fillEmailField(String usersEmail){
        emailField.shouldBe(visible).sendKeys(usersEmail);
        return this;
    }

    public RegisterPage fillPhoneField (String usersPhone){
        phoneField .shouldBe(visible).sendKeys(usersPhone);
        return this;
    }

    public RegisterPage clickAndChose2FromOccupationDropDown (){
        occupationDropDown.shouldBe(visible).click();
        occupationDropDown.selectOption(2);
        return this;
    }

    public RegisterPage checkFemaleRadioButton (){
        femaleRadioButton.shouldBe(visible).click();
        return this;
    }

    public RegisterPage passwordField(String usersPassword){
        passwordField.shouldBe(visible).sendKeys(usersPassword);
        return this;
    }

    public RegisterPage confirmPasswordField(String usersPassword){
        confirmPasswordField.shouldBe(visible).sendKeys(usersPassword);
        return this;
    }

    public RegisterPage activateIAm18CheckBox(){
        iAm18YearsCheckBox.shouldBe(visible).click();
        return this;
    }

    public RegisterPage activateRegisterButton(){
        registerButton.shouldBe(visible).click();
        return this;
    }

}
