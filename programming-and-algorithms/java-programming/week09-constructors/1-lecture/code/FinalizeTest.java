/**
 * [9-3 생성자와 소멸자] 소멸자와 finalize
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FinalizeTest {
    public static void main(String[] args) throws Throwable {
        // ① 강의 코드 (강의에서는 클래스 이름이 ConstructorExample)
        CatFinalize c = new CatFinalize("이쁜이", 45);
        CatFinalize c2 = new CatFinalize();
        System.out.println(c.toString() + "의 몸무게는 " + c.getSize());
        System.out.println(c2.toString() + "의 몸무게는 " + c2.getSize());
        c = null;     // 강의 코드에서는 주석 처리됨
        c2 = null;

        // ② 💡 GC 요청 후 잠깐 기다리기
        System.out.println("----- System.gc() 요청 -----");
        System.gc();
        Thread.sleep(500);
        System.out.println("----- main 끝 -----");
    }
}

class CatFinalize {
    int size;
    String name;

    public CatFinalize() {
        this("영순이", 50);
    }

    public CatFinalize(String n, int s) {
        name = n;
        size = s;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return name;
    }

    @SuppressWarnings("removal")   // 💡 위 ⚠ 경고를 숨김 (강의 코드에는 없음)
    public void finalize() {
        System.out.println(name + " 고양이가 소멸됨");
    }
}
