/**
 * [7-2] this 키워드 - 현재 메소드를 실행하고 있는 객체의 레퍼런스
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MyIntegerThis {
    public static void main(String[] args) {
        MyInteger2 ob1 = new MyInteger2();
        MyInteger2 ob2 = new MyInteger2();
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

class MyInteger2 {
    int val;
    int add(MyInteger2 ob) { return this.val + ob.val; }
    int subtract(MyInteger2 ob) { return this.val - ob.val; }          // ⚠ – → -
    int multiply(MyInteger2 ob) { return this.val * ob.val; }
    double divide(MyInteger2 ob) { return ((double) this.val) / ob.val; }
}
