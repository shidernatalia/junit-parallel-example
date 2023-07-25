import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.remote.RemoteWebDriver;
abstract public class BaseTest {
    public void printBrowser() {
        Allure.step(((RemoteWebDriver) WebDriverRunner.getWebDriver()).getCapabilities().getBrowserName());
    }
}