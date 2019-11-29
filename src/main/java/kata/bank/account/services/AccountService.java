package kata.bank.account.services;

import kata.bank.account.entities.Account;
import kata.bank.account.entities.Operation;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    /**
     * retrieve account
     *
     * @param accountID the account id to retrieve
     * @return the account object
     */
    Account retrieve(UUID accountID);

    /**
     * addOperation on account
     *
     * @param accountID accountID
     * @param operation the operation to add
     * @return
     */
    int addOperation(UUID accountID, Operation operation);

    /**
     * showHistory
     *
     * @param accountID accountID
     * @return all operations
     */
    List<Operation> showHistory(UUID accountID);
}
