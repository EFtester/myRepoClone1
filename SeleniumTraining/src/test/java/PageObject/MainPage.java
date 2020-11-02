package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base {

    public MainPage(WebDriver driver) { super(driver);}


    public void ClickLinkOnPage(String LinkName){
        driver.findElement(By.xpath("//a[text()='"+LinkName+"']")).click();
    }
}
