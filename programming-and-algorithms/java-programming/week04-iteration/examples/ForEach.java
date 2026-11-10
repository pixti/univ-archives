/**
 * [4-4 반복문4] foreach 문 / [실습] 학생 성적 처리하기
 *
 * foreach 문
 *  - 배열이나 컬렉션에 있는 모든 요소에 대해 반복하는 문장
 *  - 인덱스를 사용하여 직접 접근 X
 *  - 배열 요소의 개수에 딱 맞게 루프를 돌리는 작업
 *
 *    for (자료형 변수 : 배열 또는 컬렉션)        (Python)  for number in array :
 *
 *                 foreach                       일반 for
 *   형식          for (int number : array)      for (int i = 0; i < array.length; i++)
 *   요소 접근     number                        array[i]
 *   인덱스        없음                          i
 *   값 바꾸기     불가 (복사본)                 가능 (array[i] = 0)
 *
 *  - array.length : 배열의 요소 개수 (여기서는 7). 인덱스는 0 ~ length-1. (배열은 5주차)
 *  - 인덱스가 필요하거나, 값을 바꾸거나, 거꾸로 돌 때는 일반 for 를 쓴다.
 *
 * ⚠ 슬라이드는 두 번째 반복(foreach 를 for 문으로) 전에 total 을 0 으로 되돌리지 않는다.
 *   → 두 번째 출력이 521 이 아니라 1042. total = 0; 을 추가했다.
 *
 * [실습] 학생 성적 처리하기
 *  - 4-1 "성적 처리"(while) 와 같은 문제. 이번엔 입력 대신 배열의 값을 foreach 로 돈다.
 *  - max 는 0, min 은 100 으로 시작 → 첫 요소가 무조건 max, min 을 갱신.
 *    (4-1 에서는 -1, 101. 둘 다 "나올 수 있는 값의 바깥" 이라 결과는 같다)
 *  - ((double) sum) / array.length : sum 을 double 로 바꾼 뒤 나눠서 실수 결과.
 *
 * 실행 예
 *  521
 *  521
 *  평균 : 74.42857142857143
 *  최고 : 99
 *  최저 : 44
 */
public class ForEach {
    public static void main(String[] args) {
        // ===== foreach 문 =====
        int[] array = {88, 67, 56, 77, 99, 90, 44};
        int total = 0;
        for (int number : array)    // foreach : for(자료형 변수 : 배열 또는 컬렉션)
            total += number;
        System.out.println(total);

        // foreach를 for문으로
        total = 0;                  // ⚠ 추가
        for (int counter = 0; counter < array.length; counter++)
            total += array[counter];
        System.out.println(total);

        // ===== [실습] 학생 성적 처리하기 =====
        double avg;
        int max = 0, min = 100, sum = 0;

        for (int number : array) {
            sum += number;
            if (number > max) max = number;
            if (number < min) min = number;
        }
        avg = ((double) sum) / array.length;
        System.out.println("평균 : " + avg);
        System.out.println("최고 : " + max);
        System.out.println("최저 : " + min);
    }
}
