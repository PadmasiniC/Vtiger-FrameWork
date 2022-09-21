package Vtiger.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**This class will contact all the generic methods related to WebDriver actions. 
  * @author Padmasini
  */
public class WebDriverUtility {

/*
 * This Method will maximize the windows
 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

/*
 * This method will wait for 20 sec for the entire DOM to load
 */
public void waitForDOMLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
/*
 * This method will wait for the element to be visible
 * @param driver, element
 */
public void waitForElementsTobeVisible(WebDriver driver, WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver,10);
wait.until(ExpectedConditions.visibilityOf(element));
}

/*
 * This method will wait for an element to be clickable
 */
public void waitForElementTobeClickable(WebDriver driver, WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

/*
 * This method will handle DROPDOWNS using select class based on index
 * @parm element, int index
 */
public void handleDropDown(WebElement element, int index)
{
	Select s=new Select(element);
	s.selectByIndex(index);
}
/*
 * This method will handle DROPDOWNS using select class based on visible text
 * @parm element, string visible text
 */
public void handleDropDown(WebElement element, String VisibleText)
{
	Select s=new Select(element);
	s.selectByVisibleText(VisibleText);
}

/*
 * This method will handle DROPDOWNS using select class based on value
 * @parm element, string value
 */
public void handleDropDown(String value, WebElement element)
{
	Select s=new Select(element);
	s.selectByValue(value);
}
/*
 * This method will perform mousehover Action on a particular element
 * @parm element, driver
 */
public void mouseHover(WebDriver driver, WebElement element)
{
	Actions actmh=new Actions(driver);
	actmh.moveToElement(element).perform();	
}
/*
 * This method will perform doubleclick Action on an web page
 * @parm  driver
 */
public void doubleClickOn(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
/*
 * This method will perform doubleclick Action on a particular element
 * @parm  driver, element
 */
public void doubleClickOn(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/*
 * This method will perform rightclick Action on a page
 * @parm  driver
 */
public void rightClickOn(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
/*
 * This method will perform rightclick Action on a particular element
 * @parm  driver, element
 */
public void rightClickOn(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/*
 * This method will perform drag and drop Action from a source location to target location
 * @parm  driver, srcelement, targetelement
 */
public void dragAndDropOn(WebDriver driver, WebElement srcelement, WebElement targetelement)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(srcelement, targetelement);
}

/*
 * This method will press the enter key on the element
  */
public void pressEnter() throws AWTException
{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
}
/*
 * This method will handle the alert popup-accept on the webpage
 * @parm  driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/*
 * This method will handle the alert popup -dismiss on the webpage
 * @parm  driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/*
 * This method will get the text of the alert popup
 * @parm  driver
 * rtn text
 */
public String getTextOfAlert(WebDriver driver)
{
	String text=driver.switchTo().alert().getText();
	return text;
}
/*
 * This method will handle the frames based on Index
 * @parm  driver, index
 */
public void handleFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}
/*
 * This method will handle the frames based on the nameID
 * @param driver, nameorid
 */
public void handleFrame(WebDriver driver, String nameorid)
{
	driver.switchTo().frame(nameorid);
}
/*
 * This method will handle the frames based on frame element
 * @param driver, element
 */
public void handleFrame(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);
}
/*
 * This method will switch the contorl back to the immediate parent
 * @param driver
 */
public void toParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
/*
 * This method will come out of all the frames
 * @param driver
 */
public void toDefaultWindow(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/*
 * This method will switch from one window to another based on partial window title
 * @param driver, partialWintitle
 */
/**
 * This method will switch from one window to another based on Partial Window title
 * @param driver
 * @param partialWinTitle
 */
public void switchToWindow(WebDriver driver , String partialWinTitle)
{
	// Step - 1 : Get all Window Id's
	Set<String> windowIds = driver.getWindowHandles();
	
	// Step - 2 : Iterate-Navigate through all the window Ids
	Iterator<String> it = windowIds.iterator();
	
	// Step -3 : Navigate to each window and Get the title
	while(it.hasNext())
	{
		// Capture the individual window Id
		String winId = it.next();
		
		// Compare the current Window title with Partial Window Title
		String currentTitle = driver.switchTo().window(winId).getTitle();
		if(currentTitle.contains(partialWinTitle))
		{
			break;
		}
	}
}
/*  
 * This method will take screenshot and save it in scrnshot folder
 * @param driver,screenshotname
 */
public String takeScreenShot(WebDriver driver, String screenShotname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String path=".\\screenshot\\"+screenShotname+".png";
	File dst=new File(path);
	
	FileUtils.copyFile(src,dst);
	return dst.getAbsolutePath(); // used for reports
}

/*
 * This method will scroll until 500 on the page randomly
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.SrollBy(0,500)"," ");
}
/*
 * This method will scroll until u reach a particular element
 * @param driver, element
 */
public void scrollAction(WebDriver driver, WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].scrollIntoView()",element); // this method will scroll until the element
	int y= element.getLocation().getY();
	// for up and down use y - for left and right use x
	js.executeScript("window.ScrollBy(0,"+y+")",element);
}

}
