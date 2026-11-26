import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 1번 문제 (split 을 쓰지 않는 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
