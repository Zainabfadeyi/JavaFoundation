package test;

import org.junit.Before;
import org.junit.Test;
import src.BankApp.Account;
import src.BankApp.Bank;
import src.BankApp.exceptions.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BankTest {

    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank("Semicolon Bank", "SCB001");
        bank.createAccount("Chukwuma Eze",    "1234", "SCB001");
        bank.createAccount("Emeka Okafor",    "5678", "SCB002");
        bank.createAccount("Amaka Nwosu",     "9999", "SCB003");
    }



    @Test
    public void testBankNameIsSetCorrectly() {
        assertEquals("Semicolon Bank", bank.getBankName());
    }

    @Test
    public void testBankCodeIsSetCorrectly() {
        assertEquals("SCB001", bank.getBankCode());
    }

    @Test
    public void testBankStartsWithCorrectNumberOfAccounts() {
        assertEquals(3, bank.getTotalAccounts());
    }



    @Test
    public void testCreateAccountIncreasesAccountCount() {
        bank.createAccount("Tunde Bello", "1111", "SCB004");
        assertEquals(4, bank.getTotalAccounts());
    }

    @Test
    public void testCreatedAccountHasZeroBalance() {
        Account account = bank.getAccount("SCB001");
        assertEquals(BigDecimal.ZERO, account.getBalance());
    }

    @Test
    public void testCreatedAccountNameIsCorrect() {
        Account account = bank.getAccount("SCB001");
        assertEquals("Chukwuma Eze", account.getAccountName());
    }

    @Test(expected = AccountAlreadyExistsException.class)
    public void testCreateAccountWithDuplicateNumberThrowsException() {
        bank.createAccount("Duplicate User", "0000", "SCB001");
    }



    @Test
    public void testGetAccountReturnsCorrectAccount() {
        Account account = bank.getAccount("SCB002");
        assertEquals("Emeka Okafor", account.getAccountName());
    }

    @Test(expected = BankAccountNotFoundException.class)
    public void testGetAccountWithInvalidNumberThrowsException() {
        bank.getAccount("INVALID999");
    }



    @Test
    public void testDepositIncreasesBalance() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        assertEquals(new BigDecimal("5000"), bank.getAccount("SCB001").getBalance());
    }

    @Test
    public void testMultipleDepositsAccumulate() {
        bank.deposit("SCB001", new BigDecimal("3000"));
        bank.deposit("SCB001", new BigDecimal("2000"));
        assertEquals(new BigDecimal("5000"), bank.getAccount("SCB001").getBalance());
    }

    @Test(expected = InvalidAmountException.class)
    public void testDepositZeroThrowsException() {
        bank.deposit("SCB001", BigDecimal.ZERO);
    }

    @Test(expected = InvalidAmountException.class)
    public void testDepositNegativeAmountThrowsException() {
        bank.deposit("SCB001", new BigDecimal("-500"));
    }



    @Test
    public void testWithdrawReducesBalance() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.withdraw("SCB001", "1234", new BigDecimal("2000"));
        assertEquals(new BigDecimal("3000"), bank.getAccount("SCB001").getBalance());
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdrawMoreThanBalanceThrowsException() {
        bank.deposit("SCB001", new BigDecimal("1000"));
        bank.withdraw("SCB001", "1234", new BigDecimal("2000"));
    }

    @Test(expected = InvalidPinException.class)
    public void testWithdrawWithWrongPinThrowsException() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.withdraw("SCB001", "0000", new BigDecimal("1000"));
    }

    @Test(expected = InvalidAmountException.class)
    public void testWithdrawZeroThrowsException() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.withdraw("SCB001", "1234", BigDecimal.ZERO);
    }

    @Test(expected = InvalidAmountException.class)
    public void testWithdrawNegativeAmountThrowsException() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.withdraw("SCB001", "1234", new BigDecimal("-500"));
    }



    @Test
    public void testTransferReducesSenderBalance() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.transfer("SCB001", "1234", "SCB002", new BigDecimal("2000"));
        assertEquals(new BigDecimal("3000"), bank.getAccount("SCB001").getBalance());
    }

    @Test
    public void testTransferIncreasesReceiverBalance() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.transfer("SCB001", "1234", "SCB002", new BigDecimal("2000"));
        assertEquals(new BigDecimal("2000"), bank.getAccount("SCB002").getBalance());
    }

    @Test
    public void testTransferFullAmount() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.transfer("SCB001", "1234", "SCB002", new BigDecimal("5000"));
        assertEquals(BigDecimal.ZERO, bank.getAccount("SCB001").getBalance());
        assertEquals(new BigDecimal("5000"), bank.getAccount("SCB002").getBalance());
    }

    @Test(expected = InsufficientFundsException.class)
    public void testTransferMoreThanBalanceThrowsException() {
        bank.deposit("SCB001", new BigDecimal("1000"));
        bank.transfer("SCB001", "1234", "SCB002", new BigDecimal("5000"));
    }

    @Test(expected = InvalidPinException.class)
    public void testTransferWithWrongPinThrowsException() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.transfer("SCB001", "0000", "SCB002", new BigDecimal("1000"));
    }

    @Test(expected = BankAccountNotFoundException.class)
    public void testTransferToInvalidAccountThrowsException() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.transfer("SCB001", "1234", "INVALID999", new BigDecimal("1000"));
    }



    @Test
    public void testCheckBalanceReturnsCorrectBalance() {
        bank.deposit("SCB001", new BigDecimal("7500"));
        assertEquals(new BigDecimal("7500"), bank.checkBalance("SCB001", "1234"));
    }

    @Test(expected = InvalidPinException.class)
    public void testCheckBalanceWithWrongPinThrowsException() {
        bank.checkBalance("SCB001", "0000");
    }



    @Test
    public void testFreezeAccountPreventsDeposit() {
        bank.freezeAccount("SCB001");
        try {
            bank.deposit("SCB001", new BigDecimal("1000"));
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertEquals("Account is frozen", e.getMessage());
        }
    }

    @Test
    public void testFreezeAccountPreventsWithdrawal() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.freezeAccount("SCB001");
        try {
            bank.withdraw("SCB001", "1234", new BigDecimal("1000"));
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertEquals("Account is frozen", e.getMessage());
        }
    }

    @Test
    public void testUnfreezeAccountAllowsDeposit() {
        bank.freezeAccount("SCB001");
        bank.unfreezeAccount("SCB001");
        bank.deposit("SCB001", new BigDecimal("1000"));
        assertEquals(new BigDecimal("1000"), bank.getAccount("SCB001").getBalance());
    }

    @Test
    public void testFreezeStatusIsCorrect() {
        bank.freezeAccount("SCB001");
        assertTrue(bank.getAccount("SCB001").isFrozen());
    }

    @Test
    public void testUnfreezeStatusIsCorrect() {
        bank.freezeAccount("SCB001");
        bank.unfreezeAccount("SCB001");
        assertFalse(bank.getAccount("SCB001").isFrozen());
    }



    @Test
    public void testChangePinAllowsNewPinToBeUsed() {
        bank.changePin("SCB001", "1234", "4321");
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.withdraw("SCB001", "4321", new BigDecimal("1000"));
        assertEquals(new BigDecimal("4000"), bank.getAccount("SCB001").getBalance());
    }

    @Test(expected = InvalidPinException.class)
    public void testChangePinWithWrongOldPinThrowsException() {
        bank.changePin("SCB001", "0000", "4321");
    }

    @Test(expected = InvalidPinException.class)
    public void testChangePinWithOldPinAfterChangeThrowsException() {
        bank.changePin("SCB001", "1234", "4321");
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.withdraw("SCB001", "1234", new BigDecimal("1000"));
    }



    @Test
    public void testTransactionHistoryRecordsDeposit() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        List<String> history = bank.getTransactionHistory("SCB001", "1234");
        assertFalse(history.isEmpty());
        assertTrue(history.get(0).contains("DEPOSIT"));
    }

    @Test
    public void testTransactionHistoryRecordsWithdrawal() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.withdraw("SCB001", "1234", new BigDecimal("1000"));
        List<String> history = bank.getTransactionHistory("SCB001", "1234");
        assertEquals(2, history.size());
        assertTrue(history.get(1).contains("WITHDRAWAL"));
    }

    @Test
    public void testTransactionHistoryRecordsTransferOut() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.transfer("SCB001", "1234", "SCB002", new BigDecimal("2000"));
        List<String> history = bank.getTransactionHistory("SCB001", "1234");
        assertTrue(history.get(1).contains("WITHDRAWAL"));
    }

    @Test
    public void testTransactionHistoryRecordsTransferIn() {
        bank.deposit("SCB001", new BigDecimal("5000"));
        bank.transfer("SCB001", "1234", "SCB002", new BigDecimal("2000"));
        List<String> history = bank.getTransactionHistory("SCB002", "5678");
        assertTrue(history.get(0).contains("TRANSFER IN"));
    }

    @Test(expected = InvalidPinException.class)
    public void testGetTransactionHistoryWithWrongPinThrowsException() {
        bank.getTransactionHistory("SCB001", "0000");
    }
}