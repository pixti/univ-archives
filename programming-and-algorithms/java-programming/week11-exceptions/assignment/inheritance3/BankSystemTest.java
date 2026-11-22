import java.util.ArrayList;
import java.util.List;

/**
 * [11강 과제] 상속 (인터페이스, 다중 상속) - 2번 문제 (Bank, Account 인터페이스, SavingsAccount, CurrentAccount)
 *
 * 문제
 *  Bank, Account, SavingsAccount 및 CurrentAccount 의 세 가지 클래스가 있는 은행 시스템을 생성하는 Java 프로그래밍을 작성한다.
 *  Bank 에는 계좌 목록과 계좌 추가 방법이 있어야 한다. Account 는 입금, 출금, 이자를 계산하고 잔액을 확인하는 방법을 갖춘
 *  인터페이스이다. SavingsAccount 와 CurrentAccount 는 Account 인터페이스를 구현해야 하며 고유한 메소드를 가지고 있어야 한다.
 *  main 은 다음과 같다. (아래 main 과 같음)
 *
 *    실행 결과 :
 *    Savings Account:
 *    Initial Deposit: $1000.00
 *    Interest rate: 1.25%
 *
 *    Current Account:
 *    Initial Deposit: $5000.00
 *    OverdraftLimit: $1000.00
 *
 *    Now deposit $100 to Savings Account.
 *    Now deposit $500 to Current Account.
 *    Withdraw $150 from Savings Account.
 *
 *
 *    Savings A/c and Current A/c.:
 *    Account balance: 950.0
 *    Account balance: 5500.0
 *
 *    After applying interest on Savings A/c for 1 year:
 *    Savings A/c and Current A/c.:
 *    Account balance: 961.875
 *    Account balance: 5500.0
 *
 * 포인트
 *  - interface Account : deposit, withdraw, calculateInterest, getBalance
 *  - SavingsAccount (저축 예금) : 이자율(interestRate)이 있다. 고유 메소드 applyInterest() 로 이자를 잔액에 더한다.
 *      calculateInterest() = balance * (interestRate / 100.0)    → 950 * 0.0125 = 11.875 → 961.875
 *    출금은 잔액 안에서만 된다. (잔액이 모자라면 "Insufficient balance.")
 *  - CurrentAccount (당좌 예금) : 마이너스 통장처럼 overdraftLimit 만큼 잔액보다 더 뽑을 수 있다.
 *      balance + overdraftLimit >= amount 이면 출금. 이자는 없다(0.0). 고유 메소드 setOverdraftLimit / getOverdraftLimit
 *  - Bank : List<Account> accounts 에 계좌를 모아 두고, Account 타입으로 입금 · 출금 · 잔액 출력을 한다.
 *      → 계좌 종류가 달라도 Account 인터페이스 하나로 똑같이 다룰 수 있다. (다형성)
 *
 * ⚠ 자주 틀리는 부분 : savingsAccount.applyInterest() 는 Account 인터페이스에 없는 SavingsAccount 의 고유 메소드다.
 *    그래서 main 에서도 SavingsAccount 타입 변수로 부른다. Account 타입 변수(예 : Bank 의 accounts 요소)로는 부를 수 없다.
 *      error: cannot find symbol  symbol: method applyInterest()  location: variable account of type Account
 * ⚠ 문제의 실행 결과는 "OverdraftLimit: $1000.00" 처럼 붙어 있지만 main 의 문자열은 "Overdraft Limit: $1000.00" 이다.
 *    실제 실행 결과는 main 을 따른다.
 * 💡 "Withdraw $150 from Savings Account.\n" 다음 println("\nSavings A/c ...") 때문에 빈 줄이 두 개 생긴다.
 * 💡 이자를 계산할 때 1.25 를 100.0 으로 나눠 0.0125 로 만든다. 100 (int) 으로 나눠도 1.25 가 double 이라 결과는 같지만,
 *    정수끼리의 나눗셈(예 : 1 / 100 = 0)을 피하려고 100.0 으로 쓰는 습관을 들이면 좋다.
 * 💡 List<Account>, ArrayList 는 12강(지네릭과 컬렉션)에서 배운다. 크기가 자동으로 늘어나는 배열이라고 보면 된다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 BankSystemTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Savings Account:
 *  Initial Deposit: $1000.00
 *  Interest rate: 1.25%
 *
 *  Current Account:
 *  Initial Deposit: $5000.00
 *  Overdraft Limit: $1000.00
 *
 *  Now deposit $100 to Savings Account.
 *  Now deposit $500 to Current Account.
 *  Withdraw $150 from Savings Account.
 *
 *
 *  Savings A/c and Current A/c.:
 *  Account balance: 950.0
 *  Account balance: 5500.0
 *
 *  After applying interest on Savings A/c for 1 year:
 *  Savings A/c and Current A/c.:
 *  Account balance: 961.875
 *  Account balance: 5500.0
 */
public class BankSystemTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount savingsAccount = new SavingsAccount(1000.0, 1.25);
        System.out.println("Savings Account:\nInitial Deposit: $1000.00\nInterest rate: 1.25%");

        CurrentAccount currentAccount = new CurrentAccount(5000.0, 1000.0);
        System.out.println("\nCurrent Account:\nInitial Deposit: $5000.00\nOverdraft Limit: $1000.00");

        // Add the SavingsAccount and CurrentAccount to the bank
        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        System.out.println("\nNow deposit $100 to Savings Account.");
        bank.deposit(savingsAccount, 100.0);
        System.out.println("Now deposit $500 to Current Account.");
        bank.deposit(currentAccount, 500.0);

        System.out.println("Withdraw $150 from Savings Account.\n");
        bank.withdraw(savingsAccount, 150.0);
        System.out.println("\nSavings A/c and Current A/c.:");
        bank.printAccountBalances();

        savingsAccount.applyInterest();
        System.out.println("\nAfter applying interest on Savings A/c for 1 year:");
        System.out.println("Savings A/c and Current A/c.:");

        // Print the balances of all accounts in the bank after applying interest
        bank.printAccountBalances();
    }
}

interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double calculateInterest();
    double getBalance();
}

class SavingsAccount implements Account {
    private double balance;
    private double interestRate;

    public SavingsAccount(double initialDeposit, double interestRate) {
        this.balance = initialDeposit;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * (interestRate / 100.0);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void applyInterest() {          // 고유 메소드
        balance += calculateInterest();
    }
}

class CurrentAccount implements Account {
    private double balance;
    private double overdraftLimit;

    public CurrentAccount(double initialDeposit, double overdraftLimit) {
        this.balance = initialDeposit;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }

    @Override
    public double calculateInterest() {
        return 0.0;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void setOverdraftLimit(double overdraftLimit) {   // 고유 메소드
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }

    public void printAccountBalances() {
        for (Account account : accounts) {
            System.out.println("Account balance: " + account.getBalance());
        }
    }
}
