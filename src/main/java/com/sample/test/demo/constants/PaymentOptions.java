package com.sample.test.demo.constants;

public enum PaymentOptions {
    CREDIT_CARD("Credit Card"),
    CASH_ON_PICKUP("Cash on Pickup");

    private String paymentMethod;

    PaymentOptions(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
