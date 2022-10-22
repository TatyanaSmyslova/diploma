package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import data.DataHelper;
import page.DashboardPage;
import sql.DbHelper;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreditCard {

    DashboardPage dashboardPage;

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        dashboardPage = new DashboardPage();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        DbHelper.cleanDb();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByApprovedCreditCard() {
        val creditPage = dashboardPage.payByCreditCard();
        val approvedCardInformation = DataHelper.getApprovedCardInformation();
        creditPage.enterCardInfo(approvedCardInformation);
        creditPage.checkSuccessNotification();
        val creditStatus = DbHelper.getCreditEntity();
        assertEquals("APPROVED", creditStatus);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDeclinedCreditCard() {
        val creditPage = dashboardPage.payByCreditCard();
        val declinedCardInformation = DataHelper.getDeclinedCardInformation();
        creditPage.enterCardInfo(declinedCardInformation);
        creditPage.checkDeclineNotification();
        val creditStatus = DbHelper.getPaymentEntity();
        assertEquals("DECLINED", creditStatus);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithInvalidNumber() {
        val creditPage = dashboardPage.payByCreditCard();
        val invalidCardInformation = DataHelper.getInvalidCardInformation();
        creditPage.enterCardInfo(invalidCardInformation);
        creditPage.checkInvalidFormat();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyFieldNumber() {
        val creditPage = dashboardPage.payByCreditCard();
        val emptyCardInformation = DataHelper.getEmptyCardInformation();
        creditPage.enterCardInfo(emptyCardInformation);
        creditPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithExpiredYear() {
        val creditPage = dashboardPage.payByCreditCard();
        val expiredYearCardInformation = DataHelper.getExpiredYearCardInformation();
        creditPage.enterCardInfo(expiredYearCardInformation);
        creditPage.checkExpiredDate();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyFieldYear() {
        val creditPage = dashboardPage.payByCreditCard();
        val emptyYearCardInformation = DataHelper.getEmptyYearCardInformation();
        creditPage.enterCardInfo(emptyYearCardInformation);
        creditPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithInvalidExpirationDate() {
        val creditPage = dashboardPage.payByCreditCard();
        val invalidExpirationDate = DataHelper.getInvalidExpirationDateCardInformation();
        creditPage.enterCardInfo(invalidExpirationDate);
        creditPage.checkInvalidDate();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyExpirationDate() {
        val creditPage = dashboardPage.payByCreditCard();
        val emptyExpirationDate = DataHelper.getEmptyExpirationDateCardInformation();
        creditPage.enterCardInfo(emptyExpirationDate);
        creditPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithExpiredMonth() {
        val creditPage = dashboardPage.payByCreditCard();
        val expiredMonth = DataHelper.getExpiredMonthCardInformation();
        creditPage.enterCardInfo(expiredMonth);
        creditPage.checkExpiredDate();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyMonth() {
        val creditPage = dashboardPage.payByCreditCard();
        val emptyMonth = DataHelper.getEmptyMonthCardInformation();
        creditPage.enterCardInfo(emptyMonth);
        creditPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyCardInformation1() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        creditPage.emptyField();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyCardInformation2() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.emptyField();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyCardInformation3() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.emptyField();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyCardInformation4() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.emptyField();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyCardInformation5() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.emptyField();
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyCardInformation6() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithInvalidOwner() {
        val creditPage = dashboardPage.payByCreditCard();
        val invalidOwner = DataHelper.getInvalidOwnerCard();
        creditPage.enterCardInfo(invalidOwner);
        creditPage.checkInvalidFormat();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithEmptyOwner() {
        val creditPage = dashboardPage.payByCreditCard();
        val emptyOwner = DataHelper.getEmptyOwnerCard();
        creditPage.enterCardInfo(emptyOwner);
        creditPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithInvalidAndNumberAndValidOtherFields1() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        creditPage.checkInvalidFormat();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithInvalidAndNumberAndValidOtherFields2() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.checkInvalidFormat();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithInvalidAndNumberAndValidOtherFields3() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.checkInvalidFormat();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithInvalidAndNumberAndValidOtherFields4() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.checkInvalidFormat();
        creditPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByCreditCardWithInvalidAndNumberAndValidOtherFields5() {
        val creditPage = dashboardPage.payByCreditCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.enterCardInfo(validCardInfo);
        creditPage.checkInvalidFormat();
    }
}