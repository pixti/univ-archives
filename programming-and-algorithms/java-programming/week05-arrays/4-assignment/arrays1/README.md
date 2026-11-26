# 5주차 과제 · arrays1

[🏠 5주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [MeanStdDev.java](#4-실수-30개-이하의-평균과-표준편차) | 4. 실수 30개 이하의 평균과 표준편차 (📝 배열이 필요한 이유) |
| [DaysInMonth.java](#배열1---2번-문제) | 배열(1) - 2번 문제 |
| [DaysInMonthRefactored.java](#배열1---2번-문제-리팩터링-버전) | 배열(1) - 2번 문제 (리팩터링 버전) |
| [DecimalToBinary.java](#배열1---3번-문제) | 배열(1) - 3번 문제 |
| [DecimalToBinaryRefactored.java](#배열1---3번-문제-리팩터링-버전) | 배열(1) - 3번 문제 (리팩터링 버전) |
| [RandomFrequency.java](#배열1---5번-문제) | 배열(1) - 5번 문제 |
| [RandomFrequencyRefactored.java](#배열1---5번-문제-리팩터링-버전) | 배열(1) - 5번 문제 (리팩터링 버전) |
| [ReverseInput.java](#배열1---1번-문제) | 배열(1) - 1번 문제 |
| [ReverseInputRefactored.java](#배열1---1번-문제-리팩터링-버전) | 배열(1) - 1번 문제 (리팩터링 버전) |

---

## 4. 실수 30개 이하의 평균과 표준편차

`5강 과제` · 📄 [`MeanStdDev.java`](MeanStdDev.java)

#### 문제

> 30 개 이하의 실수를 입력받아 평균(m)과 표준편차(s)를 구하는 프로그램을 작성하시오.
>
> ```text
>        1   n                      1   n
> m  =  ─── Σ  x_i         s = √(  ─── Σ (x_i − m)²  )
>        n  i=1                     n  i=1
> ```
>
> (예시 입력)<br>값? 1.5<br>계속 ? y<br>값? ...

#### 💻 코드

<!-- code: MeanStdDev.java -->
```java
import java.util.Scanner;

public class MeanStdDev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] data = new double[30];
        double sum = 0, average, variance, standardDeviation;
        int count = 0;
        char answer;

        while (count < 30) {
            System.out.print("값? ");
            data[count] = sc.nextDouble();
            sum = sum + data[count];
            count++;

            System.out.print("계속? ");
            answer = sc.next().charAt(0);
            if (answer != 'y') {
                break;
            }
        }

        average = sum / count;  // 평균

        variance = 0;           // 분산
        for (int i = 0; i < count; i++) {
            variance = variance + (data[i] - average) * (data[i] - average);
        }
        variance = variance / count;

        standardDeviation = Math.sqrt(variance);  // 표준편차

        System.out.println("평균 : " + average);
        System.out.println("표준편차 : " + standardDeviation);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
값? 1.5
계속? y
값? 5.6
계속? y
값? 7.1
계속? n
평균 : 4.733333333333333
표준편차 : 2.366901396810231
```

#### 📒 해설

- 📝 필기 : 코드 흐름<br>입력 1.5 → y → 2.5 → y → 3.5 → n 이면<br>data\[0] = 1.5,  data\[1] = 2.5,  data\[2] = 3.5,  count = 3

- 📝 필기 : 평균
  ```java
  입력받을 때마다  sum = sum + data[count];
  입력이 끝나면    average = sum / count;
  ```

- 📝 필기 : 표준편차
  ```java
  for (int i = 0; i < count; i++)
      variance = variance + (data[i] - average) * (data[i] - average);
  ```<br>여기서 (data\[i] - average) 가 x\_i − m 이고, 그것을 두 번 곱한 것이 (x\_i − m)² 이다.
  ```text
  variance = variance / count;          → 분산 (1/n Σ ...)
  ``` standardDeviation = Math.sqrt(variance); → 표준편차 (분산의 제곱근)

- 📝 필기 : 이 문제에서 배열이 필요한 이유<br>입력받는 순간 평균만 구한다면 배열이 없어도 됩니다.<br>하지만 표준편차를 구하려면 평균을 먼저 구한 다음, 각각의 값에 대해 (값 - 평균)² 을 계산해야 합니다.<br>그래서 흐름이<br>입력 → 배열에 저장 → 평균 계산 → 배열을 다시 처음부터 확인 → 표준편차 계산 이 됩니다. (5-1 강의 "일단 저장 → 나중에 처리" 와 같은 이유)

- 📝 필기 : 자료형과 크기
  - 입력이 실수이므로 double\[] 을 사용.
  - "30 개 이하" 조건 때문에 double\[] data = new double\[30];
  - while (count &lt; 30) 으로 30 개를 넘게 입력하는 것을 막는다.

**포인트**

- 입력 → 계속? 을 묻고 'y' 가 아니면 break. 30 개가 차면 조건 count &lt; 30 이 깨져서 끝.
- sum, average 는 double 이라 sum / count 는 실수 나눗셈. (int 끼리였다면 형변환 필요)

- ⚠ 이 과제는 리팩터링 버전이 없다.
- 💡 1 개만 넣으면 표준편차는 0.0. 첫 값에서 바로 n 을 넣어도 count 는 1 이라 0 으로 나누는 일은 없다.
- 💡 통계에서 "표본 표준편차" 는 n 대신 n − 1 로 나눈다. 이 문제는 식에 1/n 이 주어졌으므로 n 으로 나눈다.

## 배열(1) - 2번 문제

`5강 과제` · 📄 [`DaysInMonth.java`](DaysInMonth.java)

#### 문제

> 다음 배열을 이용하여 사용자가 입력한 달의 날짜 수를 출력하는 프로그램을 작성하시오.
>
> ```java
> int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
> ```

#### 💻 코드

<!-- code: DaysInMonth.java -->
```java
import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month;

        System.out.print("원하는 달을 입력하세요 : ");
        month = sc.nextInt();

        System.out.println(month + "월은 " + days[month - 1] + "일까지 있습니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
원하는 달을 입력하세요 : 4
4월은 30일까지 있습니다.
```

**포인트**

- 배열을 "표(룩업 테이블)" 로 쓴다. if 나 switch 12 개 대신 days\[month - 1] 한 번으로 끝난다.<br>(3주차 switch 로 월의 날짜 수를 구하던 것과 비교)
- 사람의 달은 1 \~ 12, 배열 인덱스는 0 \~ 11 → month - 1

month :  1  2  3  4 ...  12<br>index :  0  1  2  3 ...  11<br>days  : 31 29 31 30 ...  31

- ⚠ 범위 검사가 없다. 0 이나 13 을 넣으면 days\[-1], days\[12] 에서 ArrayIndexOutOfBoundsException.<br>→ 리팩터링 버전에서 1 \~ 12 검사를 추가했다.
- 💡 2월은 문제의 배열대로 29 일로 고정. 윤년까지 따지려면 연도도 입력받아야 한다.

## 배열(1) - 2번 문제 (리팩터링 버전)

`5강 과제` · 📄 [`DaysInMonthRefactored.java`](DaysInMonthRefactored.java)

#### 문제

> DaysInMonth.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: DaysInMonthRefactored.java -->
```java
import java.util.Scanner;

public class DaysInMonthRefactored {
    public static void main(String[] args) {
        // 표준 입력을 읽습니다.
        try (Scanner scanner = new Scanner(System.in)) {
            int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            System.out.print("원하는 달을 입력하세요: ");
            int month = scanner.nextInt();

            // 배열 인덱스로 사용하기 전에 월 범위를 확인합니다.
            if (month < 1 || month > daysInMonth.length) {
                System.out.println("1부터 12 사이의 달을 입력하세요.");
                return;
            }

            // 이 예제는 2월을 29일로 고정해 표시합니다.
            System.out.println(month + "월은 " + daysInMonth[month - 1] + "일까지 있습니다.");
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
원하는 달을 입력하세요: 4
4월은 30일까지 있습니다.

원하는 달을 입력하세요: 13
1부터 12 사이의 달을 입력하세요.
```

**바뀐 점**

- try-with-resources 로 Scanner 자동 닫기
- 변수 이름 days → daysInMonth
- 범위 검사 추가 : month &lt; 1 || month > daysInMonth.length 이면 안내 후 return.<br>→ 원래 코드에서 0, 13 을 넣으면 나던 ArrayIndexOutOfBoundsException 을 막는다.
- 12 대신 daysInMonth.length 로 비교.

- 💡 return 은 main 메소드를 끝낸다 = 프로그램 종료. try 블록 안에서 return 해도 Scanner 는 닫힌다.
- 💡 안내 문구 "1부터 12 사이" 의 12 는 숫자로 적혀 있다. (조건은 length 로, 문구는 숫자로)

## 배열(1) - 3번 문제

`5강 과제` · 📄 [`DecimalToBinary.java`](DecimalToBinary.java)

#### 문제

> 10 진수를 입력받아 2 진수로 변환하여 출력하는 프로그램을 작성하시오.
>
> - 최대 64 자리까지 표현하고, 2 진수의 각 자리는 배열에 저장한다.
> - 처음 1 이 나오기 전의 0 은 출력하지 않는다.
>   - (예) 9  → 000...001001 이 아니라 1001<br>15 → 000...001111 이 아니라 1111

#### 💻 코드

<!-- code: DecimalToBinary.java -->
```java
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num;
        int[] binary = new int[64];
        int index = 0;

        System.out.print("10진수를 입력하세요. : ");
        num = sc.nextLong();

        // 10진수를 2진수로 변환
        while (num > 0) {
            binary[index] = (int) (num % 2);
            num = num / 2;
            index++;
        }

        // 역순으로 출력
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
10진수를 입력하세요. : 142924
100010111001001100
```

#### 📒 해설

- 📝 필기 : 왜 배열에 역순으로 저장되는가?<br>16 을 2 로 계속 나누면<br>16 / 2 → 몫 8, 나머지 0<br>8 / 2 → 몫 4, 나머지 0<br>4 / 2 → 몫 2, 나머지 0<br>2 / 2 → 몫 1, 나머지 0<br>1 / 2 → 몫 0, 나머지 1<br>나머지는 0 0 0 0 1 순서로 나오지만, 2 진수는 거꾸로 읽어야 하므로 1 0 0 0 0 이 된다.<br>그래서 binary\[0] = 0, binary\[1] = 0, binary\[2] = 0, binary\[3] = 0, binary\[4] = 1 로 저장된다.<br>→ 낮은 자리부터 저장되므로, 출력할 때 뒤에서부터 읽는다.

- 📝 필기 : index 가 필요한 이유<br>배열은 64 칸이지만 모두 사용하는 것이 아니다. 예를 들어 9 는<br>binary\[0] = 1, binary\[1] = 0, binary\[2] = 0, binary\[3] = 1<br>로 0 \~ 3 까지만 데이터가 들어간다. index 는 마지막으로 저장한 다음 위치를 기억하고, 반복이 끝나면 index 는 4 가 된다.
  ```java
  for (int i = index - 1; i >= 0; i--)
  ```<br>이므로 3 → 2 → 1 → 0 순서로 출력된다.<br>→ 사용한 칸까지만 출력하므로 "처음 1 이 나오기 전의 0" 은 자연스럽게 출력되지 않는다.

**포인트**

- long : int(약 21 억, 31 비트)보다 큰 수도 받으려고. 최대 64 자리 조건에 맞춘 것.
- (int)(num % 2) : long 끼리 연산한 결과는 long 이라서 int 배열에 넣으려면 형변환이 필요.
- 5-1 강의 "값 배열에 읽어들이기" 의 idx 와 같은 역할 : 다음에 넣을 위치 = 지금까지 넣은 개수.

- ⚠ 0 을 입력하면 while 을 한 번도 돌지 않아 아무것도 출력되지 않는다. (0 의 2 진수는 0)
- ⚠ 음수도 while (num > 0) 를 통과하지 못해 아무것도 출력되지 않는다.<br>→ 리팩터링 버전에서 둘 다 처리했다.
- 💡 long 의 양수 최대값은 2^63 - 1 이라 실제로는 63 자리까지 나온다. (64 칸이면 충분)
- 💡 검산 : Long.toBinaryString(142924) 도 100010111001001100

## 배열(1) - 3번 문제 (리팩터링 버전)

`5강 과제` · 📄 [`DecimalToBinaryRefactored.java`](DecimalToBinaryRefactored.java)

#### 문제

> DecimalToBinary.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: DecimalToBinaryRefactored.java -->
```java
import java.util.Scanner;

public class DecimalToBinaryRefactored {
    public static void main(String[] args) {
        // 표준 입력을 읽고 사용이 끝나면 자동으로 닫습니다.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("10진수를 입력하세요: ");
            long number = scanner.nextLong();

            // 이 예제는 음이 아닌 정수의 2진수 변환을 지원합니다.
            if (number < 0) {
                System.out.println("0 이상의 정수를 입력하세요.");
                return;
            }

            // 0은 나눗셈 반복문에서 처리되지 않으므로 별도로 출력합니다.
            if (number == 0) {
                System.out.println("0");
                return;
            }

            int[] binaryDigits = new int[64];
            int digitCount = 0;

            // 나머지를 낮은 자리부터 배열에 저장합니다.
            while (number > 0) {
                binaryDigits[digitCount] = (int) (number % 2);
                number /= 2;
                digitCount++;
            }

            // 저장 순서를 뒤집어 높은 자리부터 출력합니다.
            for (int index = digitCount - 1; index >= 0; index--) {
                System.out.print(binaryDigits[index]);
            }
            System.out.println();
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
10진수를 입력하세요: 11
1011

10진수를 입력하세요: 0
0
```

**바뀐 점**

- try-with-resources 로 Scanner 자동 닫기
- 음수 입력 처리 : "0 이상의 정수를 입력하세요." 후 종료
- 0 입력 처리 : 나눗셈 반복을 한 번도 돌지 않으므로 "0" 을 따로 출력<br>→ 원래 코드의 ⚠ 두 가지(0, 음수 입력 시 아무것도 안 나옴)를 고쳤다.
- 변수 이름 num, binary, index → number, binaryDigits, digitCount<br>index 대신 digitCount : "몇 자리인지" 라는 뜻이 드러난다. (📝 필기의 "index 가 필요한 이유" 와 같은 역할)
- num = num / 2 → number /= 2  (복합 대입 연산자)
- 배열 선언을 검사 뒤로 옮김 : 쓰지 않을 경우(0, 음수)엔 배열을 만들지 않는다.
- 마지막에 줄바꿈 추가.

- 💡 음수까지 2 진수로 보려면 2 의 보수 표현을 알아야 한다. (Long.toBinaryString(-1) 은 1 이 64 개)<br>이 과제의 범위를 넘어서서 리팩터링 버전도 지원하지 않는다고 명시했다.

## 배열(1) - 5번 문제

`5강 과제` · 📄 [`RandomFrequency.java`](RandomFrequency.java)

#### 문제

> 0 \~ 19 사이의 난수를 1000 개 생성하여, 가장 많이 발생한 수를 출력하는 프로그램을 작성하시오.
>
> (문제의 예시 화면) 각 수의 발생 횟수를 출력한 뒤 마지막에<br>0 : 49
>
> ```text
> ...
> 6 : 65      ← 가장 많음
> ...
> ```
>
> 최대 발생 수 : 6

#### 💻 코드

<!-- code: RandomFrequency.java -->
```java
public class RandomFrequency {
    public static void main(String[] args) {
        int[] count = new int[20];
        int num;
        int max = 0;

        // 0부터 19까지의 난수를 1000번 생성
        for (int i = 0; i < 1000; i++) {
            num = (int) (Math.random() * 20);
            count[num]++;
        }

        // 각 숫자가 나온 횟수 출력
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " : " + count[i]);
        }

        // 가장 많이 발생한 횟수 찾기
        for (int i = 0; i < 20; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        System.out.println("최대 발생 수 : " + max);
    }
}
```
<!-- /code -->

#### 실행 예  (난수라 매번 다름)

```text
0 : 52
1 : 47
...
19 : 51
최대 발생 수 : 65
```

#### 📒 해설

- 📝 필기 : 핵심은 count 배열입니다
  ```java
  int[] count = new int[20];
  ```<br>배열의 인덱스를 난수 자체로 사용하는 방식입니다. 예를 들어 난수가<br>3, 7, 3, 15, 7, 3<br>순서로 나왔다면<br>count\[3]  → 3<br>count\[7]  → 2<br>count\[15] → 1<br>이 됩니다.<br>count\[num]++;  은  count\[num] = count\[num] + 1;  과 같습니다.

- 📝 필기 : 난수 생성
  ```java
  num = (int) (Math.random() * 20);
    Math.random()        : 0.0 이상 1.0 미만
    Math.random() * 20   : 0.0 이상 20.0 미만
    (int) 형변환          : 0 ~ 19
  ```

- 📝 필기 : 최대값 찾기
  ```java
  int max = 0;
  for (int i = 0; i < 20; i++)
      if (count[i] > max) max = count[i];
  ```<br>예를 들어 count\[6] 이 65 라면 max 가 65 가 됩니다.

**포인트**

- 0 \~ 19 의 "값" 을 그대로 배열의 "위치" 로 쓴다. → if 20 개 없이 count\[num]++ 한 줄로 센다.<br>(2번 문제 DaysInMonth 의 "배열을 표로 쓰기" 와 비슷한 발상)
- new int\[20] 은 0 으로 채워져 있으므로 세기 전에 초기화할 필요가 없다.

- ⚠ 문제는 "가장 많이 발생한 수" 를 출력하라고 했고, 예시 화면도 "최대 발생 수 : 6" (= 숫자 6, 65 번) 이다.<br>이 코드는 최대 "횟수" (max = 65) 를 출력한다. 숫자를 출력하려면 위치도 같이 기억해야 한다.
  ```java
  int max = 0, maxNum = 0;
  for (...) if (count[i] > max) { max = count[i]; maxNum = i; }   (5-1 강의 maxPos 와 같은 방식)
  ```<br>→ 리팩터링 버전은 "최다 발생 숫자" 를 따로 출력해서 이 문제를 고쳤다.
- 💡 난수라 실행할 때마다 결과가 다르다. 1000 / 20 = 50 이므로 각 수는 평균 50 번 정도 나온다.

## 배열(1) - 5번 문제 (리팩터링 버전)

`5강 과제` · 📄 [`RandomFrequencyRefactored.java`](RandomFrequencyRefactored.java)

#### 문제

> RandomFrequency.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: RandomFrequencyRefactored.java -->
```java
public class RandomFrequencyRefactored {

    private static final int VALUE_COUNT = 20;
    private static final int GENERATION_COUNT = 1_000;

    public static void main(String[] args) {
        int[] frequencies = new int[VALUE_COUNT];

        // 0부터 VALUE_COUNT - 1까지의 정수를 무작위로 생성해 빈도를 셉니다.
        for (int generated = 0; generated < GENERATION_COUNT; generated++) {
            int value = (int) (Math.random() * VALUE_COUNT);
            frequencies[value]++;
        }

        int maxFrequency = 0;

        // 각 숫자의 빈도를 출력하고 최댓값을 찾습니다.
        for (int value = 0; value < frequencies.length; value++) {
            System.out.println(value + " : " + frequencies[value]);
            maxFrequency = Math.max(maxFrequency, frequencies[value]);
        }

        System.out.println("최대 발생 수: " + maxFrequency);

        // 최댓값과 같은 빈도를 가진 숫자를 모두 출력합니다.
        System.out.print("최다 발생 숫자: ");
        for (int value = 0; value < frequencies.length; value++) {
            if (frequencies[value] == maxFrequency) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 예  (난수라 매번 다름)

```text
0 : 48
...
19 : 55
최대 발생 수: 61
최다 발생 숫자: 8
```

**바뀐 점**

- 숫자 20, 1000 → 상수 VALUE\_COUNT, GENERATION\_COUNT  (1\_000 : 숫자 사이의 \_ 는 읽기 쉽게 하는 구분자)
- 변수 이름 count, num, max → frequencies, value, maxFrequency
- 출력과 최대값 찾기를 반복문 하나로 합침 : Math.max(maxFrequency, frequencies\[value])
- "최다 발생 숫자" 출력 추가 : 최대 빈도와 같은 숫자를 모두 출력한다.<br>→ 원래 코드의 ⚠ (숫자가 아니라 횟수를 출력) 를 고쳤다. 동점인 숫자가 여러 개여도 모두 나온다.

- 💡 Math.max(a, b) : 둘 중 큰 값. if (b > a) a = b; 와 같은 일을 한 줄로.
- 💡 "최대 발생 수" 라는 문구는 그대로 횟수를 뜻한다. 문제의 예시 화면과는 뜻이 다르다.

## 배열(1) - 1번 문제

`5강 과제` · 📄 [`ReverseInput.java`](ReverseInput.java)

#### 문제

> 10 개의 정수를 입력받아 배열에 저장한 뒤, 역순으로 출력하는 프로그램을 작성하시오.

#### 💻 코드

<!-- code: ReverseInput.java -->
```java
import java.util.Scanner;

public class ReverseInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("10개의 정수 입력");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("역순 출력 : ");
        for (int i = 9; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
10개의 정수 입력
1 2 3 4 5 6 7 8 9 10
역순 출력 :
10 9 8 7 6 5 4 3 2 1
```

**포인트**

- 입력 : i = 0 → 9 순서로 arr\[i] 에 저장
- 출력 : i = 9 → 0 순서로 거꾸로 읽기 (i--)
- 배열 자체를 뒤집는 것(실습 배열(1) 4번)이 아니라 "읽는 순서" 만 거꾸로 한다. 배열은 그대로.

- 💡 숫자 10, 9 대신 arr.length, arr.length - 1 을 쓰면 개수를 바꿔도 한 곳만 고치면 된다.<br>(리팩터링 버전이 그렇게 했다 → ReverseInputRefactored.java)
- 💡 10 개를 한 줄에 공백으로 띄워 입력해도, 하나씩 엔터를 쳐도 된다.

## 배열(1) - 1번 문제 (리팩터링 버전)

`5강 과제` · 📄 [`ReverseInputRefactored.java`](ReverseInputRefactored.java)

#### 문제

> ReverseInput.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: ReverseInputRefactored.java -->
```java
import java.util.Scanner;

public class ReverseInputRefactored {
    public static void main(String[] args) {
        // 표준 입력을 읽기 위한 Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            int[] numbers = new int[10];

            System.out.println("10개의 정수 입력");
            // 배열의 길이를 기준으로 입력을 읽습니다.
            for (int index = 0; index < numbers.length; index++) {
                numbers[index] = scanner.nextInt();
            }

            System.out.println("역순 출력:");
            // 마지막 원소부터 첫 번째 원소까지 출력합니다.
            for (int index = numbers.length - 1; index >= 0; index--) {
                System.out.print(numbers[index] + " ");
            }
            System.out.println();
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
10개의 정수 입력
1 2 3 4 5 6 7 8 9 10
역순 출력:
10 9 8 7 6 5 4 3 2 1
```

**바뀐 점**

- try-with-resources : try (Scanner scanner = ...) { } 블록이 끝나면 Scanner 가 자동으로 닫힌다.<br>sc.close() 를 잊어버릴 일이 없다.
- 변수 이름 sc, arr, i → scanner, numbers, index
- 반복 조건의 숫자 10, 9 → numbers.length, numbers.length - 1<br>배열 크기(new int\[10])만 바꾸면 반복문은 그대로 동작한다.
- 마지막에 줄바꿈 추가.

- 💡 "10개의 정수 입력" 의 10 은 여전히 숫자로 적혀 있다. 크기를 바꾸면 이 문구도 같이 고쳐야 한다.<br>상수(private static final int COUNT = 10;)로 빼면 완전히 한 곳에서 관리할 수 있다.

---

[🏠 5주차 학습 가이드](../../README.md)
