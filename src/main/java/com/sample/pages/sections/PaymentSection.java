package com.sample.pages.sections;

import com.sample.test.demo.constants.PaymentOptions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Radio;

public class PaymentSection extends HtmlElement {
    @FindBy(id= "ccpayment")
    private Radio creditCard;

    @FindBy(id= "cashpayment")
    private Radio cash;

    public PaymentSection payBY(PaymentOptions paymentOption) {
        switch (paymentOption) {
            case CREDIT_CARD:
                creditCard.click();
                break;
            case CASH_ON_PICKUP:
                cash.click();
                break;
        }
        return this;
    }

    public String getSelectedPayment() {
        if(creditCard.isSelected()) {
            return creditCard.getText();
        }
        if(cash.isSelected()) {
            return cash.getText();
        }
        return "";
    }
}
