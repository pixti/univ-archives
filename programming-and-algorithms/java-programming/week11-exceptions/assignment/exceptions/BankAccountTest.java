/**
 * [11강 과제] 예외 처리 - 2번 문제 (BankAccount : 잔액보다 많이 인출하면 NegativeBalance)
 *
 * 문제
 *  은행 예금을 나타내는 BankAccount 클래스를 작성하라. BankAccount 는 잔액(balance)을 나타내는 필드를 가지며, 입금을 나타내는
 *  deposit() 과 출금을 나타내는 withdraw() 메서드를 가진다. 기타 필요한 생성자, getter, setter 를 추가하라. withdraw() 에서는
 *  인출 금액이 잔액보다 크면 NotEnoughBalance 라는 예외를 발생시킨다. NotEnoughBalance 는 별도의 클래스로 정의한다.
 *  BankAccount 객체를 main() 안에서 생성하여서 테스트하라. try/catch 블록을 이용하여서 예외를 처리하도록 하라.
 *
 *    public class Test2 {
 *        public static void main(String[] args) {
 *            // Create instances of each vehicle type
 *            BankAccount myAcount = new BankAccount(1000000);
 *
 *            System.out.println("myAccount 계좌가 생성 되었습니다.");
 *            try{
 *                myAcount.deposit(20000);
 *                myAcount.display();
 *                myAcount.withdraw(1020001);
 *                myAcount.display();
 *            }
 *            catch(NegativeBalance e)
 *            {
 *                e.printStackTrace();
 *            }
 *        }
 *    }
 *
 *    실행 결과 :
 *    myAccount 계좌가 생성 되었습니다.
 *    현재 잔액은 : 1020000
 *    1020001원 인출 시도 ...
 *    NegativeBalance: 잔액 부족
 *        at BankAccount.withdraw(Test2.java:57)
 *        at Test2.main(Test2.java:36)
 *
 * ⚠ 문제 문장은 예외 이름을 NotEnoughBalance 라고 하지만, 주어진 main 과 실행 결과는 NegativeBalance 를 쓴다.
 *    main 이 컴파일되려면 NegativeBalance 로 정의해야 하므로 main 과 실행 결과를 따랐다.
 *
 * 포인트
 *  - NegativeBalance extends Exception (Checked) → withdraw 에 throws NegativeBalance 가 필요하다.
 *  - withdraw 는 먼저 "1020001원 인출 시도 ..." 를 출력하고, amount > balance 이면 예외를 던진다.
 *    1000000 + 20000 = 1020000 < 1020001 이므로 예외가 나고, 그 아래 balance -= amount; 와 main 의 두 번째 display() 는 실행되지 않는다.
 *  - NegativeBalance 에는 기본 생성자(super("잔액 부족"))와 메시지를 받는 생성자 두 개를 만들었다.
 *    throw new NegativeBalance(); 만 써도 메시지가 "잔액 부족" 이 된다.
 *
 * 💡 생성자를 하나라도 직접 만들면 기본 생성자는 자동으로 생기지 않는다. 그래서 new NegativeBalance() 를 쓰려면 기본 생성자도 적어야 한다.
 *    (실습 Vowel_Check.java 📝 필기 ⑤)
 * 💡 main 의 변수 이름 myAcount 는 myAccount 의 오타처럼 보이지만, 문제에 주어진 이름이라 그대로 두었다. (동작에는 영향 없음)
 * 💡 printStackTrace() 의 줄 번호는 파일 구성에 따라 달라진다. (문제의 결과는 57, 36 / 처음 작성한 코드는 37, 55)
 * 💡 원래 이클립스에서 Test2 클래스로 작성한 코드. 같은 폴더의 다른 문제도 Test2 라서 BankAccountTest 로 이름을 바꿨다.
 *
 * 실행 결과 (줄 번호는 이 파일 기준)
 *  (java 파일이름.java 로 실행하면 맨 아래에 SourceLauncher 줄이 몇 줄 더 붙는다)
 *  myAccount 계좌가 생성 되었습니다.
 *  현재 잔액은 : 1020000
 *  1020001원 인출 시도 ...
 *  NegativeBalance: 잔액 부족
 *      at BankAccount.withdraw(BankAccountTest.java:114)
 *      at BankAccountTest.main(BankAccountTest.java:70)
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
