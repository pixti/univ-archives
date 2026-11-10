import java.util.Scanner;

/**
 * [4강 실습] 반복문1 - 2번 문제
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * 자동차의 연비를 반복적으로 계산해주는 프로그램을 작성하여 보자.
 *
 * 📝 필기
 *  - 반복 횟수가 일정하지 않으므로 for 보단 while 이 적절하고.
 *    무조건 1번은 실행되므로 do while 이 적절하다.
 *  - } while (cont == 'Y' || cont == 'y');  // True 이면 반복 False 이면 do-while 문 빠져나옴.
 *
 * 포인트
 *  - 연비 = 주행 거리 / 연료의 양 (km/l)
 *  - distance / (double) fuel : 둘 다 int 라서 형변환하지 않으면 정수 나눗셈이 된다.
 *    (예 : 100 / 30 = 3, 소수점 버림)
 *  - 대문자 'Y' 와 소문자 'y' 를 모두 받기 위해 || 로 묶었다.
 *  💡 do-while 이라 cont 를 미리 초기화할 필요가 없다 (4-2 강의 내용).
 *
 * 💡 fuel 에 0 을 넣으면 distance / 0.0 = Infinity 가 출력된다. (실수 나눗셈은 예외 대신 Infinity)
 *
 * 문제의 실행 예
 *  연료의 양을 입력하시오(l) : 10
 *  주행한 거리를 입력하세요(km) : 100
 *  연비는  10km/l 입니다.
 *  다시 계산하겠습니까?(Y/N) : N
 *
 * 내 코드 실행 예
 *  연료의 양 ? 10
 *  주행한 거리 ? 5000
 *  연비는 500.0 입니다.
 *  계속 진행 ? (Y/N) : n
 *  프로그램 종료
 */
public class FuelEfficiency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fuel, distance; double ratio; char cont;
        do {
            System.out.print("연료의 양 ? ");
            fuel = sc.nextInt();
            System.out.print("주행한 거리 ? ");
            distance = sc.nextInt();
            ratio = distance / (double) fuel;
            System.out.println("연비는 " + ratio + " 입니다.");

            System.out.print("계속 진행 ? (Y/N) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'Y' || cont == 'y');   // True이면 반복 False이면 do-while문 빠져나옴.
        System.out.println("프로그램 종료");
        sc.close();
    }
}
