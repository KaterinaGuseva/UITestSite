package pages;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GameUserInyerfacePage extends Form {

    private final IButton btnHelpForm = getElementFactory().getButton(By.xpath("//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"), "Button Help form");
    private final ITextBox helpForm = getElementFactory().getTextBox(By.xpath("//div[@class='help-form']"), "Help Form");
    private final IButton btnAcceptCookies = getElementFactory().getButton(By.xpath("//button[@class='button button--solid button--transparent']"), "Button Help form");
    private final ITextBox checkCookiesForm = getElementFactory().getTextBox(By.xpath("//div[@class='cookies']"), "Cookies form");
    private final ITextBox valueOfTime = getElementFactory().getTextBox(By.xpath("//div[@class='timer timer--white timer--center']"), "Timer");

    public GameUserInyerfacePage() {
        super(By.xpath("//div[@class='login-form__container']"), "Login form");
    }

    public CardForm1 getCardForm1() {
        return new CardForm1();
    }

    public void clickOnHelpForm() {
        btnHelpForm.click();
    }

    public boolean isHelpFormDisplayed() {
        return helpForm.state().waitForDisplayed();
    }

    public void clickOnAcceptCookies() {
        btnAcceptCookies.click();
    }

    public boolean isCookiesFormDisplayed() {
        return checkCookiesForm.state().waitForDisplayed();
    }

    public String getTime() {
        return valueOfTime.getText();
    }
}
