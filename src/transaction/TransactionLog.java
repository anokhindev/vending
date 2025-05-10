package transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionLog {
    private final List<Transaction> transactions = new ArrayList<>();

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAll() {
        return transactions;
    }

    public void printAll() {
        System.out.println("=== История покупок автоматта ===");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}