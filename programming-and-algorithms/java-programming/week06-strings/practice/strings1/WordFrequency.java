import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 4번 문제 (단어 빈도수)
 *
 * 문장을 입력받아 각 단어가 몇 번 나왔는지 출력하시오. (대소문자는 구분하지 않는다)
 *  예) Easy come, easy go.
 *      easy	2
 *      come	1
 *      go	1
 *
 * 포인트
 *  - toLowerCase() 로 소문자 통일 → "Easy" 와 "easy" 를 같은 단어로
 *  - split("( |,|\\.)+") : 공백 · 쉼표 · 마침표가 1개 이상 이어진 덩어리로 자르기
 *      "easy come, easy go."  →  ["easy", "come", "easy", "go"]
 *      (맨 끝의 마침표 뒤 빈 문자열은 split 이 자동으로 없애 준다)
 *  - 이중 for 문 : i 번째 단어를 뒤쪽(j = i+1 ~) 단어들과 비교해 같은 것을 센다.
 *    센 단어는 null 로 바꿔서 나중에 다시 세지 않게 한다.
 *
 * 📝 필기 (내 코드의 주석)
 *  - 이미 처리되어 null 이 된 단어는 건너뜀
 *  - 중복 단어는 null 로 변경하여 제외
 *  - (cnt + 1) 형태로 괄호를 묶어주어야 숫자 덧셈이 정상 처리됨
 *      subs[i] + "\t" + cnt + 1   → "easy\t1" 뒤에 "1" 이 이어 붙어 "easy\t11"  (문자열 연결이 왼쪽부터 진행)
 *      subs[i] + "\t" + (cnt + 1) → 괄호 안을 먼저 계산 → "easy\t2"
 *
 * 📝 필기 (AI 설명) 중복 단어를 지울 때 null 과 "" 중 무엇을 쓸까?
 *  - "" (빈 문자열) : 길이가 0 인 "진짜 String 객체". 이후 비교 때 equals 를 또 호출하게 되어 비효율적이고,
 *                     입력에 원래 빈 단어가 있었는지와 헷갈릴 수 있다.
 *  - null           : "여기엔 더 이상 단어가 없다" 는 의미가 분명하고, subs[i] != null 로 간단히 건너뛸 수 있다.
 *    → null 로 표시하는 방법을 사용. 단, null 에 equals 를 호출하면 NullPointerException 이므로
 *      subs[j] != null && subs[i].equals(subs[j]) 처럼 null 검사를 "먼저" 해야 한다. (&& 의 단축 평가)
 *
 * 💡 나중에 배울 HashMap<String, Integer> 을 쓰면 이중 for 문 없이 단어별 개수를 셀 수 있다.
 *
 * 실행 예
 *  문장을 입력하세요 : Easy come, easy go.
 *  easy	2
 *  come	1
 *  go	1
 */
public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장을 입력하세요 : ");
        String sentence = sc.nextLine();                 // 띄어쓰기가 들어간 문장 전체를 읽어온다.

        sentence = sentence.toLowerCase();               // 소문자로 변환
        String[] subs = sentence.split("( |,|\\.)+");    // 공백을 기준으로 단어를 나눈다. (쉼표, 마침표 포함)

        for (int i = 0; i < subs.length; i++) {
            if (subs[i] != null) {                       // 이미 처리되어 null이 된 단어는 건너뜀
                int cnt = 0;
                for (int j = i + 1; j < subs.length; j++) {
                    if (subs[j] != null && subs[i].equals(subs[j])) {
                        cnt++;
                        subs[j] = null;                  // 중복 단어는 null로 변경하여 제외
                    }
                }
                // (cnt + 1) 형태로 괄호를 묶어주어야 숫자 덧셈이 정상 처리됨
                System.out.println(subs[i] + "\t" + (cnt + 1));
            }
        }
        sc.close();
    }
}
