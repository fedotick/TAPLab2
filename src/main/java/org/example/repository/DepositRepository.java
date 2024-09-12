package org.example.repository;

import org.example.model.Deposit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepositRepository implements IRepository<Deposit, Long> {

    private final List<Deposit> deposits;
    private Long currentId = 1L;

    private static DepositRepository instance;

    private DepositRepository() {
        deposits = new ArrayList<>();
    }

    public static DepositRepository getInstance() {
        if (instance == null) {
            instance = new DepositRepository();
        }
        return instance;
    }

    @Override
    public Deposit save(Deposit entity) {
        if (entity.getId() == null) {
            entity.setId(currentId++);
        }
        Optional<Deposit> existingDeposit = findById(entity.getId());
        existingDeposit.ifPresent(deposits::remove);
        deposits.add(entity);
        return entity;
    }

    @Override
    public Optional<Deposit> findById(Long id) {
        return deposits.stream()
                .filter(deposit -> deposit.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Deposit> findAll() {
        return new ArrayList<>(deposits);
    }

    @Override
    public void deleteById(Long id) {
        deposits.removeIf(deposit -> deposit.getId().equals(id));
    }

}
