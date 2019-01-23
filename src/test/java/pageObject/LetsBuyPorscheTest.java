package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cayman718SPage;
import pages.PorscheConfigurator;
import pages.PorscheMainPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.Set;

public class LetsBuyPorscheTest extends TestBase {

    @Test
    public void porscheMainPage() throws InterruptedException {

        //2.Go to url “https://www.porsche.com/usa/modelstart/”
        Driver.getDriver().get("https://www.porsche.com/usa/modelstart/");

        //3. Select model 718
        PorscheMainPage pmp = new PorscheMainPage();
        pmp.porsche718Btn.click();

        //4.Remember the price of 718 Cayman Model S
        Thread.sleep(2000);
        Cayman718SPage price718 = new Cayman718SPage();
        Assert.assertTrue(price718.caymanBasePriceBeforeClick.isEnabled());
        int priceFirstInt = Integer.valueOf( price718.caymanBasePriceBeforeClick.getAttribute("innerText").substring(7, 13).replace(",",""));


        //5.Click on 718 Cayman S
        String parentWindHandle = Driver.getDriver().getWindowHandle();
        price718.caymanBasePriceBeforeClick.click();


        //Verify that Base price displayed on the page is same as the price from step 4
        Set<String> winHandles = Driver.getDriver().getWindowHandles();
        for (String handle : winHandles) {
            if (!handle.equals(parentWindHandle)) {
                Driver.getDriver().switchTo().window(handle);
                Thread.sleep(3000);
            }

        }

        PorscheConfigurator confiPage = new PorscheConfigurator();
        int priceSecondInt = Integer.valueOf(confiPage.caymanBasePriceAfterClick.getAttribute("innerText").substring(1).replace(",", ""));
        Assert.assertEquals(priceFirstInt, priceSecondInt);


        //7.Verify that Price for Equipment is 0
        int equipmentPriceInt = Integer.valueOf(confiPage.equipmentPrice.getAttribute("innerText").substring(1));
        //String equipmentPriceStr = confiPage.equipmentPrice.getAttribute("innerText").substring(1);
        Assert.assertEquals(equipmentPriceInt, 0);


        //8.Verify that total price is the sum of base price + Delivery, Processing and Handling Fee
        int delProcHandFeeInt = Integer.valueOf(confiPage.delProcHandFee.getAttribute("innerText").substring(1).replace(",", ""));
        int totalPriceInt = Integer.valueOf(confiPage.totalPrice.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(totalPriceInt, priceSecondInt + equipmentPriceInt + delProcHandFeeInt);


        //9.Select color “Miami Blue”
        confiPage.miamiBlueBtn.click();

        //10.Verify that Price for Equipment is Equal to Miami Blue price
        int equipMiamiBlueInt = Integer.valueOf(confiPage.equipmentPrice.getAttribute("innerText").substring(1).replace(",",""));
        int miamiBluePriceInt = Integer.valueOf(confiPage.priceOfMiamiBlue.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(equipMiamiBlueInt, miamiBluePriceInt);


        //11.Verify that total price is the sum of base price +
        // Price for Equipment + Delivery, Processing and Handling Fee
        Assert.assertEquals(totalPriceInt, priceSecondInt + equipmentPriceInt + delProcHandFeeInt);

        //12.Select 20" Carrera Sport Wheels
        Actions myAction = new Actions(Driver.getDriver());
        myAction.sendKeys(Keys.ARROW_DOWN).perform();
        myAction.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        confiPage.carreraSportWheelsBtn.click();


        //13.Verify that Price for Equipment is the sum of Miami Blue price + 20" Carrera Sport Wheels
        int equipCarreraSportWheels = Integer.valueOf(confiPage.equipmentPrice.getAttribute("innerText").substring(1).replace(",",""));
        int carreraWheelsPriceInt = Integer.valueOf(confiPage.priceOfCarreraSportWheels.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(equipCarreraSportWheels, miamiBluePriceInt + carreraWheelsPriceInt);


        //14.Verify that total price is the sum of base price +
        // Price for Equipment + Delivery, Processing and Handling Fee
        int totalAfterCarreraWheelsInt = Integer.valueOf(confiPage.totalPrice.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(totalAfterCarreraWheelsInt, priceSecondInt + equipCarreraSportWheels + delProcHandFeeInt);


        //15.Select seats ‘Power Sport Seats (14-way) with Memory Package’
        myAction.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        myAction.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        confiPage.powerSportSeatBtn.click();
        Thread.sleep(2000);


        //16.Verify that Price for Equipment is the sum of Miami Blue price +
        // 20" Carrera Sport Wheels + Power Sport Seats (14-way) with Memory Package
        int sportSeatPriceInt = Integer.valueOf(confiPage.priceOfPowerSportSeat.getAttribute("innerText").substring(1).replace(",",""));
        int equipAfterSportSeat = Integer.valueOf(confiPage.equipmentPrice.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(equipAfterSportSeat, miamiBluePriceInt + carreraWheelsPriceInt + sportSeatPriceInt);


        //17.Verify that total price is the sum of base price +
        // Price for Equipment + Delivery, Processing and Handling Fee
        int totalAfterSportSeat = Integer.valueOf(confiPage.totalPrice.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(totalAfterSportSeat, priceSecondInt + equipAfterSportSeat + delProcHandFeeInt);


        //18.Click on Interior Carbon Fiber
        myAction.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        myAction.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        confiPage.interriorCarbonFiberBtn.click();


        //19.Select Interior Trim in Carbon Fiber i.c.w. Standard Interior
        confiPage.selectStandardInterriorBtn.click();


        //20.Verify that Price for Equipment is the sum of
        // Miami Blue price + 20" Carrera Sport Wheels +
        // Power Sport Seats (14-way) with Memory Package +
        // Interior Trim in Carbon Fiber i.c.w. Standard Interior

        int standardInterriorPriceInt = Integer.valueOf(confiPage.priceOfStandardInterrior.getAttribute("innerText").substring(1).replace(",",""));
        int equipAfterStandartInterrior = Integer.valueOf(confiPage.equipmentPrice.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(equipAfterStandartInterrior, miamiBluePriceInt + carreraWheelsPriceInt + sportSeatPriceInt + standardInterriorPriceInt);

        //21.Verify that total price is the sum of base price +
        // Price for Equipment + Delivery, Processing and Handling Fee
        int totalAfterStandardInterrior = Integer.valueOf(confiPage.totalPrice.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(totalAfterStandardInterrior, priceSecondInt + equipAfterStandartInterrior + delProcHandFeeInt);


        //22.Click on Performance
        myAction.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        confiPage.performanceBtn.click();


        //23.Select 7-speed Porsche Doppelkupplung (PDK)
        confiPage.select7SpeedPorscheDoppelkupplungBtn.click();
        int select7SpeedPriceInt = Integer.valueOf(confiPage.priceOf7speed.getAttribute("innerText").substring(1).replace(",",""));

        //24.Select Porsche Ceramic Composite Brakes (PCCB)
        myAction.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        confiPage.ceramicCompositeBrakesBtn.click();
        int ceramicCompositeBreaksPriceInt = Integer.valueOf(confiPage.priceOfCeramicCompositeBreaks.getAttribute("innerText").substring(1).replace(",",""));



        //25.Verify that Price for Equipment is the sum of Miami Blue price +
        // 20" Carrera Sport Wheels + Power Sport Seats (14-way) with Memory Package +
        // Interior Trim in Carbon Fiber i.c.w. Standard Interior +
        // 7-speed Porsche Doppelkupplung (PDK) + Porsche Ceramic Composite Brakes (PCCB)

        int equipAfterCeramicBreaks  = Integer.valueOf(confiPage.equipmentPrice.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(equipAfterCeramicBreaks, miamiBluePriceInt + carreraWheelsPriceInt + sportSeatPriceInt +
                standardInterriorPriceInt + select7SpeedPriceInt + ceramicCompositeBreaksPriceInt);

        //26.Verify that total price is the sum of base price +
        // Price for Equipment + Delivery, Processing and Handling Fee
        int totalAtTheEnd = Integer.valueOf(confiPage.totalPrice.getAttribute("innerText").substring(1).replace(",",""));
        Assert.assertEquals(totalAtTheEnd, priceSecondInt + equipAfterCeramicBreaks + delProcHandFeeInt);




    }

}






