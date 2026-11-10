import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6-4 실습] 정규식을 이용한 사용자 입력 값 검사
 *
 * 사용자로부터 이름, 주소, 우편번호, 핸드폰 번호를 입력받아 유효성을 검증한다.
 *  - 이름은 한글문자 2~4개                  ^[가-힣]{2,4}$
 *  - 주소는 "…도 …시 …로 000" 형태          ^[가-힣]{2,4}도\s+[가-힣]{2,4}시\s+[가-힣]{2,6}로\s+\d{2,4}$
 *  - 우편번호는 5자리 숫자                  ^\d\d\d\d\d$ 또는 ^\d{5}$
 *  - 핸드폰은 "010-xxxx-xxxx" or "011-xxxx-xxxx"   ^01[01]-\d{4}-\d{4}$
 *
 * 포인트
 *  - [가-힣] : 한글 완성형 글자 '가' 부터 '힣' 까지 = 한글 한 글자
 *  - \s+     : 공백 1개 이상 (도 / 시 / 로 사이에 띄어쓰기)
 *  - 형식이 틀리면 메시지를 출력하고 return 으로 main 을 바로 끝낸다.
 *  - 📝 (퀴즈 10번, AI 설명) matches() 는 문자열 "전체" 가 패턴과 맞아야 true.
 *    compile 은 정규식을 미리 해석(컴파일)해 두는 것이라 같은 패턴을 여러 번 쓸 때 효율적이다.
 *
 * 💡 sc.next() 뒤에 sc.nextLine() 을 한 번 호출하는 이유
 *    next() 는 단어만 읽고 엔터(줄바꿈)를 버퍼에 남긴다. 바로 nextLine() 을 부르면 그 남은 줄바꿈만 읽고 끝나 버린다.
 *    그래서 "input = sc.nextLine();" 으로 남은 줄바꿈을 한 번 비운 뒤, 공백이 있는 주소를 nextLine() 으로 읽는다.
 *
 * ⚠ 슬라이드 설명은 "도명·시명은 한글 3~5개, 도로명은 3~7개 (끝자리 포함)" 인데
 *    정규식은 [가-힣]{2,4}도 = "도" 를 빼고 2~4개 + 도 → 합쳐서 3~5개, [가-힣]{2,6}로 → 3~7개 이므로 서로 맞다.
 *    (끝자리 '도' '시' '로' 를 포함해서 센 것)
 * ⚠ 슬라이드의 Pattern.compiles(“...") 는 오타. compile 이 맞고, 따옴표도 일반 " 로 고쳤다.
 *    또 슬라이드는 정규식 중간에 줄이 바뀌어 있는데, 자바 문자열 리터럴은 줄을 넘길 수 없으므로 + 로 이었다.
 *
 * 실행 예
 *  이름 :
 *  김병만
 *  주소 :
 *  경기도 수원시 월드컵로 206
 *  우편번호 :
 *  16499
 *  핸드폰 번호 :
 *  010-1234-5678
 *  모든 자료를 형식에 맞게 입력하셨습니다.
 *
 *  (주소를 "수원시 월드컵로 206" 으로 입력하면)
 *  주소 형식에 맞지 않습니다.
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
