import java.util.Scanner;

/**
 * [6-3 실습] 부분 문자열 바꾸기 - 이전 프로그램(SearchReplace.java) 을 StringBuilder 로 수정
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
