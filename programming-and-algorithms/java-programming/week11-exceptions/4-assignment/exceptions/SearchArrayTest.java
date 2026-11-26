import java.util.Scanner;

/**
 * [11강 과제] 예외 처리 - 4번 문제 (SearchArray : 찾는 숫자가 없으면 NotFound)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SearchArrayTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int[] s = new int[] {11, 22, 33, 44, 55, 66, 77, 88, 99, 111};
        SearchArray sa = new SearchArray(s, 10);
        sa.display();
        System.out.print("찾을 값을 입력하세요 : ");
        input = sc.nextInt();
        sc.close();
        sa.searchNum(input);
    }
}

class NotFound extends Exception {
    public NotFound(String message) {
        super(message);
    }
}

class SearchArray {
    private int[] arr;
    private int size;

    public SearchArray(int[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    public void display() {
        System.out.println("배열에 저장된 값은...");
        for (int i = 0; i < size; i++) {
            System.out.print("[" + arr[i] + "] ");
        }
        System.out.println();
    }

    public void searchNum(int num) {
        try {
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (arr[i] == num) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println(num + "은 배열안에 존재합니다.");
            } else {
                throw new NotFound("원소가 존재하지 않음");
            }
        } catch (NotFound e) {
            e.printStackTrace();
        }
    }
}
