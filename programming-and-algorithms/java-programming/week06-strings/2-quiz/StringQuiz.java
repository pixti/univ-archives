import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 퀴즈] 문자열 (String · StringBuilder · 정규식)
 * 문제 · 정답 · 필기 → README.md
 */
public class StringQuiz {

    public static void main(String[] args) {
        System.out.println("===== 1 =====");  q1();
        System.out.println("===== 2 =====");  q2();
        System.out.println("===== 3 =====");  q3();
        System.out.println("===== 4 =====");  q4();
        System.out.println("===== 5 =====");  q5();
        System.out.println("===== 6 =====");  q6();
        System.out.println("===== 7 =====");  q7();
        System.out.println("===== 8 =====");  q8();
        System.out.println("===== 9 =====");  q9();
        System.out.println("===== 10 ====="); q10();
        System.out.println("===== 11 ====="); q11();
    }

    // 1. String 생성
    static void q1() {
        String str1, str2, str3, str4;
        char[] charArray = { 'I', ' ', 'L', 'o', 'v', 'e', ' ', 'Y', 'o', 'u' };

        str1 = "Hi, Byeong Man";
        str2 = new String(str1);
        str3 = new String(charArray);
        str4 = new String(charArray, 2, 4);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }

    // 2. "I lobe You" 의 b 를 v 로 바꾸기
    static void q2() {
        String str = "I lobe You";
        char[] t = str.toCharArray();
        t[4] = 'v';
        str = new String(t);
        System.out.println(str);
    }

    // 3. equals 와 ==
    static void q3() {
        String Str1 = new String("I Love You!!");
        String Str2 = Str1;
        String Str3 = new String("I Love You!!");

        // (왼쪽) equals
        boolean retVal;
        retVal = Str1.equals(Str2);        // true
        System.out.println("Returned Value = " + retVal);
        retVal = Str1.equals(Str3);        // true
        System.out.println("Returned Value = " + retVal);

        // (오른쪽) ==
        // ⚠ if (str1 == str2) 처럼 소문자로 쓰면 컴파일 에러 (변수 이름은 Str1)
        if (Str1 == Str2) System.out.println("true");   // true
        if (Str1 == Str3) System.out.println("true");   // false → 출력 없음
        // 문자의 구성은 같지만, 다른 객체이기 때문
    }

    // 4. compareTo
    static void q4() {
        String Str1 = new String("I Love You!!");
        String Str2 = Str1;
        String Str3 = new String("I Hate You!!");

        if (Str1.compareTo(Str2) == 0) System.out.println("Equal");
        else                           System.out.println("Not Equal");

        if (Str1.compareTo(Str3) > 0)      System.out.println("Greater");
        else if (Str1.compareTo(Str3) < 0) System.out.println("Less");
        else                               System.out.println("Equal");
    }

    // 5. 문자열 검색 · 조작
    static void q5() {
        String str1 = "  abcisabc isabc ";
        System.out.println(str1.startsWith("abc"));     // false   (⚠ startWith 가 아니다)
        System.out.println(str1.indexOf('i', 4));       // 5

        try {
            System.out.println(str1.substring(20));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("substring(20) → " + e);
        }
        System.out.println("substring(2)  → [" + str1.substring(2) + "]");   // 📝 필기 : 2 로 바꿔서 확인

        str1.replace('a', 'A');                         // 재대입하지 않음 → 변화 없음
        System.out.println("[" + str1 + "]");

        String upperStr = str1.toUpperCase();
        System.out.println("[" + upperStr + "]");

        String str2 = str1.trim();
        System.out.println("[" + str2 + "]");

        String str3 = str1.replaceAll("^\\s+", "");
        System.out.println("[" + str3 + "]");
    }

    // 6. split
    static void q6() {
        String delimStr = " ";
        String words = "minus one two,three:four.five";
        String[] subs = words.split(delimStr);
        for (String s : subs) {
            System.out.println("-" + s + "-");
        }
    }

    // 7. matches 와 정규식
    static void q7() {
        String regExp = "01[078]-\\d{4}-\\d{4}";
        String str = new String("010-5182-0173");
        System.out.println(str.matches(regExp));
        str = new String("013-5182-0173");
        System.out.println(str.matches(regExp));
        str = new String("010-518-0173");
        System.out.println(str.matches(regExp));
    }

    // 8. StringBuilder.replace vs String.replace
    static void q8() {
        StringBuilder str = new StringBuilder("hello");
        str.replace(2, 5, "love");
        System.out.println(str);       // helove

        String str1 = new String("hello");
        str1.replace("llo", "love");   // 재대입하지 않아서 그대로
        System.out.println(str1);      // hello
    }

    // 9. capacity / ensureCapacity
    static void q9() {
        StringBuilder s1 = new StringBuilder("hello");
        System.out.println("Old Capacity = " + s1.capacity());
        s1.ensureCapacity(28);
        System.out.println("New Capacity = " + s1.capacity());
        s1.ensureCapacity(33);
        System.out.println("New Capacity = " + s1.capacity());

        StringBuilder s2 = new StringBuilder();
        System.out.println("Old Capacity = " + s2.capacity());
        s2.ensureCapacity(40);
        System.out.println("New Capacity = " + s2.capacity());
    }

    // 10. 빈칸 채우기 (핸드폰 번호 형식 검사)
    static void q10() {
        System.out.println("핸드폰 번호 ? (010-1234-5678 입력 가정)");
        check("010-1234-5678");
        System.out.println("(011-12-5678 입력 가정)");
        check("011-12-5678");
    }

    static void check(String input) {
        Pattern pattern = Pattern.compile("^01[01]-\\d{4}-\\d{4}$");   // ①
        Matcher m = pattern.matcher(input);                              // ②
        if (!m.matches()) {                                              // ③
            System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
            return;
        }
        System.out.println("형식에 맞게 입력하셨습니다.");
    }

    /** 💡 실제로 키보드 입력을 받는 원래 형태 (main 에서는 호출하지 않음) */
    static void q10Scanner() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.print("핸드폰 번호 ? ");
        input = sc.next();
        Pattern pattern = Pattern.compile("^01[01]-\\d{4}-\\d{4}$");
        Matcher m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
            return;
        }
        System.out.println("형식에 맞게 입력하셨습니다.");
    }

    // 11. StringBuilder 메소드 연속 호출
    static void q11() {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(33.333);
        System.out.println(sb);
        sb.insert(8, 's');
        System.out.println(sb);
        sb.delete(4, 7);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        String s = sb.substring(3, 5);
        System.out.println(s);
        char c = sb.charAt(3);
        System.out.println(c);
        sb.setCharAt(3, 'o');
        System.out.println(sb);
        sb.deleteCharAt(3);
        System.out.println(sb);
    }
}
