/**
 * [10-3 상속3] 인터페이스의 형변환
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
