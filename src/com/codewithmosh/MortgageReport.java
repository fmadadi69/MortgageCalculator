package com.codewithmosh;

import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }
    public void printMonthlyPayment(){
        System.out.println("MORTGAGE");
        System.out.println("---------");
        String mortgageFormatted = currency.format(this.calculator.calculateMortgage());
        System.out.println("Monthly Payments: " + mortgageFormatted + "\n");
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("------------------");
        short iterator = 1;
        for(double payment: calculator.getPaymentSchedule()){
            System.out.printf("Month %3d: %s\n", iterator++, currency.format(payment));
        }
//        for (short i = 0; i <  this.calculator.getPaymentSchedule().length ; i++) {
//            System.out.printf("Month %2d: %s\n", i+1, NumberFormat.getCurrencyInstance().format(calculator.getPaymentSchedule()[i]));
//        }
    }
}
