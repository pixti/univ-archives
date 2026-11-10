/**
 * [6강 실습] 문자열(2) - 3번 문제
 *
 * 다음 문장에서 "Python" 을 "Java" 로, "code" 를 "coding" 으로 바꾸시오.
 *
 *  Python is an interpreted high-level general-purpose programming language. Its design philosophy
 *  emphasizes code readability with its use of significant indentation. Its language constructs as
 *  well as its object-oriented approach aim to help programmers writeclear, logical code for small
 *  and large-scale projects.
 *
 * 포인트
 *  - str.replace("Python", "Java").replace("code", "coding")
 *    → replace 가 "새 String" 을 돌려주므로 그 결과에 다시 .replace 를 이어 붙일 수 있다. (메소드 체이닝)
 *
 * 📝 필기 (AI 설명)
 *  - 정규식이 필요 없는 단순 치환은 replaceAll 보다 replace 가 간단하고 안전하다.
 *    (replaceAll 은 첫 번째 인자를 정규식으로 해석하므로 . + ( 같은 문자가 들어 있으면 의도와 다르게 동작)
 *  - replace 도 일치하는 "모든" 부분을 바꾼다. (이름 때문에 하나만 바꾼다고 착각하기 쉬움)
 *  - 메소드 체이닝 : A.replace(...) 의 결과(String) 에 바로 .replace(...) 를 호출
 *
 * 💡 "code" 를 단순 치환하면 "codes", "decode" 같은 단어 속의 code 도 바뀐다.
 *    단어 단위로만 바꾸려면 정규식 단어 경계를 쓴다 : replaceAll("\\bcode\\b", "coding")
 *    (이 문장에는 code 가 단독 단어로만 2번 나와서 결과는 같다)
 * 💡 원문의 "writeclear" 는 원본 문제의 띄어쓰기 그대로 둔 것.
 *
 * 실행 결과
 *  Java is an interpreted high-level general-purpose programming language. Its design philosophy emphasizes coding readability with its use of significant indentation. Its language constructs as well as its object-oriented approach aim to help programmers writeclear, logical coding for small and large-scale projects.
 */
public class ReplaceWords {
    public static void main(String[] args) {
        String str = "Python is an interpreted high-level general-purpose programming language. "
                + "Its design philosophy emphasizes code readability with its use of significant indentation. "
                + "Its language constructs as well as its object-oriented approach aim to help programmers "
                + "writeclear, logical code for small and large-scale projects.";

        String result = str.replace("Python", "Java").replace("code", "coding"); // Python -> Java, code -> coding
        System.out.println(result);
    }
}
