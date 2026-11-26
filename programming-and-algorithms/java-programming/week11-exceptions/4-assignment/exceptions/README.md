# 11주차 과제 · exceptions

[🏠 11주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [SafeArrayTest.java](#1-잘못된-인덱스이면-indexexception) | 1. 잘못된 인덱스이면 `IndexException` |
| [BankAccountTest.java](#2-잔액보다-많이-인출하면-negativebalance) | 2. 잔액보다 많이 인출하면 `NegativeBalance` (⚠ 문제의 `NotEnoughBalance`와 이름 불일치) |
| [StackTest.java](#3-stack-underflow--stack-overflow를-exception으로) | 3. `Stack Underflow` / `Stack Overflow`를 `Exception`으로 (⚠ 스택은 LIFO) |
| [SearchArrayTest.java](#4-찾는-숫자가-없으면-notfound) | 4. 찾는 숫자가 없으면 `NotFound` |

---

## 1. 잘못된 인덱스이면 `IndexException`

`11강 과제` · 📄 [`SafeArrayTest.java`](SafeArrayTest.java)

#### 문제

> 정수형 배열을 나타내는 SafeArray 클래스를 작성하여 보자. SafeArray 는 기존의 배열을 향상시킨 것으로 사용자가 잘못된 인덱스로 요소에 접근하는 경우에 예외를 발생한다. SafeArray 클래스의 setAt() 메서드를 정의하고, 이 연산자 함수에서 매개 변수로 전달된 인덱스가 잘못된 경우에 예외를 발생한다. SafeArray 객체를 main 안에서 생성하여 테스트하라. 이 때 try/catch 문을 이용하여 예외를 처리하도록 하라.
>
> ```java
> public class Test2 {
>     public static void main(String[] args) {
>         // Create instances of each vehicle type
>         SafeArray sa = new SafeArray(5);
>         sa.setAt(1, 11);   // 배열 인덱스 1 위치에 11 저장
>         sa.setAt(2, 12);
>         sa.setAt(3, 13);
>         sa.setAt(4, 14);
>         sa.setAt(5, 15);   //예외 발생
>     }
> }
> ```
>
> 실행 결과 :<br>IndexException: out of index error
>
> ```text
> at SafeArray.setAt(Test2.java:57)
> at Test2.main(Test2.java:36)
> ```

#### 💻 코드

<!-- code: SafeArrayTest.java -->
```java
public class SafeArrayTest {
    public static void main(String[] args) {
        SafeArray sa = new SafeArray(5);

        try {
            sa.setAt(1, 11);   // 배열 인덱스 1 위치에 11 저장
            sa.setAt(2, 12);
            sa.setAt(3, 13);
            sa.setAt(4, 14);
            sa.setAt(5, 15);   // 인덱스 범위(0~4) 초과로 예외 발생
        } catch (IndexException e) {
            e.printStackTrace();
        }
    }
}

class IndexException extends Exception {
    public IndexException(String message) {
        super(message);
    }
}

class SafeArray {
    private int[] arr;

    public SafeArray(int size) {
        arr = new int[size];
    }

    public void setAt(int index, int value) throws IndexException {
        if (index < 0 || index >= arr.length) {
            throw new IndexException("out of index error");
        }
        arr[index] = value;
    }
}
```
<!-- /code -->

#### 실행 결과 (줄 번호는 이 파일 기준)

```text
(java 파일이름.java 로 실행하면 맨 아래에 SourceLauncher 줄이 몇 줄 더 붙는다)
IndexException: out of index error
    at SafeArray.setAt(SafeArrayTest.java:80)
    at SafeArrayTest.main(SafeArrayTest.java:58)
```

**포인트**

- 사용자 정의 예외 IndexException extends Exception (Checked) → setAt 에 throws IndexException 이 필요하다.
- 올바른 인덱스는 0 \~ arr.length - 1. 그래서 index &lt; 0 || index >= arr.length 이면 예외를 던진다.<br>크기가 5 인 배열에서 setAt(5, 15) 는 인덱스 5 라 예외가 난다.
- 예외를 던지는 줄(throw) 다음의 arr\[index] = value; 는 실행되지 않는다.
- main 에서는 try/catch 로 잡고 e.printStackTrace() 로 예외 종류, 메시지, 발생 위치(줄 번호)를 출력한다.

- 💡 자바의 기본 배열도 범위를 벗어나면 ArrayIndexOutOfBoundsException 을 던진다. SafeArray 는 그 검사를 직접 해서 우리가 정한 예외와 메시지를 쓰는 것이다. (C++ 의 배열은 범위를 검사하지 않아서 이런 "안전한 배열" 클래스를 만든다)
- 💡 문제 문장의 "연산자 함수" 는 C++ 의 operator\[] 를 떠올린 표현이다. 자바에서는 setAt 메서드다.
- 💡 문제 main 의 "// Create instances of each vehicle type" 주석은 다른 문제에서 남은 것이라 이 문제와는 관계없다.
- 💡 printStackTrace() 는 System.err 로 출력해서 이클립스 콘솔에서는 빨간 글씨로 보인다. 줄 번호(Test2.java:16 등)는 파일 구성에 따라 달라진다. (문제의 결과는 57, 36 / 처음 작성한 코드는 16, 31)
- 💡 이클립스는 IndexException 줄에 serialVersionUID 노란 경고를 표시한다. 무시해도 된다.
- 💡 원래 이클립스에서 Test2 클래스로 작성한 코드. 같은 폴더의 다른 문제도 Test2 라서 SafeArrayTest 로 이름을 바꿨다.

## 2. 잔액보다 많이 인출하면 `NegativeBalance`

`11강 과제` · 📄 [`BankAccountTest.java`](BankAccountTest.java)

#### 문제

> 은행 예금을 나타내는 BankAccount 클래스를 작성하라. BankAccount 는 잔액(balance)을 나타내는 필드를 가지며, 입금을 나타내는 deposit() 과 출금을 나타내는 withdraw() 메서드를 가진다. 기타 필요한 생성자, getter, setter 를 추가하라. withdraw() 에서는 인출 금액이 잔액보다 크면 NotEnoughBalance 라는 예외를 발생시킨다. NotEnoughBalance 는 별도의 클래스로 정의한다.<br>BankAccount 객체를 main() 안에서 생성하여서 테스트하라. try/catch 블록을 이용하여서 예외를 처리하도록 하라.
>
> ```java
> public class Test2 {
>     public static void main(String[] args) {
>         // Create instances of each vehicle type
>         BankAccount myAcount = new BankAccount(1000000);
>
>         System.out.println("myAccount 계좌가 생성 되었습니다.");
>         try{
>             myAcount.deposit(20000);
>             myAcount.display();
>             myAcount.withdraw(1020001);
>             myAcount.display();
>         }
>         catch(NegativeBalance e)
>         {
>             e.printStackTrace();
>         }
>     }
> }
> ```
>
> 실행 결과 :<br>myAccount 계좌가 생성 되었습니다.<br>현재 잔액은 : 1020000<br>1020001원 인출 시도 ...<br>NegativeBalance: 잔액 부족
>
> ```text
> at BankAccount.withdraw(Test2.java:57)
> at Test2.main(Test2.java:36)
> ```

#### 💻 코드

<!-- code: BankAccountTest.java -->
```java
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
```
<!-- /code -->

#### 실행 결과 (줄 번호는 이 파일 기준)

```text
(java 파일이름.java 로 실행하면 맨 아래에 SourceLauncher 줄이 몇 줄 더 붙는다)
myAccount 계좌가 생성 되었습니다.
현재 잔액은 : 1020000
1020001원 인출 시도 ...
NegativeBalance: 잔액 부족
    at BankAccount.withdraw(BankAccountTest.java:114)
    at BankAccountTest.main(BankAccountTest.java:70)
```

#### 📒 해설

- ⚠ 문제 문장은 예외 이름을 NotEnoughBalance 라고 하지만, 주어진 main 과 실행 결과는 NegativeBalance 를 쓴다.<br>main 이 컴파일되려면 NegativeBalance 로 정의해야 하므로 main 과 실행 결과를 따랐다.

**포인트**

- NegativeBalance extends Exception (Checked) → withdraw 에 throws NegativeBalance 가 필요하다.
- withdraw 는 먼저 "1020001원 인출 시도 ..." 를 출력하고, amount > balance 이면 예외를 던진다.<br>1000000 + 20000 = 1020000 &lt; 1020001 이므로 예외가 나고, 그 아래 balance -= amount; 와 main 의 두 번째 display() 는 실행되지 않는다.
- NegativeBalance 에는 기본 생성자(super("잔액 부족"))와 메시지를 받는 생성자 두 개를 만들었다.<br>throw new NegativeBalance(); 만 써도 메시지가 "잔액 부족" 이 된다.

- 💡 생성자를 하나라도 직접 만들면 기본 생성자는 자동으로 생기지 않는다. 그래서 new NegativeBalance() 를 쓰려면 기본 생성자도 적어야 한다.<br>(실습 Vowel\_Check.java 📝 필기 ⑤)
- 💡 main 의 변수 이름 myAcount 는 myAccount 의 오타처럼 보이지만, 문제에 주어진 이름이라 그대로 두었다. (동작에는 영향 없음)
- 💡 printStackTrace() 의 줄 번호는 파일 구성에 따라 달라진다. (문제의 결과는 57, 36 / 처음 작성한 코드는 37, 55)
- 💡 원래 이클립스에서 Test2 클래스로 작성한 코드. 같은 폴더의 다른 문제도 Test2 라서 BankAccountTest 로 이름을 바꿨다.

## 3. `Stack Underflow` / `Stack Overflow`를 `Exception`으로

`11강 과제` · 📄 [`StackTest.java`](StackTest.java)

#### 문제

> 스택(stack)은 먼저 들어온 요소가 먼저 나가는 자료 구조이다. 정수들이 저장된 Stack 클래스를 가정한다. Stack 은 정수 배열을 필드로 가지며, 데이터를 추가하는 push() 와 데이터를 제거하는 pop() 메서드를 가진다. 만약 pop() 메서드가 호출이 되었는데 데이터가 없으면 "Stack Underflow" 예외를 발생시키며, 반대로 데이터가 가득찬 상태에서 push() 메서드가 호출이 되면 "Stack Overflow" 를 발생시키도록 한다. 단, 예외는 새로운 클래스로 정의하지 말고 Exception 클래스를 이용토록 한다.<br>Stack 객체를 main() 안에서 생성하여서 테스트하라. try/catch 블록을 이용하여서 예외를 처리하도록 하라.
>
> ```java
> public class Test2 {
>     public static void main(String[] args) {
>         // Create instances of each vehicle type
>         Stack s = new Stack();
>
>         s.push(3);
>         s.display();
>         s.push(4);
>         s.display();
>         s.pop();
>         s.display();
>         s.pop();
>         s.display();
>         s.pop();
>     }
> }
> ```
>
> 실행 결과 :<br>\>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><br>스택\[0]에 저장된값은 :3<br>&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;<br>(... 생략 ...)<br>Stack\_Underflow: Stack Underflow
>
> ```text
> at Stack.pop(Test2.java:76)
> at Test2.main(Test2.java:41)
> ```

#### 💻 코드

<!-- code: StackTest.java -->
```java
public class StackTest {
    public static void main(String[] args) {
        Stack s = new Stack();

        try {
            s.push(3);
            s.display();
            s.push(4);
            s.display();
            s.pop();
            s.display();
            s.pop();
            s.display();
            s.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Stack {
    private int[] stack;
    private int top;
    private int maxSize;

    public Stack() {
        this.maxSize = 10;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    public Stack(int size) {
        this.maxSize = size;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    public void push(int data) throws Exception {
        if (top >= maxSize - 1) {
            throw new Exception("Stack Overflow");
        }
        stack[++top] = data;
    }

    public int pop() throws Exception {
        if (top < 0) {
            throw new Exception("Stack Underflow");
        }
        return stack[top--];
    }

    public void display() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i <= top; i++) {
            System.out.println("스택[" + i + "]에 저장된값은 :" + stack[i]);
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
}
```
<!-- /code -->

#### 실행 결과 (줄 번호는 이 파일 기준, 맨 아래에 빈 줄 포함)

```text
(java 파일이름.java 로 실행하면 맨 아래에 SourceLauncher 줄이 몇 줄 더 붙는다)
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
스택[0]에 저장된값은 :3
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
스택[0]에 저장된값은 :3
스택[1]에 저장된값은 :4
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
스택[0]에 저장된값은 :3
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

java.lang.Exception: Stack Underflow
    at Stack.pop(StackTest.java:128)
    at StackTest.main(StackTest.java:95)
```

#### 📒 해설

- ⚠ 자주 틀리는 부분 : 스택은 "먼저 들어온 요소가 먼저 나가는" 구조가 아니다. 그건 큐(Queue, FIFO)다.<br>스택은 "나중에 들어온 요소가 먼저 나가는" 구조(LIFO, Last In First Out)다. 접시를 쌓고 맨 위부터 꺼내는 것과 같다.<br>이 코드도 push(3), push(4) 다음 pop() 하면 나중에 넣은 4 가 먼저 빠진다.
- ⚠ 문제의 실행 결과는 "Stack\_Underflow: Stack Underflow" 처럼 별도의 예외 클래스 이름이 찍혀 있지만, 문제 조건은 "새로운 클래스로 정의하지 말고 Exception 을 이용" 하라고 한다. new Exception("Stack Underflow") 를 던지면 실제로는 java.lang.Exception: Stack Underflow 로 출력된다.

**포인트**

- top : 마지막으로 넣은 데이터의 인덱스. 비어 있을 때는 -1 이다.
- push : top >= maxSize - 1 (이미 꽉 참)이면 Stack Overflow. 아니면 stack\[++top] = data; (top 을 먼저 1 늘리고 그 칸에 저장)
- pop  : top &lt; 0 (비어 있음)이면 Stack Underflow. 아니면 return stack\[top--]; (그 칸의 값을 돌려준 뒤 top 을 1 줄임)
- 예외 클래스를 새로 만들지 않고 throw new Exception("Stack Underflow"); 처럼 Exception 에 메시지만 담아서 던진다.<br>Exception 은 Checked 이므로 push, pop 에 throws Exception 이 필요하고, main 은 catch (Exception e) 로 잡는다.
- 세 번째 pop() 에서 스택이 비어 있어서(top == -1) 예외가 난다.

- 💡 ++top 과 top-- 의 차이 (2강 증감 연산자) : ++top 은 먼저 증가시킨 값을 쓰고, top-- 는 지금 값을 쓴 뒤 감소시킨다.
- 💡 pop() 은 꺼낸 값을 돌려주지만 main 에서는 받지 않는다. int x = s.pop(); 처럼 받아서 쓸 수도 있다.
- 💡 pop 한 칸의 값은 배열에 그대로 남아 있지만 top 이 줄었기 때문에 display() 에서는 보이지 않는다.
- 💡 자바에는 이미 java.util.Stack 클래스가 있다. 이 파일은 import 하지 않았기 때문에 직접 만든 Stack 이 쓰인다.<br>(12강 컬렉션에서는 Deque / ArrayDeque 를 스택으로 쓰는 것을 권장한다)
- 💡 printStackTrace() 의 줄 번호는 파일 구성에 따라 달라진다. (처음 작성한 코드는 27, 54)
- 💡 원래 이클립스에서 Test2 클래스로 작성한 코드. 같은 폴더의 다른 문제도 Test2 라서 StackTest 로 이름을 바꿨다.

## 4. 찾는 숫자가 없으면 `NotFound`

`11강 과제` · 📄 [`SearchArrayTest.java`](SearchArrayTest.java)

#### 문제

> 숫자를 저장하고 있는 배열을 받아서 지정된 숫자를 찾는 SearchArray 를 작성하라. 만약 배열 안에 원하는 숫자가 없으면 NotFound 예외를 발생한다. NotFound 클래스를 별도로 정의한다. SearchArray 객체를 main() 안에서 생성하여서 테스트하라.<br>try/catch 블록을 이용하여서 예외를 처리하도록 하라.
>
> ```java
> public class Main {
>     public static void main(String[] args) {
>         // Create instances of each vehicle type
>         Scanner sc = new Scanner(System.in);
>         int input=0;
>         int[] s = new int[]{11,22,33,44,55,66,77,88,99,111};
>         SearchArray sa = new SearchArray(s, 10);
>         sa.display();
>         System.out.print("찾을 값을 입력하세요 : ");
>         input = sc.nextInt(); sc.close();
>         sa.searchNum(input);
>     }
> }
> ```
>
> 배열에 저장된 값은...<br>\[11] \[22] \[33] \[44] \[55] \[66] \[77] \[88] \[99] \[111]<br>찾을 값을 입력하세요 : 11<br>11은 배열안에 존재합니다.
>
> 배열에 저장된 값은...<br>\[11] \[22] \[33] \[44] \[55] \[66] \[77] \[88] \[99] \[111]<br>찾을 값을 입력하세요 : 13<br>NotFound: 원소가 존재하지 않음
>
> ```text
> at SearchArray.searchNum(Test2.java:69)
> at Test2.main(Test2.java:38)
> ```

#### 💻 코드

<!-- code: SearchArrayTest.java -->
```java
import java.util.Scanner;

public class SearchArrayTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int[] s = new int[] {11, 22, 33, 44, 55, 66, 77, 88, 99, 111};
        SearchArray sa = new SearchArray(s, 10);
        sa.display();
        System.out.print("찾을 값을 입력하세요 : ");
        input = sc.nextInt();
        sc.close();
        sa.searchNum(input);
    }
}

class NotFound extends Exception {
    public NotFound(String message) {
        super(message);
    }
}

class SearchArray {
    private int[] arr;
    private int size;

    public SearchArray(int[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    public void display() {
        System.out.println("배열에 저장된 값은...");
        for (int i = 0; i < size; i++) {
            System.out.print("[" + arr[i] + "] ");
        }
        System.out.println();
    }

    public void searchNum(int num) {
        try {
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (arr[i] == num) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println(num + "은 배열안에 존재합니다.");
            } else {
                throw new NotFound("원소가 존재하지 않음");
            }
        } catch (NotFound e) {
            e.printStackTrace();
        }
    }
}
```
<!-- /code -->

#### 실행 결과 (입력 : 33)

```text
배열에 저장된 값은...
[11] [22] [33] [44] [55] [66] [77] [88] [99] [111]
찾을 값을 입력하세요 : 33
33은 배열안에 존재합니다.
```

#### 실행 결과 (입력 : 13, 줄 번호는 이 파일 기준)

```text
(java 파일이름.java 로 실행하면 맨 아래에 SourceLauncher 줄이 몇 줄 더 붙는다)
배열에 저장된 값은...
[11] [22] [33] [44] [55] [66] [77] [88] [99] [111]
찾을 값을 입력하세요 : 13
NotFound: 원소가 존재하지 않음
    at SearchArray.searchNum(SearchArrayTest.java:117)
    at SearchArrayTest.main(SearchArrayTest.java:77)
```

**포인트**

- 주어진 main 에는 try/catch 가 없다. 그래서 searchNum() 안에서 예외를 던지고(throw) 바로 잡아서(catch) 처리했다.<br>(실습 Exception\_OddNumber.java 의 방법 1 과 같은 구조)
- 플래그 변수 found 로 끝까지 찾아본 뒤, 못 찾았을 때만 예외를 던진다. (반복문 안에서 바로 던지면 첫 칸만 보고 예외가 난다)
- catch 에서 e.printStackTrace() 로 예외 종류, 메시지, 발생 위치를 출력한다.

- 💡 searchNum 안에서 예외를 잡았기 때문에 main 이 바뀌지 않아도 된다. 대신 searchNum 에 throws NotFound 를 붙이고 main 에서 try/catch 로 잡는 방법도 있다. 문제의 실행 결과 스택 트레이스에 SearchArray.searchNum 과 Test2.main 이 모두 나오는 것은 그 방식에 가깝다. 두 방법 모두 결과는 같다.
- 💡 "11은", "33은" 처럼 숫자 뒤에 조사를 붙이면 받침에 따라 어색할 수 있다(예 : "22은"). 문제의 출력 형식 그대로 두었다.
- 💡 size 필드 대신 arr.length 를 써도 된다. 생성자에 넘긴 10 이 배열 길이와 다르면 문제가 생길 수 있기 때문이다.
- 💡 sc.close() 를 nextInt() 바로 다음에 했으므로, 그 뒤에는 Scanner 를 다시 쓸 수 없다. (2강)
- 💡 이클립스는 NotFound 줄에 serialVersionUID 노란 경고를 표시한다. 무시해도 된다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 SearchArrayTest 로 이름을 바꿨다.

---

[🏠 11주차 학습 가이드](../../README.md)
