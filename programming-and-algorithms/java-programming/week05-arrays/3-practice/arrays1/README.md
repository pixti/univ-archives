# 5주차 실습 · arrays1

[🏠 5주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [ContainsValue.java](#1-배열이-특정-값을-포함하는지-인덱스-for) | 1. 배열이 특정 값을 포함하는지 (인덱스 for) |
| [ContainsValueForEach.java](#1-같은-문제를-for-each--flag로) | 1. 같은 문제를 for each + flag로 (📝 시험 출제 예상) |
| [ContainsValueRepeat.java](#1-같은-문제를-do-while로-반복) | 1. 같은 문제를 do-while로 반복 |
| [FindIndex.java](#2-배열-요소의-인덱스-찾기-인덱스-for--optionalint) | 2. 💡 배열 요소의 인덱스 찾기 (인덱스 for + `OptionalInt`) |
| [RemoveElement.java](#3-배열에서-특정-요소-제거-인덱스-for) | 3. 배열에서 특정 요소 제거 (인덱스 for) |
| [RemoveElementForEach.java](#3-같은-문제를-for-each로) | 3. 같은 문제를 for each로 |
| [ReverseArray.java](#4-배열-요소-순서-반전) | 4. 배열 요소 순서 반전 |
| [CommonElements.java](#5-두-배열의-공통-요소) | 5. 💡 두 배열의 공통 요소 |
| [DuplicateElements.java](#6-중복-값-찾기-int-배열--string-배열은-equals) | 6. 💡 중복 값 찾기 (int 배열 + String 배열은 `equals`) |
| [MoveZerosToEnd.java](#7-0을-배열-끝으로-옮기기-상대-순서-유지) | 7. 💡 0을 배열 끝으로 옮기기 (상대 순서 유지) |
| [Leaders.java](#8-배열의-리더-찾기) | 8. 배열의 리더 찾기 |

---

## 1. 배열이 특정 값을 포함하는지 (인덱스 for)

`5강 실습` · 📄 [`ContainsValue.java`](ContainsValue.java)

#### 문제

> 배열이 특정 값을 포함하는지 테스트하는 프로그램을 작성하시오.
>
> ```java
> 배열 : {1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2265, 1457, 2456}
> ```
>
> (예시 출력)<br>찾고자 하는 값 ? 2456<br>결과 : True<br>계속 ? ('y' or 'n')

#### 💻 코드

<!-- code: ContainsValue.java -->
```java
import java.util.Scanner;

public class ContainsValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] my_array = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                     1254, 1472, 2365, 1456, 2265, 1457, 2456};

        System.out.print("찾고자 하는 값 ? ");
        int i, n = sc.nextInt();
        for (i = 0; i < my_array.length; i++) {
            if (my_array[i] == n) {
                System.out.println("True");
                break;
            }
        }
        if (i == my_array.length) {       // 끝까지 돌았다 = 못 찾았다
            System.out.println("False");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
찾고자 하는 값 ? 1472
True
```

**포인트**

- 찾으면 "True" 를 출력하고 break 로 더 이상 찾지 않는다.
- i 를 for 밖에서 선언 → 반복이 끝난 뒤에도 i 를 쓸 수 있다.
- i == my\_array.length : break 없이 끝까지 돌았다 = 못 찾았다 → "False"<br>(4-4 소수 판별의 i == n 과 같은 발상)

- 💡 int i, n = sc.nextInt(); 는 i 는 선언만, n 은 선언 + 입력값으로 초기화.
- 💡 같은 문제를 foreach 로 → ContainsValueForEach.java, 반복 질문까지 → ContainsValueRepeat.java

## 1. 같은 문제를 for each + flag로

`5강 실습` · 📄 [`ContainsValueForEach.java`](ContainsValueForEach.java)

#### 문제

> 배열이 특정 값을 포함하는지 테스트하는 프로그램을 작성하시오.

#### 💻 코드

<!-- code: ContainsValueForEach.java -->
```java
import java.util.Scanner;

public class ContainsValueForEach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] my_array = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                     1254, 1472, 2365, 1456, 2265, 1457, 2456};

        System.out.print("찾고자 하는 값 ? ");
        int n = sc.nextInt();
        boolean flag = false;
        for (int e : my_array) {
            if (e == n) {
                System.out.println("True");
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("False");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
찾고자 하는 값 ? 2456
True
```

#### 📒 해설

- 📝 필기 : for each 문 ★) 시험 출제 예상 1

**포인트**

- for (int e : my\_array) : 인덱스 없이 원소를 하나씩 e 에 꺼낸다.
- foreach 에는 i 가 없어서 버전 1 처럼 "i == length 면 못 찾음" 으로 판단할 수 없다.<br>→ boolean flag 로 "찾았는지" 를 따로 기억한다.<br>flag = false 로 시작 → 찾으면 true 로 바꾸고 break → 끝난 뒤 flag 가 false 면 못 찾은 것.

- 💡 if (flag == false) 는 if (!flag) 와 같다.
- 💡 foreach 는 "읽기" 전용으로 생각하자. e 에 값을 대입해도 배열 원소는 바뀌지 않는다.<br>(e 는 원소의 복사본)  위치(인덱스)가 필요하면 인덱스 for 를 써야 한다. (2번 문제)

## 1. 같은 문제를 do-while로 반복

`5강 실습` · 📄 [`ContainsValueRepeat.java`](ContainsValueRepeat.java)

#### 문제

> 배열이 특정 값을 포함하는지 테스트하고, "계속 ? ('y' or 'n')" 으로 반복한다.

#### 💻 코드

<!-- code: ContainsValueRepeat.java -->
```java
import java.util.Scanner;

public class ContainsValueRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] my_array = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                     1254, 1472, 2365, 1456, 2265, 1457, 2456};
        int n;
        boolean flag;
        char cont;

        do {
            System.out.print("찾고자 하는 값 ? ");
            n = sc.nextInt();
            flag = false;                  // 매번 다시 초기화
            for (int e : my_array) {
                if (e == n) {
                    System.out.println("True");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("False");
            }
            System.out.print("계속 하시겠습니까? (y/n) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y');

        sc.close();                        // ⚠ 원래 코드에는 없음
    }
}
```
<!-- /code -->

#### 실행 예

```text
찾고자 하는 값 ? 2546
False
계속 하시겠습니까? (y/n) : y
찾고자 하는 값 ? 1254
True
계속 하시겠습니까? (y/n) : n
```

**포인트**

- 최소 1 번은 찾아야 하므로 do-while (4-2).
- flag = false; 를 do 블록 "안" 에서 매번 다시 해 주는 것이 중요.<br>밖에서 한 번만 하면, 한 번 True 가 나온 뒤로는 계속 true 로 남아 "False" 가 영영 안 나온다.<br>(4주차 Pyramid 의 col = 0; , NumberGuessingRepeat 의 cont = true; 와 같은 이야기)
- sc.next().charAt(0) : 단어 하나를 읽어 첫 글자만 char 로.

- ⚠ 원래 코드에는 sc.close(); 가 없어서 마지막에 추가했다.
- 💡 'Y' 대문자도 받으려면 while (cont == 'y' || cont == 'Y')  (3번 문제 RemoveElement 처럼)

## 2. 배열 요소의 인덱스 찾기 (인덱스 for + `OptionalInt`)

`5강 실습` · 📄 [`FindIndex.java`](FindIndex.java)

#### 문제

> 배열 요소의 인덱스를 찾는 프로그램을 작성하시오. OptionalInt 를 사용해서도 작성해 보시오.

#### 💻 코드

<!-- code: FindIndex.java -->
```java
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        char cont;

        do {
            System.out.print("찾고자 하는 값 ? ");
            int n = sc.nextInt();

            // 방법 1) 인덱스 for
            int index = -1;                       // 못 찾으면 -1
            for (int i = 0; i < my_arr.length; i++) {
                if (my_arr[i] == n) {
                    index = i;
                    break;                        // 첫 위치만
                }
            }
            if (index != -1) System.out.println("인덱스 : " + index);
            else             System.out.println("인덱스 : -1 (배열에 없음)");

            // 방법 2) OptionalInt
            OptionalInt found = IntStream.range(0, my_arr.length)
                                         .filter(i -> my_arr[i] == n)
                                         .findFirst();
            if (found.isPresent()) System.out.println("OptionalInt 인덱스 : " + found.getAsInt());
            else                   System.out.println("OptionalInt : 값 없음");

            System.out.print("계속 ? ('y' or 'n') ");
            cont = sc.next().charAt(0);
        } while (cont == 'y');
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
찾고자 하는 값 ? 25
인덱스 : 0
OptionalInt 인덱스 : 0
계속 ? ('y' or 'n') y
찾고자 하는 값 ? 29
인덱스 : 8
OptionalInt 인덱스 : 8
계속 ? ('y' or 'n') y
찾고자 하는 값 ? 100
인덱스 : -1 (배열에 없음)
OptionalInt : 값 없음
계속 ? ('y' or 'n') n
```

**(isPresent(), getAsInt() 메소드 사용)**

```java
배열 : {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}
```

(예시 출력)<br>찾고자 하는 값 ? 25<br>인덱스 : 0

```text
...
```

찾고자 하는 값 ? 29<br>인덱스 : 8

- 📝 필기 : 수업시간에는 패스

- 💡 수업에서 넘어간 문제라 직접 작성한 코드는 없다. 아래는 참고용 풀이.

**방법 1) 인덱스 for**

  - 1번 문제와 같지만 "찾았다" 대신 "어디서 찾았는지(i)" 를 출력한다.
  - 그래서 foreach 가 아니라 인덱스 for 를 써야 한다. (foreach 에는 i 가 없다)
  - 56 처럼 같은 값이 여러 번 있으면 break 때문에 첫 위치(2)만 나온다.
  - 못 찾으면 -1 : 인덱스로 나올 수 없는 값이라 "없음" 표시로 흔히 쓴다. (binarySearch 의 음수와 같은 발상)

**방법 2) OptionalInt**

  - OptionalInt 는 "int 값이 있을 수도, 없을 수도 있다" 를 담는 상자다.<br>-1 같은 약속 대신 isPresent() 로 값이 있는지 묻고, getAsInt() 로 꺼낸다.
  - IntStream.range(0, arr.length) : 0, 1, ..., length-1 (인덱스들의 흐름)
    ```text
    .filter(i -> arr[i] == n)      : 그중 값이 n 인 인덱스만 남김
    .findFirst()                   : 첫 번째 것을 OptionalInt 로 (없으면 비어 있는 OptionalInt)
    ```
  - 💡 람다(i -> ...)와 스트림은 이후에 배우는 내용이다. 여기서는 "이런 식으로도 쓴다" 정도로만.
  - 💡 값이 없는 OptionalInt 에 getAsInt() 를 부르면 NoSuchElementException. 꼭 isPresent() 먼저.

- 💡 binarySearch 는 정렬이 필요해서 원래 위치를 잃어버린다. 원래 배열의 인덱스를 찾을 때는 쓸 수 없다.

## 3. 배열에서 특정 요소 제거 (인덱스 for)

`5강 실습` · 📄 [`RemoveElement.java`](RemoveElement.java)

#### 문제

> 배열에서 특정 요소를 제거하는 프로그램을 작성하시오.
>
> ```java
> 배열 : {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}
> ```
>
> (예시 출력)<br>제거하고자 하는 값 ? 14<br>제거 후 배열 : \[25, 56, 15, 36, 56, 77, 18, 29, 49, 49]

#### 💻 코드

<!-- code: RemoveElement.java -->
```java
import java.util.Arrays;
import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        char cont;
        int n, cnt, j;

        do {
            System.out.println("변경 전 배열 : ");
            System.out.println(Arrays.toString(my_arr));

            System.out.print("제거 값 ? ");
            n = sc.nextInt();
            cnt = 0;

            // 제거할 값의 개수 카운트
            for (int i = 0; i < my_arr.length; i++) {
                if (my_arr[i] == n) {
                    cnt++;
                }
            }

            // 값이 존재하는 경우 새로운 배열 생성 및 복사
            if (cnt != 0) {
                int[] tmp = new int[my_arr.length - cnt];
                j = 0;
                for (int i = 0; i < my_arr.length; i++) {
                    if (my_arr[i] != n) {
                        tmp[j] = my_arr[i];
                        j++;
                    }
                }
                my_arr = tmp;   // 변경된 배열 업데이트
            } else {
                System.out.println("배열에 해당 값이 존재하지 않습니다.");
            }

            System.out.println("변경 후 배열 : ");
            System.out.println(Arrays.toString(my_arr));

            // 계속 진행할지 여부 입력받기
            System.out.print("계속하시겠습니까? (y/n) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y' || cont == 'Y');

        System.out.println("프로그램을 종료합니다.");
        sc.close();

        System.out.println("(참고) 예시 출력 방식 : 14 제거 → "
                + Arrays.toString(shiftLeft(new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}, 14)));
    }

    /**
     * 💡 참고 : 문제 예시 출력 방식. 처음 찾은 값 하나를 지우고 뒤의 원소를 한 칸씩 앞으로 당긴다.
     *    배열 크기는 그대로라서 마지막 칸에는 원래 마지막 값이 한 번 더 남는다.
     */
    static int[] shiftLeft(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                for (int k = i; k < arr.length - 1; k++) {
                    arr[k] = arr[k + 1];   // 한 칸씩 앞으로
                }
                break;
            }
        }
        return arr;
    }
}
```
<!-- /code -->

#### 실행 예

```text
변경 전 배열 :
[25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
제거 값 ? 77
변경 후 배열 :
[25, 14, 56, 15, 36, 56, 18, 29, 49]
계속하시겠습니까? (y/n) : y
변경 전 배열 :
[25, 14, 56, 15, 36, 56, 18, 29, 49]
제거 값 ? 56
변경 후 배열 :
[25, 14, 15, 36, 18, 29, 49]
계속하시겠습니까? (y/n) : y
변경 전 배열 :
[25, 14, 15, 36, 18, 29, 49]
제거 값 ? 100
배열에 해당 값이 존재하지 않습니다.
변경 후 배열 :
[25, 14, 15, 36, 18, 29, 49]
계속하시겠습니까? (y/n) : n
프로그램을 종료합니다.
(참고) 예시 출력 방식 : 14 제거 → [25, 56, 15, 36, 56, 77, 18, 29, 49, 49]
```

**📝 필기**

x -> \[1,2,3,4,5] 배열에서 원소 하나 쏙 빼는 건 물리적으로 불가능함.<br>새로운 배열을 만들고 \[1,2,3,5] 값을 복사해 하나 만들고 x 가 매핑되는 구조.

```text
변경 전  my_arr ──▶ [25|14|56|15|36|56|77|18|29|49]   (크기 10, 바꿀 수 없음)
                    tmp ──▶ [25|56|15|36|56|77|18|29|49] (크기 9, 새로 만듦)
my_arr = tmp;       my_arr 이 새 배열을 가리키게 됨 (옛 배열은 가비지 컬렉터가 정리)
```

**포인트 (두 번 훑는다)**

1) 제거할 값의 개수(cnt)를 센다 → 새 배열의 크기 = 원래 길이 - cnt 를 알 수 있다.
2) 제거할 값이 아닌 것만 tmp 에 옮긴다.<br>i : 원래 배열에서 읽을 위치 (매번 증가)<br>j : 새 배열에 쓸 위치 (옮길 때만 증가) → 두 위치가 따로 움직인다.
- 같은 값이 여러 개면(56) 모두 제거된다.
- 값이 없으면 cnt == 0 → 배열을 그대로 두고 안내 문구.

- 💡 문제의 예시 출력은 \[... 29, 49, 49] 로 맨 끝에 49 가 두 번 있다.<br>새 배열을 만드는 것이 아니라 "뒤의 원소를 한 칸씩 앞으로 당기고 크기는 그대로" 둔 결과다.<br>마지막 칸은 옮길 값이 없어 원래 값(49)이 남는다. 크기를 못 바꾸니 생기는 현상.<br>이 코드는 필기대로 새 배열을 만들어서 \[25, 56, 15, 36, 56, 77, 18, 29, 49] (크기 9) 가 나온다.<br>예시 방식의 코드는 아래 shiftLeft() 에 참고로 넣었다.
- 💡 for each 로 옮기기 → RemoveElementForEach.java

## 3. 같은 문제를 for each로

`5강 실습` · 📄 [`RemoveElementForEach.java`](RemoveElementForEach.java)

#### 💻 코드

<!-- code: RemoveElementForEach.java -->
```java
import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementForEach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        char cont;
        int n, cnt, j;

        do {
            System.out.println("변경 전 배열 : ");
            System.out.println(Arrays.toString(my_arr));

            System.out.print("제거 값 ? ");
            n = sc.nextInt();
            cnt = 0;

            // 제거할 값의 개수 카운트
            for (int e : my_arr) {
                if (e == n) {
                    cnt++;
                }
            }

            // 값이 존재하는 경우 새로운 배열 생성 및 복사
            if (cnt != 0) {
                int[] tmp = new int[my_arr.length - cnt];
                j = 0;
                for (int e : my_arr) {
                    if (e != n) {
                        tmp[j] = e;
                        j++;
                    }
                }
                my_arr = tmp;   // 변경된 배열 업데이트
            } else {
                System.out.println("배열에 해당 값이 존재하지 않습니다.");
            }

            System.out.println("변경 후 배열 : ");
            System.out.println(Arrays.toString(my_arr));

            // 계속 진행할지 여부 입력받기
            System.out.print("계속하시겠습니까? (y/n) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y' || cont == 'Y');

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
변경 전 배열 :
[25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
제거 값 ? 49
변경 후 배열 :
[25, 14, 56, 15, 36, 56, 77, 18, 29]
계속하시겠습니까? (y/n) : n
프로그램을 종료합니다.
```

#### 📒 해설

- 📝 필기 : for each 문으로

버전 1 (RemoveElement.java) 과 같고, 개수 세기와 복사하는 반복문을 foreach 로 바꿨다.

**포인트**

- 원래 배열을 "읽기만" 하는 곳은 foreach 로 바꿀 수 있다.
  ```java
  for (int e : my_arr) { if (e != n) { tmp[j] = e; j++; } }
  ```
- 새 배열 tmp 에 "쓰는" 위치 j 는 여전히 직접 관리해야 한다.<br>foreach 는 읽는 배열의 위치만 대신 관리해 줄 뿐이다.

- 💡 PDF 의 코드는 복사하는 반복문만 foreach 로 바꿨다. 개수를 세는 반복도 읽기만 하므로 똑같이 foreach 로 바꿀 수 있어서 함께 바꿨다.

## 4. 배열 요소 순서 반전

`5강 실습` · 📄 [`ReverseArray.java`](ReverseArray.java)

#### 문제

> 정수 배열의 요소 순서를 반전시키는 프로그램을 작성하시오.
>
> ```java
> 배열 : {1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456}
> ```
>
> (예시 출력)<br>반전 배열 : \[2456, 1457, 2165, 1456, 2365, 1472, 1254, 2458, 1458, 2013, 1456, 1899, 2035, 1789]

#### 💻 코드

<!-- code: ReverseArray.java -->
```java
import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                  1254, 1472, 2365, 1456, 2165, 1457, 2456};
        int temp;

        System.out.println("변경 전 배열 : " + Arrays.toString(my_arr));

        for (int i = 0; i < my_arr.length / 2; i++) {          // 중앙까지만
            temp = my_arr[i];                                   // temp = x
            my_arr[i] = my_arr[my_arr.length - 1 - i];          // x = y
            my_arr[my_arr.length - 1 - i] = temp;               // y = temp
        }

        System.out.println("변경 후 배열 : " + Arrays.toString(my_arr));
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
변경 전 배열 : [1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456]
변경 후 배열 : [2456, 1457, 2165, 1456, 2365, 1472, 1254, 2458, 1458, 2013, 1456, 1899, 2035, 1789]
```

**📝 필기**

배열의 대칭성을 이용해 arr.length/2 의 값을 이용해 스왑시켜주면 된다.<br>자바에서는 x 와 y 값을 스왑할 때<br>temp 에 x 값을 저장해 놓고 -> y 값을 x 에 저장하고 -> temp 값(원래 x 값)을 y 에 저장하면 -> 스왑

```java
temp = x;  x = y;  y = temp;
```

\[7, 6, 5, 4, 3] 이라 하면 중앙 5 를 기준으로 대칭.<br>0번째 - 4번째, 1번째 - 3번째 끼리 대칭 관계.<br>일반화 하면 i번째 - (배열길이 - i - 1) 끼리 대칭 관계.

**📝 필기**

```text
| 반복 범위       | arr.length / 2 : 중앙까지만 수행해야 다시 원상복구되는 문제를 막음 |
| 대칭 인덱스 공식 | i ↔ arr.length - 1 - i                                         |
| 스왑 로직       | temp = x; x = y; y = temp;                                     |
```

- 💡 길이 14 (짝수) → 7 번 교환 (0↔13, 1↔12, ..., 6↔7). 길이가 홀수면 가운데는 자기 자신이라 그대로.
- 💡 5-2 강의 "내림차순 정렬" 에서 정렬 후 뒤집던 코드와 같다. (a.length-(i+1) == a.length-1-i)
- ⚠ Scanner 를 만들었지만 입력은 받지 않는다. (원래 코드 그대로 둠)
- ⚠ 1번 문제 배열은 2265, 이 문제 배열은 2165 로 원소 하나가 다르다. (문제 그대로)

## 5. 두 배열의 공통 요소

`5강 실습` · 📄 [`CommonElements.java`](CommonElements.java)

#### 문제

> 두 배열 사이에 공통 요소를 찾는 프로그램을 작성하시오.<br>Array1 : \[1, 2, 5, 5, 8, 9, 7, 10]<br>Array2 : \[1, 0, 6, 15, 6, 4, 7, 0]
>
> (예시 출력)<br>공통요소1 : 1<br>공통요소2 : 7

#### 💻 코드

<!-- code: CommonElements.java -->
```java
public class CommonElements {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] arr2 = {1, 0, 6, 15, 6, 4, 7, 0};
        int cnt = 0;

        for (int i = 0; i < arr1.length; i++) {
            // arr1 앞쪽에 같은 값이 이미 있었으면 건너뜀 (중복 출력 방지)
            boolean seen = false;
            for (int k = 0; k < i; k++) {
                if (arr1[k] == arr1[i]) {
                    seen = true;
                    break;
                }
            }
            if (seen) continue;

            // arr2 에 같은 값이 있는지
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    cnt++;
                    System.out.println("공통요소" + cnt + " : " + arr1[i]);
                    break;
                }
            }
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
공통요소1 : 1
공통요소2 : 7
```

#### 📒 해설

- 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.

**포인트**

- 이중 for : arr1 의 원소 하나(i)마다 arr2 전체(j)를 훑어서 같은 값이 있는지 본다.
- 찾으면 break : 같은 값이 arr2 에 여러 번 있어도 한 번만 센다.
- arr1 에 같은 값이 여러 번 있으면(5, 5) 공통요소가 중복으로 찍힐 수 있다.<br>→ "앞에서 이미 나온 값인지" 를 먼저 검사해서 건너뛴다. (6번 중복 요소 문제와 같은 발상)<br>이 예제에서는 5 가 arr2 에 없어서 티가 나지 않지만, arr2 에 5 가 있었다면 두 번 찍혔을 것이다.
- 공통요소 번호(cnt)는 찾을 때마다 1 씩 증가.

- 💡 비교 횟수는 최대 8 × 8 = 64 번. 배열이 커지면 정렬 후 비교하거나 Set 을 쓰는 방법이 빠르다.

## 6. 중복 값 찾기 (int 배열 + String 배열은 `equals`)

`5강 실습` · 📄 [`DuplicateElements.java`](DuplicateElements.java)

#### 문제

> 정수 배열의 중복 값을 찾는 프로그램을 작성하시오. (문자열 배열도 따로 작성해 보시오.)<br>배열 : \[1, 2, 5, 5, 6, 6, 7, 2]
>
> (예시 출력)<br>중복 요소1 : 2<br>중복 요소2 : 5<br>중복 요소3 : 6

#### 💻 코드

<!-- code: DuplicateElements.java -->
```java
public class DuplicateElements {
    public static void main(String[] args) {
        int[] my_arr = {1, 2, 5, 5, 6, 6, 7, 2};
        int cnt = 0;

        for (int i = 0; i < my_arr.length; i++) {
            if (appearedBefore(my_arr, i)) continue;   // 이미 출력한 값이면 건너뜀

            for (int j = i + 1; j < my_arr.length; j++) {
                if (my_arr[i] == my_arr[j]) {
                    cnt++;
                    System.out.println("중복 요소" + cnt + " : " + my_arr[i]);
                    break;
                }
            }
        }

        // 문자열 배열 버전
        String[] words = {"java", "c", "python", "java", "c", "go"};
        System.out.println("--- 문자열 배열 " + java.util.Arrays.toString(words) + " ---");
        cnt = 0;
        for (int i = 0; i < words.length; i++) {
            boolean seen = false;
            for (int k = 0; k < i; k++) {
                if (words[k].equals(words[i])) { seen = true; break; }
            }
            if (seen) continue;

            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {        // 문자열은 equals 로 비교
                    cnt++;
                    System.out.println("중복 요소" + cnt + " : " + words[i]);
                    break;
                }
            }
        }
    }

    /** arr[0] ~ arr[i-1] 중에 arr[i] 와 같은 값이 있는지 */
    static boolean appearedBefore(int[] arr, int i) {
        for (int k = 0; k < i; k++) {
            if (arr[k] == arr[i]) return true;
        }
        return false;
    }
}
```
<!-- /code -->

#### 실행 예

```text
중복 요소1 : 2
중복 요소2 : 5
중복 요소3 : 6
--- 문자열 배열 [java, c, python, java, c, go] ---
중복 요소1 : java
중복 요소2 : c
```

#### 📒 해설

- 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.

**포인트**

- 이중 for : i 번째 값과 i 뒤(j = i + 1 \~)의 값들을 비교. 같은 값이 있으면 i 번째는 중복 요소.<br>j 를 i + 1 부터 시작하면 (i, j) 쌍을 한 번씩만 비교한다. (자기 자신과 비교하지 않음)
- 같은 값이 3 번 이상 나오면 여러 번 찍힐 수 있다.<br>→ i 앞쪽에 같은 값이 있었으면 "이미 출력한 값" 이므로 건너뛴다.
- 문자열은 == 가 아니라 equals() 로 비교한다.<br>== 는 "같은 객체인지(레퍼런스)" 를 비교하고, equals() 는 "내용이 같은지" 를 비교한다.<br>(4주차 가위바위보 과제의 equals, 5-3 강의의 레퍼런스 이야기와 연결)

- 💡 예시 출력은 2, 5, 6 순서다. 2 는 1번 · 7번 위치에 있는데, "처음 나온 위치" 순서로 찍으면 2 → 5 → 6.
- 💡 문자열 배열 예시는 문제에 없어서 직접 만들었다.

## 7. 0을 배열 끝으로 옮기기 (상대 순서 유지)

`5강 실습` · 📄 [`MoveZerosToEnd.java`](MoveZerosToEnd.java)

#### 문제

> 주어진 배열의 모든 0 을 배열의 끝으로 옮기는 프로그램을 작성하시오.<br>다른 요소들의 상대적인 순서는 유지되어야 한다.<br>입력 배열 : 0 0 1 0 3 0 5 0 6
>
> (예시 출력)<br>처리 후 배열 : 1 3 5 6 0 0 0 0 0

#### 💻 코드

<!-- code: MoveZerosToEnd.java -->
```java
public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 3, 0, 5, 0, 6};

        System.out.print("입력 배열 : ");
        print(arr);

        int pos = 0;                          // 0 이 아닌 값을 다음에 쓸 위치
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos] = arr[i];
                pos++;
            }
        }
        for (int i = pos; i < arr.length; i++) {
            arr[i] = 0;                       // 나머지를 0 으로
        }

        System.out.print("처리 후 배열 : ");
        print(arr);
    }

    static void print(int[] arr) {
        for (int e : arr) System.out.print(e + " ");
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 예

```text
입력 배열 : 0 0 1 0 3 0 5 0 6
처리 후 배열 : 1 3 5 6 0 0 0 0 0
```

#### 📒 해설

- 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.

포인트 : 위치 두 개 (3번 원소 제거 문제의 i, j 와 같은 발상)

- i   : 읽는 위치 (처음부터 끝까지 하나씩)
- pos : 0 이 아닌 값을 "다음에 쓸" 위치
1) 0 이 아닌 값을 만나면 arr\[pos] 에 쓰고 pos++  → 앞쪽에 순서대로 모인다.
2) 다 옮긴 뒤 pos \~ 끝을 0 으로 채운다.

```text
i   :  0 1 2 3 4 5 6 7 8
```

원본 : \[0 0 1 0 3 0 5 0 6]

    1)   : \[1 3 5 6 3 0 5 0 6]   pos = 4  (앞 4칸에 1 3 5 6)
    2)   : \[1 3 5 6 0 0 0 0 0]   pos \~ 8 을 0 으로

- pos &lt;= i 가 항상 성립해서, 아직 읽지 않은 값을 덮어쓰는 일이 없다. → 새 배열 없이 제자리에서 처리.
- 0 이 아닌 값은 앞에서부터 차례로 옮기므로 상대적인 순서(1 → 3 → 5 → 6)가 유지된다.

- 💡 Arrays.sort 로 하면 안 된다. 순서가 유지되지 않고, 0 이 오히려 맨 앞으로 간다.

## 8. 배열의 리더 찾기

`5강 실습` · 📄 [`Leaders.java`](Leaders.java)

#### 문제

> 배열에서 모든 리더를 찾아 출력하는 프로그램을 작성하시오.<br>리더 : 오른쪽에 있는 모든 요소보다 큰 요소. (가장 오른쪽 요소는 항상 리더)<br>배열 : \[10, 9, 14, 23, 15, 0, 9]
>
> (예시 출력)<br>리더들 : 23 15 9

#### 💻 코드

<!-- code: Leaders.java -->
```java
public class Leaders {
    public static void main(String[] args) {
        int[] my_arr = new int[] {10, 9, 14, 23, 15, 0, 9};
        int i, j;

        System.out.print("리더들 : ");
        for (i = 0; i < my_arr.length; i++) {
            // i번째 값이 리더인지 검사, i번째 값보다 큰 값이 있는지 검사
            for (j = i + 1; j < my_arr.length; j++) {
                if (my_arr[i] < my_arr[j]) {   // i번째 값이 리더가 아님
                    break;
                }
            }
            // 끝까지 검사했다면 i번째 값은 리더임.
            if (j == my_arr.length) {
                System.out.print(my_arr[i] + " ");
            }
        }
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 예

```text
리더들 : 23 15 9
```

**포인트**

- 바깥 for (i) : 리더 후보 하나씩
- 안쪽 for (j = i + 1 \~) : i 의 오른쪽에 i 번째보다 큰 값이 있는지 검사<br>있으면 i 번째는 리더가 아니다 → break
- j == my\_arr.length : break 없이 끝까지 검사했다 = 더 큰 값이 없었다 → 리더<br>(1번 문제의 i == my\_array.length, 4-4 소수 판별의 i == n 과 같은 발상)
- 마지막 원소는 j = i + 1 = length 라서 안쪽 for 를 한 번도 돌지 않고 바로 리더가 된다.
- i, j 를 for 밖에서 선언한 이유 : 반복이 끝난 뒤 j 값을 써야 해서.

i=0  10 : 오른쪽에 14 → 아님

```text
i=1   9 : 오른쪽에 14 → 아님
```

i=2  14 : 오른쪽에 23 → 아님<br>i=3  23 : 15, 0, 9 모두 작음 → 리더<br>i=4  15 : 0, 9 모두 작음 → 리더

```text
i=5   0 : 오른쪽에 9 → 아님
i=6   9 : 오른쪽 없음 → 리더
```

- 💡 비교가 my\_arr\[i] &lt; my\_arr\[j] (엄격) 라서, 오른쪽에 "같은" 값만 있으면 리더로 판정된다.<br>"모든 요소보다 크다" 를 엄격하게 적용하려면 &lt;= 로 바꿔야 한다. 이 예제에서는 결과가 같다.
- 💡 오른쪽부터 거꾸로 훑으면서 "지금까지의 최대값" 보다 크면 리더로 판단하면 한 번만 훑어도 된다.<br>대신 출력 순서가 9 15 23 으로 거꾸로 나온다.

---

[🏠 5주차 학습 가이드](../../README.md)
