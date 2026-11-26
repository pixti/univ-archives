/**
 * [10-3 상속3] [실습] instanceof 연산자 사용하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class IsTest {

    static class Class1 { }

    static class Class2 { }

    static void test(Object o) {
        Class1 ob1;
        Class2 ob2;
        if (o instanceof Class1) {
            System.out.println("o is Class1");
            ob1 = (Class1) o;
        } else if (o instanceof Class2) {
            System.out.println("o is Class2");
            ob2 = (Class2) o;
        } else {
            System.out.println("o is neither Class1 nor Class2.");
        }
    }

    public static void main(String[] args) {
        Class1 c1 = new Class1();
        Class2 c2 = new Class2();
        test(c1);           // if 문
        test(c2);           // else if 문
        test("a string");   // else 문

        System.out.println("---- 조상 타입 검사 ----");   // 💡 비교용
        Object nothing = null;
        System.out.println("c1 instanceof Object : " + (c1 instanceof Object));
        System.out.println("null instanceof Class1 : " + (nothing instanceof Class1));
    }
}
