package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        boolean tmp = true;

        while (tmp) {
            System.out.println("Enter amount in EUR: ");
            double amount = Double.parseDouble(sc.nextLine());
            System.out.println("Enter currnecy code: ");
            String code = sc.nextLine().toUpperCase();

            calculator.exchange(amount, code);

            System.out.println("To exit write [q], to continue write anything else");
            if (sc.nextLine().equals("q")) {
                tmp = false;
            }
        }
    }
}