import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    Login loginPage;
    Products productsPage;
    Cart cartPage;
    Checkout checkout;


    @BeforeTest
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @Test
    public void validLoginTest() {
        loginPage = new Login(driver);
        loginPage.fillUsernameField("standard_user");
        loginPage.fillPasswordField("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.GetProductTitle(),"Products");
    }

    @Test(dependsOnMethods = "validLoginTest",priority = 0)
    public void validAddingItem(){
        productsPage = new Products(driver);
        productsPage.AddFirstItemToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertEquals(productsPage.GetFirstButtonName(),"REMOVE");
        productsPage.GoToCart();
    }

    @Test(dependsOnMethods = "validLoginTest",priority = 4)
    public void goToCart(){
        productsPage = new Products(driver);
        productsPage.GoToCart();
        Assert.assertEquals(productsPage.GetCartTitle(),"Your Cart");
    }


    @Test(dependsOnMethods = "goToCart")
    public void backToProductsPage(){
        cartPage= new Cart(driver);
        cartPage.ClickContinueShopping();
        loginPage = new Login(driver);
        Assert.assertEquals(loginPage.GetProductTitle(),"Products");

    }

    @Test(dependsOnMethods = "backToProductsPage")
    public void validAddingAnotherItem(){
        productsPage.AddSecondItemToCart();
        productsPage.GoToCart();
        Assert.assertEquals(productsPage.GetCartTitle(),"Your Cart");
    }

    @Test(dependsOnMethods = "validAddingAnotherItem")
    public void goCheckout(){
        cartPage= new Cart(driver);
        cartPage.ClickCheckout();
        Assert.assertEquals(cartPage.GetCheckoutTitle(),"Checkout: Your Information");
    }

    @Test(dependsOnMethods = "goCheckout")
    public void fillCheckoutData (){
        checkout = new Checkout(driver);
        checkout.fillFirstname("Ahmed");
        checkout.fillLastname("Abdullatif");
        checkout.fillPostalCode("775522");
        checkout.clickContinueButton();
        Assert.assertEquals(checkout.GetCheckoutTitle(),"Checkout: Overview");
        checkout.clickFinishButton();
    }

    @Test(dependsOnMethods = "fillCheckoutData")
    public void checkFinish(){
        Assert.assertEquals(checkout.GetCheckoutTitle(),"Finish");

    }



    @AfterTest
    public void quit()
    {
        loginPage.clickBurgerMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage.clickLogoutButton();
        driver.quit();
    }
}
