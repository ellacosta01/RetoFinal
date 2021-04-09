package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.utils.Constants;
import com.saucedemo.utils.DataGenerator;
import com.saucedemo.utils.ScreenshotsHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private String suiteEvidenceRoute;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        suiteEvidenceRoute = Constants.evidenceRoute + "Login\\" + DataGenerator.getCurrentDate();
    }

    @Given("the client is in the home page")
    public void the_client_is_in_the_home_page() throws Exception {
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        System.out.println();
        ScreenshotsHandler.takeSnapShot(driver, suiteEvidenceRoute, "ClientInHomePage.png");
    }

    @When("he attempts to login with his credentials")
    public void he_attempts_to_login_with_his_credentials(List<String> listData) throws Exception {
        homePage.writeUsername("standard_user");
        homePage.writePassword("secret_sauce");
        ScreenshotsHandler.takeSnapShot(driver, suiteEvidenceRoute, "AfterWritingCredentials.png");
        homePage.clickOnLogin();
    }

    @Then("he should see the Cart icon")
    public void he_should_see_the_cart_icon() throws Exception {
        InventoryPage inventoryPage = new InventoryPage(driver);
        System.out.println(inventoryPage.getNumberOfAddToCartButtons());
        ScreenshotsHandler.takeSnapShot(driver, suiteEvidenceRoute, "VerifyingCartIcon.png");
        assertTrue("The shopping cart icon is not displayed.", inventoryPage.shoppingCartIconIsDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
