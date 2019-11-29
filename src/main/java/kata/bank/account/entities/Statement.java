package kata.bank.account.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Statement {

    //TODO

    private UUID id;
    private UUID accountId;
    private LocalDateTime[] interval;
    private List<Operation> operations;

    public Statement(UUID id, UUID accountId, LocalDateTime[] interval, List<Operation> operations) {
        this.id = id;
        this.accountId = accountId;
        this.interval = interval;
        this.operations = operations;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public LocalDateTime[] getInterval() {
        return interval;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
