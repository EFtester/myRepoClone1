package PageObject;

import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckBoxes extends Base {
    public CheckBoxes(WebDriver driver) { super(driver);}

    @FindBy (xpath = "//form[@id='checkboxes']//input[1]")
    public WebElement checkbox1;
    @FindBy (xpath = "//form[@id='checkboxes']//input[2]")
    public WebElement checkbox2;

    public CheckBoxes MarkCheckbox(WebElement ObjToClick){
        Assert.assertTrue(ObjToClick.isDisplayed());
        boolean isMarked = ObjToClick.isSelected();
        ObjToClick.click();

        if (isMarked==false){ Assert.assertTrue(ObjToClick.isSelected()); }
        else {Assert.assertFalse(ObjToClick.isSelected());}
        return this;
    }

}
