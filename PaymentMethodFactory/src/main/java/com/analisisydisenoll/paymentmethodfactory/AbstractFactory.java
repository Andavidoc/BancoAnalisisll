package com.analisisydisenoll.paymentmethodfactory;

public abstract class AbstractFactory {
    abstract IPay factoryMethod(PaymentType type);
}
