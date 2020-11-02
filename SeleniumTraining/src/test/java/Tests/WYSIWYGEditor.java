package Tests;

import org.testng.annotations.Test;

public class WYSIWYGEditor extends TestBase {

    @Test
    public void AddTextToConsole(){
        mainPage
                .ClickLinkOnPage("WYSIWYG Editor");
        wysiwygEditor
                .openListFromMenuBar("File")
                .selectListItem("New document")
                .addTextToConsole("THIS IS SAMPLE FOR THE TEST");
    }
}
