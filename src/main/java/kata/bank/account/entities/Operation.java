package kata.bank.account.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Operation {

    private UUID id;
    private UUID accountId;
    private int amount;
    private OperationType operationType;
    private LocalDateTime date;
    // new account balance after operation
    private int newBalance;

    public Operation(int amount, OperationType operationType) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.operationType = operationType;
        // New JAVA 8 API java.time....
        this.date = LocalDateTime.now();
    }

    public int getAmount() {
        return amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getNewBalance() {
        return newBalance;
    }

    public UUID getId() {
        return id;
    }

    public void setNewBalance(int newBalance) {
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
