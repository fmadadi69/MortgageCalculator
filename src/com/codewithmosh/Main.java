package com.codewithmosh;

public class Main {

    public static void main(String[] args) {

        int principal = (int) ConsoleReader.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) ConsoleReader.readNumber("Annual Interest Rate (Greater than 0 and less than equal 30 Percent): ", 1, 30);
        byte period = (byte) ConsoleReader.readNumber("Period (Years) (1 - 30): ");

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, period);
        MortgageReport report = new MortgageReport(calculator);

        report.printMonthlyPayment();
        report.printPaymentSchedule();
    }
}