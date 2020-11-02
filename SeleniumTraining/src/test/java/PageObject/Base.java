package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Base {
    protected WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public BufferedReader myReader;
    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,300);
        actions = new Actions(driver);
        myReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void visit(String url) {
        driver.get(url);
    }

}
