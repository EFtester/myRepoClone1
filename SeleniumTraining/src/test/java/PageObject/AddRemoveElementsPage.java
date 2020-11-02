package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddRemoveElementsPage extends Base {
    public AddRemoveElementsPage(WebDriver driver) { super(driver);}

    @FindBy (xpath = "//button[text()='Add Element']")
    private WebElement AddElementButton;

    @FindBy (xpath = "//button[text()='Delete'][1]")
    private WebElement DeleteButton;

    public AddRemoveElementsPage ClickAddElement(int HowManyTimes){
        Assert.assertTrue(AddElementButton.isDisplayed());
        int deleteCountBefore = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        for(int i=1; i<=HowManyTimes; i++){
            AddElementButton.click();
        }
        int deleteCountAfter = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(deleteCountAfter, (deleteCountBefore+HowManyTimes));
        return this;
    }

    public AddRemoveElementsPage ClickDeleteElement(int HowManyTimes){
        Assert.assertTrue(DeleteButton.isDisplayed());
        int deleteCountBefore = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        for(int i=1; i<=HowManyTimes; i++){
            DeleteButton.click();
        }
        int deleteCountAfter = driver.findElements(By.xpath("//button[text()='Delete']")).size();

        if (deleteCountBefore == HowManyTimes){ Assert.assertTrue(deleteCountAfter==0); }
        else if(deleteCountBefore < HowManyTimes){
            System.out.println("Parameter cannot be bigger than amount of Delete buttons visible on the screen");

        }
        else{Assert.assertEquals(deleteCountBefore-HowManyTimes, deleteCountAfter);}

        return this;
    }
}
