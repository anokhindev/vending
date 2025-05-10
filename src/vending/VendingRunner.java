package vending;

import equiring.Equiring;
import person.Person;
import transaction.Transaction;
import transaction.TransactionLog;
import transaction.VendingTransactionProcessor;

import java.util.Scanner;

public class VendingRunner {
    private final VendingShop shop;
    private final Equiring equiring;
    private final VendingTransactionProcessor processor;
    private final TransactionLog log;

    public VendingRunner(VendingShop shop) {
        this.shop = shop;
        this.equiring = new Equiring(shop);
        this.processor = new VendingTransactionProcessor(shop);
        this.log = new TransactionLog();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        // мне кажется покупатель дожен хранится не здесь, а где-то в эквайринге
        Person person = new Person("Покупатель Измаил", 220);

        while (true) {
            System.out.println("\n=== Вендинговый автомат ===");
            for (VendingSlot slot : shop.getSlotList()) {
                System.out.println(slot.getSlotStatus());
            }

            System.out.print("\nВведите номер слота (или 'exit' для выхода или log для вывода лога): ");
            String slotId = scanner.nextLine().trim();

            if (slotId.equalsIgnoreCase("exit")) {
                System.out.println("Выход из автомата. До свидания!");
                break;
            }

            if (slotId.equalsIgnoreCase("log")) {
                log.printAll();
                continue;
            }


            if (!equiring.isSlotValid(slotId)) {
                System.out.println("❌ Неверный код слота.");
                continue;
            }

            if (!equiring.isProductAvailable(slotId)) {
                System.out.println("❌ Товар отсутствует.");
                continue;
            }

            double price = equiring.getRequiredAmount(slotId);
            System.out.printf("Внесите %.2f рублей: ", price);

            String moneyInput = scanner.nextLine().trim();
            double insertedMoney;

            try {
                insertedMoney = Double.parseDouble(moneyInput);
            } catch (NumberFormatException e) {
                System.out.println("❌ Некорректная сумма. Повторите попытку.");
                continue;
            }

            //не уверен, что валидация на деньги должна быть здесь
            if (!equiring.personCanProvide(person, insertedMoney)) {
                System.out.println("❌ У вас нет такой суммы.");
                continue;
            }

            Transaction transaction = processor.process(person, slotId, insertedMoney);
            log.add(transaction);

            System.out.printf("✅ Ваш товар — %s. Сдача: %.2f рублей. Ваш баланс %.2f рублей\n", transaction.getProduct().getName(), transaction.getChange(), person.getBalance());
        }

        scanner.close();
    }
}
