package pages;

import lombok.Getter;

@Getter
public final class PagesFactory {
    private static PagesFactory instance;
    private final AutomationPage automationPage;
    private final CardPage cardPage;
    private final PaymentPage paymentPage;
    private final EnterNewPwdPage enterNewPwdPage;
    private final LoginPage loginPage;
    private final MainPage mainPage;
    private final MyOrdersPage myOrdersPage;
    private final OrderPage orderPage;
    private final ProductDetailsPage productDetailsPage;
    private final RegisterPage registerPage;

    public static PagesFactory app(){
        if (instance == null){
            instance = new PagesFactory();
        }
        return instance;
    }

    private PagesFactory() {
        automationPage = new AutomationPage();
        cardPage = new CardPage();
        enterNewPwdPage = new EnterNewPwdPage();
        loginPage = new LoginPage();
        mainPage = new MainPage();
        myOrdersPage = new MyOrdersPage();
        orderPage = new OrderPage();
        productDetailsPage =new ProductDetailsPage();
        registerPage = new RegisterPage();
        paymentPage = new PaymentPage();
    }


}
