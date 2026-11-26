# 7주차 과제 · classes2

[🏠 7주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [DiceTest.java](#1-주사위-굴리기-mathrandom으로-16-만들기) | 1. 주사위 굴리기 (📝 `Math.random()`으로 1~6 만들기) |
| [CellPhoneTest.java](#2-cellphone-boolean-필드와-is-getter) | 2. CellPhone: boolean 필드와 `is~` getter (📝 핵심 개념 표) |
| [TriangleTest.java](#3-삼각형의-넓이) | 3. 삼각형의 넓이 (📝 int vs double, 💡 정수 나눗셈) |
| [RectangleTest.java](#4-사각형-면적-비교와-겹치는-영역-intersect) | 4. 사각형 면적 비교와 겹치는 영역 `intersect` (📝 포함 관계, `Math.max` / `Math.min`. 💡 겹치는 예시 추가) |

---

## 1. 주사위 굴리기 (`Math.random()`으로 1~6 만들기)

`7강 과제` · 📄 [`DiceTest.java`](DiceTest.java)

#### 문제

> 주사위의 눈(face)을 필드로 가지는 Dice 클래스를 작성하시오.
>
>   - roll()    : 1\~6 사이의 숫자를 무작위로 정해 face 에 저장
>   - getFace() : face 반환
>
> main 에서 주사위를 10번 굴려 나온 숫자를 출력한다.

#### 💻 코드

<!-- code: DiceTest.java -->
```java
public class DiceTest {
    public static void main(String[] args) {
        Dice D1 = new Dice();
        for (int i = 0; i < 10; i++) {
            D1.roll();
            System.out.println("주사위의 숫자는 " + D1.getFace() + "입니다.");
        }
    }
}

class Dice {
    private int face;

    public void roll() {
        face = (int) (Math.random() * 6) + 1;     // 1 ~ 6
    }

    public int getFace() {
        return face;
    }
}
```
<!-- /code -->

#### 실행 예 (무작위라 매번 다름)

```text
주사위의 숫자는 3입니다.
주사위의 숫자는 6입니다.
주사위의 숫자는 1입니다.
... (총 10줄)
```

**포인트**

- face 는 private → roll() 로만 바뀌고 getFace() 로만 읽을 수 있다.

- 📝 필기 : Math.random() 으로 1\~6 만들기
  ```text
  Math.random()                  0.0 <= x < 1.0      (1.0 은 나오지 않음)
  Math.random() * 6              0.0 <= x < 6.0
  (int)(Math.random() * 6)       0, 1, 2, 3, 4, 5    (소수점 버림)
  (int)(Math.random() * 6) + 1   1, 2, 3, 4, 5, 6
  ```<br>→ 일반화 : (int)(Math.random() \* 개수) + 시작값

- ⚠ (int)Math.random() \* 6 + 1 처럼 괄호를 빼면 (int) 가 Math.random() 에만 적용되어 항상 0 → 결과가 항상 1

- 💡 main 의 참조 변수 이름 D1 은 문제 그대로 두었다. (자바 관례로는 소문자로 시작하는 d1 이 좋다)

## 2. CellPhone: boolean 필드와 `is~` getter

`7강 과제` · 📄 [`CellPhoneTest.java`](CellPhoneTest.java)

#### 문제

> 모델명(model), 제조사(manufacturer), 색상(color), 전원(power), 카메라 장착 여부(camera)를 필드로 가지는 CellPhone 클래스를 작성하시오. getter / setter 와 전원을 켜고 끄는 turnOn() / turnOff() 를 만든다.<br>main 에서 값을 넣고 휴대폰 정보를 출력한다.

#### 💻 코드

<!-- code: CellPhoneTest.java -->
```java
public class CellPhoneTest {
    public static void main(String[] args) {
        CellPhone phone = new CellPhone();
        phone.setModel("NEXUS ONE");
        phone.setManufacturer("HTC");
        phone.setColor("Black");
        phone.setCamera(true);
        phone.turnOn();

        System.out.println("모델명 : " + phone.getModel());
        System.out.println("제조사 : " + phone.getManufacturer());
        System.out.println("색상 : " + phone.getColor());
        System.out.println("카메라 장착여부 : " + (phone.isCamera() ? "장착" : "미장착"));
    }
}

class CellPhone {
    private String model;
    private String manufacturer;
    private String color;
    private boolean power;
    private boolean camera;

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public boolean isPower() { return power; }              // boolean getter → is~
    public void setPower(boolean power) { this.power = power; }

    public boolean isCamera() { return camera; }
    public void setCamera(boolean camera) { this.camera = camera; }

    public void turnOn() { power = true; }
    public void turnOff() { power = false; }
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

#### 📒 해설

- 📝 필기 : 핵심 개념
  ```text
  | 개념         | 이 코드에서                                       | 설명                                       |
  ```<br>|--------------|---------------------------------------------------|--------------------------------------------|
  ```text
  | private      | private String model; ...                         | 필드를 밖에서 직접 못 바꾸게 숨김 (캡슐화) |
  | getter       | getModel(), isPower(), isCamera()                 | 필드 값을 읽어 돌려줌                      |
  | setter       | setModel(...), setCamera(true)                    | 필드 값을 바꿈                             |
  | boolean      | private boolean power, camera;                    | true / false 두 가지 상태                  |
  | turnOn       | power = true;                                     | 전원 켜기                                  |
  | turnOff      | power = false;                                    | 전원 끄기                                  |
  | 삼항 연산자  | phone.isCamera() ? "장착" : "미장착"              | 조건 ? 참일 때 값 : 거짓일 때 값           |
  ```
  - boolean 필드의 getter 는 관례적으로 get 대신 is 를 붙인다.  getCamera() → isCamera()<br>("카메라가 있는가?" 처럼 질문 형태로 읽힘)

- 💡 power 는 turnOn() 으로 true 가 되지만 출력하지는 않는다. 확인하려면
  ```java
  System.out.println("전원 : " + (phone.isPower() ? "켜짐" : "꺼짐"));
  ```

## 3. 삼각형의 넓이

`7강 과제` · 📄 [`TriangleTest.java`](TriangleTest.java)

#### 문제

> 밑변(base)과 높이(height)를 필드로 가지는 Triangle 클래스를 작성하고,<br>넓이를 돌려주는 getArea() 를 만드시오.

#### 💻 코드

<!-- code: TriangleTest.java -->
```java
public class TriangleTest {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        t.setBase(4);
        t.setHeight(4);

        System.out.println("삼각형의 밑변 : " + t.getBase());
        System.out.println("삼각형의 높이 : " + t.getHeight());
        System.out.println("삼각형의 넓이는 " + t.getArea() + "입니다.");
    }
}

class Triangle {
    private int base;
    private int height;

    public int getBase() { return base; }
    public void setBase(int base) { this.base = base; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getArea() {
        return base * height / 2;
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

**📝 필기**

  - 삼각형의 넓이 = 밑변 × 높이 ÷ 2   →   return base \* height / 2;
  - 출력 결과(8)가 정수이므로 int 를 사용했다.<br>소수점이 나올 수 있는 값(예 : 밑변 3, 높이 5 → 7.5)을 다루려면 double 을 쓴다.

- 💡 int 끼리의 나눗셈은 소수점을 버린다. (정수 나눗셈)
  ```java
      3 * 5 / 2   = 15 / 2 = 7      (7.5 가 아님!)
      3 * 5 / 2.0 = 7.5             (하나라도 실수면 실수 나눗셈)
  double 로 바꾸려면 :  public double getArea() { return base * height / 2.0; }
  ```

## 4. 사각형 면적 비교와 겹치는 영역 `intersect`

`7강 과제` · 📄 [`RectangleTest.java`](RectangleTest.java)

#### 문제

> 시작점(Point startPoint, 왼쪽 아래 꼭짓점), 너비(width), 높이(height)를 가지는 Rectangle 클래스를 작성하시오.
>
>   - getArea()                 : 면적
>   - intersect(Rectangle other): 두 사각형이 겹치는 영역을 새 Rectangle 로 반환, 겹치지 않으면 null
>
> main 에서 두 사각형의 면적을 비교하고, 겹치는 영역을 출력한다.

#### 💻 코드

<!-- code: RectangleTest.java -->
```java
public class RectangleTest {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.setX(10);
        p1.setY(10);
        Point p2 = new Point();
        p2.setX(3);
        p2.setY(7);

        Rectangle r1 = new Rectangle();
        r1.setStartPoint(p1);
        r1.setWidth(5);
        r1.setHeight(5);

        Rectangle r2 = new Rectangle();
        r2.setStartPoint(p2);
        r2.setWidth(6);
        r2.setHeight(4);

        if (r1.getArea() > r2.getArea()) {
            System.out.println("첫 번째 사각형 면적이 더 넓습니다.");
        } else {
            System.out.println("두 번째 사각형 면적이 더 넓습니다.");
        }

        Rectangle inter = r1.intersect(r2);
        printIntersect(inter);

        // 💡 추가 예시 : 겹치는 경우
        Point p3 = new Point();
        p3.setX(12);
        p3.setY(8);
        Rectangle r3 = new Rectangle();
        r3.setStartPoint(p3);
        r3.setWidth(6);
        r3.setHeight(4);
        System.out.print("(💡 추가 예시) ");
        printIntersect(r1.intersect(r3));
    }

    static void printIntersect(Rectangle inter) {
        if (inter == null) {
            System.out.println("겹치는 영역이 없습니다.");
        } else {
            System.out.println("(" + inter.getX() + ", " + inter.getY() + ")에서 너비 "
                    + inter.getWidth() + ", 높이 " + inter.getHeight() + " 만큼 겹칩니다.");
        }
    }
}

class Rectangle {
    private Point startPoint;       // 포함 관계 : Rectangle has-a Point
    private int width;
    private int height;

    public Point getStartPoint() { return startPoint; }
    public void setStartPoint(Point startPoint) { this.startPoint = startPoint; }

    public int getX() { return startPoint.getX(); }
    public int getY() { return startPoint.getY(); }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getArea() {
        return width * height;
    }

    public Rectangle intersect(Rectangle other) {
        int left = Math.max(this.getX(), other.getX());
        int bottom = Math.max(this.getY(), other.getY());
        int right = Math.min(this.getX() + this.width, other.getX() + other.width);
        int top = Math.min(this.getY() + this.height, other.getY() + other.height);

        if (left >= right || bottom >= top) {
            return null;                          // 겹치지 않음
        }

        Point p = new Point();
        p.setX(left);
        p.setY(bottom);
        Rectangle result = new Rectangle();
        result.setStartPoint(p);
        result.setWidth(right - left);
        result.setHeight(top - bottom);
        return result;
    }
}

class Point {
    private int x, y;

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}
```
<!-- /code -->

#### 실행 결과

```text
첫 번째 사각형 면적이 더 넓습니다.
겹치는 영역이 없습니다.
(💡 추가 예시) (12, 10)에서 너비 3, 높이 2 만큼 겹칩니다.
```

#### 📒 해설

- 📝 필기 : 핵심 개념
  - Point 클래스      : x, y 좌표를 저장
  - Rectangle 클래스  : Point 를 필드로 가진다 → 포함 관계 (Composition, "has-a")<br>getX() / getY() 는 startPoint.getX() 를 대신 불러 주는 편의 메서드
  - getArea()         : width \* height
  - intersect()       : 겹치면 새 Rectangle 객체를, 겹치지 않으면 null 을 반환
  - Math.max / Math.min 으로 겹치는 영역의 경계를 구한다.

```text
겹치는 영역의  왼쪽   = 두 사각형 왼쪽(x)       중 큰 값   Math.max
               아래   = 두 사각형 아래(y)       중 큰 값   Math.max
               오른쪽 = 두 사각형 오른쪽(x + w) 중 작은 값 Math.min
               위     = 두 사각형 위(y + h)     중 작은 값 Math.min
```

left >= right 또는 bottom >= top 이면 겹치지 않음 → null

  - 이 문제의 값<br>r1 : (10, 10) 에서 5 x 5  → x 10 \~ 15, y 10 \~ 15, 면적 25<br>r2 : ( 3,  7) 에서 6 x 4  → x  3 \~  9, y  7 \~ 11, 면적 24
    ```text
    left = max(10, 3) = 10,  right = min(15, 9) = 9   → left >= right → 겹치지 않음
    ```

- 💡 intersect 가 null 을 돌려줄 수 있으므로 main 에서 반드시 if (inter == null) 을 먼저 검사해야 한다.<br>검사 없이 inter.getX() 를 부르면 NullPointerException 이 난다.
- 💡 실제로 겹치는 경우도 확인하려고 r3 예시를 추가했다. (문제에는 없음)<br>r1 (10,10) 5x5 와 r3 (12,8) 6x4 → x 12 \~ 15, y 10 \~ 12 → (12, 10) 에서 너비 3, 높이 2

---

[🏠 7주차 학습 가이드](../../README.md)
