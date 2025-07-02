package com.codewithmosh;

public class Main {

    public static void main(String[] args) {

        ConsoleReader reader = new ConsoleReader();

        int principal = (int) reader.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) reader.readNumber("Annual Interest Rate (Greater than 0 and less than equal 30 Percent): ", 1, 30);
        byte period = (byte) reader.readNumber("Period (Years) (1 - 30): ", 1, 30);

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, period);
        MortgageReport report = new MortgageReport(calculator);

        report.printMonthlyPayment();
        report.printPaymentSchedule();
    }
}