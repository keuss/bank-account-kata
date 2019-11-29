package kata.bank.account.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Operation {

    private UUID id;
    private UUID accountId;
    private double amount;
    private OperationType operationType;
    private LocalDateTime date;
    // new account balance after operation
    private double newBalance;

    public Operation(double amount, OperationType operationType) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.operationType = operationType;
        // New JAVA 8 API java.time....
        this.date = LocalDateTime.now();
    }

    public Operation(UUID id, UUID accountId, double amount, OperationType operationType) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.operationType = operationType;
        // New JAVA 8 API java.time....
        this.date = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public UUID getId() {
        return id;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", operationType=" + operationType +
                ", date=" + date +
                ", newBalance=" + newBalance +
                '}';
    }
}
