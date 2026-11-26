/**
 * [5강 과제] 배열(1) - 5번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RandomFrequency {
    public static void main(String[] args) {
        int[] count = new int[20];
        int num;
        int max = 0;

        // 0부터 19까지의 난수를 1000번 생성
        for (int i = 0; i < 1000; i++) {
            num = (int) (Math.random() * 20);
            count[num]++;
        }

        // 각 숫자가 나온 횟수 출력
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " : " + count[i]);
        }

        // 가장 많이 발생한 횟수 찾기
        for (int i = 0; i < 20; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        System.out.println("최대 발생 수 : " + max);
    }
}
