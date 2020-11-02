package Tests;

import org.testng.annotations.Test;

public class Checkboxes extends TestBase {

    @Test
    public void MarkCheckbox() {
        mainPage
                .ClickLinkOnPage("Checkboxes");
        checkBoxes
                .MarkCheckbox(checkBoxes.checkbox1)
                .MarkCheckbox(checkBoxes.checkbox2);

    }
}
