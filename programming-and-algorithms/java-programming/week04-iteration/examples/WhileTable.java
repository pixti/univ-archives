/**
 * [4-1 반복문1] while 문 - 1 / 10 / 100 표 출력
 *
 * while 문
 *  - while 문과 for 문은 표현력이 동일하다.
 *  - 조건식을 검사하여 true 이면 블록 내 문장을 실행하고, 다시 조건식을 검사한다.
 *
 *    while (조건식) {          (Python)  while 조건식 :
 *        ...                                 ...
 *    }
 *
 *    while (true) {   // 의도적인 무한루프
 *        ...
 *    }
 *
 * 반복할 때마다 i 가 1 → 5 로 바뀌면서 "같은 문장" 이 실행된다.
 *   (i : 1)   i   i*10   i*100
 *   (i : 2)   i   i*10   i*100
 *   ...
 *   (i : 5)   i   i*10   i*100
 *   (i : 6)   조건 6 <= 5 거짓 → 종료
 *
 * 💡 i++ 를 빼먹으면 i 가 계속 1 이라 조건이 항상 참 → 실수로 무한루프가 된다.
 *
 * 실행 예
 *  1 10 100
 *  2 20 200
 *  3 30 300
 *  4 40 400
 *  5 50 500
 */
public class WhileTable {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println(i + " " + i * 10 + " " + i * 100);
            i++;
        }
    }
}
