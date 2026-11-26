# 11주차 실습 · inheritance3

[🏠 11주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [ShapeInterfaceTest.java](#1-shape-인터페이스와-rectangle--circle--triangle) | 1. `Shape` 인터페이스와 `Rectangle` · `Circle` · `Triangle` (📝 일반 · 추상 클래스 · 인터페이스 비교) |
| [SearchableTest.java](#2-searchable-인터페이스와-document--webpage-contains) | 2. `Searchable` 인터페이스와 `Document` · `WebPage` (📝 `contains()`) |
| [TestPerson.java](#3-person-has-a-job-컴포지션) | 3. `Person` has-a `Job` 컴포지션 (📝 객체 생성 메커니즘, 상속 vs 포함의 메모리 구조) |
| [MultipleInheritanceABC.java](#4-a-b를-모두-상속받는-c-다중-상속불가--컴포지션--인터페이스--컴포지션) | 4. `A`, `B`를 모두 상속받는 `C`: 다중 상속(불가) / 컴포지션 / 인터페이스 + 컴포지션 (📝 다이아몬드 문제) |

---

## 1. `Shape` 인터페이스와 `Rectangle` · `Circle` · `Triangle`

`11강 실습` · 📄 [`ShapeInterfaceTest.java`](ShapeInterfaceTest.java)

#### 문제

> getArea() 메소드를 갖는 Shape 인터페이스를 작성하라. Shape 인터페이스를 구현하는 세 가지 클래스 Rectangle, Circle 및 Triangle 도 작성하라. 세 클래스 각각에 대해 getArea() 메서드를 구현토록 한다. main 은 다음과 같다.
>
> ```java
> // Main
> public class Main {
>     public static void main(String[] args) {
>         // Create a Rectangle object with length=10 and width=12
>         Rectangle rectangle = new Rectangle(10, 12);
>         // Create a Circle object with radius=3
>         Circle circle = new Circle(3);
>         // Create a Triangle object with base=4 and height=6
>         Triangle triangle = new Triangle(4, 6);
>         // Print the area of the Rectangle
>         System.out.println("Area of the Rectangle: " + rectangle.getArea());
>         // Print the area of the Circle
>         System.out.println("Area of the Circle: " + circle.getArea());
>         // Print the area of the Triangle
>         System.out.println("Area of the Triangle: " + triangle.getArea());
>     }
> }
> ```

#### 💻 코드

<!-- code: ShapeInterfaceTest.java -->
```java
public class ShapeInterfaceTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 12);
        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(4, 6);

        System.out.println("Area of the Rectangle: " + rectangle.getArea());
        System.out.println("Area of the Circle: " + circle.getArea());
        System.out.println("Area of the Triangle: " + triangle.getArea());

        System.out.println("---- Shape[] ----");
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(10, 12);
        shapes[1] = new Circle(3);
        shapes[2] = new Triangle(4, 6);
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getArea());   // 동적 바인딩
        }
    }
}

interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Area of the Rectangle: 120.0
Area of the Circle: 28.274333882308138
Area of the Triangle: 12.0
---- Shape[] ----
120.0
28.274333882308138
12.0
```

#### 📒 해설

- 📝 필기 : 1. 클래스와 인터페이스의 구조적 분류 - 자바에서 타입을 정의하는 구조는 구현의 완성도와 목적에 따라 일반 클래스, 추상 클래스, 인터페이스로 구분된다.
1) 일반 클래스 (Concrete Class)
    - 정의 : 상태를 나타내는 필드(멤버 변수), 객체를 초기화하는 생성자, 동작을 정의하는 메소드가 모두 구체적으로 구현된 클래스다.
    - 특징 : 모든 메소드가 실행 블록({ })을 가지고 있다. new 연산자를 사용하여 메모리에 직접 인스턴스(객체)를 생성할 수 있다.
    - 문제 내 예시 : Rectangle, Circle, Triangle, Main 클래스가 이에 해당한다.
2) 추상 클래스 (Abstract Class)
    - 정의 : 클래스 선언부에 abstract 키워드가 붙은 클래스다. 내부에 구현부가 없는 "추상 메소드" 를 하나 이상 포함할 수 있다.
    - 특징 : 일반 클래스처럼 일반 필드, 일반 메소드, 생성자를 모두 가질 수 있다.<br>구현이 완료되지 않은 메소드가 존재할 수 있으므로, new 연산자를 통한 직접적인 인스턴스 생성이 불가능하다.<br>하위 클래스에서 extends 키워드로 상속받은 후, 추상 메소드를 모두 구현해야만 인스턴스를 생성할 수 있다.
    - 목적 : 서로 관련된 클래스들의 공통적인 필드와 메소드를 추출하여 코드의 중복을 줄이고, 하위 클래스마다 다르게 동작해야 하는 부분만 추상 메소드로 남겨 구현을 강제할 때 사용한다.
3) 인터페이스 (Interface)
    - 정의 : interface 키워드로 선언하며, 클래스가 구현해야 하는 동작의 명세(Specification)만을 정의한 구조다.
    - 특징 : 일반적인 인스턴스 필드를 가질 수 없으며, 선언되는 모든 변수는 자동으로 public static final(상수)로 처리된다.<br>선언되는 모든 메소드는 기본적으로 실행 블록이 없는 public abstract(추상 메소드)로 처리된다.<br>(단, Java 8 부터는 구현부를 가진 default 메소드와 static 메소드의 선언도 허용된다)<br>생성자를 가질 수 없으며, 직접 인스턴스를 생성할 수 없다.<br>클래스에서 implements 키워드를 사용해 인터페이스를 구현하며, 인터페이스에 정의된 모든 추상 메소드를 반드시 구현해야 한다.
    - 목적 : 상속 관계에 얽매이지 않고, 서로 다른 클래스들이 동일한 메소드 형태(시그니처)를 가지도록 강제하여 사용 방법을 표준화할 때 사용한다.
    - 문제 내 예시 : Shape 인터페이스는 이를 구현하는 모든 도형 클래스가 double getArea() 라는 메소드를 반드시 작성하도록 강제하는 역할을 한다.

- 📝 필기 : 2. 세 가지 구조의 기술적 비교
  ```text
  구분               일반 클래스                   추상 클래스                       인터페이스
  선언 키워드        class                         abstract class                    interface
  인스턴스 생성      가능                          불가능                            불가능
  생성자 유무        있음                          있음 (하위 클래스에서 호출용)      없음
  포함 가능한 변수   모든 변수 (인스턴스/정적/상수) 모든 변수 (인스턴스/정적/상수)    상수만 가능 (public static final)
  포함 가능한 메소드 구현된 일반 메소드            일반 메소드 + 추상 메소드          추상 메소드 (+ default, static 메소드)
  하위 연결 키워드   extends (상속)                extends (상속)                    implements (구현)
  다중 적용 여부     단일 상속만 가능              단일 상속만 가능                  다중 구현 가능
  주된 사용 목적     객체 생성 및 기능 수행        공통 기능 상속 및 부분적 구현 강제 기능의 명세 제공 및 동작의 표준화
  ```

- 📝 필기 : 3. 클래스 간 관계 및 구현 관련 개념
1) 추상 메소드 (Abstract Method)
    - 정의 : 메소드의 선언부(접근 제어자, 반환 타입, 메소드 이름, 매개변수 목록)만 있고, 실제 동작을 정의하는 구현부({ })가 없는 메소드다.
    - 역할 : 하위 클래스나 구현 클래스가 작성해야 할 메소드의 규격(시그니처)을 정의한다. 문제의 double getArea(); 는 매개변수 없이 호출되어 double 타입의 값을 반환해야 한다는 규칙을 의미한다.
2) 상속 (extends) 과 구현 (implements)
    - 상속 (extends) : 상위 클래스(일반 또는 추상 클래스)의 필드와 메소드를 하위 클래스가 물려받는 것이다.<br>기존의 코드를 재사용하고 계층 구조를 형성하는 데 목적이 있다. 자바는 여러 부모 클래스로부터 동시에 상속받는 "다중 상속" 을 허용하지 않는데, 이는 두 부모 클래스에 동일한 이름의 메소드가 있을 때 어떤 것을 실행해야 할지 모호해지는 문제(다이아몬드 문제)를 방지하기 위함이다.
    - 구현 (implements) : 인터페이스에 정의된 추상 메소드의 몸통을 클래스에서 작성하는 것이다. 인터페이스는 구현된 내용이 없으므로 여러 인터페이스를 동시에 구현하더라도 충돌 문제가 발생하지 않는다. 따라서 하나의 클래스가 여러 개의 인터페이스를 다중 구현하는 것이 가능하다.
3) 메소드 오버라이딩 (Method Overriding)
    - 정의 : 상위 클래스나 인터페이스에 정의된 메소드를 하위 클래스에서 다시 정의하는 것이다.
    - 조건 : 오버라이딩을 할 때는 메소드의 이름, 매개변수의 타입과 개수, 반환 타입이 상위 구조에 정의된 것과 완전히 일치해야 한다. 접근 제어자는 상위 메소드보다 좁은 범위로 변경할 수 없다.<br>(인터페이스의 메소드는 기본 public 이므로 구현 클래스에서도 반드시 public 으로 선언해야 한다)
    - @Override 어노테이션 : 해당 메소드가 상위 클래스나 인터페이스의 메소드를 재정의한 것임을 컴파일러에게 알리는 역할을 한다.<br>만약 메소드 이름에 오타가 있거나 매개변수가 다르면 컴파일 에러를 발생시켜 개발자의 실수를 방지한다.

- 📝 필기 : 4. 인터페이스 사용의 기술적 목적 - 각 도형 클래스에 개별적으로 getArea() 를 만들지 않고 굳이 Shape 인터페이스를 거쳐서 만드는 이유는 표준화와 다형성(Polymorphism) 때문이다.
1) 다형성 (Polymorphism) 과 동적 바인딩<br>다형성이란 하나의 참조 변수 타입으로 여러 종류의 하위 객체를 참조할 수 있는 성질을 말한다. 인터페이스 역시 타입으로 사용할 수 있으므로, Shape 타입의 변수에 이를 구현한 Rectangle, Circle, Triangle 객체를 할당할 수 있다.
  ```java
  // 인터페이스 타입의 배열에 서로 다른 도형 객체를 저장
  Shape[] shapes = new Shape[3];
  shapes[0] = new Rectangle(10, 12);
  shapes[1] = new Circle(3);
  shapes[2] = new Triangle(4, 6);
  for (int i = 0; i < shapes.length; i++) {
      // 컴파일 시점에는 Shape 의 getArea() 를 호출하지만,
      // 실행 시점(Runtime)에는 실제 담긴 객체(Rectangle, Circle 등)의 오버라이딩된 메소드가 실행됨
      System.out.println(shapes[i].getArea());
  }
  ``` 위 코드처럼 상위 타입(Shape)으로 메소드를 호출하더라도, 프로그램 실행 시점에는 실제 메모리에 생성된 객체의 오버라이딩된 메소드가 찾아가서 실행된다. 이를 동적 바인딩(Dynamic Binding)이라고 한다.
2) 결합도 감소 및 유지보수성 향상<br>인터페이스를 사용하면 기능을 사용하는 쪽(Main 클래스)에서는 구체적인 도형 클래스의 내부 구조를 몰라도 Shape 인터페이스의 getArea() 라는 규격만 알면 코드를 작성할 수 있다. 추후 새로운 도형 클래스(예 : Pentagon)가 추가되더라도, Shape 인터페이스를 구현하기만 하면 기존의 출력 코드를 수정하지 않고 그대로 재사용할 수 있다.

- 📝 필기 : 5. 문제에 사용된 기타 객체지향 개념
1) 생성자 (Constructor)
    - 객체가 생성될 때(new 키워드 사용 시) 호출되는 특수한 목적의 메소드다. 주로 객체의 필드(멤버 변수)를 초기화하는 데 사용된다.
    - 클래스의 이름과 동일해야 하며, 반환 타입(Return Type) 자체가 존재하지 않는다(void 도 적지 않음).
    - 문제에서 new Rectangle(10, 12) 가 실행될 때, Rectangle 클래스 내부의 public Rectangle(double length, double width)<br>생성자가 호출되어 전달받은 값을 내부 필드에 저장한다.
2) 캡슐화 (Encapsulation) 와 정보 은닉
    - 객체의 데이터(필드)와 그 데이터를 처리하는 동작(메소드)을 하나로 묶고, 외부에서 데이터에 직접 접근하는 것을 제한하는 기법이다.
    - 코드에서 각 도형의 속성 변수(length, width, radius 등) 앞에 private 접근 제어자를 선언한 것이 이에 해당한다.
    - private 으로 선언된 변수는 해당 클래스 외부에서 직접 읽거나 수정할 수 없으며, 생성자나 public 으로 공개된 메소드를 통해서만 간접적으로 다룰 수 있다. 이는 외부의 잘못된 조작으로 인해 객체의 데이터가 손상되는 것을 막아 무결성을 유지하기 위함이다.
3) this 참조 변수
    - 인스턴스 자기 자신을 가리키는 참조 변수다.
    - 생성자나 메소드의 매개변수 이름과 클래스의 필드 이름이 동일할 때(예 : 매개변수 length 와 필드 length), 해당 블록 내부에서는 매개변수가 우선시된다. 이때 클래스의 필드임을 명확히 지정하기 위해 this.length = length; 와 같이 사용한다.

- 💡 new Rectangle(10, 12) 처럼 int 를 넘겨도 생성자의 매개변수가 double 이라 10.0, 12.0 으로 자동 형변환된다. 그래서 120.0 이 출력된다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 ShapeInterfaceTest 로 이름을 바꿨다.<br>아래 "---- Shape\[] ----" 부분은 📝 필기 4절의 다형성 코드를 확인용으로 덧붙인 것이다.

## 2. `Searchable` 인터페이스와 `Document` · `WebPage` (`contains()`)

`11강 실습` · 📄 [`SearchableTest.java`](SearchableTest.java)

#### 문제

> 텍스트 문서에서 주어진 키워드를 검색하는 search(문자열 키워드) 메소드를 갖는 Searchable 인터페이스를 작성하라.<br>Searchable 인터페이스를 구현하고 search() 메서드의 자체 구현을 제공하는 두 개의 클래스 Document 및 WebPage 를 작성하라.<br>main 은 다음과 같다.
>
> ```java
> // Main
> public class Main {
>     public static void main(String[] args) {
>         Document document = new Document("This is a sample document.");
>         boolean documentContainsKeyword = document.search("sample");
>         System.out.println("Document contains keyword 'sample': " + documentContainsKeyword);
>
>         WebPage webPage = new WebPage("https://www.w3resource.com", "This is a sample webpage.");
>         boolean webPageContainsKeyword = webPage.search("webpage");
>
>         System.out.println("Webpage contains keyword 'webpage': " + webPageContainsKeyword);
>     }
> }
> ```

#### 💻 코드

<!-- code: SearchableTest.java -->
```java
public class SearchableTest {
    public static void main(String[] args) {
        Document document = new Document("This is a sample document.");
        boolean documentContainsKeyword = document.search("sample");
        System.out.println("Document contains keyword 'sample': " + documentContainsKeyword);

        WebPage webPage = new WebPage("https://www.w3resource.com", "This is a sample webpage.");
        boolean webPageContainsKeyword = webPage.search("webpage");
        System.out.println("Webpage contains keyword 'webpage': " + webPageContainsKeyword);
    }
}

interface Searchable {
    boolean search(String keyword);
}

class Document implements Searchable {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    @Override
    public boolean search(String keyword) {
        return content.contains(keyword);
    }
}

class WebPage implements Searchable {
    private String url;
    private String htmlContent;

    public WebPage(String url, String htmlContent) {
        this.url = url;
        this.htmlContent = htmlContent;
    }

    @Override
    public boolean search(String keyword) {
        return htmlContent.contains(keyword);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Document contains keyword 'sample': true
Webpage contains keyword 'webpage': true
```

#### 📒 해설

- 📝 필기 : 1. 문제 요구사항 및 Main 코드 분석 - 제시된 Main 클래스의 코드와 실행 결과를 통해 역추적할 수 있는 설계 조건
1. Searchable 인터페이스의 메소드 규격
    - boolean documentContainsKeyword = document.search("sample"); 코드를 보면, search 메소드는 검색할 단어인 문자열(String) 1개를 매개변수로 전달받는다.
    - 메소드의 실행 결과를 boolean 타입 변수에 저장하고, 출력 결과가 true 이므로 반환 타입은 boolean 이어야 한다.
    - 따라서 인터페이스에 선언할 추상 메소드의 형태는 boolean search(String keyword); 가 된다.
2. Document 클래스의 구조
    - new Document("This is a sample document.") 와 같이 생성자에 문자열 1개를 전달하고 있다.
    - 따라서 문서의 본문 내용을 저장할 String 타입의 멤버 변수 1개와, 이를 초기화하는 생성자가 필요하다.
3. WebPage 클래스의 구조
    - new WebPage("https://www.w3resource.com", "This is a sample webpage.") 와 같이 생성자에 문자열 2개를 전달하고 있다.
    - 첫 번째 인자는 웹사이트의 주소(URL)이고, 두 번째 인자는 웹페이지의 본문 내용이다. 따라서 String 타입의 멤버 변수 2개(url, htmlContent 등)와 이를 초기화하는 생성자가 필요하다.

- 📝 필기 : 2. 문제에 사용된 핵심 개념 설명
1) String 클래스의 contains() 메소드<br>자바에서 문자열을 다루는 String 클래스는 문자열 내부에 특정 단어(부분 문자열)가 포함되어 있는지 확인하는 내장 메소드를 제공한다.
    - 문법 : 대상문자열.contains("찾을문자열")
    - 동작 : 대상 문자열 안에 찾을 문자열이 존재하면 true 를 반환하고, 존재하지 않으면 false 를 반환한다. 대소문자를 구분한다.
    - 적용 : 본문 내용이 저장된 변수가 content 이고 검색어가 keyword 라면, content.contains(keyword) 를 호출하여 검색 결과를<br>즉시 boolean 값으로 얻을 수 있다.
    - (참고 : content.indexOf(keyword) != -1 방식을 사용할 수도 있다. indexOf 는 특정 문자열이 시작되는 위치 인덱스를 반환하며, 찾지 못하면 -1 을 반환하므로 동일한 결과를 얻을 수 있다)
2) 인터페이스 구현 클래스의 내부 구조 독립성<br>1번 문제와 마찬가지로, 인터페이스는 외부에서 호출할 메소드의 형태(boolean search(String keyword))만 강제할 뿐 클래스 내부의 멤버 변수나 생성자의 형태는 관여하지 않는다.
    - Document 는 변수가 1개이고, WebPage 는 변수가 2개이지만 둘 다 Searchable 인터페이스의 규격을 따르므로 외부(Main)에서는 동일한 방식(객체.search("키워드"))으로 검색 기능을 사용할 수 있다.
    - 만약 WebPage 의 검색 기능을 "본문뿐만 아니라 URL 주소에서도 키워드를 검색" 하도록 변경하고 싶다면, WebPage 내부의 search 메소드만 return htmlContent.contains(keyword) || url.contains(keyword); 형태로 수정하면 된다.<br>이처럼 인터페이스에 맞춰 각 클래스가 자신의 특성에 맞게 동작을 개별적으로 정의하는 것이 인터페이스를 통한 다형성의 핵심이다.

- 💡 이클립스는 url 필드에 "값을 쓰기만 하고 읽지 않는다" 는 노란 경고(The value of the field WebPage.url is not used)를 표시한다.<br>위 필기처럼 search 에서 url 도 검색하거나 getUrl() 을 만들면 사라진다. 실행에는 문제가 없다.
- ⚠ 자주 틀리는 부분 : contains 는 대소문자를 구분한다. search("Sample") 은 "This is a sample document." 에서 false 다.<br>대소문자 없이 찾으려면 content.toLowerCase().contains(keyword.toLowerCase()) 처럼 둘 다 소문자로 바꿔서 비교한다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 SearchableTest 로 이름을 바꿨다.

## 3. `Person` has-a `Job` 컴포지션

`11강 실습` · 📄 [`TestPerson.java`](TestPerson.java)

#### 문제

> Inheritance 는 object 사이에 is-a relationship 을 갖고 있을 때 사용되며, composition 은 has-a relationship 을 갖고 있을 때 사용한다. 둘 다 코드를 재사용하게 하는 기법이다. "Person 은 Job 을 갖는다" 라는 사실을 기초로 Person 과 Job 클래스를 정의하라.<br>단, Job 클래스는 role, salary, id 를 필드로 갖는다.
>
> ```java
> public class Job {
>     private String role;
>     private long salary;
>     private int id;
>     (각 필드의 getter / setter)
> }
> ```

#### 💻 코드

<!-- code: TestPerson.java -->
```java
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        long salary = person.getSalary();
        System.out.println("salary = " + salary);   // 💡 확인용
    }
}

class Job {
    private String role;
    private long salary;
    private int id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Person {
    // composition has-a relationship
    private Job job;

    public Person() {
        this.job = new Job();
        job.setSalary(1000L);
    }

    public long getSalary() {
        return job.getSalary();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
salary = 1000
```

**정답 코드**

```java
public class Person {
    //composition has-a relationship
    private Job job;

    public Person(){
        this.job=new Job();
        job.setSalary(1000L);
    }
    public long getSalary() {
        return job.getSalary();
    }
}
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        long salary = person.getSalary();
    }
}
```

- 📝 필기 : ★) is-a 관계 has-a 관계

- 📝 필기 : 1단계 - 자바의 기초 개념과 객체 생성 메커니즘<br>상속과 포함을 이해하려면 먼저 클래스가 무엇이고, 객체가 메모리에 어떻게 만들어지는지 정확히 알아야 한다.
  1) 클래스 (Class) 와 객체 (Object)
    - 클래스 : 관련 있는 변수(데이터)와 메소드(기능)를 하나로 묶어 놓은 "설계도" 이자 "새로운 자료형(타입)" 이다.<br>클래스 코드 자체는 하드디스크에 저장된 텍스트일 뿐, 프로그램이 실행될 때 실제 데이터를 저장하지 못한다.
    - 객체 (인스턴스) : 클래스라는 설계도를 바탕으로 실제 컴퓨터 메모리(RAM, 정확히는 Heap 영역)에 만들어진 실체다.
  2) 객체 생성 메커니즘 (Job j = new Job(); 의 작동 원리) - 이 한 줄을 적으면 컴퓨터 내부에서는 4단계의 일이 일어난다.
    ```java
    [코드]  Job j     =      new Job();
           (1단계) (4단계)  (2단계, 3단계)
    ```
    1. Job j (참조 변수 선언) : 메모리의 스택(Stack) 영역에 j 라는 이름의 작은 상자가 만들어진다. 이 상자에는 Job 객체 자체가 들어가는 것이 아니라, 앞으로 만들어질 Job 객체의 메모리 주소(위치 번호)만 들어갈 수 있다.
    2. new (메모리 공간 확보) : 메모리의 힙(Heap) 영역에 Job 클래스에 적힌 변수들(role, salary, id)이 들어갈 수 있는 실제 크기의 공간을 확보한다. 그리고 그 공간의 고유한 메모리 주소(예 : 0x100번지)가 정해진다.
    3. Job() (생성자 호출) : 방금 만든 힙 메모리 공간 안의 변수들을 초기값으로 세팅한다.
    4. = (주소 대입) : new 가 만든 실제 객체의 메모리 주소(0x100번지)를 변수 j 에 저장한다.<br>이제 변수 j 를 통해 실제 객체에 접근(j.setSalary(1000))할 수 있게 된다.
      ```text
      [Stack 메모리]        [Heap 메모리]
      ┌──────────┐          ┌─────────────────────┐
      │ j: 0x100 │ ───────▶ │ (0x100번지) Job 객체 │
      └──────────┘          │  - role: null       │
                            │  - salary: 0        │
                            │  - id: 0            │
                            └─────────────────────┘
      ```

이 구조가 자바의 가장 기본이 되는 객체 생성 메커니즘이다.

- 📝 필기 : 2단계 - 질문에 대한 핵심 답변 : "상속과 포함은 아예 다른 것인가?"<br>결론부터 말하면 목적만 같고, 개념과 구현 방식(문법, 메모리 구조)은 완전히 다르다.
  - 유일한 공통점 (목적) : A 라는 클래스를 만들 때, 이미 만들어져 있는 B 라는 클래스의 코드(변수와 메소드)를 처음부터 다시 짜지 않고 재사용하고 싶다는 목적은 같다.
  - 결정적 차이점 (방법)
    - 상속 (Inheritance) : B 클래스를 내 부모로 삼아서, A 와 B 를 하나의 몸체로 합쳐 버리는 방식이다. (extends 키워드 사용)
    - 포함 (Composition) : A 와 B 를 완전히 "남남(별개의 객체)" 으로 두되, A 클래스 안에서 B 객체를 new 로 생성하여 부품처럼 들고 쓰면서 기능을 빌려 쓰는 방식이다. (멤버 변수 선언 방식 사용)

- 📝 필기 : 3단계 - 상속 (Inheritance) 상세 분석
  1) 개념적 의미 (is-a 관계) : 기존의 추상적이거나 포괄적인 클래스에 살을 더 붙여서, 더 구체적인 새로운 클래스를 만들 때 사용한다.
    - 예 : Person(사람) 클래스에는 name(이름)만 있다. 여기에 school(학교명)을 추가하여 Student(학생) 클래스를 만들고 싶다.
    - 현실 세계에서 "학생은 일종의 사람이다 (Student is a Person)" 라는 문장이 논리적으로 맞다. 이때 상속을 쓴다.
  2) 코드 구현 방식 : extends 키워드를 사용하며, 부모의 변수나 메소드를 내 것처럼 아무런 거쳐감 없이 바로 사용한다.
    ```java
    class Person {
        String name;
        void eat() { System.out.println("밥을 먹는다"); }
    }
    // Person 을 상속받은 Student
    class Student extends Person {
        String school;   // 추가된 변수
        // 눈에 보이지 않지만 Person 의 name 변수와 eat() 메소드가 그대로 들어와 있음
    }
    ```
  3) 상속의 객체 생성 메커니즘 (메모리 구조) : Student s = new Student(); 를 실행하면 메모리에서는
    1. 자식 객체(Student)를 생성하라고 명령하면, 자바는 자동으로 부모(Person)의 생성자를 먼저 호출(super())한다.
    2. 그 결과, 힙 메모리에 부모인 Person 의 공간이 먼저 만들어지고, 그 바로 아래에 자식인 Student 의 공간이 붙어서 하나의 거대한 단일 객체로 만들어진다.
      ```text
      [Stack 메모리]        [Heap 메모리 : 하나의 덩어리로 합쳐짐]
      ┌──────────┐          ┌─────────────────────────────┐
      │ s: 0x200 │ ───────▶ │ (0x200번지) Student 객체     │
      └──────────┘          │  ┌──────────────────────┐   │
                            │  │ [부모 Person 영역]    │   │
                            │  │  - name              │   │
                            │  │  - eat()             │   │
                            │  └──────────────────────┘   │
                            │  - school (자식 영역)        │
                            └─────────────────────────────┘
      ```

하나의 몸체로 합쳐져 있기 때문에, 외부에서 s.name = "홍길동";, s.eat(); 처럼 부모의 기능을 내 것처럼 바로 호출할 수 있다.

- 📝 필기 : 4단계 - 포함 / 합성 (Composition) 상세 분석
  1) 개념적 의미 (has-a 관계) : 서로 종류가 완전히 다른 클래스의 기능이 필요할 때, 그 클래스를 내 부품이나 속성으로 소유하는 관계다.
    - 예 : Person(사람) 클래스에서 Job(직업) 클래스에 있는 salary(급여) 기능이 필요하다.
    - 현실 세계에서 "사람은 일종의 직업이다 (Person is a Job)" 라고 하면 말이 안 된다. "사람은 직업을 가지고 있다<br>(Person has a Job)" 가 맞다. 따라서 상속(extends)을 쓰면 안 되고 포함(Composition)을 써야 한다.
  2) 코드 구현 방식 : extends 를 쓰지 않는다. 대신 1단계에서 배웠던 객체 생성 메커니즘(Job job = new Job();)을 Person 클래스 내부에서 그대로 수행한다.
    ```java
    class Job {
        long salary;
        long getSalary() { return salary; }
    }
    class Person {
        // 1. Job 객체의 주소를 담을 참조 변수를 멤버(필드)로 선언
        private Job job;
        public Person() {
            // 2. Person 이 만들어질 때, Job 객체도 새로 만들어서 주소를 연결함
            this.job = new Job();
        }
        // 3. Job 의 기능을 쓰려면 반드시 참조 변수 "job." 을 거쳐서 호출해야 함
        public long getPersonSalary() {
            return this.job.getSalary();
        }
    }
    ```
  3) 포함의 객체 생성 메커니즘 (메모리 구조) : Person p = new Person(); 을 실행하면 메모리에서는 상속과 완전히 다르게 만들어진다.
    1. 힙 메모리에 Person 객체(0x300번지)가 만들어진다. 그 안에는 job 이라는 참조 변수가 들어 있다.
    2. Person 의 생성자가 실행되면서 new Job() 이 작동하여, 힙 메모리의 전혀 다른 위치(0x400번지)에 별개의 Job 객체가 만들어진다.
    3. Person 안의 job 변수에 0x400번지라는 주소값이 저장되어 두 객체가 선(참조)으로 연결된다.
      ```text
      [Stack 메모리]        [Heap 메모리 : 두 객체가 따로 만들어지고 주소로 연결됨]
      ┌──────────┐          ┌──────────────────────┐        ┌───────────────────────┐
      │ p: 0x300 │ ───────▶ │ (0x300) Person 객체   │        │ (0x400) Job 객체       │
      └──────────┘          │  ┌────────────────┐  │        │  - salary: 1000       │
                            │  │ job: 0x400  ───┼──┼──────▶ │  - getSalary()        │
                            │  └────────────────┘  │        └───────────────────────┘
                            └──────────────────────┘
      ```

이처럼 두 객체가 하나로 합쳐진 것이 아니라 독립된 두 개의 객체로 존재하기 때문에, Person 안에서 Job 의 기능을 쓰려면 내 것처럼 바로 부를 수 없고 반드시 this.job.getSalary() 처럼 변수 이름을 거쳐서 불러야 한다.

- 📝 필기 : 5단계 - 한눈에 보는 코드 및 구조 비교<br>만약 Person 이 Job 의 급여(getSalary) 기능을 재사용하려고 할 때, 상속으로 짰을 때(잘못된 설계)와 포함으로 짰을 때(올바른 설계)
  ```java
  비교 항목         상속 (is-a) 방식으로 작성 시                    포함 (has-a) 방식으로 작성 시
  클래스 선언       class Person extends Job                        class Person { private Job job; }
  객체 생성 수      new Person() 실행 시 1개의 통합된 객체 생성      new Person() 과 내부의 new Job() 으로 2개의 개별 객체 생성
  기능 사용법       부모 것이 곧 내 것이므로 바로 호출               남의 객체를 변수로 쥐고 있으므로 변수를 통해 호출
                    long s = getSalary();                           long s = this.job.getSalary();
  외부(Main) 호출   person.getSalary() 가 자동으로 노출됨           Person 이 허락(위임 메소드 작성)한 기능만 노출됨
  ```

- 📝 필기 : 6단계 - 추가 개념 : 상속과 포함에서 쓰이는 필수 키워드 (this vs super)
  1. this 와 this() (자기 자신)
    - 모든 클래스에서 사용한다.
    - this.변수명 : 현재 만들어져 있는 객체 자기 자신의 멤버 변수를 가리킨다.<br>(포함 관계에서 this.job = new Job(); 은 "내 객체 안에 있는 job 변수에 새로 만든 Job 객체 주소를 넣어라" 라는 뜻이다)
    - this() : 자기 자신의 다른 생성자를 호출할 때 쓴다.
  2. super 와 super() (부모 객체)
    - 오직 상속(extends) 관계에서만 사용한다.
    - super.변수명 / super.메소드명() : 자식 클래스 안에서 부모 클래스의 영역에 있는 변수나 메소드를 명시적으로 가리킬 때 쓴다.
    - super() : 자식 생성자 첫 줄에서 부모 클래스의 생성자를 호출할 때 쓴다. 개발자가 적지 않아도 컴파일러가 눈에 보이지 않게 자동으로 첫 줄에 끼워 넣는다. (이 때문에 3단계에서 설명했던 자식 객체를 만들면 부모 영역이 먼저 메모리에 만들어지는 것이다)

- 📝 필기 : 요약 정리
  1. 자바에서 클래스를 사용하려면 new 를 통해 메모리에 객체를 만들고 그 주소를 참조 변수에 담아야 한다.
  2. 다른 클래스의 코드를 재사용하는 방법에는 상속과 포함 두 가지가 있다.
  3. 상속(extends, is-a)은 두 클래스를 부모-자식으로 묶어 메모리상에서 하나의 몸체로 합치는 것이다. ("학생은 사람이다")
  4. 포함(has-a)은 클래스 안에 다른 클래스 타입의 참조 변수를 선언하고, 내부에서 new 로 별도의 객체를 생성해 연결(소유)하여 기능을 빌려 쓰는 것이다. ("사람은 직업을 가진다")

- 💡 문제의 정답 코드는 main 에서 salary 를 받기만 하고 출력하지 않는다. 확인용으로 출력문을 덧붙였다.
- 💡 1000L 의 L 은 long 리터럴 표시다. (2강) setSalary(long) 에 1000 을 넣어도 자동 형변환되지만, long 임을 분명히 하려고 붙였다.
- 💡 원래는 Job.java, Person.java, TestPerson.java 처럼 public class 마다 파일을 나눈다. 한 파일에 넣으려고 Job, Person 의 public 을 뺐다.

## 4. `A`, `B`를 모두 상속받는 `C`: 다중 상속(불가) / 컴포지션 / 인터페이스 + 컴포지션

`11강 실습` · 📄 [`MultipleInheritanceABC.java`](MultipleInheritanceABC.java)

#### 문제

> 다음과 같이 클래스 A, B 가 주어졌을 때 이 둘 모두를 상속받는 C 클래스를 정의하라.
>
> - (1) 다중 상속을 이용한 구현을 하시오.
> - (2) composition 을 이용하여 구현하라.
> - (3) 인터페이스와 composition 을 이용하여 구현하라.
>
> ```java
> public class A {
>     private int x, y;
>     public void f1() {System.out.print("f1 in A");}
>     public void f2() {System.out.print("f2 in A");}
>     public void c() {System.out.print("c in A");}
> }
> public class B {
>     private int w, q;
>     public void g1() {System.out.print("g1 in B");}
>     public void g2() {System.out.print("g2 in B");}
>     public void c() {System.out.print("c in B");}
> }
> public class Main {
>     public static void main(String[] args) {
>         C ob = new C();
>         ob.f1(); ob.f2(); ob.c();
>         ob.g1(); ob.g2(); ob.c();
>         ob.h1();
>     }
> }
> ```

#### 💻 코드

<!-- code: MultipleInheritanceABC.java -->
```java
public class MultipleInheritanceABC {

    interface IA {
        void f1();
        void f2();
        void c();
    }

    interface IB {
        void g1();
        void g2();
        void c();
    }

    static class A implements IA {
        private int x, y;
        public void f1() { System.out.print("f1 in A"); }
        public void f2() { System.out.print("f2 in A"); }
        public void c() { System.out.print("c in A"); }
    }

    static class B implements IB {
        private int w, q;
        public void g1() { System.out.print("g1 in B"); }
        public void g2() { System.out.print("g2 in B"); }
        public void c() { System.out.print("c in B"); }
    }

    // (1) static class C extends A, B { ... }   // ❌ 컴파일 에러 : 클래스는 하나만 extends 할 수 있다

    // (2-1) A, B 모두 Composition 사용
    static class CComposition {
        private A a = new A();
        private B b = new B();

        public void f1() { a.f1(); }
        public void f2() { a.f2(); }

        public void g1() { b.g1(); }
        public void g2() { b.g2(); }

        public void c() { a.c(); }

        public void h1() { System.out.print("h1 in C"); }
    }

    // (2-2) 하나는 상속(extends A)받고, 다른 하나만 Composition(B)으로 구현
    static class CExtendsA extends A {
        private B b = new B();

        public void g1() { b.g1(); }
        public void g2() { b.g2(); }

        public void h1() { System.out.print("h1 in C"); }
    }

    // (3-1) IA, IB 인터페이스 다중 구현 + Composition
    static class CInterfaces implements IA, IB {
        private A a = new A();
        private B b = new B();

        public void f1() { a.f1(); }
        public void f2() { a.f2(); }

        public void g1() { b.g1(); }
        public void g2() { b.g2(); }

        public void c() { a.c(); }

        public void h1() { System.out.print("h1 in C"); }
    }

    // (3-2) A 는 그대로 상속(extends A)받고, B 만 인터페이스(implements IB)와 Composition 으로 구현
    static class CExtendsAImplementsIB extends A implements IB {
        private B b = new B();

        public void g1() { b.g1(); }
        public void g2() { b.g2(); }

        public void h1() { System.out.print("h1 in C"); }
    }

    public static void main(String[] args) {
        System.out.print("(2-1) ");
        CComposition ob1 = new CComposition();
        ob1.f1(); ob1.f2(); ob1.c();
        ob1.g1(); ob1.g2(); ob1.c();
        ob1.h1();
        System.out.println();

        System.out.print("(2-2) ");
        CExtendsA ob2 = new CExtendsA();
        ob2.f1(); ob2.f2(); ob2.c();
        ob2.g1(); ob2.g2(); ob2.c();
        ob2.h1();
        System.out.println();

        System.out.print("(3-1) ");
        CInterfaces ob3 = new CInterfaces();
        ob3.f1(); ob3.f2(); ob3.c();
        ob3.g1(); ob3.g2(); ob3.c();
        ob3.h1();
        System.out.println();

        System.out.print("(3-2) ");
        CExtendsAImplementsIB ob4 = new CExtendsAImplementsIB();
        ob4.f1(); ob4.f2(); ob4.c();
        ob4.g1(); ob4.g2(); ob4.c();
        ob4.h1();
        System.out.println();

        IA ia = new CInterfaces();          // 💡 (3) 은 IA 타입으로도 쓸 수 있다 (다형성)
        System.out.print("IA ob = new CInterfaces() → ");
        ia.f1();
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
(2-1) f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C
(2-2) f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C
(3-1) f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C
(3-2) f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C
IA ob = new CInterfaces() → f1 in A
```

#### 📒 해설

- 📝 필기 : ★) Java 에서는 클래스의 다중 상속이 불가능하다. has-a 관계로 변경하거나 인터페이스의 다중 상속이 가능함을 이용한다.

- 📝 필기 (정답) : (1) 자바에서는 "extends A, B" 와 같이 두 개 이상의 클래스를 동시에 상속받는 다중 상속을 문법적으로 금지한다.<br>특히 클래스 A 와 B 모두 동일한 시그니처의 "public void c()" 메소드를 가지고 있기 때문에, 다중 상속이 허용될 경우 C 객체에서 c() 를 호출할 때 어느 부모의 c() 를 실행해야 할지 알 수 없는 모호성(Diamond Problem)이 발생하기 때문이다.

- 📝 필기 : 1. 핵심 개념 정리 - IS-A (상속) vs HAS-A (포함). 클래스들이 서로 관계를 맺고 기존 코드를 재사용하는 방법에는 크게 두 가지가 있다.

**① 상속 (Inheritance) - IS-A 관계 ("\~은 \~이다")**

    - 개념 : 부모 클래스의 변수와 메소드를 자식 클래스가 그대로 물려받는 것이다. 자바에서는 extends 키워드를 쓴다.
    - 비유 : 강아지(자식) is a 동물(부모). (강아지는 동물이다.)
    - 특징 : 부모의 기능을 내 것처럼 바로 쓸 수 있다. 다형성(Polymorphism)이 성립한다. 즉, 동물 ob = new 강아지(); 처럼 부모 타입으로 자식 객체를 다룰 수 있다.
    - 단점 (자바의 제약) : 자바에서는 클래스의 다중 상속을 금지한다. (부모 클래스를 동시에 2개 이상 둘 수 없음)
  - ② 포함 / 구성 (Composition) - HAS-A 관계 ("\~은 \~을 가지고 있다")
    - 개념 : 다른 클래스를 상속받는 대신, 내 클래스 안에 멤버 변수(부품)로 선언해서 가져다 쓰는 것이다.
    - 비유 : 자동차 has a 엔진. (자동차는 엔진이다(X) → 자동차는 엔진을 부품으로 가지고 있다(O))
    - 특징 : 내 클래스 안에 다른 클래스의 객체를 생성(new)해 두고, 필요한 기능이 있을 때 그 객체의 메소드를 대신 호출해 준다.<br>(이를 위임, Delegation 이라고 한다)<br>개수 제한 없이 여러 클래스를 부품처럼 가져다 쓸 수 있으므로 다중 상속의 대안으로 쓰인다.

- 📝 필기 : 2. 출제 의도 파악 - 왜 A 와 B 둘 다 c() 메소드를 가지고 있을까?<br>문제의 코드를 보면 A 클래스에도 public void c() 가 있고, B 클래스에도 똑같은 이름의 public void c() 가 있다.<br>만약 C 클래스가 A 와 B 를 동시에 상속받은 뒤, Main 에서 ob.c() 를 호출하면 컴퓨터는 A 의 c() 를 실행해야 할까, B 의 c() 를 실행해야 할까? 컴퓨터 입장에서는 도저히 알 수가 없다. 이를 객체지향에서 다이아몬드 문제(Diamond Problem, 다중 상속의 모호성)라고 부른다.<br>이 문제의 (1), (2), (3) 번은 "자바에서 다중 상속이 왜 안 되는지 이해하고(1번), 이를 Composition(2번)과 인터페이스(3번)로 어떻게 해결하는가?" 를 단계별로 질문하고 있다.

- 📝 필기 : 3. 문제 단계별 풀이 및 코드
  - (1) 다중 상속을 이용하여 구현하시오.<br>결론부터 말하면, 자바(Java)에서는 문법적으로 불가능하다(컴파일 에러). 이 문제는 "가상으로 작성해 보고 왜 에러가 나는지 설명하라" 는 의도다.
    ```java
    // [문법 에러가 발생하는 코드]
    public class C extends A, B {   // 에러! 자바는 클래스를 2개 이상 extends 할 수 없음
        public void h1() {
            System.out.print("h1 in C");
        }
    }
    ```
    - 답안 작성 팁 : 위 코드를 적은 후, "자바는 다중 상속을 지원하지 않으므로 컴파일 에러가 발생한다. 특히 A 와 B 에 동일한 시그니처의 c() 메소드가 존재하여 어떤 부모의 메소드를 호출할지 모호해지기(Diamond Problem) 때문이다." 라고 덧붙이면 된다.
    - 실제로 이클립스에서 실행하면 C extends A, B 줄에 빨간 줄이 생기고, 실행하면 다음과 같이 나온다.
      ```text
      Exception in thread "main" java.lang.Error: Unresolved compilation problems:
          The method g1() is undefined for the type C
          The method g2() is undefined for the type C
          at Main.main(Main.java:26)
      ```<br>(javac 로 컴파일하면 error: '{' expected)

  - (2) Composition (포함)을 이용하여 구현하라.<br>상속(extends)을 포기하고, HAS-A 관계를 이용해 C 클래스 내부에 A 와 B 의 객체를 부품처럼 생성해 놓고 기능을 빌려 쓰는<br>(위임하는) 방식이다. (참고 : A 는 상속(extends)받고 B 만 Composition 으로 넣는 방법도 있지만, 아래 코드는 가장 순수한 Composition 방식이다)
    ```java
    public class C {
        // 1. A 와 B 객체를 멤버 변수로 포함 (HAS-A 관계)
        private A a = new A();
        private B b = new B();
        // 2. A 의 기능들을 위임(Delegation)하여 구현
        public void f1() { a.f1(); }
        public void f2() { a.f2(); }
        // 3. B 의 기능들을 위임(Delegation)하여 구현
        public void g1() { b.g1(); }
        public void g2() { b.g2(); }
        // 4. 충돌이 났던 c() 메소드를 개발자가 직접 제어할 수 있음!
        public void c() {
            a.c();   // 또는 b.c(); 상황에 맞게 선택하거나 둘 다 호출 가능
        }
        // 5. C 고유의 메소드
        public void h1() { System.out.print("h1 in C"); }
    }
    ```
    - 특징 및 한계 : 이렇게 하면 Main 클래스의 코드가 에러 없이 완벽하게 돌아간다. 모호했던 c() 메소드도 개발자가 직접 a.c() 를 부를지 b.c() 를 부를지 정해 줄 수 있다.
    - 하지만 단점이 하나 있다 : C 는 A 나 B 를 상속받은 것이 아니기 때문에 IS-A 관계가 깨진다. 즉, A ob = new C(); 또는 B ob = new C(); 처럼 다형성을 활용할 수 없다. 이를 해결하기 위해 (3) 번 방법이 등장한다.

  - (3) 인터페이스와 Composition 을 이용하여 구현하라.<br>자바는 클래스의 다중 상속은 막아 두었지만, 인터페이스(Interface)의 다중 상속(구현)은 허용한다!<br>왜냐하면 인터페이스는 껍데기(선언)만 있고 알맹이(구현 코드)가 없어서, 이름이 겹쳐도 충돌이 나지 않기 때문이다.<br>따라서 인터페이스로 IS-A(타입 상속) 관계를 만들고, 내부 구현은 Composition(HAS-A)으로 채워 넣는 것이 자바에서 다중 상속을 완벽히 대체하는 정석 패턴이다.
    ```java
    // 1. A 와 B 의 껍데기 역할을 할 인터페이스 정의
    interface IA { void f1(); void f2(); void c(); }
    interface IB { void g1(); void g2(); void c(); }
    // 2. 기존 A, B 클래스가 인터페이스를 구현하도록 수정
    public class A implements IA { ... }
    public class B implements IB { ... }
    // 3. C 클래스는 인터페이스 IA, IB 를 다중 상속(구현)받고, 실제 동작은 Composition 으로 처리!
    // (또는 public class C extends A implements IB 로 작성해도 됩니다)
    public class C implements IA, IB {
        // Composition (HAS-A) 으로 부품 장착
        private A a = new A();
        private B b = new B();
        // IA 인터페이스 메소드 구현 (A 객체에게 위임)
        public void f1() { a.f1(); }
        public void f2() { a.f2(); }
        // IB 인터페이스 메소드 구현 (B 객체에게 위임)
        public void g1() { b.g1(); }
        public void g2() { b.g2(); }
        // 겹치는 c() 메소드도 문제없이 오버라이딩하여 직접 결정
        public void c() {
            a.c();   // 필요에 따라 b.c() 호출도 가능
        }
        // C 의 고유 메소드
        public void h1() { System.out.print("h1 in C"); }
    }
    ```

- 📝 필기 : 💡 한눈에 보는 요약 정리
  ```text
  구분                    (1) 다중 상속 (extends A, B)   (2) Composition 만 사용          (3) 인터페이스 + Composition
  자바 문법 허용 여부     불가능 (컴파일 에러)            가능                             가능 (가장 이상적인 방법)
  관계                    IS-A                            HAS-A                            IS-A + HAS-A 모두 만족
  코드 재사용             자동 상속됨                     내부 객체에 위임(Delegation)     내부 객체에 위임(Delegation)
  다형성 (IA ob = new C()) -                              불가능 (C 는 A 나 B 타입이 아님)  가능 (C 는 IA 이자 IB 타입이 됨)
  ```

처음 작성한 코드 (네 가지 방법을 모두 실행해 봤다. 아래 main 에서 차례로 확인)

```text
(2-1) A, B 모두 Composition 사용                                            → CComposition
(2-2) 하나는 상속(extends A)받고, 다른 하나만 Composition(B)으로 구현          → CExtendsA
(3-1) IA, IB 인터페이스 다중 구현 + Composition                              → CInterfaces
```

(3-2) A 는 그대로 상속(extends A)받고, B 만 인터페이스(implements IB)와 Composition 으로 구현 → CExtendsAImplementsIB 네 방법 모두 실행 결과는 f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C 로 같다.

- 💡 (3-2) 의 C 에는 c() 가 없는데도 IB 의 c() 를 구현하라는 오류가 나지 않는다. 부모 A 에게서 물려받은 public void c() 가 IB 의 c() 를 대신 구현하기 때문이다. 그래서 ob.c() 는 "c in A" 를 출력한다.
- 💡 print 는 줄을 바꾸지 않아서 출력이 한 줄로 붙어 나온다. 문제의 출력 형식 그대로 두었다.
- 💡 이클립스는 A 의 x, y 와 B 의 w, q 에 "사용하지 않는 필드" 노란 경고를 표시한다. 문제에 주어진 필드라 그대로 두었다.
- 💡 한 파일에서 네 버전을 실행하려고 A, B, IA, IB 와 네 가지 C 를 MultipleInheritanceABC 안에 static 중첩 클래스로 넣었다.
  - (2) 의 A, B 는 원래 인터페이스를 구현하지 않지만, 여기서는 (3) 에서 쓰려고 implements IA / IB 를 붙인 하나의 A, B 를 함께 썼다.

---

[🏠 11주차 학습 가이드](../../README.md)
