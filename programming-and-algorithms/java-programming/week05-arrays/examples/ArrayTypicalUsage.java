/**
 * [5-1 배열1] 배열의 전형적인 사용 예 (출력 · 합 · 최대값 · 최소값)
 *
 * 전형적인 사용 예를 배워두면 도움이 된다.
 *
 * 포인트
 *  - 반복 조건은 숫자 대신 array.length  (length 는 필드라서 괄호 없음. String 의 length() 와 구분)
 *  - 최대/최소는 첫 원소 array[0] 으로 시작하고 i = 1 부터 비교한다.
 *      4주차 성적 처리처럼 -1, 101 같은 "나올 수 없는 값" 을 몰라도 된다.
 *  - 위치(maxPos, minPos)도 함께 기억하려면 값을 바꿀 때 i 도 같이 저장.
 *  - > (엄격한 비교) 라서 최대값이 여러 개면 가장 앞의 위치가 남는다. (>= 면 가장 뒤)
 *
 * ⚠ 슬라이드는 1. 출력 예에서 println(array[i] + " ") 를 썼다. println 이라 한 줄에 하나씩 찍힌다.
 *   한 줄로 보려고 여기서는 print 로 바꿨다. 슬라이드의 둥근 따옴표 “ ” 도 " " 로 고쳤다.
 *
 * 실행 예
 *  1. 출력 : 1 2 3 4 5
 *  2. 합 : 15
 *  3. 최대 : 5, 최대 위치 : 4
 *  4. 최소 : 1, 최소 위치 : 0
 */
public class ArrayTypicalUsage {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // 1. 출력 예
        System.out.print("1. 출력 : ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();

        // 2. 원소의 합
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println("2. 합 : " + sum);

        // 3. 원소의 최대값 구하기
        int max = array[0], maxPos = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxPos = i;
            }
        }
        System.out.println("3. 최대 : " + max + ", 최대 위치 : " + maxPos);

        // 4. 원소의 최소값 구하기
        int min = array[0], minPos = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minPos = i;
            }
        }
        System.out.println("4. 최소 : " + min + ", 최소 위치 : " + minPos);
    }
}
