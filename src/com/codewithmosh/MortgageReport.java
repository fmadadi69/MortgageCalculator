package com.codewithmosh;

import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }
    public void printMonthlyPayment(){
        System.out.println("MORTGAGE");
        System.out.println("---------");
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(this.calculator.calculateMortgage());
        System.out.println("Monthly Payments: " + mortgageFormatted + "\n");
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("------------------");
        for (short month = 1; month <= this.calculator.getNumPayments() ; month++) {
            System.out.printf("Month %2d: %s\n", month, NumberFormat.getCurrencyInstance().format(this.calculator.calculateRemainingBalance(month)));
        }
    }
}
