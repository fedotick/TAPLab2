package org.example.model;

public class Deposit {

    private Long id;
    private Duration duration;
    private String type;
    private double balance;
    private double annualRate;
    private int durationInYears;
    private String currency;

    public Deposit() {
    }

    public Deposit(Duration duration, String type, double balance, double annualRate, int durationInYears, String currency) {
        this.duration = duration;
        this.type = type;
        this.balance = balance;
        this.annualRate = annualRate;
        this.durationInYears = durationInYears;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(double annualRate) {
        this.annualRate = annualRate;
    }

    public int getDurationInYears() {
        return durationInYears;
    }

    public void setDurationInYears(int durationInYears) {
        this.durationInYears = durationInYears;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "duration='" + duration + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", annualRate=" + annualRate +
                ", durationInYears=" + durationInYears +
                ", currency='" + currency + '\'' +
                '}';
    }

}
