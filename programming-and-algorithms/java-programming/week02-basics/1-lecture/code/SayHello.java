import java.util.Scanner; // ← 이 줄이 없으면 "Scanner cannot be resolved to a type" 컴파일 에러

/**
 * [2-4 변수와 자료형4] [실습] 사용자 이름을 입력 받아 인사말 출력하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SayHello {
    public static void main(String[] args) {
        System.out.println("이름 입력 >> ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();   // 공백 전까지의 문자열(단어) 하나를 읽음
        sc.close();

        // + 기호로 긴 문자열 연결 (문자열 + 변수 + 문자열)
        String helloMessage = "안녕하세요. " + name +
                " 님, 자바 세계에 오실 것을 축하드립니다.";
        System.out.println(helloMessage);
    }
}
