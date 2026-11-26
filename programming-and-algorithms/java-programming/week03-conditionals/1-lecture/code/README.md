# 3주차 강의 예제 코드

[🏠 3주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [Qualification.java](#if-문---복합-조건식-vs-중첩-if-문) | 복합 조건식(`&&`)과 중첩 if 비교 |
| [Grade.java](#else-if-문---점수에-따른-학점-판단) | 점수에 따른 학점 (else if) |
| [Median.java](#실습-3개의-정수-중-중간-값-찾기) | 3개의 정수 중 중간값 |
| [Quadrant.java](#실습-좌표값의-분면-결정하기) | 좌표값의 분면 결정 |
| [Calculator.java](#실습-메뉴-방식의-사칙-연산-if---else-if-버전) | 메뉴 방식의 사칙 연산 (if) |
| [CaseConversion.java](#실습-문자-변환-소문자--대문자-대문자--소문자) | 대문자 ↔ 소문자 변환 |
| [OddEven.java](#실습-홀짝-맞히기) | 홀짝 맞히기 (Random) |
| [FruitType.java](#switch-문---식에-문자열string-변수-사용) | String switch |
| [CalculatorSwitch.java](#실습-메뉴-방식의-사칙-연산-switch-버전) | 메뉴 방식의 사칙 연산 (switch) |
| [Month.java](#실습-월의-일수-맞히기) | 월의 일수 (case 묶기) |

---

## if 문 - 복합 조건식 vs 중첩 if 문

`3-1 조건문1` · 📄 [`Qualification.java`](Qualification.java)

나이가 40 이상 && 키가 170 이상 → "자격이 됩니다"

```text
그렇지 않은 경우              → "자격이 안 됩니다"
```

같은 판단을 두 가지 방법으로 작성해 비교한다.

1) 복합 조건식 : 조건 두 개를 && 로 묶어 if-else 한 번에 처리
2) 중첩 if 문  : if 안에 if 를 넣어 단계적으로 처리

#### 💻 코드

<!-- code: Qualification.java -->
```java
import java.util.Scanner;

public class Qualification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 ? ");
        int age = sc.nextInt();
        System.out.print("키 ? ");
        int height = sc.nextInt();
        sc.close();

        // 1) 복합 조건식
        System.out.print("[복합 조건식] ");
        if (age >= 40 && height >= 170) {
            System.out.println("자격이 됩니다");
        }
        else {
            System.out.println("자격이 안 됩니다");
        }

        // 2) 중첩 if 문 - 실행문이 한 줄이라 중괄호 생략 가능
        System.out.print("[중첩 if 문 ] ");
        if (age >= 40) {
            if (height >= 170)
                System.out.println("자격이 됩니다");
            else
                System.out.println("자격이 안 됩니다");  // 나이는 되지만 키가 미달
        }
        else
            System.out.println("자격이 안 됩니다");      // 나이가 미달
    }
}
```
<!-- /code -->

#### 실행 예

```text
나이 ? 45
키 ? 172
[복합 조건식] 자격이 됩니다
[중첩 if 문 ] 자격이 됩니다
```

#### 📒 해설

- 💡 else 는 "가장 가까운, 짝이 없는 if" 와 짝을 이룬다 (dangling else).<br>중첩할 때는 중괄호로 짝을 분명히 해 두는 것이 안전하다.

## else if 문 - 점수에 따른 학점 판단

`3-1 조건문1` · 📄 [`Grade.java`](Grade.java)

```text
else if 는 "순차적으로 진행" 된다!
 → 어느 조건이 true 이면 그 블록만 실행하고, 다음 조건문들은 실행(검사)되지 않는다.
```

#### 💻 코드

<!-- code: Grade.java -->
```java
import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수 ? ");
        int score = sc.nextInt();
        sc.close();

        // 수정 버전
        if (score >= 90)
            System.out.println("A 학점 입니다");
        else if (score >= 80)       // 여기까지 왔다면 score < 90 은 이미 참
            System.out.println("B 학점 입니다");
        else if (score >= 70)
            System.out.println("C 학점 입니다");
        else if (score >= 60)
            System.out.println("D 학점 입니다");
        else
            System.out.println("F 학점 입니다");
    }
}
```
<!-- /code -->

#### 실행 예

```text
점수 ? 85
B 학점 입니다
```

**첫 번째 버전 (불필요한 조건 포함)**

```java
if (score >= 90) ...A
else if (score < 90 && score >= 80) ...B
else if (score < 80 && score >= 70) ...C
else if (score < 70 && score >= 60) ...D
else ...F
```

→ 두 번째 조건까지 왔다는 것은 이미 score >= 90 이 거짓이라는 뜻.<br>즉 score &lt; 90 은 항상 참이므로 "불필요한 조건 생략!" → 아래 수정 버전

**📝 필기 (퀴즈 3-② 와 연결)**

조건의 "순서" 가 틀리면 논리 오류가 난다.

```java
if (grade >= 2.0) C  else if (grade >= 3.0) B
```

→ 3.0 이상도 첫 조건(>= 2.0)에서 먼저 걸려 C 가 출력된다.<br>→ 이 예제처럼 큰 값부터 검사해야 한다.

## \[실습] 3개의 정수 중 중간 값 찾기

`3-1 조건문1` · 📄 [`Median.java`](Median.java)

#### 💻 코드

<!-- code: Median.java -->
```java
import java.util.Scanner;

public class Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int s1 = sc.nextInt();
        System.out.println("두 번째 숫자 (음수도 가능) >> ");
        int s2 = sc.nextInt();
        System.out.println("세 번째 숫자 (음수도 가능) >> ");
        int s3 = sc.nextInt();
        sc.close();

        int medianVal;
        if (s1 > s2) {
            if (s2 > s3)
                medianVal = s2;     // s1 > s2 > s3
            else if (s3 > s1)
                medianVal = s1;     // s3 > s1 > s2
            else
                medianVal = s3;     // s1 >= s3 >= s2
        }
        else {                      // s2 >= s1
            if (s1 > s3)
                medianVal = s1;     // s2 >= s1 > s3
            else if (s2 < s3)
                medianVal = s2;     // s3 > s2 >= s1
            else
                medianVal = s3;     // s2 >= s3 >= s1
        }
        System.out.println("중간값 : " + medianVal);
    }
}
```
<!-- /code -->

#### 실행 예

```text
첫 번째 숫자 (음수도 가능) >>
5
두 번째 숫자 (음수도 가능) >>
7
세 번째 숫자 (음수도 가능) >>
9
중간값 : 7
```

**풀이 아이디어**

- 먼저 s1 > s2 로 두 수의 대소를 정해 둔다.
- 그다음 s3 가 어디에 끼어드는지 (맨 위 / 가운데 / 맨 아래) 만 따지면 된다.

**💡 다른 풀이: s1 > s2 블록 안을**

```java
if (s2 > s3) s2;  else if (s1 > s3) s3;  else s1;
```

순서로 비교해도 된다. 비교 순서만 다르고 두 방식 모두 정답.

## \[실습] 좌표값의 분면 결정하기

`3-2 조건문2` · 📄 [`Quadrant.java`](Quadrant.java)

- x 나 y 가 0 이면 축 위의 점이라 분면을 판단할 수 없으므로 먼저 걸러낸다.
- return; 은 메소드를 즉시 끝낸다. main 에서 쓰면 프로그램이 그 자리에서 종료된다.<br>(잘못된 입력을 걸러낼 때 자주 쓰는 패턴)

#### 💻 코드

<!-- code: Quadrant.java -->
```java
import java.util.Scanner;

public class Quadrant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("좌표의 x값 >> ");
        int x = sc.nextInt();
        System.out.println("좌표의 y값 >> ");
        int y = sc.nextInt();
        sc.close();

        int qud;
        if (x == 0 || y == 0) {
            System.out.println("x나 y 중 하나가 0이면 분면 판단 불가");
            return;
        }

        // 방법 1) 중첩 if - 비교 횟수가 항상 2번
        if (x > 0) {
            if (y > 0) qud = 1;
            else qud = 4;
        }
        else {
            if (y > 0) qud = 2;
            else qud = 3;
        }

        /*
         * 방법 2) 복합 조건식 + else if - 이해하기 쉬움
         *  하지만 최악의 경우(3분면) 이전 코드보다 많은 비교를 한다.
         *  (x > 0) → (x > 0) → (x < 0, y > 0) 로 총 4번 비교
         *
         *  if (x > 0 && y > 0) qud = 1;
         *  else if (x > 0 && y < 0) qud = 4;
         *  else if (x < 0 && y > 0) qud = 2;
         *  else qud = 3;
         */

        System.out.println("좌표 (" + x + ", " + y + ")의 분면은 "
                + qud + "분면입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
좌표의 x값 >>
4
좌표의 y값 >>
-3
좌표 (4, -3)의 분면은 4분면입니다.
```

#### 📒 해설

- 💡 2주차 과제 Quadrant.java 는 ?: 만으로 풀어서 0 을 처리하지 못했지만,<br>if 문을 배운 지금은 축 위의 점을 따로 처리할 수 있다.

## \[실습] 메뉴 방식의 사칙 연산 (if - else if 버전)

`3-2 조건문2` · 📄 [`Calculator.java`](Calculator.java)

→ switch 버전은 CalculatorSwitch.java (3-3)

#### 💻 코드

<!-- code: Calculator.java -->
```java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int a = sc.nextInt();
        System.out.println("두 번째 숫자 (음수도 가능) >> ");
        int b = sc.nextInt();
        System.out.println("연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈)을 선택하세요.");
        /* Scanner 클래스는 한 글자를 읽어 들이는 메소드가 제공되지 않기 때문에
           next() 메소드로 문자열을 읽은 후
           charAt() 메소드를 이용하여 첫 번째 문자 가져옴 */
        char c = sc.next().charAt(0);
        sc.close();

        double result;
        if (c == 'a') result = a + b;
        else if (c == 's') result = a - b;
        else if (c == 'm') result = a * b;
        else if (c == 'd') result = a / b;   // 💡 정수 나눗셈! (double) a / b 로 쓰면 소수점까지
        else {
            System.out.println("허용되지 않는 문자입니다.");
            return;
        }
        System.out.println("결과는 " + result + "입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
첫 번째 숫자 (음수도 가능) >>
3
두 번째 숫자 (음수도 가능) >>
5
연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈)을 선택하세요.
m
결과는 15.0입니다.
```

**참고) sc.next().charAt(0)**

- sc.next()    : 공백 전까지의 단어 하나를 String 으로 읽는다.
- .charAt(0)   : 그 문자열의 0번째(첫 번째) 글자를 char 로 꺼낸다. (인덱스는 0부터)

**💡 주의할 점**

1) result 는 double 이지만 a / b 는 int 끼리의 나눗셈이다.<br>7 / 2 → 3 이 먼저 계산된 뒤 3.0 으로 저장된다.<br>소수점까지 원하면 (double) a / b 로 써야 한다. (2주차 형변환)
2) b 가 0 인데 'd' 를 고르면 ArithmeticException: / by zero 로 프로그램이 죽는다.
3) result 를 초기화하지 않았는데도 에러가 나지 않는 이유:
  ```text
  else 블록이 return; 으로 끝나므로 출력문까지 오는 모든 경로에서
  ```<br>result 에 값이 대입된다. (확정 대입, definite assignment)

## \[실습] 문자 변환 (소문자 → 대문자, 대문자 → 소문자)

`3-2 조건문2` · 📄 [`CaseConversion.java`](CaseConversion.java)

- 문자는 내부적으로 2Byte 숫자(유니코드)로 표현된다.
- 그래서 코드값을 비교하여 대/소문자를 판별할 수 있다.  (c >= 'a' && c &lt;= 'z')

#### 💻 코드

<!-- code: CaseConversion.java -->
```java
import java.util.Scanner;

public class CaseConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("영문자를 입력하세요 : ");
        char c = sc.next().charAt(0);
        sc.close();

        if (c >= 'a' && c <= 'z') c = (char) (c - 'a' + 'A');        // 소문자 → 대문자
        else if (c >= 'A' && c <= 'Z') c = (char) (c - 'A' + 'a');   // 대문자 → 소문자
        else {
            System.out.println("영문자가 아닙니다.");
            return;
        }
        System.out.println("변환 결과 : " + c);
    }
}
```
<!-- /code -->

#### 실행 예

```text
영문자를 입력하세요 :
B
변환 결과 : b
```

**📝 필기 (실습 조건문1 3번에서 정리)**

- 아스키코드상 A 는 65, ..... , Z 는 90, \[ 는 91, .... , a 는 97, ..... , z 는 122.
- char 타입은 내부적으로 아스키 코드(int) 값으로 저장된다.<br>따라서 두 문자를 빼서 연산하면 알파벳 순서상 떨어져 있는 "거리(알파벳 위치 차이)" 를 구할 수 있다.
- 문자들 간의 거리는 어떻게 구할까?  x = 'B' 라고 하면<br>x - 'A' 를 하면 실제로는 66 - 65 라서 1 이 나온다.
  ```text
  'B' - 'A' → 66 - 65 = 1   (A 로부터 1번째 뒤에 위치)
  ```<br>'Z' - 'A' → 90 - 65 = 25  (A 로부터 25번째 뒤에 위치)
- 대문자 → 소문자 : 'a' + (x - 'A')
    1. x - 'A'   → 'B' - 'A' = 1  (거리 계산)
    2. 'a' + 1   → 97 + 1    = 98
    3. (char) 98 → 'b'
- 소문자 → 대문자는 반대로 'A' + (x - 'a')  (아래 코드의 c - 'a' + 'A' 와 같다)

- 💡 char - char, char + int 의 결과는 int 이다. (연산 시 int 로 자동 형변환)<br>그래서 다시 char 변수에 넣으려면 (char) 로 강제 형변환해야 한다.
- 💡 대문자와 소문자는 항상 32 차이 ('a' - 'A' = 97 - 65 = 32).<br>c + 32 로도 되지만 'a' - 'A' 처럼 의미가 보이게 쓰는 편이 읽기 좋다.

## \[실습] 홀짝 맞히기

`3-3 조건문3` · 📄 [`OddEven.java`](OddEven.java)

#### 💻 코드

<!-- code: OddEven.java -->
```java
import java.util.Random;
import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Random rnd = new Random();
        int quest = rnd.nextInt(100);                 // 무작위로 범위 내 숫자가 나옴 (0 ~ 99)
        char answer = (quest % 2) == 0 ? 'e' : 'o';   // 짝수(even) 'e', 홀수(odd) 'o'

        Scanner sc = new Scanner(System.in);
        System.out.println("짝수라 생각하면 e를, "
                + "홀수라고 생각하면 o를 입력하세요 : ");
        char guess = sc.next().charAt(0);
        sc.close();

        if (guess == answer)
            System.out.println("축하합니다!!!");
        else
            System.out.println("다음 기회에 ...");

        System.out.println("(정답 숫자 : " + quest + ")");  // 확인용으로 추가한 출력
    }
}
```
<!-- /code -->

#### 실행 예

```text
짝수라 생각하면 e를, 홀수라고 생각하면 o를 입력하세요 :
o
축하합니다!!!
```

**참고) 난수(Random) 만들기**

- java.util.Random 을 import 한 뒤 new Random() 으로 객체를 만든다.
- rnd.nextInt(n) : 0 이상 n 미만의 정수.  nextInt(100) → 0 \~ 99<br>(1 \~ 100 을 원하면 rnd.nextInt(100) + 1)
- 다른 방법: (int) (Math.random() \* n)  → 과제 RockPaperScissors.java 에서 사용
- 2주차에 배운 조건 연산자 ?: 로 정답 문자를 한 줄에 결정했다.

- ⚠ 자주 틀리는 부분: 문자열 리터럴은 줄을 넘길 수 없다.<br>안내문을 두 줄에 걸쳐 쓰면 컴파일 에러가 난다. 길면 "..." + "..." 로 나눠 쓴다.

## switch 문 - 식에 문자열(String) 변수 사용

`3-3 조건문3` · 📄 [`FruitType.java`](FruitType.java)

```java
switch (식) {
    case 값1 : 실행문장들1; break;   // break 가 없으면 switch 문 끝까지 실행됨
    ...
    default  : 실행문장들n;
}
```


- if - else if 문과 유사하지만, "조건" 이 아닌 "식의 값" 에 따라 작업을 달리한다.
- Python 에는 없음 (Python 3.10 부터 비슷한 match-case 문이 생겼다)
- 식에는 수식, 문자 변수뿐만 아니라 문자열 변수도 사용 가능 (Java 7 이상)

#### 💻 코드

<!-- code: FruitType.java -->
```java
import java.util.Scanner;

public class FruitType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("과일 이름 ? ");
        String s = sc.next();
        sc.close();

        int type;
        switch (s) { // 여기 - 문자열 변수
            case "apple":
                type = 1;
                break;
            case "banana":
                type = 2;
                break;
            case "carrot":
                type = 3;
                break;
            default:
                type = 4;
        }
        System.out.println("type = " + type);
    }
}
```
<!-- /code -->

#### 실행 예

```text
과일 이름 ? banana
type = 2
```

**참고)**

- switch 식에 쓸 수 있는 자료형: byte, short, char, int (+ 래퍼 클래스), String, enum<br>→ long, float, double, boolean 은 불가
- String switch 는 내부적으로 == 가 아니라 equals() 로 내용을 비교한다.
- case 에는 값 외의 변수나 수식(조건식)이 오지 못한다.
  ```text
  case x : ...        // 오류 (변수)
  case x > 5 : ...    // 오류 (조건식)
  case x == 3 : ...   // 오류 (조건식)
  ```<br>단, final 상수나 case 1 + 2: 같은 "컴파일 시간 상수식" 은 허용된다.

- 💡 실행할 수 있도록 과일 이름을 입력받는 코드를 추가했다.

## \[실습] 메뉴 방식의 사칙 연산 (switch 버전)

`3-3 조건문3` · 📄 [`CalculatorSwitch.java`](CalculatorSwitch.java)

3-2 의 "메뉴 방식의 사칙 연산" 예제(Calculator.java)에서<br>if 문으로 작성된 부분을 switch 문으로 바꾸어 본다.

```java
if (c == 'a') result = a + b;          switch (c) {
else if (c == 's') result = a - b;  →      case 'a' : result = a + b; break;
...                                         ...
else { ...; return; }                      default : ...; return;
                                        }
```

- 같은 변수를 == 로 여러 번 비교하는 if - else if 는 switch 로 바꾸면 더 깔끔하다.
- else 의 역할은 default 가 맡는다.

#### 💻 코드

<!-- code: CalculatorSwitch.java -->
```java
import java.util.Scanner;

public class CalculatorSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int a = sc.nextInt();
        System.out.println("두 번째 숫자 (음수도 가능) >> ");
        int b = sc.nextInt();
        System.out.println("연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈)을 선택하세요.");
        char c = sc.next().charAt(0);
        sc.close();

        double result;
        switch (c) {
            case 'a' : result = a + b; break;
            case 's' : result = a - b; break;
            case 'm' : result = a * b; break;
            case 'd' : result = a / b; break;   // 💡 정수 나눗셈 (Calculator.java 주석 참고)
            default :
                System.out.println("허용되지 않는 문자");
                return;
        }
        System.out.println("결과는 " + result + "입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
첫 번째 숫자 (음수도 가능) >>
3
두 번째 숫자 (음수도 가능) >>
5
연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈)을 선택하세요.
a
결과는 8.0입니다.
```

## \[실습] 월의 일수 맞히기

`3-3 조건문3` · 📄 [`Month.java`](Month.java)

- break 없이 case 를 나열하면 여러 값을 같은 동작으로 묶을 수 있다. (fall-through 활용)
  ```java
  case 1 : case 3 : ... case 12 : days = 31; break;
  ```<br>→ 1 이 들어오면 case 1 로 점프한 뒤, break 를 만날 때까지 아래로 흘러가 days = 31 실행
- default 에서 return; 으로 끝내므로 days 를 초기화하지 않아도 컴파일 에러가 없다. (확정 대입)

#### 💻 코드

<!-- code: Month.java -->
```java
import java.util.Scanner;

public class Month {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("월 (1 ~ 12) ? ");
        int m = sc.nextInt();
        sc.close();

        int days;
        switch (m) {
            case 1 : case 3 :
            case 5 : case 7 :
            case 8 : case 10 :
            case 12 : days = 31; break;
            case 4 : case 6 : case 9 : case 11 :
                days = 30; break;
            case 2 : days = 28; break;
            default :
                System.out.println("허용되지 않는 월입니다.");
                return;
        }
        System.out.println(m + "월은 " + days + "까지 입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
월 (1 ~ 12) ?
3
3월은 31까지 입니다.
```

#### 📒 해설

- 💡 2월은 윤년이면 29일이다.<br>2주차의 윤년식 (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 과 함께 쓰면 연도까지 고려할 수 있다.

---

[🏠 3주차 학습 가이드](../../README.md)
