/**
 * [10-3 상속3] 인터페이스의 형변환
 *
 * 포인트
 *  - 인터페이스로 객체를 생성하지는 못하지만, 인터페이스 유형의 객체 참조 변수에 그 인터페이스를 구현하고 있는
 *    클래스 객체를 할당할 수 있다.        IA p = new A();
 *  - 클래스 형변환과 마찬가지로, 인터페이스 유형의 객체 참조 변수는 인터페이스에 선언된 요소에만 접근할 수 있다.
 *        p.print();    → ✅ IA 에 선언된 메소드. 실제로는 A 의 print() 가 실행된다
 *        p.x           → ❌ 접근 불가능 (IA 에는 x 가 없다)
 *          error: cannot find symbol  symbol: variable x  location: variable p of type IA
 *
 * 💡 A 의 필드를 쓰고 싶으면 다시 A 타입으로 형변환한다.  ((A) p).x  또는  A a = (A) p;
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 IA, A 를 InterfaceCastingTest 안에 중첩해서 넣었다. (강의 코드의 public class 이름은 Example)
 *
 * 실행 결과
 *  print method :17
 *  print method :abc
 *  x : 17
 */
public class InterfaceCastingTest {

    interface IA {
        public void print();
    }

    static class A implements IA {
        public int x = 17;
        public String y = "abc";

        public void print() {
            System.out.println("print method :" + x);
            System.out.println("print method :" + y);
        }
    }

    public static void main(String[] args) {
        IA p = new A();
        p.print();
        // System.out.println("x : " + p.x);      // ❌ 접근 불가능
        System.out.println("x : " + ((A) p).x);   // 💡 A 로 형변환하면 접근 가능
    }
}
