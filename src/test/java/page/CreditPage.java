package page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.time.Duration.*;
import static com.codeborne.selenide.Selectors.byText;

public class CreditPage {

    private SelenideElement heading = $$("h3").findBy(Condition.text("Оплата по карте"));
    private SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("input[placeholder='08']");
    private SelenideElement yearField = $("input[placeholder='22']");
    private SelenideElement holderField = $(byXpath("/html/body/div/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input"));
    private SelenideElement cvcField = $("input[placeholder='999']");
    private SelenideElement continueButton = $$("button").findBy(Condition.text("Продолжить"));


    public CreditPage() {
        heading.shouldBe(Condition.visible);
    }

    public void enterCardInfo(DataHelper.CardInfo cardInfo) {
        cardNumberField.setValue(cardInfo.getCardNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        holderField.setValue(cardInfo.getOwner());
        cvcField.setValue(cardInfo.getCvc());
        continueButton.click();
    }


    public void checkSuccessNotification() {
        $(".notification_status_ok").shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    public void checkDeclineNotification() {
        $("notification_status_error").shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    public void checkInvalidFormat() {
        $(".input__sub").shouldHave(exactText("Неверный формат")).shouldBe(visible);
    }

    public void checkInvalidDate() {
        $(".input__sub").shouldHave(exactText("Неверно указан срок действия карты")).shouldBe(visible);
    }

    public void checkExpiredDate() {
        $(".input__sub").shouldHave(exactText("Истёк срок действия карты")).shouldBe(visible);
    }

    public void emptyField() {
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}