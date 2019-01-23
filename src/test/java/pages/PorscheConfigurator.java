package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PorscheConfigurator {

    public PorscheConfigurator() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//div[@class='ccaPrice'])[5]")
    public WebElement caymanBasePriceAfterClick;

    @FindBy(xpath = "(//div[@class='ccaPrice'])[6]")
    public WebElement equipmentPrice;

    @FindBy(xpath = "(//div[@class='ccaPrice'])[7]")
    public WebElement delProcHandFee;

    @FindBy (xpath = "(//div[@class='ccaPrice'])[8]")
    public WebElement totalPrice;

    @FindBy (xpath = "//li[@id='s_exterieur_x_FJ5']")
    public WebElement miamiBlueBtn;

    @FindBy (xpath = "(//div[@class='tt_price tt_cell'])[1]")
    public  WebElement priceOfMiamiBlue;

    @FindBy (xpath = "(//span[@class='wheel-option img-wrapper'])[6]")
    public WebElement carreraSportWheelsBtn;

    @FindBy (xpath = "(//div[@class='tt_price tt_cell'])[2]")
    public  WebElement priceOfCarreraSportWheels;

    @FindBy (xpath = "//span[@id='s_interieur_x_PP06']")
    public WebElement powerSportSeatBtn;

    @FindBy (xpath = "(//div[@class='pBox'])[8]/div")
    public WebElement priceOfPowerSportSeat;

    @FindBy (xpath = "//div[@id='IIC_subHdl']")
    public WebElement interriorCarbonFiberBtn;

    @FindBy (xpath = "//span[@id='vs_table_IIC_x_PEKH_x_c01_PEKH']")
    public WebElement selectStandardInterriorBtn;

    @FindBy (xpath = "//div[@id='vs_table_IIC_x_PEKH_x_c04_PEKH_x_shorttext']/../div[2]/div")
    public WebElement priceOfStandardInterrior;

    @FindBy (xpath = "//div[@id='IMG_subHdl']")
    public WebElement performanceBtn;

    @FindBy (xpath = "//span[@id='vs_table_IMG_x_M250_x_c11_M250']")
    public WebElement select7SpeedPorscheDoppelkupplungBtn;

    @FindBy (xpath = "//div[@id='vs_table_IMG_x_M250_x_c14_M250_x_shorttext']/../div[2]/div")
    public WebElement priceOf7speed;

    @FindBy (xpath = "//span[@id='vs_table_IMG_x_M450_x_c81_M450']")
    public  WebElement ceramicCompositeBrakesBtn;

    @FindBy (xpath = "//div[@id='vs_table_IMG_x_M450_x_c84_M450_x_shorttext']/../div[2]/div")
    public WebElement priceOfCeramicCompositeBreaks;











}
