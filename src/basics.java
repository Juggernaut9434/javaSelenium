// import webdriver

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basics {

    private WebDriverWait waiter;
    private ChromeDriver drive;
    public basics(ChromeDriver driver, int waitTime){
        // @link WebDriverWait#WebDriverWait(WebDriver, Duration);
        waiter = new WebDriverWait(driver, waitTime);
        drive = driver;
    }

    public ChromeDriver getDriver() {return drive;}

    public WebElement findByXpath(String xpath)
    {
        WebElement element;
        try {
            try {
                waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            }
            catch(TimeoutException e){
                assert true;
            }
            element = waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        }
        catch(TimeoutException e){
            throw new TimeoutException("time out on xpath" + xpath);
        }
        catch(NoSuchElementException g)
        {
            throw new NoSuchElementException("no such element with xpath: " + xpath);
        }

        return element;
    }

    public void blockUIDisappear(String css)
    {
        try {
            waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css)));
        }
        catch(TimeoutException e)
        {
            throw new TimeoutException("blockUI did not disappear" + css);
        }
    }

    public void scrollPage(int choice)
    {
        // choice 0 is top, else
        if(choice == 0)
            drive.executeScript("window.scrollTo(0,0)");
        else
            drive.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public clickClearSendKeys(WebElement element, String keys)
    {
        element.click();
        element.clear();
        element.sendKeys(Keys.HOME);
        element.sendKeys(keys);
    }
}
