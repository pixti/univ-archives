/**
 * [9-3 생성자와 소멸자] 상수 필드 및 정적 필드 초기화 (슬라이드 15, 16)
 *
 * 포인트
 *  - 상수 필드(final) : ① 선언과 함께 초기화  ② 생성자에서 초기화 (blank final)
 *  - 정적 필드(static) : ① 선언과 함께 초기화  ② static 블록 static { ... } 에서 초기화
 *    슬라이드 : "정적 필드는 생성자에서 초기화 할 수 없음" → static 블록을 쓴다.
 *
 * 💡 final 필드는 딱 한 번만 값을 넣을 수 있다. 다시 대입하면
 *      error: cannot assign a value to final variable MAX_SIZE
 * 💡 blank final 은 모든 생성자에서 반드시 값을 넣어야 한다. 빠뜨리면
 *      error: variable MAX_SIZE might not have been initialized
 * 💡 blank final 의 장점 : 객체마다 다른 상수 값을 줄 수 있다. (CatFinalCtor(int max))
 * 💡 정적 필드는 객체가 아니라 클래스가 처음 로드될 때 한 번 만들어진다.
 *    생성자는 객체를 만들 때마다 실행되므로 정적 필드 초기화에 맞지 않다 → static 블록은 클래스 로드 시 한 번만 실행.
 * ⚠ "생성자에서 초기화할 수 없음" 을 정확히 말하면
 *    - static final 필드 : 생성자에서 대입하면 컴파일 오류.
 *    - 그냥 static 필드  : 생성자에서 대입하는 것 자체는 문법상 가능. 하지만 객체를 만들 때마다 값이 덮어써지고,
 *                          객체를 하나도 안 만들면 아예 초기화되지 않는다. (CatStaticInCtor 로 확인)
 *      퀴즈 1번 Cat() { this("영순이", 50); MAX_WEIGHT = 100; } 가 이 경우다.
 *
 *    필드 종류      | 선언과 함께 | 생성자에서          | static 블록
 *    일반 필드      |     O       |      O              |     X
 *    final 필드     |     O       |      O (한 번만)    |     X
 *    static 필드    |     O       |      △ (매번 덮어씀)|     O
 *    static final   |     O       |      X 컴파일 오류  |     O
 *
 * 실행 결과
 *  ① final 선언과 함께 : 100
 *  ② final 생성자에서 : 100, 200
 *  ③ static 선언과 함께 : 100
 *  static 블록 실행 (클래스 로드 시 한 번)      ← 💡 CatStaticBlock 을 처음 쓰는 순간 실행
 *  ④ static 블록 : 100
 *  ⑤ 객체 생성 전 CatStaticInCtor.MAX_SIZE = 0
 *     객체 생성 후 CatStaticInCtor.MAX_SIZE = 100
 *     값을 바꾼 뒤 CatStaticInCtor.MAX_SIZE = 999
 *     객체 하나 더 생성 후 CatStaticInCtor.MAX_SIZE = 100  ← 덮어써짐
 *  💡 static 블록 활용 : 0 1 4 9 16 25 36 49 64 81
 */
public class FieldInitTest {
    public static void main(String[] args) {
        System.out.println("① final 선언과 함께 : " + new CatFinal().getMax());
        System.out.println("② final 생성자에서 : " + new CatFinalCtor().getMax() + ", " + new CatFinalCtor(200).getMax());
        System.out.println("③ static 선언과 함께 : " + CatStatic.getMax());
        System.out.println("④ static 블록 : " + CatStaticBlock.getMax());   // 이때 CatStaticBlock 이 로드되며 static 블록 실행

        System.out.println("⑤ 객체 생성 전 CatStaticInCtor.MAX_SIZE = " + CatStaticInCtor.MAX_SIZE);
        new CatStaticInCtor();
        System.out.println("   객체 생성 후 CatStaticInCtor.MAX_SIZE = " + CatStaticInCtor.MAX_SIZE);
        CatStaticInCtor.MAX_SIZE = 999;
        System.out.println("   값을 바꾼 뒤 CatStaticInCtor.MAX_SIZE = " + CatStaticInCtor.MAX_SIZE);
        new CatStaticInCtor();
        System.out.println("   객체 하나 더 생성 후 CatStaticInCtor.MAX_SIZE = " + CatStaticInCtor.MAX_SIZE + "  ← 덮어써짐");

        System.out.print("💡 static 블록 활용 :");
        for (int s : Squares.squares) System.out.print(" " + s);
        System.out.println();
    }
}

/** ① 상수 필드 : 선언과 함께 초기화 */
class CatFinal {
    private final int MAX_SIZE = 100;
    private String name;

    int getMax() { return MAX_SIZE; }
}

/** ② 상수 필드 : 생성자에서 초기화 (blank final) */
class CatFinalCtor {
    private final int MAX_SIZE;
    private String name;

    public CatFinalCtor() {
        MAX_SIZE = 100;
        // MAX_SIZE = 200;   // ❌ cannot assign a value to final variable MAX_SIZE (한 번만 가능)
    }

    public CatFinalCtor(int max) {   // 💡 객체마다 다른 상수 값
        MAX_SIZE = max;
    }

    int getMax() { return MAX_SIZE; }
}

/** ③ 정적 필드 : 선언과 함께 초기화 */
class CatStatic {
    private static int MAX_SIZE = 100;
    private String name;

    static int getMax() { return MAX_SIZE; }
}

/** ④ 정적 필드 : static 블록에서 초기화 */
class CatStaticBlock {
    private static int MAX_SIZE;
    private String name;

    static {
        MAX_SIZE = 100;
        System.out.println("static 블록 실행 (클래스 로드 시 한 번)");
    }

    static int getMax() { return MAX_SIZE; }
}

/** ⑤ ⚠ static 필드를 생성자에서 대입 : 컴파일은 되지만 "초기화"가 아님 */
class CatStaticInCtor {
    static int MAX_SIZE;
    // private static final int LIMIT;   // ❌ static final 은 생성자에서 대입 불가 (컴파일 오류)

    public CatStaticInCtor() {
        MAX_SIZE = 100;     // 객체를 만들 때마다 다시 100 으로 덮어씀
    }
}

/** 💡 static 블록은 계산이 필요한 초기화에 유용 */
class Squares {
    static int[] squares = new int[10];

    static {
        for (int i = 0; i < 10; i++) {
            squares[i] = i * i;
        }
    }
}
