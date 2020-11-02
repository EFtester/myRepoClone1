package Tests;

import PageObject.AddRemoveElementsPage;
import PageObject.Base;
import PageObject.CheckBoxes;
import PageObject.MainPage;
import PageObject.WYSIWYGEditor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;
    public Base base;
    public MainPage mainPage;
    public AddRemoveElementsPage addRemoveElementsPage;
    public CheckBoxes checkBoxes;
    public WYSIWYGEditor wysiwygEditor;

    @BeforeMethod
    protected void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        base = new Base(driver);
        mainPage = new MainPage(driver);
        checkBoxes = new CheckBoxes(driver);
        wysiwygEditor = new WYSIWYGEditor(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);

        driver.manage().window().maximize();
        base.visit("http://the-internet.herokuapp.com/");
    }

    @AfterMethod
    protected void after() {
        driver.quit();
    }

}

