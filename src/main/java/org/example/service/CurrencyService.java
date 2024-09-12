package org.example.service;

import org.example.model.Currency;
import org.example.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

public class CurrencyService implements IService<Currency, Long> {

    private final CurrencyRepository currencyRepository;

    public CurrencyService() {
        this.currencyRepository = CurrencyRepository.getInstance();
    }

    @Override
    public Currency create(Currency currency) {
        return currencyRepository.create(currency);
    }

    public List<Currency> create(List<Currency> currencies) {
        return currencies.stream()
                .map(this::create)
                .toList();
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Optional<Currency> findById(Long id) {
        return currencyRepository.findById(id);
    }

    public Optional<Currency> findByName(String name) {
        return currencyRepository.findByName(name);
    }

    @Override
    public Currency update(Currency currency) {
        return currencyRepository.update(currency);
    }

    @Override
    public void deleteById(Long id) {
        currencyRepository.deleteById(id);
    }

}
