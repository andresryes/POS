package Models;

public class Transaction {
    private int idTransaction;
    private Customer customer;
    private User user;
    private TransactionDetail[] transactions;
    private double total;

    public Transaction(int idTransaction, Customer customer, User user, TransactionDetail[] transactions, double total) {
        this.idTransaction = idTransaction;
        this.customer = customer;
        this.user = user;
        this.transactions = transactions;
        this.total = total;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TransactionDetail[] getTransactions() {
        return transactions;
    }

    public void setTransactions(TransactionDetail[] transactions) {
        this.transactions = transactions;
    }

    public double isTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
