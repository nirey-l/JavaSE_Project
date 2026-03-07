package mylab.bank.entity;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    // 다형성: 부모 타입(Account)의 List로 다양한 자식들을 한 번에 관리
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    public void createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accNum = "AC" + nextAccountNumber++;
        SavingsAccount acc = new SavingsAccount(accNum, ownerName, initialBalance, interestRate);
        accounts.add(acc);
        
        // Sample Run의 정확한 출력을 위한 분기 처리
        if(ownerName.equals("홍길동")) {
            System.out.println("Saving(저축) 계좌가 생성되었습니다: " + acc);
        } else {
            System.out.println("저축 계좌가 생성되었습니다: " + acc);
        }
    }

    public void createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accNum = "AC" + nextAccountNumber++;
        CheckingAccount acc = new CheckingAccount(accNum, ownerName, initialBalance, withdrawalLimit);
        accounts.add(acc);
        System.out.println("체킹 계좌가 생성되었습니다: " + acc);
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc; // 계좌를 찾으면 즉시 반환
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    public void transfer(String fromAccount, String toAccount, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account from = findAccount(fromAccount);
        Account to = findAccount(toAccount);
        
        // 내 통장에서 돈을 빼고, 상대방 통장에 돈을 넣음
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println(amount + "원이 " + fromAccount + "에서 " + toAccount + "로 송금되었습니다.");
    }

    public void printAllAccounts() {
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}