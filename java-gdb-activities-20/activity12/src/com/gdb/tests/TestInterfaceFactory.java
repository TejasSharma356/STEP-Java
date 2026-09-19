package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestInterfaceFactory {
    public static void main(String[] args) {
        System.out.println("=== Activity 12: Factory-Driven System Suite ===");

        // NOTE: If you completed Activity 11 successfully, paste your working IAccount.java and AccountFactory.java into src/com/gdb/domain (replacing the provided versions).

        // TODO: Step 1 - Instantiate Savings, Current, and FixedDeposit accounts exclusively through AccountFactory.createAccount()
        IAccount savings = AccountFactory.createAccount("SAVINGS", "SAV1001", "Rajesh Sharma", 28, 5000.0, "ACTIVE", "1234");
        IAccount current = AccountFactory.createAccount("CURRENT", "CUR1001", "Priya Patel", 34, 10000.0, "ACTIVE", "5678");
        IAccount fd = AccountFactory.createAccount("FIXED_DEPOSIT", "FD1001", "Amit Kumar", 45, 50000.0, "ACTIVE", "1111");

        // TODO: Step 2 - Perform deposits and withdrawals through the IAccount interface references
        try {
            savings.deposit(2000.0);
            System.out.println("[Test 1] Savings Account Creation & Deposit: [PASS]");
        } catch (InvalidAmountException e) {
        }

        // TODO: Step 3 - Verify Savings minimum balance rule enforcement through the interface
        try {
            savings.withdraw(10000.0, "1234");
        } catch (AccountException e) {
        }

        // TODO: Step 4 - Verify Current overdraft limit enforcement through the interface
        try {
            current.withdraw(15000.0, "5678");
            System.out.println("[Test 2] Current Account Overdraft Withdrawal: [PASS]");
        } catch (AccountException e) {
        }

        // TODO: Step 5 - Verify FixedDeposit premature withdrawal rejection through the interface
        try {
            fd.withdraw(5000.0, "1111");
        } catch (AccountException e) {
            System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [PASS]");
        }

        // TODO: Step 6 - Verify requesting an invalid account type from AccountFactory throws IllegalArgumentException
        try {
            AccountFactory.createAccount("INVALID_TYPE", "INV1001", "Test", 30, 1000.0, "ACTIVE", "0000");
        } catch (IllegalArgumentException e) {
            System.out.println("[Test 4] Invalid Type Rejection: [PASS]");
        }

        System.out.println("Factory-driven architecture successfully verified!");
    }
}
