/**
 * [7-3 실습] 변수의 유효범위 테스트
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class VariableScopeTest {
    public static void main(String[] args) {
        VariableScope app = new VariableScope();
        app.method1();
        app.method2();
    }
}

class VariableScope {
    int x = 3;

    public void method1() {
        int y = 5;
        System.out.println("x = " + x + " y = " + y);
    }

    public void method2() {
        // ❌ System.out.println("x = " + x + " y = " + y);   // method1 지역변수 오류
        System.out.println("x = " + x);                          // ✅ y 는 여기서 보이지 않는다
        for (int z = 0; z < 3; z++) System.out.println("z = " + z);
        // ❌ System.out.println("z = " + z);                  // for 문의 z를 사용하여 오류
    }
}
