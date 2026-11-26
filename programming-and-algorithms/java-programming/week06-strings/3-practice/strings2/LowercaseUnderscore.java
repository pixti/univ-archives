/**
 * [6강 실습] 문자열(2) - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class LowercaseUnderscore {
    public static void main(String[] args) {
        String[] strs = { "java_exercises", "Java_exercises", "java_Exercises", "Java_Exercises" };

        // ❌ 처음 코드 : 밑줄(_)이 정규식에 없어서 모두 실패
        System.out.println("---- [a-z]+[a-z]+ (처음 코드) ----");
        for (String s : strs) {
            System.out.println(s + " : " + (s.matches("[a-z]+[a-z]+") ? "Yes" : "No"));
        }

        // ✅ 고친 코드 : 소문자 + _ + 소문자
        System.out.println("---- ^[a-z]+_[a-z]+$ (고친 코드) ----");
        String regex = "^[a-z]+_[a-z]+$";
        for (String s : strs) {
            if (s.matches(regex)) {
                System.out.println("Found a match!");   // 처음 출력 : Yes
            } else {
                System.out.println("Not matched!");     // 처음 출력 : No
            }
        }
    }
}
