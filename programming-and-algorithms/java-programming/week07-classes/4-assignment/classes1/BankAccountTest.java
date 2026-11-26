/**
 * [7강 과제] 클래스(1) - 2번 문제 (BankAccount 클래스 - UML 을 보고 클래스 작성)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setBalance(0);
        account.deposit(10000);
        System.out.println("잔액 : " + account.getBalance());
        account.withdraw(8000);
        System.out.println("잔액 : " + account.getBalance());
    }
}

class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }

    public void deposit(int amount) {         // 입금
        this.balance += amount;
    }

    public void withdraw(int amount) {        // 출금
        this.balance -= amount;
    }
}
