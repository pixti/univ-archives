# 7주차 실습 · classes2

[🏠 7주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [CircleTest.java](#1-❶-circle--point-포함-관계-resizedouble로-변경-메서드-체이닝) | 1-❶. Circle + Point 포함 관계 (📝 `resize(double)`로 변경, 메서드 체이닝) |
| [CircleInnerPointTest.java](#1-❷-point를-circle의-내부-클래스로-c1new-point) | 1-❷. Point를 Circle의 내부 클래스로 (`c1.new Point()`) |
| [MatrixTest.java](#2-3x3-행렬의-합--차--전치--곱-참고-답안) | 2. 💡 3x3 행렬의 합 · 차 · 전치 · 곱 (참고 답안) |
| [TheaterTest.java](#3-영화관-좌석-예약-실행-클래스--좌석-관리-클래스) | 3. 영화관 좌석 예약: 실행 클래스 + 좌석 관리 클래스 (📝 개념 정리 1~5: 클래스와 객체, 필드와 메서드, `private`, `static`, 생성자) |
| [TheaterSeatsSystem.java](#4-영화관-좌석-예약-하나의-클래스로-통합) | 4. 영화관 좌석 예약: 하나의 클래스로 통합 (📝 개념 정리 6~10: 2차원 배열, `this`, 단축 평가, do-while · switch, 3번 vs 4번 설계 비교, ★ 시험 포인트) |

---

## 1-❶. Circle + Point 포함 관계 (`resize(double)`로 변경, 메서드 체이닝)

`7강 실습` · 📄 [`CircleTest.java`](CircleTest.java)

#### 문제

> 중심 좌표(Point center)와 반지름(radius)을 필드로 가지는 Circle 클래스를 만드시오.
>
>   - getter / setter
>   - move(Point newPos)   : 중심을 newPos 로 옮긴다
>   - resize(newRadius)    : 반지름을 바꾼다
>   - getArea()            : 넓이
>   - toString()           : "중심 : x, y 반지름 : r"
>
> Point 클래스는 private int x, y 와 getter / setter 를 가진다.

#### 💻 코드

<!-- code: CircleTest.java -->
```java
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Point p1 = new Point();
        p1.setX(3);
        p1.setY(5);
        c1.setCenter(p1);
        c1.setRadius(7);
        System.out.println(c1.toString());

        Point p2 = new Point();
        p2.setX(8);
        p2.setY(8);
        c1.move(p2);
        c1.resize(4);
        System.out.println(c1.toString());
        System.out.println("넓이 : " + c1.getArea());     // 💡 getArea 확인용 출력 추가
    }
}

class Circle {
    private Point center;
    private double radius;

    public Point getCenter() { return center; }
    public void setCenter(Point center) { this.center = center; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public void move(Point newPos) {
        this.center = newPos;
    }

    public void resize(double newRadius) {      // 📝 int → double 로 변경
        this.radius = newRadius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        String rStr = (radius % 1 == 0) ? String.valueOf((int) radius) : String.valueOf(radius);
        return "중심 : " + center.getX() + ", " + center.getY() + " 반지름 : " + rStr;
        // 같은 결과 : this.center.getX() / this.getCenter().getX() / getCenter().getX()
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
중심 : 3, 5 반지름 : 7
중심 : 8, 8 반지름 : 4
넓이 : 50.26548245743669
```

**포인트**

- Circle 이 Point 객체를 필드로 "가지고 있는" 포함 관계(Composition)
  ```text
  c1 ──▶ [ Circle : center ●, radius 7.0 ]
                           └──▶ [ Point : x 3, y 5 ]
  ```
- 중심 좌표를 읽을 때는 center.getX() 처럼 . 을 두 번 쓴다.
- move(p2) 는 center 가 p2 객체를 가리키게 바꾼다. (좌표를 복사하는 것이 아니라 레퍼런스를 바꿈)
- radius 는 double 이므로 7 을 넣으면 7.0 → toString 에서 소수 부분이 0 이면 정수로 출력

- 📝 필기 : resize(int newRadius) -> resize(double newRadius) 로 구현하도록 문제를 변경한다.<br>(반지름 필드가 double 이므로 매개변수도 double 로 맞춤)

- 📝 필기 : this.center.getX()  center.getX() 로 해도되고<br>아니면 this.getCenter().getX()  getCenter().getX() 로 메서드 이중으로 해도된다. 메서드 체이닝.
- 📝 필기 : 클래스 안에서는 네 가지 모두 같은 결과다.
  ```text
  this.center.getX()        ← 필드 center 에 this 를 붙여 명시
  center.getX()             ← this 생략
  this.getCenter().getX()   ← getter 가 돌려준 Point 에 바로 .getX() (메서드 체이닝)
  getCenter().getX()        ← this 생략
  ```

- 💡 move(p2) 뒤에 main 에서 p2.setX(100) 을 하면 원의 중심도 같이 바뀐다. (같은 Point 객체를 공유)<br>이게 싫다면 move 에서 새 Point 를 만들어 좌표만 복사하면 된다.
- 💡 같은 폴더의 CircleInnerPointTest.java (❷) 에도 Circle, Point 가 있어서 두 파일을 한꺼번에 컴파일하면 이름이 겹친다. java CircleTest.java 처럼 한 파일씩 실행한다.

## 1-❷. Point를 Circle의 내부 클래스로 (`c1.new Point()`)

`7강 실습` · 📄 [`CircleInnerPointTest.java`](CircleInnerPointTest.java)

#### 문제

> - ❶ 의 Point 클래스를 CircleInner 클래스의 내부 클래스로 정의하여 같은 결과를 출력하시오.

#### 💻 코드

<!-- code: CircleInnerPointTest.java -->
```java
public class CircleInnerPointTest {
    public static void main(String[] args) {
        CircleInner c1 = new CircleInner();
        CircleInner.Point p1 = c1.new Point();       // 외부 객체 c1 을 통해 생성
        p1.setX(3);
        p1.setY(5);
        c1.setCenter(p1);
        c1.setRadius(7);
        System.out.println(c1.toString());

        CircleInner.Point p2 = c1.new Point();
        p2.setX(8);
        p2.setY(8);
        c1.move(p2);
        c1.resize(4);
        System.out.println(c1.toString());
    }
}

class CircleInner {
    private Point center;
    private double radius;

    public Point getCenter() { return center; }
    public void setCenter(Point center) { this.center = center; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public void move(Point newPos) { this.center = newPos; }
    public void resize(double newRadius) { this.radius = newRadius; }
    public double getArea() { return Math.PI * radius * radius; }

    @Override
    public String toString() {
        String rStr = (radius % 1 == 0) ? String.valueOf((int) radius) : String.valueOf(radius);
        return "중심 : " + center.getX() + ", " + center.getY() + " 반지름 : " + rStr;
    }

    // 내부 클래스
    public class Point {
        private int x, y;
        public int getX() { return x; }
        public void setX(int x) { this.x = x; }
        public int getY() { return y; }
        public void setY(int y) { this.y = y; }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
중심 : 3, 5 반지름 : 7
중심 : 8, 8 반지름 : 4
```

**포인트**

- Point 를 CircleInner 의 { } 안으로 옮긴다. → 타입 이름은 CircleInner.Point
- 내부 클래스 객체는 외부 클래스 객체가 먼저 있어야 만들 수 있다.
  ```java
  CircleInner c1 = new CircleInner();
  CircleInner.Point p1 = c1.new Point();     ← 외부객체.new 내부클래스()
  ```

**📝 필기**

  - Point 클래스를 CircleInner 클래스의 내부 클래스로 정의
  - 내부 클래스의 객체는 '외부객체.new 내부클래스()' 형태로 생성

- 📝 필기 (퀴즈 9번과 같은 문법) : A.B inner = outer.new B();

- 💡 Point 가 CircleInner 안에 있으므로 CircleInner 에서는 center.x 처럼 Point 의 private 필드에 직접 접근할 수도 있다.<br>(7-5 MyRectangleInnerPoint.java 와 같은 구조) 여기서는 ❶ 과 똑같이 getter 를 썼다.
- 💡 문제의 main 클래스 이름은 CircleTest. ❶ 파일과 겹쳐서 CircleInnerPointTest 로 바꿨다.

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (Circle → CircleInner, 강의 코드에서는 바꾸기 전 이름)

## 2. 3x3 행렬의 합 · 차 · 전치 · 곱 (참고 답안)

`7강 실습` · 📄 [`MatrixTest.java`](MatrixTest.java)

#### 문제

> 3x3 행렬을 나타내는 Matrix 클래스를 만들어 아래 main 이 동작하도록 하시오.
>
> ```java
> Matrix m1 = new Matrix(), m2 = new Matrix();
> int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
> int[][] arr2 = {{-1, -2, -3}, {4, 5, 6}, {-7, -8, -9}};
> m1.setData(arr1);  m2.setData(arr2);
> Matrix m3 = m1.add(m2);       System.out.println("두 행렬의 합");    System.out.println(m3);
> m3 = m1.subtract(m2);         System.out.println("두 행렬의 차");    System.out.println(m3);
> m3 = m1.transpose();          System.out.println("m1 행렬의 전치");  System.out.println(m3);
> m3 = m1.multiply(m2);         System.out.println("두 행렬의 곱");    System.out.println(m3);
> ```

#### 💻 코드

<!-- code: MatrixTest.java -->
```java
public class MatrixTest {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(), m2 = new Matrix();
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{-1, -2, -3}, {4, 5, 6}, {-7, -8, -9}};
        m1.setData(arr1);
        m2.setData(arr2);

        Matrix m3 = m1.add(m2);
        System.out.println("두 행렬의 합");
        System.out.println(m3);

        m3 = m1.subtract(m2);
        System.out.println("두 행렬의 차");
        System.out.println(m3);

        m3 = m1.transpose();
        System.out.println("m1 행렬의 전치");
        System.out.println(m3);

        m3 = m1.multiply(m2);
        System.out.println("두 행렬의 곱");
        System.out.println(m3);
    }
}

class Matrix {
    private static final int N = 3;          // 3x3
    private int[][] data = new int[N][N];

    public int[][] getData() { return data; }

    public void setData(int[][] data) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.data[i][j] = data[i][j];      // 값 복사 (배열 공유 방지)
            }
        }
    }

    public Matrix add(Matrix other) {
        Matrix result = new Matrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        Matrix result = new Matrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.data[i][j] = this.data[j][i];     // 행 ↔ 열
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        Matrix result = new Matrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(String.format("%4d", data[i][j]));    // 4칸 오른쪽 정렬
            }
            if (i < N - 1) sb.append("\n");                      // 마지막 줄 뒤에는 줄바꿈 X (println 이 해줌)
        }
        return sb.toString();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
두 행렬의 합
   0   0   0
   8  10  12
   0   0   0
두 행렬의 차
   2   4   6
   0   0   0
  14  16  18
m1 행렬의 전치
   1   4   7
   2   5   8
   3   6   9
두 행렬의 곱
 -14 -16 -18
 -26 -31 -36
 -38 -46 -54
```

#### 📒 해설

- 💡 직접 풀지 않은 문제라서 참고 답안으로 작성했다.

**포인트**

- add / subtract / transpose / multiply 는 모두 "새 Matrix 객체" 를 만들어 결과를 담아 돌려준다.<br>(실습 클래스1 3번 Complex 의 add / sub 와 같은 방식) → m1, m2 는 바뀌지 않는다.
- System.out.println(m3) 처럼 객체를 바로 출력하므로 toString() 을 오버라이딩해야 한다.<br>(오버라이딩하지 않으면 Matrix@1b6d3586 같은 "클래스이름@해시코드" 가 출력된다)
- 같은 클래스이므로 다른 객체(other)의 private 필드 other.data 에 직접 접근할 수 있다.<br>(실습 클래스1 3번 📝 필기 : private 은 클래스 기준)

- 전치 (transpose) : 행과 열을 바꾼다.  result\[i]\[j] = data\[j]\[i]
  ```text
  1 2 3        1 4 7
  4 5 6   →    2 5 8
  7 8 9        3 6 9
  ```
- 곱 (multiply) : result\[i]\[j] = Σ(k=0..2) data\[i]\[k] \* other\[k]\[j]   (i 행 · j 열 내적)<br>예) result\[0]\[0] = 1\*(-1) + 2\*4 + 3\*(-7) = -1 + 8 - 21 = -14

- 💡 setData 에서 배열을 그대로 대입(this.data = data)하면 main 의 arr1 과 같은 배열을 공유하게 된다.<br>(7-4 배열 인수 : 레퍼런스가 전달됨) 그러면 main 에서 arr1 을 바꿀 때 m1 도 같이 바뀐다.<br>그래서 값을 하나씩 복사해서 저장했다.
- 💡 String 을 반복해서 + 하는 대신 StringBuilder 로 문자열을 만들었다. (6주차 6-3)

## 3. 영화관 좌석 예약: 실행 클래스 + 좌석 관리 클래스

`7강 실습` · 📄 [`TheaterTest.java`](TheaterTest.java)

#### 문제

> 10행 8열 영화관의 좌석 예약 프로그램을 작성하시오.
>
>   0. 예약 현황 표시  (■ 예약됨 / □ 빈 좌석)
>   1. 예약 하기
>   2. 예약 취소
>   3. 종료
> - TheaterTest   : 메뉴 표시, 입력, 메시지 출력 (실행 흐름)
> - TheaterSeats  : 좌석 배열 관리 (setSize, printSeats, reserve, cancel, isValid)

#### 💻 코드

<!-- code: TheaterTest.java -->
```java
import java.util.Scanner;

public class TheaterTest {
    static TheaterSeats seats = new TheaterSeats();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;
        seats.setSize(10, 8);              // 10행 8열

        do {
            displayMenu();
            menu = selectMenu();

            switch (menu) {
                case 0:
                    displaySeats();
                    break;
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelSeat();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
            }
        } while (menu != 3);

        sc.close();
    }

    static void displayMenu() {
        System.out.println("\n===== 영화관 예약 시스템 =====");
        System.out.println("0. 예약 현황 표시");
        System.out.println("1. 예약 하기");
        System.out.println("2. 예약 취소");
        System.out.println("3. 종료");
        System.out.println("==============================");
    }

    static int selectMenu() {
        System.out.print("메뉴를 선택하세요: ");
        return sc.nextInt();
    }

    static void displaySeats() {
        seats.printSeats();
    }

    static void reserveSeat() {
        System.out.print("예약할 행 번호를 입력하세요 (1~10): ");
        int r = sc.nextInt() - 1;                       // 1~10 → 인덱스 0~9
        System.out.print("예약할 열 번호를 입력하세요 (1~8): ");
        int c = sc.nextInt() - 1;

        if (seats.reserve(r, c)) {                       // boolean 반환값을 if 에서 사용
            System.out.println("정상적으로 예약되었습니다.");
        } else {
            System.out.println("이미 예약된 좌석이거나 잘못된 번호입니다.");
        }
    }

    static void cancelSeat() {
        System.out.print("취소할 행 번호를 입력하세요 (1~10): ");
        int r = sc.nextInt() - 1;
        System.out.print("취소할 열 번호를 입력하세요 (1~8): ");
        int c = sc.nextInt() - 1;

        if (seats.cancel(r, c)) {
            System.out.println("예약이 정상적으로 취소되었습니다.");
        } else {
            System.out.println("예약되지 않은 좌석이거나 잘못된 번호입니다.");
        }
    }
}

class TheaterSeats {
    private boolean[][] seats;              // false : 빈 좌석, true : 예약됨 (기본값 false)

    // 기본 생성자 public TheaterSeats() { } 는 컴파일러가 자동으로 넣어 준다

    public void setSize(int rows, int cols) {
        seats = new boolean[rows][cols];
    }

    public void printSeats() {
        System.out.println("\n[ 좌석 예약 현황 ]");
        for (int i = 0; i < seats.length; i++) {             // 바깥 for : 행
            for (int j = 0; j < seats[i].length; j++) {      // 안쪽 for : 열
                System.out.print((seats[i][j] ? "■" : "□") + " ");
            }
            System.out.println();                            // 한 행이 끝나면 줄바꿈
        }
    }

    public boolean reserve(int row, int col) {
        if (isValid(row, col) && !seats[row][col]) {         // 범위 안 && 아직 예약 안 됨
            seats[row][col] = true;
            return true;
        }
        return false;
    }

    public boolean cancel(int row, int col) {
        if (isValid(row, col) && seats[row][col]) {          // 범위 안 && 예약되어 있음
            seats[row][col] = false;
            return true;
        }
        return false;
    }

    private boolean isValid(int row, int col) {              // 내부에서만 쓰는 도우미 메서드
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }
}
```
<!-- /code -->

**포인트**

- 사용자는 1\~10 / 1\~8 로 입력하지만 배열 인덱스는 0부터 → 입력값 - 1
- reserve / cancel 은 성공 여부를 boolean 으로 돌려주고, 메시지는 TheaterTest 가 출력한다.
- isValid 를 먼저 검사하므로(&& 단축 평가) 범위 밖 번호를 넣어도 ArrayIndexOutOfBoundsException 이 나지 않는다.

- 📝 필기 : 영화관 좌석 예약 프로그램 개념 정리 — 3번·4번 코드 기준<br>(1\~5 는 이 파일, 6\~10 은 TheaterSeatsSystem.java 에 이어서 정리)

1. 클래스와 객체
  - TheaterSeats  : 좌석을 관리하는 설계도 (좌석 배열 + 예약/취소 기능)
  - TheaterTest   : 프로그램의 실행 흐름 (메뉴 → 입력 → 처리)

```text
TheaterSeats   seats   =   new TheaterSeats();
───────────    ─────       ──────────────────
 타입(클래스)   참조 변수     객체 생성
```

  - seats 는 배열이 아니라 TheaterSeats 객체를 가리키는 "참조 변수" 이다.<br>실제 boolean 배열은 그 객체 안의 seats 필드에 들어 있다.
    ```text
    TheaterTest.seats ──▶ [ TheaterSeats 객체 : seats ● ] ──▶ boolean[10][8]
    ```
  - 객체마다 데이터가 따로 있다.
    ```java
    TheaterSeats a = new TheaterSeats();  a.setSize(10, 8);
    TheaterSeats b = new TheaterSeats();  b.setSize(5, 5);
    ```<br>→ a 와 b 의 좌석 배열은 서로 영향을 주지 않는다. (상영관이 두 개인 것과 같다)

2. 필드와 메서드
  - 필드 : private boolean\[]\[] seats;   (객체가 가지는 데이터)
  - 메서드 : 객체가 하는 일
    ```text
    | 메서드      | 반환형  | 하는 일                              |
    ```<br>|-------------|---------|--------------------------------------|
    ```text
    | setSize     | void    | 좌석 배열 생성                       |
    | printSeats  | void    | 좌석 현황 출력                       |
    | reserve     | boolean | 예약 성공 true / 실패 false          |
    | cancel      | boolean | 취소 성공 true / 실패 false          |
    | isValid     | boolean | 번호가 범위 안이면 true              |
    ```
  - void vs boolean
    ```java
    void    : 일만 하고 돌려주는 값이 없다.
    boolean : 결과(성공/실패)를 돌려준다. → 호출한 쪽에서 if 로 사용
        if (seats.reserve(r, c)) System.out.println("정상적으로 예약되었습니다.");
        else                     System.out.println("이미 예약된 좌석이거나 잘못된 번호입니다.");
    ```<br>→ 좌석 관리(로직) 클래스는 "결과" 만 알려주고, "어떻게 보여줄지(출력)" 는 실행 클래스가 정한다.<br>로직과 화면 출력이 분리된다.

3. private vs public
  - seats 배열은 private → 클래스 밖에서 직접 건드릴 수 없다.
    ```java
    seats.reserve(0, 0);         // ✅ 가능 : public 메서드를 통해 예약
    seats.seats[0][0] = true;    // ❌ 불가 : private 필드에 직접 접근 (컴파일 에러)
    ```
  - 이것이 캡슐화(encapsulation).<br>반드시 reserve / cancel 을 거치게 해서 "중복 예약 검사", "범위 검사" 를 건너뛰지 못하게 보호한다.
  - isValid 는 private → 클래스 내부에서만 쓰는 도우미(helper) 메서드. 밖에서 부를 필요가 없다.

4. static<br>4-1. TheaterTest 의 static 필드
  ```java
  static TheaterSeats seats = new TheaterSeats();
  static Scanner sc = new Scanner(System.in);
  ```<br>→ 객체 없이 클래스에 하나만 존재하고, main · reserveSeat · cancelSeat 등 모든 static 메서드가 같이 쓴다.<br>sc 는 프로그램 전체가 공유하는 입력 도구.

4-2. main 은 왜 static 인가?

    - JVM 이 프로그램을 시작할 때 객체를 만들지 않고 TheaterTest.main() 을 바로 호출하기 때문.
    - 규칙
        - ① static 메서드는 객체 없이 인스턴스 멤버(필드/메서드)를 사용할 수 없다.
        - ② 인스턴스 메서드는 객체를 통해 호출한다.  (객체.메서드())
        - ③ static 메서드는 static 메서드를 바로 호출할 수 있다.
    - 3번 코드 : displayMenu, selectMenu, reserveSeat ... 가 모두 static → main 에서 바로 호출 (규칙 ③)
    - 4번 코드 : main 에서 system 객체를 먼저 만든 뒤 system.displayMenu() 처럼 호출 (규칙 ②)<br>→ static 메서드에서도 "객체를 통해서라면" non-static 메서드를 호출할 수 있다.

4-3. 설계 구조<br>\[ TheaterTest ]  (static : 실행 흐름)

```text
├─ static Scanner sc
├─ static TheaterSeats seats ─────▶ [ TheaterSeats 객체 ]
├─ main()                              ├─ private boolean[][] seats
├─ displayMenu() / selectMenu()        ├─ setSize() / printSeats()
└─ displaySeats() / reserveSeat()      ├─ reserve() / cancel()
   / cancelSeat()                      └─ private isValid()
```

5. new 와 생성자
  - 생성자 : new 로 객체를 만들 때 자동으로 실행되는 특별한 메서드. 클래스 이름과 같고 반환형이 없다.
    ```java
    class Example {
        int number;
        Example() { number = 10; }      // 생성자
    }
    Example ex = new Example();          // 생성자 실행 → ex.number 는 10
    ```
  - TheaterSeats 에는 생성자를 쓰지 않았으므로 컴파일러가 기본 생성자를 자동으로 넣어 준다.
    ```java
    public TheaterSeats() { }
    ```
  - 이 프로그램에서 new 는 두 번 쓰인다.
    ```text
    new TheaterSeats()             → 좌석 관리 객체 생성
    new boolean[rows][cols]        → setSize 안에서 좌석 배열 생성
    ```

(6\~10 : TheaterSeatsSystem.java 에 계속)

- 💡 문제에 정답 코드가 함께 주어졌고, 메뉴 문구와 메시지는 그대로 옮겼다.
- 💡 숫자가 아닌 값을 입력하면 nextInt() 에서 InputMismatchException 이 난다. (예외 처리는 뒤에서 배움)

실행 예 (입력 : 1 / 1 1 / 1 / 1 1 / 0 / 2 / 3 3 / 3)<br>===== 영화관 예약 시스템 =====

0. 예약 현황 표시
1. 예약 하기
2. 예약 취소
3. 종료

메뉴를 선택하세요: 1<br>예약할 행 번호를 입력하세요 (1\~10): 1<br>예약할 열 번호를 입력하세요 (1\~8): 1<br>정상적으로 예약되었습니다.

```text
...
메뉴를 선택하세요: 1     (같은 좌석 1, 1 을 다시 예약)
```

이미 예약된 좌석이거나 잘못된 번호입니다.

```text
...
```

메뉴를 선택하세요: 0

\[ 좌석 예약 현황 ]<br>■ □ □ □ □ □ □ □<br>□ □ □ □ □ □ □ □<br>... (10줄)

```text
...
메뉴를 선택하세요: 2     (예약하지 않은 3, 3 취소)
```

예약되지 않은 좌석이거나 잘못된 번호입니다.

```text
...
```

메뉴를 선택하세요: 3<br>프로그램을 종료합니다.

## 4. 영화관 좌석 예약: 하나의 클래스로 통합

`7강 실습` · 📄 [`TheaterSeatsSystem.java`](TheaterSeatsSystem.java)

#### 문제

> 3번 프로그램을 TheaterSeatsSystem 클래스 하나로 다시 작성하시오.<br>좌석 배열, Scanner, 메뉴, 예약/취소를 모두 이 클래스의 인스턴스 멤버로 만든다.

#### 💻 코드

<!-- code: TheaterSeatsSystem.java -->
```java
import java.util.Scanner;

public class TheaterSeatsSystem {
    private boolean[][] seats;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TheaterSeatsSystem system = new TheaterSeatsSystem();   // static main → 객체를 먼저 만든다
        system.setSize(10, 8);
        int menu;

        do {
            system.displayMenu();
            menu = system.selectMenu();

            switch (menu) {
                case 0:
                    system.displaySeats();
                    break;
                case 1:
                    system.reserveSeat();
                    break;
                case 2:
                    system.cancelSeat();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
            }
        } while (menu != 3);

        system.sc.close();
    }

    public void setSize(int rows, int cols) {
        seats = new boolean[rows][cols];
    }

    public void displayMenu() {
        System.out.println("\n===== 영화관 예약 시스템 =====");
        System.out.println("0. 예약 현황 표시");
        System.out.println("1. 예약 하기");
        System.out.println("2. 예약 취소");
        System.out.println("3. 종료");
        System.out.println("==============================");
    }

    public int selectMenu() {
        System.out.print("메뉴를 선택하세요: ");
        return sc.nextInt();
    }

    public void displaySeats() {
        System.out.println("\n[ 좌석 예약 현황 ]");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print((seats[i][j] ? "■" : "□") + " ");
            }
            System.out.println();
        }
    }

    public void reserveSeat() {
        System.out.print("예약할 행 번호를 입력하세요 (1~10): ");
        int r = sc.nextInt() - 1;
        System.out.print("예약할 열 번호를 입력하세요 (1~8): ");
        int c = sc.nextInt() - 1;

        if (isValid(r, c) && !seats[r][c]) {
            seats[r][c] = true;
            System.out.println("정상적으로 예약되었습니다.");
        } else {
            System.out.println("이미 예약된 좌석이거나 잘못된 번호입니다.");
        }
    }

    public void cancelSeat() {
        System.out.print("취소할 행 번호를 입력하세요 (1~10): ");
        int r = sc.nextInt() - 1;
        System.out.print("취소할 열 번호를 입력하세요 (1~8): ");
        int c = sc.nextInt() - 1;

        if (isValid(r, c) && seats[r][c]) {
            seats[r][c] = false;
            System.out.println("예약이 정상적으로 취소되었습니다.");
        } else {
            System.out.println("예약되지 않은 좌석이거나 잘못된 번호입니다.");
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }
}
```
<!-- /code -->

**포인트**

- main 은 static 이므로 먼저 객체를 만들고, 그 객체를 통해 인스턴스 메서드를 호출한다.
  ```java
  TheaterSeatsSystem system = new TheaterSeatsSystem();
  system.setSize(10, 8);
  ``` system.displayMenu();  ...
- 3번과 달리 reserveSeat / cancelSeat 가 입력 · 검사 · 메시지 출력을 모두 직접 한다.
- system.sc.close() : private 필드지만 main 이 같은 클래스 안에 있으므로 접근 가능

- 📝 필기 : 영화관 좌석 예약 프로그램 개념 정리 — 3번·4번 코드 기준 (이어서)<br>(1\~5 : TheaterTest.java)

6. 2차원 배열과 boolean<br>6-1. 선언과 생성
  ```java
  private boolean[][] seats;
  seats = new boolean[rows][cols];      // 10행 8열
  seats.length     → 행의 개수 (10)
  ```<br>seats\[0].length  → 열의 개수 (8)<br>6-2. boolean 배열의 기본값은 false<br>false : 예약되지 않음 (빈 좌석)<br>true  : 예약됨<br>→ 따로 초기화하지 않아도 처음에는 모든 좌석이 빈 좌석이다.<br>6-3. 삼항 연산자
  ```java
  System.out.print((seats[i][j] ? "■" : "□") + " ");
  ```<br>는 아래 if-else 와 같다.
  ```java
  if (seats[i][j]) System.out.print("■ ");     // 예약됨
  else             System.out.print("□ ");     // 빈 좌석
  ```<br>6-4. 중첩 for 문
  ```java
  for (int i = 0; i < seats.length; i++) {          // 바깥 : 행
      for (int j = 0; j < seats[i].length; j++) {   // 안쪽 : 열
          ... 한 칸 출력
      }
      System.out.println();                         // 한 행이 끝나면 줄바꿈
  }
  ```

7. this / 매개변수 / 반환값
  - setSize(int rows, int cols) 의 rows, cols 는 매개변수 : 호출할 때 넘겨준 값(10, 8)을 받는다.
  - reserve(int row, int col) → boolean 반환값으로 성공 여부를 돌려준다.
  - this 는 매개변수 이름과 필드 이름이 같을 때 필요하다.
    ```java
    class Example {
        int number;
        void setNumber(int number) {
            this.number = number;     // this.number : 필드,  number : 매개변수
        }
    }
    ```<br>이 프로그램은 필드(seats)와 매개변수(rows, cols) 이름이 겹치지 않아서 this 없이 써도 된다.

8. 조건문과 논리 연산자<br>8-1. && (AND) : 둘 다 true 여야 true
  ```java
  if (isValid(row, col) && !seats[row][col])
  | isValid (범위 안) | !seats (예약 안 됨) | 결과          |
  ```<br>|-------------------|---------------------|---------------|
  ```text
  | true              | true                | 예약 가능     |
  | true              | false               | 이미 예약됨   |
  | false             | (검사 안 함)        | 잘못된 번호   |
  ```<br>8-2. || (OR) : 하나라도 true 이면 true → "범위 밖" 검사에 쓸 수 있다.
  ```java
  if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
      // 범위를 벗어남
  }
  ```<br>isValid 는 이것을 뒤집은 것 (>= 0 && &lt; length ...)<br>8-3. 단축 평가 (short-circuit evaluation)
    - && 는 왼쪽이 false 이면 오른쪽을 아예 계산하지 않는다.
    - 그래서 isValid 가 먼저 와야 한다. 범위 밖이면 seats\[row]\[col] 에 접근하지 않으므로 ArrayIndexOutOfBoundsException 이 나지 않는다.
      ```text
      !seats[row][col] && isValid(row, col)    // ❌ 순서가 반대면 범위 밖 번호에서 예외 발생
      ```

9. do-while / switch / break
  - do-while : 메뉴를 "최소 한 번" 보여 줘야 하므로 먼저 실행하고 나중에 조건 검사
  - switch   : menu 값에 따라 0 / 1 / 2 / 3 / default 로 분기
  - break    : switch 를 빠져나간다. (반복문을 빠져나가는 것이 아님!)<br>→ 반복 종료는 while (menu != 3) 조건이 담당한다. 3 을 고르면 조건이 false 가 되어 끝난다.

10. 3번 vs 4번 설계 비교
  - 3번 : 역할을 나눴다. TheaterSeats 는 좌석 관리만, TheaterTest 는 메뉴 · 입력 · 출력만.<br>→ 좌석 규칙을 바꿀 때는 TheaterSeats 만, 화면을 바꿀 때는 TheaterTest 만 고치면 된다. (유지보수 쉬움)
  - 4번 : 하나의 클래스에 모두 통합. 작은 프로그램에서는 간단하고 파일 하나로 끝난다.<br>→ 하지만 기능이 늘어나면 클래스가 비대해지므로 UI(메뉴/입력)와 관리(좌석) 를 분리하는 것이 좋다.

```text
| 항목             | 3번                                   | 4번                                  |
```

|------------------|---------------------------------------|--------------------------------------|

```text
| 클래스 구성      | TheaterTest + TheaterSeats (2개)      | TheaterSeatsSystem (1개)             |
| 좌석 배열 관리   | TheaterSeats 의 인스턴스 필드 seats   | TheaterSeatsSystem 의 인스턴스 필드  |
| 메뉴와 입력 처리 | TheaterTest 의 static 메서드          | TheaterSeatsSystem 의 인스턴스 메서드|
| 예약 / 취소      | reserve, cancel 이 boolean 반환       | reserveSeat, cancelSeat 가 직접 출력 |
| 객체 생성        | static TheaterSeats seats = new ...   | main 에서 new TheaterSeatsSystem()   |
| 실행 클래스      | TheaterTest                           | TheaterSeatsSystem                   |
```

  - ★ 시험 포인트
    - ① main 에서 왜 객체를 만들어야 하는가?   → main 은 static 이라 객체 없이 인스턴스 멤버를 쓸 수 없기 때문
    - ② seats 는 왜 인스턴스 필드인가?          → 객체(상영관)마다 좌석 데이터가 독립적이어야 하기 때문
    - ③ 3번과 4번의 구조는 왜 다른가?           → 역할 분리(유지보수) vs 통합(간단함)

- 💡 실행 결과는 3번(TheaterTest.java)과 같다.

---

[🏠 7주차 학습 가이드](../../README.md)
