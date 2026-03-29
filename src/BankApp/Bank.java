package src.BankApp;

import src.BankApp.exceptions.AccountAlreadyExistsException;
import src.BankApp.exceptions.BankAccountNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {
    private String bankName;
    private String bankCode;
    private List<Account> accounts;

    public Bank(String bankName, String bankCode) {
        this.bankName  = bankName;
        this.bankCode  = bankCode;
        this.accounts  = new ArrayList<>();
    }

    public void createAccount(String accountName, String pin, String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                throw new AccountAlreadyExistsException("Account number already exists: " + accountNumber);
        }
        accounts.add(new Account(accountName, pin, accountNumber));
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) return account;
        }
        throw new BankAccountNotFoundException("Account not found: " + accountNumber);
    }

    public void deposit(String accountNumber, BigDecimal amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, String pin, BigDecimal amount) {
        getAccount(accountNumber).withdraw(amount, pin);
    }

    public void transfer(String senderAccountNumber, String pin, String receiverAccountNumber, BigDecimal amount) {
        Account sender   = getAccount(senderAccountNumber);
        Account receiver = getAccount(receiverAccountNumber);
        sender.withdraw(amount, pin);
        receiver.depositFromBank(amount);
    }

    public BigDecimal checkBalance(String accountNumber, String pin) {
        Account account = getAccount(accountNumber);
        account.validatePin(pin);
        return account.getBalance();
    }

    public void freezeAccount(String accountNumber) {
        getAccount(accountNumber).freeze();
    }

    public void unfreezeAccount(String accountNumber) {
        getAccount(accountNumber).unfreeze();
    }

    public void changePin(String accountNumber, String oldPin, String newPin) {
        getAccount(accountNumber).changePin(oldPin, newPin);
    }

    public List<String> getTransactionHistory(String accountNumber, String pin) {
        Account account = getAccount(accountNumber);
        account.validatePin(pin);
        return account.getTransactionHistory();
    }

    public int getTotalAccounts() {
        return accounts.size();
    }

    public List<Account> getAccounts()  { return Collections.unmodifiableList(accounts); }
    public String getBankName()          { return bankName; }
    public String getBankCode()          { return bankCode; }
}