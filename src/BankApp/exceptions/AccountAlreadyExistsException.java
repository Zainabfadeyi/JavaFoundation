package src.BankApp.exceptions;

public class AccountAlreadyExistsException extends  BankAppException {
    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}