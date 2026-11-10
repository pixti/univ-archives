import java.util.Scanner;

/**
 * [6-3 실습] 부분 문자열 바꾸기 - 이전 프로그램(SearchReplace.java) 을 StringBuilder 로 수정
 *
 * 포인트
 *  - new StringBuilder(sc.nextLine()) : 입력받은 문장으로 StringBuilder 생성
 *  - indexOf(sword)            → 찾는 단어의 시작 위치
 *    start + sword.length()    → 끝 위치 (끝 인덱스는 포함 X 이므로 딱 맞다)
 *  - statement.replace(start, end, rword) : 원본 문자열이 직접 변경됨 → 재대입 필요 없음
 *    (String 버전은 statement = statement.replaceFirst(...) 로 다시 대입해야 했다)
 *
 * 💡 String 버전과 달리 정규식이 아니라 "글자 그대로" 찾는다. "1+1" 같은 단어도 문제없다.
 *
 * ⚠ 슬라이드 코드는 찾는 단어가 문장에 없을 때를 처리하지 않는다.
 *    indexOf 가 -1 을 돌려주면 replace(-1, ...) 에서 StringIndexOutOfBoundsException 이 난다.
 *    아래처럼 if (start != -1) 로 검사를 추가했다.
 *
 * 실행 예
 *  문장 입력 :
 *  I love you. You love me.
 *  찾고자 하는 단어 :
 *  love
 *  바꾸고자 하는 단어 :
 *  like
 *  I like you. You love me.
 *
 *  (없는 단어를 입력하면)
 *  찾고자 하는 단어 :
 *  hate
 *  ...
 *  "hate" 를 찾을 수 없습니다.
 */
public class SearchReplaceBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문장 입력 : ");
        StringBuilder statement = new StringBuilder(sc.nextLine());

        System.out.println("찾고자 하는 단어 : ");
        String sword = sc.next();

        System.out.println("바꾸고자 하는 단어 : ");
        String rword = sc.next();

        int start = statement.indexOf(sword);
        if (start != -1) {                               // ⚠ 추가 : 못 찾은 경우 처리
            int end = start + sword.length();
            statement.replace(start, end, rword);        // 원본 문자열이 변경됨
            System.out.println(statement);
        } else {
            System.out.println("\"" + sword + "\" 를 찾을 수 없습니다.");
        }
        sc.close();
    }
}
