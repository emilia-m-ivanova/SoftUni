public class TransactionImpl implements Comparable<TransactionImpl>, Transaction {

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int compareTo(TransactionImpl o) {
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        Class<?> clazz = other.getClass();
        if(clazz!=TransactionImpl.class){
            return false;
        }
        Transaction that = (Transaction) other;
        return this.getId() == that.getId() && this.getStatus().equals(that.getStatus()) &&
                this.getFrom().equals(that.getFrom()) && this.getTo().equals(that.getTo()) &&
                this.getAmount() == that.getAmount();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public TransactionStatus getStatus() {
        return this.status;
    }

    @Override
    public String getFrom() {
        return this.from;
    }

    @Override
    public String getTo() {
        return this.to;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public void setStatus(TransactionStatus newStatus){
        this.status = newStatus;
    }
}
