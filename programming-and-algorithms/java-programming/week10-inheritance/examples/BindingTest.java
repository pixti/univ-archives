/**
 * [10-3 상속3] 상속과 바인딩
 *
 * 포인트
 *  - 바인딩 : 이름(필드, 메소드)을 실제로 어느 것과 연결할지 정하는 것
 *  - 필드는 정적 바인딩 : 컴파일할 때 "변수의 타입"을 보고 결정한다.
 *  - 메소드는 동적 바인딩 : 실행할 때 "객체의 타입"에 따라 결정한다.
 *
 *      A c = new B();
 *      c.X     → A 에서 상속받은 X  (변수 c 의 타입이 A → 정적 바인딩)   = 2
 *      c.f()   → B 의 f()           (실제 객체가 B → 동적 바인딩)       = hhh
 *
 *  - static(정적) 필드, static 메소드는 모두 정적 바인딩이다. (컴파일 시 결정) → StaticBindingTest.java
 *
 * 📝 필기 (퀴즈) : 자바는 동적 바인딩
 *    질문 : 자바는 동적 바인딩이면 동적 타입 언어인가? → 아니다. 자바는 대표적인 "정적 타입 언어"다.
 *    두 개념이 비슷해 보여 헷갈리기 쉽다.
 *    1. 정적 타입 언어 (Static Typing)
 *       - 변수를 선언할 때 자료형(int, String, Human 등)을 명시해야 하고, 컴파일 시점에 변수의 타입이 정해지고 검사된다.
 *       - 한 번 선언된 변수의 타입은 실행 중에 바뀔 수 없고, 맞지 않는 타입의 값을 넣으면 컴파일 에러가 난다.
 *           int age = 10;
 *           age = "열살";     // 컴파일 에러 (정적 타입 검사)
 *       - (참고) 파이썬, 자바스크립트처럼 변수에 타입을 적지 않고 실행 시점에 타입이 정해지는 언어가 "동적 타입 언어"다.
 *    2. 동적 바인딩 (Dynamic Binding)
 *       - 자바는 정적 타입 언어이지만, 상속 관계에서 메소드를 호출할 때는 동적 바인딩을 쓴다.
 *           Human h = new Student("철수", 20, "컴퓨터");
 *           h.print();
 *       - 컴파일 시점 : 컴파일러는 h 의 타입을 Human 으로 보고, Human 클래스에 print() 가 있는지만 검사한다.
 *       - 실행 시점 : JVM 이 h 가 가리키는 실제 객체가 Student 임을 확인하고, Student 가 재정의한 print() 를 실행한다.
 *    요약 : 언어의 타입 시스템 → 정적 타입 / 오버라이딩된 메소드 호출 방식 → 동적 바인딩
 * 📝 필기 (퀴즈) : 실제 돌아갈 때는 상위 타입의 변수에 대해서 상위 타입 메소드를 호출하는 게 아니라 객체가 뭐냐에 따라서 결정.
 *
 * ⚠ 자주 틀리는 부분 : 필드는 재정의되지 않는다. B 에 같은 이름의 X 를 만들면 A 의 X 를 "가릴(hide)" 뿐이고,
 *    B 객체 안에는 A 의 X(2) 와 B 의 X(0) 가 둘 다 들어 있다. 어느 X 를 쓸지는 변수의 타입이 정한다.
 *      ((B) c).X  → 0   (변수 타입을 B 로 바꾸면 B 의 X)
 *    그래서 부모와 자식에 같은 이름의 필드를 만들지 않는 것이 좋다. (보통 private 필드 + getter 로 쓴다)
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 A, B 를 BindingTest 안에 static 중첩 클래스로 넣었다. (강의 코드의 public class 이름은 Test)
 *
 * 실행 결과
 *  2
 *  hhh
 *  ---- 변수 타입을 B 로 ----
 *  0
 *  hhh
 */
public class BindingTest {

    static class A {
        public int X = 2;
        public void f() { System.out.println("kkk"); }
    }

    static class B extends A {
        public int X = 0;
        public void f() { System.out.println("hhh"); }
    }

    public static void main(String[] args) {
        A c = new B();
        System.out.println(c.X);   // A 에서 상속받은 X → (정적 바인딩)
        c.f();                     // B 의 f() → (동적 바인딩)

        System.out.println("---- 변수 타입을 B 로 ----");   // 💡 비교용
        B d = (B) c;
        System.out.println(d.X);   // B 의 X
        d.f();                     // 메소드는 여전히 B 의 f()
    }
}
