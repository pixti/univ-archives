import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 1번 문제 (split 을 쓰지 않는 버전)
 *
 * 영문 문자열을 입력받아 영단어의 개수를 출력하는 프로그램을 작성하시오.
 *  - split 메소드를 사용하지 않고, 문자 배열(char[]) 과 Character.isLetter() 를 이용한다.
 *  - 영문자가 아닌 문자(공백, 숫자, 문장부호)는 단어의 구분자로 본다.
 *
 * 💡 참고 답안 (필기에는 split 버전만 있어서, 문제 조건대로 작성한 답안을 추가함)
 *  - 아이디어 : "영문자가 아닌 문자 → 영문자" 로 바뀌는 순간 = 새 단어가 시작되는 순간.
 *    inWord(지금 단어 안에 있는가?) 변수 하나로 상태를 기억하면서 한 글자씩 본다.
 *
 *        T h i s _ i s _ a _ b o o k .
 *        ↑       ↑   ↑   ↑                 ← 단어 시작 4번 → 4개
 *
 *  - Character.isLetter(c) : c 가 문자(알파벳 등)면 true.  숫자·공백·문장부호는 false.
 *    💡 isLetter 는 한글도 문자로 본다. "영문자만" 엄격하게 보려면
 *       (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') 로 검사한다.
 *
 * 실행 예
 *  영문 문자열을 입력하세요 : This is a book.
 *  영단어의 개수는 : 4
 *
 *  영문 문자열을 입력하세요 : abc         → 영단어의 개수는 : 1
 *  영문 문자열을 입력하세요 : 123         → 영단어의 개수는 : 0
 *  영문 문자열을 입력하세요 : 123abc456   → 영단어의 개수는 : 1
 */
public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();       // 띄어쓰기가 들어간 문장 전체를 읽어온다.

        char[] chars = input.toCharArray(); // 문자열 → 문자 배열
        int count = 0;
        boolean inWord = false;             // 현재 단어 안에 있는지

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (!inWord) {              // 구분자 다음에 처음 나온 문자 = 새 단어의 시작
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;             // 공백 · 숫자 · 문장부호 → 단어 끝
            }
        }
        System.out.println("영단어의 개수는 : " + count);
        sc.close();
    }
}
