import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 1번 문제 (버전 3 : do-while 로 반복)
 *
 * 배열이 특정 값을 포함하는지 테스트하고, "계속 ? ('y' or 'n')" 으로 반복한다.
 *
 * 포인트
 *  - 최소 1 번은 찾아야 하므로 do-while (4-2).
 *  - flag = false; 를 do 블록 "안" 에서 매번 다시 해 주는 것이 중요.
 *    밖에서 한 번만 하면, 한 번 True 가 나온 뒤로는 계속 true 로 남아 "False" 가 영영 안 나온다.
 *    (4주차 Pyramid 의 col = 0; , NumberGuessingRepeat 의 cont = true; 와 같은 이야기)
 *  - sc.next().charAt(0) : 단어 하나를 읽어 첫 글자만 char 로.
 *
 * ⚠ 원래 코드에는 sc.close(); 가 없어서 마지막에 추가했다.
 * 💡 'Y' 대문자도 받으려면 while (cont == 'y' || cont == 'Y')  (3번 문제 RemoveElement 처럼)
 *
 * 실행 예
 *  찾고자 하는 값 ? 2546
 *  False
 *  계속 하시겠습니까? (y/n) : y
 *  찾고자 하는 값 ? 1254
 *  True
 *  계속 하시겠습니까? (y/n) : n
 */
public class ContainsValueRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] my_array = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                     1254, 1472, 2365, 1456, 2265, 1457, 2456};
        int n;
        boolean flag;
        char cont;

        do {
            System.out.print("찾고자 하는 값 ? ");
            n = sc.nextInt();
            flag = false;                  // 매번 다시 초기화
            for (int e : my_array) {
                if (e == n) {
                    System.out.println("True");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("False");
            }
            System.out.print("계속 하시겠습니까? (y/n) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y');

        sc.close();                        // ⚠ 원래 코드에는 없음
    }
}
