/**
 * [5강 실습] 배열(1) - 6번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DuplicateElements {
    public static void main(String[] args) {
        int[] my_arr = {1, 2, 5, 5, 6, 6, 7, 2};
        int cnt = 0;

        for (int i = 0; i < my_arr.length; i++) {
            if (appearedBefore(my_arr, i)) continue;   // 이미 출력한 값이면 건너뜀

            for (int j = i + 1; j < my_arr.length; j++) {
                if (my_arr[i] == my_arr[j]) {
                    cnt++;
                    System.out.println("중복 요소" + cnt + " : " + my_arr[i]);
                    break;
                }
            }
        }

        // 문자열 배열 버전
        String[] words = {"java", "c", "python", "java", "c", "go"};
        System.out.println("--- 문자열 배열 " + java.util.Arrays.toString(words) + " ---");
        cnt = 0;
        for (int i = 0; i < words.length; i++) {
            boolean seen = false;
            for (int k = 0; k < i; k++) {
                if (words[k].equals(words[i])) { seen = true; break; }
            }
            if (seen) continue;

            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {        // 문자열은 equals 로 비교
                    cnt++;
                    System.out.println("중복 요소" + cnt + " : " + words[i]);
                    break;
                }
            }
        }
    }

    /** arr[0] ~ arr[i-1] 중에 arr[i] 와 같은 값이 있는지 */
    static boolean appearedBefore(int[] arr, int i) {
        for (int k = 0; k < i; k++) {
            if (arr[k] == arr[i]) return true;
        }
        return false;
    }
}
