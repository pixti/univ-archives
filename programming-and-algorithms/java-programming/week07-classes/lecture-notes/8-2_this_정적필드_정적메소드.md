# 8-2. 클래스 2: this 키워드 · 정적 필드 · 정적 메소드

> 원본: `8-2 클래스2.pptx`
> 관련 코드: [`examples/MyIntegerThis.java`](../examples/MyIntegerThis.java), [`examples/StaticFieldTest.java`](../examples/StaticFieldTest.java), [`examples/StudentScoreStatic.java`](../examples/StudentScoreStatic.java), [`examples/MyMathDemo.java`](../examples/MyMathDemo.java), [`quiz/ClassQuiz.java`](../quiz/ClassQuiz.java) (6, 7, 8번)

---

## 1. this 키워드

- `this`는 **현재 메소드를 실행하고 있는 객체의 레퍼런스**를 저장하는 레퍼런스 변수다.

```java
class MyInteger {
    int val;
    int add(MyInteger ob) { return this.val + ob.val; }
    int subtract(MyInteger ob) { return this.val - ob.val; }
    int multiply(MyInteger ob) { return this.val * ob.val; }
    double divide(MyInteger ob) { return ((double) this.val)/ob.val; }
}
```

```java
MyInteger ob1 = new MyInteger();
MyInteger ob2 = new MyInteger();
int r = ob1.add(ob2);   // this <- ob1
int r2 = ob2.add(ob1);  // this <- ob2
```

```
ob1.add(ob2)  →  this = ob1,  ob = ob2  →  ob1.val + ob2.val
ob2.add(ob1)  →  this = ob2,  ob = ob1  →  ob2.val + ob1.val
```

> 참고:
> - 📝 **필기 (실습 클래스1 1번, AI 설명) this가 필요한 이유:**
>   - 같은 클래스로 만든 객체들은 메소드 코드를 따로 갖지 않는다. 메소드 코드는 메모리(Method Area)에 **한 번만** 올라가고 모든 객체가 공유한다.
>   - 그래서 메소드 안에서 "**어느 객체의** 필드인지" 알려 줘야 한다. 그 역할을 하는 것이 `this`다.
>   - `b.setTitle("Great C++")`를 호출하면 JVM이 `b`의 주소를 **숨겨진 매개변수**로 몰래 넘겨준다. 그 값이 바로 `this`(메소드를 호출한 객체)다.
>   - 매개변수 이름을 필드 이름과 똑같이 짓는 것이 표준 관례다. 메소드 안에서는 **매개변수가 우선**하기 때문에 `title = title;`이라고 쓰면 매개변수에 자기 자신을 넣는 셈이 된다. 그래서 `this.title = title;`로 필드임을 밝혀야 한다.
>   - getter(`return title;`)처럼 이름이 겹치지 않을 때는 보통 `this`를 생략한다.
> - ⚠ 슬라이드의 `this.val – ob.val`에서 `–`는 빼기 기호(`-`)가 아니라 en dash다. 그대로 쓰면 컴파일 오류가 난다. `Int r`은 `int`의 오타다.

---

## 2. [실습] 앞 예제 this 키워드 사용하여 바꾸기

```java
public class Student {
    String sname;
    int sid, kor, eng, math;
    void setInfo(String name, int id, int k, int e, int m) {
        this.sname = name;
        this.sid = id;
        this.kor = k;
        this.eng = e;
        this.math = m;
    }
    double getAverage() {
        return (this.kor + this.eng + this.math)/3.0;
    }
    …
}
```

> 참고:
> - 💡 여기서는 매개변수 이름(`name`, `k`, …)과 필드 이름(`sname`, `kor`, …)이 달라서 `this`를 빼도 의미가 같다. 매개변수 이름이 필드 이름과 같을 때(`this.kor = kor;`)는 `this`를 꼭 써야 한다.

---

## 3. 정적 필드 (static field)

- 같은 클래스로 만든 객체들끼리 **값을 공유**해야 할 때 쓴다.
- 자료형 앞에 `static` 키워드를 붙인다.
- 일반 필드와 달리 객체마다 생기지 않는다. **클래스당 하나만** 생성되고, 같은 클래스의 객체들이 공유한다.
- 정적 필드는 특정 객체와 무관하다. 그래서 객체를 만들기 전에도 **클래스명**으로 사용할 수 있다.

```java
System.out.println(StaticTest.value);
```

```java
public class MyApp {
    public static void main(String[] args) {
        StaticTest ob1 = new StaticTest();
        StaticTest ob2 = new StaticTest();
        ob1.setValue(3);
        System.out.println(ob2.getValue());   // 3출력
        ob1.setInstVal(5);
        System.out.println(ob2.getInstVal()); // static 변수 아님
    }
}

class StaticTest {
    static int value;
    int instVal;
    void setValue(int n) {value = n;}
    int getValue() {return value;}
    void setInstVal(int n) {instVal = n;}
    int getInstVal() {return instVal;}
}
```

```
3
0
```

```
          ┌──── StaticTest 클래스 (하나만) ────┐
          │   static int value = 3             │ ◀── ob1, ob2가 함께 사용
          └────────────────────────────────────┘
ob1 ──▶ [ instVal = 5 ]
ob2 ──▶ [ instVal = 0 ]     ← 객체마다 따로 있음
```

> 참고:
> - 📝 **필기 (퀴즈 6번) 보충 설명:**
>   - 일반 필드는 객체를 생성할 때마다 **따로따로** 할당된다.
>   - 일반 필드는 객체 생성 없이는 접근할 수 없다. 객체를 생성해야 한다.
>   - 스태틱 필드는 같은 클래스 안에서 객체마다가 아니라 **하나만 공유**되는 형태로 할당된다.
>   - 스태틱 필드는 객체 생성 없이도 접근이 가능하다.
> - 📝 **필기 (퀴즈 6번, AI 설명) static 필드 vs 일반 필드:**
>
>   | 구분 | static 필드 (클래스 변수) | 일반 필드 (인스턴스 변수) |
>   |---|---|---|
>   | 생성 시점 | 클래스가 로드될 때 **한 번** | `new`로 객체를 만들 때마다 |
>   | 저장 위치 | 메소드(static) 영역 | Heap (객체 안) |
>   | 개수 | 클래스당 1개, 모든 객체가 공유 | 객체마다 1개씩 |
>   | 접근 | `클래스명.필드명` (권장) | `객체변수.필드명` |
>
> - 📝 **필기 (퀴즈 7번) ★ 기말고사 출제 유력:** `ob1.z = 3; ob2.z = 4; ob3.z = 5;` 뒤에 `ob1.z++; ob2.z++; ob3.z++;`를 하면 `z`는 하나뿐이다. 마지막에 대입된 5에서 시작해 ++가 3번 일어나 `8, 8, 8`이 출력된다. 같은 상황의 일반 필드 `x`는 `4, 5, 6`이다. 자세한 풀이는 [`quiz/ClassQuiz.java`](../quiz/ClassQuiz.java) `q7()`에 있다.

---

## 4. [실습] 앞 예제 정적 변수 사용하여 재구현하기

- 학생 수를 세는 `count`를 정적 변수로 추가한다.
- 배열은 넉넉하게 100칸으로 만들고, 실제 학생 수(`Student.count`)만큼만 반복한다.

```java
// Student.java 파일
public class Student {
    String sname;
    int sid, kor, eng, math;
    static int count = 0; // 정적 변수 추가!
    void setInfo(String name, int id, int k, int e, int m) {
        this.sname = name; this.sid = id; this.kor = k; this.eng = e; this.math = m;
    }
    double getAverage() { return (this.kor + this.eng + this.math)/3.0;}
    String getInfo() {return this.sname + ", " + this.sid + ", " + this.kor + ", " + this.eng + ", " + this.math;}
}
```

```java
// StudentScore.java 파일
public class StudentScore {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;
        Student [] students = new Student[100];
        students[0] = new Student();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        Student.count++; // students[0].count++;
        students[1] = new Student();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        Student.count++; // students[0].count++;
        students[2] = new Student();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);
        Student.count++; // students[0].count++;
        for(int i=0; i < Student.count; i++) {
            System.out.println(students[i].getInfo());
            korSum += students[i].kor;
            engSum += students[i].eng;
            mathSum += students[i].math;
            totalSum += students[i].getAverage();
        }
        korAvg = ((double) korSum) / Student.count;
        engAvg = ((double) engSum) / Student.count;
        mathAvg = ((double) mathSum) / Student.count;
        totalAvg = totalSum / Student.count;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}
```

> 참고:
> - 💡 주석의 `students[0].count++`처럼 객체로 접근해도 **같은 변수 하나**를 가리킨다. 다만 static임이 잘 드러나도록 `Student.count`처럼 클래스명으로 쓰는 것을 권장한다. (퀴즈 7번의 `A.z++`)
> - 💡 반복문을 `students.length`(100)까지 돌리면 비어 있는 칸(`null`)에서 `NullPointerException`이 난다. 그래서 `Student.count`까지만 돈다.
> - 💡 실행 결과는 8-1 예제와 같다. 실행해 볼 수 있도록 두 파일을 [`examples/StudentScoreStatic.java`](../examples/StudentScoreStatic.java) 한 파일로 합쳤다.

---

## 5. 정적 메소드 (static method)

- 정적 메소드는 **일반 필드(인스턴스 변수)를 사용하지 않는** 메소드다.
- 일반 필드를 쓰지 않으므로 **객체를 만들지 않고도** 실행할 수 있다.
- 정적 메소드는 **정적 필드, 인수, 지역 변수만** 사용할 수 있다. 즉 일반 필드는 쓸 수 없다.

```java
public class MyApp {
    int x = 3;
    public static void main(String[] args) {
        System.out.println(x);   // 일반 필드 접근하여 오류!
    }
}
```

```
error: non-static variable x cannot be referenced from a static context
```

> 참고:
> - 📝 **필기 (퀴즈 6번) 보충 설명:** 메서드도 필드와 마찬가지로 non-static 메서드와 static 메서드가 있다. 일반 메서드는 반드시 객체를 생성하고 `객체.메서드명()`으로 접근한다. 스태틱 메서드는 `클래스명.메서드명()`으로 객체 생성 없이 접근할 수 있다.
> - 📝 **필기 (퀴즈 8번, AI 설명) static 메서드와 멤버 접근 제약:**
>
>   | 메소드 안에서 | 일반 필드 | 일반 메소드 | static 필드 | static 메소드 | `this` |
>   |---|---|---|---|---|---|
>   | **static 메소드** | ❌ | ❌ | ✅ | ✅ | ❌ |
>   | **일반 메소드** | ✅ | ✅ | ✅ | ✅ | ✅ |
>
>   static 메소드 안에서는 지역 변수, static 필드, static 메소드만 바로 쓸 수 있다.
> - 📝 **필기 (실습 클래스2 3·4번, AI 설명):** `main`이 static인 이유는 JVM이 **객체 없이** 프로그램 시작점을 호출해야 하기 때문이다. 그래서 main에서 일반 메소드를 쓰려면 먼저 `new`로 객체를 만들고 `객체.메소드()`로 호출한다. ("static에서 non-static을 아예 못 부르는 것"이 아니라 "**객체 없이** 바로는 못 부르는 것"이다.)
> - 💡 위 오류를 고치려면 `x`를 `static int x = 3;`으로 바꾸거나, `MyApp app = new MyApp(); System.out.println(app.x);`처럼 객체를 통해 접근한다.

---

## 6. [실습] 수학 라이브러리 작성: 원주와 원 면적, 마일을 킬로미터로

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
    }
}

//MyMath 클래스는 다음과 같이 작성토록 한다.
class MyMath {
    static final double PI = 3.14159;
    static final double KMPerMILE = 1.609344;
    static double getCirclePerimeter(double r) {return 2*PI*r;}
    static double getCircleArea(double r) { return PI*r*r;}
    static double kilometerToMile(double km) {return km * 1/KMPerMILE;}
    static double mileToKilometer(double m) {return m * KMPerMILE;}
}
```

```
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

> 참고:
> - 💡 `MyMath`에는 일반 필드가 없다. 모든 기능이 인수만으로 계산되므로 static 메소드로 만들기 딱 맞다. 자바의 `Math` 클래스(`Math.max`, `Math.round`, `Math.random` …)도 같은 방식이라 `new Math()` 없이 쓴다.
> - 💡 `static final`은 객체마다 가질 필요가 없는 **상수**다. 상수 이름은 보통 대문자와 밑줄로 짓는다. (`PI`, `KM_PER_MILE`)
> - 💡 슬라이드 12의 실행 화면 이미지는 위 실행 예로 대신했다. (반지름 2를 넣으면 둘레와 면적이 같은 값이 나온다.)
