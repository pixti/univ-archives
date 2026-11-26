/**
 * [9-3 생성자와 소멸자] 상수 필드 및 정적 필드 초기화
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
