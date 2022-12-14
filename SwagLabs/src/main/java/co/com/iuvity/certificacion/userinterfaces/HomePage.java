package co.com.iuvity.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target INPUT_USERNAME = Target.the("Input of user name.")
            .locatedBy("id:user-name");
    public static final Target INPUT_PASS = Target.the("Input of password.")
            .locatedBy("id:password");
    public static final Target BTN_LOGIN = Target.the("Button to login.")
            .locatedBy("id:login-button");
}
