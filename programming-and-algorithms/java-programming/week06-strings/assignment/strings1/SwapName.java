import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 2번 문제
 *
 * "성 이름" 형식으로 대문자 이름을 입력받아, 소문자로 바꾸고 "이름 성" 순서로 출력하시오.
 *      HONG GIL DONG         → gil dong hong
 *      KIM BYEONGMAN         → byeongman kim
 *      LEE MAXIM GOLDEN BAR  → maxim golden bar lee
 *
 * 포인트
 *  - input.trim().toLowerCase().split("\\s+") : 앞뒤 공백 제거 → 소문자 → 공백 덩어리로 자르기
 *  - 성(LastName) 은 첫 번째 단어 (parts[0])
 *    이름(FirstName) 은 두 번째 단어부터 마지막 단어까지 (parts[1] ~ parts[length-1])
 *  - 이름을 먼저 공백과 함께 출력하고, 마지막에 성을 println
 *
 * 💡 parts.length > 0 검사는 사실 항상 참이다. ("".split(...) 도 길이 1 짜리 [""] 를 반환)
 *    입력이 비었는지 검사하려면 input.trim().isEmpty() 로 확인하는 편이 정확하다.
 * 💡 이름이 한 단어뿐이면 (예: "KIM") 반복문이 돌지 않고 "kim" 만 출력된다.
 *
 * 실행 예
 *  이름을 입력하세요(성 이름)(ex : HONG GIL DONG) : PARK JAE HYEONG
 *  jae hyeong park
 *
 *  이름을 입력하세요(성 이름)(ex : HONG GIL DONG) : LEE MAXIM GOLDEN BAR
 *  maxim golden bar lee
 */
public class SwapName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요(성 이름)(ex : HONG GIL DONG) : ");
        String input = sc.nextLine();

        String[] parts = input.trim().toLowerCase().split("\\s+");

        if (parts.length > 0) {
            // 이름(FirstName)은 두 번째 단어부터 마지막 단어까지 (parts[1] ~ parts[length-1])
            for (int i = 1; i < parts.length; i++) {
                System.out.print(parts[i] + " ");
            }
            // 성(LastName)은 첫 번째 단어 (parts[0])
            System.out.println(parts[0]);
        }
        sc.close();
    }
}
