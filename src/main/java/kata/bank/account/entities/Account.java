package kata.bank.account.entities;

import com.google.common.util.concurrent.AtomicDouble;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Account {

    private UUID id;
    private String firstName;
    private String lastName;
    private AtomicDouble balance = new AtomicDouble(0);
    // java.util.concurrent
    List<Operation> operations = new CopyOnWriteArrayList<>();

    public Account(String firstName, String lastName) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Account(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Add operation
     *
     * @param operation the operation
     * @return the updated current balance
     */
    public double addOperation(Operation operation) {
        this.operations.add(operation);
        // update balance
        return balance.addAndGet(operation.getAmount());
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AtomicDouble getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
