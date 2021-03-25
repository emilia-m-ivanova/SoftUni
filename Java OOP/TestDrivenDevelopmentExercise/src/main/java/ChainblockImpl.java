import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        this.transactions.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        this.transactions.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        this.transactions.remove(id);

    }

    public Transaction getById(int id) {
        if (!this.transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return this.transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> result = this.transactions.values().stream()
                .filter(e -> e.getStatus().equals(status))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> result = this.transactions.values().stream()
                .filter(e -> e.getStatus().equals(status))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> result = this.transactions.values().stream()
                .filter(e -> e.getStatus().equals(status))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .map(Transaction::getTo)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactions.values().stream()
                .sorted(Comparator.comparingInt(Transaction::getId))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());

    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> result = this.transactions.values().stream()
                .filter(e -> e.getFrom().equals(sender))
                .sorted(Comparator.comparingInt(Transaction::getId))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> result = this.transactions.values().stream()
                .filter(e -> e.getTo().equals(receiver))
                .sorted(Comparator.comparingInt(Transaction::getId))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.transactions.values().stream()
                .filter(e -> e.getStatus().equals(status) && e.getAmount() <= amount)
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> result = this.transactions.values().stream()
                .filter(e -> e.getFrom().equals(sender) && e.getAmount() > amount)
                .sorted(Comparator.comparingInt(Transaction::getId))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> result = this.transactions.values().stream()
                .filter(e -> e.getTo().equals(receiver) && e.getAmount() >= lo && hi > e.getAmount())
                .sorted(Comparator.comparingInt(Transaction::getId))
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.transactions.values().stream()
                .filter(e -> lo <= e.getAmount() && e.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return this.transactions.values().iterator();
    }
}
