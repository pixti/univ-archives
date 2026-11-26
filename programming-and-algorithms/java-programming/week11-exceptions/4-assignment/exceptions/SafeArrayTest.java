/**
 * [11강 과제] 예외 처리 - 1번 문제 (SafeArray : 잘못된 인덱스이면 IndexException)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SafeArrayTest {
    public static void main(String[] args) {
        SafeArray sa = new SafeArray(5);

        try {
            sa.setAt(1, 11);   // 배열 인덱스 1 위치에 11 저장
            sa.setAt(2, 12);
            sa.setAt(3, 13);
            sa.setAt(4, 14);
            sa.setAt(5, 15);   // 인덱스 범위(0~4) 초과로 예외 발생
        } catch (IndexException e) {
            e.printStackTrace();
        }
    }
}

class IndexException extends Exception {
    public IndexException(String message) {
        super(message);
    }
}

class SafeArray {
    private int[] arr;

    public SafeArray(int size) {
        arr = new int[size];
    }

    public void setAt(int index, int value) throws IndexException {
        if (index < 0 || index >= arr.length) {
            throw new IndexException("out of index error");
        }
        arr[index] = value;
    }
}
