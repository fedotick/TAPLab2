package org.example.model;

import java.util.Objects;

public class Deposit {

    private Long id;
    private Duration duration;
    private Type type;
    private Double balance;
    private Double annualRate;
    private Integer durationInYears;
    private Currency currency;

    public Deposit() {
    }

    public Deposit(Duration duration, Type type, double balance, double annualRate, int durationInYears, Currency currency) {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(id, deposit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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
