# 11주차 과제 · inheritance3

[🏠 11주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [PlayableTest.java](#1-playable-인터페이스와-football--volleyball--basketball) | 1. `Playable` 인터페이스와 `Football` · `Volleyball` · `Basketball` |
| [BankSystemTest.java](#2-bank-account-인터페이스-savingsaccount이자--currentaccount마이너스-한도) | 2. `Bank`, `Account` 인터페이스, `SavingsAccount`(이자) · `CurrentAccount`(마이너스 한도) |
| [TATest.java](#3-faculty와-student의-특성을-모두-갖는-ta-a-컴포지션--b-컴포지션--인터페이스) | 3. `Faculty`와 `Student`의 특성을 모두 갖는 `TA`: (a) 컴포지션 / (b) 컴포지션 + 인터페이스 |

---

## 1. `Playable` 인터페이스와 `Football` · `Volleyball` · `Basketball`

`11강 과제` · 📄 [`PlayableTest.java`](PlayableTest.java)

#### 문제

> 인수를 사용하지 않고 void 를 반환하는 play() 메서드를 갖는 Playable 인터페이스를 생성하라. Playable 인터페이스를 구현하고 각 스포츠를 플레이하기 위해 play() 메서드를 재정의하는 세 가지 클래스 Football, Volleyball 및 Basketball 클래스를 작성하라.<br>main 은 다음과 같다.
>
> ```java
> // Main
> public class Main {
>     public static void main(String[] args) {
>         // Create instances of Playable objects for football, volleyball, and basketball
>         Playable football = new Football();
>         Playable volleyball = new Volleyball();
>         Playable basketball = new Basketball();
>
>         // Call the "play" method on each Playable object to play different sports
>         football.play();
>         volleyball.play();
>         basketball.play();
>     }
> }
> ```

#### 💻 코드

<!-- code: PlayableTest.java -->
```java
public class PlayableTest {
    public static void main(String[] args) {
        Playable football = new Football();
        Playable volleyball = new Volleyball();
        Playable basketball = new Basketball();

        football.play();
        volleyball.play();
        basketball.play();
    }
}

interface Playable {
    void play();
}

class Football implements Playable {
    @Override
    public void play() {
        System.out.println("Playing football");
    }
}

class Volleyball implements Playable {
    @Override
    public void play() {
        System.out.println("Playing volleyball");
    }
}

class Basketball implements Playable {
    @Override
    public void play() {
        System.out.println("Playing basketball");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Playing football
Playing volleyball
Playing basketball
```

**포인트**

- interface Playable { void play(); } : 인수 없음, 반환형 void
- 세 클래스가 implements Playable 로 play() 를 각자 구현한다.
- main 에서는 셋 다 Playable 타입 변수에 담는다. play() 를 부르면 실제 객체의 play() 가 실행된다. (동적 바인딩, 10-3)

- 💡 인터페이스의 play() 는 자동으로 public abstract 다. 그래서 구현 클래스의 play() 도 반드시 public 이어야 한다.
- 💡 Playable\[] games = { new Football(), new Volleyball(), new Basketball() }; 처럼 배열에 담고 for 문으로 돌려도 결과가 같다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 PlayableTest 로 이름을 바꿨다.

## 2. `Bank`, `Account` 인터페이스, `SavingsAccount`(이자) · `CurrentAccount`(마이너스 한도)

`11강 과제` · 📄 [`BankSystemTest.java`](BankSystemTest.java)

#### 문제

> Bank, Account, SavingsAccount 및 CurrentAccount 의 세 가지 클래스가 있는 은행 시스템을 생성하는 Java 프로그래밍을 작성한다.<br>Bank 에는 계좌 목록과 계좌 추가 방법이 있어야 한다. Account 는 입금, 출금, 이자를 계산하고 잔액을 확인하는 방법을 갖춘 인터페이스이다. SavingsAccount 와 CurrentAccount 는 Account 인터페이스를 구현해야 하며 고유한 메소드를 가지고 있어야 한다.<br>main 은 다음과 같다. (아래 main 과 같음)
>
> 실행 결과 :<br>Savings Account:<br>Initial Deposit: $1000.00<br>Interest rate: 1.25%
>
> Current Account:<br>Initial Deposit: $5000.00<br>OverdraftLimit: $1000.00
>
> Now deposit $100 to Savings Account.<br>Now deposit $500 to Current Account.<br>Withdraw $150 from Savings Account.
>
> Savings A/c and Current A/c.:<br>Account balance: 950.0<br>Account balance: 5500.0
>
> After applying interest on Savings A/c for 1 year:<br>Savings A/c and Current A/c.:<br>Account balance: 961.875<br>Account balance: 5500.0

#### 💻 코드

<!-- code: BankSystemTest.java -->
```java
import java.util.ArrayList;
import java.util.List;

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
```
<!-- /code -->

#### 실행 결과

```text
Savings Account:
Initial Deposit: $1000.00
Interest rate: 1.25%

Current Account:
Initial Deposit: $5000.00
Overdraft Limit: $1000.00

Now deposit $100 to Savings Account.
Now deposit $500 to Current Account.
Withdraw $150 from Savings Account.


Savings A/c and Current A/c.:
Account balance: 950.0
Account balance: 5500.0

After applying interest on Savings A/c for 1 year:
Savings A/c and Current A/c.:
Account balance: 961.875
Account balance: 5500.0
```

**포인트**

- interface Account : deposit, withdraw, calculateInterest, getBalance
- SavingsAccount (저축 예금) : 이자율(interestRate)이 있다. 고유 메소드 applyInterest() 로 이자를 잔액에 더한다.
  ```text
  calculateInterest() = balance * (interestRate / 100.0)    → 950 * 0.0125 = 11.875 → 961.875
  ``` 출금은 잔액 안에서만 된다. (잔액이 모자라면 "Insufficient balance.")
- CurrentAccount (당좌 예금) : 마이너스 통장처럼 overdraftLimit 만큼 잔액보다 더 뽑을 수 있다.<br>balance + overdraftLimit >= amount 이면 출금. 이자는 없다(0.0). 고유 메소드 setOverdraftLimit / getOverdraftLimit
- Bank : List&lt;Account> accounts 에 계좌를 모아 두고, Account 타입으로 입금 · 출금 · 잔액 출력을 한다.<br>→ 계좌 종류가 달라도 Account 인터페이스 하나로 똑같이 다룰 수 있다. (다형성)

- ⚠ 자주 틀리는 부분 : savingsAccount.applyInterest() 는 Account 인터페이스에 없는 SavingsAccount 의 고유 메소드다.<br>그래서 main 에서도 SavingsAccount 타입 변수로 부른다. Account 타입 변수(예 : Bank 의 accounts 요소)로는 부를 수 없다.
  ```text
  error: cannot find symbol  symbol: method applyInterest()  location: variable account of type Account
  ```
- ⚠ 문제의 실행 결과는 "OverdraftLimit: $1000.00" 처럼 붙어 있지만 main 의 문자열은 "Overdraft Limit: $1000.00" 이다.<br>실제 실행 결과는 main 을 따른다.
- 💡 "Withdraw $150 from Savings Account.\\n" 다음 println("\\nSavings A/c ...") 때문에 빈 줄이 두 개 생긴다.
- 💡 이자를 계산할 때 1.25 를 100.0 으로 나눠 0.0125 로 만든다. 100 (int) 으로 나눠도 1.25 가 double 이라 결과는 같지만, 정수끼리의 나눗셈(예 : 1 / 100 = 0)을 피하려고 100.0 으로 쓰는 습관을 들이면 좋다.
- 💡 List&lt;Account>, ArrayList 는 12강(지네릭과 컬렉션)에서 배운다. 크기가 자동으로 늘어나는 배열이라고 보면 된다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 BankSystemTest 로 이름을 바꿨다.

## 3. `Faculty`와 `Student`의 특성을 모두 갖는 `TA`: (a) 컴포지션 / (b) 컴포지션 + 인터페이스

`11강 과제` · 📄 [`TATest.java`](TATest.java)

#### 문제

> 다음 클래스를 이용하여 아래의 물음에 답하라.
>
> ```java
> public class Person {
>     int age;
>     String sex;
>     public Person(int age, String sex) {
>         this.age = age; this.sex = sex;
>     }
>     public int getAge() {return this.age;}
>     public void setAge(int newAge) { this.age= newAge;}
>     public String getSex() {return sex;}
>     public void setSex(String newSex) {sex = newSex;}
> }
> public class Faculty extends Person {
>     String major;
>     public Faculty(int age, String sex, String major) {
>         super(age, sex);
>         this.major = major;
>     }
>     public String getMajor() {return major;}
>     public void setMajor(String newMajor) {major = newMajor;}
> }
> public class Student extends Person {
>     String dept;
>     public Student(int age, String sex, String dept) {
>         super(age, sex);
>         this.dept = dept;
>     }
>     public String getDept() {return dept;}
>     public void setDept(String newDept) {dept = newDept;}
> }
> ```
>
> - (a) composition 을 이용하여 Faculty 와 Student 의 특성 모두를 갖고 있는 TA 클래스를 정의하시오.
> - (b) composition 과 인터페이스 모두를 이용하여 TA 클래스를 정의하시오.

#### 💻 코드

<!-- code: TATest.java -->
```java
public class TATest {
    public static void main(String[] args) {
        TA ta = new TA(25, "Male", "AI", "Computer Science");

        System.out.println("=== (a) Composition ===");
        System.out.println("나이: " + ta.getAge());
        System.out.println("성별: " + ta.getSex());
        System.out.println("전공(Faculty): " + ta.getMajor());
        System.out.println("학과(Student): " + ta.getDept());

        ta.setAge(26);
        ta.setMajor("Machine Learning");
        System.out.println("수정 후 나이: " + ta.getAge() + ", 전공: " + ta.getMajor());

        TA2 ta2 = new TA2(25, "Female", "Data Science", "Software Engineering");

        System.out.println("=== (b) Composition + Interface ===");
        System.out.println("나이: " + ta2.getAge());
        System.out.println("성별: " + ta2.getSex());
        System.out.println("전공(Faculty): " + ta2.getMajor());
        System.out.println("학과(Student): " + ta2.getDept());

        IPerson p = ta2;
        IFaculty f = ta2;
        IStudent s = ta2;

        System.out.println("IPerson 나이: " + p.getAge());
        System.out.println("IFaculty 전공: " + f.getMajor());
        System.out.println("IStudent 학과: " + s.getDept());
    }
}

class Person {
    int age;
    String sex;

    public Person(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() { return this.age; }
    public void setAge(int newAge) { this.age = newAge; }
    public String getSex() { return sex; }
    public void setSex(String newSex) { sex = newSex; }
}

class Faculty extends Person {
    String major;

    public Faculty(int age, String sex, String major) {
        super(age, sex);
        this.major = major;
    }

    public String getMajor() { return major; }
    public void setMajor(String newMajor) { major = newMajor; }
}

class Student extends Person {
    String dept;

    public Student(int age, String sex, String dept) {
        super(age, sex);
        this.dept = dept;
    }

    public String getDept() { return dept; }
    public void setDept(String newDept) { dept = newDept; }
}

/** (a) Composition 을 이용한 TA */
class TA {
    private Faculty faculty;
    private Student student;

    public TA(int age, String sex, String major, String dept) {
        this.faculty = new Faculty(age, sex, major);
        this.student = new Student(age, sex, dept);
    }

    public int getAge() { return student.getAge(); }
    public void setAge(int newAge) {
        student.setAge(newAge);
        faculty.setAge(newAge);
    }

    public String getSex() { return student.getSex(); }
    public void setSex(String newSex) {
        student.setSex(newSex);
        faculty.setSex(newSex);
    }

    public String getMajor() { return faculty.getMajor(); }
    public void setMajor(String newMajor) { faculty.setMajor(newMajor); }

    public String getDept() { return student.getDept(); }
    public void setDept(String newDept) { student.setDept(newDept); }
}

/** (b) 인터페이스 */
interface IPerson {
    int getAge();
    void setAge(int newAge);
    String getSex();
    void setSex(String newSex);
}

interface IFaculty extends IPerson {
    String getMajor();
    void setMajor(String newMajor);
}

interface IStudent extends IPerson {
    String getDept();
    void setDept(String newDept);
}

/** (b) Composition + 인터페이스를 이용한 TA (처음 작성한 코드에서는 이름이 TA) */
class TA2 implements IFaculty, IStudent {
    private Faculty faculty;
    private Student student;

    public TA2(int age, String sex, String major, String dept) {
        this.faculty = new Faculty(age, sex, major);
        this.student = new Student(age, sex, dept);
    }

    @Override
    public int getAge() { return student.getAge(); }

    @Override
    public void setAge(int newAge) {
        student.setAge(newAge);
        faculty.setAge(newAge);
    }

    @Override
    public String getSex() { return student.getSex(); }

    @Override
    public void setSex(String newSex) {
        student.setSex(newSex);
        faculty.setSex(newSex);
    }

    @Override
    public String getMajor() { return faculty.getMajor(); }

    @Override
    public void setMajor(String newMajor) { faculty.setMajor(newMajor); }

    @Override
    public String getDept() { return student.getDept(); }

    @Override
    public void setDept(String newDept) { student.setDept(newDept); }
}
```
<!-- /code -->

#### 실행 결과

```text
=== (a) Composition ===
나이: 25
성별: Male
전공(Faculty): AI
학과(Student): Computer Science
수정 후 나이: 26, 전공: Machine Learning
=== (b) Composition + Interface ===
나이: 25
성별: Female
전공(Faculty): Data Science
학과(Student): Software Engineering
IPerson 나이: 25
IFaculty 전공: Data Science
IStudent 학과: Software Engineering
```

#### 📒 해설

- 📝 필기 : 자바(Java)는 클래스의 다중 상속을 지원하지 않기 때문에, Faculty 와 Student 의 특성을 모두 갖는 TA 클래스를 만들 때는 합성(Composition)이나 인터페이스(Interface)를 활용해야 한다.
  - (a) Composition(합성)을 이용한 TA 클래스 정의<br>TA 클래스 내부에 Faculty 와 Student 객체를 멤버 변수로 포함(HAS-A 관계)시키고, 각 메서드의 호출을 내부 객체에 위임(Delegation)하는 방식이다.
  - (b) Composition 과 인터페이스를 모두 이용한 TA 클래스 정의
      - (a) 방식만 사용하면 기능은 모두 사용할 수 있지만, TA 가 Faculty 나 Student 타입으로 취급될 수 없어 다형성(Polymorphism)을

활용할 수 없다. 이를 해결하기 위해 각 클래스의 기능을 정의한 인터페이스를 선언하고, TA 가 인터페이스를 구현(implements)하면서 실제 기능 구현은 합성(Composition)한 객체에 위임한다.

```java
interface IPerson { getAge, setAge, getSex, setSex }
interface IFaculty extends IPerson { getMajor, setMajor }
interface IStudent extends IPerson { getDept, setDept }
class TA implements IFaculty, IStudent { ... }
```

**포인트**

- TA 는 faculty 와 student 두 객체를 갖고 있다. 나이와 성별은 두 객체에 똑같이 들어 있으므로 getAge() / getSex()  : 한쪽(student)에서 읽는다<br>setAge() / setSex()  : 두 객체 모두에 써서 값이 어긋나지 않게 한다
- (b) 에서 IFaculty 와 IStudent 둘 다 IPerson 을 extends 하므로 getAge() 등은 TA 에서 한 번만 구현하면 된다.<br>(인터페이스는 구현이 없어서 같은 메소드가 두 경로로 들어와도 충돌하지 않는다)
- (b) 의 TA 는 IPerson, IFaculty, IStudent 어느 타입 변수에도 담을 수 있다.  IPerson p = ta;  IFaculty f = ta;  IStudent s = ta;

- 💡 (a) 와 (b) 를 한 파일에서 실행하려고 (a) 의 TA 는 TA, (b) 의 TA 는 TA2 로 이름을 나눴다. 처음 작성한 코드에서는 둘 다 TA 다.<br>두 버전의 main 도 하나로 합쳤다.
- 💡 원래는 Person.java, Faculty.java, Student.java 처럼 public class 마다 파일을 나눈다. 한 파일에 넣으려고 public 을 뺐다.

---

[🏠 11주차 학습 가이드](../../README.md)
