/**
 * [8-3 실습] 정수 클래스의 기능 중복 정의하기 - 메소드 중복정의(오버로딩, overloading)
 *
 * 포인트
 *  - 같은 이름의 메소드로 여러 형태를 지원하는 것 (System.out.println 도 중복정의되어 있어
 *    자료형에 상관없이 같은 메소드로 불러 쓸 수 있다)
 *  - 구분 기준은 "매개변수의 개수·자료형" 뿐이다. 반환형만 다르면 구분하지 못한다.
 *      int f1() {...}
 *      int f1(int x) {...}          // ok
 *      int f1(int x, int y) {...}   // ok
 *      int f1(double x) {...}       // ok
 *      void f1(int x)               // error, 두번째 함수와 구분하지 못함 (반환형만 다름)
 *  - ob.add(5)   → add(int i)    호출 (val 은 기본값 0) → 5
 *    ob.add(3.5) → add(double d) 호출                  → 3.5
 *
 * ⚠ 슬라이드의 add(int i) { return this.val + I; } 는 대문자 I 라서 컴파일 오류 → i 로 수정
 *
 * 실행 결과
 *  5, 3.5
 *  add(MyInteger) : 15
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
