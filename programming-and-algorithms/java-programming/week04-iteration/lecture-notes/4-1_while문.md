# 4-1. 반복문 1: while 문

> 원본: `4-1 반복문1.pptx`
> 관련 코드: [`examples/WhileTable.java`](../examples/WhileTable.java), [`examples/WhileSum.java`](../examples/WhileSum.java), [`examples/WhileProduct.java`](../examples/WhileProduct.java), [`examples/MultiplicationTableWhile.java`](../examples/MultiplicationTableWhile.java), [`examples/ContinueQuestion.java`](../examples/ContinueQuestion.java), [`examples/ScoreProcessing.java`](../examples/ScoreProcessing.java), [`examples/MenuCalculatorWhile.java`](../examples/MenuCalculatorWhile.java), [`examples/NumberGuessing.java`](../examples/NumberGuessing.java)

이번 주(반복문)에서 배우는 것:

- while 문
- do-while 문
- for 문
- break 문
- continue 문
- 이중 for 문
- foreach 문

---

## 1. while 문

- **while 문과 for 문은 표현력이 동일하다.** 한쪽으로 쓴 코드는 다른 쪽으로도 쓸 수 있다. ([퀴즈 2번](../quiz/IterationQuiz.java)이 while을 for로 바꾸는 문제다.)
- 조건식을 검사해서 **true이면 블록 안의 문장을 실행**하고, 다시 조건식을 검사한다.
- 조건식이 false가 되면 반복을 끝내고 블록 다음 문장으로 넘어간다.

```java
while (조건식) {
    ...
}

while (true) {   // 의도적인 무한루프
    ...
}
```

| Java | Python |
|---|---|
| `while (조건식) { ... }` | `while 조건식 :` + 들여쓰기 |

> 참고: **무한루프**
> - `while (true)`는 조건이 항상 참이라 끝나지 않는다. 일부러 이렇게 쓰고 블록 안에서 `break`(4-4)나 `return`으로 빠져나오는 방식을 자주 쓴다.
> - 반대로 조건식의 변수를 블록 안에서 바꾸지 않으면 **실수로** 무한루프가 된다. 예를 들어 아래 예제에서 `i++`를 빼먹으면 i가 계속 1이라 끝나지 않는다.

---

## 2. 예제: 1 / 10 / 100 표 출력

다음을 출력하는 프로그램을 작성한다.

```
1 10 100
2 20 200
3 30 300
4 40 400
5 50 500
```

```java
int i = 1;
while (i <= 5) {
    System.out.println(i + " " + i*10 + " " + i*100);
    i++;
}
```

반복할 때마다 i가 1, 2, 3, 4, 5로 바뀌면서 **같은 문장** `i, i*10, i*100`이 실행된다.

| 반복 | i | 출력 |
|---|---|---|
| 1회 | 1 | `1 10 100` |
| 2회 | 2 | `2 20 200` |
| 3회 | 3 | `3 30 300` |
| 4회 | 4 | `4 40 400` |
| 5회 | 5 | `5 50 500` |
| — | 6 | 조건 `6 <= 5`가 거짓 → 종료 |

---

## 3. 예제: 1 ~ 5까지의 합

반복문 없이 쓰면 이렇다.

```java
int sum = 0;
sum = sum + 1;  // 1까지 합
sum = sum + 2;  // 2까지 합
sum = sum + 3;  // 3까지 합
sum = sum + 4;  // 4까지 합
sum = sum + 5;  // 5까지 합
```

바뀌는 부분(1 ~ 5)을 변수 i로 바꾸면 매번 `sum = sum + i;`라는 같은 문장이 된다. 그래서 반복문으로 쓸 수 있다.

```java
int i = 1, sum = 0;
while (i <= 5) {        // while (i < 6) { 와 같다
    sum = sum + i;
    i++;
}
System.out.println("합 : " + sum);   // 합 : 15
```

> 참고: **누적 변수의 초기값**
> - 합을 구할 때는 `sum = 0`에서 시작한다. 0은 덧셈의 항등원이다.
> - 곱을 구할 때는 `1`에서 시작해야 한다. 0에서 시작하면 무엇을 곱해도 0이다. (다음 예제)
> - 퀴즈 3번(Σ · Π)에서 이 차이가 그대로 나온다. Σ → `sum = 0`, Π → `prod = 1`.

---

## 4. 예제: 1 ~ 5까지의 곱

```java
int i = 1, sum = 1;     // 곱이므로 1로 초기화
while (i <= 5) {        // while (i < 6) {
    sum = sum * i;
    i++;
}
System.out.println("곱 : " + sum);   // 곱 : 120
```

> ⚠ 슬라이드 코드는 `While( I <= 5)`로 되어 있다. 자바는 대소문자를 구분하므로 `While`(키워드 아님)과 `I`(선언 안 된 변수) 때문에 컴파일 에러가 난다. `while (i <= 5)`로 고쳤다.
>
> ⚠ 슬라이드는 곱을 구하면서도 변수 이름을 `sum`, 출력 문구를 `"합 : "`으로 썼다. 위의 합 예제를 복사한 흔적이다. 코드에서는 출력을 `"곱 : "`으로 바꿨다. ([`examples/WhileProduct.java`](../examples/WhileProduct.java))

---

## 5. [실습] 특정 구구단 출력하기

```java
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        int dan;

        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 단 ? ");
        dan = sc.nextInt();
        sc.close();

        int index = 1;
        while (index <= 9) {
            System.out.println(dan + " * " + index + " = " + dan*index);
            index++;
        }
    }
}
```

```
원하는 단 ? 7
7 * 1 = 7
7 * 2 = 14
...
7 * 9 = 63
```

> 같은 문제를 4-3에서 for 문으로, 4-4에서 이중 for 문(2 ~ 9단 전체)으로 다시 푼다.

---

## 6. 반복 횟수가 정해지지 않은 경우

**while 문은 반복 횟수가 미리 정해지지 않은 경우에 편리하다.** 사용자에게 "계속할지"를 묻는 구조가 대표적이다.

```java
char cont = 'y';    // y로 초기화 하지 않으면 while문 접근 X
Scanner sc = new Scanner(System.in);
while (cont == 'y') {
    // 반복작업 내용
    ...
    System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
    cont = sc.next().charAt(0);
}
```

> 참고:
> - while은 **조건을 먼저 검사**한다. 그래서 첫 반복에 들어가려면 cont가 처음부터 `'y'`여야 한다.
> - 지역 변수는 초기화하지 않으면 사용할 수 없다. `char cont;`만 쓰고 `while (cont == 'y')`를 쓰면 컴파일 에러(`variable cont might not have been initialized`)가 난다.
> - 4-2의 **do-while**로 바꾸면 이 초기화가 필요 없어진다.
> - `sc.next().charAt(0)`: 단어 하나를 읽어 첫 글자를 char로 꺼낸다. (3주차 메뉴 계산기에서 배운 방법)

---

## 7. [실습] 성적 처리

0 ~ 100 사이의 점수를 계속 입력받는다. 범위 밖의 값이 들어오면 입력을 끝내고 평균, 최대값, 최소값을 출력한다.

```java
import java.util.Scanner;

public class ScoreProcessing {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0, max = -1, min = 101;
        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외 값은 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            cnt = cnt + 1;              // 입력 정수의 개수 세기
            sum = sum + val;            // 합 구하기
            if (val > max) max = val;   // 최대값 구하기
            if (val < min) min = val;   // 최소값 구하기
            System.out.println("0과 100 사이의 값을 입력 (그외 값은 종료) : ");
            val = sc.nextInt();
        }
        if (cnt != 0) {
            System.out.println("평균 : " + (double) sum / cnt);
            System.out.println("최대값 : " + max);
            System.out.println("최소값 : " + min);
        }
        sc.close();
    }
}
```

```
0과 100 사이의 값을 입력 (그외 값은 종료) :
30
0과 100 사이의 값을 입력 (그외 값은 종료) :
40
0과 100 사이의 값을 입력 (그외 값은 종료) :
50
0과 100 사이의 값을 입력 (그외 값은 종료) :
-1
평균 : 40.0
최대값 : 50
최소값 : 30
```

> 참고: **이 실습에서 볼 패턴**
> - **입력 → 검사 → 처리 → 다시 입력**: 첫 값을 반복문 **밖에서** 한 번 읽고, 블록의 **마지막**에서 다음 값을 읽는다. 그래야 "종료 값"이 처리(합계 등)에 섞이지 않는다. 실습 1번(산술 평균)도 같은 구조다.
> - **최대값/최소값 초기값**: max는 나올 수 있는 값보다 작은 `-1`, min은 큰 `101`로 시작한다. 그래야 첫 입력이 무조건 max와 min이 된다.
> - **`(double) sum / cnt`**: 형변환이 나눗셈보다 먼저 일어나 실수 나눗셈이 된다. `(double)(sum / cnt)`로 쓰면 정수 나눗셈 결과를 바꾸는 것이라 소수점이 사라진다.
> - **`if (cnt != 0)`**: 처음부터 범위 밖의 값을 넣으면 cnt가 0이다. 0으로 나누는 것을 막는다.

---

## 8. [실습] 메뉴 반복 처리하기: 조건문 실습에 반복 추가

3주차의 "메뉴 방식의 사칙 연산"을 `q`를 누를 때까지 반복하도록 바꾼다.

```java
...
boolean cont = true; char c;
while (cont) {  // cont가 false 될때 까지 무한 루프
    System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료");
    c = sc.next().charAt(0);

    if (c == 'q') {
        System.out.println("프로그램을 종료하였습니다.");
        cont = false;
    }
    else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd')) {
        System.out.println("유효하지 않는 메뉴입니다.");
    }
    else {
        ... // 생략
    }
}
```

```
연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료)을 선택하세요.
a
첫 번째 숫자 (음수도 가능) >>
3
두 번째 숫자 (음수도 가능) >>
7
결과는 10.0입니다.
연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료)을 선택하세요.
q
프로그램을 종료하였습니다.
```

> 참고:
> - **boolean 플래그로 반복 제어**: `cont`가 true인 동안 돌다가 `q`가 들어오면 false로 바꾼다. 그러면 다음 조건 검사에서 빠져나온다.
> - 실행 화면 캡처의 코드는 `while(true)` + `break;`(q일 때), `continue;`(잘못된 메뉴일 때)로 되어 있다. break와 continue는 4-4에서 배운다. 플래그 방식과 결과는 같다.
> - 생략된 부분(숫자 두 개 입력 → 계산 → 출력)은 [`examples/MenuCalculatorWhile.java`](../examples/MenuCalculatorWhile.java)에 채워 넣었다.
>
> ⚠ 슬라이드의 `"휴효하지 않는 메뉴입니다."`와 주석의 `문한 루프`는 오타다. "유효", "무한"으로 고쳤다.

---

## 9. [실습] 숫자 맞히기 게임

1 ~ 100 사이의 무작위 숫자를 맞힐 때까지 반복한다.

```java
import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        int answer = (new Random()).nextInt(100) + 1;   // 1~100 무작위 숫자
        int guess;
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        while (cont) {  // 정답이 될 때 까지 무한 루프
            System.out.println("예측값 ? ");
            guess = sc.nextInt();
            if (guess > answer) System.out.println("정답보다 크다");
            else if (guess < answer) System.out.println("정답보다 작다");
            else {
                System.out.println("정답!!!");
                cont = false;
            }
        }
        sc.close();
    }
}
```

```
예측값 ?
50
정답보다 크다
예측값 ?
25
정답보다 작다
...
예측값 ?
37
정답!!!
```

> 참고:
> - `(new Random()).nextInt(100)`은 0 ~ 99이므로 `+ 1`을 해서 1 ~ 100으로 만든다. (3주차 홀짝 맞히기에서 배운 방법)
> - 몇 번 만에 맞힐지 모르므로 **반복 횟수가 정해지지 않은 경우**다. 그래서 while이 어울린다.
> - 4-2에서 "게임을 계속할지"를 묻는 바깥 반복문(do-while)을 추가한다.
