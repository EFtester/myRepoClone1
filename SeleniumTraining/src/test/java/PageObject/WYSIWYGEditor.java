package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class WYSIWYGEditor extends Base{
    public WYSIWYGEditor(WebDriver driver) { super(driver);}

@FindBy (xpath = "//iframe[contains(@title, 'Rich Text Area')]")
private WebElement textField;

    public WYSIWYGEditor openListFromMenuBar(String MenuBarItem){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='menuitem']//span[text()='"+MenuBarItem+"']/ancestor::button")));
        WebElement menuBarOption = driver.findElement(By.xpath("//div[@role='menuitem']//span[text()='"+MenuBarItem+"']/ancestor::button"));
        Assert.assertTrue(menuBarOption.isDisplayed());
        menuBarOption.click();
        return this;
    }

    public WYSIWYGEditor selectListItem(String ListItem){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='menuitem']//span[text()='"+ListItem+"']/../..")));
        WebElement ItemList = driver.findElement(By.xpath("//div[@role='menuitem']//span[text()='"+ListItem+"']/../.."));
        Assert.assertTrue(ItemList.isDisplayed());
        ItemList.click();
        return this;
    }

    public WYSIWYGEditor addTextToConsole(String textToAdd){
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.sendKeys(textToAdd);
        String areaText = textField.getText();
        Assert.assertEquals(textToAdd, areaText);
        return this;
    }
}
