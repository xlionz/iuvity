package co.com.iuvity.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {

    public static final Target LBL_TITLE_PRODUCT = Target.the("Label of title of product.")
            .locatedBy("//div[text() = '{0}']");
    public static final Target BTN_ADD_CART = Target.the("Button to add cart.")
            .locatedBy("//div[text() = '{0}']/ancestor::div/following-sibling" +
                    "::div[@class = 'pricebar']/descendant::button");
    public static final Target BTN_CART = Target.the("Button to view products in the cart.")
            .locatedBy("//span[@class = 'shopping_cart_badge']");
    public static final Target BTN_CHECKOUT = Target.the("Button to checkout product.")
            .locatedBy("id:checkout");
    public static final Target INPUT_FIRST_NAME = Target.the("Input of first name.")
            .locatedBy("id:first-name");
    public static final Target INPUT_LAST_NAME = Target.the("Input of last name.")
            .locatedBy("id:last-name");
    public static final Target INPUT_ZIP = Target.the("Input of zip.")
            .locatedBy("id:postal-code");
    public static final Target BTN_CONTINUE = Target.the("Button to continue.")
            .locatedBy("id:continue");
    public static final Target BTN_FINISH = Target.the("Button to finish.")
            .locatedBy("id:finish");
    public static final Target LBL_ORDER_SENT = Target.the("Label of order sent.")
            .locatedBy("//h2[@class = 'complete-header']");
}
