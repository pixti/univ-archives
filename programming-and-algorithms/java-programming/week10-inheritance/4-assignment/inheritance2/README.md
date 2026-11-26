# 10주차 과제 · inheritance2

[🏠 10주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [PersonAbstractTest.java](#1-추상-person--athlete--lazyperson) | 1. 추상 Person / Athlete / LazyPerson |
| [GeometricShapeTest.java](#2-추상-geometricshape--triangle--square) | 2. 추상 GeometricShape / Triangle / Square (📝 헤론의 공식) |

---

## 1. 추상 Person / Athlete / LazyPerson

`10강 과제` · 📄 [`PersonAbstractTest.java`](PersonAbstractTest.java)

#### 문제

> 추상 메서드 eat() 및 exercise() 를 갖는 추상 클래스 Person 을 작성하라.<br>Person 클래스를 상속하고 각 사람이 어떻게 먹고 운동하는지 설명하는 각각의 메서드를 구현하는 하위 클래스 Athlete 및 LazyPerson 클래스를 작성하라. main 은 다음과 같다.
>
> ```java
> //Main
> public class Main {
>     public static void main(String[] args) {
>         Person athlete = new Athlete();
>         Person lazyPerson = new LazyPerson();
>         athlete.eat();
>         athlete.exercise();
>         lazyPerson.eat();
>         lazyPerson.exercise();
>     }
> }
> ```

#### 💻 코드

<!-- code: PersonAbstractTest.java -->
```java
public class PersonAbstractTest {
    public static void main(String[] args) {
        Person athlete = new Athlete();
        Person lazyPerson = new LazyPerson();
        athlete.eat();
        athlete.exercise();
        lazyPerson.eat();
        lazyPerson.exercise();
    }
}

abstract class Person {
    public abstract void eat();
    public abstract void exercise();
}

class Athlete extends Person {
    @Override
    public void eat() {
        System.out.println("Athlete: Include foods full of calcium, iron, potassium, and fiber.");
    }

    @Override
    public void exercise() {
        System.out.println("Athlete: Training allows the body to gradually build up strength and endurance, improve skill levels and build motivation, ambition and confidence.");
    }
}

class LazyPerson extends Person {
    @Override
    public void eat() {
        System.out.println("Couch Potato: Eating while watching TV also prolongs the time period that we're eating.");
    }

    @Override
    public void exercise() {
        System.out.println("Couch Potato: Rarely exercising or being physically active.");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Athlete: Include foods full of calcium, iron, potassium, and fiber.
Athlete: Training allows the body to gradually build up strength and endurance, improve skill levels and build motivation, ambition and confidence.
Couch Potato: Eating while watching TV also prolongs the time period that we're eating.
Couch Potato: Rarely exercising or being physically active.
```

**포인트**

- abstract class Person 에 몸체 없는 추상 메서드 eat(), exercise() 를 선언한다.
- Athlete, LazyPerson 은 두 추상 메서드를 모두 구현(재정의)해야 일반 클래스가 되어 객체를 만들 수 있다.
- main 에서는 Person 타입 변수에 자식 객체를 담고(업캐스팅), 실제 객체의 메서드가 실행된다(동적 바인딩).

- 💡 출력 문구의 "Couch Potato" 는 LazyPerson(소파에서 TV 만 보는 사람)을 뜻한다. 클래스 이름과 출력 문구가 다르지만 문제의 실행 결과 그대로 썼다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 PersonAbstractTest 로 이름을 바꿨다.

## 2. 추상 GeometricShape / Triangle / Square

`10강 과제` · 📄 [`GeometricShapeTest.java`](GeometricShapeTest.java)

#### 문제

> 추상 메소드 area() 및 perimeter() 를 갖는 추상 클래스 GeometricShape 클래스를 작성하라.<br>GeometricShape 클래스를 상속하고 각 모양의 면적과 둘레를 계산하는 해당 메서드를 구현하는 하위 클래스 Triangle 및 Square 를 작성하라. main 은 다음과 같다.
>
> ```java
> //Main.java
> public class Main {
>     public static void main(String[] args) {
>         GeometricShape triangle = new Triangle(4, 5, 6);
>         GeometricShape square = new Square(6);
>
>         System.out.println("Triangle Area: " + triangle.area());
>         System.out.println("Triangle Perimeter: " + triangle.perimeter());
>
>         System.out.println("Square Area: " + square.area());
>         System.out.println("Square Perimeter: " + square.perimeter());
>     }
> }
> ```

#### 💻 코드

<!-- code: GeometricShapeTest.java -->
```java
public class GeometricShapeTest {
    public static void main(String[] args) {
        GeometricShape triangle = new Triangle(4, 5, 6);
        GeometricShape square = new Square(6);

        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());

        System.out.println("Square Area: " + square.area());
        System.out.println("Square Perimeter: " + square.perimeter());
    }
}

abstract class GeometricShape {
    public abstract double area();
    public abstract double perimeter();
}

class Triangle extends GeometricShape {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        double s = (side1 + side2 + side3) / 2;                          // 헤론의 공식
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}

class Square extends GeometricShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Triangle Area: 9.921567416492215
Triangle Perimeter: 15.0
Square Area: 36.0
Square Perimeter: 24.0
```

#### 📒 해설

- 📝 필기 : 헤론의 공식 사용<br>세 변의 길이 a, b, c 만 알 때 삼각형의 넓이를 구하는 공식
  ```text
  s = (a + b + c) / 2          (둘레의 절반)
  ```<br>넓이 = √( s (s - a) (s - b) (s - c) )<br>a = 4, b = 5, c = 6  →  s = 7.5,  넓이 = √(7.5 x 3.5 x 2.5 x 1.5) = √98.4375 = 9.921567416492215

**포인트**

- 생성자 Triangle(4, 5, 6), Square(6) 는 정수를 넘기지만 매개변수가 double 이라 4.0, 5.0, 6.0 으로 자동 형변환된다.<br>그래서 둘레가 15.0, 24.0 처럼 실수로 출력된다.
- s 를 구할 때 (side1 + side2 + side3) / 2 는 side 들이 double 이라 실수 나눗셈이다. (정수였다면 15 / 2 = 7 로 잘린다)
- 제곱근은 Math.sqrt() 로 구한다.

- ⚠ 자주 틀리는 부분 : 세 변이 삼각형을 만들 수 없는 길이(예 : 1, 2, 10)면 s - c 가 음수가 되어 Math.sqrt 가 NaN 을 돌려준다.<br>실제로 쓰려면 "가장 긴 변 &lt; 나머지 두 변의 합" 인지 생성자에서 검사하는 것이 좋다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 GeometricShapeTest 로 이름을 바꿨다.

---

[🏠 10주차 학습 가이드](../../README.md)
