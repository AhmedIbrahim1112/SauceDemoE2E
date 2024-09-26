import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout extends PageBase {
    public Checkout(WebDriver driver)
    {
        super(driver);
    }

    private By firstnameField = By.id("first-name");

    WebElement firstnameFieldElement ;

    private By lastnameField = By.id("last-name");

    WebElement lastnameFieldElement ;

    private By postalCodeField = By.id("postal-code");

    WebElement postalCodeFieldElement ;

    private By continueButton = By.xpath("//*[@class=\"btn_primary cart_button\"]");

    WebElement continueButtonElement ;

    private By finishButton = By.xpath("//*[@class=\"btn_action cart_button\"]");

    WebElement finishButtonElement ;

    private By checkoutTitle = By.className("subheader");

    WebElement checkoutTitleElement ;


    public void fillFirstname(String firstname)
    {
        firstnameFieldElement= driver.findElement(firstnameField);
        writing(firstnameFieldElement,firstname);
    }

    public void fillLastname(String lastname)
    {
        lastnameFieldElement= driver.findElement(lastnameField);
        writing(lastnameFieldElement,lastname);
    }


    public void fillPostalCode(String postalCode)
    {
        postalCodeFieldElement= driver.findElement(postalCodeField);
        writing(postalCodeFieldElement,postalCode);
    }


    public void clickContinueButton()
    {
        continueButtonElement= driver.findElement(continueButton);
        clicking(continueButtonElement);
    }


    public void clickFinishButton()
    {
        finishButtonElement= driver.findElement(finishButton);
        clicking(finishButtonElement);
    }

    public String GetCheckoutTitle()
    {
        checkoutTitleElement= driver.findElement(checkoutTitle);
        return getText(checkoutTitleElement);
    }
}
