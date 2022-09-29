package test;

import data.DataHelper;
import data.DbHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashboardPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentPageUiTest {
    private final int expectedAmount = 45_000_00;

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    /*=======================================*/
    /*          Approved payment            */
    /*_____________________________________*/

    @Test
    void shouldApproveViaPayment() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNull(DbHelper.getOrderCreditId());
    }

    @Test
    void shouldInsertPaymentId() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getPaymentId());
    }

    @Test
    void shouldInsertPaymentAmount() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertEquals(expectedAmount, DbHelper.getPaymentAmount());
    }

    @Test
    void shouldInsertPaymentCreated() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getPaymentCreated());
    }

    @Test
    void shouldInsertApprovedPaymentStatus() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertEquals("APPROVED", DbHelper.getPaymentStatus());
    }

    @Test
    void shouldInsertPaymentIdAndTransactionId() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertEquals(DbHelper.getOrderPaymentId(), DbHelper.getPaymentTransactionId());
        assertNotNull(DbHelper.getOrderPaymentId());
    }

    @Test
    void shouldInsertPaymentOrderId() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getOrderId());
    }

    @Test
    void shouldInsertPaymentOrderCreated() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyApproved(DataHelper.getValidApprovedFields());
        assertNotNull(DbHelper.getOrderCreated());
    }

    /*=======================================*/
    /*          Declined payment            */
    /*_____________________________________*/

    @Test
//    @Disabled
    void shouldDeclineViaPayment() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNull(DbHelper.getOrderCreditId());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedPaymentId() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getPaymentId());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedPaymentAmount() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals(expectedAmount, DbHelper.getPaymentAmount());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedPaymentCreated() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getPaymentCreated());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedPaymentStatus() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals("DECLINED", DbHelper.getPaymentStatus());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedPaymentIdAndTransactionId() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertEquals(DbHelper.getOrderPaymentId(), DbHelper.getPaymentTransactionId());
        assertNotNull(DbHelper.getOrderPaymentId());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedOrderId() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getOrderId());
    }

    @Test
//    @Disabled
    void shouldInsertDeclinedPaymentOrderCreated() {
        new
                DashboardPage().
                goToPaymentPage().
                verifyDeclinedWithValidInput(DataHelper.getValidDeclinedFields());
        assertNotNull(DbHelper.getOrderCreated());
    }

    /*===================================*/
    /*          Invalid payment         */
    /*_________________________________*/

    @Test
    void shouldDeclineViaPaymentWithEmptyFields() {
        new
                DashboardPage().
                goToPaymentPage().
                checkDeclinedWithEmptyFields();
    }

    @Test
//    @Disabled
    void shouldDeclineViaPaymentWithInvalidCard() {
        new
                DashboardPage().
                goToPaymentPage().
                checkDeclinedWithInvalidCard(DataHelper.getInvalidCardFields());
    }

    @Test
//    @Disabled
    void shouldDeclineViaPaymentWithInvalidOwner() {
        new
                DashboardPage().
                goToPaymentPage().
                checkDeclinedWithInvalidOwner(DataHelper.getInvalidOwnerFields());
    }
}