# 7주차 과제 · classes1

[🏠 7주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [EmployeeTest.java](#1-employee-private-필드--getter--setter) | 1. Employee: `private` 필드 + getter / setter |
| [BankAccountTest.java](#2-uml을-보고-bankaccount-작성-입금--출금) | 2. UML을 보고 BankAccount 작성 (입금 · 출금) |
| [TelevisionTest.java](#3-television-전원--채널--볼륨-tostring) | 3. Television: 전원 · 채널 · 볼륨, `toString` (📝 `@Override`를 붙이는 이유) |
| [StopwatchTest.java](#4-stopwatch-instant--duration-getelapsedtime-오버로딩) | 4. Stopwatch: `Instant` · `Duration`, `getElapsedTime` 오버로딩 |

---

## 1. Employee: `private` 필드 + getter / setter

`7강 과제` · 📄 [`EmployeeTest.java`](EmployeeTest.java)

#### 문제

> 이름(name), 나이(age), 급여(salary), 근속연수(years)를 private 필드로 가지는 Employee 클래스를 만들고 getter / setter 를 작성하시오. main 에서 setter 로 값을 넣고 getter 로 꺼내 출력한다.

#### 💻 코드

<!-- code: EmployeeTest.java -->
```java
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("홍길동");
        emp.setAge(20);
        emp.setSalary(3000000);
        emp.setYears(1);

        System.out.println("이름: " + emp.getName());
        System.out.println("나이: " + emp.getAge());
        System.out.println("급여: " + emp.getSalary());
        System.out.println("근속연수: " + emp.getYears());
    }
}

class Employee {
    private String name;
    private int age;
    private int salary;
    private int years;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public int getYears() { return years; }
    public void setYears(int years) { this.years = years; }
}
```
<!-- /code -->

#### 실행 결과

```text
이름: 홍길동
나이: 20
급여: 3000000
근속연수: 1
```

**포인트**

- private 필드는 클래스 밖(main)에서 emp.name 처럼 직접 쓸 수 없다. → setName() / getName() 으로 접근
- setter 의 매개변수 이름이 필드 이름과 같으므로 this.name = name; 으로 구분한다. (7-2 this)
- getter 이름 규칙 : get + 필드 이름 (첫 글자 대문자) / setter : set + 필드 이름

- 💡 int 범위는 약 ±21억이므로 급여 3000000 은 int 로 충분하다.

## 2. UML을 보고 BankAccount 작성 (입금 · 출금)

`7강 과제` · 📄 [`BankAccountTest.java`](BankAccountTest.java)

#### 문제

> 아래 UML 클래스 다이어그램대로 BankAccount 클래스를 작성하고, 입금 후 출금한 잔액을 출력하시오.
>
> ```text
> ┌──────────────────────────────┐
> │          BankAccount         │
> ├──────────────────────────────┤
> │ - accountNumber              │
> │ - owner                      │
> │ - balance                    │
> ├──────────────────────────────┤
> │ + getter / setter            │
> │ + deposit()                  │
> │ + withdraw()                 │
> └──────────────────────────────┘
> ```

#### 💻 코드

<!-- code: BankAccountTest.java -->
```java
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
```
<!-- /code -->

#### 실행 결과

```text
잔액 : 10000
잔액 : 2000
```

**포인트**

- UML 기호 : -  는 private,  + 는 public
- deposit(입금) 은 잔액에 더하고, withdraw(출금) 는 잔액에서 뺀다.
  ```java
  this.balance += amount;   →   this.balance = this.balance + amount;
  ```
- 잔액(balance)을 직접 바꾸지 못하게 private 으로 두고, deposit / withdraw 메서드로만 바꾸게 한다. (캡슐화)

- 💡 print 는 줄바꿈이 없어서 두 결과가 한 줄에 붙는다. 그래서 println 을 썼다.
  ```java
  System.out.println("잔액 : " + account.getBalance());
  ```

- 💡 지금은 잔액보다 많이 출금해도 음수가 된다. 실제라면 withdraw 에서 검사하는 것이 좋다.
  ```java
  if (amount > balance) { System.out.println("잔액이 부족합니다."); return; }
  ```

## 3. Television: 전원 · 채널 · 볼륨, `toString`

`7강 과제` · 📄 [`TelevisionTest.java`](TelevisionTest.java)

#### 문제

> 아래 UML 대로 Television 클래스를 작성하시오.
>
> ```text
> ┌──────────────────────────────┐
> │          Television          │
> ├──────────────────────────────┤
> │ - isOn                       │
> │ - volume                     │
> │ - channel                    │
> ├──────────────────────────────┤
> │ + setChannel() / getChannel()│
> │ + setVolume()  / getVolume() │
> │ + turnOn() / turnOff()       │
> │ + toString()                 │
> └──────────────────────────────┘
> ```

#### 💻 코드

<!-- code: TelevisionTest.java -->
```java
public class TelevisionTest {
    public static void main(String[] args) {
        Television tv = new Television();
        tv.turnOn();
        tv.setChannel(7);
        tv.setVolume(15);
        System.out.println(tv.toString());

        tv.setChannel(11);
        tv.setVolume(20);
        System.out.println(tv.toString());

        tv.turnOff();
        System.out.println(tv.toString());
    }
}

class Television {
    private boolean isOn;
    private int volume;
    private int channel;

    public void setChannel(int channel) { this.channel = channel; }
    public int getChannel() { return channel; }

    public void setVolume(int volume) { this.volume = volume; }
    public int getVolume() { return volume; }

    public void turnOn() { isOn = true; }
    public void turnOff() { isOn = false; }

    @Override       // 📝 Object 의 toString() 을 재정의
    public String toString() {
        return "TV 상태 [전원: " + (isOn ? "켜짐" : "꺼짐") + ", 채널: " + channel + ", 볼륨: " + volume + "]";
    }
}
```
<!-- /code -->

#### 실행 결과

```text
TV 상태 [전원: 켜짐, 채널: 7, 볼륨: 15]
TV 상태 [전원: 켜짐, 채널: 11, 볼륨: 20]
TV 상태 [전원: 꺼짐, 채널: 11, 볼륨: 20]
```

**포인트**

- isOn 은 boolean : turnOn() 에서 true, turnOff() 에서 false
- toString() 안에서 삼항 연산자로 true / false 를 "켜짐" / "꺼짐" 으로 바꿔 출력<br>(isOn ? "켜짐" : "꺼짐")
- 전원을 꺼도 채널 · 볼륨 값은 그대로 남는다. (세 번째 출력 : 꺼짐, 채널 11, 볼륨 20)

- 📝 필기 (질문) @Override 붙이는 이유는 뭐임

**📝 필기**

  - @Override 는 "이 메서드는 부모 클래스(또는 인터페이스)의 메서드를 재정의(오버라이딩)한 것" 이라고 컴파일러에게 알려 주는 어노테이션(annotation)이다.<br>toString() 은 모든 클래스의 부모인 Object 클래스에 이미 있는 메서드라서 재정의하는 것이다.
  - 붙이지 않아도 동작은 같다. (선택 사항) 하지만 붙이는 것을 권장한다.
    - ① 오타 방지
      ```java
      public String tostring() { ... }               // 소문자 s → 재정의가 아니라 "새 메서드" 가 조용히 만들어짐
                                                      //   println(tv) 하면 Television@1b6d3586 이 출력됨
      @Override public String tostring() { ... }     // → 컴파일 에러 : method does not override or
                                                      //   implement a method from a supertype
      ```
    - ② 가독성 : 코드를 읽는 사람이 "부모 메서드를 재정의한 것" 임을 바로 안다.
    - ③ 유지보수 : 나중에 부모 클래스의 메서드 이름이나 매개변수가 바뀌면, @Override 가 붙은 곳에서 바로 컴파일 에러가 나서 고쳐야 할 곳을 놓치지 않는다.

(상속과 오버라이딩은 뒤 주차에서 자세히 배움)

- 💡 System.out.println(tv.toString()) 은 System.out.println(tv) 로 써도 같다. (println 이 toString 을 자동 호출)

## 4. Stopwatch: `Instant` · `Duration`, `getElapsedTime` 오버로딩

`7강 과제` · 📄 [`StopwatchTest.java`](StopwatchTest.java)

#### 문제

> start() / stop() 으로 시간을 재는 Stopwatch 클래스를 작성하시오.
>
>   - 이미 시작한 상태에서 start() 를 부르면 안내 메시지 출력
>   - 시작하지 않은 상태에서 stop() 을 부르면 안내 메시지 출력
>   - getElapsedTime()              : 경과 시간 (밀리초)
>   - getElapsedTime(TimeUnit unit) : 경과 시간을 원하는 단위로 (오버로딩)

#### 💻 코드

<!-- code: StopwatchTest.java -->
```java
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class StopwatchTest {
    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = new Stopwatch();
        sw.stop();                 // 시작 전에 stop → 안내 메시지
        sw.start();
        sw.start();                // 이미 시작됨 → 안내 메시지
        Thread.sleep(150);         // 150ms 대기
        sw.stop();

        long millis = sw.getElapsedTime();
        long nanos = sw.getElapsedTime(TimeUnit.NANOSECONDS);
        System.out.println("경과 시간(밀리초): " + millis);
        System.out.println("경과 시간(나노초): " + nanos);
    }
}

class Stopwatch {
    private Instant startTime;
    private Instant stopTime;
    private boolean isRunning;

    public void start() {
        if (isRunning) {
            System.out.println("이미 시작 중입니다. stop 메서드를 호출하여 중단한 후 start 메서드를 호출 하시기 바랍니다.");
            return;
        }
        this.isRunning = true;
        this.startTime = Instant.now();
    }

    public void stop() {
        if (!isRunning) {
            System.out.println("아직 시작하지 않았습니다. start 메서드를 호출하여 시작한 후 stop 메서드를 호출하시기 바랍니다.");
            return;
        }
        this.stopTime = Instant.now();
        this.isRunning = false;
    }

    private Duration getDuration() {
        if (startTime == null) return Duration.ZERO;           // 한 번도 시작하지 않음
        Instant end = isRunning ? Instant.now() : stopTime;    // 측정 중이면 지금까지
        return Duration.between(startTime, end);
    }

    public long getElapsedTime() {                             // 밀리초
        return getDuration().toMillis();
    }

    public long getElapsedTime(TimeUnit unit) {                // 오버로딩 : 원하는 단위
        return unit.convert(getDuration().toNanos(), TimeUnit.NANOSECONDS);
    }
}
```
<!-- /code -->

#### 실행 결과 (나노초는 실행할 때마다 다름)

```text
아직 시작하지 않았습니다. start 메서드를 호출하여 시작한 후 stop 메서드를 호출하시기 바랍니다.
이미 시작 중입니다. stop 메서드를 호출하여 중단한 후 start 메서드를 호출 하시기 바랍니다.
경과 시간(밀리초): 150
경과 시간(나노초): 150516300
```

**포인트**

- Instant.now()                 : 지금 이 순간의 시각
- Duration.between(시작, 끝)    : 두 시각 사이의 시간 간격<br>duration.toMillis()  → 밀리초 (1/1,000초)
  ```text
  duration.toNanos()   → 나노초 (1/1,000,000,000초)
  ```
- isRunning (boolean) 으로 상태를 기억해서 start 를 두 번, stop 을 먼저 부르는 잘못된 사용을 막는다.
  ```java
  if (isRunning) { 메시지; return; }   ← return 으로 메서드를 바로 끝냄 (아래 코드 실행 X)
  ```
- getElapsedTime() 과 getElapsedTime(TimeUnit) 은 이름이 같고 매개변수가 다른 메서드 오버로딩 (7-3)
- getDuration() 은 두 getElapsedTime 이 같이 쓰는 private 도우미 메서드 (중복 코드 제거)
      - 아직 start 하지 않았으면 Duration.ZERO
      - 측정 중이면 지금까지, 멈췄으면 stop 한 시각까지
- unit.convert(값, 원래 단위) : 나노초 값을 원하는 단위(unit)로 변환<br>TimeUnit.NANOSECONDS.convert(n, TimeUnit.NANOSECONDS) → n 그대로
  ```text
  TimeUnit.SECONDS.convert(n, TimeUnit.NANOSECONDS)     → 초 단위 (소수점 버림)
  ```

- Thread.sleep(150) : 150 밀리초 동안 멈춘다. 이 메서드는 InterruptedException 을 던질 수 있으므로 main 에 throws InterruptedException 을 붙였다. (예외 처리는 뒤 주차에서 배움)

- 💡 sleep 은 "최소" 150ms 를 보장할 뿐이고 실행할 때마다 조금씩 달라서 나노초 값은 매번 다르다.<br>밀리초도 151, 161 처럼 조금 더 크게 나올 수 있다.

---

[🏠 7주차 학습 가이드](../../README.md)
