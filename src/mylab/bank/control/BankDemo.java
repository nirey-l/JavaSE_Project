package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.Account;
import mylab.bank.entity.SavingsAccount;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        bank.createSavingsAccount("이영희", 30000.0, 2.0);

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();

        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            bank.deposit("AC1000", 5000.0);
            bank.withdraw("AC1001", 3000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            bank.deposit("AC1000", 450.0);
            Account acc = bank.findAccount("AC1000");
            // 객체가 SavingsAccount 타입인지 확인 후 형변환하여 메서드 호출
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();

        // 고의로 발생시키는 에러 테스트
        try {
            bank.withdraw("AC1001", 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw("AC1001", 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw("AC9999", 1000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}