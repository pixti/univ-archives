/**
 * [5강 과제] 배열(1) - 5번 문제
 *
 * 0 ~ 19 사이의 난수를 1000 개 생성하여, 가장 많이 발생한 수를 출력하는 프로그램을 작성하시오.
 *
 *   (문제의 예시 화면) 각 수의 발생 횟수를 출력한 뒤 마지막에
 *   0 : 49
 *   ...
 *   6 : 65      ← 가장 많음
 *   ...
 *   최대 발생 수 : 6
 *
 * 📝 필기 (AI 설명) : 핵심은 count 배열입니다
 *   int[] count = new int[20];
 *   배열의 인덱스를 난수 자체로 사용하는 방식입니다. 예를 들어 난수가
 *     3, 7, 3, 15, 7, 3
 *   순서로 나왔다면
 *     count[3]  → 3
 *     count[7]  → 2
 *     count[15] → 1
 *   이 됩니다.
 *   count[num]++;  은  count[num] = count[num] + 1;  과 같습니다.
 *
 * 📝 필기 (AI 설명) : 난수 생성
 *   num = (int) (Math.random() * 20);
 *     Math.random()        : 0.0 이상 1.0 미만
 *     Math.random() * 20   : 0.0 이상 20.0 미만
 *     (int) 형변환          : 0 ~ 19
 *
 * 📝 필기 (AI 설명) : 최대값 찾기
 *   int max = 0;
 *   for (int i = 0; i < 20; i++)
 *       if (count[i] > max) max = count[i];
 *   예를 들어 count[6] 이 65 라면 max 가 65 가 됩니다.
 *
 * 포인트
 *  - 0 ~ 19 의 "값" 을 그대로 배열의 "위치" 로 쓴다. → if 20 개 없이 count[num]++ 한 줄로 센다.
 *    (2번 문제 DaysInMonth 의 "배열을 표로 쓰기" 와 비슷한 발상)
 *  - new int[20] 은 0 으로 채워져 있으므로 세기 전에 초기화할 필요가 없다.
 *
 * ⚠ 문제는 "가장 많이 발생한 수" 를 출력하라고 했고, 예시 화면도 "최대 발생 수 : 6" (= 숫자 6, 65 번) 이다.
 *   내 코드는 최대 "횟수" (max = 65) 를 출력한다. 숫자를 출력하려면 위치도 같이 기억해야 한다.
 *     int max = 0, maxNum = 0;
 *     for (...) if (count[i] > max) { max = count[i]; maxNum = i; }   (5-1 강의 maxPos 와 같은 방식)
 *   → 리팩터링 버전은 "최다 발생 숫자" 를 따로 출력해서 이 문제를 고쳤다.
 * 💡 난수라 실행할 때마다 결과가 다르다. 1000 / 20 = 50 이므로 각 수는 평균 50 번 정도 나온다.
 *
 * 실행 예  (난수라 매번 다름)
 *  0 : 52
 *  1 : 47
 *  ...
 *  19 : 51
 *  최대 발생 수 : 65
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
