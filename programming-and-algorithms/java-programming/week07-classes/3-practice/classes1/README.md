# 7주차 실습 · classes1

[🏠 7주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [BookDirectAccess.java](#1-❶-book-클래스-필드에-직접-접근) | 1-❶. Book 클래스: 필드에 직접 접근 |
| [BookGetterSetter.java](#1-❷-book-클래스-private-필드--getter--setter) | 1-❷. Book 클래스: `private` 필드 + getter / setter (📝 `this` 설명) |
| [EmployeeSalary.java](#2-employee-클래스-setter에서-연봉-범위-검사) | 2. Employee 클래스: setter에서 연봉 범위 검사 |
| [ComplexTest.java](#3-복소수-덧셈--뺄셈) | 3. 복소수 덧셈 · 뺄셈 (📝 `private`은 클래스 기준이라 다른 객체의 필드에도 직접 접근 가능) |
| [DynamicArrayTest.java](#4-동적-배열) | 4. 동적 배열 (📝 논리적 삭제 vs 물리적 삭제, 교수님의 나눗셈 최적화 팁) |

---

## 1-❶. Book 클래스: 필드에 직접 접근

`7강 실습` · 📄 [`BookDirectAccess.java`](BookDirectAccess.java)

#### 문제

> 책 제목(title)과 저자(author)를 필드로 가지는 Book 클래스를 만들고,<br>Book 클래스 안의 main 에서 객체를 만들어 필드에 직접 값을 넣고 출력하시오.

#### 💻 코드

<!-- code: BookDirectAccess.java -->
```java
public class BookDirectAccess {
    public String title;
    public String author;

    public static void main(String[] args) {
        BookDirectAccess b = new BookDirectAccess();     // 원래 코드 : Book b = new Book();
        b.title = "Great C++";
        b.author = "bob";
        System.out.println(b.title + " - " + b.author);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Great C++ - bob
```

**포인트**

- 필드를 public 으로 열어 두면 b.title = "..." 처럼 "객체.필드" 로 바로 읽고 쓸 수 있다.
- 간단하지만 아무 값이나 들어갈 수 있어서(유효성 검사 불가) 보통은 ❷ 처럼 private + getter/setter 로 바꾼다.<br>(퀴즈 2번 📝 필기 : 캡슐화와 정보 은닉)

- 💡 문제의 클래스 이름은 Book. 같은 폴더의 ❷ 버전(BookGetterSetter.java)에 있는 Book 과 겹치지 않도록 BookDirectAccess 로 바꿨다.

## 1-❷. Book 클래스: `private` 필드 + getter / setter

`7강 실습` · 📄 [`BookGetterSetter.java`](BookGetterSetter.java)

#### 문제

> - ❶ 의 Book 클래스의 필드를 private 으로 바꾸고 getter / setter 를 통해 접근하도록 수정하시오.

#### 💻 코드

<!-- code: BookGetterSetter.java -->
```java
public class BookGetterSetter {
    public static void main(String[] args) {
        Book b = new Book();
        b.setTitle("Great C++");
        b.setAuthor("bob");
        System.out.println(b.getTitle() + " - " + b.getAuthor());
        // b.title = "Great C++";   // ❌ error: title has private access in Book
    }
}

class Book {
    private String title;
    private String author;

    public String getTitle() {
        return title;                  // 이름이 겹치지 않으므로 this 생략
    }

    public void setTitle(String title) {
        this.title = title;            // this.title = 필드, title = 매개변수
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Great C++ - bob
```

**포인트**

- private 필드는 Book 클래스 밖(main 이 있는 클래스)에서 직접 접근할 수 없다.<br>→ b.setTitle("Great C++"); 로 쓰고 b.getTitle() 로 읽는다.
- setter 의 매개변수 이름을 필드와 같게 지으면 this.title = title; 로 구분한다.

- 📝 필기 : 처음에는 매개변수 이름을 다르게 지어서 이렇게 작성해 봤다.
  ```java
  public String getTitle() { return this.title; }
  public void setTitle(String newTitle) { this.title = newTitle; }
  ```

- 📝 필기 : this 키워드
  - 같은 클래스로 만든 객체들은 메서드 코드를 객체마다 따로 갖지 않는다.<br>메서드 코드는 메모리(Method Area)에 한 번만 올라가고 모든 객체가 공유한다.
  - 그래서 "어느 객체의 필드인지" 를 알려 줘야 하는데, 그것이 this 다.<br>b.setTitle("Great C++") 를 호출하면 JVM 이 b 의 주소를 숨겨진 매개변수로 몰래 넘겨주고, 그 값이 바로 this (= 메서드를 호출한 객체) 이다.

```text
b.setTitle("Great C++");
    │            │
    ▼            ▼
```

setTitle(this = b, title = "Great C++")  →  this.title = title;  →  b 의 title 에 저장

  - 매개변수 이름을 필드 이름과 같게 짓는 것이 표준 관례다.<br>메서드 안에서는 매개변수가 우선하기 때문에 title = title; 이라고 쓰면 매개변수에 자기 자신을 대입할 뿐 필드는 바뀌지 않는다. → this.title = title; 이 필요하다.
  - getter 는 이름이 겹치는 매개변수가 없으므로 return title; 처럼 this 를 생략하는 경우가 많다.<br>(return this.title; 로 써도 같다)

- 📝 필기 : 최종 코드는 Book.java 와 Main.java 두 파일로 나눠서 작성했다.<br>여기서는 한 파일로 실행할 수 있도록 합쳤다. (public class 는 하나만 → Book 의 public 을 뺌, Main 은 BookGetterSetter 로 이름을 바꿈)

## 2. Employee 클래스: setter에서 연봉 범위 검사

`7강 실습` · 📄 [`EmployeeSalary.java`](EmployeeSalary.java)

#### 문제

> 이름(name), 전화번호(phoneNumber), 연봉(salary)을 private 필드로 가지는 Employee 클래스를 만드시오.<br>연봉은 0 이상 100,000,000 이하만 저장하고, 범위를 벗어나면 안내 문구를 출력한 뒤 0 으로 저장한다.

#### 💻 코드

<!-- code: EmployeeSalary.java -->
```java
public class EmployeeSalary {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("홍길동");
        emp.setPhoneNumber("010-1234-5678");
        emp.setSalary(40000000);
        System.out.println("이름 : " + emp.getName() + ", 전화번호 : " + emp.getPhoneNumber()
                + ", 연봉 : " + emp.getSalary() + "원");

        // 💡 범위를 벗어난 값 확인
        emp.setSalary(-500);
        System.out.println("잘못된 연봉을 넣은 뒤 : " + emp.getSalary() + "원");
    }
}

class Employee {
    private String name;
    private String phoneNumber;
    private int salary;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getSalary() { return salary; }

    public void setSalary(int salary) {
        if (0 <= salary && salary <= 100000000) {
            this.salary = salary;
        } else {
            System.out.println("연봉은 0 이상 100,000,000 이하로 입력해야 합니다.");
            this.salary = 0;
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
이름 : 홍길동, 전화번호 : 010-1234-5678, 연봉 : 40000000원
연봉은 0 이상 100,000,000 이하로 입력해야 합니다.
잘못된 연봉을 넣은 뒤 : 0원
```

**포인트**

- setter 안에서 값을 검사한다 = getter/setter 를 쓰는 이유 ① "데이터 무결성 / 유효성 검사" (퀴즈 2번)
- 0 &lt;= salary && salary &lt;= 100000000 : 범위 검사는 && 로 두 조건을 묶는다.<br>(수학처럼 0 &lt;= salary &lt;= 100000000 으로 쓰면 컴파일 오류)

- 💡 숫자가 길면 100\_000\_000 처럼 밑줄을 넣어 쓸 수 있다. (Java 7 이상, 값은 같음)
- 💡 main 이 있던 클래스(Main)는 EmployeeSalary 로 이름을 바꿨다.

## 3. 복소수 덧셈 · 뺄셈

`7강 실습` · 📄 [`ComplexTest.java`](ComplexTest.java)

#### 문제

> 실수부(real)와 허수부(imagine)를 필드로 가지는 복소수 클래스 Complex 를 만드시오.<br>getter / setter, 두 복소수를 더한 결과를 돌려주는 add(Complex c),<br>뺀 결과를 돌려주는 sub(Complex c), 그리고 "실수부 + 허수부i" 형태로 바꾸는 toString() 을 작성한다.<br>main 에서는 두 복소수를 입력받아 각 복소수, 합, 차를 출력한다.
>
> (문제의 실행 예 : 8 13.9 / 4 4.0 입력 → 합은 : 12 + 17.9i, 뺄셈은 : 4 + 9.9i)

#### 💻 코드

<!-- code: ComplexTest.java -->
```java
import java.util.Scanner;

public class ComplexTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Complex c1 = new Complex();
        Complex c2 = new Complex();

        System.out.print("1번째 실수부와 허수부를 입력하세요 : ");
        c1.setReal(sc.nextDouble());
        c1.setImagine(sc.nextDouble());
        System.out.print("2번째 실수부와 허수부를 입력하세요 : ");
        c2.setReal(sc.nextDouble());
        c2.setImagine(sc.nextDouble());

        Complex sum = c1.add(c2);
        Complex diff = c1.sub(c2);

        System.out.println("==========================");
        System.out.println("복소수는 : " + c1.toString());
        System.out.println("복소수는 : " + c2.toString());
        System.out.println("합은 : " + sum);            // toString() 을 안 써도 자동으로 호출된다
        System.out.println("뺄셈은 : " + diff);
        System.out.println("==========================");
        System.out.println("(직접 접근 버전 addDirect : " + c1.addDirect(c2) + ")");
        sc.close();
    }
}

class Complex {
    private double real;
    private double imagine;

    public double getReal() { return real; }
    public void setReal(double real) { this.real = real; }
    public double getImagine() { return imagine; }
    public void setImagine(double imagine) { this.imagine = imagine; }

    // 처음 작성한 코드 : getter / setter 로 계산
    public Complex add(Complex c) {
        Complex result = new Complex();
        result.setReal(this.real + c.getReal());
        result.setImagine(this.imagine + c.getImagine());
        return result;
    }

    public Complex sub(Complex c) {
        Complex result = new Complex();
        result.setReal(this.real - c.getReal());
        result.setImagine(this.imagine - c.getImagine());
        return result;
    }

    // 📝 필기 버전 : 같은 클래스이므로 c 의 private 필드에 직접 접근
    public Complex addDirect(Complex c) {
        Complex result = new Complex();
        result.real = this.real + c.real;
        result.imagine = this.imagine + c.imagine;
        return result;
    }

    @Override
    public String toString() {
        double r = Math.round(this.real * 100) / 100.0;       // 소수점 둘째 자리 반올림
        double i = Math.round(this.imagine * 100) / 100.0;
        String realStr = (r % 1 == 0) ? String.valueOf((int) r) : String.valueOf(r);
        String imagStr = (i % 1 == 0) ? String.valueOf((int) i) : String.valueOf(i);
        return realStr + " + " + imagStr + "i";
        // 💡 허수부가 음수일 때 "a - bi" 로 출력하려면
        //    String sign = (i < 0) ? " - " : " + ";
        //    double absI = Math.abs(i);
        //    String imagStr = (absI % 1 == 0) ? String.valueOf((int) absI) : String.valueOf(absI);
        //    return realStr + sign + imagStr + "i";
    }
}
```
<!-- /code -->

#### 실행 예

```text
1번째 실수부와 허수부를 입력하세요 : 2 6.1
2번째 실수부와 허수부를 입력하세요 : 6 8.2
==========================
복소수는 : 2 + 6.1i
복소수는 : 6 + 8.2i
합은 : 8 + 14.3i
뺄셈은 : -4 + -2.1i
==========================
(직접 접근 버전 addDirect : 8 + 14.3i)

(문제의 예 : 8 13.9 / 4 4.0 입력)
복소수는 : 8 + 13.9i
복소수는 : 4 + 4i
합은 : 12 + 17.9i
뺄셈은 : 4 + 9.9i
```

**포인트**

- add / sub 는 자기 자신(this)과 매개변수(c)를 바꾸지 않고, "새 Complex 객체" 를 만들어 결과를 담아 돌려준다.
  ```java
  Complex sum = c1.add(c2);      // this = c1, c = c2
  ```
- toString() 을 오버라이딩하면 System.out.println(c1) 처럼 객체를 바로 출력할 때도 이 문자열이 쓰인다.<br>(과제 클래스1 3번 📝 필기 : @Override 를 붙이는 이유)
- Math.round(x \* 100) / 100.0 : 소수점 둘째 자리에서 반올림<br>→ 6.1 + 8.2 = 14.299999999999999 처럼 생기는 실수 오차를 14.3 으로 정리
- (r % 1 == 0) ? 정수로 : 실수로 : 소수 부분이 0 이면 "2.0" 대신 "2" 로 출력

- 📝 필기 : 객체가 아닌 클래스를 기준으로 접근을 제어하므로 private 더라도 getReal()이 아닌 this.real로 접근할 수 있다.

- 📝 필기 : 맞다. private 은 "같은 클래스" 안이면 다른 객체(c)의 private 필드에도 직접 접근할 수 있다.<br>그래서 add 를 이렇게 써도 된다. (sub 도 + 를 - 로 바꾸면 같다)
  ```java
  public Complex add(Complex c) {
      Complex result = new Complex();
      result.real = this.real + c.real;
      result.imagine = this.imagine + c.imagine;
      return result;
  }
  ```<br>→ 아래 코드에는 처음 작성한 getter / setter 버전을 남기고, 이 직접 접근 버전은 addDirect() 로 넣었다.

- 💡 뺄셈 결과의 허수부가 음수이면 "-4 + -2.1i" 처럼 + 와 - 가 같이 나온다.<br>"-4 - 2.1i" 로 출력하고 싶다면 toString() 에서 부호를 따로 처리하면 된다. (아래 toString 의 주석 참고)
- 💡 main 이 있던 클래스(Main)는 ComplexTest 로 이름을 바꿨다.

## 4. 동적 배열

`7강 실습` · 📄 [`DynamicArrayTest.java`](DynamicArrayTest.java)

#### 문제

> 양의 정수를 저장하는 동적 배열 클래스 DynamicArray 를 만드시오.
>
>   - 처음 용량(capacity)은 3, 사이즈(size, 실제로 저장된 개수)는 0
>   - append(val) : val 이 0 이하이면 -1 반환. 용량이 꽉 찼으면 용량을 2배로 늘린 뒤 저장하고 size 반환
>   - delete()    : 비어 있으면 -1 반환. 마지막 값을 지우고 그 값을 반환
>   - shrink()    : size 가 capacity 의 반 미만이면 용량을 반으로 줄이고 새 용량 반환, 아니면 -1
>   - getCapacity(), getSize()

#### 💻 코드

<!-- code: DynamicArrayTest.java -->
```java
public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();     // ⚠ 문제 : new MyArray();
        int x;
        arr.append(3);
        arr.append(5);
        System.out.println("용량 : " + arr.getCapacity() + ", 사이즈 : " + arr.getSize());
        arr.append(6);
        arr.append(7);
        System.out.println("용량 : " + arr.getCapacity() + ", 사이즈 : " + arr.getSize());
        x = arr.delete();
        System.out.println("데이터 : " + x);
        arr.delete();
        arr.delete();
        System.out.println("용량 : " + arr.getCapacity() + ", 사이즈 : " + arr.getSize());
        arr.shrink();
        System.out.println("용량 : " + arr.getCapacity() + ", 사이즈 : " + arr.getSize());
        x = arr.delete();
        System.out.println("데이터 : " + x);
    }
}

class DynamicArray {
    private int capacity;
    private int size;
    private int[] array;

    public DynamicArray() {          // 💡 생성자 (9주차) : new DynamicArray() 할 때 자동으로 실행
        capacity = 3;
        size = 0;
        array = new int[capacity];
    }

    public int append(int val) {
        if (val <= 0) {
            return -1;                                   // 양의 정수만 저장
        }
        if (size == capacity) {                          // 꽉 찼으면
            capacity *= 2;                               // 용량 2배
            int[] newArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];                  // 기존 값 복사
            }
            array = newArray;                            // 필드가 새 배열을 가리키게
        }
        array[size++] = val;
        return size;
    }

    public int delete() {
        if (size == 0) {
            return -1;
        }
        int deletedValue = array[size - 1];
        size--;                                          // 논리적 삭제
        return deletedValue;
    }

    public int getCapacity() { return capacity; }
    public int getSize() { return size; }

    // 처음 작성한 코드 : "반 미만" 을 그대로 (double 로 실수 나눗셈)
    public int shrink() {
        if (size < (double) capacity / 2) {
            capacity /= 2;
            int[] newArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;                            // 물리적으로 용량 줄이기
            return capacity;
        }
        return -1;
    }

    // 📝 교수님 팁 버전 : 나눗셈을 한 번만 하고 재사용
    public int shrinkOptimized() {
        int newCapacity = capacity / 2;
        if (size <= newCapacity) {
            capacity = newCapacity;
            int[] newArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            return capacity;
        }
        return -1;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
용량 : 3, 사이즈 : 2
용량 : 6, 사이즈 : 4
데이터 : 7
용량 : 6, 사이즈 : 1
용량 : 3, 사이즈 : 1
데이터 : 3
```

**포인트**

- 자바 배열은 한 번 만들면 크기를 바꿀 수 없다.<br>→ 더 큰(작은) 새 배열을 만들고, 기존 값을 복사한 뒤, 필드가 새 배열을 가리키게 한다. (array = newArray;)
- array\[size++] = val; : size 자리에 저장한 다음 size 를 1 증가 (후위 증가)

```text
append(3), append(5)        cap 3  [3, 5, _]          size 2
append(6), append(7)        cap 6  [3, 5, 6, 7, _, _] size 4   ← 7 을 넣을 때 꽉 차서 2배
delete() → 7                cap 6  [3, 5, 6, _, _, _] size 3
delete(), delete()          cap 6  [3, _, _, _, _, _] size 1
shrink()                    cap 3  [3, _, _]          size 1   ← 1 < 6/2 이므로 반으로
delete() → 3                cap 3  [_, _, _]          size 0
```

- 📝 필기 : 논리적 삭제 vs 물리적 삭제
  - delete() 는 size-- 만 한다. 배열 안의 값은 그대로 남아 있지만 size 밖이라 "없는 값" 으로 취급된다.<br>→ 논리적 삭제 : 빠르다. 나중에 append 하면 그 자리를 덮어쓴다.
  - 실제로 메모리에서 없애려면(물리적 삭제) 더 작은 새 배열을 만들어 복사해야 한다. (= shrink() 가 하는 일)<br>중간 값을 지울 때는 뒤의 원소들을 한 칸씩 앞으로 당겨야(shift) 한다.
  - 그래서 보통은 논리적 삭제를 하고, 가끔 shrink() 로 용량을 줄인다.

- 📝 필기 (교수님 팁) 나눗셈은 한 번만 계산해서 재사용하기
  ```java
  int newCapacity = capacity / 2;
  if (size <= newCapacity) {
      capacity = newCapacity;
      int[] newArray = new int[capacity];
      ...
  }
  ```

**📝 필기**

  - 원래 코드에서 (double) 을 쓴 이유 : 문제의 "반 미만" 을 그대로 옮기면서 정수 나눗셈(3 / 2 = 1)을 피하려고.
  - 하지만 나눗셈은 비용이 큰 연산이라, 나눗셈 횟수를 줄이고 계산한 값을 재사용하는 것이 최적화다.

→ 아래 shrink() 는 처음 작성한 코드, shrinkOptimized() 는 교수님 팁 버전이다.

- 💡 두 shrink 의 조건은 경계값에서 조금 다르다.
  ```text
  capacity = 3, size = 1 : 원래  1 < 1.5 → 줄임 (용량 1)     /  팁 버전  1 <= 1 → 줄임 (용량 1)
  capacity = 6, size = 3 : 원래  3 < 3.0 → 그대로             /  팁 버전  3 <= 3 → 줄임 (용량 3, 꽉 참)
  ```<br>팁 버전은 "새 용량에 다 들어가면 줄인다" 는 뜻이고, 원래 버전은 문제 문장 "반 미만" 을 그대로 옮긴 것이다.<br>이 문제의 main 에서는 두 버전의 결과가 같다.

---

[🏠 7주차 학습 가이드](../../README.md)
