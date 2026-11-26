# 3주차 과제 · conditionals2

[🏠 3주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [RockPaperScissors.java](#1-가위바위보-mathrandom) | 1. 가위바위보 (`Math.random`) |
| [MenuCalculator.java](#2-메뉴-방식-계산기-switch) | 2. 메뉴 방식 계산기 (switch) |
| [VowelSwitch.java](#3-모음자음-구분-switch) | 3. 모음/자음 구분 (switch) |
| [Weekday.java](#4-숫자--요일-switch) | 4. 숫자 → 요일 (switch) |
| [DayToEnglish.java](#5-한글-요일--영어-요일-string-switch) | 5. 한글 요일 → 영어 요일 (String switch) |

---

## 1. 가위바위보 (`Math.random`)

`3강 과제` · 📄 [`RockPaperScissors.java`](RockPaperScissors.java)

#### 문제

> 컴퓨터와 가위, 바위, 보 게임을 하는 프로그램을 작성하라.<br>컴퓨터는 사용자에게 알리지 않고 가위, 바위, 보 중에서 임의로 하나를 선택하는데, 0 \~ 2 사이의 랜덤 정수로 구현하며, 0 이면 가위, 1 이면 바위, 2 면 보로 취급한다.

#### 💻 코드

<!-- code: RockPaperScissors.java -->
```java
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자에게 가위, 바위, 보 중 하나를 입력받는다.
        System.out.print("가위(0), 바위(1), 보(2)를 선택 : ");
        int userChoice = sc.nextInt();

        // 사용자가 0, 1, 2 이외의 값을 입력했는지 확인한다.
        if (userChoice < 0 || userChoice > 2) {
            System.out.println("잘못된 입력입니다.");
            sc.close();
            return;
        }

        // 0 ~ 2 중 하나를 랜덤으로 선택한다.
        // 0 = 가위, 1 = 바위, 2 = 보
        int computerChoice = (int) (Math.random() * 3);

        // 컴퓨터가 무엇을 선택했는지 출력한다.
        if (computerChoice == 0) {
            System.out.println("컴퓨터는 가위를 내서");
        }
        else if (computerChoice == 1) {
            System.out.println("컴퓨터는 바위를 내서");
        }
        else {
            System.out.println("컴퓨터는 보를 내서");
        }

        // 사용자와 컴퓨터가 같은 것을 냈다면 무승부이다.
        if (userChoice == computerChoice) {
            System.out.println("사용자가 비겼습니다.");
        }
        // 사용자가 이기는 세 가지 경우
        else if ((userChoice == 0 && computerChoice == 2) ||   // 가위 vs 보
                 (userChoice == 1 && computerChoice == 0) ||   // 바위 vs 가위
                 (userChoice == 2 && computerChoice == 1)) {   // 보 vs 바위
            System.out.println("사용자가 이겼습니다.");
        }
        // 무승부도 아니고 사용자가 이긴 것도 아니라면 컴퓨터의 승리이다.
        else {
            System.out.println("컴퓨터가 이겼습니다.");
        }

        // 사용자가 선택한 값과 컴퓨터가 선택한 값을 확인한다.
        System.out.println("user : " + userChoice + " com : " + computerChoice);

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
가위 (0),바위(1),보(2) 를 선택하세요 : 0
컴퓨터는 보를 내서 사용자가 이겼습니다.!!
user : 0, com : 2
```

#### 이 코드 실행 예

```text
가위(0), 바위(1), 보(2)를 선택 : 1
컴퓨터는 보를 내서
컴퓨터가 이겼습니다.
user : 1 com : 2
```

**포인트**

- 잘못된 입력(0 \~ 2 이외)을 먼저 걸러서 return; 으로 종료한다.
- 승패 판정은 3가지로 나눈다.
    1. 같으면 무승부
    2. 사용자가 이기는 3가지 경우를 || 로 묶어서 검사
    3. 나머지는 모두 컴퓨터 승리 → else

- 💡 (int) (Math.random() \* 3)
  - Math.random() 은 0.0 이상 1.0 미만의 double → \* 3 하면 0.0 이상 3.0 미만
  - (int) 로 소수점을 버리면 0, 1, 2 중 하나
  - 괄호가 중요하다! (int) Math.random() \* 3 으로 쓰면 형변환이 먼저 되어<br>(int) 0.xxx = 0 → 0 \* 3 = 0. 컴퓨터가 항상 가위만 낸다.
  - java.util.Random 을 쓰면 new Random().nextInt(3) 으로 같은 결과 (1-lecture/code/OddEven.java 참고)
- 💡 이기는 조건을 수식 하나로 쓸 수도 있다 : (userChoice - computerChoice + 3) % 3 == 1 이면 사용자 승리.<br>(바위(1) - 가위(0) = 1, 보(2) - 바위(1) = 1, 가위(0) - 보(2) + 3 = 1)

## 2. 메뉴 방식 계산기 (switch)

`3강 과제` · 📄 [`MenuCalculator.java`](MenuCalculator.java)

#### 문제

> 간단한 계산기 프로그램을 작성하여 보자. (switch 문 사용)<br>먼저 사용자로부터 하나의 연산 문자 (+, -, \*, /, Q) 를 입력받는다.<br>이어서 사용자로부터 2개의 숫자를 입력 받는다.<br>연산 문자에 맞는 계산을 한 후 그 결과를 출력한다. 연산 문자 중 Q 는 프로그램 종료를 의미한다.<br>→ 실습 조건문1 2번 (3-practice/conditionals1/SimpleCalculatorSwitch.java) 과 같은 문제. 실습 버전과 비교해 보기.

#### 💻 코드

<!-- code: MenuCalculator.java -->
```java
import java.util.Scanner;

public class MenuCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 계산기 메뉴 출력
        System.out.println("*******************");
        System.out.println("+ ------- 덧셈");
        System.out.println("- ------- 뺄셈");
        System.out.println("* ------- 곱셈");
        System.out.println("/ ------- 나눗셈");
        System.out.println("Q ------- Quit");
        System.out.println("*******************");

        // 연산자 입력
        System.out.print("연산 선택 : ");
        char operator = sc.next().charAt(0);

        // Q 또는 q를 입력하면 프로그램 종료
        if (operator == 'Q' || operator == 'q') {
            System.out.println("프로그램을 종료합니다.");
            sc.close();
            return;
        }

        // 입력된 연산자가 올바른 연산자인지 확인
        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            System.out.println("잘못된 연산자입니다.");
            sc.close();
            return;
        }

        // 두 정수 입력
        System.out.print("두 수를 공백으로 분리하여 입력하시오 : ");
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();

        // 입력된 연산자에 따라 계산
        switch (operator) {
            case '+':
                System.out.println(firstNumber + secondNumber);
                break;
            case '-':
                System.out.println(firstNumber - secondNumber);
                break;
            case '*':
                System.out.println(firstNumber * secondNumber);
                break;
            case '/':
                // 0으로 나누는 경우를 방지
                if (secondNumber == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                else {
                    System.out.println(firstNumber / secondNumber);
                }
                break;
        }

        sc.close();
    }
}
```
<!-- /code -->

#### 이 코드 실행 예

```text
연산 선택 : +
두 수를 공백으로 분리하여 입력하시오 : 6 4
10
```

**실습 버전에서 달라진 점**

- 연산자가 올바른지 숫자를 입력받기 "전에" 먼저 검사한다.<br>→ 잘못된 연산자를 입력하면 숫자를 입력할 필요 없이 바로 종료된다.
- 그래서 switch 안에 default 가 필요 없어졌다. (이미 +, -, \*, / 만 남았으므로)
- 변수 이름을 firstNumber, secondNumber 처럼 의미가 드러나게 지었다.

- 💡 "+, -, \*, / 중 어느 것도 아니다" 는 != 를 && 로 묶는다.<br>operator != '+' && operator != '-' && operator != '\*' && operator != '/'<br>|| 로 묶으면 어떤 문자든 최소 하나와는 다르므로 항상 참이 되어 버린다.<br>(드 모르간 법칙 : !(A || B) == !A && !B)

문제의 실행 예 : 실습 버전(SimpleCalculatorSwitch.java) 주석 참고

## 3. 모음/자음 구분 (switch)

`3강 과제` · 📄 [`VowelSwitch.java`](VowelSwitch.java)

#### 문제

> switch 문을 사용하여 키보드에서 문자 하나를 읽어서 모음과 비모음을 구분하는 프로그램을 작성하여 보자.<br>→ 실습 조건문1 4번 (3-practice/conditionals1/VowelCheck.java) 을 switch 로 다시 푼 문제.

#### 💻 코드

<!-- code: VowelSwitch.java -->
```java
import java.util.Scanner;

public class VowelSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자 하나를 입력받는다.
        System.out.print("문자 입력 : ");
        char inputChar = sc.next().charAt(0);

        // 대문자와 소문자를 구분하지 않기 위해 소문자로 변환한다.
        inputChar = Character.toLowerCase(inputChar);

        // 입력된 문자가 영문자인지 먼저 확인한다.
        if (inputChar < 'a' || inputChar > 'z') {
            System.out.println("영문자를 입력하세요.");
        }
        else {
            // 영문자인 경우 모음인지 확인한다.
            switch (inputChar) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("입력하신 문자는 모음입니다.");
                    break;

                // a, e, i, o, u가 아닌 영문자는 자음이다.
                default:
                    System.out.println("입력하신 문자는 자음입니다.");
                    break;
            }
        }

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예  (입력 : I)

```text
입력하신 문자는 모음입니다.!!^^
```

#### 이 코드 실행 예

```text
문자 입력 : i
입력하신 문자는 모음입니다.
```

**포인트**

- Character.toLowerCase() 로 먼저 소문자로 바꿨다.<br>→ 실습 때 필기한 팁 그대로. case 를 10개가 아니라 5개만 나열하면 된다.
- switch 는 "범위" 를 표현할 수 없으므로 영문자인지 검사는 switch 앞의 if 로 따로 했다.<br>→ 숫자나 기호를 입력했을 때 default 에서 "자음" 이라고 잘못 출력하는 것을 막는다.
- case 'a': case 'e': ... 처럼 break 없이 나열 → 5개의 값을 하나의 동작으로 묶는다 (fall-through).

- 💡 inputChar &lt; 'a' || inputChar > 'z' : "a \~ z 범위 밖" 은 || 로 쓴다.<br>(범위 안 : 'a' &lt;= c && c &lt;= 'z'  ↔  범위 밖 : c &lt; 'a' || c > 'z')

## 4. 숫자 → 요일 (switch)

`3강 과제` · 📄 [`Weekday.java`](Weekday.java)

#### 문제

> 사용자로부터 1에서 7 사이의 정수를 입력받아 그에 해당하는 요일을 표시하는 프로그램을 작성하라. (switch 문 사용)

#### 💻 코드

<!-- code: Weekday.java -->
```java
import java.util.Scanner;

public class Weekday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자에게 요일 번호를 입력받는다.
        // 1 = 월요일, 2 = 화요일, ..., 7 = 일요일
        System.out.print("정수 입력 : ");
        int dayNumber = sc.nextInt();

        // 입력된 숫자에 해당하는 요일을 출력한다.
        switch (dayNumber) {
            case 1:
                System.out.println("월요일");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                break;
            case 6:
                System.out.println("토요일");
                break;
            case 7:
                System.out.println("일요일");
                break;

            // 1~7 이외의 값이 입력된 경우
            default:
                System.out.println("유효한 값이 아님.");
        }

        // Scanner 사용 종료
        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
입력 숫자: 3
해당 요일 : 수요일
```

#### 이 코드 실행 예

```text
정수 입력 : 2
화요일
```

**포인트**

- "정수 값 하나가 여러 값 중 무엇과 같은지" 를 고르는 전형적인 switch 문제.
- case 마다 break 를 빠뜨리면 아래 요일까지 모두 출력된다 (fall-through).<br>예) case 1 에 break 가 없으면 1 입력 시 "월요일" 다음에 "화요일" 도 출력.
- 1 \~ 7 이외의 값은 default 에서 처리한다.

- 💡 if-else if 로 쓰면 dayNumber == 1, dayNumber == 2, ... 를 7번 반복해야 한다.<br>switch 가 훨씬 읽기 쉽다.

## 5. 한글 요일 → 영어 요일 (String switch)

`3강 과제` · 📄 [`DayToEnglish.java`](DayToEnglish.java)

#### 문제

> 영어 요일을 한글 요일로 출력해 주는 프로그램을 작성하라. (switch 문 사용)

#### 💻 코드

<!-- code: DayToEnglish.java -->
```java
import java.util.Scanner;

public class DayToEnglish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 한글 요일을 입력받는다.
        System.out.print("입력 요일 : ");
        String inputDay = sc.next();

        // 입력받은 한글 요일에 대응하는 영어 요일을 저장한다.
        String englishDay;

        switch (inputDay) {
            case "월요일":
                englishDay = "Monday";
                break;
            case "화요일":
                englishDay = "Tuesday";
                break;
            case "수요일":
                englishDay = "Wednesday";
                break;
            case "목요일":
                englishDay = "Thursday";
                break;
            case "금요일":
                englishDay = "Friday";
                break;
            case "토요일":
                englishDay = "Saturday";
                break;
            case "일요일":
                englishDay = "Sunday";
                break;

            // 위의 어떤 요일에도 해당하지 않는 경우
            default:
                englishDay = "잘못된 요일입니다.";
        }

        // switch에서 결정된 영어 요일을 출력한다.
        System.out.println("출력 요일 : " + englishDay);

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
입력 요일 : 월요일
출력 요일 : Monday
```

#### 이 코드 실행 예

```text
입력 요일 : 화요일
출력 요일 : Tuesday
```

#### 📒 해설

- ⚠ 문제 문장은 "영어 → 한글" 인데, 문제의 실행 예는 "월요일 → Monday" (한글 → 영어) 이다.<br>실행 예를 기준으로 한글 요일을 입력받아 영어 요일을 출력하도록 작성했다.

**포인트**

- switch 식에 String 을 쓸 수 있다. (Java 7 이상)
- String switch 는 내부적으로 == 가 아니라 equals() 로 "내용" 을 비교한다.<br>→ sc.next() 로 입력받은 문자열도 case "월요일" 과 제대로 비교된다.<br>(if 문으로 쓸 때는 inputDay == "월요일" 이 아니라 inputDay.equals("월요일") 로 써야 한다)
- 결과를 switch 안에서 바로 출력하지 않고 englishDay 변수에 저장한 뒤, switch 밖에서 한 번만 출력했다.

- 💡 englishDay 를 초기화하지 않았지만 default 를 포함한 모든 갈래에서 값을 대입하므로 컴파일 에러가 나지 않는다.<br>default 를 지우면 "variable englishDay might not have been initialized" 에러가 난다. (확정 대입)

---

[🏠 3주차 학습 가이드](../../README.md)
