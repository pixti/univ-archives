/**
 * [5강 과제] 배열(1) - 5번 문제 (리팩터링 버전)
 *
 * RandomFrequency.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 숫자 20, 1000 → 상수 VALUE_COUNT, GENERATION_COUNT  (1_000 : 숫자 사이의 _ 는 읽기 쉽게 하는 구분자)
 *  - 변수 이름 count, num, max → frequencies, value, maxFrequency
 *  - 출력과 최대값 찾기를 반복문 하나로 합침 : Math.max(maxFrequency, frequencies[value])
 *  - "최다 발생 숫자" 출력 추가 : 최대 빈도와 같은 숫자를 모두 출력한다.
 *    → 원래 코드의 ⚠ (숫자가 아니라 횟수를 출력) 를 고쳤다. 동점인 숫자가 여러 개여도 모두 나온다.
 *
 * 💡 Math.max(a, b) : 둘 중 큰 값. if (b > a) a = b; 와 같은 일을 한 줄로.
 * 💡 "최대 발생 수" 라는 문구는 그대로 횟수를 뜻한다. 문제의 예시 화면과는 뜻이 다르다.
 *
 * 실행 예  (난수라 매번 다름)
 *  0 : 48
 *  ...
 *  19 : 55
 *  최대 발생 수: 61
 *  최다 발생 숫자: 8
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
