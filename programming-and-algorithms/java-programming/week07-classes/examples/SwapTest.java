/**
 * [8-4] 메소드 인수 전달 - 기본 자료형 vs 배열(레퍼런스)
 *
 * 포인트
 *  - 기본 자료형 인자는 "값" 이 복사되어 전달된다 (call-by-value)
 *    → swap(x, y) 안에서 a, b 를 바꿔도 main 의 x, y 는 그대로
 *
 *      main          swap(int a, int b)
 *      x [5]  ──복사──▶ a [5] → [3]
 *      y [3]  ──복사──▶ b [3] → [5]      ← 바뀌는 건 복사본뿐
 *
 *  - 배열(레퍼런스형) 인자는 "레퍼런스(주소)" 가 전달된다
 *    → 메소드 안의 arr 와 main 의 arr 가 같은 배열 객체를 가리키므로 원본이 바뀜
 *
 *      main arr ──┐
 *                 ├──▶ [ 5 | 3 ]  → [ 3 | 5 ]
 *      swap arr ──┘
 *
 *  - 💡 정확히 말하면 자바는 항상 call-by-value 이다. 레퍼런스형은 "레퍼런스 값(주소)" 이 복사되어
 *    전달되는 것이라서 같은 객체를 가리키게 되고, 결과적으로 call-by-reference 처럼 동작한다.
 *    (슬라이드 5 : "배열은 레퍼런스가 값으로 전달되기 때문에 작업 후 원래 배열의 원소도 바뀜")
 *    그래서 메소드 안에서 arr = new int[]{...} 처럼 "새 배열을 대입" 하면 main 의 배열은 바뀌지 않는다.
 *
 * ⚠ 슬라이드 3 의 배열 swap 은 public void swap(...) (static 없음)인데 static main 에서 바로
 *    swap(arr, 0, 1) 로 호출해서 컴파일 오류가 난다.
 *      error: non-static method swap(int[],int,int) cannot be referenced from a static context
 *    → public static void swap(...) 로 수정 (퀴즈 8번과 같은 오류)
 * 💡 슬라이드 2, 3 은 둘 다 SwapTest 클래스라서 한 파일에 합쳤다. swap 이 매개변수가 다른 두 형태로
 *    중복정의(오버로딩)된다.
 *
 * 실행 결과
 *  5
 *  3
 *  3
 *  5
 */
public class SwapTest {
    public static void main(String[] args) {
        // 슬라이드 2 : 기본 자료형
        int x = 5, y = 3;
        swap(x, y); // 값이 바뀌지 않음
        System.out.println(x);
        System.out.println(y);

        // 슬라이드 3 : 배열
        int[] arr = new int[] {5, 3};
        swap(arr, 0, 1); // 값이 바뀜
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    public static void swap(int a, int b) {
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
    }

    public static void swap(int[] arr, int idx1, int idx2) {   // ⚠ static 추가
        int tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
