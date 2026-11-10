import java.util.Arrays;

/**
 * [5강 실습] 배열(2) - 2번 문제
 *
 * 문자열 배열을 다른 배열로 복사하는 프로그램을 작성하시오.
 *   배열 : ["aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj"]
 *
 *   (예시 출력)
 *   복사 배열 : [aa, bb, cc, dd, ee, ff, gg, hh, ii, jj]
 *
 * 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.
 *
 * 포인트
 *  - 1번(int 배열)과 같은 방법. 타입만 String[] 이다.
 *  - 문자열 배열은 레퍼런스형 배열이다. 복사되는 것은 각 문자열 객체의 "레퍼런스" 다.
 *    (5-1 강의 "레퍼런스형 배열") → 원본과 복사본이 같은 문자열 객체를 가리킨다.
 *  - 그래도 문제가 없는 이유 : String 은 내용을 바꿀 수 없는 객체(immutable)다.
 *    my_arr[0] = "zz"; 는 "aa" 객체를 고치는 것이 아니라 0번 칸이 새 객체 "zz" 를 가리키게 하는 것.
 *    → 복사본의 0번 칸은 여전히 "aa".
 *
 * 실행 예
 *  원본 배열 : [aa, bb, cc, dd, ee, ff, gg, hh, ii, jj]
 *  복사 배열 : [aa, bb, cc, dd, ee, ff, gg, hh, ii, jj]
 *  원본 my_arr[0] = "zz" 로 바꾼 뒤 복사 배열 : [aa, bb, cc, dd, ee, ff, gg, hh, ii, jj]
 */
public class CopyStringArray {
    public static void main(String[] args) {
        String[] my_arr = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj"};
        String[] copy = new String[my_arr.length];    // 처음에는 모두 null

        for (int i = 0; i < my_arr.length; i++) {
            copy[i] = my_arr[i];
        }

        System.out.println("원본 배열 : " + Arrays.toString(my_arr));
        System.out.println("복사 배열 : " + Arrays.toString(copy));

        my_arr[0] = "zz";
        System.out.println("원본 my_arr[0] = \"zz\" 로 바꾼 뒤 복사 배열 : " + Arrays.toString(copy));
    }
}
