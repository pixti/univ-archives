/**
 * [10-3 상속3] 상속과 바인딩 - static
 *
 * 포인트
 *  - 정적(static) 필드, 정적 메소드는 모두 정적 바인딩이다. (컴파일 시 결정)
 *      A c = new B();
 *      c.X     → A 의 X
 *      c.f()   → A 의 f()      ← 실제 객체가 B 인데도 A 의 f() 가 불린다 (BindingTest.java 와 비교)
 *
 * 💡 static 메소드는 객체가 아니라 "클래스"에 속한다. 그래서 변수 c 가 가리키는 객체는 보지 않고 변수의 타입(A)만 본다.
 *    c.f() 라고 써도 컴파일러는 A.f() 로 바꿔서 호출한다.
 * 💡 그래서 static 멤버는 객체 변수 대신 클래스 이름으로 쓰는 것이 좋다.  A.X, A.f(), B.f()
 *    (객체 변수로 쓰면 이클립스는 "The static method f() from the type A should be accessed in a static way" 경고를 준다)
 * ⚠ 자주 틀리는 부분 : B 의 static f() 는 A 의 f() 를 재정의(override)한 것이 아니라 "숨긴(hide)" 것이다.
 *    static 메소드에 @Override 를 붙이면 컴파일 오류가 난다.
 *      error: method does not override or implement a method from a supertype
 *    반대로 static 메소드를 인스턴스 메소드로(또는 그 반대로) 바꿔 쓰는 것도 오류다.
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 A, B 를 StaticBindingTest 안에 static 중첩 클래스로 넣었다. (강의 코드의 public class 이름은 Test)
 *
 * 실행 결과
 *  2
 *  kkk
 *  ---- 클래스 이름으로 ----
 *  0
 *  hhh
 */
public class StaticBindingTest {

    static class A {
        public static int X = 2;
        public static void f() { System.out.println("kkk"); }
    }

    static class B extends A {
        public static int X = 0;
        public static void f() { System.out.println("hhh"); }
    }

    @SuppressWarnings({"static", "static-access"})   // 💡 객체 변수로 static 멤버를 쓰는 경고를 숨김 (javac, 이클립스)
    public static void main(String[] args) {
        A c = new B();
        System.out.println(c.X);   // A 의 X
        c.f();                     // A 의 f()

        System.out.println("---- 클래스 이름으로 ----");   // 💡 비교용
        System.out.println(B.X);
        B.f();
    }
}
