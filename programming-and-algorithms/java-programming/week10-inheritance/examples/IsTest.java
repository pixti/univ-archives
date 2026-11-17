/**
 * [10-3 상속3] [실습] instanceof 연산자 사용하기
 *
 * 포인트
 *  - instanceof : 레퍼런스 변수가 가리키는 객체가 어떤 타입인지 검사하는 연산자. 주로 조건문에 쓴다.
 *      o instanceof Class1     ← 왼쪽에는 레퍼런스 변수, 오른쪽에는 타입(클래스명)
 *  - 연산 결과로 boolean 값인 true, false 중 하나를 반환한다.
 *  - 실제 인스턴스와 같은 타입뿐만 아니라 조상 타입에 대해서도 true 를 반환한다.
 *    따라서 instanceof 연산의 결과가 true 라는 것은 검사한 타입으로 형변환이 가능하다는 뜻이다.
 *      if (o instanceof Class1) { ob1 = (Class1) o; }   ← 검사한 뒤 안전하게 다운캐스팅
 *
 *  - test(Object o) : Object 는 모든 클래스의 조상이므로 어떤 객체든(Class1, Class2, String) 받을 수 있다.
 *
 * 💡 실행 결과의 마지막 줄은 코드대로 "o is neither Class1 nor Class2." 처럼 마침표까지 출력된다.
 *    (강의 자료의 실행 결과에는 마침표가 빠져 있다)
 * 💡 "조상 타입에 대해서도 true" 확인 : 모든 객체는 Object 의 자손이므로 c1 instanceof Object 는 true 다.
 * 💡 null instanceof 아무타입 은 항상 false 다. 그래서 instanceof 검사를 통과하면 null 이 아님도 보장된다.
 * 💡 Java 16 부터는 검사와 형변환을 한 번에 쓸 수 있다. (패턴 매칭)
 *      if (o instanceof Class1 ob1) { ... ob1 을 바로 사용 ... }
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 Class1, Class2 를 IsTest 안에 static 중첩 클래스로 넣었다.
 *
 * 실행 결과
 *  o is Class1
 *  o is Class2
 *  o is neither Class1 nor Class2.
 *  ---- 조상 타입 검사 ----
 *  c1 instanceof Object : true
 *  null instanceof Class1 : false
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
