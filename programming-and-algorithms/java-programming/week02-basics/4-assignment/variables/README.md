# 2주차 과제 · variables

[🏠 2주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [Test1.java](#1-오류-7개-찾아-고치기) | 1. 오류 7개 찾아 고치기 |
| [StudentInfo.java](#2-학생-정보-입력-및-출력) | 2. 학생 정보 입력 및 출력 |

---

## 1. 오류 7개 찾아 고치기

`2강 과제` · 📄 [`Test1.java`](Test1.java)

#### 문제

> 다음 프로그램의 오류를 수정하시오.
>
> ```text
> ── 문제 코드 ──────────────────────────────────────────
>   public class Test1 {
>       public static void main(String[] args) {
>           String s = 'abc';
>           System.out.print(s);
>
>           double d = 12.3
>           int f = d; // double 형을 int 형으로 저장
>           System.out.print(f);
>
>           Scanner sc = new Scanner(System.in);
>           double db = sc.next();
>           System.out.print(db);
>           sc.close();
>           String s = sc.next();
>           System.out.print(s);
>       }
>   }
>
> ── 오류 목록 ──────────────────────────────────────────
> ```
>
> **① String s = 'abc';**
>
> → 작은따옴표는 문자(char) 하나만. 문자열은 큰따옴표 "abc" 로 감싸야 한다.
>
> **② double d = 12.3**
>
> → 세미콜론(;) 누락
>
> **③ int f = d;**
>
> → double(8byte) → int(4byte) 는 정보 손실 가능성 때문에 자동 형변환이 안 된다.<br>강제 형변환 int f = (int) d; 필요 (f 에는 12 저장, 소수점 이하 버림)
>
> **④ double db = sc.next();**
>
> → sc.next() 의 반환형은 String. 실수를 읽으려면 sc.nextDouble() 사용
>
> **⑤ sc.close(); 후에 sc.next() 호출**
>
> → 닫힌 Scanner 를 사용하면 실행 중 IllegalStateException 발생.<br>close() 는 입력을 모두 받은 뒤 마지막에 호출해야 한다.
>
> **⑥ Scanner 를 import 하지 않음**
>
> → import java.util.Scanner; 추가
>
> **⑦ String s = sc.next();**
>
> → 같은 메소드 안에서 변수 s 를 다시 선언 (중복 선언 에러).<br>다른 이름(s2)을 쓰거나 s = sc.next(); 로 재대입

#### 💻 코드

<!-- code: Test1.java -->
```java
import java.util.Scanner; // ⑥ Scanner 를 쓰려면 import 필요

public class Test1 {
    public static void main(String[] args) {
        String s = "abc";              // ① ' ' → " "
        System.out.print(s);

        double d = 12.3;               // ② 세미콜론 추가
        int f = (int) d;               // ③ 강제 형변환 (double 형을 int 형으로 저장)
        System.out.print(f);

        Scanner sc = new Scanner(System.in);
        double db = sc.nextDouble();   // ④ next() → nextDouble()
        System.out.print(db);

        String s2 = sc.next();         // ⑦ 변수 중복 선언 해결
        System.out.print(s2);
        sc.close();                    // ⑤ 다 쓴 후 마지막에 close
    }
}
```
<!-- /code -->

#### 실행 예 (입력: 3.14 hello)

```text
abc123.14hello
```

## 2. 학생 정보 입력 및 출력

`2강 과제` · 📄 [`StudentInfo.java`](StudentInfo.java)

#### 문제

> 학생 정보(이름, 생년월일, 학년, 토익 성적, 평균 학점)를 입력 받아 출력하는 프로그램을 작성하시오.

#### 💻 코드

<!-- code: StudentInfo.java -->
```java
import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(">이름: ");
        String name = sc.next();
        System.out.print(">생년월일: ");
        String birth = sc.next();
        System.out.print(">학년: ");
        int grade = sc.nextInt();
        System.out.print(">토익 성적: ");
        int toeic = sc.nextInt();
        System.out.print(">평균 학점: ");
        double gpa = sc.nextDouble();
        sc.close();

        System.out.println(name + ", " + birth + ", " + grade + ", " + toeic + ", " + gpa);
    }
}
```
<!-- /code -->

#### 실행 예

```text
>이름: 김병만
>생년월일: 640824
>학년: 4
>토익 성적: 200
>평균 학점: 4.5
김병만, 640824, 4, 200, 4.5
```

**자료형 선택 이유**

- 이름     : String  (문자열)
- 생년월일 : String  (계산에 쓰지 않는 "번호" 성격. int 로 받으면 2000년대생 "010824" 의 앞자리 0 이 사라짐)
- 학년     : int
- 토익 성적 : int
- 평균 학점 : double  (소수점 필요)

---

[🏠 2주차 학습 가이드](../../README.md)
