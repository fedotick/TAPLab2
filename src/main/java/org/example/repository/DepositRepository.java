package org.example.repository;

import org.example.model.Deposit;
import org.example.model.Type;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DepositRepository implements IRepository<Deposit, Long> {

    private final List<Deposit> deposits;

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
    public Deposit create(Deposit entity) {
        entity.setId(getCurrentId());
        deposits.add(entity);
        return entity;
    }

    @Override
    public List<Deposit> findAll() {
        return new ArrayList<>(deposits);
    }

    @Override
    public Optional<Deposit> findById(Long id) {
        return deposits.stream()
                .filter(deposit -> deposit.getId().equals(id))
                .findFirst();
    }

    public List<Deposit> findAllByType(Type type) {
        return deposits.stream()
                .filter(deposit -> deposit.getType().equals(type))
                .toList();
    }

    @Override
    public Deposit update(Deposit entity) {
        Optional<Deposit> existingDeposit = findById(entity.getId());

        existingDeposit.ifPresent(deposit -> {
            int index = deposits.indexOf(deposit);
            deposits.set(index, entity);
        });

        return entity;
    }

    @Override
    public void deleteById(Long id) {
        deposits.removeIf(deposit -> deposit.getId().equals(id));
    }

    private Long getCurrentId() {
        return deposits.stream()
                .max(Comparator.comparing(Deposit::getId))
                .map(deposit -> deposit.getId() + 1L)
                .orElse(1L);
    }

}
