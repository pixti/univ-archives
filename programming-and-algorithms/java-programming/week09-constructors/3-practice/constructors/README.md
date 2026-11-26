# 9주차 실습 · constructors

[🏠 9주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [PlaneTest.java](#1-plane-생성자-4개-생성자-체이닝-this-기법) | 1. Plane: 생성자 4개 (📝 생성자 체이닝 `this()` 기법) |
| [BoxTest.java](#2-box-부피가-가장-큰-상자-참고-답안-실수-오차-반올림) | 2. 💡 Box: 부피가 가장 큰 상자 (참고 답안, 실수 오차 반올림) |
| [MovieTest.java](#3-movie-평점이-가장-좋은-영화-참고-답안) | 3. 💡 Movie: 평점이 가장 좋은 영화 (참고 답안) |
| [NationTest.java](#4-nation-인구--국민소득이-가장-큰-나라) | 4. 💡 Nation: 인구 · 국민소득이 가장 큰 나라 (참고 답안. ⚠ C++식 지수 표기) |
| [MatrixTest.java](#5-matrix-생성자로-크기-지정-합--차--전치--곱-tostring) | 5. Matrix: 생성자로 크기 지정, 합 · 차 · 전치 · 곱, `toString` (📝 깊은 복사, 곱셈 조건) |

---

## 1. Plane: 생성자 4개 (생성자 체이닝 `this()` 기법)

`9강 실습` · 📄 [`PlaneTest.java`](PlaneTest.java)

#### 문제 (요약)

> 비행기의 식별 번호(id), 모델(model), 승객 수(passenger)를 필드로 가지는 Plane 클래스를 작성하시오.
>
> - 생성자를 중복 정의해 Plane(), Plane(id), Plane(id, model), Plane(id, model, passenger) 로 만들 수 있게 한다.
> - 필드는 private, getter / setter 를 둔다.
> - main 에서 p1 \~ p4 를 만들고 setter 로 값을 바꾼 뒤 출력한다.

#### 💻 코드

<!-- code: PlaneTest.java -->
```java
public class PlaneTest {
    public static void main(String[] args) {
        Plane p1 = new Plane();
        Plane p2 = new Plane(1);
        Plane p3 = new Plane(2, "B-747");
        Plane p4 = new Plane(3, "A-330", 80);

        p1.setModel("A-380");
        p1.setPassenger(60);
        p2.setModel("B-787");
        p2.setPassenger(120);
        p3.setPassenger(140);

        p1.print();
        p2.print();
        p3.print();
        p4.print();
    }
}

class Plane {
    private int id;
    private String model;
    private int passenger;

    // 생성자 체이닝 : 모두 마지막 생성자로 모인다
    public Plane() {
        this(0, null, 0);
    }

    public Plane(int id) {
        this(id, null, 0);
    }

    public Plane(int id, String model) {
        this(id, model, 0);
    }

    public Plane(int id, String model, int passenger) {   // ← 실제 초기화는 여기서만
        this.id = id;
        this.model = model;
        this.passenger = passenger;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getPassenger() { return passenger; }
    public void setPassenger(int passenger) { this.passenger = passenger; }

    public void print() {
        System.out.println("식별 번호 : " + id);
        System.out.println("모    델 : " + model);
        System.out.println("승 객 수 : " + passenger);
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
식별 번호 : 0
모    델 : A-380
승 객 수 : 60

식별 번호 : 1
모    델 : B-787
승 객 수 : 120

식별 번호 : 2
모    델 : B-747
승 객 수 : 140

식별 번호 : 3
모    델 : A-330
승 객 수 : 80
```

**포인트**

- 생성자 오버로딩 + this(...) 로 다른 생성자 호출

- 📝 필기 : 생성자 체이닝 this() 기법.<br>매개변수가 가장 많은 생성자 Plane(int, String, int) 하나에만 실제 대입 코드를 두고, 나머지 생성자는 this(...) 로 "빈 값"(0, null)을 채워 그 생성자를 호출한다.
  ```text
  Plane()                → this(0, null, 0)
  Plane(1)               → this(1, null, 0)
  Plane(2, "B-747")      → this(2, "B-747", 0)
  ``` Plane(3, "A-330", 80)  → 실제 초기화<br>→ 초기화 코드가 한 곳에 모여 중복이 없고, 고칠 때도 한 곳만 고치면 된다.

- 💡 this(...) 는 생성자의 첫 문장이어야 한다(수업 기준). (퀴즈 1번 📝 필기)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 PlaneTest 로 이름을 바꿨다.

## 2. Box: 부피가 가장 큰 상자 (참고 답안, 실수 오차 반올림)

`9강 실습` · 📄 [`BoxTest.java`](BoxTest.java)

#### 문제 (요약)

> 높이(height), 너비(width), 길이(length)와 상자가 비었는지(empty)를 필드로 가지는 Box 클래스를 작성하시오.
>
> - 생성자를 중복 정의한다. (모든 값을 받는 생성자 / 매개변수 없는 생성자)
> - 부피를 구하는 getVolume() 메소드를 둔다.
> - 주어진 main 의 나머지 부분을 완성해 세 상자의 부피와 가장 큰 상자를 출력한다.
>
> ```java
> double vb1, vb2, vb3;
> Box b1 = new Box(3.5, 4.4, 5.0, false);
> Box b2 = new Box();
> Box b3 = new Box();
> b3.setHeight(4.0);
> b3.setLength(5.0);
> b3.setWidth(2.4);
> // main 나머지 부분 완성
> ```

#### 💻 코드

<!-- code: BoxTest.java -->
```java
public class BoxTest {
    public static void main(String[] args) {
        double vb1, vb2, vb3;
        Box b1 = new Box(3.5, 4.4, 5.0, false);
        Box b2 = new Box();
        Box b3 = new Box();
        b3.setHeight(4.0);
        b3.setLength(5.0);
        b3.setWidth(2.4);

        // ----- main 나머지 부분 완성 -----
        b2.setHeight(5.0);
        b2.setWidth(6.0);
        b2.setLength(7.0);
        b2.setEmpty(false);

        vb1 = b1.getVolume();
        vb2 = b2.getVolume();
        vb3 = b3.getVolume();

        System.out.println("======================");
        System.out.println("박스 1 부피는 : " + Math.round(vb1));
        System.out.println("박스 2 부피는 : " + Math.round(vb2));
        System.out.println("박스 3 부피는 : " + Math.round(vb3));
        System.out.println("======================");

        // 가장 큰 부피 찾기
        int maxNo = 1;
        double max = vb1;
        if (vb2 > max) { max = vb2; maxNo = 2; }
        if (vb3 > max) { max = vb3; maxNo = 3; }
        System.out.println("박스" + maxNo + "의 부피가 가장 큽니다 : " + Math.round(max));
    }
}

class Box {
    private double height;
    private double width;
    private double length;
    private boolean empty;

    public Box() {
        this(0.0, 0.0, 0.0, true);   // 크기 0 의 빈 상자
    }

    public Box(double height, double width, double length, boolean empty) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.empty = empty;
    }

    public double getVolume() {
        return height * width * length;
    }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public boolean isEmpty() { return empty; }          // 💡 boolean getter 는 is~ (7강 CellPhone)
    public void setEmpty(boolean empty) { this.empty = empty; }
}
```
<!-- /code -->

#### 실행 결과

```text
======================
박스 1 부피는 : 77
박스 2 부피는 : 210
박스 3 부피는 : 48
======================
박스2의 부피가 가장 큽니다 : 210
```

#### 📒 해설

- 💡 직접 풀지 않은 문제라 참고 답안으로 채웠다.
- 💡 실행 결과에 "박스 2 부피는 : 210" 이 나오므로 b2 에 5 x 6 x 7 = 210 을 넣었다. (문제에 값이 없음)
- 💡 부피를 그대로 출력하면 3.5 \* 4.4 \* 5.0 = 77.00000000000001 처럼 실수 오차가 보인다.<br>실행 결과처럼 정수로 보이도록 Math.round() 로 반올림해서 출력했다.<br>((int) 로 자르면 47.99999... 같은 값이 47 이 될 수 있어서 반올림이 안전하다.)
- 💡 Box() 는 this(0, 0, 0, true) 로 "크기 0 의 빈 상자"를 만든다. (생성자 체이닝)

## 3. Movie: 평점이 가장 좋은 영화 (참고 답안)

`9강 실습` · 📄 [`MovieTest.java`](MovieTest.java)

#### 문제 (요약)

> 영화 제목(name), 감독(director), 평점(point)을 필드로 가지는 Movie 클래스를 작성하시오.
>
> - 생성자를 중복 정의한다. (모든 값을 받는 생성자 / 매개변수 없는 생성자)
> - 주어진 main 으로 세 영화를 출력하고, 평점이 가장 좋은 영화의 제목을 출력한다.
>
> ```java
> Movie m1 = new Movie("아저씨", "이정범", 9.28);
> Movie m2 = new Movie("슈퍼배드", "피에르 꼬팽", 8.96);
> Movie m3 = new Movie();
> m3.setName("무적자");
> m3.setDirector("송해성");
> m3.setPoint(6.08);
> ```

#### 💻 코드

<!-- code: MovieTest.java -->
```java
public class MovieTest {
    public static void main(String[] args) {
        Movie m1 = new Movie("아저씨", "이정범", 9.28);
        Movie m2 = new Movie("슈퍼배드", "피에르 꼬팽", 8.96);
        Movie m3 = new Movie();
        m3.setName("무적자");
        m3.setDirector("송해성");
        m3.setPoint(6.08);

        System.out.println("========================");
        m1.print();
        m2.print();
        m3.print();

        Movie best = best(m1, m2, m3);
        System.out.println("가장 평점이 좋은 영화 : " + best.getName());
    }

    static Movie best(Movie a, Movie b, Movie c) {
        Movie best = a;
        if (b.getPoint() > best.getPoint()) best = b;
        if (c.getPoint() > best.getPoint()) best = c;
        return best;
    }
}

class Movie {
    private String name;
    private String director;
    private double point;

    public Movie() {
        this("", "", 0.0);
    }

    public Movie(String name, String director, double point) {
        this.name = name;
        this.director = director;
        this.point = point;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public double getPoint() { return point; }
    public void setPoint(double point) { this.point = point; }

    public void print() {
        System.out.println("영화제목 : " + name);
        System.out.println("감    독 : " + director);
        System.out.println("평    점 : " + point);
        System.out.println("========================");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
========================
영화제목 : 아저씨
감    독 : 이정범
평    점 : 9.28
========================
영화제목 : 슈퍼배드
감    독 : 피에르 꼬팽
평    점 : 8.96
========================
영화제목 : 무적자
감    독 : 송해성
평    점 : 6.08
========================
가장 평점이 좋은 영화 : 아저씨
```

#### 📒 해설

- 💡 직접 풀지 않은 문제라 참고 답안으로 채웠다.
- 💡 "가장 좋은 영화" 를 구하는 메소드를 static 으로 두고 Movie 객체 세 개를 받게 했다.<br>객체(레퍼런스)를 그대로 돌려주므로 제목뿐 아니라 감독 · 평점도 꺼낼 수 있다.

## 4. Nation: 인구 · 국민소득이 가장 큰 나라

`9강 실습` · 📄 [`NationTest.java`](NationTest.java)

#### 문제 (요약)

> 국가 이름(country), 인구(population, 만 명), 넓이(area, ㎢), 국민 소득(income, $)을 필드로 가지는 Nation 클래스를 작성하시오.
>
> - 생성자를 중복 정의한다. (모든 값을 받는 생성자 / 매개변수 없는 생성자)
> - 주어진 main 으로 세 나라를 출력하고, 인구가 가장 많은 국가와 국민소득이 가장 높은 국가를 출력한다.
>
> ```java
> Nation n1 = new Nation("대한민국", 4977, 100032, 17074);
> Nation n2 = new Nation("일본", 12728, 377835, 39731);
> Nation n3 = new Nation();
> n3.setCountry("중국");
> n3.setPopulation(133004);
> n3.setArea(9596960);
> n3.setIncome(3677);
> ```

#### 💻 코드

<!-- code: NationTest.java -->
```java
public class NationTest {
    public static void main(String[] args) {
        Nation n1 = new Nation("대한민국", 4977, 100032, 17074);
        Nation n2 = new Nation("일본", 12728, 377835, 39731);
        Nation n3 = new Nation();
        n3.setCountry("중국");
        n3.setPopulation(133004);
        n3.setArea(9596960);
        n3.setIncome(3677);

        Nation[] nations = { n1, n2, n3 };   // 💡 객체 배열로 묶으면 반복문으로 비교하기 편하다

        System.out.println("==========================");
        for (Nation n : nations) {
            n.print();
        }

        Nation maxPop = nations[0];
        Nation maxIncome = nations[0];
        for (Nation n : nations) {
            if (n.getPopulation() > maxPop.getPopulation()) maxPop = n;
            if (n.getIncome() > maxIncome.getIncome()) maxIncome = n;
        }
        System.out.println("가장 인구가 많은 국가 : " + maxPop.getCountry());
        System.out.println("가장 국민소득이 높은 국가 : " + maxIncome.getCountry());
    }
}

class Nation {
    private String country;
    private int population;   // 만 명
    private int area;         // ㎢
    private int income;       // $

    public Nation() {
        this("", 0, 0, 0);
    }

    public Nation(String country, int population, int area, int income) {
        this.country = country;
        this.population = population;
        this.area = area;
        this.income = income;
    }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }
    public int getArea() { return area; }
    public void setArea(int area) { this.area = area; }
    public int getIncome() { return income; }
    public void setIncome(int income) { this.income = income; }

    public void print() {
        System.out.println("국가 이름 : " + country);
        System.out.println("인    구 : " + population + "만명");
        System.out.println("넓    이 : " + area + "㎢");
        System.out.println("국민 소득 : " + income + "$");
        System.out.println("==========================");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
==========================
국가 이름 : 대한민국
인    구 : 4977만명
넓    이 : 100032㎢
국민 소득 : 17074$
==========================
국가 이름 : 일본
인    구 : 12728만명
넓    이 : 377835㎢
국민 소득 : 39731$
==========================
국가 이름 : 중국
인    구 : 133004만명
넓    이 : 9596960㎢
국민 소득 : 3677$
==========================
가장 인구가 많은 국가 : 중국
가장 국민소득이 높은 국가 : 일본
```

#### 📒 해설

- 💡 직접 풀지 않은 문제라 참고 답안으로 채웠다.
- ⚠ 문제의 실행 결과에는 중국의 넓이가 9.59696e+006 으로 나온다. C++ 의 cout 이 큰 실수를 지수 표기로 출력한 것이다(원래 C++ 용 문제). 자바에서 int 로 저장하면 9596960 그대로 나온다.<br>(double 로 저장하면 자바도 9596960.0 으로 출력. 지수 표기는 1.0E7 이상부터)

## 5. Matrix: 생성자로 크기 지정, 합 · 차 · 전치 · 곱, `toString`

`9강 실습` · 📄 [`MatrixTest.java`](MatrixTest.java)

#### 문제 (요약)

> 2차원 배열 data 와 행 수(rows), 열 수(cols)를 필드로 가지는 Matrix 클래스를 작성하시오.
>
> - Matrix(int rows, int cols, int initVal) : rows x cols 크기를 만들고 모든 칸을 initVal 로 채운다.
> - Matrix(int\[]\[] arr)                     : 2차원 배열을 받아 같은 내용의 행렬을 만든다.
> - add, subtract, transpose, multiply 메소드와 getRows, getCols, getAt(i, j) 를 둔다.
> - 행렬을 출력할 수 있도록 toString() 을 재정의한다.

#### 💻 코드

<!-- code: MatrixTest.java -->
```java
public class MatrixTest {
    public static void main(String[] args) {
        Matrix m0 = new Matrix(3, 2, 0);
        int[][] arr1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
        int[][] arr2 = { { -1, -2, -3 }, { 4, 5, 6 } };
        Matrix m1 = new Matrix(arr1);
        Matrix m2 = new Matrix(arr2);

        Matrix m3 = m0.add(m1);
        System.out.println("두 행렬의 합 : " + m3.getRows() + "x" + m3.getCols());
        System.out.println(m3);      // 재정의된 toString()이 자동으로 호출되어 행렬 형태 출력

        Matrix m4 = m0.subtract(m1);
        System.out.println("두 행렬의 차: ");
        System.out.println(m4);

        Matrix m5 = m0.transpose();  // 3x2 → 2x3
        System.out.println("m0 행렬의 전치: ");
        System.out.println(m5);

        Matrix m6 = m1.multiply(m2); // (3x2) x (2x3) = 3x3
        System.out.println("두 행렬의 곱: ");
        // toString()을 사용하지 않고 직접 getAt() 메서드를 이용해 원소를 하나씩 가져와 출력
        for (int i = 0; i < m6.getRows(); i++) {
            for (int j = 0; j < m6.getCols(); j++) {
                System.out.print(m6.getAt(i, j) + " ");
            }
            System.out.println();
        }

        // 💡 깊은 복사 확인
        arr1[0][0] = 99;
        System.out.println("💡 arr1[0][0] = 99 로 바꾼 뒤 m1.getAt(0, 0) = " + m1.getAt(0, 0));
    }
}

class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols, int initVal) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];        // 지정된 크기만큼 2차원 배열 할당
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = initVal;      // 모든 칸을 initVal로 채움
            }
        }
    }

    public Matrix(int[][] arr) {
        this.rows = arr.length;
        this.cols = arr[0].length;
        this.data = new int[rows][cols];
        // 외부에서 전달된 배열(arr)의 값이 나중에 바뀌더라도 Matrix 내부의 데이터는
        // 안전하게 유지되도록 값을 하나씩 복사(깊은 복사)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = arr[i][j];
            }
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    // 특정 위치(i행, j열)의 값을 반환
    public int getAt(int i, int j) {
        return data[i][j];
    }

    public Matrix add(Matrix other) {
        Matrix result = new Matrix(rows, cols, 0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];   // 💡 private 이지만 같은 클래스라 접근 가능
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        Matrix result = new Matrix(rows, cols, 0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows, 0);   // 행과 열의 크기가 뒤바뀜
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }

    // 행렬의 곱셈: 앞 행렬의 열 개수와 뒤 행렬의 행 개수가 같을 때 수행 가능
    public Matrix multiply(Matrix other) {
        // 결과 행렬의 크기는 (앞 행렬의 행 개수) x (뒤 행렬의 열 개수)
        Matrix result = new Matrix(this.rows, other.cols, 0);   // 결과를 담을 새 행렬
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;   // 계산된 새 행렬 객체를 반환
    }

    // 객체를 System.out.println()으로 출력할 때 어떤 문자열 형태로 보여줄지 정의
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
두 행렬의 합 : 3x2
1 2
4 5
7 8

두 행렬의 차:
-1 -2
-4 -5
-7 -8

m0 행렬의 전치:
0 0 0
0 0 0

두 행렬의 곱:
7 8 9
16 17 18
25 26 27
💡 arr1[0][0] = 99 로 바꾼 뒤 m1.getAt(0, 0) = 1
```

**포인트**

- 7강 실습 클래스(2) 2번(3-practice/classes2/MatrixTest.java, 3x3 고정)을 생성자로 크기를 정할 수 있게 확장한 문제.
- 생성자 오버로딩 : (크기 + 초기값) / (배열) 두 가지 방법으로 행렬을 만든다.
- 연산 결과는 원래 행렬을 바꾸지 않고 "새 Matrix 객체"를 만들어 돌려준다. (9-1 LocalDateTime 의 불변 객체와 같은 방식)

**📝 필기 (코드 주석 정리)**

- Matrix(int\[]\[] arr) : 외부에서 전달된 배열(arr)의 값이 나중에 바뀌더라도 Matrix 내부의 데이터는 안전하게 유지되도록 값을 하나씩 복사(깊은 복사)한다.
- 행렬의 곱셈 : 앞 행렬의 열 개수와 뒤 행렬의 행 개수가 같을 때 수행 가능.<br>결과 행렬의 크기는 (앞 행렬의 행 개수) x (뒤 행렬의 열 개수).
- toString() : 객체를 System.out.println() 으로 출력할 때 어떤 문자열 형태로 보여줄지 정의.
- println(m3) : 재정의된 toString() 이 자동으로 호출되어 행렬 형태로 출력.
- 곱셈 결과는 toString() 을 사용하지 않고 직접 getAt() 메서드를 이용해 원소를 하나씩 가져와 출력.

**💡 깊은 복사 vs 얕은 복사**

```java
this.data = arr;                 // 얕은 복사 : 같은 배열을 가리킴 → 밖에서 arr[0][0] = 99 하면 행렬도 바뀜
this.data[i][j] = arr[i][j];     // 깊은 복사 : 새 배열에 값만 복사 → 행렬은 안전
```

main 마지막의 💡 부분에서 arr1 을 바꿔도 m1 이 그대로인 것을 확인했다.

- 💡 add / subtract 는 두 행렬의 크기가, multiply 는 this.cols == other.rows 가 맞아야 한다.<br>문제에서는 검사하지 않았지만 크기가 다르면 ArrayIndexOutOfBoundsException 이 날 수 있다.
- 💡 원래 이클립스에서 TestMain 클래스로 작성한 코드. MatrixTest 로 이름을 바꿨다.

---

[🏠 9주차 학습 가이드](../../README.md)
