/**
 * [4강 실습] 반복문2 - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PyramidFor {
    public static void main(String[] args) {
        pyramid();
        System.out.println();
        twinPyramid();
    }

    // 실습 4번 : 피라미드 하나
    static void pyramid() {
        int start = 3, end = 3;
        for (int r = 0; r <= 3; r++) {          // 행 : 0 ~ 3
            for (int c = 0; c <= 6; c++) {      // 열 : 0 ~ 6 (행이 바뀔 때마다 c = 0 부터 다시)
                if (start <= c && c <= end) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
            start--; end++;
        }
    }

    // 📝 확장 : 피라미드 두 개
    static void twinPyramid() {
        int start1 = 3, end1 = 3, start2 = 11, end2 = 11;
        for (int r = 0; r <= 3; r++) {
            for (int c = 0; c <= 14; c++) {
                if (start1 <= c && c <= end1) System.out.print("*");
                else if (start2 <= c && c <= end2) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
            start1--; end1++; start2--; end2++;
        }
    }
}
