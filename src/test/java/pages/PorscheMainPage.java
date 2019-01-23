package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PorscheMainPage {

    public PorscheMainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='b-teaser-caption-wrapper']/div/span[.='718']")
    public WebElement porsche718Btn;





}
