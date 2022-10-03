package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.MyConfiguration;
import utils.TimerFormat;
import utils.generators.PasswordGenerator;

import java.io.File;

public class CheckTestCases extends BaseTest {

    @Test
    public void testCase1() {
        MainUserInyerfacePage mainUserInyerfacePage = new MainUserInyerfacePage();
        mainUserInyerfacePage.goToGamePage();
        GameUserInyerfacePage gameUserInyerfacePage = new GameUserInyerfacePage();
        Assert.assertTrue(gameUserInyerfacePage.state().waitForDisplayed(), "Game page isn't open");
        CardForm1 cardForm1 = gameUserInyerfacePage.getCardForm1();
        Assert.assertTrue(cardForm1.state().waitForDisplayed(), "The '1' card isn't open");
        cardForm1.inputDataToCard1(MyConfiguration.getEmail(), MyConfiguration.getDomain(), PasswordGenerator.generatePassword());
        cardForm1.chooseDomainFromCombobox(MyConfiguration.getChooseDomain());
        cardForm1.acceptTermsAndConditions();
        CardForm2 cardForm2 = cardForm1.goToCard2();
        Assert.assertTrue(cardForm2.state().waitForDisplayed(), "The '2' card isn't open");
        cardForm2.uploadPhoto(new File(MyConfiguration.getUploadPhotoPath()).getAbsolutePath());
        cardForm2.chooseThreeRandomCheckBoxes();
        CardForm3 cardForm3 = cardForm2.goToCard3();
        Assert.assertTrue(cardForm3.state().waitForDisplayed(), "The '3' card isn't open");
    }

    @Test
    public void testCase2() {
        MainUserInyerfacePage mainUserInyerfacePage = new MainUserInyerfacePage();
        Assert.assertTrue(mainUserInyerfacePage.state().waitForDisplayed(),"Welcome page isn't open");
        mainUserInyerfacePage.goToGamePage();
        GameUserInyerfacePage gameUserInyerfacePage = new GameUserInyerfacePage();
        gameUserInyerfacePage.clickOnHelpForm();
        Assert.assertFalse(gameUserInyerfacePage.isHelpFormDisplayed(), "Help form isn't closed");
    }

    @Test
    public void testCase3() {
        MainUserInyerfacePage mainUserInyerfacePage = new MainUserInyerfacePage();
        Assert.assertTrue(mainUserInyerfacePage.state().waitForDisplayed(),"Welcome page isn't open");
        mainUserInyerfacePage.goToGamePage();
        GameUserInyerfacePage gameUserInyerfacePage = new GameUserInyerfacePage();
        gameUserInyerfacePage.clickOnAcceptCookies();
        Assert.assertFalse(gameUserInyerfacePage.isCookiesFormDisplayed(), "Cookies form isn't closed");
    }

    @Test
    public void testCase4() {
        MainUserInyerfacePage mainUserInyerfacePage = new MainUserInyerfacePage();
        Assert.assertTrue(mainUserInyerfacePage.state().waitForDisplayed(),"Welcome page isn't open");
        mainUserInyerfacePage.goToGamePage();
        GameUserInyerfacePage gameUserInyerfacePage = new GameUserInyerfacePage();
        Assert.assertEquals(TimerFormat.getTimeFormat(gameUserInyerfacePage.getTime()), MyConfiguration.getExpectedTimeForTimer(),"Timer doesn't start from 00:00");
    }
}
