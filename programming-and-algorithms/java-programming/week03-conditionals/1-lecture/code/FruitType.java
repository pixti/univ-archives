import java.util.Scanner;

/**
 * [3-3 조건문3] switch 문 - 식에 문자열(String) 변수 사용
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FruitType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("과일 이름 ? ");
        String s = sc.next();
        sc.close();

        int type;
        switch (s) { // 여기 - 문자열 변수
            case "apple":
                type = 1;
                break;
            case "banana":
                type = 2;
                break;
            case "carrot":
                type = 3;
                break;
            default:
                type = 4;
        }
        System.out.println("type = " + type);
    }
}
