/**
 * [5강 과제] 배열(1) - 5번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RandomFrequencyRefactored {

    private static final int VALUE_COUNT = 20;
    private static final int GENERATION_COUNT = 1_000;

    public static void main(String[] args) {
        int[] frequencies = new int[VALUE_COUNT];

        // 0부터 VALUE_COUNT - 1까지의 정수를 무작위로 생성해 빈도를 셉니다.
        for (int generated = 0; generated < GENERATION_COUNT; generated++) {
            int value = (int) (Math.random() * VALUE_COUNT);
            frequencies[value]++;
        }

        int maxFrequency = 0;

        // 각 숫자의 빈도를 출력하고 최댓값을 찾습니다.
        for (int value = 0; value < frequencies.length; value++) {
            System.out.println(value + " : " + frequencies[value]);
            maxFrequency = Math.max(maxFrequency, frequencies[value]);
        }

        System.out.println("최대 발생 수: " + maxFrequency);

        // 최댓값과 같은 빈도를 가진 숫자를 모두 출력합니다.
        System.out.print("최다 발생 숫자: ");
        for (int value = 0; value < frequencies.length; value++) {
            if (frequencies[value] == maxFrequency) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }
}
