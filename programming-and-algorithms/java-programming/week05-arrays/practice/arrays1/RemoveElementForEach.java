import java.util.Arrays;
import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 3번 문제 (버전 2 : for each 문으로)
 *
 * 📝 필기 : for each 문으로
 *
 * 버전 1 (RemoveElement.java) 과 같고, 개수 세기와 복사하는 반복문을 foreach 로 바꿨다.
 *
 * 포인트
 *  - 원래 배열을 "읽기만" 하는 곳은 foreach 로 바꿀 수 있다.
 *      for (int e : my_arr) { if (e != n) { tmp[j] = e; j++; } }
 *  - 새 배열 tmp 에 "쓰는" 위치 j 는 여전히 직접 관리해야 한다.
 *    foreach 는 읽는 배열의 위치만 대신 관리해 줄 뿐이다.
 *
 * 💡 PDF 의 코드는 복사하는 반복문만 foreach 로 바꿨다. 개수를 세는 반복도 읽기만 하므로
 *    똑같이 foreach 로 바꿀 수 있어서 함께 바꿨다.
 *
 * 실행 예
 *  변경 전 배열 :
 *  [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
 *  제거 값 ? 49
 *  변경 후 배열 :
 *  [25, 14, 56, 15, 36, 56, 77, 18, 29]
 *  계속하시겠습니까? (y/n) : n
 *  프로그램을 종료합니다.
 */
public class RemoveElementForEach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        char cont;
        int n, cnt, j;

        do {
            System.out.println("변경 전 배열 : ");
            System.out.println(Arrays.toString(my_arr));

            System.out.print("제거 값 ? ");
            n = sc.nextInt();
            cnt = 0;

            // 제거할 값의 개수 카운트
            for (int e : my_arr) {
                if (e == n) {
                    cnt++;
                }
            }

            // 값이 존재하는 경우 새로운 배열 생성 및 복사
            if (cnt != 0) {
                int[] tmp = new int[my_arr.length - cnt];
                j = 0;
                for (int e : my_arr) {
                    if (e != n) {
                        tmp[j] = e;
                        j++;
                    }
                }
                my_arr = tmp;   // 변경된 배열 업데이트
            } else {
                System.out.println("배열에 해당 값이 존재하지 않습니다.");
            }

            System.out.println("변경 후 배열 : ");
            System.out.println(Arrays.toString(my_arr));

            // 계속 진행할지 여부 입력받기
            System.out.print("계속하시겠습니까? (y/n) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y' || cont == 'Y');

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
