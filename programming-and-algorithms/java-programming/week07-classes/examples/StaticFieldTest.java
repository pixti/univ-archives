/**
 * [8-2] 정적 필드 (static field) - 같은 클래스의 객체들끼리 값을 공유
 *
 * 포인트
 *  - 자료형 앞에 static 을 붙인다.
 *  - 일반 필드와 달리 객체마다 생기지 않고 "클래스당 하나만" 생성되어 같은 클래스의 객체가 공유한다.
 *  - 특정 객체와 무관하므로 객체 생성 전에도 클래스명으로 사용할 수 있다.  → StaticTest.value
 *
 *          ┌──────── StaticTest (클래스당 하나) ────────┐
 *          │  static int value = 3                      │ ◀── ob1, ob2 가 같이 씀
 *          └────────────────────────────────────────────┘
 *      ob1 ──▶ [ instVal = 5 ]
 *      ob2 ──▶ [ instVal = 0 ]   ← 객체마다 따로 (ob1 에 넣은 5 가 안 보임)
 *
 *  - 📝 퀴즈 6번 필기 : 일반 필드는 객체 생성시마다 따로따로 할당된다. 스태틱 필드는 객체마다가 아니라
 *    하나만 공유되는 형태로 할당되고, 객체 생성 없이도 접근이 가능하다.
 *
 * 💡 슬라이드의 public class 이름은 MyApp (8-2 의 정적 메소드 예제와 이름이 겹쳐서 StaticFieldTest 로 바꿈)
 *
 * 실행 결과
 *  3
 *  0
 *  StaticTest.value = 3
 */
public class StaticFieldTest {
    public static void main(String[] args) {
        StaticTest ob1 = new StaticTest();
        StaticTest ob2 = new StaticTest();
        ob1.setValue(3);
        System.out.println(ob2.getValue());     // 3 출력 (value 는 하나뿐이므로 ob1 이 넣은 값이 보인다)
        ob1.setInstVal(5);
        System.out.println(ob2.getInstVal());   // static 변수 아님 → ob2 의 instVal 은 기본값 0

        // 💡 정적 필드는 객체 없이 클래스명으로 접근 가능
        System.out.println("StaticTest.value = " + StaticTest.value);
    }
}

class StaticTest {
    static int value;
    int instVal;
    void setValue(int n) { value = n; }
    int getValue() { return value; }
    void setInstVal(int n) { instVal = n; }
    int getInstVal() { return instVal; }
}
