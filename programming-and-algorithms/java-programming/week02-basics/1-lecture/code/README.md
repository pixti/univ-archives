# 2주차 강의 예제 코드

[🏠 2주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [ProgramBasic.java](#프로그램-및-클래스-구성---메인-메소드) | main 메소드와 명령행 인수 |
| [VariablesTest.java](#변수와-자료형---변수-저장-예제) | 기본 자료형 8가지, String 생성 |
| [SayHello.java](#실습-사용자-이름을-입력-받아-인사말-출력하기) | 이름을 입력받아 인사말 출력 |
| [Assignment.java](#자료형-변환---자동-형변환-예제) | char ↔ int 형변환 |
| [IntegerToTime.java](#실습-임의의-양의-정수값을-시분초로-변환하기) | 초 → 시·분·초 |
| [SumNAvg.java](#실습-3명의-학생의-성적을-입력-받아-총점-및-평균-구하기) | 성적 3개의 합계와 평균 |
| [Overflow.java](#오버플로우와-언더플로우---예제) | 오버플로우와 언더플로우 |
| [BitOperation.java](#실습-비트-연산자-실습하기) | 비트 논리 연산 |
| [ShiftOperation.java](#실습-시프트-연산자-실습하기) | 시프트 연산 |
| [RelationOperation.java](#실습-관계-연산자-실습하기) | 관계 연산 |
| [LogicOperation.java](#실습-논리-연산자-실습하기) | 논리 연산 |
| [IncDecOperation.java](#실습-증감-연산자-실습하기) | 증감 연산 |
| [ConditionOperation.java](#실습-조건-연산자-실습하기) | 조건 연산 (절대값, 최대값) |

---

## 프로그램 및 클래스 구성 - 메인 메소드

`2-1 변수와 자료형1` · 📄 [`ProgramBasic.java`](ProgramBasic.java)

이클립스에서 ProgramBasic 클래스를 정의할 때 자동으로 생성해주는 코드.

#### 💻 코드

<!-- code: ProgramBasic.java -->
```java
public class ProgramBasic {
    public static void main(String[] args) {
        // 이 부분은 한 줄짜리 주석
        /* 이 부분은
           여러 줄짜리
           주석 */

        // 명령행 인수 확인용 (추가 코드)
        // 실행 예) java ProgramBasic.java aaa bbb
        System.out.println("전달된 인수 개수 : " + args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
```
<!-- /code -->

**main 메소드**

- 프로그램을 구성하는 클래스 중 적어도 한 클래스에서 main 메소드를 제공해야 한다.
- public        : 외부(JVM)에서 호출 가능
- static        : 객체 생성 없이 호출할 수 있음을 의미
- void          : 반환값 없음
- String\[] args : 실행 파일명과 함께 주어지는 인라인(명령행) 인수를 받아들여 사용할 수 있게 함<br>예) java ProgramBasic aaa bbb  →  args\[0] = "aaa", args\[1] = "bbb"

**⚠ 자주 틀리는 부분**

- C 처럼 public static int main(...) 으로 쓰면 컴파일은 되지만 실행되지 않는다.<br>("Main method not found") main 의 반환형은 반드시 void 다.
- JDK 25 부터는 static 없는 void main() 도 실행된다(JEP 512).<br>하지만 수업과 시험의 기준은 public static void main(String\[] args) 이다.

**📝 필기 (실습 시간)**

- 파이썬은 들여쓰기로 명령어의 레벨(블록)을 구분하지만, 자바는 중괄호 { } 로 구분한다.
- 파이썬은 들여쓰기가 문법적으로 엄격하지만, 자바의 들여쓰기는 "가독성"을 위해서만 사용한다.

## 변수와 자료형 - 변수 저장 예제

`2-2` · 📄 [`VariablesTest.java`](VariablesTest.java)

기본 자료형 8가지

```text
| 자료형  | 값의 유형   | 크기 / 범위                                         |
```

|---------|-------------|-----------------------------------------------------|

```text
| boolean | true, false | 1 byte                                              |
| byte    | 정수        | 1 byte (-128 ~ 127)                                 |
| char    | 문자        | 2 byte (유니코드 0 ~ 65535)                         |
| short   | 정수        | 2 byte (-32768 ~ 32767)                             |
| int     | 정수        | 4 byte (-2147483648 ~ 2147483647)                   |
| long    | 정수        | 8 byte (-9223372036854775808 ~ 9223372036854775807) |
| float   | 실수        | 4 byte (약 ±3.40282347E38)                          |
| double  | 실수        | 8 byte (약 ±1.79769313486231570E308)                |
```

#### 💻 코드

<!-- code: VariablesTest.java -->
```java
public class VariablesTest {
    public static void main(String[] args) {
        boolean bln = true;                       // true 또는 false 만 가능
        byte val1 = 127;                          // byte 최대값
        char ch = 'a';                            // ch = '한'; 처럼 한글도 저장 가능 (2byte 유니코드)
        short val2 = 32767;                       // short 최대값
        int val3 = 2147483647;                    // int 최대값
        long val4 = 9223372036854775807L;         // long 최대값 - L 필수!
        float val5 = 3.40282347E38f;              // float 최대값 - f 필수!
        double val6 = 1.79769313486231570E308;    // double 최대값

        System.out.println("boolean : " + bln);
        System.out.println("byte    : " + val1);
        System.out.println("char    : " + ch);
        System.out.println("short   : " + val2);
        System.out.println("int     : " + val3);
        System.out.println("long    : " + val4);
        System.out.println("float   : " + val5);
        System.out.println("double  : " + val6);

        // 변수 선언 방법
        int x, y, z;          // 같은 타입은 한 줄에 여러 개 선언 가능
        x = 1;
        y = 0;
        z = -1;
        int a = 1, b = 0;     // 선언과 동시에 초기화도 가능
        System.out.println(x + " " + y + " " + z + " " + a + " " + b);
        // 동일 변수에 대해 선언은 한 번만! (int x; 를 또 쓰면 에러)

        // 참조 자료형 String
        String s1 = new String("bmkim");   // 선언 시에 객체 생성하여 초기화
        String s2;
        s2 = new String("bmkim");          // 선언 후에 객체 생성하여 초기화
        String s3 = "bmkim";               // 편의상 기본 자료형처럼 사용 가능
        System.out.println(s1 + " " + s2 + " " + s3);
    }
}
```
<!-- /code -->

**⚠ 자주 틀리는 부분: 리터럴 접미사**

1) long val4 = 9223372036854775807;    → 컴파일 에러 (integer number too large)<br>정수 리터럴은 기본이 int 라서 int 범위를 넘으면 안 된다. 끝에 L 을 붙인다.
2) float val5 = 3.40282347E38;         → 컴파일 에러 (possible lossy conversion from double to float)<br>소수점 리터럴은 기본이 double 이라서 float 에 넣으려면 끝에 f 를 붙인다.
3) float 최대값(Float.MAX\_VALUE)은 3.40282347E38 이다.<br>이보다 큰 3.4029E38f 같은 값은 f 를 붙여도 "floating-point number too large" 에러가 난다.

## \[실습] 사용자 이름을 입력 받아 인사말 출력하기

`2-4 변수와 자료형4` · 📄 [`SayHello.java`](SayHello.java)

#### 💻 코드

<!-- code: SayHello.java -->
```java
import java.util.Scanner; // ← 이 줄이 없으면 "Scanner cannot be resolved to a type" 컴파일 에러

public class SayHello {
    public static void main(String[] args) {
        System.out.println("이름 입력 >> ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();   // 공백 전까지의 문자열(단어) 하나를 읽음
        sc.close();

        // + 기호로 긴 문자열 연결 (문자열 + 변수 + 문자열)
        String helloMessage = "안녕하세요. " + name +
                " 님, 자바 세계에 오실 것을 축하드립니다.";
        System.out.println(helloMessage);
    }
}
```
<!-- /code -->

**이클립스 실습 순서**

1) File -> New -> Java Project, 프로젝트 이름은 SayHelloTest
2) 프로젝트 탐색기(Project Explorer)에서 프로젝트 우클릭 -> New -> Class
3) 클래스 이름(SayHello)과 main 메소드 자동 생성 옵션(public static void main) 선택

```java
import 없이 Scanner 를 쓰면 Scanner 클래스 위치를 몰라서 컴파일 에러.
 → import java.util.Scanner; 를 맨 윗줄에 추가하면 해결
 → 이클립스: 빨간 줄 위에 마우스를 올리면 해결 창이 뜨는데,
   가장 위의 "'Scanner' (java.util) 가져오기" 를 선택하면 자동으로 import 추가
 → 빨간 줄이 사라지면 File -> Save All 로 저장 후 실행
```

**📝 필기**

- 이미 정의된 클래스라도 어디에 있는지 알려주지 않으면 자바(컴파일러)는 모른다.<br>import java.util.Scanner; 라고 선언해야 컴파일러가 "아, 이 클래스를 가져와서 쓰는구나" 하고 해석한다.
- 단, java.lang 패키지(System, String, Math 등)는 자동 import 된다.

## 자료형 변환 - 자동 형변환 예제

`2-4 변수와 자료형4` · 📄 [`Assignment.java`](Assignment.java)

#### 💻 코드

<!-- code: Assignment.java -->
```java
public class Assignment {
    public static void main(String[] args) {
        char c = '한';
        System.out.println("문자 : " + c);

        int code = c; // 자동 형변환 (char 2byte -> int 4byte)
        System.out.println("유니코드 : " + Integer.toHexString(code)); // 16진수 문자열로 변환

        int i = 0xd55d; // '한'(d55c) 의 다음 코드값
        // char c2 = i;     // 컴파일 에러! int(4byte) -> char(2byte) 는 자동 변환 불가
        char c2 = (char) i; // 강제 형변환 필요
        System.out.println("문자 : " + c2);

        // 자동 형변환과 강제 형변환 비교
        int x;
        x = 6;            // 자료형 일치, OK
        // x = 3.7;       // 자료형 불일치 에러 - 우측(double)이 더 크다
        double d;
        d = 3;            // OK - int 3 이 3.0 으로 자동 형변환
        d = x;            // OK
        // x = d;         // 자료형 불일치 에러
        x = (int) 3.14;   // 강제 형변환, x 에 3 이 대입
        System.out.println("d = " + d + ", x = " + x);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
문자 : 한
유니코드 : d55c
문자 : 핝
```

**자동 형변환(묵시적 형변환)**

- 치환문에서 왼쪽 변수의 자료형과 오른쪽 값의 자료형이 일치해야 한다.
- 오른쪽 자료형이 왼쪽보다 "작은" 경우에는 컴파일러가 큰 자료형으로 자동 변환해서 허용.
- 자동 형변환 방향: byte -> short 또는 char -> int -> long -> float -> double

**강제 형변환(명시적 형변환, casting)**

- 왼쪽 자료형이 더 작으면 정보 손실 가능성 때문에 허용하지 않음 → 컴파일 에러
- 손실을 감수하고서라도 저장하려면 (자료형) 을 붙여 강제 형변환
  ```java
  예) int x = (int) 3.14;  // x 에 3 이 대입 (소수점 아래 버림)
  ```

## \[실습] 임의의 양의 정수값을 시분초로 변환하기

`2-5 수식1` · 📄 [`IntegerToTime.java`](IntegerToTime.java)

사용자에게 정수값(초)을 받은 후 시/분/초로 변환하여 출력하는 프로그램<br>예) 입력 : 3665 → 출력 : 1시 1분 5초

```text
입력 : 65   → 출력 : 0시 1분 5초
```

#### 💻 코드

<!-- code: IntegerToTime.java -->
```java
import java.util.Scanner; // 이 줄이 없으면 Scanner 를 찾지 못해 컴파일 에러

public class IntegerToTime {
    public static void main(String[] args) {
        System.out.println("숫자 입력 >> ");
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성
        int i = sc.nextInt();                // 정수 입력
        sc.close();                          // 사용 후 꼭! 닫아줌

        int hour = i / 3600;
        int remain = i % 3600;
        int minute = remain / 60;
        int second = remain % 60;
        System.out.println(hour + "시 " + minute + "분 " + second + "초");
    }
}
```
<!-- /code -->

**핵심: 정수 나눗셈(/)은 몫, 나머지 연산(%)은 나머지**

- 1시간 = 3600초, 1분 = 60초
- hour   = 전체 / 3600
- remain = 전체 % 3600   (시간을 빼고 남은 초)
- minute = remain / 60
- second = remain % 60

## \[실습] 3명의 학생의 성적을 입력 받아 총점 및 평균 구하기

`2-5 수식1` · 📄 [`SumNAvg.java`](SumNAvg.java)

```java
포인트: double avg = sum / 3.0;
```


- sum / 3   → int / int = 정수 나눗셈 → 소수점 이하가 버려짐 (예: 250 / 3 = 83)
- sum / 3.0 → int / double = double 나눗셈 → 83.333...

즉, 피연산자 중 하나라도 실수여야 실수 나눗셈이 된다.

#### 💻 코드

<!-- code: SumNAvg.java -->
```java
import java.util.Scanner;

public class SumNAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 성적 >> ");
        int s1 = sc.nextInt();
        System.out.println("두 번째 성적 >> ");
        int s2 = sc.nextInt();
        System.out.println("세 번째 성적 >> ");
        int s3 = sc.nextInt();
        sc.close();

        int sum = s1 + s2 + s3;
        double avg = sum / 3.0;
        System.out.println("합 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
```
<!-- /code -->

## 오버플로우와 언더플로우 - 예제

`2-5 수식1` · 📄 [`Overflow.java`](Overflow.java)

- 자료형마다 저장할 수 있는 값의 범위가 한정되어 있다.
- 범위보다 크면 오버플로우, 작으면 언더플로우 → 엉뚱한 결과가 나온다. (에러가 나지 않으니 주의!)
- 각 기본 자료형의 대응 클래스(래퍼 클래스)는 최대값(MAX\_VALUE)과 최소값(MIN\_VALUE)을 정적(static) 필드로 제공한다.

```java
boolean - Boolean   | byte  - Byte    | char  - Character | short  - Short
int     - Integer   | long  - Long    | float - Float     | double - Double
```

#### 💻 코드

<!-- code: Overflow.java -->
```java
public class Overflow {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE; // int 형의 최대값
        int y = Integer.MIN_VALUE; // int 형의 최소값
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int w = x + 1;
        int z = y - 1;
        System.out.println("w = " + w);
        System.out.println("z = " + z);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
x = 2147483647
y = -2147483648
w = -2147483648   ← 최대값 + 1 이 최소값으로 넘어감 (오버플로우)
z = 2147483647    ← 최소값 - 1 이 최대값으로 넘어감 (언더플로우)
```

## \[실습] 비트 연산자 실습하기

`2-6 수식2` · 📄 [`BitOperation.java`](BitOperation.java)

#### 💻 코드

<!-- code: BitOperation.java -->
```java
public class BitOperation {
    public static void main(String[] args) {
        byte x = (byte) 0x00, y = (byte) 0xFF;
        byte z;

        z = (byte) (x & y);
        System.out.println("& : " + z);

        z = (byte) (x | y);
        // 부호 있는 정수 -1 로 해석하여 출력되기 때문에 toUnsignedInt 사용
        System.out.println("| : " + Byte.toUnsignedInt(z));

        z = (byte) (x ^ y);
        System.out.println("^ : " + Byte.toUnsignedInt(z));

        z = (byte) ~y;
        System.out.println("~ : " + z);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
& : 0
| : 255
^ : 255
~ : 0
```

**비트 논리 연산자**

- 비트 AND  &  : 두 비트가 모두 1일 때만 1
- 비트 OR   |  : 두 비트 중 하나라도 1이면 1
- 비트 XOR  ^  : 두 비트가 같으면 0, 다르면 1
- 비트 NOT  \~  : 0 -> 1, 1 -> 0 (현재 비트를 반대로)

x = 0x00 = 0000 0000<br>y = 0xFF = 1111 1111

**왜 (byte) 캐스팅을 하나?**

- byte, short 끼리 연산해도 결과는 int 로 자동 승격된다.
- 그래서 byte 변수에 다시 넣으려면 (byte) 강제 형변환이 필요하다.

**왜 Byte.toUnsignedInt() 를 쓰나?**

- 1111 1111 을 byte 로 출력하면 부호 있는 정수 -1 로 해석되어 출력됨.
- 부호 없는 값 255 로 보고 싶으면 Byte.toUnsignedInt() 를 사용.

## \[실습] 시프트 연산자 실습하기

`2-6 수식2` · 📄 [`ShiftOperation.java`](ShiftOperation.java)

```text
| 연산    | 의미                                                                       |
```

|---------|----------------------------------------------------------------------------| | a >> b  | a 의 각 비트를 오른쪽으로 b 비트 이동. 최상위 빈자리는 원래 최상위 비트(부호)로 채움 |

```text
| a >>> b | a 의 각 비트를 오른쪽으로 b 비트 이동. 최상위 빈자리는 0 으로 채움               |
| a << b  | a 의 각 비트를 왼쪽으로 b 비트 이동. 최하위 빈자리는 0 으로 채움                  |
```

#### 💻 코드

<!-- code: ShiftOperation.java -->
```java
public class ShiftOperation {
    public static void main(String[] args) {
        int x = 128, y = -128;
        System.out.println("x >> 2 : " + Integer.toBinaryString(x) + " -> "
                + Integer.toBinaryString(x >> 2));
        System.out.println("y >> 2 : " + Integer.toBinaryString(y) + " -> "
                + Integer.toBinaryString(y >> 2));
        System.out.println("x >>> 2 : " + Integer.toBinaryString(x) + " -> "
                + Integer.toBinaryString(x >>> 2));
        System.out.println("y >>> 2 : " + Integer.toBinaryString(y) + " -> "
                + Integer.toBinaryString(y >>> 2));
        System.out.println("x << 2 : " + Integer.toBinaryString(x) + " -> "
                + Integer.toBinaryString(x << 2));
        System.out.println("y << 2 : " + Integer.toBinaryString(y) + " -> "
                + Integer.toBinaryString(y << 2));

        // 10진수로도 확인 (추가)
        System.out.println(x + " >> 2 = " + (x >> 2) + ", " + y + " >> 2 = " + (y >> 2));
        System.out.println(y + " >>> 2 = " + (y >>> 2));
        System.out.println(x + " << 2 = " + (x << 2) + ", " + y + " << 2 = " + (y << 2));
    }
}
```
<!-- /code -->

#### 실행 결과

```text
x >> 2 : 10000000 -> 100000
y >> 2 : 11111111111111111111111110000000 -> 11111111111111111111111111100000
x >>> 2 : 10000000 -> 100000
y >>> 2 : 11111111111111111111111110000000 -> 111111111111111111111111100000
x << 2 : 10000000 -> 1000000000
y << 2 : 11111111111111111111111110000000 -> 11111111111111111111111000000000
```

**정리**

- \>> 는 부호를 유지하는 산술 시프트 → 양수/음수 모두 "2^b 로 나누기" 효과
- \>>> 는 부호를 무시하는 논리 시프트 → 음수에 쓰면 큰 양수가 됨
- &lt;&lt; 는 "2^b 곱하기" 효과

Integer.toBinaryString() : 정수를 2진수 문자열로 변환 (앞의 0 은 생략, 음수는 32비트 전체 표시)

## \[실습] 관계 연산자 실습하기

`2-6 수식2` · 📄 [`RelationOperation.java`](RelationOperation.java)

관계 연산자: 두 피연산자가 주어진 관계를 만족하는지 검사 → 만족하면 true, 아니면 false 조건식을 기술할 때 많이 사용한다.

```text
| 연산    | 의미                        | 예                          |
```

|---------|-----------------------------|-----------------------------|

```text
| a < b   | a 가 b 보다 작으면 true      | 3 < 5 : true,  5 < 3 : false |
| a > b   | a 가 b 보다 크면 true        | 5 > 3 : true,  3 > 5 : false |
```

| a &lt;= b  | a 가 b 보다 작거나 같으면 true | 3 &lt;= 5 : true, 5 &lt;= 3 : false| | a >= b  | a 가 b 보다 크거나 같으면 true | 5 >= 3 : true, 3 >= 5 : false|

```text
| a == b  | a 가 b 와 같으면 true        | 5 == 5 : true, 5 == 3 : false|
| a != b  | a 가 b 와 다르면 true        | 5 != 3 : true, 5 != 5 : false|
```

#### 💻 코드

<!-- code: RelationOperation.java -->
```java
public class RelationOperation {
    public static void main(String[] args) {
        int x = 3, y = 5;
        System.out.println(x < y);
        System.out.println(x > y);
        System.out.println(x <= y);
        System.out.println(x >= y);
        System.out.println(x == y);
        System.out.println(x != y);
    }
}
```
<!-- /code -->

#### 실행 결과 (x = 3, y = 5)

```text
true / false / true / false / false / true
```

## \[실습] 논리 연산자 실습하기

`2-7 수식3` · 📄 [`LogicOperation.java`](LogicOperation.java)

```text
사용 형태: 조건식1 논리연산자 조건식2   또는   논리연산자 조건식

| e1    | e2    | e1 && e2 | e1 || e2 | e1 ^ e2 | !e1   |
```

|-------|-------|----------|----------|---------|-------|

```text
| true  | true  | true     | true     | false   | false |
| true  | false | false    | true     | true    | false |
| false | true  | false    | true     | true    | true  |
| false | false | false    | false    | false   | true  |
```

- && (AND) : 둘 다 true 일 때만 true
- || (OR)  : 하나라도 true 면 true
- ^  (XOR) : 두 값이 다를 때 true
- !  (NOT) : 반대로

참고) && 와 || 는 단락 평가(short-circuit)를 한다.

- false && ... → 오른쪽은 계산하지 않고 바로 false
- true  || ... → 오른쪽은 계산하지 않고 바로 true

#### 💻 코드

<!-- code: LogicOperation.java -->
```java
public class LogicOperation {
    public static void main(String[] args) {
        int x = 3, y = 9;

        System.out.println("논리 AND 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y && x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y && x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y && x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y && x < 0));

        System.out.println("논리 OR 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y || x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y || x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y || x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y || x < 0));

        System.out.println("논리 XOR 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y ^ x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y ^ x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y ^ x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y ^ x < 0));

        System.out.println("논리 NOT 테스트");
        System.out.println((x < y) + " : " + !(x < y));
        System.out.println((x > y) + " : " + !(x > y));
    }
}
```
<!-- /code -->

## \[실습] 증감 연산자 실습하기

`2-7 수식3` · 📄 [`IncDecOperation.java`](IncDecOperation.java)

```text
| 연산 | 의미                     |
```

|------|--------------------------|<br>| ++a  | a 를 증가시킨 후 a 를 사용 (전위) |

```text
| a++  | a 를 사용한 후 a 를 증가 (후위)   |
```

| --a  | a 를 감소시킨 후 a 를 사용 (전위) |

```text
| a--  | a 를 사용한 후 a 를 감소 (후위)   |
```

#### 💻 코드

<!-- code: IncDecOperation.java -->
```java
public class IncDecOperation {
    public static void main(String[] args) {
        int a, b, c, d;

        a = 3; b = 5; c = 6;
        d = a++ + b++ - c--;
        System.out.println("a=" + a + " b=" + b + " c=" + c + " d=" + d);

        a = 3; b = 5; c = 6;
        d = ++a + ++b - --c;
        System.out.println("a=" + a + " b=" + b + " c=" + c + " d=" + d);

        a = 3; b = 5; c = 6;
        d = ++a + b++ - --c;
        System.out.println("a=" + a + " b=" + b + " c=" + c + " d=" + d);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
a=4 b=6 c=5 d=2    ← d = 3 + 5 - 6 (사용 후 증감)
a=4 b=6 c=5 d=5    ← d = 4 + 6 - 5 (증감 후 사용)
a=4 b=6 c=5 d=4    ← d = 4 + 5 - 5
```

**예시**

```java
int a = 3, b = 0, c;
c = ++a + b;   →  a = a + 1;  c = a + b;
c = a++ + b;   →  c = a + b;  a = a + 1;
++a;           →  단독으로 쓰일 경우 결과는 a++ 와 같다.
```

감소 연산자(--)도 같은 방식.

**📝 필기 (퀴즈 때 질문했던 내용)**

Q. z = ++x + ++y; 에서 전위 증가 연산자는 y 다음 x 순서인가, x 다음 y 순서인가?<br>A. x 가 먼저 처리되고 그다음 y 가 처리된다.<br>자바는 연산자 우선순위와 별개로 "피연산자는 무조건 왼쪽에서 오른쪽(Left-to-Right) 순서로 평가"한다.<br>1단계) 왼쪽 항 ++x 실행 → x 증가 (왼쪽 값 확정)<br>2단계) 오른쪽 항 ++y 실행 → y 증가 (오른쪽 값 확정)<br>3단계) 덧셈<br>4단계) 우선순위가 가장 낮은 대입(=) 이 마지막에 실행<br>참고: C/C++ 은 컴파일러 최적화 방식에 따라 오른쪽 항을 먼저 계산하기도 하지만, 자바는 어떤 컴퓨터에서 실행해도 결과가 똑같도록 '왼쪽부터 순서대로'를 언어 스펙으로 강제한다.

## \[실습] 조건 연산자 실습하기

`2-7 수식3` · 📄 [`ConditionOperation.java`](ConditionOperation.java)

#### 💻 코드

<!-- code: ConditionOperation.java -->
```java
import java.util.Scanner;

public class ConditionOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int s1 = sc.nextInt();
        System.out.println("두 번째 숫자 (음수도 가능) >> ");
        int s2 = sc.nextInt();
        sc.close();

        s1 = s1 > 0 ? s1 : -s1; // s1 절대값을 구한다
        s2 = s2 > 0 ? s2 : -s2; // s2 절대값을 구한다
        int sum = s1 + s2;
        int max = s1 > s2 ? s1 : s2;
        System.out.println("절대값 합 : " + sum);
        System.out.println("절대값 최대 : " + max);
    }
}
```
<!-- /code -->

**조건 연산자 ( ?: ) - 자바의 유일한 삼항 연산자**

형태: 조건 ? 피연산자1 : 피연산자2<br>조건이 true 이면 피연산자1, false 이면 피연산자2 가 결과값이 된다.<br>→ if-else 를 한 줄로 간단히 쓸 수 있다.

```java
a   = c > 0 ? 1 : 0;   // c 가 0 보다 크면 1, 아니면 0 을 a 에 대입
max = a > b ? a : b;   // a, b 중 최대값
abs = a > 0 ? a : -a;  // a 의 절대값
```

프로그램: 두 정수(음수 가능)를 입력받아 절대값의 합과 절대값의 최대값을 출력

---

[🏠 2주차 학습 가이드](../../README.md)
