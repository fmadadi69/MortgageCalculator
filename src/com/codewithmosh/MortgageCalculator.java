package com.codewithmosh;

public class MortgageCalculator {
    final byte MONTHS_IN_YEAR =12;
    final byte PERCENT =100;
    private final int principal;
    private final float annualInterestRate;
    private final byte period;
    private final short num_payments;
    private final float monthlyInterestRate;


    public MortgageCalculator(int principal , float annualInterestRate , byte period ) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
        this.num_payments = (short) (period * MONTHS_IN_YEAR);
        this.monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

    }

    public short getNumPayments() {
        return num_payments;
    }

    public double  calculateMortgage(){
        return this.principal
                * (this.monthlyInterestRate * Math.pow(1+this.monthlyInterestRate, this.num_payments))
                / (Math.pow(1+this.monthlyInterestRate, this.num_payments)-1);
    }

    public double calculateRemainingBalance(int numberOfPaymentsMade){
        return this.principal
                * (Math.pow(1+this.monthlyInterestRate, this.num_payments) - Math.pow(1+this.monthlyInterestRate , numberOfPaymentsMade))
                / (Math.pow(1 + this.monthlyInterestRate, this.num_payments) - 1);
    }


}
