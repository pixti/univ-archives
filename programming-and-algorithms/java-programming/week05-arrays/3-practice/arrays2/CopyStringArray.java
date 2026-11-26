import java.util.Arrays;

/**
 * [5강 실습] 배열(2) - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
