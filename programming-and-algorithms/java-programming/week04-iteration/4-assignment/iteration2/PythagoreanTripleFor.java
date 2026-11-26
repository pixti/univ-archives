/**
 * [4강 과제] 반복문2 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PythagoreanTripleFor {
    public static void main(String[] args) {

        int a, b, c, count = 0;
        for (c = 1; c <= 100; c++) {            // c가 1~100까지 반복
            for (a = 1; a < c; a++) {           // a가 1~c-1까지 반복
                for (b = 1; b < c; b++) {       // b가 1~c-1까지 반복
                    if (a * a + b * b == c * c) {
                        System.out.println(c + " : " + a + " : " + b);
                        count++;
                    }
                }
            }
        }
        System.out.println("총 " + count + "개");
    }
}
