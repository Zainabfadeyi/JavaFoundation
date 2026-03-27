package src.BankApp.exceptions;

public class InvalidAmountException extends BankAppException {
    public InvalidAmountException(String message) {
        super(message);
    }
}