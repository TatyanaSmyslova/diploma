package test;

import data.DataHelper;
import data.DbHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class CreditPageUiTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    /*===================================*/
    /*          Approved credit         */
    /*_________________________________*/

    @Test
//    @Disabled
    void shouldApproveViaCredit() {
        new
                DashboardPage().
                goToCreditPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNull(DbHelper.getOrderPaymentId());
    }

    @Test
    void shouldInsertCreditId() {
        new
                DashboardPage().
                goToCreditPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getCreditId());
    }

    @Test
//    @Disabled
    void shouldInsertCreditIdAndTransactionId() {
        new
                DashboardPage().
                goToCreditPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertEquals(DbHelper.getOrderCreditId(), DbHelper.getCreditBankId());
        assertNotNull(DbHelper.getOrderCreditId());
    }

    @Test
    void shouldInsertCreditCreated() {
        new
                DashboardPage().
                goToCreditPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getCreditCreated());
    }

    @Test
    void shouldInsertApprovedCreditStatus() {
        new
                DashboardPage().
                goToCreditPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertEquals("APPROVED", DbHelper.getCreditStatus());
    }

    @Test
    void shouldInsertCreditOrderId() {
        new
                DashboardPage().
                goToCreditPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getOrderId());
    }

    @Test
    void shouldInsertCreditOrderCreated() {
        new
                DashboardPage().
                goToCreditPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getOrderCreated());
    }

    /*===================================*/
    /*          Declined credit         */
    /*_________________________________*/

    @Test
//    @Disabled
    void shouldDeclineViaCredit() {
        new
                DashboardPage().
                goToCreditPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNull(DbHelper.getOrderPaymentId());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedCreditId() {
        new
                DashboardPage().
                goToCreditPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getCreditId());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedCreditIdAndTransactionId() {
        new
                DashboardPage().
                goToCreditPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals(DbHelper.getOrderCreditId(), DbHelper.getCreditBankId());
        assertNotNull(DbHelper.getOrderCreditId());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedCreditCreated() {
        new
                DashboardPage().
                goToCreditPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getCreditCreated());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedCreditStatus() {
        new
                DashboardPage().
                goToCreditPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals("DECLINED", DbHelper.getCreditStatus());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedCreditOrderId() {
        new
                DashboardPage().
                goToCreditPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getOrderId());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedCreditOrderCreated() {
        new
                DashboardPage().
                goToCreditPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getOrderCreated());
    }

    /*===================================*/
    /*          Invalid credit          */
    /*_________________________________*/

    @Test
    void shouldDeclineViaCreditWithEmptyFields() {
        new
                DashboardPage().
                goToCreditPage().
                checkDeclinedWithEmptyFields();
    }

    @Test
//    @Disabled
    void shouldDeclineViaCreditWithInvalidCard() {
        new
                DashboardPage().
                goToCreditPage().
                checkDeclinedWithInvalidCard(DataHelper.getInvalidCardFields());
    }

    @Test
//    @Disabled
    void shouldDeclineViaCreditWithInvalidOwner() {
        new
                DashboardPage().
                goToCreditPage().
                checkDeclinedWithInvalidOwner(DataHelper.getInvalidOwnerFields());
    }
}