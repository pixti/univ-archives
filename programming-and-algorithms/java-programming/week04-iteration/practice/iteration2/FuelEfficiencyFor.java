import java.util.Scanner;

/**
 * [4강 실습] 반복문2 - 2번 문제
 * ※ 반복 시 for 문만 사용하시오.
 *
 * 자동차의 연비를 반복적으로 계산해주는 프로그램을 작성하여 보자.
 *
 * 포인트
 *  - for (; 조건; ) : 초기화와 증가식을 비우면 while (조건) 과 똑같다.
 *  - 반복문1-2 (do-while) 와 달리 for 는 조건을 "먼저" 검사한다.
 *    → 반복문 들어가기 전에 cont 를 미리 입력받아야 한다. (4-2 의 cont 초기화 비교 표 참고)
 *    → 그래서 시작하자마자 "계속 (y or n) ?" 을 묻는다. 처음에 n 을 넣으면 한 번도 계산하지 않는다.
 *  - 계속 여부를 묻는 코드가 for 앞과 본문 끝, 두 군데에 들어간다.
 *    (do-while 이 "적어도 한 번 실행" 하는 문제에 더 잘 맞는 이유)
 *
 * 💡 "계속 묻기" 를 for 의 세 칸에 다 넣을 수도 있다. (반복문2-1 과 같은 방식)
 *      for (System.out.print("계속 (y or n) ? "), cont = sc.next().charAt(0);
 *           cont == 'y' || cont == 'Y';
 *           System.out.print("계속 (y or n) ? "), cont = sc.next().charAt(0)) { ... }
 *    짧아지기는 하지만 읽기는 더 어렵다.
 *
 * 💡 실행 예 첫 번째 계산의 0.04285714285714286 은 주행 거리 30, 연료량 700 을 넣은 결과.
 *    (30 / 700. 입력 순서가 반복문1-2 와 반대 : 여기서는 주행 거리를 먼저 묻는다)
 *
 * 문제의 실행 예
 *  연료의 양을 입력하시오(l) : 10
 *  주행한 거리를 입력하세요(km) : 100
 *  연비는  10km/l 입니다.
 *  다시 계산하겠습니까?(Y/N) : N
 *
 * 내 코드 실행 예
 *  계속 (y or n) ? y
 *  주행 거리 ? 30
 *  연료량 ? 700
 *  연비 : 0.04285714285714286
 *  계속 (y or n) ? y
 *  주행 거리 ? 40
 *  연료량 ? 20
 *  연비 : 2.0
 *  계속 (y or n) ? n
 */
public class FuelEfficiencyFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char cont; int dist, fuel; double ratio;
        System.out.print("계속 (y or n) ? "); cont = sc.next().charAt(0);

        for (; cont == 'y' || cont == 'Y'; ) {      // 초기화, 증가식 생략 → while (cont == 'y' || cont == 'Y') 과 같다
            System.out.print("주행 거리 ? ");
            dist = sc.nextInt();
            System.out.print("연료량 ? ");
            fuel = sc.nextInt();
            ratio = dist / (double) fuel;
            System.out.println("연비 : " + ratio);

            System.out.print("계속 (y or n) ? ");
            cont = sc.next().charAt(0);
        }
        sc.close();
    }
}
