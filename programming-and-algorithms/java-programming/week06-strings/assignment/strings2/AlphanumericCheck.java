/**
 * [6강 과제] 문자열(2) - 1번 문제
 *
 * 문자열이 영문자(a-z, A-Z)와 숫자(0-9)로만 이루어져 있는지 검사하시오.
 *      "ABCDEFabcdef123450" → true
 *      "SQL"                → true
 *      "Java"               → true
 *      "*&%@#!}{"           → false
 *      "w3resource.com"     → false
 *
 * 포인트
 *  - [a-zA-Z0-9]+ : 대괄호 안에 범위를 여러 개 이어 쓸 수 있다. (소문자 OR 대문자 OR 숫자) 가 1개 이상
 *  - String.matches 는 문자열 "전체" 가 일치해야 true
 *
 * 📝 필기 (AI 설명)
 *  - 정규식의 의미를 명확히 하려면 ^[a-zA-Z0-9]+$ 처럼 시작(^) 과 끝($) 을 표시해도 된다.
 *    (matches 는 원래 전체 일치라 결과는 같음)
 *  - "*&%@#!}{" 는 특수문자만 있어서 false,
 *    "w3resource.com" 은 영문자·숫자 사이에 점(.) 이 하나 섞여 있어서 false.
 *
 * 💡 [a-zA-Z0-9] 는 \\p{Alnum} 으로도 쓸 수 있다.  \\w 는 밑줄(_) 까지 포함하므로 이 문제에는 맞지 않다.
 *
 * 실행 결과
 *  ABCDEFabcdef123450 : true
 *  SQL : true
 *  Java : true
 *  *&%@#!}{ : false
 *  w3resource.com : false
 */
public class AlphanumericCheck {
    public static void main(String[] args) {
        String[] strs = { "ABCDEFabcdef123450", "SQL", "Java", "*&%@#!}{", "w3resource.com" };
        String regex = "[a-zA-Z0-9]+";

        for (String s : strs) {
            System.out.println(s + " : " + s.matches(regex));
        }
    }
}
