import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * [5강 실습] 배열(1) - 2번 문제
 *
 * 배열 요소의 인덱스를 찾는 프로그램을 작성하시오. OptionalInt 를 사용해서도 작성해 보시오.
 * (isPresent(), getAsInt() 메소드 사용)
 *   배열 : {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}
 *
 *   (예시 출력)
 *   찾고자 하는 값 ? 25
 *   인덱스 : 0
 *   ...
 *   찾고자 하는 값 ? 29
 *   인덱스 : 8
 *
 * 📝 필기 : 수업시간에는 패스
 *
 * 💡 수업에서 넘어간 문제라 직접 작성한 코드는 없다. 아래는 참고용 풀이.
 *
 * 방법 1) 인덱스 for
 *   - 1번 문제와 같지만 "찾았다" 대신 "어디서 찾았는지(i)" 를 출력한다.
 *   - 그래서 foreach 가 아니라 인덱스 for 를 써야 한다. (foreach 에는 i 가 없다)
 *   - 56 처럼 같은 값이 여러 번 있으면 break 때문에 첫 위치(2)만 나온다.
 *   - 못 찾으면 -1 : 인덱스로 나올 수 없는 값이라 "없음" 표시로 흔히 쓴다. (binarySearch 의 음수와 같은 발상)
 *
 * 방법 2) OptionalInt
 *   - OptionalInt 는 "int 값이 있을 수도, 없을 수도 있다" 를 담는 상자다.
 *     -1 같은 약속 대신 isPresent() 로 값이 있는지 묻고, getAsInt() 로 꺼낸다.
 *   - IntStream.range(0, arr.length) : 0, 1, ..., length-1 (인덱스들의 흐름)
 *     .filter(i -> arr[i] == n)      : 그중 값이 n 인 인덱스만 남김
 *     .findFirst()                   : 첫 번째 것을 OptionalInt 로 (없으면 비어 있는 OptionalInt)
 *   - 💡 람다(i -> ...)와 스트림은 이후에 배우는 내용이다. 여기서는 "이런 식으로도 쓴다" 정도로만.
 *   - 💡 값이 없는 OptionalInt 에 getAsInt() 를 부르면 NoSuchElementException. 꼭 isPresent() 먼저.
 *
 * 💡 binarySearch 는 정렬이 필요해서 원래 위치를 잃어버린다. 원래 배열의 인덱스를 찾을 때는 쓸 수 없다.
 *
 * 실행 예
 *  찾고자 하는 값 ? 25
 *  인덱스 : 0
 *  OptionalInt 인덱스 : 0
 *  계속 ? ('y' or 'n') y
 *  찾고자 하는 값 ? 29
 *  인덱스 : 8
 *  OptionalInt 인덱스 : 8
 *  계속 ? ('y' or 'n') y
 *  찾고자 하는 값 ? 100
 *  인덱스 : -1 (배열에 없음)
 *  OptionalInt : 값 없음
 *  계속 ? ('y' or 'n') n
 */
public class FindIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        char cont;

        do {
            System.out.print("찾고자 하는 값 ? ");
            int n = sc.nextInt();

            // 방법 1) 인덱스 for
            int index = -1;                       // 못 찾으면 -1
            for (int i = 0; i < my_arr.length; i++) {
                if (my_arr[i] == n) {
                    index = i;
                    break;                        // 첫 위치만
                }
            }
            if (index != -1) System.out.println("인덱스 : " + index);
            else             System.out.println("인덱스 : -1 (배열에 없음)");

            // 방법 2) OptionalInt
            OptionalInt found = IntStream.range(0, my_arr.length)
                                         .filter(i -> my_arr[i] == n)
                                         .findFirst();
            if (found.isPresent()) System.out.println("OptionalInt 인덱스 : " + found.getAsInt());
            else                   System.out.println("OptionalInt : 값 없음");

            System.out.print("계속 ? ('y' or 'n') ");
            cont = sc.next().charAt(0);
        } while (cont == 'y');
        sc.close();
    }
}
