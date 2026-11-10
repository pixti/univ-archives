/**
 * [7강 과제] 클래스(1) - 2번 문제 (BankAccount 클래스 - UML 을 보고 클래스 작성)
 *
 * 문제
 *  아래 UML 클래스 다이어그램대로 BankAccount 클래스를 작성하고, 입금 후 출금한 잔액을 출력하시오.
 *
 *      ┌──────────────────────────────┐
 *      │          BankAccount         │
 *      ├──────────────────────────────┤
 *      │ - accountNumber              │
 *      │ - owner                      │
 *      │ - balance                    │
 *      ├──────────────────────────────┤
 *      │ + getter / setter            │
 *      │ + deposit()                  │
 *      │ + withdraw()                 │
 *      └──────────────────────────────┘
 *
 * 포인트
 *  - UML 기호 : -  는 private,  + 는 public
 *  - deposit(입금) 은 잔액에 더하고, withdraw(출금) 는 잔액에서 뺀다.
 *        this.balance += amount;   →   this.balance = this.balance + amount;
 *  - 잔액(balance)을 직접 바꾸지 못하게 private 으로 두고, deposit / withdraw 메서드로만 바꾸게 한다. (캡슐화)
 *
 * ⚠ 문제의 출력 코드는 System.out.print(“잔액 : ” + ...) 처럼 둥근 따옴표(“ ”)로 되어 있다.
 *    자바 문자열은 반드시 곧은 따옴표(" ")를 써야 한다. 또 print 는 줄바꿈이 없어서 두 결과가 한 줄에 붙는다.
 *        ❌ 원본 : System.out.print(“잔액 : ” + account.getBalance());
 *        ✅ 수정 : System.out.println("잔액 : " + account.getBalance());   ← 내 코드는 println 사용
 *
 * 💡 지금은 잔액보다 많이 출금해도 음수가 된다. 실제라면 withdraw 에서 검사하는 것이 좋다.
 *        if (amount > balance) { System.out.println("잔액이 부족합니다."); return; }
 *
 * 실행 결과
 *  잔액 : 10000
 *  잔액 : 2000
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
