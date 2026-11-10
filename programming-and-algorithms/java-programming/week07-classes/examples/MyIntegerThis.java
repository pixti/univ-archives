/**
 * [8-2] this 키워드 - 현재 메소드를 실행하고 있는 객체의 레퍼런스
 *
 * 포인트
 *  - this 는 "지금 이 메소드를 호출한 객체" 를 가리키는 레퍼런스 변수
 *      int r  = ob1.add(ob2);   // this ← ob1,  ob ← ob2  →  ob1.val + ob2.val
 *      int r2 = ob2.add(ob1);   // this ← ob2,  ob ← ob1  →  ob2.val + ob1.val
 *  - 메소드 코드는 클래스에 하나만 있고 모든 객체가 공유한다.
 *    그래서 "어느 객체의 val 인지" 를 this 로 구분한다. (실습 클래스1 1번 📝 필기 참고)
 *  - divide 는 ((double) this.val) / ob.val 로 실수 나눗셈
 *
 * ⚠ 슬라이드의 "this.val – ob.val" 의 – 는 빼기 기호(-)가 아니라 en dash(–)라서 컴파일 오류가 난다.
 * ⚠ 슬라이드의 "Int r = ..." 는 int 의 오타 (자바는 대소문자를 구분한다)
 *
 * 실행 결과
 *  ob1.add(ob2) = 13
 *  ob2.add(ob1) = 13
 *  ob1.subtract(ob2) = 7
 *  ob2.subtract(ob1) = -7
 *  ob1.multiply(ob2) = 30
 *  ob1.divide(ob2) = 3.3333333333333335
 */
public class MyIntegerThis {
    public static void main(String[] args) {
        MyInteger ob1 = new MyInteger();
        MyInteger ob2 = new MyInteger();
        ob1.val = 10;
        ob2.val = 3;
        int r = ob1.add(ob2);      // this <- ob1
        int r2 = ob2.add(ob1);     // this <- ob2
        System.out.println("ob1.add(ob2) = " + r);
        System.out.println("ob2.add(ob1) = " + r2);
        System.out.println("ob1.subtract(ob2) = " + ob1.subtract(ob2));   // this <- ob1 : 10 - 3
        System.out.println("ob2.subtract(ob1) = " + ob2.subtract(ob1));   // this <- ob2 : 3 - 10
        System.out.println("ob1.multiply(ob2) = " + ob1.multiply(ob2));
        System.out.println("ob1.divide(ob2) = " + ob1.divide(ob2));
    }
}

class MyInteger {
    int val;
    int add(MyInteger ob) { return this.val + ob.val; }
    int subtract(MyInteger ob) { return this.val - ob.val; }          // ⚠ – → -
    int multiply(MyInteger ob) { return this.val * ob.val; }
    double divide(MyInteger ob) { return ((double) this.val) / ob.val; }
}
