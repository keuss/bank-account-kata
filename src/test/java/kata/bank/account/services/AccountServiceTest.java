package kata.bank.account.services;

import kata.bank.account.entities.AccountException;
import kata.bank.account.entities.Operation;
import kata.bank.account.entities.OperationType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountServiceTest {

    private static final AccountServiceImpl accountService = AccountServiceImpl.getInstance();
    private static final UUID accountId = UUID.fromString("21317427-8884-4a05-8ed1-156164b39e7d");

    @BeforeAll
    public static void init() {
        System.out.println("BeforeAll init() method called");
        AccountServiceImpl.ACCOUNT_LIST.stream().forEach(System.out::println);
    }

    @Test
    void testRetrieve() {
        assertEquals(accountId, accountService.retrieve(accountId).getId());
    }

    @Test
    void testAddOperations() {
        int newBalance1 = accountService.addOperation(accountId, new Operation(100, OperationType.DEPOSIT));
        assertEquals(100, newBalance1);
        int newBalance2 = accountService.addOperation(accountId, new Operation(-100, OperationType.WITHDRAWAL));
        assertEquals(0, newBalance2);
        int newBalance3 = accountService.addOperation(accountId, new Operation(50, OperationType.DEPOSIT));
        assertEquals(50, newBalance3);
        final List<Operation> operations = accountService.showHistory(accountId);
        operations.stream().forEach(System.out::println);
        assertEquals(3, operations.size());
    }

    @Test
    void testAddOperation_KO() {
        assertThrows(AccountException.class, () -> accountService.addOperation(UUID.fromString("21317427-8884-4a05-8ed1-156164b39e5b"),
                new Operation(100, OperationType.DEPOSIT)));
    }

}
