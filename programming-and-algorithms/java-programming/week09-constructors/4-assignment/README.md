# 9주차 과제

[🏠 9주차 학습 가이드](../README.md)

| 파일 | 내용 |
|---|---|
| [EmployeeTest.java](#1-employee-생성자-3개-7강-과제에-생성자-추가) | 1. Employee: 생성자 3개 (7강 과제에 생성자 추가) |
| [CellPhoneTest.java](#2-cellphone-생성자-3개-is-getter) | 2. CellPhone: 생성자 3개, `is~` getter |
| [TriangleTest.java](#3-triangle-생성자와-넓이-int-형변환-출력) | 3. Triangle: 생성자와 넓이 (💡 `(int)` 형변환 출력) |
| [RectangleTest.java](#4-rectangle--point-정적-필드로-객체-수-세기) | 4. Rectangle + Point: 정적 필드로 객체 수 세기 (💡 체이닝으로 `rectCount++`는 한 곳에만, 이클립스 미사용 필드 경고) |
| [SMSTest.java](#5-sms-생성자-2개-나중에-setter로-값-넣기) | 5. SMS: 생성자 2개, 나중에 setter로 값 넣기 (💡 `setText` / `setMsgtext`) |
| [MyWorldTest.java](#6-myworld-같은-클래스-객체를-필드로-가지는-일촌-관계-인기도) | 6. MyWorld: 같은 클래스 객체를 필드로 가지는 일촌 관계, 인기도 (💡 `null` 검사) |

---

## 1. Employee: 생성자 3개 (7강 과제에 생성자 추가)

`9강 과제` · 📄 [`EmployeeTest.java`](EmployeeTest.java)

#### 문제 (요약)

> 이름(name), 전화번호(phone), 연봉(salary)을 필드로 가지는 Employee 클래스를 작성하시오.
>
> - 생성자를 중복 정의한다 : Employee(), Employee(name), Employee(name, phone, salary)
> - 필드는 private, getter / setter 를 둔다.
> - main 에서 홍길동 직원을 만들어 정보를 출력한다.

#### 💻 코드

<!-- code: EmployeeTest.java -->
```java
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee("홍길동", "010-1234-5678", 40000000);
        System.out.println("이름 : " + emp.getName() + ", 전화번호 : " + emp.getPhone()
                + ", 연봉 : " + emp.getSalary() + "원");

        // 💡 다른 생성자로 만든 직원
        System.out.print("💡 ");
        new Employee().printEmployeeInfo();
        System.out.print("💡 ");
        new Employee("김철수").printEmployeeInfo();
    }
}

class Employee {
    private String name;
    private String phone;
    private int salary;

    public Employee() {
        this("미정", "000-0000-0000", 0);
    }

    public Employee(String name) {
        this(name, "000-0000-0000", 0);
    }

    public Employee(String name, String phone, int salary) {
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public void printEmployeeInfo() {
        System.out.println("이름 : " + name + ", 전화번호 : " + phone + ", 연봉 : " + salary + "원");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
이름 : 홍길동, 전화번호 : 010-1234-5678, 연봉 : 40000000원
💡 이름 : 미정, 전화번호 : 000-0000-0000, 연봉 : 0원
💡 이름 : 김철수, 전화번호 : 000-0000-0000, 연봉 : 0원
```

**포인트**

- 7강 과제 클래스1 1번 Employee(getter / setter 만 사용)에 생성자를 추가한 문제.
- 생성자 체이닝 : 값이 주어지지 않은 항목은 "미정", "000-0000-0000", 0 으로 채운다.

- 💡 printEmployeeInfo() 를 만들어 두었지만 main 은 문제의 실행 결과 형식대로 getter 로 출력했다.<br>두 방법 모두 결과는 같다. (💡 줄에서 printEmployeeInfo() 도 호출)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. EmployeeTest 로 이름을 바꿨다.

## 2. CellPhone: 생성자 3개, `is~` getter

`9강 과제` · 📄 [`CellPhoneTest.java`](CellPhoneTest.java)

#### 문제 (요약)

> 모델명(model), 제조사(manufacturer), 색상(color), 전원 상태(power), 카메라 장착 여부(hasCamera)를 필드로 가지는 CellPhone 클래스를 작성하시오.
>
> - 생성자를 중복 정의한다 : CellPhone(), CellPhone(model, manufacturer), 모든 값을 받는 생성자
> - powerOn() / powerOff() 와 getter / setter 를 둔다.
> - NEXUS ONE, HTC, Black, 전원 off, 카메라 장착인 휴대폰을 만들어 출력한다.

#### 💻 코드

<!-- code: CellPhoneTest.java -->
```java
public class CellPhoneTest {
    public static void main(String[] args) {
        // 객체 생성 및 테스트 (NEXUS ONE, HTC, Black, 전원 off, 카메라 장착)
        CellPhone phone = new CellPhone("NEXUS ONE", "HTC", "Black", false, true);

        // 실행 결과 포맷에 맞춰 출력
        System.out.println("모델명 : " + phone.getModel());
        System.out.println("제조사 : " + phone.getManufacturer());
        System.out.println("색상 : " + phone.getColor());
        System.out.println("카메라 장착여부 : " + (phone.isHasCamera() ? "장착" : "미장착"));
    }
}

class CellPhone {
    private String model;
    private String manufacturer;
    private String color;
    private boolean power;
    private boolean hasCamera;

    public CellPhone() {
        this("미정", "미정", "Black", false, false);
    }

    public CellPhone(String model, String manufacturer) {
        this(model, manufacturer, "Black", false, false);
    }

    public CellPhone(String model, String manufacturer, String color, boolean power, boolean hasCamera) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.color = color;
        this.power = power;
        this.hasCamera = hasCamera;
    }

    public void powerOn() { power = true; }
    public void powerOff() { power = false; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public boolean isPower() { return power; }
    public boolean isHasCamera() { return hasCamera; }
    public void setHasCamera(boolean hasCamera) { this.hasCamera = hasCamera; }
}
```
<!-- /code -->

#### 실행 결과

```text
모델명 : NEXUS ONE
제조사 : HTC
색상 : Black
카메라 장착여부 : 장착
```

**포인트**

- 7강 과제 클래스2 2번 CellPhone(setter 로 값 설정)을 생성자로 바꾼 문제.
- boolean 필드의 getter 는 get\~ 대신 is\~ 로 짓는다 : isPower(), isHasCamera()<br>(7강 과제 📝 핵심 개념 표 참고)

- 💡 boolean 값을 "장착 / 미장착" 처럼 글자로 보여 주려고 삼항 연산자 (조건 ? A : B) 를 썼다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. CellPhoneTest 로 이름을 바꿨다.

## 3. Triangle: 생성자와 넓이 (`(int)` 형변환 출력)

`9강 과제` · 📄 [`TriangleTest.java`](TriangleTest.java)

#### 문제 (요약)

> 밑변(base)과 높이(height)를 필드로 가지는 Triangle 클래스를 작성하시오.
>
> - 생성자 : Triangle(), Triangle(base, height)
> - getter / setter 와 넓이를 구하는 getArea() 를 둔다.
> - 밑변 4, 높이 4 인 삼각형을 만들어 밑변, 높이, 넓이를 출력한다.

#### 💻 코드

<!-- code: TriangleTest.java -->
```java
public class TriangleTest {
    public static void main(String[] args) {
        Triangle t = new Triangle(4, 4);
        System.out.println("삼각형의 밑변 : " + (int) t.getBase());
        System.out.println("삼각형의 높이 : " + (int) t.getHeight());
        System.out.println("삼각형의 넓이는 " + (int) t.getArea() + "입니다.");
    }
}

class Triangle {
    private double base;
    private double height;

    public Triangle() {
        this(0.0, 0.0);
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() { return base; }
    public void setBase(double base) { this.base = base; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getArea() {
        return (base * height) / 2.0;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
삼각형의 밑변 : 4
삼각형의 높이 : 4
삼각형의 넓이는 8입니다.
```

**포인트**

- 7강 과제 클래스2 3번 Triangle 을 생성자로 바꾼 문제.
- Triangle() 은 this(0.0, 0.0) 으로 연결 (생성자 체이닝)

- 💡 필드가 double 이라 그대로 출력하면 4.0, 8.0 이 나온다. 실행 결과(4, 8)에 맞추려고 (int) 로 형변환해서 출력했다.<br>넓이가 7.5 처럼 소수가 되는 경우에는 (int) 가 소수점을 버리므로 주의. (7강 과제 💡 정수 나눗셈)
- 💡 new Triangle(4, 4) 처럼 int 를 넘겨도 double 매개변수로 자동 형변환된다.
- 💡 (base \* height) / 2.0 : 2 가 아니라 2.0 으로 나눠 실수 나눗셈임을 분명히 했다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. TriangleTest 로 이름을 바꿨다.

## 4. Rectangle + Point: 정적 필드로 객체 수 세기

`9강 과제` · 📄 [`RectangleTest.java`](RectangleTest.java)

#### 문제 (요약)

> 왼쪽 위 꼭짓점(origin, Point), 너비(width), 높이(height)를 필드로 가지는 Rectangle 클래스를 작성하시오.
>
> - Point 클래스 : Point(), Point(x, y), getX(), getY()
> - Rectangle 생성자 : Rectangle(), Rectangle(w, h), Rectangle(Point origin, w, h)
> - 넓이를 구하는 area() 와, 지금까지 만든 Rectangle 객체 수를 세는 정적 필드 rectCount 를 둔다.
> - 주어진 main 으로 세 사각형의 넓이와 전체 객체 수를 출력한다.

#### 💻 코드

<!-- code: RectangleTest.java -->
```java
public class RectangleTest {
    public static void main(String[] args) {
        Point originOne = new Point(23, 94);
        Rectangle rectOne = new Rectangle(originOne, 5, 6);
        Rectangle rectTwo = new Rectangle();
        Rectangle rectThree = new Rectangle(5, 6);

        System.out.println("Area 1 : " + rectOne.area());
        System.out.println("Area 2 : " + rectTwo.area());
        System.out.println("Area 3 : " + rectThree.area());
        System.out.println("Total Number of Objects : " + Rectangle.rectCount);
    }
}

class Point {
    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

class Rectangle {
    public static int rectCount = 0;
    private Point origin;
    private int width;
    private int height;

    public Rectangle() {
        this(new Point(0, 0), 0, 0);
    }

    public Rectangle(int w, int h) {
        this(new Point(0, 0), w, h);
    }

    public Rectangle(Point origin, int w, int h) {   // ← 모든 생성자가 여기로 모임
        this.origin = origin;
        this.width = w;
        this.height = h;
        rectCount++;                                   // 한 곳에서만 센다
    }

    public Point getOrigin() {                         // 💡 추가 (origin 미사용 경고 해결)
        return origin;
    }

    public int area() {
        return width * height;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Area 1 : 30
Area 2 : 0
Area 3 : 30
Total Number of Objects : 3
```

**포인트**

- 포함 관계 : Rectangle 이 Point 객체를 필드로 가진다. (7강 MyRectangle / MyPoint)
- 정적 필드 rectCount : 객체끼리 공유하는 "클래스당 하나" 의 변수 (7-2)

- 💡 생성자 체이닝 덕분에 rectCount++ 를 마지막 생성자 Rectangle(Point, int, int) 한 곳에만 쓰면 된다.<br>어떤 생성자로 만들어도 결국 그 생성자를 거치므로 개수가 빠짐없이 세어진다.<br>(생성자마다 rectCount++ 를 쓰면 this(...) 로 연결된 경우 두 번 세는 실수를 할 수 있다.)
- 💡 이클립스에서 origin 필드에 경고 아이콘(노란 느낌표)이 떴다. "The value of the field Rectangle.origin is not used",<br>즉 값을 넣기만 하고 어디서도 읽지 않는다는 뜻이다. 오류가 아니라 실행에는 문제없다.<br>getOrigin() 같은 getter 를 만들어 쓰면 경고가 사라진다. (아래에 💡 getOrigin() 추가)
- 💡 rectCount 는 public static 이라 Rectangle.rectCount 로 바로 읽을 수 있다. private 으로 숨기고 static int getRectCount() 를 두는 것이 캡슐화 측면에서는 더 좋다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. RectangleTest 로 이름을 바꿨다.

## 5. SMS: 생성자 2개, 나중에 setter로 값 넣기

`9강 과제` · 📄 [`SMSTest.java`](SMSTest.java)

#### 문제 (요약)

> 송신자(sender), 수신자(receiver), 메시지 내용(msgtext), 시각(time)을 필드로 가지는 SMS 클래스를 작성하시오.
>
> - 생성자 : SMS(sender, receiver), SMS(sender, receiver, msgtext, time)
> - setTime(), setText() 와 getter, 메시지를 출력하는 print() 를 둔다.
> - 주어진 main 으로 두 메시지를 출력한다.

#### 💻 코드

<!-- code: SMSTest.java -->
```java
public class SMSTest {
    public static void main(String[] args) {
        SMS m1 = new SMS("010-555-2111", "010-555-1111", "Hi", "03:10");
        SMS m2 = new SMS("010-555-1111", "010-555-2111");
        m2.setTime("03:11");
        m2.setMsgtext("Hm..");

        m1.print();
        System.out.println("===============================");
        m2.print();
    }
}

class SMS {
    private String sender;
    private String receiver;
    private String msgtext;
    private String time;

    public SMS(String sender, String receiver) {
        this(sender, receiver, "", "");
    }

    public SMS(String sender, String receiver, String msgtext, String time) {
        this.sender = sender;
        this.receiver = receiver;
        this.msgtext = msgtext;
        this.time = time;
    }

    public void setTime(String time) { this.time = time; }
    public void setMsgtext(String msgtext) { this.msgtext = msgtext; }
    public void setText(String text) { setMsgtext(text); }   // 문제에서 요구한 이름

    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public String getMsgtext() { return msgtext; }
    public String getTime() { return time; }

    public void print() {
        System.out.println("송신자 : " + sender);
        System.out.println("시  각 : " + time);
        System.out.println("메시지 : " + msgtext);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
송신자 : 010-555-2111
시  각 : 03:10
메시지 : Hi
===============================
송신자 : 010-555-1111
시  각 : 03:11
메시지 : Hm..
```

**포인트**

- SMS(sender, receiver) 는 아직 내용과 시각이 없는 메시지 → this(sender, receiver, "", "") 로 빈 문자열을 채운다.<br>나중에 setTime(), setMsgtext() 로 값을 넣는다. (생성자 = 초기 상태, 세터 = 나중에 수정 → 퀴즈 📝 필기)

- 💡 문제는 메시지를 바꾸는 메소드를 setText() 로 요구하지만 주어진 main 은 setMsgtext() 를 호출한다.<br>그래서 두 메소드를 모두 만들고 setText() 는 setMsgtext() 를 호출하게 했다.
- 💡 빈 값을 null 대신 "" 로 넣으면 출력할 때 "null" 이 찍히지 않고, 문자열 메소드를 호출해도 NullPointerException 이 안 난다.
- 💡 receiver 는 print() 에서 출력하지 않는다. (문제의 실행 결과 형식)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. SMSTest 로 이름을 바꿨다.

## 6. MyWorld: 같은 클래스 객체를 필드로 가지는 일촌 관계, 인기도

`9강 과제` · 📄 [`MyWorldTest.java`](MyWorldTest.java)

#### 문제 (요약)

> 이름(name), 일촌(myFrd, MyWorld 객체), 인기도(loveP)를 필드로 가지는 MyWorld 클래스를 작성하시오.
>
> - 생성자 MyWorld(name) : 이름을 받고 일촌은 없음(null), 인기도는 0 으로 초기화한다.
> - getName(), setMyFrd(친구), incLoveP()(인기도 1 증가), print() 를 둔다.
> - 주어진 main 에서 Lee, Kim, Kang, Song 네 명을 만들고, 한 명씩 친구 이름을 입력받아 일촌을 맺는다.<br>일촌으로 선택된 사람은 인기도가 1 올라간다.

#### 💻 코드

<!-- code: MyWorldTest.java -->
```java
import java.util.Scanner;

public class MyWorldTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyWorld[] P = new MyWorld[4];
        P[0] = new MyWorld("Lee");
        P[1] = new MyWorld("Kim");
        P[2] = new MyWorld("Kang");
        P[3] = new MyWorld("Song");

        for (int i = 0; i < 4; i++) {
            P[i].print();
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(P[i].getName() + "의 친구를 입력하세요 : ");
            String frd = sc.next();
            for (int j = 0; j < 4; j++) {
                if (frd.equals(P[j].getName())) {
                    P[i].setMyFrd(P[j]);
                    P[j].incLoveP();
                    break;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            P[i].print();
        }
        sc.close();
    }
}

class MyWorld {
    private String name;
    private MyWorld myFrd;     // 일촌 (같은 클래스의 객체)
    private int loveP;         // 인기도

    public MyWorld(String name) {
        this.name = name;
        this.myFrd = null;
        this.loveP = 0;
    }

    public String getName() {
        return name;
    }

    public void setMyFrd(MyWorld myFrd) {
        this.myFrd = myFrd;
    }

    public void incLoveP() {
        loveP++;
    }

    public void print() {
        System.out.println("=======================");
        System.out.println("이름 : " + name);
        System.out.println("일촌 : " + (myFrd != null ? myFrd.getName() : "없음"));
        System.out.println("인기도 : " + loveP);
    }
}
```
<!-- /code -->

#### 실행 결과 (입력 : Kim, Kang, Kim, Lee)

```text
=======================
이름 : Lee
일촌 : 없음
인기도 : 0
=======================
이름 : Kim
일촌 : 없음
인기도 : 0
=======================
이름 : Kang
일촌 : 없음
인기도 : 0
=======================
이름 : Song
일촌 : 없음
인기도 : 0
Lee의 친구를 입력하세요 : Kim
Kim의 친구를 입력하세요 : Kang
Kang의 친구를 입력하세요 : Kim
Song의 친구를 입력하세요 : Lee
=======================
이름 : Lee
일촌 : Kim
인기도 : 1
=======================
이름 : Kim
일촌 : Kang
인기도 : 2
=======================
이름 : Kang
일촌 : Kim
인기도 : 1
=======================
이름 : Song
일촌 : Lee
인기도 : 0
```

**포인트**

- 자기 자신과 같은 클래스(MyWorld)의 객체를 필드로 가진다. → 객체끼리 서로 "가리키는" 관계
- 객체 배열 P\[] 에서 입력한 이름과 같은 객체를 찾아 그 레퍼런스를 setMyFrd 로 넘긴다.

- 💡 myFrd 가 null 인 상태에서 myFrd.getName() 을 호출하면 NullPointerException 이 난다.<br>그래서 print() 에서 (myFrd != null ? myFrd.getName() : "없음") 으로 먼저 검사했다.
- 💡 문자열 비교는 == 가 아니라 equals() 를 쓴다. (6강 문자열)
- 💡 P\[j].incLoveP() 는 "친구로 선택된 사람" 의 인기도를 올린다. (내가 아니라 상대방)
- 💡 입력한 이름이 목록에 없으면 아무 일도 일어나지 않는다(일촌 없음 유지). 주어진 main 그대로 두었다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. MyWorldTest 로 이름을 바꿨다.

---

[🏠 9주차 학습 가이드](../README.md)
