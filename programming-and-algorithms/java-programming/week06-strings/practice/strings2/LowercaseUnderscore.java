/**
 * [6강 실습] 문자열(2) - 1번 문제
 *
 * 밑줄(_)로 연결된 "소문자 문자열" 을 찾는 프로그램을 작성하시오.
 *      "java_exercises"  → Found a match!
 *      "Java_exercises"  → Not matched!
 *      "java_Exercises"  → Not matched!
 *      "Java_Exercises"  → Not matched!
 *
 * 포인트
 *  - ^[a-z]+_[a-z]+$
 *      ^        문자열의 시작
 *      [a-z]+   소문자 1개 이상
 *      _        밑줄 그대로
 *      [a-z]+   소문자 1개 이상
 *      $        문자열의 끝
 *
 * 📝 필기 처음 작성한 정규식 "[a-z]+[a-z]+" → No No No No (전부 실패)
 *  - (AI 설명) 이 정규식에는 밑줄(_) 이 들어 있지 않다.
 *    matches() 는 문자열 "전체" 가 정규식과 일치해야 true 인데,
 *    "java_exercises" 의 가운데 _ 를 [a-z] 가 받아 줄 수 없으므로 정답이어야 할 첫 번째 문자열까지 실패한다.
 *    → 정규식에 _ 를 넣어 "^[a-z]+_[a-z]+$" 로 수정 → Yes No No No
 *
 * 💡 문제의 기대 출력은 "Found a match!" / "Not matched!" 인데, 내 코드는 Yes / No 로 출력했다.
 *    아래 코드는 문제의 출력 형식에 맞췄다. (내 원래 출력은 주석으로 남김)
 * 💡 String.matches 는 자동으로 전체 일치를 검사하므로 ^ $ 는 생략해도 결과가 같다.
 *
 * 실행 결과
 *  ---- [a-z]+[a-z]+ (처음 코드) ----
 *  java_exercises : No
 *  Java_exercises : No
 *  java_Exercises : No
 *  Java_Exercises : No
 *  ---- ^[a-z]+_[a-z]+$ (수정) ----
 *  Found a match!
 *  Not matched!
 *  Not matched!
 *  Not matched!
 */
public class LowercaseUnderscore {
    public static void main(String[] args) {
        String[] strs = { "java_exercises", "Java_exercises", "java_Exercises", "Java_Exercises" };

        // ❌ 처음 코드 : 밑줄(_)이 정규식에 없어서 모두 실패
        System.out.println("---- [a-z]+[a-z]+ (처음 코드) ----");
        for (String s : strs) {
            System.out.println(s + " : " + (s.matches("[a-z]+[a-z]+") ? "Yes" : "No"));
        }

        // ✅ 수정 : 소문자 + _ + 소문자
        System.out.println("---- ^[a-z]+_[a-z]+$ (수정) ----");
        String regex = "^[a-z]+_[a-z]+$";
        for (String s : strs) {
            if (s.matches(regex)) {
                System.out.println("Found a match!");   // 내 코드 : Yes
            } else {
                System.out.println("Not matched!");     // 내 코드 : No
            }
        }
    }
}
