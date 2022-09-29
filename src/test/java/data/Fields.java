package data;

import lombok.Data;

@Data
public class Fields {
    private String id;
    private int amount;
    private String status;
    private String created;
    private String bank_id;
    private String credit_id;
    private String payment_id;
    private String transaction_id;
}