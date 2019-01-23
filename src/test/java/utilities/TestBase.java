package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;





public class TestBase {

    //public static WebDriver driver;
    public static Faker faker;
    Random random = new Random();
    Actions myActions;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }



    @BeforeMethod
    public void startTest(){

        Driver.getDriver();
        faker = new Faker();
        //driver.manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        myActions = new Actions(Driver.getDriver());

    }


    @AfterMethod
    public void cleaning(){

    }






}



