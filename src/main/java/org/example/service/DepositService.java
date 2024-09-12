package org.example.service;

import org.example.model.Deposit;
import org.example.model.Duration;
import org.example.repository.DepositRepository;

import java.util.Optional;

public class DepositService {

    private final DepositRepository depositRepository;
    private Deposit currentDeposit;

    public DepositService() {
        this.depositRepository = DepositRepository.getInstance();
    }

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public void setDuration(Duration duration) {
        if (currentDeposit != null) {
            currentDeposit.setDuration(duration);
            depositRepository.save(currentDeposit);
        }
    }

    public Duration getDuration() {
        if (currentDeposit != null) {
            return currentDeposit.getDuration();
        }
        return null;
    }

    public void setType(String type) {
        if (currentDeposit != null) {
            currentDeposit.setType(type);
            depositRepository.save(currentDeposit);
        }
    }

    public String getType() {
        if (currentDeposit != null) {
            return currentDeposit.getType();
        }
        return null;
    }

    public void close() {
        if (currentDeposit != null) {
            depositRepository.deleteById(currentDeposit.getId());
            currentDeposit = null;
        }
    }

    public void openNewDeposit(String currency) {
        if (currentDeposit != null) {
            Deposit newDeposit = new Deposit(
                    currentDeposit.getDuration(),
                    currentDeposit.getType(),
                    currentDeposit.getBalance(),
                    currentDeposit.getAnnualRate(),
                    currentDeposit.getDurationInYears(),
                    currency
            );
            depositRepository.save(newDeposit);
            currentDeposit = newDeposit;
        }
    }

    public double calculateInterest() {
        if (currentDeposit != null) {
            return currentDeposit.getBalance() * (currentDeposit.getAnnualRate() / 100) * currentDeposit.getDurationInYears();
        }
        return 0;
    }

    public Optional<Deposit> getDepositById(Long id) {
        return depositRepository.findById(id);
    }

    public void setCurrentDeposit(Long id) {
        Optional<Deposit> deposit = depositRepository.findById(id);
        deposit.ifPresent(value -> this.currentDeposit = value);
    }

}
