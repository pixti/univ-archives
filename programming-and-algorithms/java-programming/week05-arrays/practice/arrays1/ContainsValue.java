import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 1번 문제 (버전 1 : 인덱스 for)
 *
 * 배열이 특정 값을 포함하는지 테스트하는 프로그램을 작성하시오.
 *   배열 : {1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2265, 1457, 2456}
 *
 *   (예시 출력)
 *   찾고자 하는 값 ? 2456
 *   결과 : True
 *   계속 ? ('y' or 'n')
 *
 * 포인트
 *  - 찾으면 "True" 를 출력하고 break 로 더 이상 찾지 않는다.
 *  - i 를 for 밖에서 선언 → 반복이 끝난 뒤에도 i 를 쓸 수 있다.
 *  - i == my_array.length : break 없이 끝까지 돌았다 = 못 찾았다 → "False"
 *    (4-4 소수 판별의 i == n 과 같은 발상)
 *
 * 💡 int i, n = sc.nextInt(); 는 i 는 선언만, n 은 선언 + 입력값으로 초기화.
 * 💡 같은 문제를 foreach 로 → ContainsValueForEach.java, 반복 질문까지 → ContainsValueRepeat.java
 *
 * 실행 예
 *  찾고자 하는 값 ? 1472
 *  True
 */
public class ContainsValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] my_array = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                     1254, 1472, 2365, 1456, 2265, 1457, 2456};

        System.out.print("찾고자 하는 값 ? ");
        int i, n = sc.nextInt();
        for (i = 0; i < my_array.length; i++) {
            if (my_array[i] == n) {
                System.out.println("True");
                break;
            }
        }
        if (i == my_array.length) {       // 끝까지 돌았다 = 못 찾았다
            System.out.println("False");
        }
        sc.close();
    }
}
