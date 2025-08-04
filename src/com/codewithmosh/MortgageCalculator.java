package com.codewithmosh;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR =12;
    private final static byte PERCENT =100;

    private final int principal;
    private final float annualInterestRate;
    private final byte period;

    public MortgageCalculator(int principal , float annualInterestRate , byte period ) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }

    public double  calculateMortgage(){
        return this.principal
                * (this.getMonthlyInterestRate() * Math.pow(1+this.getMonthlyInterestRate(), this.getNumPayments()))
                / (Math.pow(1+this.getMonthlyInterestRate(), this.getNumPayments())-1);
    }

    public double calculateRemainingBalance(int numberOfPaymentsMade){
        return this.principal
                * (Math.pow(1+this.getMonthlyInterestRate(), this.getNumPayments()) - Math.pow(1+this.getMonthlyInterestRate() , numberOfPaymentsMade))
                / (Math.pow(1 + this.getMonthlyInterestRate(), this.getNumPayments()) - 1);
    }

    public double[] getPaymentSchedule(){
        var paymentSchedule = new double[this.getNumPayments()] ;
        for(short month = 1; month < paymentSchedule.length; month++)
            paymentSchedule[month - 1] = this.calculateRemainingBalance(month);
        return paymentSchedule;
    }

    private short getNumPayments() {
        return (short) (period * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterestRate(){
        return annualInterestRate / MONTHS_IN_YEAR / PERCENT;
    }
}
