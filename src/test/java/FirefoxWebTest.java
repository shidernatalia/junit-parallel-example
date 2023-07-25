import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.ConfigProvider;
import helpers.TestValues;
import jupiter.Env;
import jupiter.EnvAnnotationProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ElementsPage;
import pages.HomePage;

import static helpers.StringModifier.replaceNewLines;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(EnvAnnotationProcessor.class)
@Env(browser = Env.Browser.firefox, remote = true)
class FirefoxWebTest extends BaseTest {
    static {
        Configuration.browser = "chrome";
        Configuration.remote = "http://localhost:4444/wd/hub";
    }

    private HomePage homePage;

    @BeforeEach
    void setUp() {
        printBrowser();
        Configuration.browserSize = "1920x1080";
        homePage = new HomePage(ConfigProvider.URL);

    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @RepeatedTest(4)
    @Test
    void testNameEmail() {
        ElementsPage elementsPage = homePage
                .clickOnElementsButton()
                .clickOnTextBoxButton()
                .fillOutTextBoxes();

        assertEquals("Name:" + TestValues.FULL_NAME, elementsPage.getName());
        assertEquals("Email:" + TestValues.EMAIL, elementsPage.getEmail());
        assertEquals("Current Address :" + replaceNewLines(TestValues.CURRENT_ADDRESS), elementsPage.getCurrentAddress());
        assertEquals("Permananet Address :" + replaceNewLines(TestValues.PERMANENT_ADDRESS), elementsPage.getPermanentAddress());
    }
}
