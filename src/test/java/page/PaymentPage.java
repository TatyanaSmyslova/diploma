package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.time.Duration.*;

public class PaymentPage {

    private SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement cardMonth = $("[placeholder='08']");
    private SelenideElement cardYear = $("[placeholder='22']");
    private SelenideElement cardOwner = $("fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    private SelenideElement cardCVC = $("[placeholder='999']");
    private SelenideElement buyButton = $$(".button").find(exactText("Продолжить"));

    private SelenideElement successNotification = $(withText("Успешно"));
    private SelenideElement errorNotification = $(withText("Ошибка"));
    private SelenideElement cardNumberFieldWarning = $("fieldset > div:nth-child(1) > span > span > span.input__sub");
    private SelenideElement monthFieldWarning = $("div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub");
    private SelenideElement yearFieldWarning = $("div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub");
    private SelenideElement ownerFieldWarning = $("div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__sub");
    private SelenideElement cvcFieldWarning = $("div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub");

    public void enterCardInfo(DataHelper.CardInfo cardInfo) {
        cardNumber.setValue(cardInfo.getCardNumber());
        cardMonth.setValue(cardInfo.getMonth());
        cardYear.setValue(cardInfo.getYear());
        cardOwner.setValue(cardInfo.getOwner());
        cardCVC.setValue(cardInfo.getCvc());
        buyButton.click();
    }

    public void waitSuccessNotification() {
        successNotification.shouldBe(Condition.visible);
    }

    public void waitErrorNotification() {
        errorNotification.shouldBe(Condition.visible);
    }

    public void checkInvalidCardNumber() {
        cardNumberFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkInvalidMonth() {
        monthFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkInvalidYear() {
        yearFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkInvalidOwner() {
        ownerFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkInvalidCvc() {
        cvcFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkEmptyCardNumberFieldMessage() {
        cardNumberFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkEmptyMonthFieldMessage() {
        monthFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkEmptyYearFieldMessage() {
        yearFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkEmptyOwnerFieldMessage() {
        ownerFieldWarning.shouldHave(text("Поле обязательно для заполнения"));
    }

    public void checkEmptyCvcFieldMessage() {
        cvcFieldWarning.shouldHave(text("Неверный формат"));
    }

    public void checkExpiredYearMessage() {
        yearFieldWarning.shouldHave(text("Истёк срок действия карты"));
    }

    public void checkExpiredMonthMessage() {
        monthFieldWarning.shouldHave(text("Неверно указан срок действия карты"));
    }

    public void checkInvalidExpirationDate() {
        yearFieldWarning.shouldHave(text("Неверно указан срок действия карты"));
    }
}