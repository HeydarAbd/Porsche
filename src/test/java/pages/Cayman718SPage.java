package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Cayman718SPage {

    public Cayman718SPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='model-result-row']/div[3]/div[2]/div[1]/div[2]/div[@class='m-14-model-price']")
    public static WebElement caymanBasePriceBeforeClick;
}
