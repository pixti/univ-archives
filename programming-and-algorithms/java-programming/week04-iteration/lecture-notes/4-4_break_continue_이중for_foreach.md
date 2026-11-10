# 4-4. 반복문 4: break · continue · 이중 for · foreach

> 원본: `4-4 반복문4.pptx`
> 관련 코드: [`examples/BreakExample.java`](../examples/BreakExample.java), [`examples/PrimeCheck.java`](../examples/PrimeCheck.java), [`examples/ContinueOddSum.java`](../examples/ContinueOddSum.java), [`examples/StarPattern.java`](../examples/StarPattern.java), [`examples/MultiplicationTableAll.java`](../examples/MultiplicationTableAll.java), [`examples/PrimesBelowN.java`](../examples/PrimesBelowN.java), [`examples/ForEach.java`](../examples/ForEach.java), [`quiz/IterationQuiz.java`](../quiz/IterationQuiz.java)

---

## 1. break 문

반복문을 사용할 때 **특정 조건을 만족해서 더 이상 반복하지 않을 때** 사용한다.

```java
int r;
for (r = 0; r < 10; r++) {
    if (r == 3)
        break;
}
// 여기서 r은 3
```

> 참고:
> - break를 만나면 **가장 가까운(자신을 감싼) 반복문 하나**만 빠져나온다. 이중 반복문 안쪽에서 break하면 바깥 반복은 계속된다. (아래 "n보다 작은 소수 찾기")
> - break로 빠져나오면 **증감식도 실행되지 않는다.** 그래서 위 코드에서 r은 4가 아니라 3이다.
> - 3주차 switch 문의 break와 같은 키워드다. switch 안에서는 switch를, 반복문 안에서는 반복문을 빠져나온다.
>
> 📝 **필기 (퀴즈 1-④):**
> - `x = 0; for (;;) { if (x > 10) break; System.out.print(x + " "); x++; }`
> - 정답은 `0 1 2 3 4 5 6 7 8 9 10`. 따라서 오답.
> - 💡 break 검사가 출력보다 **앞에** 있다. x가 11이 되는 순간 출력 전에 빠져나오므로 10까지 출력된다.

---

## 2. [실습] 소수 판별하기

n보다 작은 수 중에 n을 나누어 떨어지게 하는 수가 있으면 **더 이상 반복할 필요가 없다.**

```java
import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        for (i = 2; i < n; i++) {
            if ((n % i) == 0) break;
        }
        if (i == n) System.out.println("소수입니다.");
        else System.out.println("소수가 아닙니다.");
        sc.close();
    }
}
```

```
n의 값을 입력하시오.
17
소수입니다.
```

> 참고: **`i == n`으로 소수를 판단하는 이유**
> - 2 ~ n-1 중 나누어 떨어지는 수가 **없으면** 끝까지 돌고, 조건 `i < n`이 깨질 때 i는 **n**이다.
> - 나누어 떨어지는 수가 **있으면** break로 중간에 나오므로 i는 n보다 **작다.**
> - 반복이 끝난 뒤 i를 써야 하므로 `int i;`를 for 문 **밖에서** 선언했다. (4-3 "반복 변수의 범위")
> - 💡 n이 1 이하이면 반복을 한 번도 안 돈다. i는 2라서 `i == n`이 false가 되고 "소수가 아닙니다"가 나온다. 1은 소수가 아니므로 결과가 맞다. 단, n = 2이면 i = 2 = n이라서 "소수입니다"가 나온다. 이것도 맞다.
> - 💡 실제로는 √n까지만 검사해도 충분하다(`i * i <= n`). 수업에서는 단순한 형태로 배웠다.
> - 슬라이드의 클래스 이름은 `ConditionOperation`이다. 교수님이 이클립스 프로젝트 하나에서 계속 고쳐 쓴 이름이라 여기서는 `PrimeCheck`로 바꿨다.

---

## 3. continue 문

반복문을 사용할 때 **특정 조건을 만족하면 continue 아래의 문장들은 실행하지 않는다.** 바로 다음 반복으로 넘어간다.

```java
int sum = 0;
for (int i = 1; i <= 100; i++) {
    if ((i % 2) == 0) continue;
    sum += i;   // 짝수일때 실행되지 않음
}
System.out.println("홀수의 합" + sum);   // 홀수의 합2500
```

> 참고:
> - for 문에서 continue를 만나면 **증감식(i++)으로 이동한 뒤** 조건을 검사한다.
> - while 문에서 continue를 쓸 때는 조심해야 한다. 증감 문장이 continue **아래**에 있으면 건너뛰어져서 무한루프가 될 수 있다.
> - break는 반복을 **끝내고**, continue는 이번 회차만 **건너뛴다.**
>
> ⚠ 슬라이드 코드의 `I <= 100`은 대문자 I라서 컴파일 에러가 난다. `i <= 100`으로 고쳤다. 출력도 `"홀수의 합 : "`처럼 띄어 쓰는 편이 보기 좋다.

---

## 4. 이중 for 문

for 문 안에 또 다른 for 문이 중첩되어 있는 형태다.

```java
int r, c;
for (r = 0; r < 5; r++) {
    for (c = 0; c < 5; c++)
        System.out.print("*");
    System.out.println("");
}
```

```
=== 결과 ===
*****
*****
*****
*****
*****
```

안쪽 반복 조건이 바깥 반복 변수에 따라 달라지면 삼각형이 된다.

```java
int r, c;
for (r = 0; r < 5; r++) {
    for (c = 0; c < (r + 1); c++)
        System.out.print("*");
    System.out.println("");
}
```

```
=== 결과 ===
*
**
***
****
*****
```

> 참고: **이중 반복문 읽는 법**
> - **바깥 반복 = 행(row)**, **안쪽 반복 = 열(column)**로 생각하면 쉽다.
> - 바깥이 한 번 돌 때 안쪽은 **처음부터 끝까지** 다 돈다. 5×5이면 `print("*")`가 25번 실행된다.
> - 안쪽 for가 끝난 뒤 `println`으로 줄을 바꾼다. 이 줄이 안쪽 for 안에 들어가면 별이 한 줄에 하나씩 찍힌다.
> - 두 번째 예제에서 r행에는 r+1개의 별이 찍힌다. (0행 → 1개, 4행 → 5개)
>
> ⚠ 슬라이드의 `for(c=0; c < (r+1)) ; c++)`는 괄호가 하나 더 있어서 컴파일 에러가 난다. `c < (r + 1)`로 고쳤다.
>
> 📝 **필기 (퀴즈 1-③):**
> - `for (x = 0; x < 3; x++) { for (y = 0; y <= 2; y++) System.out.println(x); System.out.println(); }`
> - 바깥 x는 0 → 1 → 2, 안쪽 y는 매번 0 → 1 → 2. 정답은 `000`(줄바꿈) `111`(줄바꿈) `222`(줄바꿈). 따라서 오답.
> - ⚠ 정확히는 안쪽이 `println(x)`라서 숫자 하나마다 줄이 바뀐다. 실제 출력은 `0` `0` `0` `(빈 줄)` `1` `1` `1` `(빈 줄)` `2` `2` `2` `(빈 줄)`로 한 줄에 하나씩 나온다. 안쪽이 `print(x)`였다면 필기처럼 `000` / `111` / `222`가 된다.
>
> 💡 실습 4번(피라미드)은 이중 반복문으로 별과 공백을 한 칸씩 찍는 문제다. "각 행마다 별이 시작하는 열과 끝나는 열"을 변수로 두고 행마다 바꾼다. ([`practice/iteration1/Pyramid.java`](../practice/iteration1/Pyramid.java))

---

## 5. [실습] 구구단 전체 출력하기

```java
public class MultiplicationTable {
    public static void main(String[] args) {
        int dan, index;
        for (dan = 2; dan <= 9; dan++) {
            System.out.println(dan + "단");
            for (index = 1; index <= 9; index++) {
                System.out.println(dan + " * " + index + " = " + dan*index);
            }
            System.out.println("");
        }
    }
}
```

```
2단
2 * 1 = 2
2 * 2 = 4
...
2 * 9 = 18

3단
3 * 1 = 3
...
9 * 9 = 81
```

> 참고: 4-1, 4-3의 "특정 구구단 출력하기"는 단(dan)을 입력받았다. 이번에는 **단을 바깥 for로 돌리면서** 안쪽에 그 코드를 그대로 넣었다.

---

## 6. [실습] n보다 작은 소수 찾기

2번 "소수 판별하기"를 바깥 for로 감싸서 2 ~ n-1의 모든 수(p)를 검사한다.

```java
import java.util.Scanner;

public class PrimesBelowN {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = "";
        int i, p;
        for (p = 2; p < n; p++) {
            for (i = 2; i < p; i++) {
                if ((p % i) == 0) break;
            }
            if (i == p) result = result + " " + p;
        }
        System.out.println(n + " 보다 작은 소수 : " + result);
        sc.close();
    }
}
```

```
n의 값을 입력하시오.
100
100 보다 작은 소수 :  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
```

> 참고:
> - 안쪽 for의 `break`는 **안쪽 for만** 빠져나온다. 바깥 for(p)는 계속 돈다.
> - `result = result + " " + p`: 문자열에 소수를 이어 붙여 두었다가 마지막에 한 번에 출력한다. 첫 소수 앞에도 공백이 붙으므로 `:` 뒤에 공백이 두 칸 나온다.
>
> ⚠ 실행 화면 캡처의 코드는 슬라이드 본문과 다르다. `String result = "1";`, `for (p = 3; ...)`로 되어 있어서 결과가 `1 3 5 7 11 ...`로 나온다. **1은 소수가 아니고, 2(유일한 짝수 소수)가 빠져 있다.** 슬라이드 본문 코드(`result = ""`, `p = 2`)가 맞다.

---

## 7. foreach 문

- 배열이나 컬렉션에 있는 **모든 요소에 대해 반복**하는 문장이다.
- **인덱스를 사용해 직접 접근하지 않는다.**
- 배열 요소의 개수에 딱 맞게 루프를 돌리는 작업이다.

```java
int[] array = {88, 67, 56, 77, 99, 90, 44};
int total = 0;
for (int number : array)    // foreach : for(자료형 변수 : 배열 또는 컬렉션)
    total += number;
System.out.println(total);  // 521

// foreach를 for문으로
total = 0;
for (int counter = 0; counter < array.length; counter++)
    total += array[counter];
System.out.println(total);  // 521
```

| | foreach | 일반 for |
|---|---|---|
| 형식 | `for (int number : array)` | `for (int i = 0; i < array.length; i++)` |
| 요소 접근 | `number` (요소 값이 차례로 들어옴) | `array[i]` |
| 인덱스 | 없음 | i |
| 요소 값 바꾸기 | 불가 (복사본이라 `number = 0`은 배열에 영향 X) | 가능 (`array[i] = 0`) |

> 참고:
> - 파이썬의 `for number in array:`와 같은 모양이다. 자바는 `:`를 "in"으로 읽으면 된다.
> - `array.length`는 배열의 요소 개수다(여기서는 7). 배열 인덱스는 0부터 `length - 1`까지다. 배열은 5주차에 자세히 배운다.
> - 인덱스가 필요하거나(몇 번째인지 출력), 배열 값을 바꾸거나, 거꾸로 돌 때는 일반 for를 쓴다.
>
> ⚠ 슬라이드는 두 번째 반복 전에 `total`을 0으로 되돌리지 않는다. 그래서 두 번째 출력은 521이 아니라 1042가 된다. 위 코드에는 `total = 0;`을 추가했다.

---

## 8. [실습] 학생 성적 처리하기

```java
public class ForEach {
    public static void main(String[] args) {
        int[] array = {88, 67, 56, 77, 99, 90, 44};
        double avg;
        int max = 0, min = 100, sum = 0;

        for (int number : array) {
            sum += number;
            if (number > max) max = number;
            if (number < min) min = number;
        }
        avg = ((double) sum) / array.length;
        System.out.println("평균 : " + avg);
        System.out.println("최고 : " + max);
        System.out.println("최저 : " + min);
    }
}
```

```
평균 : 74.42857142857143
최고 : 99
최저 : 44
```

> 참고:
> - 4-1 "성적 처리"(while)와 같은 문제다. 이번에는 값을 입력받지 않고 배열에 들어 있는 값을 foreach로 돈다.
> - max는 점수의 최솟값인 0, min은 최댓값인 100으로 시작한다. 그래서 첫 요소가 무조건 max와 min을 갱신한다. (4-1에서는 -1, 101을 썼다. 둘 다 "나올 수 있는 값의 바깥"이라 같은 결과다.)
> - `((double) sum) / array.length`: sum을 double로 바꾼 뒤 나눠서 실수 결과를 얻는다.
