package org.example.service;

import org.example.model.Currency;
import org.example.model.Deposit;
import org.example.model.Type;
import org.example.repository.DepositRepository;

import java.util.List;
import java.util.Optional;

public class DepositService implements IService<Deposit, Long> {

    private final DepositRepository depositRepository;

    public DepositService() {
        this.depositRepository = DepositRepository.getInstance();
    }

    @Override
    public Deposit create(Deposit deposit) {
        return depositRepository.create(deposit);
    }

    public List<Deposit> create(List<Deposit> deposits) {
        return deposits.stream()
                .map(this::create)
                .toList();
    }

    @Override
    public List<Deposit> findAll() {
        return depositRepository.findAll();
    }

    @Override
    public Optional<Deposit> findById(Long id) {
        return depositRepository.findById(id);
    }

    public List<Deposit> findAllByType(Type type) {
        return depositRepository.findAllByType(type);
    }

    @Override
    public Deposit update(Deposit deposit) {
        return depositRepository.update(deposit);
    }

    @Override
    public void deleteById(Long id) {
        depositRepository.deleteById(id);
    }

    public Deposit closeDepositAndOpenNewInDifferentCurrency(Deposit deposit, Currency currency) {
        deleteById(deposit.getId());
        deposit.setCurrency(currency);
        return create(deposit);
    }

    public Double calculateInterestAccrual(Deposit deposit) {
        return deposit.getBalance() * deposit.getAnnualRate() * deposit.getDurationInYears() / 100;
    }

}
