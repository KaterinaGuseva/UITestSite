package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class CardForm1 extends Form {

    private final ITextBox txbEmailBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "TextBox Your email");
    private final ITextBox txbDomainBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "TextBox Your domain");
    private final IButton btnDomaincomboBox = getElementFactory().getButton(By.xpath("//div[@class='dropdown__field']"), "Domain dropdown menu button");
    private final ITextBox txbPasswordBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "TextBox Password");
    private final ICheckBox ckbAccept = getElementFactory().getCheckBox(By.xpath("//span[@class='checkbox__box']"), "Checkbox Accept");
    private final IButton btnNextTo2 = getElementFactory().getButton(By.xpath("//a[@class='button--secondary']"), "Button Next to card 2");

    public CardForm1() {
        super(By.xpath("//div[@class='login-form__container']"), "Card form 1");
    }

    public void inputDataToCard1(String email, String domain, String password) {
        txbEmailBox.clearAndType(email);
        txbDomainBox.clearAndType(domain);
        txbPasswordBox.clearAndType(password);
    }

    public void chooseDomainFromCombobox(String chooseDomain) {
        btnDomaincomboBox.click();
        String selectedDomain= String.format("//div[@class='dropdown__list-item' and contains (text(),'%s')]",chooseDomain);
        getElementFactory().getButton(By.xpath(selectedDomain), "Domain").click();
    }

    public void acceptTermsAndConditions() {
        ckbAccept.click();
    }
    public CardForm2 goToCard2() {
        btnNextTo2.click();
        return new CardForm2();
    }
}
