package com.analisisydisenoll.paymentmethodfactory;

public class ConcreteFactory extends AbstractFactory {
    IPay factoryMethod(PaymentType type) {
        switch (type) {
            case PSE:
                return new PSEPay();
            case WOMPI:
                return new WompiPay();
            case BANCOLOMBIA:
                return new BancolombiaPay();
            case DAVIVIENDA:
                return new DaviviendaPay();
            default:
                return null;
        }
    }
}
