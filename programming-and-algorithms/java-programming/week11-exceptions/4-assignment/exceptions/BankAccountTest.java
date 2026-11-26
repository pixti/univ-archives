/**
 * [11강 과제] 예외 처리 - 2번 문제 (BankAccount : 잔액보다 많이 인출하면 NegativeBalance)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount myAcount = new BankAccount(1000000);

        System.out.println("myAccount 계좌가 생성 되었습니다.");
        try {
            myAcount.deposit(20000);
            myAcount.display();
            myAcount.withdraw(1020001);
            myAcount.display();
        } catch (NegativeBalance e) {
            e.printStackTrace();
        }
    }
}

class NegativeBalance extends Exception {
    public NegativeBalance() {
        super("잔액 부족");
    }

    public NegativeBalance(String message) {
        super(message);
    }
}

class BankAccount {
    private int balance;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) throws NegativeBalance {
        System.out.println(amount + "원 인출 시도 ...");
        if (amount > balance) {
            throw new NegativeBalance("잔액 부족");
        }
        balance -= amount;
    }

    public void display() {
        System.out.println("현재 잔액은 : " + balance);
    }
}
