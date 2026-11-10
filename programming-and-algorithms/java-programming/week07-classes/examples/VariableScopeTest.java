/**
 * [8-3 실습] 변수의 유효범위 테스트
 *
 * 포인트
 *  - 변수는 선언 위치에 따라 접근할 수 있는 범위와 생존 기간이 달라진다.
 *      필드(x)         : 클래스 내에 선언 → 클래스의 모든 메소드에서 사용 가능, 객체가 살아 있는 동안 존재
 *      지역 변수(y)    : 메소드 안에 선언 → 그 메소드 안에서만 사용, 메소드가 끝나면 사라짐
 *      블록 변수(z)    : for 문 안에 선언 → for 블록 안에서만 사용
 *
 *      class VariableScope {
 *          int x = 3;  ───────────────────────────┐ 필드 : 클래스 전체
 *          method1() {                            │
 *              int y = 5; ─────┐ method1 안에서만  │
 *          }  ─────────────────┘                  │
 *          method2() {                            │
 *              for (int z ...) { ─┐ for 안에서만   │
 *              } ─────────────────┘               │
 *          }                                      │
 *      } ─────────────────────────────────────────┘
 *
 *  - 📝 퀴즈 1-❷ 필기 (필드 vs 지역 변수) : 필드는 기본값(0, false, null)으로 자동 초기화되지만
 *    지역 변수는 자동 초기화되지 않아 사용 전에 반드시 초기화해야 한다.
 *
 * ⚠ 슬라이드의 method2 에 있는 두 줄은 일부러 넣은 "오류" 줄이다. 그대로 두면 컴파일되지 않으므로
 *    ❌ 원본은 주석으로 남기고 ✅ 로 고친 줄을 넣었다.
 *      error: cannot find symbol  y   (method1 의 지역변수)
 *      error: cannot find symbol  z   (for 문의 변수)
 *
 * 실행 결과
 *  x = 3 y = 5
 *  x = 3
 *  z = 0
 *  z = 1
 *  z = 2
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
