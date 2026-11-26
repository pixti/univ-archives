import java.util.Scanner;

/**
 * [6-2 실습] 부분 문자열 검색 및 치환하기 (String 이용)   ※ 6-3 에서 같은 코드를 다시 보여준 뒤 StringBuilder 로 수정
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SearchReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문장 입력 : ");
        String statement = sc.nextLine();   // 공백 고려 nextLine

        System.out.println("찾고자 하는 단어 : ");
        String sword = sc.next();

        System.out.println("바꾸고자 하는 단어 : ");
        String rword = sc.next();

        statement = statement.replaceFirst(sword, rword);
        System.out.println(statement);
        sc.close();
    }
}
