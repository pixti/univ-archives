import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6-4 실습] 정규식을 이용한 사용자 입력 값 검사
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RegularExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        Pattern pattern;
        Matcher m;

        System.out.println("이름 : ");
        input = sc.next();
        pattern = Pattern.compile("^[가-힣]{2,4}$");
        m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("이름 형식에 맞지 않습니다.");
            return;
        }

        input = sc.nextLine();   // 💡 next() 가 남긴 줄바꿈 비우기
        System.out.println("주소 : ");
        input = sc.nextLine();
        pattern = Pattern.compile("^[가-힣]{2,4}도\\s+"
                + "[가-힣]{2,4}시\\s+[가-힣]{2,6}로\\s+\\d{2,4}$");
        m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("주소 형식에 맞지 않습니다.");
            return;
        }

        System.out.println("우편번호 : ");
        input = sc.next();
        pattern = Pattern.compile("^\\d{5}$");
        m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("우편번호 형식에 맞지 않습니다.");
            return;
        }

        System.out.println("핸드폰 번호 : ");
        input = sc.next();
        pattern = Pattern.compile("^01[01]-\\d{4}-\\d{4}$");
        m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
            return;
        }
        System.out.println("모든 자료를 형식에 맞게 입력하셨습니다.");
        sc.close();
    }
}
