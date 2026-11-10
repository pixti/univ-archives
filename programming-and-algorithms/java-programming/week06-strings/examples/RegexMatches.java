/**
 * [6-4] 정규식 관련 클래스 - String 클래스의 matches
 *
 * 포인트
 *  - str.matches(정규식) : 문자열 "전체" 가 정규식과 부합되는지 → true / false
 *  - "01[078]-\\d{4}-\\d{4}"
 *      01       글자 그대로 "01"
 *      [078]    0, 7, 8 중 하나        → 010, 017, 018 중 하나
 *      -        하이픈 그대로
 *      \\d{4}   숫자(\d) 정확히 4개
 *
 * 📝 필기 (퀴즈 7번) 01[078] → 010, 017, 018 중 하나
 * 📝 필기 (퀴즈 7번, AI 설명)
 *  - 정규식의 \d 를 자바 문자열 안에 쓰려면 \ 를 한 번 더 써서 "\\d" 로 적어야 한다.
 *    (자바 문자열에서 \ 는 이스케이프 문자이므로)
 *  - "013-5182-0173" : 세 번째 자리 3 이 [078] 에 없음 → false
 *    "010-518-0173"  : 가운데가 3자리라 \d{4} 에 맞지 않음 → false
 *
 * 💡 matches 는 자동으로 전체 일치를 검사하므로 ^ 와 $ 를 붙이지 않아도 된다.
 *    (Pattern / Matcher 의 find 처럼 "부분 검색" 을 할 때는 ^ $ 가 의미 있다)
 *
 * 실행 결과
 *  true
 *  false
 *  false
 */
public class RegexMatches {
    public static void main(String[] args) {
        String regExp = "01[078]-\\d{4}-\\d{4}";
        String str = new String("010-5182-0173");
        System.out.println(str.matches(regExp));   // 부합

        str = new String("013-5182-0173");
        System.out.println(str.matches(regExp));   // 부합 X

        str = new String("010-518-0173");
        System.out.println(str.matches(regExp));   // 부합 X
    }
}
