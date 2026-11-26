/**
 * [4-4 반복문4] foreach 문 / [실습] 학생 성적 처리하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
