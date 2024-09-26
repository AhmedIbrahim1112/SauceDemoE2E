import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart extends PageBase {
    public Cart(WebDriver driver)
    {
        super(driver);
    }

    private By continueShoppingButton = By.xpath("//*[@class=\"cart_footer\"]/a[1]");

    WebElement continueShoppingButtonElement ;

    private By checkoutButton = By.xpath("//*[@class=\"cart_footer\"]/a[2]");

    WebElement checkoutButtonElement ;

    private By checkoutTitle = By.className("subheader");

    WebElement checkoutTitleElement ;



    public void ClickContinueShopping()
    {
        continueShoppingButtonElement = driver.findElement(continueShoppingButton);
        clicking(continueShoppingButtonElement);
    }

    public void ClickCheckout()
    {
        checkoutButtonElement = driver.findElement(checkoutButton);
        clicking(checkoutButtonElement);
    }

    public String GetCheckoutTitle()
    {
        checkoutTitleElement= driver.findElement(checkoutTitle);
        return getText(checkoutTitleElement);
    }

}
