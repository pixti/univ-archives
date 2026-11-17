/**
 * [10-3 상속3] 클래스 형변환 (Type Casting)
 *
 * 포인트
 *  - 하위 클래스 → 상위 클래스로의 변환은 묵시적(자동)이다.   Poly y = new Square();          (업캐스팅)
 *  - 상위 클래스 → 하위 클래스로의 변환은 명시적(강제적)이다. Square x = (Square) p;          (다운캐스팅)
 *  - 필드에 대한 접근은 객체 변수의 타입에 의해 결정된다.        (정적 바인딩)
 *  - 메소드 호출은 실제 저장된 인스턴스의 타입에 의해 결정된다.  (동적 바인딩)
 *
 *  (1) [실습] 하위 타입의 객체를 상위 타입의 변수에 저장하기
 *        A p = new B();
 *        p.print();     → B 의 메소드 호출 (Child method :17, Child method :abc)
 *        p.x            → A 의 필드 접근 (53)
 *  (2) [실습] 상위 타입의 객체를 하위 타입의 변수에 저장하기
 *        B p = (B) new A();    → 컴파일 오류는 아니지만 실행 오류 (ClassCastException)
 *        A p = new B();  B c = (B) p;   → 아래 형태는 허용 (p 가 실제로 B 객체를 가리키므로)
 *
 * ⚠ 자주 틀리는 부분 : 강의의 Square x = (Square) new Poly(); // 명시적  은 "명시적 형변환을 쓰는 문법" 의 예일 뿐,
 *    실제로 실행하면 ClassCastException 이 난다. new Poly() 로 만든 객체는 Square 가 아니기 때문이다.
 *    (2) 의 B p = (B) new A(); 와 같은 경우다. 다운캐스팅은 "원래 하위 타입이었던 객체"를 되돌릴 때만 성공한다.
 *    → 안전하게 하려면 instanceof 로 먼저 검사한다. (IsTest.java)
 * 💡 업캐스팅한 변수로는 부모에 있는 것만 쓸 수 있다. A p = new B(); 에서 p.y 는 컴파일 오류 (A 에는 y 가 없다)
 *      error: cannot find symbol  symbol: variable y  location: variable p of type A
 * 💡 왜 업캐스팅을 쓰나? 서로 다른 자식 객체들을 부모 타입 하나로 묶어서(배열, 매개변수) 똑같이 다룰 수 있기 때문이다.
 *    (MultipleInheritanceTest.java 의 Car[] cars, 퀴즈 3번의 Human[] arr)
 * 💡 강의 코드의 public class 이름은 Program, Example. 같은 폴더의 다른 예제와 겹치지 않도록
 *    Poly, Square, A, B 를 TypeCastingTest 안에 static 중첩 클래스로 넣었다. 강의 코드의 main(String arg[]) 도 그대로 썼다.
 *
 * 실행 결과
 *  ---- Poly / Square ----
 *  Poly y = new Square() : 묵시적 형변환 OK
 *  (Square) new Poly() → java.lang.ClassCastException
 *  ---- (1) 하위 타입의 객체를 상위 타입의 변수에 ----
 *  Child method :17
 *  Child method :abc
 *  Parent value : 53
 *  ---- (2) 상위 타입의 객체를 하위 타입의 변수에 ----
 *  B p = (B) new A() → java.lang.ClassCastException
 *  Child method :17
 *  Child method :abc
 *  Child value : 17
 */
public class TypeCastingTest {

    static class Poly { }

    static class Square extends Poly { }

    static class A {
        public int x = 53;

        public void print() {
            System.out.println("Parent method :" + x);
        }
    }

    static class B extends A {
        public int x = 17;
        public String y = "abc";

        public void print() {
            System.out.println("Child method :" + x);
            System.out.println("Child method :" + y);
        }
    }

    public static void main(String arg[]) {
        System.out.println("---- Poly / Square ----");
        Poly y = new Square();                      // 묵시적
        System.out.println("Poly y = new Square() : 묵시적 형변환 OK");
        try {
            Square x = (Square) new Poly();         // 명시적 : 컴파일은 되지만 실행 오류
        } catch (ClassCastException e) {
            System.out.println("(Square) new Poly() → " + e.getClass().getName());
        }

        System.out.println("---- (1) 하위 타입의 객체를 상위 타입의 변수에 ----");
        A p = new B();
        p.print();                                  // B 의 메소드 호출
        System.out.println("Parent value : " + p.x); // A 의 필드 접근

        System.out.println("---- (2) 상위 타입의 객체를 하위 타입의 변수에 ----");
        try {
            B p2 = (B) new A();                     // 컴파일 오류 아님. 실행 오류
            p2.print();
            System.out.println("Child value : " + p2.x);
        } catch (ClassCastException e) {
            System.out.println("B p = (B) new A() → " + e.getClass().getName());
        }

        // 아래의 형태는 허용
        A p3 = new B();
        B c = (B) p3;
        c.print();
        System.out.println("Child value : " + c.x);
    }
}
