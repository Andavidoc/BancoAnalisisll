package com.analisisydisenoll.paymentmethodfactory;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ConcreteFactory factory = new ConcreteFactory();
        PaymentType[] paymentTypes = PaymentType.values();
        while (true) {
            System.out.println("Elige un medio de pago:");
            System.out.println("0: Salir");
            for (int i = 0; i < paymentTypes.length; i++) {
                System.out.println((i + 1) + ": " + paymentTypes[i]);
            }
            System.out.println((paymentTypes.length + 1) + ": Elegir aleatoriamente 5 veces");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Inténtalo de nuevo.");
                scanner.nextLine();
                continue;
            }
            if (choice == 0) {
                break;
            } else if (choice == paymentTypes.length + 1) {
                for (int i = 0; i < 5; i++) {
                    int randomChoice = random.nextInt(paymentTypes.length);
                    IPay payment = factory.factoryMethod(paymentTypes[randomChoice]);
                    payment.pay();
                }
            } else if (choice < 0 || choice > paymentTypes.length + 1) {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            } else {
                IPay payment = factory.factoryMethod(paymentTypes[choice - 1]);
                payment.pay();
            }
        }
    }
}