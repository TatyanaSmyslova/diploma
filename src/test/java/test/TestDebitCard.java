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

public class TestDebitCard {

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
    void shouldPayByApprovedDebitCard() {
        val paymentPage = dashboardPage.payByDebitCard();
        val approvedCardInformation = DataHelper.getApprovedCardInformation();
        paymentPage.enterCardInfo(approvedCardInformation);
        paymentPage.checkSuccessNotification();
        val paymentStatus = DbHelper.getPaymentEntity();
        assertEquals("APPROVED", paymentStatus);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDeclinedDebitCard() {
        val paymentPage = dashboardPage.payByDebitCard();
        val declinedCardInformation = DataHelper.getDeclinedCardInformation();
        paymentPage.enterCardInfo(declinedCardInformation);
        paymentPage.checkDeclineNotification();
        val paymentStatus = DbHelper.getPaymentEntity();
        assertEquals("DECLINED", paymentStatus);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithInvalidNumber() {
        val paymentPage = dashboardPage.payByDebitCard();
        val invalidCardInformation = DataHelper.getInvalidCardInformation();
        paymentPage.enterCardInfo(invalidCardInformation);
        paymentPage.checkInvalidFormat();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyFieldNumber() {
        val paymentPage = dashboardPage.payByDebitCard();
        val emptyCardInformation = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardInfo(emptyCardInformation);
        paymentPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithExpiredYear() {
        val paymentPage = dashboardPage.payByDebitCard();
        val expiredYearCardInformation = DataHelper.getExpiredYearCardInformation();
        paymentPage.enterCardInfo(expiredYearCardInformation);
        paymentPage.checkExpiredDate();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyFieldYear() {
        val paymentPage = dashboardPage.payByDebitCard();
        val emptyYearCardInformation = DataHelper.getEmptyYearCardInformation();
        paymentPage.enterCardInfo(emptyYearCardInformation);
        paymentPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithInvalidExpirationDate() {
        val paymentPage = dashboardPage.payByDebitCard();
        val invalidExpirationDate = DataHelper.getInvalidExpirationDateCardInformation();
        paymentPage.enterCardInfo(invalidExpirationDate);
        paymentPage.checkInvalidDate();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyExpirationDate() {
        val paymentPage = dashboardPage.payByDebitCard();
        val emptyExpirationDate = DataHelper.getEmptyExpirationDateCardInformation();
        paymentPage.enterCardInfo(emptyExpirationDate);
        paymentPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithExpiredMonth() {
        val paymentPage = dashboardPage.payByDebitCard();
        val expiredMonth = DataHelper.getExpiredMonthCardInformation();
        paymentPage.enterCardInfo(expiredMonth);
        paymentPage.checkExpiredDate();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyMonth() {
        val paymentPage = dashboardPage.payByDebitCard();
        val emptyMonth = DataHelper.getEmptyMonthCardInformation();
        paymentPage.enterCardInfo(emptyMonth);
        paymentPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyCardInformation1() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        paymentPage.emptyField();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyCardInformation2() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.emptyField();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyCardInformation3() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.emptyField();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyCardInformation4() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.emptyField();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyCardInformation5() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.emptyField();
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyCardInformation6() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getEmptyCardInformation();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithInvalidOwner() {
        val paymentPage = dashboardPage.payByDebitCard();
        val invalidOwner = DataHelper.getInvalidOwnerCard();
        paymentPage.enterCardInfo(invalidOwner);
        paymentPage.checkInvalidFormat();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithEmptyOwner() {
        val paymentPage = dashboardPage.payByDebitCard();
        val emptyOwner = DataHelper.getEmptyOwnerCard();
        paymentPage.enterCardInfo(emptyOwner);
        paymentPage.emptyField();
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithInvalidAndNumberAndValidOtherFields1() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        paymentPage.checkInvalidFormat();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithInvalidAndNumberAndValidOtherFields2() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.checkInvalidFormat();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithInvalidAndNumberAndValidOtherFields3() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.checkInvalidFormat();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithInvalidAndNumberAndValidOtherFields4() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.checkInvalidFormat();
        paymentPage.enterCardInfo(validCardInfo);
    }

    @org.junit.jupiter.api.Test
    void shouldPayByDebitCardWithInvalidAndNumberAndValidOtherFields5() {
        val paymentPage = dashboardPage.payByDebitCard();
        val validCardInfo = DataHelper.getValidCardNumberWithInvalidOtherFields();
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.enterCardInfo(validCardInfo);
        paymentPage.checkInvalidFormat();
    }
}