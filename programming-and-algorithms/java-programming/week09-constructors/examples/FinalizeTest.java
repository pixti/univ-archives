/**
 * [9-3 생성자와 소멸자] 소멸자와 finalize (슬라이드 17~19)
 *
 * 포인트
 *  - 소멸자 : 객체가 소멸될 때 자동으로 호출되는 메소드. C++ 은 ~클래스명() 형태.
 *  - Java 에는 그런 소멸자가 없고 finalize 메소드를 제공한다.
 *  - 객체 소멸 = 객체 변수를 null 로 지정 → 가비지 컬렉터(GC)가 적당한 시점에 제거하면서 finalize 호출.
 *  - GC 가 시점을 정하므로 객체의 소멸 시기를 정확히 알 수 없다.
 *
 * 📝 필기 (퀴즈) : 객체가 소멸될 때 소멸자. 자바에서는 가비지 컬렉터가 결정함. → 파이널라이즈(finalize)
 *
 * 💡 슬라이드 코드(① 부분)만 실행하면 "고양이가 소멸됨" 은 출력되지 않는다. c = null; 주석을 풀어도 마찬가지.
 *    프로그램이 너무 빨리 끝나 GC 가 돌 기회가 없고, 종료 시에는 finalize 를 호출해 주지 않기 때문이다.
 *    그래서 ② 에서 System.gc() 로 GC 를 "요청"하고 잠깐 기다렸다. 보통은 호출되지만 이것도 보장은 아니다.
 * 💡 null 대입 외에도 다른 객체를 대입하거나(c = new Cat()) 지역 변수의 블록이 끝나면 GC 대상이 된다.
 * 💡 throws Throwable 은 Object 의 finalize() 가 throws Throwable 로 선언되어 있어서 붙인 것. (예외 처리는 11강)
 * 💡 Object 의 finalize() 는 protected 인데 public 으로 재정의했다. 접근 범위를 넓히는 재정의는 허용(10강 상속).
 * ⚠ finalize() 는 Java 9 부터 deprecated, Java 18 부터 삭제 예정(for removal, JEP 421).
 *    JDK 25 로 컴파일하면 경고가 나온다.
 *      warning: [removal] finalize() in Object has been deprecated and marked for removal
 *    실무에서는 close() + try-with-resources(AutoCloseable) 로 자원을 정리한다(13강 파일 입출력).
 *    수업에서는 "자바의 소멸자 = finalize" 로 개념만 이해하면 된다.
 *
 * 실행 결과 (② 의 출력 순서 · 여부는 GC 에 따라 다를 수 있음)
 *  이쁜이의 몸무게는 45
 *  영순이의 몸무게는 50
 *  ----- System.gc() 요청 -----
 *  이쁜이 고양이가 소멸됨
 *  영순이 고양이가 소멸됨
 *  ----- main 끝 -----
 */
public class FinalizeTest {
    public static void main(String[] args) throws Throwable {
        // ① 슬라이드 18 코드 (원래 클래스 이름 ConstructorExample)
        Cat c = new Cat("이쁜이", 45);
        Cat c2 = new Cat();
        System.out.println(c.toString() + "의 몸무게는 " + c.getSize());
        System.out.println(c2.toString() + "의 몸무게는 " + c2.getSize());
        c = null;     // 슬라이드에서는 주석 처리됨
        c2 = null;

        // ② 💡 GC 요청 후 잠깐 기다리기
        System.out.println("----- System.gc() 요청 -----");
        System.gc();
        Thread.sleep(500);
        System.out.println("----- main 끝 -----");
    }
}

class Cat {
    int size;
    String name;

    public Cat() {
        this("영순이", 50);
    }

    public Cat(String n, int s) {
        name = n;
        size = s;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return name;
    }

    @SuppressWarnings("removal")   // 💡 위 ⚠ 경고를 숨김 (원본에는 없음)
    public void finalize() {
        System.out.println(name + " 고양이가 소멸됨");
    }
}
