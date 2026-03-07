package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance); // 부모 생성자 호출
        this.interestRate = interestRate;
    }

    // 이자율 적용 특별 기능
    public void applyInterest() {
        double interest = balance * (interestRate / 100.0);
        balance += interest;
        System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + interestRate + "%";
    }
}