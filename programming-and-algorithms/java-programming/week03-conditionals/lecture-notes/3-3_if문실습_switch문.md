# 3-3. 조건문 3: if 문 실습 · switch 문

> 원본: `3-3 조건문3.pptx`
> 관련 코드: [`examples/OddEven.java`](../examples/OddEven.java), [`examples/FruitType.java`](../examples/FruitType.java), [`examples/CalculatorSwitch.java`](../examples/CalculatorSwitch.java), [`examples/Month.java`](../examples/Month.java), [`quiz/ConditionalQuiz.java`](../quiz/ConditionalQuiz.java)

---

## 1. [실습] 홀짝 맞히기

```java
import java.util.Random;
import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Random rnd = new Random();
        int quest = rnd.nextInt(100);              // 무작위로 범위 내 숫자가 나옴 (0 ~ 99)
        char answer = (quest % 2) == 0 ? 'e' : 'o'; // 짝수(even)면 'e', 홀수(odd)면 'o'

        Scanner sc = new Scanner(System.in);
        System.out.println("짝수라 생각하면 e를, 홀수라고 생각하면 o를 입력하세요 : ");
        char guess = sc.next().charAt(0);
        sc.close();

        if (guess == answer)
            System.out.println("축하합니다!!!");
        else
            System.out.println("다음 기회에 ...");
    }
}
```

```
짝수라 생각하면 e를, 홀수라고 생각하면 o를 입력하세요 :
o
축하합니다!!!
```

> 참고: **난수(Random) 만들기**
> - `java.util.Random`을 `import`한 뒤 `new Random()`으로 객체를 만든다.
> - `rnd.nextInt(n)`은 **0 이상 n 미만**의 정수를 돌려준다. `nextInt(100)`이면 0 ~ 99이다.
> - 1 ~ 100을 원하면 `rnd.nextInt(100) + 1`로 쓴다.
> - 다른 방법으로 `(int) (Math.random() * n)`이 있다. `Math.random()`은 0.0 이상 1.0 미만의 double이다. 이 방법은 [과제: 가위바위보](../assignment/conditionals2/RockPaperScissors.java)에서 썼다.
> - 2주차에 배운 **조건 연산자 `?:`**로 정답 문자를 한 줄에 정했다.
>
> ⚠ 슬라이드는 출력 문자열 `"짝수라 생각하면 e를, (줄바꿈) 홀수라고..."`를 두 줄에 걸쳐 썼다. 자바 문자열 리터럴은 줄을 넘길 수 없어 컴파일 에러가 난다. 한 줄로 합쳤다. 길면 `"..." + "..."`로 나눠 쓴다.

---

## 2. switch 문

> **Python에는 없음** (참고: Python 3.10부터 비슷한 `match-case` 문이 생겼다.)

if-else if 문과 비슷한 조건문이다. 다만 **조건이 아니라 식의 값**에 따라 작업을 나눈다.

```java
switch (식) {
    case 값1 :
        실행문장들1;
        break;      // 없으면 switch 문 끝까지 실행됨
    case 값2 :
        실행문장들2;
        break;
    ...
    case 값m :
        실행문장들m;
        break;
    default :
        실행문장들n;
}
```

- `식`의 값과 일치하는 `case`로 **점프**해서 그 아래부터 실행한다.
- `break`를 만나면 switch 문을 빠져나간다.
- 일치하는 case가 없으면 `default`를 실행한다. `default`는 생략할 수 있다.

위 switch 문을 굳이 if-else if 문으로 바꾸면 아래와 같다.

```java
if (식 == 값1) {
    실행문장들1;
}
else if (식 == 값2) {
    실행문장들2;
}
...
else if (식 == 값m) {
    실행문장들m;
}
else {
    실행문장들n;
}
```

> 📝 **필기 (퀴즈 · 조건문 4번):** "`default :`로 else를 표현함."
> 처음에는 `else`에 해당하는 출력문을 switch 밖에 두었다. 그래서 0, 1, 2일 때도 "그외"가 출력되어 **오답** 처리되었다. else 역할은 switch 안의 `default`가 맡는다.
> → [`quiz/ConditionalQuiz.java`](../quiz/ConditionalQuiz.java)

### break가 없으면? (fall-through)

`break`가 없으면 일치한 case부터 **아래 case들을 계속 실행**한다(fall-through).

> 📝 **필기 (퀴즈 · 조건문 5번):** `x = 0, y = 1, z = 2`일 때 아래 코드를 실행하면?
> ```java
> switch (x) {
>     case 0 :
>         x = 1;
>         y = 2;      // break 없음 → case 1 로 계속 내려감
>     case 1 :
>         z = 3;
>         break;
> }
> ```
> → **x = 1, y = 2, z = 3**이다.
> 주의: case 0에서 `x = 1`로 바꿨다고 case 1로 "다시 점프"하는 것이 아니다. switch는 **처음 한 번만** 식의 값을 보고 점프한다. 그 뒤에는 break 없이 아래로 흘러간 것이다.

이 성질을 이용하면 **여러 case를 하나로 묶을** 수 있다(아래 [월의 일수](#4-실습-월의-일수-맞히기) 예제 참고).

### 식에 쓸 수 있는 자료형

식에는 수식과 문자 변수뿐 아니라 **문자열 변수도 쓸 수 있다**(Java 7 이상).

```java
String s;
int type;
switch (s) {            // 여기
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
```

> 참고:
> - switch 식에 쓸 수 있는 자료형은 `byte`, `short`, `char`, `int`, 그리고 각각의 래퍼 클래스, `String`, `enum`이다.
> - **`long`, `float`, `double`, `boolean`은 쓸 수 없다.**
> - String switch는 내부적으로 `==`가 아니라 **`equals()`**로 내용을 비교한다. 그래서 `sc.next()`로 입력받은 문자열도 제대로 비교된다.
>   → [`assignment/conditionals2/DayToEnglish.java`](../assignment/conditionals2/DayToEnglish.java)
>
> → [`examples/FruitType.java`](../examples/FruitType.java)

### case에 올 수 없는 것

case에는 **값 이외의 변수나 수식(조건식)이 올 수 없다.**

```java
// 아래 코드들은 오류
case x : ...        // 변수
case x > 5 : ...    // 조건식
case x == 3 : ...   // 조건식
```

> 참고:
> - case 값은 **컴파일할 때 값이 정해지는 상수**여야 한다. 그래서 `final int MAX = 3;`처럼 상수로 선언한 이름이나 `case 1 + 2:`(상수식)는 허용된다.
> - 같은 값을 가진 case가 두 개 있으면 컴파일 에러가 난다.
> - "x가 5보다 크면"처럼 **범위 조건**은 switch로 표현할 수 없다. 이런 경우는 if-else if를 쓴다(예: 학점, 소득세 계산).

> 💡 **switch 안의 변수 선언:** switch 문 전체가 **하나의 블록 `{ }`**이다. 그래서 case 아래에서 선언한 변수의 범위(scope)는 switch 블록 전체가 된다. 다른 case에서 같은 이름으로 또 선언하면 "이미 정의된 변수" 에러가 난다. 실습·과제에서 case마다 `r_width`, `t_width`처럼 변수 이름을 다르게 지은 이유다. 각 case를 `{ }`로 감싸면 같은 이름을 써도 된다.
> → [`practice/conditionals2/AreaCalculator.java`](../practice/conditionals2/AreaCalculator.java)

> 💡 참고: **향상된 switch (Java 14+)**. 수업 범위 밖이지만 알아 두면 편하다.
> ```java
> switch (c) {
>     case 'a' -> result = a + b;    // 화살표(->)를 쓰면 break 가 필요 없다 (fall-through 없음)
>     case 's' -> result = a - b;
>     default  -> System.out.println("허용되지 않는 문자");
> }
> int days = switch (m) {             // switch 를 '식'으로 써서 값을 돌려받을 수도 있다
>     case 1, 3, 5, 7, 8, 10, 12 -> 31;
>     case 4, 6, 9, 11 -> 30;
>     case 2 -> 28;
>     default -> -1;
> };
> ```

---

## 3. [실습] 메뉴 방식의 사칙 연산 (switch 버전)

[3-2의 "메뉴 방식의 사칙 연산"](3-2_if문실습.md#2-실습-메뉴-방식의-사칙-연산) 예제에서 if 문으로 작성한 부분을 아래처럼 바꿔 본다.

```java
switch (c) {
    case 'a' : result = a + b; break;
    case 's' : result = a - b; break;
    case 'm' : result = a * b; break;
    case 'd' : result = a / b; break;
    default :
        System.out.println("허용되지 않는 문자");
        return;
}
```

> - `c == 'a'`처럼 **같은 변수를 `==`로 여러 번 비교하는 if-else if**는 switch로 바꾸면 더 깔끔하다.
> - 한 줄에 `case 'a' : 실행문; break;`처럼 써도 된다.

→ [`examples/CalculatorSwitch.java`](../examples/CalculatorSwitch.java)

---

## 4. [실습] 월의 일수 맞히기

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

```
월 (1 ~ 12) ?
3
3월은 31까지 입니다.
```

> - break 없이 case를 나열하면 **여러 값을 같은 동작으로 묶을** 수 있다(fall-through 활용).
> - `default`에서 `return;`으로 끝내기 때문에 `days`를 초기화하지 않아도 컴파일 에러가 나지 않는다(확정 대입).
> - 💡 2월은 윤년이면 29일이다. 2주차에 배운 윤년식 `(year % 4 == 0 && year % 100 != 0) || year % 400 == 0`과 함께 쓰면 연도까지 고려할 수 있다.

→ [`examples/Month.java`](../examples/Month.java)

---

## 정리: if vs switch

| | if - else if | switch |
|---|---|---|
| 판단 기준 | **조건식** (boolean) | **식의 값** (정수, 문자, 문자열, enum) |
| 범위 조건 (`score >= 90`) | 가능 | 불가능 |
| 여러 값 중 하나와 같은지 | 가능 (`==` 반복) | **깔끔함** (case 나열) |
| 나머지 경우 | `else` | `default` |
| 주의 | 조건 **순서** (위에서부터 검사) | **break** 누락 시 fall-through |
