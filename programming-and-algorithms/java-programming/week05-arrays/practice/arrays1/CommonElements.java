/**
 * [5강 실습] 배열(1) - 5번 문제
 *
 * 두 배열 사이에 공통 요소를 찾는 프로그램을 작성하시오.
 *   Array1 : [1, 2, 5, 5, 8, 9, 7, 10]
 *   Array2 : [1, 0, 6, 15, 6, 4, 7, 0]
 *
 *   (예시 출력)
 *   공통요소1 : 1
 *   공통요소2 : 7
 *
 * 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.
 *
 * 포인트
 *  - 이중 for : arr1 의 원소 하나(i)마다 arr2 전체(j)를 훑어서 같은 값이 있는지 본다.
 *  - 찾으면 break : 같은 값이 arr2 에 여러 번 있어도 한 번만 센다.
 *  - arr1 에 같은 값이 여러 번 있으면(5, 5) 공통요소가 중복으로 찍힐 수 있다.
 *    → "앞에서 이미 나온 값인지" 를 먼저 검사해서 건너뛴다. (6번 중복 요소 문제와 같은 발상)
 *    이 예제에서는 5 가 arr2 에 없어서 티가 나지 않지만, arr2 에 5 가 있었다면 두 번 찍혔을 것이다.
 *  - 공통요소 번호(cnt)는 찾을 때마다 1 씩 증가.
 *
 * 💡 비교 횟수는 최대 8 × 8 = 64 번. 배열이 커지면 정렬 후 비교하거나 Set 을 쓰는 방법이 빠르다.
 *
 * 실행 예
 *  공통요소1 : 1
 *  공통요소2 : 7
 */
public class CommonElements {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] arr2 = {1, 0, 6, 15, 6, 4, 7, 0};
        int cnt = 0;

        for (int i = 0; i < arr1.length; i++) {
            // arr1 앞쪽에 같은 값이 이미 있었으면 건너뜀 (중복 출력 방지)
            boolean seen = false;
            for (int k = 0; k < i; k++) {
                if (arr1[k] == arr1[i]) {
                    seen = true;
                    break;
                }
            }
            if (seen) continue;

            // arr2 에 같은 값이 있는지
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    cnt++;
                    System.out.println("공통요소" + cnt + " : " + arr1[i]);
                    break;
                }
            }
        }
    }
}
