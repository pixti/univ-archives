/**
 * [7-3 실습] 정수 클래스의 기능 중복 정의하기 - 메소드 중복정의(오버로딩, overloading)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MyIntegerTest {
    public static void main(String[] args) {
        MyInteger ob = new MyInteger();
        int x = ob.add(5);
        double y = ob.add(3.5);
        System.out.println(x + ", " + y);

        // 💡 세 번째 형태 add(MyInteger) 도 확인
        MyInteger a = new MyInteger(), b = new MyInteger();
        a.val = 10; b.val = 5;
        System.out.println("add(MyInteger) : " + a.add(b));
    }
}

class MyInteger {
    int val;
    int add(MyInteger ob) { return this.val + ob.val; }  // 중복정의
    int add(int i) { return this.val + i; }               // 중복정의  (⚠ I → i)
    double add(double d) { return this.val + d; }         // 중복정의
    int subtract(MyInteger ob) { return this.val - ob.val; }
    int multiply(MyInteger ob) { return this.val * ob.val; }
    double divide(MyInteger ob) { return ((double) this.val) / ob.val; }
}
