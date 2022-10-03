package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainUserInyerfacePage extends Form {
    private final ILink linkGoTo1card = getElementFactory().getLink(By.xpath("//a[@class='start__link']"),"Link go to the next page" );

    public MainUserInyerfacePage() {
        super(By.xpath("//p[@class='start__paragraph' and contains(text(),'welcome')]"), "User Inyerface");
    }

    public void goToGamePage() {
        linkGoTo1card.clickAndWait();
    }
}
