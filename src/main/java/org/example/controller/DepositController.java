package org.example.controller;

import org.example.model.Duration;
import org.example.service.DepositService;

public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    public void changeDuration(Long depositId, Duration newDuration) {
        depositService.setCurrentDeposit(depositId);
        depositService.setDuration(newDuration);
        System.out.println("Продолжительность вклада изменена на: " + newDuration);
    }

    public void changeType(Long depositId, String newType) {
        depositService.setCurrentDeposit(depositId);
        depositService.setType(newType);
        System.out.println("Тип вклада изменен на: " + newType);
    }

    public void closeDeposit(Long depositId) {
        depositService.setCurrentDeposit(depositId);
        depositService.close();
        System.out.println("Вклад закрыт.");
    }

    public void openNewDepositWithCurrency(Long depositId, String newCurrency) {
        depositService.setCurrentDeposit(depositId);
        depositService.openNewDeposit(newCurrency);
        System.out.println("Новый вклад открыт с валютой: " + newCurrency);
    }

    public void calculateInterest(Long depositId) {
        depositService.setCurrentDeposit(depositId);
        double interest = depositService.calculateInterest();
        System.out.println("Начисленные проценты: " + interest);
    }

}
