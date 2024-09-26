import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
    protected WebDriver driver;

    public PageBase (WebDriver driver){
        this.driver = driver;
    }

    public static void clicking (WebElement element)
    {
        element.click();
    }

    public static void writing (WebElement element,String data)
    {
        element.sendKeys(data);
    }

    public static String getText (WebElement element){
        return element.getText();
    }
}
