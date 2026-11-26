/**
 * [4강 과제] 반복문1 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PythagoreanTriple {
    public static void main(String[] args) {

        int a, b, c = 1, count = 0;
        while (c <= 100) {          // c가 1~100 까지 반복
            a = 1;
            while (a < c) {         // a가 1~c-1까지 반복
                b = 1;
                while (b < c) {     // b가 1~c-1까지 반복
                    if (a * a + b * b == c * c) { System.out.println(c + " : " + a + " : " + b); count++; }
                    b++;
                }
                a++;
            }
            c++;
        }
        System.out.println("총 " + count + "개");
    }
}
