package otherpkg;

/**
 * [10-1 상속1] 다른 패키지에 있는 부모 클래스 (OtherPackageAccessTest.java 에서 사용)
 *
 * 💡 다른 패키지에서 쓰려면 클래스 자체가 public 이어야 한다.
 *    class A 처럼 public 을 빼면 다른 패키지에서는 import 도 할 수 없다.
 *    (error: A is not public in otherpkg; cannot be accessed from outside package)
 * 💡 강의 코드의 패키지 이름은 다르지만 내용은 같다.
 */
public class A {
    private int a = 1;
    int b = 5;
    protected int c = 10;
    public int d = 15;
}
