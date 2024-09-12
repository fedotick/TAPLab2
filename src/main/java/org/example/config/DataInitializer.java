package org.example.config;

import org.example.model.Currency;
import org.example.model.Deposit;
import org.example.model.Duration;
import org.example.model.Type;
import org.example.service.CurrencyService;
import org.example.service.DepositService;
import org.example.service.DurationService;
import org.example.service.TypeService;
import org.example.util.RandomElementSelector;

import java.util.List;

public class DataInitializer {

    private static final CurrencyService currencyService = new CurrencyService();
    private static final DepositService depositService = new DepositService();
    private static final DurationService durationService = new DurationService();
    private static final TypeService typeService = new TypeService();

    public static void initialize() {
        initializeDeposit();
    }

    private static void initializeDeposit() {
        initializeCurrency();
        initializeDuration();
        initializeType();

        List<Deposit> deposits = getSampleDepositData();
        depositService.create(deposits);
    }

    private static List<Deposit> getSampleDepositData() {
        return List.of(
                new Deposit(
                        RandomElementSelector.getRandomElement(durationService.findAll()),
                        RandomElementSelector.getRandomElement(typeService.findAll()),
                        10000,
                        2,
                        3,
                        RandomElementSelector.getRandomElement(currencyService.findAll())
                ),
                new Deposit(
                        RandomElementSelector.getRandomElement(durationService.findAll()),
                        RandomElementSelector.getRandomElement(typeService.findAll()),
                        20000,
                        5,
                        1,
                        RandomElementSelector.getRandomElement(currencyService.findAll())
                ),
                new Deposit(
                        RandomElementSelector.getRandomElement(durationService.findAll()),
                        RandomElementSelector.getRandomElement(typeService.findAll()),
                        15000,
                        3,
                        5,
                        RandomElementSelector.getRandomElement(currencyService.findAll())
                )
        );
    }

    private static void initializeCurrency() {
        List<Currency> currencies = getSampleCurrencyData();
        currencyService.create(currencies);
    }

    private static List<Currency> getSampleCurrencyData() {
        return List.of(
                new Currency("MDL"),
                new Currency("EUR"),
                new Currency("USD")
        );
    }

    private static void initializeDuration() {
        List<Duration> durations = getSampleDurationData();
        durationService.create(durations);
    }

    private static List<Duration> getSampleDurationData() {
        return List.of(
                new Duration("Demand"),
                new Duration("Long-term"),
                new Duration("Short-term")
        );
    }

    private static void initializeType() {
        List<Type> types = getSampleTypeData();
        typeService.create(types);
    }

    private static List<Type> getSampleTypeData() {
        return List.of(
                new Type("Revocable"),
                new Type("Irrevocable")
        );
    }

}
