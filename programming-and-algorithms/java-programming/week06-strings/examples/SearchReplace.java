import java.util.Scanner;

/**
 * [6-2 실습] 부분 문자열 검색 및 치환하기 (String 이용)   ※ 6-3 에서 같은 코드를 다시 보여준 뒤 StringBuilder 로 수정
 *
 * 문장, 찾고자 하는 단어, 바꾸고자 하는 단어를 입력받아 문장에서 처음 나오는 단어 하나를 바꾼다.
 *
 * 포인트
 *  - 문장은 공백이 들어가므로 nextLine(), 단어는 next()
 *  - replaceFirst(sword, rword) : 처음 일치하는 부분 하나만 치환 → 새 문자열을 돌려주므로 statement 에 다시 대입
 *
 * 💡 replaceFirst / replaceAll 의 첫 인자는 "정규식" 이다.
 *    찾는 단어에 . ( ) + * ? 같은 문자가 있으면 의도와 다르게 동작할 수 있다.
 *    예) 문장 "1+1=2" 에서 "1+1" 을 찾으면 정규식 1+1 은 "1이 1개 이상 + 1" 이라 일치하지 않는다.
 *    정규식이 아닌 "글자 그대로" 바꾸려면 replace(sword, rword) (모두 치환) 를 쓰거나
 *    Pattern.quote(sword) 로 감싼다.
 *
 * 실행 예
 *  문장 입력 :
 *  I love you. You love me.
 *  찾고자 하는 단어 :
 *  love
 *  바꾸고자 하는 단어 :
 *  like
 *  I like you. You love me.
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
