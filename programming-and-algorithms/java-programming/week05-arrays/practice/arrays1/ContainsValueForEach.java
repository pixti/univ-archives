import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 1번 문제 (버전 2 : for each + flag)
 *
 * 배열이 특정 값을 포함하는지 테스트하는 프로그램을 작성하시오.
 *
 * 📝 필기 : for each 문 ★) 시험 출제 예상 1
 *
 * 포인트
 *  - for (int e : my_array) : 인덱스 없이 원소를 하나씩 e 에 꺼낸다.
 *  - foreach 에는 i 가 없어서 버전 1 처럼 "i == length 면 못 찾음" 으로 판단할 수 없다.
 *    → boolean flag 로 "찾았는지" 를 따로 기억한다.
 *      flag = false 로 시작 → 찾으면 true 로 바꾸고 break → 끝난 뒤 flag 가 false 면 못 찾은 것.
 *
 * 💡 if (flag == false) 는 if (!flag) 와 같다.
 * 💡 foreach 는 "읽기" 전용으로 생각하자. e 에 값을 대입해도 배열 원소는 바뀌지 않는다.
 *    (e 는 원소의 복사본)  위치(인덱스)가 필요하면 인덱스 for 를 써야 한다. (2번 문제)
 *
 * 실행 예
 *  찾고자 하는 값 ? 2456
 *  True
 */
public class ContainsValueForEach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] my_array = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                     1254, 1472, 2365, 1456, 2265, 1457, 2456};

        System.out.print("찾고자 하는 값 ? ");
        int n = sc.nextInt();
        boolean flag = false;
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
        sc.close();
    }
}
