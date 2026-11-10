import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 1번 변형 문제 (split 사용 버전, 내가 작성한 코드)
 *
 * 영문 문자열을 입력받아 영단어의 개수를 출력하시오. 이번에는 split 을 사용한다.
 *  - 공백, 콜론(:), 콤마(,), 점(.), 숫자를 구분자로 본다.
 *
 * 포인트
 *  - split("( |:|,|\\.|\\d)+") : 공백, 콜론, 콤마, 점, 숫자(\d) 가 1번 이상 연속되면 구분자로 분리
 *      ( A | B | C )+ : A 또는 B 또는 C 가 1번 이상 반복
 *      \\.           : 정규식에서 . 은 "아무 문자 1개" 라서 진짜 점은 \\. 로 써야 한다.
 *      \\d           : 숫자 1개 (0~9)
 *  - + 를 붙이지 않으면 "a,  b" 처럼 구분자가 연달아 있을 때 사이사이 빈 문자열("") 이 생긴다.
 *
 * 📝 필기 "2로 나오는 문제 주의"
 *  - 처음 코드는 if (subs[i] != null) 로 개수를 셌는데, "123abc456" 을 넣으면 1 이 아니라 2 가 나왔다.
 *      출력 :            ← 빈 줄 (subs[0] = "")
 *             abc
 *             영단어의 개수는 : 2
 *  - (AI 설명) 문자열이 구분자(숫자 123)로 "시작" 하면 split 결과의 맨 앞에 빈 문자열 "" 이 생긴다.
 *        "123abc456".split("( |:|,|\\.|\\d)+")  →  ["", "abc"]   (길이 2)
 *      (맨 뒤에 생기는 빈 문자열은 split 이 자동으로 지워 주지만, 맨 앞은 남는다)
 *    "" 은 길이 0 인 "진짜 String 객체" 이므로 null 이 아니다. → null 검사로는 걸러지지 않는다.
 *
 * 📝 필기 ".isEmpty()"
 *  - 그래서 !subs[i].isEmpty() 로 "빈 문자열("")이 아닌 경우만" 카운트하고 출력하도록 수정 → 1
 *
 * 📝 필기 (AI 설명) 더 짧게 쓰는 방법 → 문자 클래스 [ ]
 *  - "[ :,.0-9]+" : 대괄호 안에 넣으면 "이 중 아무거나 1개" 라는 뜻. | 로 일일이 나열하지 않아도 된다.
 *    대괄호 안에서는 . 이 특수문자가 아니라 진짜 점이라 \\ 도 필요 없다.
 *  - 단, 교수님은 \\d 를 사용하셨다. 0-9 같은 "범위" 는 대괄호 안에서만 범위로 해석되고,
 *    대괄호 밖에서 0-9 라고 쓰면 문자 '0', '-', '9' 가 순서대로 나오는 것으로 읽혀 버린다.
 *
 * 💡 split 결과 맨 앞의 "" 를 아예 없애려면, 먼저 앞쪽 구분자를 지우고 자르는 방법도 있다.
 *      sentence.replaceAll("^[ :,.0-9]+", "").split("[ :,.0-9]+")
 *
 * 실행 예
 *  문장 ? 123abc456
 *  abc
 *  영단어의 개수는 : 1
 *
 *  문장 ? This is a book.
 *  this
 *  is
 *  a
 *  book
 *  영단어의 개수는 : 4
 */
public class WordCountSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장 ? ");
        String sentence = sc.nextLine();
        sentence = sentence.toLowerCase();

        // 공백, 콜론, 콤마, 점, 숫자(\d)가 1번 이상 연속되면 구분자로 분리
        String[] subs = sentence.split("( |:|,|\\.|\\d)+");
        // String[] subs = sentence.split("[ :,.0-9]+");   // 📝 AI 추천 : 같은 의미, 더 짧게

        int cnt = 0;
        for (int i = 0; i < subs.length; i++) {
            // ❌ 처음 코드 : "" 는 null 이 아니라서 맨 앞의 빈 문자열까지 세어 버림 → 2
            // System.out.println(subs[i]);
            // if (subs[i] != null) { cnt++; }

            // ✅ 빈 문자열("")이 아닌 경우만 카운트하고 출력
            if (!subs[i].isEmpty()) {
                System.out.println(subs[i]);
                cnt++;
            }
        }
        System.out.println("영단어의 개수는 : " + cnt);
        sc.close();
    }
}
