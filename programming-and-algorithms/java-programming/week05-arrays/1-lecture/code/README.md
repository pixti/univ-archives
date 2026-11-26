# 5주차 강의 예제 코드

[🏠 5주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [ArrayBasics.java](#배열-선언--생성--접근--선언과-동시에-초기화) | 배열 선언 · 생성 · 접근 · 선언과 동시에 초기화 |
| [ReferenceArray.java](#레퍼런스형객체-배열) | 레퍼런스형(객체) 배열 |
| [ArrayTypicalUsage.java](#배열의-전형적인-사용-예-출력--합--최대값--최소값) | 배열의 전형적인 사용 예 (출력 · 합 · 최대값 · 최소값) |
| [ReadIntoArray.java](#5-값-배열에-읽어들이기) | 값을 배열에 읽어들이기 |
| [ScoreStatistics.java](#실습-학생-성적-데이터-처리하기--평균-최대소값) | [실습] 학생 성적 처리 (평균, 최대·최소). ⚠ 합계에서 `array[0]`이 빠지는 실수 |
| [ArraySort.java](#배열-정렬--javautilarrays-의-정적-메소드-sort) | `Arrays.sort` |
| [DescendingSort.java](#내림차순-정렬--두-변수-교환swap) | 내림차순 정렬 + 두 변수 교환(swap) |
| [ScoreSort.java](#실습-학생-성적-정렬) | [실습] 학생 성적 정렬. ⚠ `sort(array, 0, cnt-1)` → `cnt` |
| [BinarySearchTest.java](#배열-탐색--javautilarrays-의-정적-메소드-binarysearch) | `Arrays.binarySearch` |
| [ScoreSortSearch.java](#실습-학생-성적-정렬-및-검색하기) | [실습] 학생 성적 정렬 및 검색 |
| [ArrayCopy.java](#배열-복사--레퍼런스-복사공유-vs-clone-복사--2차원-배열의-clone) | 레퍼런스 복사(공유) vs `clone()`, 2차원 배열의 `clone()` |
| [MultiDimensionArray.java](#다차원-배열-선언--생성--접근--자바의-다차원-배열-구조) | 다차원 배열 선언 · 생성 · 접근, 자바의 다차원 배열 구조 |
| [JaggedArray.java](#jagged-배열-행마다-길이가-다른-배열) | Jagged 배열 (행마다 길이가 다른 배열) |
| [MultiDimensionTest.java](#다차원-배열-출력--arraylength-와-arrayilength) | `array.length`와 `array[i].length` |
| [MatrixAdd.java](#실습-행렬-덧셈) | [실습] 행렬 덧셈 |

---

## 배열 선언 · 생성 · 접근 · 선언과 동시에 초기화

`5-1 배열1` · 📄 [`ArrayBasics.java`](ArrayBasics.java)

#### 💻 코드

<!-- code: ArrayBasics.java -->
```java
import java.util.Arrays;

public class ArrayBasics {
    public static void main(String[] args) {
        double [] array;                 // double array[]도 가능하나 권장 x
        array = new double[3];           // double 형 데이터 3개 저장 가능
        System.out.println("생성 직후 : " + Arrays.toString(array));

        array[0] = 1.0;                  // 첨자를 붙여 접근, 초기화
        array[1] = 2.0;
        array[2] = 3.0;
        System.out.println("대입 후   : " + Arrays.toString(array));

        // 선언과 동시에 초기화 (크기는 값의 개수로 자동 결정)
        double [] array2 = new double[] {1.0, 2.0, 3.0};
        double [] array3 = {1.0, 2.0, 3.0};                 // 축약 형태
        // double [] array4 = new double[3] {1.0, 2.0, 3.0}; // ❌ 명시적으로 크기를 쓰면 컴파일 오류
        System.out.println("초기화 1  : " + Arrays.toString(array2));
        System.out.println("초기화 2  : " + Arrays.toString(array3));

        // 💡 new 로 만든 배열의 기본값
        System.out.println("기본값    : " + Arrays.toString(new int[2]) + " "
                + Arrays.toString(new boolean[2]) + " " + Arrays.toString(new String[2]));

        System.out.println("array.length = " + array.length);   // length 는 필드 → 괄호 없음

        // 💡 인덱스는 0 ~ length-1. 범위를 벗어나면 실행 중 예외
        try {
            array[3] = 4.0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("array[3] 접근 → " + e);
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
생성 직후 : [0.0, 0.0, 0.0]
대입 후   : [1.0, 2.0, 3.0]
초기화 1  : [1.0, 2.0, 3.0]
초기화 2  : [1.0, 2.0, 3.0]
기본값    : [0, 0] [false, false] [null, null]
array.length = 3
array[3] 접근 → ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
```

**포인트**

- double \[] array;           선언 : 배열을 "가리킬" 참조 변수만 생긴다.  (double array\[] 도 가능하나 권장 x)
- array = new double\[3];     생성 : double 3칸이 만들어지고 기본값 0.0 으로 채워진다.
- array\[0] = 1.0;            첨자(인덱스)를 붙여 접근. 인덱스는 0 \~ length-1.
- new double\[] {1.0, 2.0, 3.0} / {1.0, 2.0, 3.0}<br>선언과 동시에 초기화. 크기는 값의 개수로 자동 결정.
  ```text
  new double[3] {1.0, 2.0, 3.0} 처럼 크기를 쓰면 컴파일 오류.
  ```

- 💡 축약형 {...} 은 "선언할 때만" 쓸 수 있다.
  ```java
  double[] a;  a = {1.0, 2.0};              // ❌ 컴파일 오류
  double[] a;  a = new double[] {1.0, 2.0}; // ✅
  ```
- 💡 기본값 : 정수 0, 실수 0.0, boolean false, char '\\u0000', 참조형 null
- 💡 범위 밖 인덱스는 컴파일은 되지만 실행 중 ArrayIndexOutOfBoundsException.

## 레퍼런스형(객체) 배열

`5-1 배열1` · 📄 [`ReferenceArray.java`](ReferenceArray.java)

레퍼런스형인 경우 추가로 작업이 필요하다.<br>배열 객체가 생성되면 객체의 레퍼런스를 저장할 공간만 확보된다. (실제 객체 생성 x)

```text
array ──▶ [  ●  |  ●  |  ●  ]
             │     │     └──▶ ( ExampleClass 객체 )
             │     └────────▶ ( ExampleClass 객체 )
             └──────────────▶ ( ExampleClass 객체 )
```

#### 💻 코드

<!-- code: ReferenceArray.java -->
```java
public class ReferenceArray {

    static class ExampleClass {
        private final int value;

        ExampleClass(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        ExampleClass [] array = new ExampleClass[3];
        System.out.println("생성 직후 array[0] = " + array[0]);   // 레퍼런스 공간만 확보 → null

        for (int i = 0; i < 3; i++) {
            array[i] = new ExampleClass(i);                        // 실제 객체 생성
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "].getValue() = " + array[i].getValue());
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
생성 직후 array[0] = null
array[0].getValue() = 0
array[1].getValue() = 1
array[2].getValue() = 2
```

**포인트**

- new ExampleClass\[3] 직후에는 세 칸 모두 null.<br>이 상태에서 array\[0].getValue() 를 부르면 NullPointerException.
- 그래서 반복문으로 칸마다 new 로 객체를 하나씩 만들어 넣는다.

- 💡 ExampleClass 는 강의 코드에 정의가 없어서, 숫자 하나를 기억하는 간단한 클래스로 만들었다.<br>(클래스와 생성자는 이후 주차에서 배운다.)

## 배열의 전형적인 사용 예 (출력 · 합 · 최대값 · 최소값)

`5-1 배열1` · 📄 [`ArrayTypicalUsage.java`](ArrayTypicalUsage.java)

전형적인 사용 예를 배워두면 도움이 된다.

#### 💻 코드

<!-- code: ArrayTypicalUsage.java -->
```java
public class ArrayTypicalUsage {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // 1. 출력 예
        System.out.print("1. 출력 : ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();

        // 2. 원소의 합
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println("2. 합 : " + sum);

        // 3. 원소의 최대값 구하기
        int max = array[0], maxPos = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxPos = i;
            }
        }
        System.out.println("3. 최대 : " + max + ", 최대 위치 : " + maxPos);

        // 4. 원소의 최소값 구하기
        int min = array[0], minPos = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minPos = i;
            }
        }
        System.out.println("4. 최소 : " + min + ", 최소 위치 : " + minPos);
    }
}
```
<!-- /code -->

#### 실행 예

```text
1. 출력 : 1 2 3 4 5
2. 합 : 15
3. 최대 : 5, 최대 위치 : 4
4. 최소 : 1, 최소 위치 : 0
```

**포인트**

- 반복 조건은 숫자 대신 array.length  (length 는 필드라서 괄호 없음. String 의 length() 와 구분)
- 최대/최소는 첫 원소 array\[0] 으로 시작하고 i = 1 부터 비교한다.<br>4주차 성적 처리처럼 -1, 101 같은 "나올 수 없는 값" 을 몰라도 된다.
- 위치(maxPos, minPos)도 함께 기억하려면 값을 바꿀 때 i 도 같이 저장.
- \> (엄격한 비교) 라서 최대값이 여러 개면 가장 앞의 위치가 남는다. (>= 면 가장 뒤)

- 💡 1. 출력 예를 println(array\[i] + " ") 로 쓰면 println 이라 한 줄에 하나씩 찍힌다.<br>한 줄로 보려고 여기서는 print 로 바꿨다.

## 5. 값 배열에 읽어들이기

`5-1 배열1` · 📄 [`ReadIntoArray.java`](ReadIntoArray.java)

몇 개가 입력될지 모를 때 : 최대 크기로 배열을 만들어 두고, 실제 개수는 따로 센다.

#### 💻 코드

<!-- code: ReadIntoArray.java -->
```java
import java.util.Scanner;

public class ReadIntoArray {
    public static void main(String[] args) {
        final int MAX_SIZE = 100;
        int [] array = new int [MAX_SIZE];   // 최대 크기로
        int val, idx = 0;
        Scanner sc = new Scanner(System.in);
        val = sc.nextInt();
        while (val >= 0) {
            array[idx] = val; idx++;
            val = sc.nextInt();
        }
        System.out.println("읽어들인 데이터 개수 : " + idx);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
10 20 30 -1
읽어들인 데이터 개수 : 3
```

**포인트**

- final int MAX\_SIZE = 100; : 바꿀 수 없는 상수. 숫자 대신 이름을 쓰면 뜻이 드러나고 한 곳만 고치면 된다.
- idx 의 두 가지 역할 : "다음에 넣을 위치" 이자 "지금까지 읽은 개수".
- 이후 처리는 array.length(100) 가 아니라 idx 까지만. 나머지 칸은 기본값 0.
- 입력 → 검사 → 처리 → 다시 입력 (4주차와 같은 구조) → 종료 값(음수)은 배열에 안 들어간다.

- 💡 100 개보다 많이 넣으면 array\[100] 에서 ArrayIndexOutOfBoundsException.<br>안전하게 하려면 while (val >= 0 && idx &lt; MAX\_SIZE)

## \[실습] 학생 성적 데이터 처리하기 – 평균, 최대(소)값

`5-1 배열1` · 📄 [`ScoreStatistics.java`](ScoreStatistics.java)

0 \~ 100 사이의 점수를 배열에 모두 저장한 뒤, 반복문으로 평균 · 최대값 · 최소값을 구한다.

#### 💻 코드

<!-- code: ScoreStatistics.java -->
```java
import java.util.Scanner;

public class ScoreStatistics {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0;
        int [] array = new int[100];

        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외의 값 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            array[cnt] = val;
            cnt = cnt + 1;   // 입력 정수의 개수 세기
            System.out.println("0과 100 사이 값 입력 (그외의 값 종료) : ");
            val = sc.nextInt();
        }

        if (cnt != 0) {
            sum = array[0];                          // 합도 첫 원소부터 시작 (sum = 0 이면 array[0] 누락)
            int min = array[0];
            int max = array[0];
            for (int i = 1; i < cnt; i++) {
                sum += array[i];                     // 합 구하기
                if (array[i] > max) max = array[i];  // 최대값 구하기
                if (array[i] < min) min = array[i];  // 최소값 구하기
            }
            System.out.println("평균 : " + (double) sum / cnt);
            System.out.println("최대값 : " + max);
            System.out.println("최소값 : " + min);
        } else {
            System.out.println("입력된 성적이 없습니다.");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
0과 100 사이의 값을 입력 (그외의 값 종료) :
50
0과 100 사이 값 입력 (그외의 값 종료) :
60
0과 100 사이 값 입력 (그외의 값 종료) :
70
0과 100 사이 값 입력 (그외의 값 종료) :
-1
평균 : 60.0
최대값 : 70
최소값 : 50
```

**포인트**

- 4주차 ScoreProcessing 은 입력받는 순간 계산했다. 여기서는 "일단 배열에 저장 → 나중에 처리".<br>값이 남아 있으므로 정렬(5-2)이나 표준편차(과제 4번)처럼 두 번 이상 훑는 처리도 할 수 있다.
- cnt : 입력 정수의 개수이자 다음에 저장할 위치.
- 최대/최소는 array\[0] 으로 시작, i = 1 부터 비교.

**⚠ 자주 틀리는 부분**

  1) sum = 0 에서 시작하면서 for (int i = 1; ...) sum += array\[i]; 로 돌리면 array\[0] 이 합에서 빠진다.<br>50, 60, 70 을 넣으면 평균이 60.0 이 아니라 43.333333333333336 (= 130 / 3).<br>→ 합도 sum = array\[0] 으로 시작한다.
  2) if (cnt != 0) 가 평균 한 줄에만 걸려 있으면<br>처음부터 범위 밖 값을 넣었을 때 최대값 · 최소값이 0 으로 출력된다.<br>→ 세 줄을 모두 if 블록 안에 넣고, 입력이 없으면 안내 문구를 출력한다.

## 배열 정렬 : java.util.Arrays 의 정적 메소드 sort

`5-2 배열2` · 📄 [`ArraySort.java`](ArraySort.java)

다양한 정렬 방법이 있고 방법에 따라 코드가 다양하다.<br>여기서는 java.util.Arrays 클래스의 정적 메소드 sort 를 사용한다.

#### 💻 코드

<!-- code: ArraySort.java -->
```java
import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 4};

        for (int e : array)   // 정렬 전 원소 출력
            System.out.print(e + " ");
        System.out.println();

        Arrays.sort(array);   // 배열 정렬

        for (int e : array)   // 정렬 후 원소 출력
            System.out.print(e + " ");
        System.out.println();

        System.out.println(Arrays.toString(array));   // 💡 한 번에 출력
    }
}
```
<!-- /code -->

#### 실행 예

```text
1 5 3 2 4
1 2 3 4 5
[1, 2, 3, 4, 5]
```

**포인트**

- 정적(static) 메소드 : 객체 없이 클래스이름.메소드() 로 부른다. (Math.random() 과 같은 방식)
- Arrays.sort(array) 는 원본 배열 자체를 오름차순으로 바꾼다. (반환형 void)
- for (int e : array) : 4-4 에서 배운 foreach. 인덱스 없이 원소를 하나씩 꺼낸다.

- 💡 정렬 전/후 출력 사이에 줄바꿈이 없으면 한 줄에 이어진다. 구분하려고 println() 을 넣었다.
- 💡 Arrays.toString(array) 를 쓰면 \[1, 2, 3, 4, 5] 형태로 한 번에 출력할 수 있다.

## 내림차순 정렬 + 두 변수 교환(swap)

`5-2 배열2` · 📄 [`DescendingSort.java`](DescendingSort.java)

1) int 배열 : 내림차순으로 정렬해 주는 메소드가 별도로 없다.<br>→ 오름차순 정렬 후 역순으로 재정렬한다.

```text
정렬 후   [1, 2, 3, 4, 5]
i=0 교환  [5, 2, 3, 4, 1]   a[0] ↔ a[4]
i=1 교환  [5, 4, 3, 2, 1]   a[1] ↔ a[3]
```

(a\[2] 는 가운데라 그대로. 5/2 = 2 번만 반복)

  - a.length / 2 까지만 : 끝까지 돌면 바꾼 것을 한 번 더 바꿔서 원래대로 돌아간다.
  - a.length - (i + 1) == a.length - 1 - i : i 번째와 대칭인 위치.

2) 객체 배열(String\[] 등) : sort 에 Comparator 객체를 인수로 넘겨 내림차순 정렬 가능.
  ```java
  Arrays.sort(b, Collections.reverseOrder());
  ```
  - 💡 Collections.reverseOrder() 는 "반대 순서로 비교하는 규칙" 을 만들어 준다.
  - 💡 int\[] 에는 못 쓴다. Comparator 는 객체끼리 비교하는 규칙이라 기본형 int 에는 적용되지 않는다.<br>(Integer\[] 로 만들면 가능)

3) 두 변수 교환
  ```text
  a = b; b = a;          ❌ a 의 원래 값이 사라져 둘 다 3
  ```<br>tmp = a; a = b; b = tmp;  ✅ 덮어쓰기 전에 tmp 에 옮겨 둔다
  - ⚠ 자주 틀리는 부분 : int a=0; b=3; 은 문법 오류 (b 가 선언되지 않음) → int a = 0, b = 3;

#### 💻 코드

<!-- code: DescendingSort.java -->
```java
import java.util.Arrays;
import java.util.Collections;

public class DescendingSort {
    public static void main(String[] args) {
        // 1) int 배열 : 오름차순 정렬 후 뒤집기
        int [] a = new int[]{4, 2, 3, 1, 5};
        Arrays.sort(a);
        for (int i = 0; i < a.length / 2; i++) {   // a.length 는 a배열의 크기를 알려줌
            int temp = a[i];
            a[i] = a[a.length - (i + 1)];
            a[a.length - (i + 1)] = temp;
        }
        System.out.println("int 내림차순    : " + Arrays.toString(a));

        // 2) 객체 배열 : Comparator 로 내림차순
        String[] b = {"aa", "ff", "dd", "bb"};
        Arrays.sort(b, Collections.reverseOrder());
        System.out.println("String 내림차순 : " + Arrays.toString(b));

        // 3) 두 변수 교환
        int x = 0, y = 3;      // ⚠ int x=0; y=3; 로 쓰면 y 가 선언되지 않아 문법 오류
        x = y;
        y = x;
        System.out.println("잘못된 교환 : a = " + x + ", b = " + y);

        x = 0; y = 3;
        int tmp = x;
        x = y;
        y = tmp;
        System.out.println("올바른 교환 : a = " + x + ", b = " + y);
    }
}
```
<!-- /code -->

#### 실행 예

```text
int 내림차순    : [5, 4, 3, 2, 1]
String 내림차순 : [ff, dd, bb, aa]
잘못된 교환 : a = 3, b = 3
올바른 교환 : a = 3, b = 0
```

#### 📒 해설

- 📝 필기 (실습 배열(1) 4번) : 배열의 대칭성을 이용해 arr.length/2 의 값을 이용해 스왑시켜주면 된다.<br>\[7, 6, 5, 4, 3] 이라 하면 중앙 5 를 기준으로 0번째 - 4번째, 1번째 - 3번째 끼리 대칭 관계.<br>일반화 하면 i번째 - (배열길이 - i - 1) 끼리 대칭 관계.  → 3-practice/arrays1/ReverseArray.java

## \[실습] 학생 성적 정렬

`5-2 배열2` · 📄 [`ScoreSort.java`](ScoreSort.java)

#### 💻 코드

<!-- code: ScoreSort.java -->
```java
import java.util.Arrays;
import java.util.Scanner;

public class ScoreSort {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0;
        int [] array = new int[100];

        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외 값 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            array[cnt] = val;
            cnt = cnt + 1;   // 입력 정수의 개수 세기
            System.out.println("0과 100 사이의 값 입력 (그외 값 종료) : ");
            val = sc.nextInt();
        }

        System.out.print("정렬 전 성적 : ");
        for (int i = 0; i < cnt; i++) System.out.print(array[i] + " ");
        System.out.println();

        // Arrays.sort(array);           // 범위지정하지 않으면 실행결과 모두 0
        // Arrays.sort(array, 0, cnt-1); // ⚠ 마지막 원소가 정렬에서 빠진다
        Arrays.sort(array, 0, cnt);      // [0, cnt) : 값이 들어 있는 부분만 정렬

        System.out.print("정렬 후 성적 : ");
        for (int i = 0; i < cnt; i++) System.out.print(array[i] + " ");
        System.out.println();
        sc.close();
    }
}
```
<!-- /code -->

#### 포인트 : 범위를 지정하지 않으면 실행결과가 모두 0 인 이유

```text
- 배열 크기는 100 인데 값은 cnt 개만 들어 있고, 나머지 칸은 기본값 0.
- Arrays.sort(array) 는 100 칸 전체를 정렬 → 0 이 앞으로 몰리고 입력값은 맨 뒤로 밀려난다.
- 출력은 cnt 개까지만 하므로 0 0 0 0 이 보인다.
    (실행 화면 : 정렬 전 성적 : 50 40 30 70 / 정렬 후 성적 : 0 0 0 0)
- 그래서 Arrays.sort(배열, 시작, 끝) 으로 값이 있는 부분만 정렬한다.
```

#### 실행 예

```text
0과 100 사이의 값을 입력 (그외 값 종료) :
50
0과 100 사이의 값 입력 (그외 값 종료) :
40
0과 100 사이의 값 입력 (그외 값 종료) :
70
0과 100 사이의 값 입력 (그외 값 종료) :
30
0과 100 사이의 값 입력 (그외 값 종료) :
-1
정렬 전 성적 : 50 40 70 30
정렬 후 성적 : 30 40 50 70
```

#### 📒 해설

- ⚠ 자주 틀리는 부분 : Arrays.sort(array, 0, cnt-1)<br>toIndex(끝)는 포함하지 않는다(exclusive). cnt-1 이면 array\[0] \~ array\[cnt-2] 만 정렬되고 마지막 값은 정렬에서 빠진다.
  - 입력 50 40 30 70 은 마지막 70 이 우연히 가장 커서 맞게 나온다.
  - 50 40 70 30 을 넣으면 "40 50 70 30" 이 나온다.
- 💡 "시작 포함, 끝 미포함" \[0, cnt) 은 자바 전체의 관례. 개수가 정확히 cnt 개가 된다.
- 💡 sum 은 선언만 되고 쓰이지 않는다. (앞 실습 코드를 고쳐 쓰다 남은 것) 그대로 두었다.

## 배열 탐색 : java.util.Arrays 의 정적 메소드 binarySearch

`5-2 배열2` · 📄 [`BinarySearchTest.java`](BinarySearchTest.java)

- 탐색 방법도 다양하고, 방법에 따라 코드가 다양하다.
- java.util.Arrays 가 정적 메소드 binarySearch 를 제공한다.
- 다양한 배열 객체에 대해 동작하도록 중복정의(overloading) 되어 있다.
- 원하는 값(키)이 존재할 경우 그 위치의 첨자 값을 반환한다.

#### 💻 코드

<!-- code: BinarySearchTest.java -->
```java
import java.util.Arrays;

public class BinarySearchTest {   // int idx = Arrays.binarySearch(배열, 키) 형태로 쓴다
    public static void main(String[] args) {
        int [] a = new int[]{3, 2, 1, 4, 5};
        Arrays.sort(a);
        int i = Arrays.binarySearch(a, 3);
        System.out.println(i);
        i = Arrays.binarySearch(a, 0);   // 찾는 값이 없음 -1 출력
        System.out.println(i);
        i = Arrays.binarySearch(a, 6);   // 찾는 값이 없음 -6 출력
        System.out.println(i);
    }
}
```
<!-- /code -->

#### 실행 예

```text
2
-1
-6
```

**포인트**

- 이진 탐색은 정렬된 배열에서 가운데 값과 비교해 절반씩 범위를 줄여 찾는다 → 반드시 먼저 정렬.
- 정렬 후 a = \[1, 2, 3, 4, 5] → 3 의 위치는 2.

- 💡 값이 없을 때 반환값 = -(삽입 위치) - 1<br>삽입 위치 = "그 값이 있었다면 들어갔을 자리"<br>0 → 맨 앞 (삽입 위치 0) → -0 - 1 = -1<br>6 → 맨 뒤 (삽입 위치 5) → -5 - 1 = -6<br>-1 을 더 빼는 이유 : 그냥 -삽입위치 면 삽입 위치 0 일 때 0 이 되어 "0번째에 있음" 과 구분이 안 된다.<br>→ 결국 "음수면 없음" 으로 판단하면 된다.
- 💡 중복정의 : binarySearch(int\[], int), binarySearch(double\[], double),<br>binarySearch(int\[], 시작, 끝, int) ... 이름은 같고 매개변수가 다르다.
- 💡 같은 값이 여러 개면 그중 어느 위치가 반환될지 보장되지 않는다.

## \[실습] 학생 성적 정렬 및 검색하기

`5-2 배열2` · 📄 [`ScoreSortSearch.java`](ScoreSortSearch.java)

#### 💻 코드

<!-- code: ScoreSortSearch.java -->
```java
import java.util.Arrays;
import java.util.Scanner;

public class ScoreSortSearch {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0;
        int [] array = new int[100];

        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외 값 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            array[cnt] = val;
            cnt = cnt + 1;   // 입력 정수의 개수 세기
            System.out.println("0과 100 사이 값 입력 (그외 값 종료) : ");
            val = sc.nextInt();
        }

        Arrays.sort(array, 0, cnt);   // 마찬가지로 시작과 끝을 지정

        System.out.print("정렬 후 성적 : ");
        for (int i = 0; i < cnt; i++) System.out.print(array[i] + " ");
        System.out.println();

        System.out.print("찾고자 하는 성적을 입력하세요 : ");
        val = sc.nextInt();

        int i = Arrays.binarySearch(array, 0, cnt, val);
        if (i < 0)
            System.out.println("성적이 존재하지 않습니다.");
        else
            System.out.println("성적은 " + (i + 1) + " 번째에 존재합니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
0과 100 사이의 값을 입력 (그외 값 종료) :
50
0과 100 사이 값 입력 (그외 값 종료) :
40
0과 100 사이 값 입력 (그외 값 종료) :
30
0과 100 사이 값 입력 (그외 값 종료) :
70
0과 100 사이 값 입력 (그외 값 종료) :
-1
정렬 후 성적 : 30 40 50 70
찾고자 하는 성적을 입력하세요 : 40
성적은 2 번째에 존재합니다.
```

**포인트**

- 정렬과 마찬가지로 탐색도 binarySearch(배열, 시작, 끝, 키) 로 값이 있는 부분만 탐색.<br>범위를 안 주면 뒤쪽 0 들까지 탐색 대상이 된다.
- 반환값은 인덱스(0부터). 사람에게 보여 줄 때는 i + 1 로 "몇 번째"(1부터)로 바꾼다.
- 음수면 "없음". (BinarySearchTest 참고)

- ⚠ 자주 틀리는 부분 : binarySearch(array, 0, cnt-1, val) 처럼 끝을 cnt-1 로 주면 마지막(가장 큰) 성적을 검색했을 때 "존재하지 않습니다" 가 나온다. 끝은 cnt 로 준다.
- 💡 sum 은 쓰이지 않는다. (앞 실습 코드를 고쳐 쓰다 남은 것)

## 배열 복사 : 레퍼런스 복사(공유) vs clone() (복사) + 2차원 배열의 clone

`5-3 배열3` · 📄 [`ArrayCopy.java`](ArrayCopy.java)

1) int\[] myArray2 = myArray1;<br>배열 변수에 저장된 레퍼런스가 복사되어 배열 객체를 공유한다.

```text
myArray1 ──┐
           ├──▶ [ 1 | 0 | 3 ]     배열 객체는 1개
myArray2 ──┘
```

2) int\[] myArray2 = myArray1.clone();<br>배열 자체를 복사하고 싶으면 배열 객체의 clone 메소드를 사용한다.

```text
myArray1 ──▶ [ 1 | 2 | 3 ]     원본 그대로
myArray2 ──▶ [ 1 | 0 | 3 ]     새로 만들어진 복사본
```

#### 💻 코드

<!-- code: ArrayCopy.java -->
```java
import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        System.out.println("=== 1) 레퍼런스 복사 ===");
        {
            int[] myArray1 = new int[] {1, 2, 3};
            int[] myArray2 = myArray1;   // 레퍼런스가 복사되어 배열 공유
            myArray2[1] = 0;
            System.out.println(myArray1[1]);
        }

        System.out.println("=== 2) clone ===");
        {
            int[] myArray1 = new int[] {1, 2, 3};
            int[] myArray2 = myArray1.clone();
            myArray2[1] = 0;
            System.out.println(myArray1[1]);
        }

        System.out.println("=== 3) 2차원 배열 clone ===");
        int[][] myArray2d = new int[][] { {1, 0, 3}, {6, 9, 12} };
        int[][] myArray2d2 = myArray2d.clone();

        myArray2d2[0][1] = 100;          // 행은 공유 → 원본도 바뀜
        System.out.println("clone 후 myArray2d2[0][1] = 100 → myArray2d[0][1] = " + myArray2d[0][1]);

        myArray2d2[1] = new int[] {7, 7, 7};   // 행 배열은 따로 복사됨 → 원본은 그대로
        System.out.println("clone 후 myArray2d2[1] = {7,7,7} → myArray2d[1] = " + Arrays.toString(myArray2d[1]));

        // 원소까지 복사 : 행마다 clone
        int[][] deep = new int[myArray2d.length][];
        for (int i = 0; i < myArray2d.length; i++)
            deep[i] = myArray2d[i].clone();
        deep[0][1] = -1;
        System.out.println("행마다 clone 후 deep[0][1] = -1 → myArray2d[0][1] = " + myArray2d[0][1]);
    }
}
```
<!-- /code -->

#### 실행 예

```text
=== 1) 레퍼런스 복사 ===
0
=== 2) clone ===
2
=== 3) 2차원 배열 clone ===
clone 후 myArray2d2[0][1] = 100 → myArray2d[0][1] = 100
clone 후 myArray2d2[1] = {7,7,7} → myArray2d[1] = [6, 9, 12]
행마다 clone 후 deep[0][1] = -1 → myArray2d[0][1] = 100
```

**📝 필기 (퀴즈 5번)**

myarray1 -> 레퍼런스 1 (3,1,2,3)<br>.clone() 하면 myarray2 -> 레퍼런스 2 (3,1,2,3)<br>값을 바꾸면 myarray2 -> 레퍼런스 2 (3,0,2,3) / myarray1 -> 레퍼런스 1 (3,1,2,3) 값은 유지됨 int\[] myarray2 = myarray1; 로 하면 myarray1 -> 레퍼런스 1, myarray2 -> 레퍼런스 1 이 되게 됨.<br>따라서 값을 바꾸면 둘 다 레퍼런스 1 (3,0,2,3)

3) 2차원 배열의 clone() : 행 배열만 복사되고 각 행은 공유된다. (얕은 복사)

```text
myArray2d ──▶ [ ● ]──▶ [ 1 | 0 | 3  ] ◀──[ ● ] ◀── myArray2d2
              [ ● ]──▶ [ 6 | 9 | 12 ] ◀──[ ● ]
```

원소까지 복사하려면 각 행도 일일이 clone 해 주어야 한다. (깊은 복사)

- 💡 clone() 이 복사하는 것은 "원소 값". 2차원 배열에서 바깥 배열의 원소 값은 각 행의 레퍼런스다.<br>그래서 레퍼런스만 복사되고 행은 공유된다.
- 💡 반대로 행 자체를 새 배열로 바꾸면(myArray2d2\[1] = ...) 원본은 영향을 받지 않는다.

## 다차원 배열 선언 · 생성 · 접근 + 자바의 다차원 배열 구조

`5-3 배열3` · 📄 [`MultiDimensionArray.java`](MultiDimensionArray.java)

일차원 배열과 사용법은 동일하며 차원만 늘리면 된다.

자바에서 다차원 배열은 일차원 배열을 이용하여 구현한다.<br>행 개수 크기의 1차원 배열이 생성되고, 그 원소에는 각 행에 해당하는 1차원 배열의 레퍼런스가 저장된다.

```text
myArray2d ──▶ [ ● ]──▶ [ 1 | 0 | 3  ]   ← 0행 (int[])
              [ ● ]──▶ [ 6 | 9 | 12 ]   ← 1행 (int[])

myArray2d.length    = 2  (행 개수)
myArray2d[0]        = 0행 전체 (int[])
```

myArray2d\[0].length = 3  (0행의 열 개수)

#### 💻 코드

<!-- code: MultiDimensionArray.java -->
```java
public class MultiDimensionArray {
    public static void main(String[] args) {
        // 2차원 배열 변수 선언
        int [][] myArray2d;

        // 2차원 배열 객체 생성 및 초기화
        myArray2d = new int[][] { {1, 0, 3}, {6, 9, 12} };

        // 3차원 배열 변수 선언 및 배열 객체 생성
        int [][][] myArray3d = new int[2][3][2];

        // 2차원 및 3차원 배열 객체 접근
        int x = myArray3d[1][2][0] + myArray2d[0][1];
        System.out.println("x = " + x);

        System.out.println("myArray2d.length = " + myArray2d.length);         // 행 개수
        System.out.println("myArray2d[0].length = " + myArray2d[0].length);   // 0행의 열 개수
        System.out.println("myArray3d : " + myArray3d.length + " x "
                + myArray3d[0].length + " x " + myArray3d[0][0].length);

        int[] row1 = myArray2d[1];   // 한 행 = 1차원 배열 하나
        System.out.print("myArray2d[1] 의 타입 : int[]  → ");
        for (int e : row1) System.out.print(e + " ");
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 예

```text
x = 0
myArray2d.length = 2
myArray2d[0].length = 3
myArray3d : 2 x 3 x 2
myArray2d[1] 의 타입 : int[]  → 6 9 12
```

**📝 필기 (퀴즈 6번)**

2차원 배열은 자바에서는 1차원 배열의 레퍼런스를 값으로 가지는 배열을 가지는 구조임.<br>플렉서블하지만 느림. int\[] 가 1차원 배열 \[] 를 가리킴 → int\[]\[] 로 선언하는 것임.<br>자바에서는 들쭉날쭉하게 열의 개수가 행마다 다르게 선언이 가능함.<br>C 에서는 1차원 배열이 연속적으로 나열된 구조임. 속도는 월등히 빠름. 열의 개수가 행마다 달라서는 안 됨.

  - 💡 보충 : C 도 정방행렬만 되는 것은 아니고, 모든 행 길이가 같은 직사각형(R × C)이면 된다.

- 💡 myArray3d 는 2 × 3 × 2 = 12 칸, 모두 기본값 0 → x = 0 + 0 = 0

## Jagged 배열 (행마다 길이가 다른 배열)

`5-3 배열3` · 📄 [`JaggedArray.java`](JaggedArray.java)

각 행의 차원이 다른 배열을 만들 수 있음. 이를 Jagged 배열이라고 부름.<br>배열 변수를 선언하고 초기화시 일차원 배열의 크기를 달리한다.

```text
jagged ──▶ [ ● ]──▶ [ 1 | 0 | 3 ]
           [ ● ]──▶ [ 6 | 9 ]
```

```java
방법 1) int[][] jagged = { new int[] {1, 0, 3}, new int[] {6, 9} };
방법 2) jagged = new int[2][];          // 2개의 행을 생성 (이 시점의 각 행은 null)
        jagged[0] = new int[]{1, 0, 3}; // 첫 번째 행 배열 객체 생성
        jagged[1] = new int[]{6, 9};    // 두 번째 행 배열 객체 생성
```

#### 💻 코드

<!-- code: JaggedArray.java -->
```java
public class JaggedArray {
    public static void main(String[] args) {
        System.out.println("방법 1");
        int[][] jagged = { new int[] {1, 0, 3}, new int[] {6, 9} };
        print(jagged);

        int [][] jagged2;
        jagged2 = new int[2][];               // 2개의 행을 생성
        System.out.println("방법 2 (행 생성 직후 jagged[0] = " + jagged2[0] + ")");
        jagged2[0] = new int[]{1, 0, 3};      // 첫 번째 행 배열 객체 생성
        jagged2[1] = new int[]{6, 9};         // 두 번째 행 배열 객체 생성
        print(jagged2);
    }

    static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {           // 행 개수
            for (int j = 0; j < array[i].length; j++) {    // i 행의 길이 (행마다 다름)
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
방법 1
1 0 3
6 9
방법 2 (행 생성 직후 jagged[0] = null)
1 0 3
6 9
```

#### 📒 해설

- 💡 열 크기만 비우는 것은 되지만 행 크기를 비우는 것은 안 된다 : new int\[]\[3] ❌
- 💡 new int\[2]\[] 직후 jagged\[0] 은 null. 각 행은 int\[] "객체" 이기 때문 (5-1 레퍼런스형 배열과 같은 이야기)
- 📝 필기 (퀴즈 7번) : int\[]\[] data = new int \[]\[] { {1,2,3}, {6,5}, {7,4,5,8} }; 자바에서는 들쭉날쭉한 2차원 배열 선언이 가능함.
- 📝 필기 (퀴즈 8번) : data\[r].length 라고 하면 r 행의 열의 크기를 알 수 있게 됨.<br>→ 안쪽 반복 조건을 array\[i].length 로 쓰면 jagged 배열도 그대로 처리된다.

## 다차원 배열 출력 : array.length 와 array\[i].length

`5-3 배열3` · 📄 [`MultiDimensionTest.java`](MultiDimensionTest.java)

#### 💻 코드

<!-- code: MultiDimensionTest.java -->
```java
public class MultiDimensionTest {
    public static void main(String[] args) {
        int[][] array = {{62, 17, 4, 64}, {18, 96, 29, 5}, {6, 3, 6, 5}};

        for (int i = 0; i < array.length; i++) {            // 다차원 배열의 행 개수
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {     // i 행의 1차원 배열 크기
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 예

```text
62 17 4 64
18 96 29 5
6 3 6 5
```

**포인트**

- 바깥 for : 행  (array.length    = 3)
- 안쪽 for : 열  (array\[i].length = 4)
- 안쪽 조건을 4 나 array\[0].length 가 아니라 array\[i].length 로 쓰면 jagged 배열도 그대로 출력된다.

- 📝 필기 (실습 배열(2) 6번) : 바깥쪽 i 는 행(row)을 담당하고, 안쪽 j 는 열(column)을 담당합니다.<br>여기서 중요한 것은 for 문을 두 개 사용하는 것입니다.

- 💡 줄바꿈을 행 출력 "앞" 에 하므로 첫 줄이 빈 줄이고, 마지막에 println() 을 한 번 더 한다.<br>보통은 안쪽 for "뒤" 에 println() 을 두는 형태(MatrixAdd)를 더 많이 쓴다.

## \[실습] 행렬 덧셈

`5-3 배열3` · 📄 [`MatrixAdd.java`](MatrixAdd.java)

3 × 3 행렬 두 개를 0 \~ 99 난수로 채우고 더한다.

#### 💻 코드

<!-- code: MatrixAdd.java -->
```java
import java.util.Random;

public class MatrixAdd {
    public static void main(String[] args) {
        int [][] m1 = new int[3][3];
        int [][] m2 = new int[3][3];
        int [][] m3 = new int[3][3];
        Random rnd = new Random();

        // 행렬 초기화
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = rnd.nextInt(100);
                m2[i][j] = rnd.nextInt(100);
            }
        }

        // 행렬 덧셈
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[i].length; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        // m1 행렬 출력
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // m2 행렬 출력
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                System.out.print(m2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");

        // m3 행렬 출력
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[i].length; j++) {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```
<!-- /code -->

#### 실행 예  (난수라 매번 다름)

```text
31 99 99
84 64 97
17 73 35

18 83 23
86 48 22
51 46 22
================
49 182 122
170 112 119
68 119 57
```

**포인트**

- 행렬 덧셈은 같은 위치끼리 더한다 : m3\[i]\[j] = m1\[i]\[j] + m2\[i]\[j]   (예 : 31 + 18 = 49)
- rnd.nextInt(100) : 0 이상 100 미만 (0 \~ 99)
- 초기화 · 덧셈 · 출력 모두 "바깥 for = 행, 안쪽 for = 열" 의 이중 for.

- 💡 같은 "행렬 출력" 코드가 세 번 반복된다. 메소드로 빼면 printMatrix(m1); 처럼 한 줄로 줄일 수 있다.<br>(과제 배열(2) 3 · 4 번의 리팩터링 코드가 그렇게 했다.)
- 💡 행렬 곱셈은 같은 위치끼리 곱하는 것이 아니다. → 4-assignment/arrays2/MatrixMultiply.java

---

[🏠 5주차 학습 가이드](../../README.md)
