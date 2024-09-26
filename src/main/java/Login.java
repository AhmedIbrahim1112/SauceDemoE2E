import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends PageBase
{
    public Login(WebDriver driver)
    {
        super(driver);
    }
    private By loginButton = By.className("btn_action");

    private By usernameField = By.id("user-name");

    private By passwordField = By.id("password");

    private By burgerMenu = By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button");

    private By logoutButton = By.id("logout_sidebar_link");

    private By productTitle = By.className("product_label");

    WebElement loginButtonElement;

    WebElement usernameFieldElement;

    WebElement passwordFieldElement;

    WebElement burgerMenuElement;

    WebElement logoutButtonElement;

    WebElement productTitleElement;

    public void clickLoginButton()
    {
        loginButtonElement= driver.findElement(loginButton);
        clicking(loginButtonElement);
    }

    public void fillUsernameField (String username)
    {
        usernameFieldElement= driver.findElement(usernameField);
        writing(usernameFieldElement,username);
    }

    public void fillPasswordField (String password)
    {
        passwordFieldElement= driver.findElement(passwordField);
        writing(passwordFieldElement,password);
    }

    public void clickBurgerMenu()
    {
        burgerMenuElement= driver.findElement(burgerMenu);
        clicking(burgerMenuElement);
    }

    public void clickLogoutButton()
    {
        logoutButtonElement= driver.findElement(logoutButton);
        clicking(logoutButtonElement);
    }

    public String GetProductTitle()
    {
        productTitleElement= driver.findElement(productTitle);
        return getText(productTitleElement);
    }


}
