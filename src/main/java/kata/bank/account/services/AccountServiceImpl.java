package kata.bank.account.services;

import kata.bank.account.entities.Account;
import kata.bank.account.entities.AccountException;
import kata.bank.account.entities.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class AccountServiceImpl implements AccountService {

    private static AccountServiceImpl INSTANCE;

    // Singleton
    private AccountServiceImpl() {
    }

    public static synchronized AccountServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountServiceImpl();
        }
        return INSTANCE;
    }

    // For tests ------------
    protected static final List<Account> ACCOUNT_LIST = new ArrayList<>();

    static {
        ACCOUNT_LIST.add(new Account(UUID.fromString("21317427-8884-4a05-8ed1-156164b39e7d"), "fooFirstName", "fooLastName"));
        ACCOUNT_LIST.add(new Account(UUID.fromString("ed815008-e910-4355-a56e-55754d843acb"), "barFirstName", "barLastName"));
    }
    // ----------------------

    @Override
    public Account retrieve(UUID accountID) {
        Optional<Account> optionalAccount = ACCOUNT_LIST.stream().filter(account -> accountID.equals(account.getId())).findFirst();
        return optionalAccount.orElseThrow(() -> new AccountException("Account doesn't exist !"));
    }

    @Override
    public int addOperation(UUID accountID, Operation operation) {
        final int newBalance = this.retrieve(accountID).addOperation(operation);
        // update current operation for account statement
        operation.setNewBalance(newBalance);
        operation.setAccountId(accountID);
        return newBalance;
    }

    @Override
    public List<Operation> showHistory(UUID accountID) {
        return this.retrieve(accountID).getOperations();
    }
}
