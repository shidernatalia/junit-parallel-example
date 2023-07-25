package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private final SelenideElement elementsButton = $x("//div[@class = 'category-cards']/*[1]");

    public HomePage(String url) {
        Selenide.open(url);
    }
    public ElementsPage clickOnElementsButton() {
        elementsButton.click();
        return new ElementsPage();
    }
}