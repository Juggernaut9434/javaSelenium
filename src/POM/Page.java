//
// author: Michael Mathews 2020
//
//

package POM;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Basics;

import java.util.ArrayList;

/**
 * Abstract class that has the basics to a page
 * SubClass should instance title, url
 * Should hold all selectors and  possible functionality
 * Is then implemented in scenario for testing.
 * cssSelectors should be in instanced in the Subclass instance
 * and list clearly all cssSelectors being used.
 *
 * Example:
 * public class LoginPage extends Page {
 *     public LoginPage(WebDriver drive) {
 *          driver = drive;
 *          title = "Login";
 *          url = "/login_page";     // only the unique end of url, not all is needed
 *          elementutil = new Basics(driver, 10);
 *          cssSelectors = new ArrayList<String>(Arrays.asList(
 *              "username",
 *              "password",
 *              "confirmLogin"
 *          ));
 *     }
 * }
 */
public abstract class Page {
    // *****************************
    // Declaration of Variables
    // *****************************
    public String title;
    public String url;
    public ArrayList<String> cssSelectors;
    public ArrayList<WebElement> elements;  // do not instance immediately
    public ChromeDriver driver;
    public Basics elementutil;      // new Basics(driver, 10);

    // ********************************************
    // Get Methods for private variables
    // ********************************************
    public String getTitle() {return title;}
    public String getURL() {return url;}
    public ChromeDriver getDriver() {return driver;}
    public Basics getElementUtil() {return elementutil;}

    public void setCssSelectors(@NotNull ArrayList<String> cssList)
    {
        cssSelectors = new ArrayList<String>(cssList.size());
        cssSelectors.addAll(cssList);
    }
    public void addCssSelector(String css)
    {
        cssSelectors.add(css);
    }

    // ********************************************
    // WebDriver Methods
    // ********************************************
    public boolean confirmTitle()
    {
        return driver.getTitle().equals(title);
    }
    public boolean confirmURL()
    {
        return driver.getCurrentUrl().contains(url);
    }
    /**
     * Finds elements based off of the cssSelector
     * and adds them to the elements list
     */
    public void findElements()
    {
        elements = new ArrayList<WebElement>(cssSelectors.size());
        for (String cssSelector : cssSelectors) {
            elements.add( elementutil.findBySelector(cssSelector) );
        }
    }

}
