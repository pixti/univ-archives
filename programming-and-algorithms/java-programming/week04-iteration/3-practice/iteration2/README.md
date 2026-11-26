# 4주차 실습 · iteration2

[🏠 4주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [ArithmeticMeanFor.java](#1-산술-평균-for-초기식에-선언과-식을-섞은-컴파일-오류-분석) | 1. 산술 평균 (for). 초기식에 선언과 식을 섞은 컴파일 오류 분석 |
| [FuelEfficiencyFor.java](#2-연비-계산-반복-for---조건--) | 2. 연비 계산 반복 (`for ( ; 조건 ; )`) |
| [PermutationFor.java](#3-순열-npr-for) | 3. 순열 nPr (for) |
| [PyramidFor.java](#4-피라미드-출력-for--필기한-쌍둥이-피라미드) | 4. 피라미드 출력 (for) + 필기한 쌍둥이 피라미드 |

---

## 1. 산술 평균 (for). 초기식에 선언과 식을 섞은 컴파일 오류 분석

`4강 실습` · 📄 [`ArithmeticMeanFor.java`](ArithmeticMeanFor.java)

#### 문제

> ※ 반복 시 for 문만 사용하시오.
>
> 사용자로부터 일련의 데이터를 입력받아서 산술 평균을 구하는 프로그램을 작성하여 보자.<br>음수가 입력되면 데이터의 끝이라고 간주한다.
>
> 산술 평균 : (x1 + x2 + ... + xn) / n

#### 💻 코드

<!-- code: ArithmeticMeanFor.java -->
```java
import java.util.Scanner;

public class ArithmeticMeanFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, sum = 0, count = 0;
        for (System.out.print("n ? "), n = sc.nextInt(); n >= 0; n = sc.nextInt()) {
            sum += n;
            count++;
        }

        if (count != 0)             // ⚠ 추가 : 첫 입력이 음수일 때 NaN 방지
            System.out.println("산술 평균 : " + sum / (double) count);
        else
            System.out.println("입력된 데이터가 없습니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
n ? 10 5 2 8 -1
산술 평균 : 6.25
```

#### 📒 해설

- 📝 필기 : 처음 작성한 코드 → 컴파일 에러

```java
int sum = 0, count = 0;
for (System.out.print("n ? "), int n = sc.nextInt(); n >= 0; n = sc.nextInt()) {   // ❌
    sum += n;
    count++;
}
```

질문해서 받은 설명

  - 자바의 for( 초기화; 조건; 증가 ) 형식에서 "초기화" 자리는 하나의 문장이어야 하며, 일반적으로 변수 선언이나 간단한 할당이어야 합니다. System.out.print(...)는 표현식이고 문장이 아니므로 초기화 위치에 올 수 없습니다.
  - 또한 두 번째 부분인 n = sc.nextInt()도 증가식으로 사용되는데, 이 자리엔 보통 증가 연산이나 변수에 대한 재할당이 와야 하지만, 입력 루프의 의도대로라면 증가식은 사실상 필요 없거나 별도의 while/무한루프 처리가 더 자연스럽습니다.
  - 정확한 문제 요약 : 초기화 부분에 System.out.print("n ? ")이 문장이므로 허용되지 않음.<br>두 번째 부분에 int 선언을 포함하지 못함. 루프 변수 선언은 보통 한 번만 초기화 부분에 해야 하고, 이후에는 n만 다루는 방식이어야 함.

→ 고친 코드 : int n 을 for 밖에서 선언하고, 초기화 부분에서는 n = sc.nextInt() 로 "대입"만 한다.

```java
int n, sum = 0, count = 0;
for (System.out.print("n ? "), n = sc.nextInt(); n >= 0; n = sc.nextInt()) {     // ⭕
```

- ⚠ 위 설명은 절반만 맞다. 고친 코드가 그대로 컴파일되는 것이 증거.
  - System.out.print(...) 같은 메소드 호출은 for 초기화 부분에 쓸 수 있다.<br>초기화 부분에는 다음 둘 중 하나가 온다. (4-3 강의 노트 참고)
      - ① 변수 선언 하나            for (int i = 0, j = 10; ...)
      - ② 식(expression) 목록       for (System.out.print("n ? "), n = sc.nextInt(); ...)<br>메소드 호출, 대입, ++/-- 같은 "문장이 될 수 있는 식"을 쉼표로 나열.
  - 진짜 원인 : ① 과 ② 를 섞어 썼다. (print 호출 = 식, int n = ... = 선언)<br>쉼표 뒤에 int 가 오면 컴파일러는 그것을 식으로 읽으려다 실패한다.<br>실제 javac 에러 : '.class' expected / not a statement  ← 둘 다 int 위치를 가리킨다.
  - 증가식 자리의 n = sc.nextInt() 도 문제 없다. 증가식 자리 역시 "식 목록"이라 i++ 뿐 아니라 대입이나 메소드 호출도 쓸 수 있다. (실제로 잘 돌아간다)

**포인트**

- while 버전(반복문1-1)의 구조를 for 의 세 칸에 나눠 담은 것.
  ```java
  while 버전                      for 버전
  ```<br>print("값 ? "); x = nextInt();  →  초기화 : 안내 출력 + 첫 값 읽기
  ```java
  while (x >= 0)                  →  조건   : 음수가 아니면 계속
  x = nextInt(); (블록 마지막)    →  증가식 : 다음 값 읽기 (본문 실행 후 실행)
  ```
- 증가식은 본문이 끝난 뒤에 실행되므로 "처리 → 다음 값 읽기" 순서가 그대로 지켜진다.
- sum, count 가 int 라서 sum / (double) count 로 실수 나눗셈을 만든다.

- ⚠ 반복문1-1 과 같이 처음부터 음수를 넣으면 0 / 0.0 = NaN. if (count != 0) 를 추가했다.

## 2. 연비 계산 반복 (`for ( ; 조건 ; )`)

`4강 실습` · 📄 [`FuelEfficiencyFor.java`](FuelEfficiencyFor.java)

#### 문제

> ※ 반복 시 for 문만 사용하시오.
>
> 자동차의 연비를 반복적으로 계산해주는 프로그램을 작성하여 보자.

#### 💻 코드

<!-- code: FuelEfficiencyFor.java -->
```java
import java.util.Scanner;

public class FuelEfficiencyFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char cont; int dist, fuel; double ratio;
        System.out.print("계속 (y or n) ? "); cont = sc.next().charAt(0);

        for (; cont == 'y' || cont == 'Y'; ) {      // 초기화, 증가식 생략 → while (cont == 'y' || cont == 'Y') 과 같다
            System.out.print("주행 거리 ? ");
            dist = sc.nextInt();
            System.out.print("연료량 ? ");
            fuel = sc.nextInt();
            ratio = dist / (double) fuel;
            System.out.println("연비 : " + ratio);

            System.out.print("계속 (y or n) ? ");
            cont = sc.next().charAt(0);
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
연료의 양을 입력하시오(l) : 10
주행한 거리를 입력하세요(km) : 100
연비는  10km/l 입니다.
다시 계산하겠습니까?(Y/N) : N
```

#### 실행 예

```text
계속 (y or n) ? y
주행 거리 ? 30
연료량 ? 700
연비 : 0.04285714285714286
계속 (y or n) ? y
주행 거리 ? 40
연료량 ? 20
연비 : 2.0
계속 (y or n) ? n
```

**포인트**

- for (; 조건; ) : 초기화와 증가식을 비우면 while (조건) 과 똑같다.
- 반복문1-2 (do-while) 와 달리 for 는 조건을 "먼저" 검사한다.<br>→ 반복문 들어가기 전에 cont 를 미리 입력받아야 한다. (4-2 의 cont 초기화 비교 표 참고)<br>→ 그래서 시작하자마자 "계속 (y or n) ?" 을 묻는다. 처음에 n 을 넣으면 한 번도 계산하지 않는다.
- 계속 여부를 묻는 코드가 for 앞과 본문 끝, 두 군데에 들어간다.<br>(do-while 이 "적어도 한 번 실행" 하는 문제에 더 잘 맞는 이유)

- 💡 "계속 묻기" 를 for 의 세 칸에 다 넣을 수도 있다. (반복문2-1 과 같은 방식)
  ```java
  for (System.out.print("계속 (y or n) ? "), cont = sc.next().charAt(0);
       cont == 'y' || cont == 'Y';
       System.out.print("계속 (y or n) ? "), cont = sc.next().charAt(0)) { ... }
  ``` 짧아지기는 하지만 읽기는 더 어렵다.

- 💡 실행 예 첫 번째 계산의 0.04285714285714286 은 주행 거리 30, 연료량 700 을 넣은 결과.<br>(30 / 700. 입력 순서가 반복문1-2 와 반대 : 여기서는 주행 거리를 먼저 묻는다)

## 3. 순열 nPr (for)

`4강 실습` · 📄 [`PermutationFor.java`](PermutationFor.java)

#### 문제

> ※ 반복 시 for 문만 사용하시오.
>
> 서로 다른 n 개에서 r 개를 택하여 일렬로 나열할 수 있는 경우의 수를 순열(permutation)이라 하고, nPr 로 표시한다. 순열은 아래의 수식에 의해 구할 수 있는데, 이를 프로그램으로 작성하라.<br>n 과 r 은 사용자로부터 입력 받도록 한다.
>
> nPr = n(n-1) ... (n-(r-1))

#### 💻 코드

<!-- code: PermutationFor.java -->
```java
import java.util.Scanner;

public class PermutationFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n ? ");
        int n = sc.nextInt();
        System.out.print("r ? ");
        int r = sc.nextInt();
        sc.close();                 // ⚠ 추가

        int prod = 1;
        for (int i = 0; i < r; i++) {
            prod *= (n - i);
        }
        System.out.print(n + "P" + r + " : " + prod);
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
순열의 n값과 r값을 입력하시오 : 3 2
3P2순열의 값은 6입니다.
```

#### 실행 예

```text
n ? 6
r ? 4
6P4 : 360
```

**포인트**

- 반복문1-3 (while) 을 for 로 옮긴 것.
  ```java
  while 버전                     for 버전
  int i = 0;      (반복문 앞)    →  for (int i = 0;
  while (i < r)                  →             i < r;
  i++;            (블록 마지막)  →                    i++)
  ```
- 반복 횟수(r 번)가 정해져 있으므로 while 보다 for 가 자연스럽다.
- i 를 for 안에서 선언했으므로 반복문이 끝나면 i 는 사라진다. (4-3 변수 범위)
- prod 는 반복문 밖에서도 써야 하므로(출력) 밖에서 선언했다.

- ⚠ 반복문1-3 과 달리 sc.close() 를 하지 않았다. (프로그램이 끝나면 함께 정리되긴 하지만, Eclipse 가 "Resource leak: 'sc' is never closed" 경고를 띄운다. 아래에 추가했다)

## 4. 피라미드 출력 (for) + 필기한 쌍둥이 피라미드

`4강 실습` · 📄 [`PyramidFor.java`](PyramidFor.java)

#### 문제

> ※ 반복 시 for 문만 사용하시오.
>
> 아래와 같은 모양을 출력하는 프로그램을 작성하시오. 중첩 반복문을 사용토록 한다.<br>한 개의 공백과 한 개의 '\*' 를 출력하는 문을 반복 사용하여 작성하여야 한다.
>
> \*<br>\*\*\*<br>\*\*\*\*\*<br>\*\*\*\*\*\*\*

#### 💻 코드

<!-- code: PyramidFor.java -->
```java
public class PyramidFor {
    public static void main(String[] args) {
        pyramid();
        System.out.println();
        twinPyramid();
    }

    // 실습 4번 : 피라미드 하나
    static void pyramid() {
        int start = 3, end = 3;
        for (int r = 0; r <= 3; r++) {          // 행 : 0 ~ 3
            for (int c = 0; c <= 6; c++) {      // 열 : 0 ~ 6 (행이 바뀔 때마다 c = 0 부터 다시)
                if (start <= c && c <= end) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
            start--; end++;
        }
    }

    // 📝 확장 : 피라미드 두 개
    static void twinPyramid() {
        int start1 = 3, end1 = 3, start2 = 11, end2 = 11;
        for (int r = 0; r <= 3; r++) {
            for (int c = 0; c <= 14; c++) {
                if (start1 <= c && c <= end1) System.out.print("*");
                else if (start2 <= c && c <= end2) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
            start1--; end1++; start2--; end2++;
        }
    }
}
```
<!-- /code -->

#### 실행 예 (pyramid)

```text
   *
  ***
 *****
*******
```

#### 실행 예 (twinPyramid)

```text
   *       *
  ***     ***
 *****   *****
******* *******
```

**포인트**

- 반복문1-4 (while) 의 "start, end 발상" 을 그대로 for 로 옮긴 것.<br>start, end : 3,3 → 2,4 → 1,5 → 0,6
- while 버전에서 직접 해 줘야 했던 col = 0; (행마다 초기화) 이<br>for 에서는 안쪽 for 의 초기화 부분 int c = 0 이 자동으로 해 준다.<br>→ 안쪽 for 가 다시 시작될 때마다 초기화 부분이 다시 실행되기 때문.
- 행/열 변수 r, c 는 for 안에서 선언 → 반복문 밖에서는 쓸 수 없다.<br>start, end 는 행이 바뀌어도 값이 이어져야 하므로 바깥에서 선언했다.

- 📝 필기 : 확장 - 피라미드 두 개 (칠판 그림)

열 :  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14

```text
    *                 *
  * * *            *  *  *
* * * * *       *  *  *  *  *
```

\* \* \* \* \* \* \*  \*  \*  \*  \*  \*  \*

- 폭을 15칸(0 \~ 14)으로 늘리고, 두 번째 피라미드의 꼭대기를 11 열에 둔다.
- 피라미드마다 start, end 를 따로 둔다. (start1, end1 = 3,3 / start2, end2 = 11,11)
- if 에서 첫 번째 구간이 아니면 else if 로 두 번째 구간을 검사, 둘 다 아니면 공백.
- 행이 끝날 때 네 변수를 모두 갱신한다. (start1--, end1++, start2--, end2++)
- 💡 마지막 행에서 첫 번째는 0 \~ 6, 두 번째는 8 \~ 14 → 7 열 한 칸이 비어 두 피라미드가 붙지 않는다.

---

[🏠 4주차 학습 가이드](../../README.md)
