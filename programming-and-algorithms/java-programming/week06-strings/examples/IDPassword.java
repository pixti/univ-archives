import java.util.Scanner;

/**
 * [6-2 실습] 아이디와 패스워드 검사
 *
 * 아이디와 패스워드를 입력받아 등록된 값("bmkim" / "koala")과 같은지 검사한다.
 *
 * 포인트
 *  - trim()        : 앞뒤 공백 제거
 *  - toLowerCase() : 소문자로 변환 → 대소문자를 구분하지 않고 비교 (BMKIM 도 통과)
 *  - 문자열 내용 비교는 == 가 아니라 equals !
 *  - 반환값을 login = login.trim(); 처럼 다시 대입해야 바뀐다. (String 은 불변)
 *
 * 💡 sc.next() 는 원래 공백을 구분자로 쓰고 앞뒤 공백을 건너뛰기 때문에 여기서 trim() 은 사실 효과가 없다.
 *    nextLine() 으로 한 줄 전체를 받을 때 trim() 이 의미가 있다. (그래도 습관처럼 해 두면 안전)
 * 💡 실제 서비스에서 비밀번호까지 소문자로 바꾸는 것은 좋지 않다. 비밀번호는 보통 대소문자를 구분한다.
 *
 * 실행 예
 *  아이디 :
 *  BmKim
 *  패스워드 :
 *  koala
 *  아이디 패스워드 모두 일치
 */
public class IDPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 : ");
        String login = sc.next();
        System.out.println("패스워드 : ");
        String password = sc.next();

        login = login.trim();                 // 앞뒤 공백 제거
        password = password.trim();

        login = login.toLowerCase();          // 소문자로 변환
        password = password.toLowerCase();

        if (login.equals("bmkim")) {
            if (password.equals("koala")) {
                System.out.println("아이디 패스워드 모두 일치");
            }
            else {
                System.out.println("패스워드 불일치");
            }
        }
        else {
            System.out.println("아이디 불일치");
        }
        sc.close();
    }
}
