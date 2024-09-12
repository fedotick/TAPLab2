package org.example;

import org.example.config.DataInitializer;
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

public class Application {

    private static final CurrencyService currencyService = new CurrencyService();
    private static final DepositService depositService = new DepositService();
    private static final DurationService durationService = new DurationService();
    private static final TypeService typeService = new TypeService();

    public static void run() {
        DataInitializer.initialize();

        changeDuration();
        findByType();
        closeDepositAndOpenNewInDifferentCurrency();
        calculateInterestAccrual();
    }

    private static void changeDuration() {
        List<Deposit> deposits = depositService.findAll();
        Deposit deposit = RandomElementSelector.getRandomElement(deposits);
        System.out.println(deposit);

        List<Duration> durations = durationService.findAll();
        Duration duration;
        do {
            duration = RandomElementSelector.getRandomElement(durations);
        } while (deposit.getDuration().equals(duration));

        deposit.setDuration(duration);
        Deposit updatedDeposit = depositService.update(deposit);
        System.out.println(updatedDeposit);
    }

    private static void findByType() {
        List<Type> types = typeService.findAll();
        Type type = RandomElementSelector.getRandomElement(types);

        List<Deposit> deposits = depositService.findAllByType(type);
        System.out.println(deposits);
    }

    private static void closeDepositAndOpenNewInDifferentCurrency() {
        List<Deposit> deposits = depositService.findAll();
        Deposit deposit = RandomElementSelector.getRandomElement(deposits);
        System.out.println("id: " + deposit.getId() + " | " + deposit);

        List<Currency> currencies = currencyService.findAll();
        Currency currency;
        do {
            currency = RandomElementSelector.getRandomElement(currencies);
        } while (deposit.getCurrency().equals(currency));

        Deposit newDeposit = depositService.closeDepositAndOpenNewInDifferentCurrency(deposit, currency);
        System.out.println("id: " + newDeposit.getId() + " | " + newDeposit);
    }

    private static void calculateInterestAccrual() {
        List<Deposit> deposits = depositService.findAll();
        Deposit deposit = RandomElementSelector.getRandomElement(deposits);

        Double interestAccrual = depositService.calculateInterestAccrual(deposit);
        System.out.println(deposit);
        System.out.println(interestAccrual);
    }

}
