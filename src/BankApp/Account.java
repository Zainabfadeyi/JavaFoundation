package src.BankApp;

import src.BankApp.exceptions.InsufficientFundsException;
import src.BankApp.exceptions.InvalidAmountException;
import src.BankApp.exceptions.InvalidPinException;

import java.math.BigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Account {
    private String accountName;
    private String accountNumber;
    private String pin;
    private BigDecimal balance;
    private boolean frozen;
    private List<String> transactionHistory;

    public Account(String accountName, String pin, String accountNumber) {
        this.accountName      = accountName;
        this.pin              = pin;
        this.accountNumber    = accountNumber;
        this.balance          = BigDecimal.ZERO;
        this.frozen           = false;
        this.transactionHistory = new ArrayList<>();
    }

    public void validatePin(String pin) {
        if (!this.pin.equals(pin)) throw new InvalidPinException("Invalid PIN");
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAmountException("Deposit amount must be greater than zero");
        if (frozen) throw new IllegalStateException("Account is frozen");
        balance = balance.add(amount);
        transactionHistory.add("DEPOSIT: +" + amount + " | Balance: " + balance);
    }

    public void depositFromBank(BigDecimal amount) {
        if (frozen) throw new IllegalStateException("Account is frozen");
        balance = balance.add(amount);
        transactionHistory.add("TRANSFER IN: +" + amount + " | Balance: " + balance);
    }

    public void withdraw(BigDecimal amount, String pin) {
        validatePin(pin);
        if (frozen) throw new IllegalStateException("Account is frozen");
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAmountException("Withdrawal amount must be greater than zero");
        if (balance.compareTo(amount) < 0)
            throw new InsufficientFundsException("Insufficient funds");
        balance = balance.subtract(amount);
        transactionHistory.add("WITHDRAWAL: -" + amount + " | Balance: " + balance);
    }

    public void changePin(String oldPin, String newPin) {
        validatePin(oldPin);
        if (newPin == null || newPin.length() < 4)
            throw new InvalidPinException("New PIN must be at least 4 digits");
        this.pin = newPin;
    }

    public void freeze() {
        this.frozen = true;
    }

    public void unfreeze() {
        this.frozen = false;
    }

    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }

    public String getAccountName()   { return accountName;   }
    public String getAccountNumber() { return accountNumber; }
    public BigDecimal getBalance()   { return balance;       }
    public boolean isFrozen()        { return frozen;        }
}