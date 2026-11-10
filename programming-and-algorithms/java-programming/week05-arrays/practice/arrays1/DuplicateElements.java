/**
 * [5강 실습] 배열(1) - 6번 문제
 *
 * 정수 배열의 중복 값을 찾는 프로그램을 작성하시오. (문자열 배열도 따로 작성해 보시오.)
 *   배열 : [1, 2, 5, 5, 6, 6, 7, 2]
 *
 *   (예시 출력)
 *   중복 요소1 : 2
 *   중복 요소2 : 5
 *   중복 요소3 : 6
 *
 * 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.
 *
 * 포인트
 *  - 이중 for : i 번째 값과 i 뒤(j = i + 1 ~)의 값들을 비교. 같은 값이 있으면 i 번째는 중복 요소.
 *    j 를 i + 1 부터 시작하면 (i, j) 쌍을 한 번씩만 비교한다. (자기 자신과 비교하지 않음)
 *  - 같은 값이 3 번 이상 나오면 여러 번 찍힐 수 있다.
 *    → i 앞쪽에 같은 값이 있었으면 "이미 출력한 값" 이므로 건너뛴다.
 *  - 문자열은 == 가 아니라 equals() 로 비교한다.
 *    == 는 "같은 객체인지(레퍼런스)" 를 비교하고, equals() 는 "내용이 같은지" 를 비교한다.
 *    (4주차 가위바위보 과제의 equals, 5-3 강의의 레퍼런스 이야기와 연결)
 *
 * 💡 예시 출력은 2, 5, 6 순서다. 2 는 1번 · 7번 위치에 있는데, "처음 나온 위치" 순서로 찍으면 2 → 5 → 6.
 * 💡 문자열 배열 예시는 문제에 없어서 직접 만들었다.
 *
 * 실행 예
 *  중복 요소1 : 2
 *  중복 요소2 : 5
 *  중복 요소3 : 6
 *  --- 문자열 배열 [java, c, python, java, c, go] ---
 *  중복 요소1 : java
 *  중복 요소2 : c
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
