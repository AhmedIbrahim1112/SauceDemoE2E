import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {
    protected WebDriver driver;
    Login loginPage;
    int loginTimes;
    @DataProvider(name="validUserData")
    public Object[][] Data(){
        return new Object[][]{{"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"perf" +
                        "ormance_glitch_user","secret_sauce"},
        };
    }

//    @DataProvider(name="userData")
//    public Object[][] Data(){
//        return new Object[][]{{"standard_user","secret_sauce"},
//                {"standard_user","secret_sauce123"},
//                {"standard_user123","secret_sauce"},
//                {"standard_user123","secret_sauce123"},
//                {"",""},
//                {"","secret_sauce"},
//                {"standard_user",""}};
//
//    }

    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @Test(dataProvider = "validUserData")
    public void validLoginTest(String username,String password) throws InterruptedException {
        loginPage = new Login(driver);
        loginPage.fillUsernameField(username);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
        if (loginTimes==0)
        {
            loginPage.clickBurgerMenu();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            loginPage.clickLogoutButton();
            loginTimes++;
        }
    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
