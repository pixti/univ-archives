/**
 * [7-2] 정적 필드 (static field) - 같은 클래스의 객체들끼리 값을 공유
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
