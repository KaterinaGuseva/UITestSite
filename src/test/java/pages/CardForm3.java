package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CardForm3 extends Form {
    public CardForm3() {
        super(By.xpath("//div[@class='personal-details__form']"), "Card form 3");
    }
}
