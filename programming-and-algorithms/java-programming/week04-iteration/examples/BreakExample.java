/**
 * [4-4 반복문4] break 문
 *
 * 반복문 사용시 특정 조건을 만족하여 더 이상 반복하지 않을 때 사용.
 *
 * 포인트
 *  - break 는 가장 가까운(자신을 감싼) 반복문 "하나" 만 빠져나온다.
 *    이중 반복문 안쪽에서 break 하면 바깥 반복은 계속된다 → PrimesBelowN.java
 *  - break 로 빠져나오면 증감식(r++)도 실행되지 않는다 → r 은 4 가 아니라 3.
 *  - 3주차 switch 의 break 와 같은 키워드. switch 안에서는 switch 를, 반복문 안에서는 반복문을 빠져나온다.
 *
 * 📝 필기 (퀴즈 1-④)
 *   x = 0; for (;;) { if (x > 10) break; System.out.print(x + " "); x++; }
 *   정답은 0 1 2 3 4 5 6 7 8 9 10 . 따라서 오답.
 *   💡 break 검사가 출력보다 "앞에" 있다. x 가 11 이 되는 순간 출력 전에 빠져나오므로 10 까지 출력.
 *
 * 실행 예
 *  0 1 2
 *  break 후 r = 3
 */
public class BreakExample {
    public static void main(String[] args) {
        int r;
        for (r = 0; r < 10; r++) {
            if (r == 3)
                break;
            System.out.print(r + " ");
        }
        System.out.println();
        System.out.println("break 후 r = " + r);
    }
}
