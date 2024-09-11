package org.example.service;

public interface IDepositService {

    void setDuration(String duration);
    String getDuration();

    void setType(String type);
    String getType();

    void close();

    void openNewDeposit(String currency);

    double calculateInterest();

}
