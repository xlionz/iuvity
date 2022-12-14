package co.com.iuvity.certificacion.utils;

import co.com.iuvity.certificacion.models.PersonalInfo;
import co.com.iuvity.certificacion.models.UserCount;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFiles {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFiles.class);
    private static final EnvironmentVariables CONF = SystemEnvironmentVariables.createEnvironmentVariables();
    public static final String CONFIG_COUNTS = "counts.";
    public static final String  CONFIG_PERSONAL_INFO = "personalInfo.";

    public static UserCount readUserCount(String count){
        return new UserCount(CONF.getProperty(CONFIG_COUNTS + count + ".name"),
                CONF.getProperty(CONFIG_COUNTS + count + ".password"));
    }

    public static String readBrowser(){
        return CONF.getProperty("config.browser.default");
    }

    public static PersonalInfo readPersonalInfo(String personalInfo){
        return new PersonalInfo(CONF.getProperty(CONFIG_PERSONAL_INFO + personalInfo + ".firstname"),
                CONF.getProperty(CONFIG_PERSONAL_INFO + personalInfo + ".lastname"),
                CONF.getProperty(CONFIG_PERSONAL_INFO + personalInfo + ".zip"));
    }
}
