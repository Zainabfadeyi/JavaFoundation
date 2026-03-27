package src.BankApp.exceptions;


public class InsufficientBalanceException extends BankAppException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}