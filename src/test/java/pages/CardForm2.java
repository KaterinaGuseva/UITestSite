package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.UploadRobot;
import utils.generators.RandomIntGenerator;

import java.util.List;

public class CardForm2 extends Form {
    private final ICheckBox ckbUnselectAll = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']"), "Unselect checkboxes");
    private final ILink linkUploadPhoto = getElementFactory().getLink(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "Link Upload Photo");
    private final IButton btnNextTo3 = getElementFactory().getButton(By.xpath("//button[@class='button button--stroked button--white button--fluid']"), "Button Next to card 3");
    private final String locatorAllInterestsCheckBoxes = "//label[not(contains(@for,'interest_selectall')) and not(contains(@for,'interest_unselectall'))]";
    public CardForm2() {
        super(By.xpath("//div[@class='avatar-and-interests__form']"), "Card form 2");
    }

    public void uploadPhoto(String uploadPhotoPath) {
        linkUploadPhoto.click();
        UploadRobot.uploadFile(uploadPhotoPath);
        btnNextTo3.state().waitForDisplayed();
    }

    public void chooseThreeRandomCheckBoxes() {
        ckbUnselectAll.click();
        List<ICheckBox> allCheckBoxesInterests = getElementFactory().findElements(By.xpath(locatorAllInterestsCheckBoxes), ElementType.CHECKBOX);
        int chooseInterestCheckbox = 0;
        while (chooseInterestCheckbox < 3) {
            int i = RandomIntGenerator.getRandomInt(0, allCheckBoxesInterests.size()-1);
            allCheckBoxesInterests.get(i).click();
            allCheckBoxesInterests.remove(i);
            chooseInterestCheckbox++;
        }
    }

    public CardForm3 goToCard3() {
        btnNextTo3.click();
        return new CardForm3();
    }
}
