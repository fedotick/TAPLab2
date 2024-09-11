package org.example;

import org.example.controller.DepositController;
import org.example.model.Deposit;
import org.example.repository.DepositRepository;
import org.example.service.DepositService;

public class Application {

    public static void run() {
        DepositService depositService = new DepositService();
        DepositController controller = new DepositController(depositService);
        DepositRepository repository = DepositRepository.getInstance();

        repository.save(new Deposit("краткосрочный", "отзывной", 1000, 5, 1, "USD"));
        repository.save(new Deposit("долгосрочный", "безотзывной", 5000, 3, 5, "EUR"));

        controller.changeDuration(1L, "бессрочный");
        controller.calculateInterest(1L);
        controller.openNewDepositWithCurrency(1L, "RUB");
    }

}
