package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.TestValues;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ElementsPage {
    private final SelenideElement textBoxButton = $x("//span[contains(@class, 'text') and text() = 'Text Box']");
    private final SelenideElement fullNameTextBox = $x("//input[@id='userName']");
    private final SelenideElement emailTextBox = $x("//input[@id='userEmail']");
    private final SelenideElement currentAddressTextBox = $x("//textarea[@id='currentAddress']");
    private final SelenideElement permanentAddressTextBox = $x("//textarea[@id='permanentAddress']");
    private final SelenideElement submitButton = $(By.id("submit"));
    private final SelenideElement name = $x("//p[@id='name']");
    private final SelenideElement email = $x("//p[@id='email']");
    private final SelenideElement currentAddress = $x("//p[@id='currentAddress']");
    private final SelenideElement permanentAddress = $x("//p[@id='permanentAddress']");

    public ElementsPage clickOnTextBoxButton() {
        textBoxButton.click();
        return this;
    }

    public ElementsPage fillOutTextBoxes() {
        fullNameTextBox.click();
        fullNameTextBox.sendKeys(TestValues.FULL_NAME);
        emailTextBox.click();
        emailTextBox.sendKeys(TestValues.EMAIL);
        currentAddressTextBox.click();
        currentAddressTextBox.sendKeys(TestValues.CURRENT_ADDRESS);
        permanentAddressTextBox.click();
        permanentAddressTextBox.sendKeys((TestValues.PERMANENT_ADDRESS));
        submitButton.click();
        return this;
    }

    public String getName() {
        return name.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getCurrentAddress() {
        return currentAddress.getText();
    }

    public String getPermanentAddress() {
        return permanentAddress.getText();
    }
}