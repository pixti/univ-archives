# 7주차 강의 예제 코드

[🏠 7주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [FieldDeclaration.java](#필드-선언---객체마다-고유의-필드가-따로-존재한다) | 필드 선언: 객체마다 필드가 따로 있음, 레퍼런스 타입 필드(MyPoint). ⚠ 한 파일에 public class 는 하나 |
| [StudentScore.java](#학생-성적-클래스-정의하기) | [실습] 학생 성적 클래스 정의하기 (과목별 · 전체 평균) |
| [MyIntegerThis.java](#this-키워드---현재-메소드를-실행하고-있는-객체의-레퍼런스) | `this` 키워드. ⚠ 빼기 기호 대신 en dash(`–`)를 쓰는 실수 |
| [StaticFieldTest.java](#정적-필드-static-field---같은-클래스의-객체들끼리-값을-공유) | 정적 필드: 객체끼리 값을 공유, `클래스명.필드`로 접근 |
| [StudentScoreStatic.java](#앞-예제studentscorejava를-this-키워드와-정적-변수를-사용하여-재구현하기) | [실습] 학생 성적 예제를 `this`와 정적 변수(학생 수)로 재구현 |
| [MyMathDemo.java](#수학-라이브러리-작성---원주와-원-면적-마일을-킬로미터로) | [실습] 정적 메소드로 수학 라이브러리 작성 (원주, 원 면적, 마일 ↔ 킬로미터) |
| [StudentScorePrivate.java](#접근자에-따른-변수-접근성-확인하기---필드를-private-으로-getter-로-읽기) | [실습] 접근자에 따른 변수 접근성 확인 (`private` 필드 + getter) |
| [MyRectangleTest.java](#사각형-클래스---private-필드--getter--setter) | [실습] 사각형 클래스 (`private` 필드 + getter / setter) |
| [VariableScopeTest.java](#변수의-유효범위-테스트) | [실습] 변수의 유효 범위. ⚠ 범위 밖 변수를 쓰는 오류 줄은 ❌ 주석으로 표시 |
| [MyIntegerTest.java](#정수-클래스의-기능-중복-정의하기---메소드-중복정의오버로딩-overloading) | [실습] 메소드 중복정의(오버로딩). ⚠ 대소문자(`I` ≠ `i`) |
| [SwapTest.java](#메소드-인수-전달---기본-자료형-vs-배열레퍼런스) | 기본 자료형 swap(실패) vs 배열 swap(성공). ⚠ static main 에서 non-static 메소드 호출 |
| [ModifyArrayTest.java](#배열-인수---메소드에서-배열을-인수로-받아들이는-예) | 배열을 인수로 받아 메소드 안에서 바꾸기 |
| [ArrayArgument.java](#배열-데이터-메소드에서-변경하기) | [실습] 배열 데이터를 메소드에서 변경하기 (난수 배열 1씩 증가) |
| [CommandLineTest.java](#명령행-인수-command-line-arguments) | 명령행 인수 `args`. 💡 인수 개수 검사 추가 |
| [InnerTest.java](#내부-클래스-inner-class) | 내부 클래스, 다른 클래스에서 내부 클래스 객체 만들기 (`private` → `public`) |
| [MethodLocalInnerTest.java](#메소드-내부-클래스-method-local-inner-class) | 메소드 내부 클래스. ⚠ 메소드 안에서는 `private class` 불가 |
| [MyRectangleInnerPoint.java](#내부-클래스와-일반-클래스로-선언할-경우의-차이) | [실습] MyPoint를 **내부 클래스**로 (📝 내부 vs 일반 클래스 비교표) |
| [MyRectangleOuterPoint.java](#내부-클래스와-일반-클래스로-선언할-경우의-차이-1) | [실습] MyPoint를 **일반 클래스**로 (getter / setter를 거쳐야 함) |

---

## 필드 선언 - 객체마다 고유의 필드가 따로 존재한다

`7-1` · 📄 [`FieldDeclaration.java`](FieldDeclaration.java)

#### 💻 코드

<!-- code: FieldDeclaration.java -->
```java
public class FieldDeclaration {
    public static void main(String[] args) {
        MyRectangle ob1 = new MyRectangle();
        MyRectangle ob2 = new MyRectangle();
        ob1.x = 0; ob1.y = 0; ob1.width = 10; ob1.height = 10;
        ob2.x = 5; ob2.y = 5; ob2.width = 15; ob2.height = 10;
        System.out.println("위치 : " + ob1.x + ", " + ob1.y + " 폭 : "
                + ob1.width + " 높이 : " + ob1.height);
        System.out.println("위치 : " + ob2.x + ", " + ob2.y + " 폭 : "
                + ob2.width + " 높이 : " + ob2.height);

        // 💡 레퍼런스 필드 : origin 이 가리키는 MyPoint 객체의 필드를 다시 . 으로 접근
        MyRectangle2 r = new MyRectangle2();
        r.origin.x = 3; r.origin.y = 4; r.width = 20; r.height = 30;
        System.out.println("origin : " + r.origin.x + ", " + r.origin.y
                + " 폭 : " + r.width + " 높이 : " + r.height);
    }
}

class MyRectangle {
    int x, y, width, height;
}

// 필드에 객체의 레퍼런스를 저장
class MyPoint {
    int x, y; // 좌표값
}

class MyRectangle2 {          // 강의 코드에서는 이름이 MyRectangle (위 클래스와 겹쳐서 2 를 붙임)
    MyPoint origin = new MyPoint();
    int width, height; // 폭과 높이
}
```
<!-- /code -->

#### 실행 결과

```text
위치 : 0, 0 폭 : 10 높이 : 10
위치 : 5, 5 폭 : 15 높이 : 10
origin : 3, 4 폭 : 20 높이 : 30
```

**포인트**

- 필드 선언부는 객체들이 유지해야 할 데이터를 저장하는 변수들을 선언하는 곳
- 객체를 생성할 때마다 고유의 필드가 따로 생기기 때문에 "객체식별자.필드명" 으로 써야 한다.
  ```text
  ob1.x = 0;   ← ob1 객체의 x
  ob2.x = 5;   ← ob2 객체의 x (ob1 의 x 와 다른 변수)
  ```
- 필드에는 기본 자료형뿐 아니라 객체의 레퍼런스를 저장하는 변수도 선언할 수 있다. (아래 MyRectangle2)

```text
Stack                Heap
┌─────┐       ┌─────────────────────────┐
│ ob1 │──────▶│ x=0 y=0 width=10 height=10 │
├─────┤       └─────────────────────────┘
│ ob2 │──────▶┌─────────────────────────┐
└─────┘       │ x=5 y=5 width=15 height=10 │
              └─────────────────────────┘
```

- ⚠ 자주 틀리는 부분 : 한 파일에 public class 는 하나만 둘 수 있다. 그래서 MyRectangle 은
  ```java
  public 을 빼고 같은 파일에 넣었다. (퀴즈 5번 📝 필기 참고)
  ```

## 학생 성적 클래스 정의하기

`7-1 실습` · 📄 [`StudentScore.java`](StudentScore.java)

#### 💻 코드

<!-- code: StudentScore.java -->
```java
public class StudentScore {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;

        Student[] students = new Student[3];
        students[0] = new Student();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        students[1] = new Student();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        students[2] = new Student();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getInfo());
            korSum += students[i].kor;
            engSum += students[i].eng;
            mathSum += students[i].math;
            totalSum += students[i].getAverage();
        }
        korAvg = korSum / (double) students.length;
        engAvg = engSum / (double) students.length;
        mathAvg = mathSum / (double) students.length;
        totalAvg = totalSum / (double) students.length;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class Student {
    String sname;
    int sid, kor, eng, math;

    void setInfo(String name, int id, int k, int e, int m) {
        sname = name;
        sid = id;
        kor = k; eng = e;
        math = m;
    }

    double getAverage() {
        return (kor + eng + math) / 3.0;     // 3 이 아니라 3.0 으로 나눠야 소수점까지 계산
    }

    String getInfo() {
        return sname + ", " + sid + ", " + kor + ", " + eng + ", " + math;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
bmkim1, 2016001, 70, 80, 90
bmkim2, 2016002, 60, 70, 80
bmkim3, 2016003, 50, 60, 70
국어 평균 : 60.0
영어 평균 : 70.0
수학 평균 : 80.0
전체 평균 : 70.0
```

**포인트**

- Student 클래스 = 필드(sname, sid, kor, eng, math) + 메소드(setInfo, getAverage, getInfo)
- Student\[] students = new Student\[3];  → "레퍼런스 3칸" 만 생긴다. (객체는 아직 없음, 모두 null)
  ```text
  students[0] = new Student();         → 각 칸마다 new 로 객체를 따로 만들어 넣어야 한다.
  ```
- students\[i].kor 처럼 필드에 직접 접근 (필드에 접근 수정자가 없어서 같은 패키지면 접근 가능, 7-3 참고)
- korSum / (double) students.length : 정수 / 정수 는 소수점이 버려지므로 double 로 형변환

```text
students ──▶ [ ● | ● | ● ]
               │   │   └──▶ Student{bmkim3, 2016003, 50, 60, 70}
               │   └──────▶ Student{bmkim2, 2016002, 60, 70, 80}
               └──────────▶ Student{bmkim1, 2016001, 70, 80, 90}
```

- ⚠ 자주 틀리는 부분 : public class 이름이 StudentScore 이면 파일 이름도 StudentScore.java 여야 한다.<br>(StudentInfo.java 처럼 다른 이름으로 저장하면 컴파일 오류)

## this 키워드 - 현재 메소드를 실행하고 있는 객체의 레퍼런스

`7-2` · 📄 [`MyIntegerThis.java`](MyIntegerThis.java)

#### 💻 코드

<!-- code: MyIntegerThis.java -->
```java
public class MyIntegerThis {
    public static void main(String[] args) {
        MyInteger2 ob1 = new MyInteger2();
        MyInteger2 ob2 = new MyInteger2();
        ob1.val = 10;
        ob2.val = 3;
        int r = ob1.add(ob2);      // this <- ob1
        int r2 = ob2.add(ob1);     // this <- ob2
        System.out.println("ob1.add(ob2) = " + r);
        System.out.println("ob2.add(ob1) = " + r2);
        System.out.println("ob1.subtract(ob2) = " + ob1.subtract(ob2));   // this <- ob1 : 10 - 3
        System.out.println("ob2.subtract(ob1) = " + ob2.subtract(ob1));   // this <- ob2 : 3 - 10
        System.out.println("ob1.multiply(ob2) = " + ob1.multiply(ob2));
        System.out.println("ob1.divide(ob2) = " + ob1.divide(ob2));
    }
}

class MyInteger2 {
    int val;
    int add(MyInteger2 ob) { return this.val + ob.val; }
    int subtract(MyInteger2 ob) { return this.val - ob.val; }          // ⚠ – → -
    int multiply(MyInteger2 ob) { return this.val * ob.val; }
    double divide(MyInteger2 ob) { return ((double) this.val) / ob.val; }
}
```
<!-- /code -->

#### 실행 결과

```text
ob1.add(ob2) = 13
ob2.add(ob1) = 13
ob1.subtract(ob2) = 7
ob2.subtract(ob1) = -7
ob1.multiply(ob2) = 30
ob1.divide(ob2) = 3.3333333333333335
```

**포인트**

- this 는 "지금 이 메소드를 호출한 객체" 를 가리키는 레퍼런스 변수
  ```java
  int r  = ob1.add(ob2);   // this ← ob1,  ob ← ob2  →  ob1.val + ob2.val
  int r2 = ob2.add(ob1);   // this ← ob2,  ob ← ob1  →  ob2.val + ob1.val
  ```
- 메소드 코드는 클래스에 하나만 있고 모든 객체가 공유한다.<br>그래서 "어느 객체의 val 인지" 를 this 로 구분한다. (실습 클래스1 1번 📝 필기 참고)
- divide 는 ((double) this.val) / ob.val 로 실수 나눗셈

- ⚠ 자주 틀리는 부분 : 문서에서 복사한 "this.val – ob.val" 의 – 는 빼기 기호(-)가 아니라 en dash(–)라서 컴파일 오류가 난다.

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (MyInteger → MyInteger2, 강의 코드에서는 바꾸기 전 이름)

## 정적 필드 (static field) - 같은 클래스의 객체들끼리 값을 공유

`7-2` · 📄 [`StaticFieldTest.java`](StaticFieldTest.java)

#### 💻 코드

<!-- code: StaticFieldTest.java -->
```java
public class StaticFieldTest {
    public static void main(String[] args) {
        StaticTest ob1 = new StaticTest();
        StaticTest ob2 = new StaticTest();
        ob1.setValue(3);
        System.out.println(ob2.getValue());     // 3 출력 (value 는 하나뿐이므로 ob1 이 넣은 값이 보인다)
        ob1.setInstVal(5);
        System.out.println(ob2.getInstVal());   // static 변수 아님 → ob2 의 instVal 은 기본값 0

        // 💡 정적 필드는 객체 없이 클래스명으로 접근 가능
        System.out.println("StaticTest.value = " + StaticTest.value);
    }
}

class StaticTest {
    static int value;
    int instVal;
    void setValue(int n) { value = n; }
    int getValue() { return value; }
    void setInstVal(int n) { instVal = n; }
    int getInstVal() { return instVal; }
}
```
<!-- /code -->

#### 실행 결과

```text
3
0
StaticTest.value = 3
```

**포인트**

- 자료형 앞에 static 을 붙인다.
- 일반 필드와 달리 객체마다 생기지 않고 "클래스당 하나만" 생성되어 같은 클래스의 객체가 공유한다.
- 특정 객체와 무관하므로 객체 생성 전에도 클래스명으로 사용할 수 있다.  → StaticTest.value

```text
    ┌──────── StaticTest (클래스당 하나) ────────┐
    │  static int value = 3                      │ ◀── ob1, ob2 가 같이 씀
    └────────────────────────────────────────────┘
ob1 ──▶ [ instVal = 5 ]
ob2 ──▶ [ instVal = 0 ]   ← 객체마다 따로 (ob1 에 넣은 5 가 안 보임)
```

- 📝 퀴즈 6번 필기 : 일반 필드는 객체 생성시마다 따로따로 할당된다. 스태틱 필드는 객체마다가 아니라 하나만 공유되는 형태로 할당되고, 객체 생성 없이도 접근이 가능하다.

- 💡 강의 코드의 public class 이름은 MyApp (7-2 의 정적 메소드 예제와 이름이 겹쳐서 StaticFieldTest 로 바꿈)

## 앞 예제(StudentScore.java)를 this 키워드와 정적 변수를 사용하여 재구현하기

`7-2 실습` · 📄 [`StudentScoreStatic.java`](StudentScoreStatic.java)

#### 💻 코드

<!-- code: StudentScoreStatic.java -->
```java
public class StudentScoreStatic {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;

        StudentStatic[] students = new StudentStatic[100];
        students[0] = new StudentStatic();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        StudentStatic.count++; // students[0].count++;
        students[1] = new StudentStatic();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        StudentStatic.count++; // students[0].count++;
        students[2] = new StudentStatic();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);
        StudentStatic.count++; // students[0].count++;

        for (int i = 0; i < StudentStatic.count; i++) {
            System.out.println(students[i].getInfo());
            korSum += students[i].kor;
            engSum += students[i].eng;
            mathSum += students[i].math;
            totalSum += students[i].getAverage();
        }
        korAvg = ((double) korSum) / StudentStatic.count;
        engAvg = ((double) engSum) / StudentStatic.count;
        mathAvg = ((double) mathSum) / StudentStatic.count;
        totalAvg = totalSum / StudentStatic.count;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class StudentStatic {
    String sname;
    int sid, kor, eng, math;
    static int count = 0; // 정적 변수 추가!

    void setInfo(String name, int id, int k, int e, int m) {
        this.sname = name; this.sid = id; this.kor = k; this.eng = e; this.math = m;
    }

    double getAverage() { return (this.kor + this.eng + this.math) / 3.0; }

    String getInfo() {
        return this.sname + ", " + this.sid + ", " + this.kor + ", " + this.eng + ", " + this.math;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
bmkim1, 2016001, 70, 80, 90
bmkim2, 2016002, 60, 70, 80
bmkim3, 2016003, 50, 60, 70
국어 평균 : 60.0
영어 평균 : 70.0
수학 평균 : 80.0
전체 평균 : 70.0
```

**포인트**

1. this 키워드 사용
    - this.sname = name; 처럼 "이 객체의 필드" 임을 명시.<br>여기서는 매개변수 이름(name, k ...)과 필드 이름이 달라서 this 를 빼도 같은 의미다.<br>이름이 같을 때(this.name = name)는 this 가 꼭 필요하다. (실습 클래스1 1번 📝 필기)
2. 정적 변수 count 추가
    - static int count = 0;  → 모든 StudentStatic 객체가 공유하는 "학생 수"
    - StudentStatic.count++;       → 클래스명으로 접근 (students\[0].count++ 로 써도 같은 변수)
    - 배열은 100칸이지만 실제로 들어 있는 학생은 count 명 → for 문을 students.length 가 아니라 StudentStatic.count 까지만 돈다. (100 까지 돌면 비어 있는 칸(null)에서 NullPointerException)

- 💡 이 파일은 강의의 StudentStatic.java + StudentScore.java 두 파일을 한 파일로 합쳤다.<br>public class 는 하나만 둘 수 있으므로 StudentStatic 의 public 을 뺐다.<br>(원래 이름 StudentScore 는 7-1 예제와 겹쳐서 StudentScoreStatic 으로 바꿈)
- 💡 count++ 를 main 에서 직접 하지 않고 setInfo 안에서 하면 빠뜨릴 걱정이 없다.<br>9주차 생성자에서 "객체가 만들어질 때마다 count++" 하는 형태로 많이 쓴다.

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (Student → StudentStatic, 강의 코드에서는 바꾸기 전 이름)

## 수학 라이브러리 작성 - 원주와 원 면적, 마일을 킬로미터로

`7-2 실습` · 📄 [`MyMathDemo.java`](MyMathDemo.java)

#### 💻 코드

<!-- code: MyMathDemo.java -->
```java
import java.util.Scanner;

public class MyMathDemo {
    public static void main(String[] args) {
        System.out.println("반지름을 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        System.out.println("원의 둘레 : " + MyMath.getCirclePerimeter(r));
        System.out.println("원의 면적 : " + MyMath.getCircleArea(r));
        System.out.println("마일을 입력하세요 : ");
        r = sc.nextDouble();
        System.out.println(MyMath.mileToKilometer(r) + "킬로미터에 해당합니다.");
        System.out.println("킬로미터을 입력하세요 : ");
        r = sc.nextDouble();
        System.out.println(MyMath.kilometerToMile(r) + "마일에 해당합니다.");
        sc.close();
    }
}

// MyMath 클래스는 다음과 같이 작성토록 한다.
class MyMath {
    static final double PI = 3.14159;
    static final double KMPerMILE = 1.609344;
    static double getCirclePerimeter(double r) { return 2 * PI * r; }
    static double getCircleArea(double r) { return PI * r * r; }
    static double kilometerToMile(double km) { return km * 1 / KMPerMILE; }
    static double mileToKilometer(double m) { return m * KMPerMILE; }
}
```
<!-- /code -->

#### 실행 예

```text
반지름을 입력하세요 :
2
원의 둘레 : 12.56636
원의 면적 : 12.56636
마일을 입력하세요 :
10
16.09344킬로미터에 해당합니다.
킬로미터을 입력하세요 :
16.09344
10.0마일에 해당합니다.
```

**포인트**

- 정적 메소드(static method) 는 일반 필드(인스턴스 변수)를 사용하지 않는 메소드<br>→ 객체 생성 없이 "클래스명.메소드명()" 으로 실행 가능  (MyMath.getCircleArea(r))
- 정적 메소드는 정적 필드, 인수, 지역 변수만 사용 가능. 즉 일반 필드는 사용 불가
- static final : 객체마다 가질 필요 없는 "상수" (PI, KMPerMILE)
- 💡 자바의 Math 클래스(Math.PI, Math.sqrt, Math.max ...)도 같은 방식으로 만들어져 있다.<br>그래서 new Math() 없이 Math.max(a, b) 로 쓴다.

- 📝 퀴즈 8번 필기 : static 메서드 안에서는 지역변수, static 필드, static 메서드만 사용 가능

## 접근자에 따른 변수 접근성 확인하기 - 필드를 private 으로, getter 로 읽기

`7-3 실습` · 📄 [`StudentScorePrivate.java`](StudentScorePrivate.java)

#### 💻 코드

<!-- code: StudentScorePrivate.java -->
```java
public class StudentScorePrivate {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;

        StudentPrivate[] students = new StudentPrivate[3];
        students[0] = new StudentPrivate();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        students[1] = new StudentPrivate();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        students[2] = new StudentPrivate();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);

        for (int i = 0; i < 3; i++) {
            System.out.println(students[i].getInfo());
            // korSum += students[i].kor;     // ❌ 컴파일 오류 : kor has private access in StudentPrivate
            korSum += students[i].getKor();    // ✅ getter 로 읽기
            engSum += students[i].getEng();
            mathSum += students[i].getMath();
            totalSum += students[i].getAverage();
        }
        korAvg = korSum / 3.0;
        engAvg = engSum / 3.0;
        mathAvg = mathSum / 3.0;
        totalAvg = totalSum / 3.0;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class StudentPrivate {
    private String sname;
    private int sid, kor, eng, math;

    public String getName() { return sname; }
    public int getSID() { return sid; }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }

    void setInfo(String name, int id, int k, int e, int m) {
        sname = name; sid = id; kor = k; eng = e; math = m;
    }

    double getAverage() { return (kor + eng + math) / 3.0; }

    String getInfo() {
        return sname + ", " + sid + ", " + kor + ", " + eng + ", " + math;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
bmkim1, 2016001, 70, 80, 90
bmkim2, 2016002, 60, 70, 80
bmkim3, 2016003, 50, 60, 70
국어 평균 : 60.0
영어 평균 : 70.0
수학 평균 : 80.0
전체 평균 : 70.0
```

**포인트**

- 필드를 private 으로 선언하면 해당 클래스 내부에서만 접근 가능<br>→ main(StudentScorePrivate 클래스)에서 students\[i].kor 로 직접 접근하면 컴파일 오류!
  ```text
  error: kor has private access in StudentPrivate
  ```
- 그래서 public 메소드인 getter(getKor, getEng, getMath)로 값을 읽는다.
- private 필드는 public 메소드로 접근<br>getter : private 로 선언된 필드 값을 읽는 메소드<br>setter : private 로 선언된 필드 값을 수정하는 메소드  (여기서는 setInfo 가 setter 역할)

- 📝 퀴즈 2번 필기 (getter/setter 를 쓰는 이유) : 캡슐화와 정보 은닉.<br>데이터 무결성(유효성 검사), 접근 권한 제어(읽기 전용/쓰기 전용), 유지보수성

- 💡 강의 코드는 main 의 "..." 부분이 생략되어 있어 7-1 예제의 학생 3명 데이터로 채웠다.<br>(원래 이름 StudentScore 는 7-1 예제와 겹쳐서 StudentScorePrivate 로 바꿈)

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (Student → StudentPrivate, 강의 코드에서는 바꾸기 전 이름)

## 사각형 클래스 - private 필드 + getter / setter

`7-3 실습` · 📄 [`MyRectangleTest.java`](MyRectangleTest.java)

#### 💻 코드

<!-- code: MyRectangleTest.java -->
```java
public class MyRectangleTest {
    public static void main(String[] args) {
        MyRectanglePrivate r1 = new MyRectanglePrivate();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        // r1.width = 5;   // ❌ 컴파일 오류 : width has private access in MyRectanglePrivate
    }
}

class MyRectanglePrivate {
    // 필드 정의, private로 선언하여 외부접근 불가.
    private int x, y;               // 왼쪽 코너 좌표
    private int width, height;      // 사각형의 폭과 높이

    // 메소드 정의
    public int getX() { return x; }                        // x값을 읽는 기능
    public void setX(int newX) { x = newX; }               // x값을 변경하는 기능
    public int getY() { return y; }                        // y값을 읽는 기능
    public void setY(int newY) { y = newY; }               // y값을 변경하는 기능
    public int getWidth() { return width; }                // width 값을 읽는 기능
    public void setWidth(int newW) { width = newW; }       // width 값을 변경하는 기능
    public int getHeight() { return height; }              // height 값을 읽는 기능
    public void setHeight(int newY) { height = newY; }     // height 값을 변경하는 기능
    public void resize(int newW, int newH) { width = newW; height = newH; } // 크기를 변경하는 기능
    public int getArea() { return width * height; }        // 면적을 계산하는 기능
}
```
<!-- /code -->

#### 실행 결과

```text
면적은 20입니다.
```

**포인트**

- 필드(x, y, width, height)를 private 로 선언하여 외부 접근 불가
- getX / setX ... : 필드 하나마다 읽는 기능(getter)과 변경하는 기능(setter)을 public 메소드로 제공
- resize(newW, newH) : 크기를 한 번에 변경하는 기능
- getArea() : 면적을 계산하는 기능 (필드에 저장하지 않고 필요할 때 계산)

- 💡 setHeight(int newY) 의 매개변수 이름 newY 는 newH 가 자연스럽다. (동작은 같음, 강의 코드 그대로 둠)

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (MyRectangle → MyRectanglePrivate, 강의 코드에서는 바꾸기 전 이름)

## 변수의 유효범위 테스트

`7-3 실습` · 📄 [`VariableScopeTest.java`](VariableScopeTest.java)

#### 💻 코드

<!-- code: VariableScopeTest.java -->
```java
public class VariableScopeTest {
    public static void main(String[] args) {
        VariableScope app = new VariableScope();
        app.method1();
        app.method2();
    }
}

class VariableScope {
    int x = 3;

    public void method1() {
        int y = 5;
        System.out.println("x = " + x + " y = " + y);
    }

    public void method2() {
        // ❌ System.out.println("x = " + x + " y = " + y);   // method1 지역변수 오류
        System.out.println("x = " + x);                          // ✅ y 는 여기서 보이지 않는다
        for (int z = 0; z < 3; z++) System.out.println("z = " + z);
        // ❌ System.out.println("z = " + z);                  // for 문의 z를 사용하여 오류
    }
}
```
<!-- /code -->

#### 실행 결과

```text
x = 3 y = 5
x = 3
z = 0
z = 1
z = 2
```

**포인트**

- 변수는 선언 위치에 따라 접근할 수 있는 범위와 생존 기간이 달라진다.
  ```text
  필드(x)         : 클래스 내에 선언 → 클래스의 모든 메소드에서 사용 가능, 객체가 살아 있는 동안 존재
  지역 변수(y)    : 메소드 안에 선언 → 그 메소드 안에서만 사용, 메소드가 끝나면 사라짐
  블록 변수(z)    : for 문 안에 선언 → for 블록 안에서만 사용

  class VariableScope {
      int x = 3;  ───────────────────────────┐ 필드 : 클래스 전체
      method1() {                            │
          int y = 5; ─────┐ method1 안에서만  │
      }  ─────────────────┘                  │
      method2() {                            │
          for (int z ...) { ─┐ for 안에서만   │
          } ─────────────────┘               │
      }                                      │
  } ─────────────────────────────────────────┘
  ```

- 📝 퀴즈 1-❷ 필기 (필드 vs 지역 변수) : 필드는 기본값(0, false, null)으로 자동 초기화되지만 지역 변수는 자동 초기화되지 않아 사용 전에 반드시 초기화해야 한다.

- ⚠ 자주 틀리는 부분 : method2 에 있는 두 줄은 일부러 넣은 "오류" 줄이다. 그대로 두면 컴파일되지 않으므로
  - ❌ 틀린 줄은 주석으로 남기고 ✅ 로 고친 줄을 넣었다.
    ```text
    error: cannot find symbol  y   (method1 의 지역변수)
    error: cannot find symbol  z   (for 문의 변수)
    ```

## 정수 클래스의 기능 중복 정의하기 - 메소드 중복정의(오버로딩, overloading)

`7-3 실습` · 📄 [`MyIntegerTest.java`](MyIntegerTest.java)

#### 💻 코드

<!-- code: MyIntegerTest.java -->
```java
public class MyIntegerTest {
    public static void main(String[] args) {
        MyInteger ob = new MyInteger();
        int x = ob.add(5);
        double y = ob.add(3.5);
        System.out.println(x + ", " + y);

        // 💡 세 번째 형태 add(MyInteger) 도 확인
        MyInteger a = new MyInteger(), b = new MyInteger();
        a.val = 10; b.val = 5;
        System.out.println("add(MyInteger) : " + a.add(b));
    }
}

class MyInteger {
    int val;
    int add(MyInteger ob) { return this.val + ob.val; }  // 중복정의
    int add(int i) { return this.val + i; }               // 중복정의  (⚠ I → i)
    double add(double d) { return this.val + d; }         // 중복정의
    int subtract(MyInteger ob) { return this.val - ob.val; }
    int multiply(MyInteger ob) { return this.val * ob.val; }
    double divide(MyInteger ob) { return ((double) this.val) / ob.val; }
}
```
<!-- /code -->

#### 실행 결과

```text
5, 3.5
add(MyInteger) : 15
```

**포인트**

- 같은 이름의 메소드로 여러 형태를 지원하는 것 (System.out.println 도 중복정의되어 있어 자료형에 상관없이 같은 메소드로 불러 쓸 수 있다)
- 구분 기준은 "매개변수의 개수·자료형" 뿐이다. 반환형만 다르면 구분하지 못한다.
  ```java
  int f1() {...}
  int f1(int x) {...}          // ok
  int f1(int x, int y) {...}   // ok
  int f1(double x) {...}       // ok
  void f1(int x)               // error, 두번째 함수와 구분하지 못함 (반환형만 다름)
  ```
- ob.add(5)   → add(int i)    호출 (val 은 기본값 0) → 5
  ```text
  ob.add(3.5) → add(double d) 호출                  → 3.5
  ```

## 메소드 인수 전달 - 기본 자료형 vs 배열(레퍼런스)

`7-4` · 📄 [`SwapTest.java`](SwapTest.java)

#### 💻 코드

<!-- code: SwapTest.java -->
```java
public class SwapTest {
    public static void main(String[] args) {
        // (1) 기본 자료형
        int x = 5, y = 3;
        swap(x, y); // 값이 바뀌지 않음
        System.out.println(x);
        System.out.println(y);

        // (2) 배열
        int[] arr = new int[] {5, 3};
        swap(arr, 0, 1); // 값이 바뀜
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    public static void swap(int a, int b) {
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
    }

    public static void swap(int[] arr, int idx1, int idx2) {   // ⚠ static 추가
        int tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
5
3
3
5
```

**포인트**

- 기본 자료형 인자는 "값" 이 복사되어 전달된다 (call-by-value)<br>→ swap(x, y) 안에서 a, b 를 바꿔도 main 의 x, y 는 그대로

```text
main          swap(int a, int b)
x [5]  ──복사──▶ a [5] → [3]
y [3]  ──복사──▶ b [3] → [5]      ← 바뀌는 건 복사본뿐
```

- 배열(레퍼런스형) 인자는 "레퍼런스(주소)" 가 전달된다<br>→ 메소드 안의 arr 와 main 의 arr 가 같은 배열 객체를 가리키므로 원본이 바뀜

```text
main arr ──┐
           ├──▶ [ 5 | 3 ]  → [ 3 | 5 ]
swap arr ──┘
```

- 💡 정확히 말하면 자바는 항상 call-by-value 이다. 레퍼런스형은 "레퍼런스 값(주소)" 이 복사되어 전달되는 것이라서 같은 객체를 가리키게 되고, 결과적으로 call-by-reference 처럼 동작한다.<br>("배열은 레퍼런스가 값으로 전달되기 때문에 작업 후 원래 배열의 원소도 바뀜")<br>그래서 메소드 안에서 arr = new int\[]{...} 처럼 "새 배열을 대입" 하면 main 의 배열은 바뀌지 않는다.

- ⚠ 자주 틀리는 부분 : 배열 swap 을 public void swap(...) (static 없음) 으로 만들고 static main 에서 바로 swap(arr, 0, 1) 로 호출해서 컴파일 오류가 난다.
  ```text
  error: non-static method swap(int[],int,int) cannot be referenced from a static context
  ```<br>→ public static void swap(...) 로 써야 한다 (퀴즈 8번과 같은 오류)
- 💡 기본 자료형 swap 과 배열 swap 예제는 둘 다 SwapTest 클래스라서 한 파일에 합쳤다. swap 이 매개변수가 다른 두 형태로 중복정의(오버로딩)된다.

## 배열 인수 - 메소드에서 배열을 인수로 받아들이는 예

`7-4` · 📄 [`ModifyArrayTest.java`](ModifyArrayTest.java)

#### 💻 코드

<!-- code: ModifyArrayTest.java -->
```java
public class ModifyArrayTest {
    public static void main(String[] args) {
        int[] t = new int[] {1, 2, 3};
        ModifyArray(t);
        for (int j = 0; j < t.length; j++) System.out.print(t[j] + " ");
        System.out.println();
    }

    static void ModifyArray(int[] b) {
        for (int j = 0; j < b.length; j++) b[j] *= 2;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
2 4 6
```

**포인트**

- 배열도 객체이기 때문에 값이 아닌 참조(레퍼런스)가 전달된다.
- 배열을 인수로 전달할 때는 "배열명만" 인수로 전달하고,<br>메소드 선언부에서는 배열의 레퍼런스가 넘어온다고 표시한다.
  ```java
  ModifyArray( t );                 // 호출 : 배열명만 (t[] 아님)
  ```<br>static void ModifyArray( int\[] b ) // 선언 : int\[] 로 받음
- 배열은 레퍼런스가 값으로 전달되기 때문에 작업 후 원래 배열의 원소도 바뀐다.

- 💡 자바 관례로는 메소드 이름을 소문자로 시작한다 (modifyArray). 강의 코드의 이름 그대로 둠.

## 배열 데이터 메소드에서 변경하기

`7-4 실습` · 📄 [`ArrayArgument.java`](ArrayArgument.java)

#### 💻 코드

<!-- code: ArrayArgument.java -->
```java
import java.util.Random;

public class ArrayArgument {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) array[i] = rnd.nextInt();
        System.out.print("변경 전 : ");
        printArray(array);
        increaseArray(array);
        System.out.print("변경 후 : ");
        printArray(array);
    }

    public static void increaseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i]++;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 예 (난수라서 매번 다름)

```text
변경 전 : -1155484576 -723955400 1033096058 ... (10개)
변경 후 : -1155484575 -723955399 1033096059 ... (각각 1씩 증가)
```

**포인트**

- increaseArray(array) : 배열의 레퍼런스가 전달되므로 메소드 안에서 arr\[i]++ 하면 main 의 array 원소도 1씩 증가한다.
- printArray 도 static : static main 에서 객체 없이 바로 호출하려면 static 이어야 한다.
- rnd.nextInt() : int 범위 전체(음수 포함)의 난수 → 실행할 때마다 값이 다르다.
  - 💡 rnd.nextInt(100) 처럼 범위를 주면 0 \~ 99

## 명령행 인수 (command-line arguments)

`7-4` · 📄 [`CommandLineTest.java`](CommandLineTest.java)

#### 💻 코드

<!-- code: CommandLineTest.java -->
```java
public class CommandLineTest {
    public static void main(String[] args) {
        // (1) foreach 문으로 출력
        for (String arg : args) {
            System.out.println(arg);
        }

        // (2) 첨자로 접근
        if (args.length >= 2) {
            System.out.println("args[0] = " + args[0]); // aaa
            System.out.println("args[1] = " + args[1]); // bbb
        } else {
            System.out.println("명령행 인수를 2개 이상 주세요. 예) java CommandLineTest aaa bbb");
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
> java 1-lecture/code/CommandLineTest.java aaa bbb
aaa
bbb
args[0] = aaa
args[1] = bbb
```

**포인트**

- main 은 String 타입의 배열(String\[] args)을 인수로 받는다.
- 실행할 때 클래스 이름 뒤에 적은 단어들이 공백 기준으로 나뉘어 args 에 들어간다.
  ```java
  java CommandLineTest aaa bbb    →  args = { "aaa", "bbb" }
  ```
- foreach 문으로 출력하거나, 배열이므로 첨자(args\[0], args\[1])로 접근할 수 있다.
- 이클립스 : Run → Run Configurations → Arguments 탭 → Program arguments 에 입력

- 💡 인수 없이 실행하면 args.length 가 0 이라서 args\[0] 에서 ArrayIndexOutOfBoundsException 이 난다.<br>그래서 아래 코드는 길이 검사를 먼저 한다.
- 💡 class 앞의 public 은 빼도 된다. (파일 하나에 클래스 하나면 public 이 없어도 실행됨)<br>공백이 들어간 인수는 따옴표로 묶는다 : java CommandLineTest "hello world" → args\[0] = "hello world"

## 내부 클래스 (inner class)

`7-5` · 📄 [`InnerTest.java`](InnerTest.java)

#### 💻 코드

<!-- code: InnerTest.java -->
```java
public class InnerTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display_Inner();                       // (1) Outer 안에서 Inner 사용

        Outer.Inner inner = outer.new Inner();       // (2) 바깥에서 Inner 객체 생성
        inner.print();
    }
}

class Outer {
    int num = 10;

    public class Inner {                             // ⚠ 처음 코드는 private class Inner (바깥에서 쓰려고 public 으로 바꿈)
        private int x = 5;
        public void print() {
            System.out.println("This is an inner class : " + num);   // outer의 num 사용
        }
    }

    void display_Inner() {
        Inner inner = new Inner();                   // Outer 안에서는 그냥 new Inner()
        System.out.println(inner.x);                 // inner의 private도 outer에서 접근
        inner.print();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
5
This is an inner class : 10
This is an inner class : 10
```

**포인트**

- 클래스 내부(outer class)에 다시 클래스(inner class)를 정의할 수 있다.
- 내부 클래스는 외부 클래스의 필드, 메소드를 마음대로 접근할 수 있다. (Inner.print 에서 Outer 의 num 사용)
- 반대로 Inner 의 private 멤버도 Outer 에서 접근할 수 있다. (display\_Inner 에서 inner.x)
- 내부 클래스가 public 이나 접근자 없이 선언되면, 다른 클래스에서 내부 클래스 타입의 객체를 직접 생성하여 사용할 수 있다.
  ```java
  Outer outer = new Outer();                 // ① 외부 클래스 객체를 먼저 만들고
  Outer.Inner inner = outer.new Inner();     // ② 그 외부 객체를 통해 내부 클래스 객체 생성
  ```<br>→ 내부 클래스 객체는 "어느 Outer 객체의 num 인지" 알아야 하므로 외부 객체 없이는 만들 수 없다.

```text
outer ──▶ [ Outer : num = 10 ]
                 ▲
                 │ (바깥 객체를 기억)
inner ──▶ [ Inner : x = 5 ]  → print() 에서 num 을 쓰면 이 Outer 의 num
```

- 📝 퀴즈 9번 필기 : B가 내부 클래스 inner class가 되면 B inner = new B(); 를 A.B inner = outer.new B(); 로 변경한다.

- ⚠ 자주 틀리는 부분 : 바깥에서 Outer.Inner 를 쓰려면 Inner 의 접근자를 private 에서 public 으로 바꿔야 한다.<br>private class Inner 그대로면 InnerTest 에서 Outer.Inner 를 쓸 수 없다.
  ```text
  error: Outer.Inner has private access in Outer
  ```<br>그래서 아래에서는 public class Inner 로 바꿨다.

## 메소드 내부 클래스 (method-local inner class)

`7-5` · 📄 [`MethodLocalInnerTest.java`](MethodLocalInnerTest.java)

#### 💻 코드

<!-- code: MethodLocalInnerTest.java -->
```java
public class MethodLocalInnerTest {               // 강의 코드에서는 이름이 InnerTest (위 예제와 겹쳐서 바꿈)
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.display_Inner();
    }
}

class Outer2 {                                    // 강의 코드에서는 이름이 Outer
    int num = 10;

    void display_Inner() {
        class Inner {                             // ⚠ private 제거
            int x = 5;
            public void print() {
                System.out.println("This is an inner class : " + num);
            }
        }
        Inner inner = new Inner();
        System.out.println(inner.x);
        inner.print();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
5
This is an inner class : 10
```

**포인트**

- 메소드 안에서도 클래스를 선언하여 사용할 수 있다. 이를 메소드 내부 클래스라 한다.
- 지역 변수처럼 "그 메소드 안에서만" 사용 가능하다. (display\_Inner 밖에서는 Inner 를 모름)
- public, private 는 불가하며 abstract 나 final 또는 접근자 없이 사용한다.<br>(지역 변수에 public/private 를 못 붙이는 것과 같은 이유)

- ⚠ 자주 틀리는 부분 : 메소드 안에서 "private class Inner" 로 선언하면 컴파일 오류가 난다.<br>메소드 지역 내부 클래스에는 public, private 를 붙일 수 없다.
    - ❌ private class Inner { ... }     error: illegal start of expression
    - ✅ class Inner { ... }             (접근자 없이)

## 내부 클래스와 일반 클래스로 선언할 경우의 차이

`7-5 실습` · 📄 [`MyRectangleInnerPoint.java`](MyRectangleInnerPoint.java)

          - (1) MyPoint 클래스를 MyRectangleInner 의 "내부 클래스" 로 작성

#### 💻 코드

<!-- code: MyRectangleInnerPoint.java -->
```java
public class MyRectangleInnerPoint {
    public static void main(String[] args) {
        MyRectangleInner r1 = new MyRectangleInner();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        MyRectangleInner.MyPoint p = r1.new MyPoint();    // 외부 객체(r1)를 통해 내부 클래스 객체 생성
        p.setX(3); p.setY(5);
        System.out.println(p.getX() + ", " + p.getY());
    }
}

class MyRectangleInner {
    private MyPoint corner = new MyPoint();   // 필드 정의
    private int width, height;

    public int getX() { return corner.x; }    // 메소드 정의 (내부 클래스의 private 필드 직접 접근)
    public void setX(int newX) { corner.x = newX; }
    public int getY() { return corner.y; }
    public void setY(int newY) { corner.y = newY; }
    public int getWidth() { return width; }
    public void setWidth(int newW) { width = newW; }
    public int getHeight() { return height; }
    public void setHeight(int newY) { height = newY; }
    public void resize(int newW, int newH) { width = newW; height = newH; }
    public int getArea() { return width * height; }

    class MyPoint {
        private int x, y;
        public int getX() { return x; }               // x값을 읽는 기능
        public void setX(int newX) { x = newX; }      // x값을 변경하는 기능
        public int getY() { return y; }               // y값을 읽는 기능
        public void setY(int newY) { y = newY; }      // y값을 변경하는 기능
    }
}
```
<!-- /code -->

#### 실행 결과

```text
면적은 20입니다.
3, 5
```

**포인트**

- MyPoint 클래스를 MyRectangleInner 클래스의 내부 클래스로 정의하여 MyRectangleInner 클래스에서 MyPoint 사용
- 내부 클래스이므로 MyRectangleInner 에서 MyPoint 의 private 필드에 "직접" 접근할 수 있다.
  ```java
  public int getX() { return corner.x; }     ← corner.getX() 를 거치지 않아도 됨
  ```
- main 에서 MyPoint 를 사용할 경우 외부 클래스 객체 생성 후 내부 클래스 생성
  ```java
  MyRectangleInner.MyPoint p = r1.new MyPoint();
  ```

- (2) 일반 클래스 버전(MyRectangleOuterPoint.java)과 비교
  ```text
  ┌────────────────────┬──────────────────────────────┬───────────────────────────────┐
  │                    │ (1) 내부 클래스              │ (2) 일반 클래스               │
  ├────────────────────┼──────────────────────────────┼───────────────────────────────┤
  │ MyRectangleInner 에서   │ corner.x  (private 직접 접근)│ corner.getX() (getter 필요)   │
  │ main 에서 생성     │ r1.new MyPoint()             │ new MyPoint()                 │
  │ 타입 이름          │ MyRectangleInner.MyPoint          │ MyPoint                       │
  └────────────────────┴──────────────────────────────┴───────────────────────────────┘
  ```

- 📝 실습 클래스2 1-❷ 필기 : 내부 클래스의 객체는 '외부객체.new 내부클래스()' 형태로 생성

- 💡 강의 코드의 public class 이름은 MyRectangleTest (7-3 예제, (2) 버전과 겹쳐서 바꿈)

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (MyRectangle → MyRectangleInner, 강의 코드에서는 바꾸기 전 이름)

## 내부 클래스와 일반 클래스로 선언할 경우의 차이

`7-5 실습` · 📄 [`MyRectangleOuterPoint.java`](MyRectangleOuterPoint.java)

          - (2) MyPointOuter 클래스를 "일반 클래스" 로 작성

#### 💻 코드

<!-- code: MyRectangleOuterPoint.java -->
```java
public class MyRectangleOuterPoint {
    public static void main(String[] args) {
        MyRectangleOuter r1 = new MyRectangleOuter();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        MyPointOuter p = new MyPointOuter();                   // 일반 클래스 → 바로 생성
        p.setX(3); p.setY(5);
        System.out.println(p.getX() + ", " + p.getY());
    }
}

class MyRectangleOuter {
    private MyPointOuter corner = new MyPointOuter();   // 필드 정의
    private int width, height;

    public int getX() { return corner.getX(); }            // 메소드 정의 (getter 로 접근)
    public void setX(int newX) { corner.setX(newX); }
    public int getY() { return corner.getY(); }
    public void setY(int newY) { corner.setY(newY); }
    public int getWidth() { return width; }
    public void setWidth(int newW) { width = newW; }
    public int getHeight() { return height; }
    public void setHeight(int newY) { height = newY; }
    public void resize(int newW, int newH) { width = newW; height = newH; }
    public int getArea() { return width * height; }
}

class MyPointOuter {
    private int x, y;
    public int getX() { return x; }               // x값을 읽는 기능
    public void setX(int newX) { x = newX; }      // x값을 변경하는 기능
    public int getY() { return y; }               // y값을 읽는 기능
    public void setY(int newY) { y = newY; }      // y값을 변경하는 기능
}
```
<!-- /code -->

#### 실행 결과

```text
면적은 20입니다.
3, 5
```

**포인트**

- MyPointOuter 가 MyRectangleOuter 밖의 별도 클래스이므로 MyPointOuter 의 private 필드(x, y)에 직접 접근할 수 없다.
  ```text
  corner.x          ❌ error: x has private access in MyPointOuter
  corner.getX()     ✅ getter / setter 를 거쳐야 한다
  ```
- main 에서도 외부 객체 없이 바로 new MyPointOuter() 로 생성한다.
- (1) 내부 클래스 버전과의 비교표는 MyRectangleInnerPoint.java 참고

- 💡 MyRectangleOuter 이 MyPointOuter 를 필드로 "가지고 있는" 구조를 포함 관계(Composition)라고 한다.<br>과제 클래스2 4번(Rectangle + Point), 실습 클래스2 1번(Circle + Point)이 같은 구조다.
- 💡 강의 코드의 public class 이름은 MyRectangleTest (겹쳐서 바꿈)

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (MyPoint → MyPointOuter, MyRectangle → MyRectangleOuter, 강의 코드에서는 바꾸기 전 이름)

---

[🏠 7주차 학습 가이드](../../README.md)
