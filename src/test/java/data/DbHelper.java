package data;

import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class DbHelper {
    private final static Connection conn = establishConnection();
    private final static QueryRunner runn = new QueryRunner();
    private final static ResultSetHandler<List<Fields>> hand = new BeanListHandler<>(Fields.class);

    private DbHelper() {
    }

    @SneakyThrows
    private static Connection establishConnection() {
        return DriverManager.getConnection(System.getProperty("db.url"), System.getProperty("db.user"), System.getProperty("db.password"));
    }

    /* credit_request_entity table */

    @SneakyThrows
    public static String getCreditId() {
        val ids = runn.query(conn, "SELECT id FROM credit_request_entity ORDER BY created;", hand);
        return ids.get(ids.size() - 1).getId();
    }

    @SneakyThrows
    public static String getCreditBankId() {
        val bankIds = runn.query(conn, "SELECT bank_id FROM credit_request_entity ORDER BY created;", hand);
        return bankIds.get(bankIds.size() - 1).getBank_id();
    }

    @SneakyThrows
    public static String getCreditCreated() {
        val created = runn.query(conn, "SELECT created FROM credit_request_entity;", hand);
        return created.get(created.size() - 1).getCreated();
    }

    @SneakyThrows
    public static String getCreditStatus() {
        val statuses = runn.query(conn, "SELECT status FROM credit_request_entity ORDER BY created;", hand);
        return statuses.get(statuses.size() - 1).getStatus();
    }

    /* order_entity table */

    @SneakyThrows
    public static String getOrderId() {
        val orderIds = runn.query(conn, "SELECT id FROM order_entity ORDER BY created;", hand);
        return orderIds.get(orderIds.size() - 1).getId();
    }

    @SneakyThrows
    public static String getOrderCreated() {
        val created = runn.query(conn, "SELECT created FROM order_entity;", hand);
        return created.get(created.size() - 1).getCreated();
    }

    @SneakyThrows
    public static String getOrderCreditId() {
        val creditIds = runn.query(conn, "SELECT credit_id FROM order_entity ORDER BY created;", hand);
        return creditIds.get(creditIds.size() - 1).getCredit_id();
    }

    @SneakyThrows
    public static String getOrderPaymentId() {
        val paymentIds = runn.query(conn, "SELECT payment_id FROM order_entity ORDER BY created;", hand);
        return paymentIds.get(paymentIds.size() - 1).getPayment_id();
    }

    /* payment_entity table*/

    @SneakyThrows
    public static String getPaymentId() {
        val ids = runn.query(conn, "SELECT id FROM payment_entity ORDER BY created;", hand);
        return ids.get(ids.size() - 1).getId();
    }

    @SneakyThrows
    public static int getPaymentAmount() {
        val amounts = runn.query(conn, "SELECT amount FROM payment_entity ORDER BY created;", hand);
        return amounts.get(amounts.size() - 1).getAmount();
    }

    @SneakyThrows
    public static String getPaymentCreated() {
        val created = runn.query(conn, "SELECT created FROM payment_entity;", hand);
        return created.get(created.size() - 1).getCreated();
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        val statuses = runn.query(conn, "SELECT status FROM payment_entity ORDER BY created;", hand);
        return statuses.get(statuses.size() - 1).getStatus();
    }

    @SneakyThrows
    public static String getPaymentTransactionId() {
        val transactionIds = runn.query(conn, "SELECT transaction_id FROM payment_entity ORDER BY created;", hand);
        return transactionIds.get(transactionIds.size() - 1).getTransaction_id();
    }
}