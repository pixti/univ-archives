/**
 * [4-4 반복문4] 이중 for 문 - 별 찍기 (사각형, 삼각형)
 *
 * 이중 for 문 : for 문 안에 또 다른 for 문이 중첩되어 있는 형태
 *
 * 이중 반복문 읽는 법
 *  - 바깥 반복 = 행(row), 안쪽 반복 = 열(column)
 *  - 바깥이 한 번 돌 때 안쪽은 처음부터 끝까지 다 돈다. 5×5 면 print("*") 가 25번.
 *  - 안쪽 for 가 끝난 뒤 println 으로 줄을 바꾼다.
 *  - 삼각형 : 안쪽 조건이 바깥 변수(r)에 따라 달라진다. r행에는 r+1 개의 별.
 *
 * ⚠ 슬라이드의 for(c=0; c < (r+1)) ; c++) 는 괄호가 하나 더 있어 컴파일 에러 → c < (r + 1) 로 수정.
 *
 * 📝 필기 (퀴즈 1-③)
 *   for (x = 0; x < 3; x++) { for (y = 0; y <= 2; y++) System.out.println(x); System.out.println(); }
 *   바깥 x는 0 → 1 → 2  안쪽 y는 매번 0 → 1 → 2.
 *   정답은 000(줄바꿈)111(줄바꿈)222(줄바꿈). 따라서 오답.
 *   ⚠ 정확히는 안쪽이 println(x) 라서 숫자마다 줄이 바뀐다 → 퀴즈 파일(IterationQuiz.q1) 참고.
 *
 * 실행 예
 *  === 결과 ===
 *  *****
 *  *****
 *  *****
 *  *****
 *  *****
 *  === 결과 ===
 *  *
 *  **
 *  ***
 *  ****
 *  *****
 */
public class StarPattern {
    public static void main(String[] args) {
        int r, c;

        System.out.println("=== 결과 ===");
        for (r = 0; r < 5; r++) {
            for (c = 0; c < 5; c++)
                System.out.print("*");
            System.out.println("");
        }

        System.out.println("=== 결과 ===");
        for (r = 0; r < 5; r++) {
            for (c = 0; c < (r + 1); c++)   // ⚠ 수정 : c < (r+1)) → c < (r + 1)
                System.out.print("*");
            System.out.println("");
        }
    }
}
