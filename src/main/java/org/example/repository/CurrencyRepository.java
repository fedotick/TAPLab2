package org.example.repository;

import org.example.model.Currency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CurrencyRepository implements IRepository<Currency, Long> {

    private final List<Currency> currencies;

    private static CurrencyRepository instance;

    private CurrencyRepository() {
        currencies = new ArrayList<>();
    }

    public static CurrencyRepository getInstance() {
        if (instance == null) {
            instance = new CurrencyRepository();
        }
        return instance;
    }

    @Override
    public Currency create(Currency entity) {
        entity.setId(getCurrentId());
        currencies.add(entity);
        return entity;
    }

    @Override
    public List<Currency> findAll() {
        return new ArrayList<>(currencies);
    }

    @Override
    public Optional<Currency> findById(Long id) {
        return currencies.stream()
                .filter(currency -> currency.getId().equals(id))
                .findFirst();
    }

    public Optional<Currency> findByName(String name) {
        return currencies.stream()
                .filter(currency -> currency.getName().equals(name))
                .findFirst();
    }

    @Override
    public Currency update(Currency entity) {
        Optional<Currency> existingCurrency = findById(entity.getId());

        existingCurrency.ifPresent(currency -> {
            int index = currencies.indexOf(currency);
            currencies.set(index, entity);
        });

        return entity;
    }

    @Override
    public void deleteById(Long id) {
        currencies.removeIf(currency -> currency.getId().equals(id));
    }

    private Long getCurrentId() {
        return currencies.stream()
                .max(Comparator.comparing(Currency::getId))
                .map(currency -> currency.getId() + 1L)
                .orElse(1L);
    }

}
