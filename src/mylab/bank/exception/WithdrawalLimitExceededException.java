package mylab.bank.exception;

// 잔액 부족 에러를 상속받아 더 구체적인 '한도 초과' 에러를 만듭니다.
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}