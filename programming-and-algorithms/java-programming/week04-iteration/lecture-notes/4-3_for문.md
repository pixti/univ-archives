# 4-3. 반복문 3: for 문

> 원본: `4-3 반복문3.pptx`
> 관련 코드: [`examples/ForSum.java`](../examples/ForSum.java), [`examples/ForScope.java`](../examples/ForScope.java), [`examples/MultiplicationTableFor.java`](../examples/MultiplicationTableFor.java), [`examples/Factorial.java`](../examples/Factorial.java), [`examples/MultipleSum.java`](../examples/MultipleSum.java), [`examples/MenuCalculatorFor.java`](../examples/MenuCalculatorFor.java), [`quiz/IterationQuiz.java`](../quiz/IterationQuiz.java)

---

## 1. for 문

- while 문과 함께 널리 쓰이는 반복문이다.
- **반복 횟수가 정해져 있을 때** 주로 사용한다.
- **초기식**: 반복문이 실행되기 전에 초기화해야 할 내용을 쓴다. 반복문이 실행되기 전 **딱 한 번** 실행된다.
- **조건을 만족하면 반복 내용을 실행한 후 증감식을 실행**한다.

```java
for (초기식; 반복 조건; 증감식) {
    반복 내용
}
```

| Java | Python |
|---|---|
| `for (초기식; 반복 조건; 증감식) { ... }` | `for 반복변수 in 시퀀스 :` + 들여쓰기 |

실행 순서는 다음과 같다.

```
① 초기식 (한 번만)
② 반복 조건 검사 → false면 종료
③ 반복 내용 실행
④ 증감식 실행
⑤ ②로 돌아감
```

> 참고: **for를 while로 바꾸면**
> ```java
> 초기식;
> while (반복 조건) {
>     반복 내용
>     증감식;
> }
> ```
> while과 for는 표현력이 같다. 퀴즈 2번과 실습 반복문2는 이 대응 관계를 이용하는 문제다.
>
> 💡 **증감식은 반복 내용 "뒤에" 실행된다.** 과제 반복문2-3번(피보나치)에서 이 순서를 착각해 `for (int c = 0; a < 5000; c = a + b)`로 쓰면 첫 반복에서 `b = c`가 0이 되어 수열이 `0 1 0 1 1 2 ...`로 틀어진다. ([`assignment/iteration2/FibonacciFor.java`](../assignment/iteration2/FibonacciFor.java))

---

## 2. 파이썬 for 문을 자바 for 문으로

파이썬으로 작성한 for 문:

```python
sum = 0
for i in range(10, 0, -1):
    sum += i
print("합 : " + str(sum))
```

위의 코드를 자바 for 문으로 코딩하면:

```java
int sum = 0;
for (int i = 10; i > 0; i--) {  // 한줄인 경우 중괄호 생략 가능
    sum += i;
}
System.out.println("합 : " + sum);   // 합 : 55
```

슬라이드 옆에는 이런 형태도 적혀 있다.

```java
for (int sum = 0, i = 10; i > 0; i--)
```

> 참고: **초기식에 여러 개 쓰기**
> - 초기식에는 쉼표(`,`)로 여러 개를 쓸 수 있다. 위처럼 **같은 자료형의 변수 여러 개를 선언**하거나, `i = 1, factorial = 1`처럼 **식 여러 개**를 쓸 수 있다.
> - 하지만 **선언과 식을 섞어 쓸 수는 없다.** `for (System.out.print("n ? "), int n = sc.nextInt(); ...)`는 컴파일 에러다. ([실습 반복문2-1번](../practice/iteration2/ArithmeticMeanFor.java)에서 겪은 에러)
> - 💡 `for (int sum = 0, i = 10; ...)`처럼 sum을 초기식에서 선언하면 sum도 for 문 안에서만 쓸 수 있는 지역 변수가 된다. for 문이 끝난 뒤 `System.out.println("합 : " + sum);`을 쓰면 에러가 난다. 그래서 결과를 반복문 밖에서 쓰려면 sum은 for 문 **앞에서** 선언해야 한다. (다음 절)
> - 반복할 문장이 하나뿐이면 중괄호를 생략할 수 있다. 다만 나중에 문장을 추가하다 실수하기 쉬우므로 붙여 두는 편이 안전하다.

---

## 3. 반복 변수의 범위

**for 문의 초기화 부분에서 선언한 반복 변수는 지역 변수이기 때문에 for 문 안에서만 사용할 수 있다.**

```java
for (int cnt = 1; cnt <= 5; cnt++) {
    System.out.println("사랑합니다.");
}
System.out.println(cnt);    // 오류
```

반복이 끝난 뒤에도 반복 변수를 쓰고 싶다면 for 문 **앞에서** 선언한다.

```java
int cnt;
for (cnt = 1; cnt <= 5; cnt++) {
    System.out.println("사랑합니다.");
}
System.out.println(cnt);    // 6
```

> 참고:
> - 반복이 끝났을 때 cnt는 마지막으로 조건 검사에 실패한 값인 **6**이다.
> - 4-4의 소수 판별(`if (i == n)`)은 이 성질을 이용한다. 반복이 끝난 뒤 i 값을 보고 break로 중간에 나왔는지 끝까지 돌았는지 판단한다. 그래서 거기서는 `int i;`를 for 앞에서 선언한다.
>
> 📝 **필기 (퀴즈 3번 - 선언을 반복문 밖에서 vs 안에서 하는 경우):**
> - 교수님 코드처럼 `int prod;`를 반복문 밖에서 선언하고 안에서 `prod = 1;`로 초기화하면, **반복문이 끝나고도 변수 사용이 가능함.**
> - 반복문 안에서 선언하면 그 반복문 블록이 변수의 범위다. 블록이 끝나면 사라지므로 밖에서 쓰면 에러다.
> - 💡 **선언**(변수를 만드는 것)과 **초기화**(값을 넣는 것)는 별개다. 선언 위치는 "어디까지 쓸 것인가"(범위)를 정하고, 초기화 위치는 "언제 값을 리셋할 것인가"를 정한다. 안쪽 누적 변수는 어디서 선언하든 **바깥 반복이 한 번 돌 때마다 다시 초기화**해야 한다.
> - 💡 반복문 안에서 선언한다고 매번 메모리를 새로 잡아 느려지는 것은 아니다. 성능 차이는 사실상 없으므로 **필요한 범위만큼 좁게** 선언하는 것이 일반적인 권장 사항이다.

---

## 4. 증감식의 여러 형태

보통 반복 변수를 하나씩 증가시키면서 작업한다. 감소시키거나 여러 개씩 증가시키는 형태도 가능하다.

```java
for (i = 1; i <= 10; i++) {     // 하나씩 증가
    sum = sum + i;
}

for (i = 10; i >= 1; i--) {     // 하나씩 감소
    sum = sum + i;
}

for (i = 1; i < 10; i = i + 3) {    // 세개씩 증가
    sum = sum + i;
}
```

| Java | Python | 반복되는 i |
|---|---|---|
| `for (i = 1; i <= 10; i++)` | `for i in range(1, 11)` | 1, 2, …, 10 |
| `for (i = 10; i >= 1; i--)` | `for i in range(10, 0, -1)` | 10, 9, …, 1 |
| `for (i = 1; i < 10; i = i + 3)` | `for i in range(1, 11, 3)` | 1, 4, 7 (자바) / 1, 4, 7, 10 (파이썬) |

> 참고:
> - 파이썬 `range(a, b)`는 **b를 포함하지 않는다.** 그래서 `range(1, 11)` ↔ `i <= 10`(또는 `i < 11`)이다.
> - ⚠ 슬라이드의 세 번째 짝은 정확히 대응하지 않는다. 자바 `i < 10`은 10을 빼고, 파이썬 `range(1, 11, 3)`은 10을 포함한다. 같게 하려면 자바 쪽을 `i <= 10`(또는 `i < 11`)으로 써야 한다.
> - `i = i + 3`은 `i += 3`으로 줄여 쓸 수 있다.

---

## 5. 무한 반복

**반복 조건이 생략되면 항상 참이 되어 무한 반복한다.**

```java
for (;;) {
    반복 내용들
}
```

> 참고:
> - 초기식, 반복 조건, 증감식은 **모두 생략할 수 있다.** 단, 세미콜론 두 개는 반드시 남겨야 한다.
> - `for (;;)`는 `while (true)`와 같다. 보통 안에서 `break`로 빠져나온다.
> - 📝 퀴즈 1-④가 `for (;;) { if (x > 10) break; ... }` 형태였다.
> - 조건만 남기면 `for (; 조건; )`가 되어 사실상 `while (조건)`이다. 과제 반복문2(for만 사용)의 피보나치, 가위바위보에서 이 형태를 썼다.

---

## 6. [실습] 특정 구구단 출력하기

구구단 프로그램(4-1)을 for 문으로 작성한다.

```java
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 단 ? ");
        int dan = sc.nextInt();
        sc.close();
        for (int index = 1; index <= 9; index++) {
            System.out.println(dan + " * " + index + " = " + dan*index);
        }
    }
}
```

> 참고: while 버전의 `int index = 1;`(초기식), `index <= 9`(조건), `index++`(증감식) 세 줄이 for 한 줄로 모였다. 반복 횟수(9번)가 정해져 있으므로 for가 더 읽기 쉽다.

---

## 7. [실습] 팩토리얼 구하기

```java
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int i, factorial;   // 큰숫자는 double형 선언해야 오버플로 발생 x
        for (i = 1, factorial = 1; i <= n; i++) {   // i=n, factorial=1; i >= 1; i--
            factorial = factorial * i;              // 위의 조건식은 감소 방법
        }
        System.out.println("1 ~ " + n + "까지의 곱은 " + factorial + "입니다.");
    }
}
```

```
n의 값을 입력하시오.
5
1 ~ 5까지의 곱은 120입니다.
```

> 참고: **오버플로**
> - int는 약 21억(2,147,483,647)까지만 담을 수 있다. 12! = 479,001,600은 괜찮지만 **13! = 6,227,020,800은 int 범위를 넘어 엉뚱한 값**(1932053504)이 나온다.
> - 슬라이드 주석처럼 double을 쓰면 아주 큰 수까지 근사값으로 담을 수 있다. 정확한 정수가 필요하면 `long`을 쓴다. long은 20!까지 정확하다. 그보다 크면 `java.math.BigInteger`를 쓴다.
> - 주석의 `i = n, factorial = 1; i >= 1; i--`는 n부터 1까지 **감소**하면서 곱하는 방법이다. 곱셈은 순서와 상관없으므로 결과가 같다.
> - 초기식 `i = 1, factorial = 1`은 **식 두 개를 쉼표로 이어 쓴** 것이다. 두 변수는 for 앞에서 미리 선언했다.

---

## 8. [실습] 1에서 n까지 3의 배수의 합 구하기

```java
import java.util.Scanner;

public class MultipleSum {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i, sum = 0;
        for (i = 3; i <= n; i += 3) {
            sum = sum + i;
        }
        System.out.println(n + "까지의 3의 배수의 합은 " + sum + "입니다.");
        sc.close();
    }
}
```

```
n의 값을 입력하시오.
10
10까지의 3의 배수의 합은 18입니다.
```

> 참고: `i`를 1부터 하나씩 올리며 `if (i % 3 == 0)`으로 검사하는 방법도 있다. 하지만 3부터 **3씩 증가**하면 3의 배수만 돌기 때문에 검사가 필요 없고 반복 횟수도 1/3로 줄어든다. 과제 1번(3의 배수 출력)도 같은 방법이다.

---

## 9. [실습] 메뉴 반복 처리하기

앞서 while 문으로 작성한 "메뉴 방식의 사칙 연산"을 for 문으로 바꾼다.

```java
for (boolean cont = true; cont == true; ) {     // 증감문은 생략
    System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료");
    char c = sc.next().charAt(0);

    if (c == 'q') {
        System.out.println("프로그램을 종료하였습니다.");
        cont = false;   // 무한루프를 종료
    }
    else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd')) {
        System.out.println("유효하지 않는 메뉴입니다.");
    }
    else {
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int a = sc.nextInt();
        ...
        System.out.println("결과는 " + result + "입니다.");
    }
}
```

> 참고:
> - 초기식에서 boolean 변수를 선언하고, 증감식은 비웠다. cont의 값은 블록 안에서 바뀐다.
> - `cont == true`는 `cont`와 같다. boolean 변수는 그대로 조건식에 쓸 수 있다.
> - 반복 횟수가 정해지지 않은 문제이므로 for보다 while/do-while이 더 자연스럽다. "for로도 쓸 수 있다"(표현력이 같다)는 것을 보여 주는 예제다.
>
> ⚠ 슬라이드의 `"휴효하지 않는 메뉴입니다."`는 오타다. "유효"로 고쳤다.
