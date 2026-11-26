/**
 * [11강 실습] 예외 처리 - 4번 문제 (모음이 없으면 사용자 정의 예외 NoVowelsException)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Vowel_Check {
    public static void main(String[] args) {
        String[] texts = {"Java handling and managing exceptions ", "Typy gyps fly."};

        for (String text : texts) {
            try {
                System.out.println("Original string: " + text);
                checkVowels(text);
                System.out.println("String contains vowels.");
            } catch (NoVowelsException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }

        System.out.println("---- 방법 ① ~ ⑥ (\"Typy gyps fly.\" / \"APPLE\") ----");   // 💡 확인용
        for (int way = 1; way <= 6; way++) {
            System.out.println(circled(way) + " " + result(way, "Typy gyps fly.") + " / " + result(way, "APPLE"));
        }
    }

    // 처음 작성한 코드 (방법 ④ : contains())
    public static void checkVowels(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (vowels.contains(String.valueOf(ch))) {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ① : || 연산자로 10개 직접 비교하기
    public static void checkVowels1(String text) throws NoVowelsException {
        boolean containsVowels = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ② : toLowerCase() + || 5개 비교하기
    public static void checkVowels2(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String lowerText = text.toLowerCase();   // 문자열 전체를 소문자로 통일

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ③ : indexOf() 사용하기
    public static void checkVowels3(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // vowels 안에 ch 가 있으면 위치(0~9), 없으면 -1 을 반환
            if (vowels.indexOf(ch) != -1) {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ⑤ : switch 문 사용하기 (return; 활용)
    public static void checkVowels5(String text) throws NoVowelsException {
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return;   // 모음을 찾으면 메서드 자체를 즉시 종료!
            }
        }

        // 반복문이 끝날 때까지 return 이 안 됐다면 모음이 하나도 없다는 뜻!
        throw new NoVowelsException("String does not contain any vowels");
    }

    // 방법 ⑥ : 정규표현식(Regex)으로 1줄 끝내기
    public static void checkVowels6(String text) throws NoVowelsException {
        // ".*[aeiouAEIOU].*" : 문자열 어딘가에 모음이 하나라도 들어 있는지 검사
        if (!text.matches(".*[aeiouAEIOU].*")) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 💡 확인용 : way 번 방법으로 검사한 결과
    static String result(int way, String text) {
        try {
            switch (way) {
                case 1 -> checkVowels1(text);
                case 2 -> checkVowels2(text);
                case 3 -> checkVowels3(text);
                case 4 -> checkVowels(text);
                case 5 -> checkVowels5(text);
                default -> checkVowels6(text);
            }
            return "통과";
        } catch (NoVowelsException e) {
            return "예외";
        }
    }

    static String circled(int n) {
        return String.valueOf((char) ('①' + n - 1));
    }
}

class NoVowelsException extends Exception {
    public NoVowelsException(String message) {
        super(message);
    }
}
