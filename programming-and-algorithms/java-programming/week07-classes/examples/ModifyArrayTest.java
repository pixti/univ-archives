/**
 * [8-4] 배열 인수 - 메소드에서 배열을 인수로 받아들이는 예
 *
 * 포인트
 *  - 배열도 객체이기 때문에 값이 아닌 참조(레퍼런스)가 전달된다.
 *  - 배열을 인수로 전달할 때는 "배열명만" 인수로 전달하고,
 *    메소드 선언부에서는 배열의 레퍼런스가 넘어온다고 표시한다.
 *        ModifyArray( t );                 // 호출 : 배열명만 (t[] 아님)
 *        static void ModifyArray( int[] b ) // 선언 : int[] 로 받음
 *  - 배열은 레퍼런스가 값으로 전달되기 때문에 작업 후 원래 배열의 원소도 바뀐다.
 *
 * ⚠ 슬라이드의 System.out.print(t[j] + “ ”) 스마트 따옴표 → " "
 * 💡 자바 관례로는 메소드 이름을 소문자로 시작한다 (modifyArray). 슬라이드 이름 그대로 둠.
 *
 * 실행 결과
 *  2 4 6
 */
public class ModifyArrayTest {
    public static void main(String[] args) {
        int[] t = new int[] {1, 2, 3};
        ModifyArray(t);
        for (int j = 0; j < t.length; j++) System.out.print(t[j] + " ");
        System.out.println();
    }

    static void ModifyArray(int[] b) {
        for (int j = 0; j < b.length; j++) b[j] *= 2;
    }
}
