/**
 * [10강 실습] 상속 - 3번 문제 (BankAccount / SavingsAccount : withdraw 재정의)
 *
 * 문제
 *  deposit() 과 withdraw() 라는 메서드를 사용하여 "BankAccount" 라는 클래스를 정의하라.
 *  계좌 잔액이 100 미만으로 떨어지는 경우 인출을 방지하기 위해 withdraw() 메서드를 재정의하는
 *  SavingsAccount 라는 하위 클래스도 정의하라.
 *  (main 은 문제에 주어진 코드 그대로 아래에 있다)
 *
 * 📝 필기 : ① BankAccount 클래스 설계하기 (부모 클래스)
 *  1. 변수(필드)와 생성자 찾기
 *     - Main 코드를 보면 new BankAccount("BA1234", 500); 이라고 객체를 생성한다.
 *     - 첫 번째 값은 문자열("BA1234")이므로 String accountNumber, 두 번째 값은 숫자(500)인데 출력 결과를 보면
 *       $1500.0, $900.0 처럼 소수점이 찍혀 나온다. 따라서 잔액 변수는 실수형인 double balance 로 선언해야 한다.
 *  2. deposit() 과 withdraw() 메소드 만들기
 *     - BA1234.deposit(1000); : 입금 기능이다. 반환값 없이(void) 전달받은 금액을 기존 balance 에 더해 준다. (balance += amount;)
 *     - BA1234.withdraw(600); : 출금 기능이다. 전달받은 금액을 기존 balance 에서 빼 준다. (balance -= amount;)
 *  3. 숨겨진 메소드 getBalance() 찾기
 *     - 문제 설명에는 없지만 Main 클래스의 출력문을 보면 BA1234.getBalance() 를 호출하여 잔액을 확인하고 있다.
 *     - 따라서 현재 잔액(balance)을 반환하는 public double getBalance() 메소드를 반드시 만들어야 에러가 나지 않는다.
 * 📝 필기 : ② SavingsAccount 클래스 설계하기 (자식 클래스)
 *  1. 상속과 생성자 연결 (super)
 *     - class SavingsAccount extends BankAccount 로 상속을 받는다.
 *     - 자식 클래스가 생성될 때 받은 "SA1234" 와 450 이라는 값을 부모 클래스에 있는 변수에 저장해야 한다.
 *       이때 super(accountNumber, balance); 를 사용하면 부모 클래스(BankAccount)의 생성자를 호출하여
 *       깔끔하게 값을 전달할 수 있다.
 *  2. withdraw() 메소드 재정의(오버라이딩)하기
 *     - 문제 조건 : "계좌 잔액이 100 미만으로 떨어지는 경우 인출을 방지하라."
 *     - 숨겨진 출력문 찾기 : 첫 번째 이미지의 맨 아래 출력 결과를 보면, SA1000 계좌(잔액 300)에서 250 을 인출하려고 할 때
 *       Minimum balance of $100 required! 라는 문구가 출력되지만, Main 클래스에는 이 문구를 출력하는 코드가 없다.
 *       즉, 이 문구는 재정의된 withdraw() 메소드 안에서 출력되어야 한다!
 *     - 조건식 작성
 *       · 현재 잔액 - 출금할 금액 < 100 인 경우 (예 : 300 - 250 = 50 < 100) : 출금을 하지 않고 경고 메시지만 출력한다.
 *       · 그렇지 않고 100 이상이 남는 경우 (예 : 450 - 300 = 150 >= 100) : 정상적으로 돈을 빼야 하므로,
 *         부모 클래스에 이미 만들어 둔 출금 기능을 그대로 가져다 쓴다. 이때 super.withdraw(amount); 를 호출하면 된다.
 * 📝 필기 : 3. 핵심 문법 정리 - super 의 두 가지 역할
 *  1. super(매개변수); → 부모 클래스의 생성자를 호출한다. 부모 클래스가 가진 변수(accountNumber, balance)를 초기화할 때 사용한다.
 *  2. super.메소드이름(); → 부모 클래스의 메소드를 호출한다. 자식 클래스에서 메소드를 재정의(오버라이딩)했더라도,
 *     특정 조건에서는 부모의 원래 기능을 그대로 쓰고 싶을 때 super.withdraw(amount); 처럼 사용한다.
 *
 * ⚠ 자주 틀리는 부분 : balance 는 BankAccount 의 private 필드라서 SavingsAccount 에서 balance 로 직접 쓸 수 없다.
 *    그래서 getBalance() 로 읽고, 실제 출금은 super.withdraw(amount) 에게 맡긴다.
 *    (balance -= amount; 라고 쓰면 error: balance has private access in BankAccount)
 * 💡 문제 문장의 "deposi()" 는 deposit() 의 오타다. main 에서 deposit(1000) 으로 부른다.
 * 💡 이클립스는 accountNumber 필드에 "값을 쓰기만 하고 읽지 않는다" 는 노란 경고(The value of the field is not used)를 표시한다.
 *    getAccountNumber() 같은 getter 를 만들면 사라진다. 실행에는 문제가 없다.
 * 💡 System.out.println("\nCreate ...") 의 \n 때문에 출력 사이에 빈 줄이 생긴다. (이클립스 한글 폰트에서는 \ 가 ₩ 로 보임)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 SavingsAccountTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Create a Bank Account object (A/c No. BA1234) with initial balance of $500:
 *  Deposit $1000 into account BA1234:
 *  New balance after depositing $1000: $1500.0
 *  Withdraw $600 from account BA1234:
 *  New balance after withdrawing $600: $900.0
 *
 *  Create a SavingsAccount object (A/c No. SA1234) with initial balance of $450:
 *  Balance after trying to withdraw $300: $150.0
 *
 *  Create a SavingsAccount object (A/c No. SA1000) with initial balance of $300:
 *  Try to withdraw $250 from SA1000!
 *  Minimum balance of $100 required!
 *  Balance after trying to withdraw $250: $300.0
 */
public class SavingsAccountTest {
    public static void main(String[] args) {
        System.out.println("Create a Bank Account object (A/c No. BA1234) with initial balance of $500:");
        BankAccount BA1234 = new BankAccount("BA1234", 500);

        System.out.println("Deposit $1000 into account BA1234:");
        BA1234.deposit(1000);
        System.out.println("New balance after depositing $1000: $" + BA1234.getBalance());

        System.out.println("Withdraw $600 from account BA1234:");
        BA1234.withdraw(600);
        System.out.println("New balance after withdrawing $600: $" + BA1234.getBalance());

        System.out.println("\nCreate a SavingsAccount object (A/c No. SA1234) with initial balance of $450:");
        SavingsAccount SA1234 = new SavingsAccount("SA1234", 450);

        SA1234.withdraw(300);
        System.out.println("Balance after trying to withdraw $300: $" + SA1234.getBalance());

        System.out.println("\nCreate a SavingsAccount object (A/c No. SA1000) with initial balance of $300:");
        SavingsAccount SA1000 = new SavingsAccount("SA1000", 300);

        System.out.println("Try to withdraw $250 from SA1000!");
        SA1000.withdraw(250);
        System.out.println("Balance after trying to withdraw $250: $" + SA1000.getBalance());
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < 100) {
            System.out.println("Minimum balance of $100 required!");
        } else {
            super.withdraw(amount);
        }
    }
}
