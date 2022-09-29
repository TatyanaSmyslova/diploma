package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    private static String getCardNumber(String card) {
        switch (card.toLowerCase()) {
            case ("approved"):
                return "4444 4444 4444 4441";
            case ("declined"):
                return "4444 4444 4444 4442";
            default:
                return "4444 4444 4444 4444";
        }
    }

    private static String getFullName() {
        return new Faker().name().firstName().toUpperCase() + " " + new Faker().name().firstName().toUpperCase();
    }

    private static String getCvcCvv() {
        Random dgt = new Random();
        return String.valueOf(dgt.nextInt(10)) + dgt.nextInt(10) + dgt.nextInt(10);
    }

    @Value
    public static class RequiredFields {
        String cardNumber;
        String month;
        String year;
        String owner;
        String cvcCvv;
    }

    public static RequiredFields getValidApprovedFields() {
        return new RequiredFields(getCardNumber("APPROVED"), "12", "26", getFullName(), getCvcCvv());
    }

    public static RequiredFields getValidDeclinedFields() {
        return new RequiredFields(getCardNumber("DECLINED"), "12", "26", getFullName(), getCvcCvv());
    }

    public static RequiredFields getInvalidCardFields() {
        return new RequiredFields(getCardNumber("INVALID"), "12", "26", getFullName(), getCvcCvv());
    }

    public static RequiredFields getInvalidOwnerFields() {
        return new RequiredFields(getCardNumber("APPROVED"), "12", "26", "ъ", getCvcCvv());
    }
}