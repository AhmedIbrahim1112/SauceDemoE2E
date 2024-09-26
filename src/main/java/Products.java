import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products extends PageBase {
    public Products(WebDriver driver)
    {
       super(driver);
    }

    private By firstProductButton = By.xpath("//*[@class=\"inventory_list\"]/div[1]/div[3]/button");

    WebElement firstProductButtonElement ;
    WebElement firstProductButtonName ;

    private By secondProductButton = By.xpath("//*[@class=\"inventory_list\"]/div[2]/div[3]/button");

    WebElement secondProductButtonElement ;
    WebElement secondProductButtonName ;

    private By cartIcon = By.xpath("//*[@fill=\"currentColor\"]");

    WebElement cartIconElement;

    private By cartTitle = By.className("subheader");

    WebElement cartTitleElement ;

    public void AddFirstItemToCart()
    {
        firstProductButtonElement = driver.findElement(firstProductButton);
        clicking(firstProductButtonElement);
    }

    public void AddSecondItemToCart()
    {
        secondProductButtonElement = driver.findElement(secondProductButton);
        clicking(secondProductButtonElement);
    }

    public void GoToCart()
    {
        cartIconElement = driver.findElement(cartIcon);
        clicking(cartIconElement);
    }

    public String GetFirstButtonName()
    {
        firstProductButtonName= driver.findElement(firstProductButton);
        return getText(firstProductButtonName);
    }

    public String GetSecondButtonName()
    {
        secondProductButtonName= driver.findElement(secondProductButton);
        return getText(secondProductButtonName);
    }

    public String GetCartTitle()
    {
        cartTitleElement= driver.findElement(cartTitle);
        return getText(cartTitleElement);
    }

}
