package Tests;
import org.testng.annotations.Test;

public class AddRemoveElements extends TestBase {

@Test
    public void AddElement(){
    mainPage
            .ClickLinkOnPage("Add/Remove Elements");
    addRemoveElementsPage
            .ClickAddElement(8);
}

@Test
    public void DeleteElement(){
    mainPage
            .ClickLinkOnPage("Add/Remove Elements");
    addRemoveElementsPage
            .ClickAddElement(10)
            .ClickDeleteElement(10);
}


}
