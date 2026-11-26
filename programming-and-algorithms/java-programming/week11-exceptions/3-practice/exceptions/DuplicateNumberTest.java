import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * [11강 실습] 예외 처리 - 3번 문제 (중복 숫자이면 사용자 정의 예외 Duplicate_Number_Exception)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DuplicateNumberTest {
    public static void main(String[] args) {
        int[] numbers = null;
        try {
            numbers = readNumbersFromUser();
            checkDuplicates(numbers);
            System.out.println("No duplicate numbers!");
        } catch (Duplicate_Number_Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {                                   // 💡 HashSet 방식 확인용
            checkDuplicatesHashSet(numbers);
            System.out.println("HashSet 방식 → No duplicate numbers!");
        } catch (Duplicate_Number_Exception e) {
            System.out.println("HashSet 방식 → Error: " + e.getMessage());
        }
    }

    public static int[] readNumbersFromUser() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers do you want to input? ");
        int count = sc.nextInt();

        int[] numbers = new int[count];
        System.out.println("Input the integers:");
        for (int i = 0; i < count; i++) {
            numbers[i] = sc.nextInt();
        }

        sc.close();
        return numbers;
    }

    public static void checkDuplicates(int[] numbers) throws Duplicate_Number_Exception {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    throw new Duplicate_Number_Exception("Duplicate number found: " + numbers[i]);
                }
            }
        }
    }

    // 심화 : HashSet 을 이용한 중복 검사
    public static void checkDuplicatesHashSet(int[] numbers) throws Duplicate_Number_Exception {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : numbers) {
            if (uniqueNumbers.contains(num)) {
                throw new Duplicate_Number_Exception("Duplicate number found: " + num);
            }
            uniqueNumbers.add(num);
        }
    }
}

class Duplicate_Number_Exception extends Exception {
    public Duplicate_Number_Exception(String message) {
        super(message);
    }
}
