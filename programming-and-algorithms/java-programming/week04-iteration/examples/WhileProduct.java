/**
 * [4-1 반복문1] while 문 - 1 ~ 5까지의 곱
 *
 *   (i : 1)  sum = sum * i;   → 1
 *   (i : 2)  sum = sum * i;   → 2
 *   (i : 3)  sum = sum * i;   → 6
 *   (i : 4)  sum = sum * i;   → 24
 *   (i : 5)  sum = sum * i;   → 120
 *
 * 💡 곱을 구할 때는 1 (곱셈의 항등원)로 초기화한다. 0 으로 시작하면 무엇을 곱해도 0.
 *    → 퀴즈 3번 (Σ → sum = 0, Π → prod = 1)
 *
 * ⚠ 자주 틀리는 부분: 자바는 대소문자를 구분한다.
 *   While( I <= 5) 처럼 쓰면 While (키워드 아님), I (선언 안 된 변수) 때문에 컴파일 에러.
 * 💡 변수 이름은 sum 이지만 실제로는 곱을 담는다. 직접 짤 때는 prod 처럼 의미에 맞는 이름이 좋다.
 *   출력도 "합 : " 이 아니라 "곱 : " 이어야 한다.
 *
 * 실행 예
 *  곱 : 120
 */
public class WhileProduct {
    public static void main(String[] args) {
        int i = 1, sum = 1;     // 곱이므로 1 로 초기화
        while (i <= 5) {        // while (i < 6) {
            sum = sum * i;
            i++;
        }
        System.out.println("곱 : " + sum);
    }
}
