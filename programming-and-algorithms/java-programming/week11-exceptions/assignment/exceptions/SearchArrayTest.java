import java.util.Scanner;

/**
 * [11강 과제] 예외 처리 - 4번 문제 (SearchArray : 찾는 숫자가 없으면 NotFound)
 *
 * 문제
 *  숫자를 저장하고 있는 배열을 받아서 지정된 숫자를 찾는 SearchArray 를 작성하라. 만약 배열 안에 원하는 숫자가 없으면
 *  NotFound 예외를 발생한다. NotFound 클래스를 별도로 정의한다. SearchArray 객체를 main() 안에서 생성하여서 테스트하라.
 *  try/catch 블록을 이용하여서 예외를 처리하도록 하라.
 *
 *    public class Main {
 *        public static void main(String[] args) {
 *            // Create instances of each vehicle type
 *            Scanner sc = new Scanner(System.in);
 *            int input=0;
 *            int[] s = new int[]{11,22,33,44,55,66,77,88,99,111};
 *            SearchArray sa = new SearchArray(s, 10);
 *            sa.display();
 *            System.out.print("찾을 값을 입력하세요 : ");
 *            input = sc.nextInt(); sc.close();
 *            sa.searchNum(input);
 *        }
 *    }
 *
 *    배열에 저장된 값은...
 *    [11] [22] [33] [44] [55] [66] [77] [88] [99] [111]
 *    찾을 값을 입력하세요 : 11
 *    11은 배열안에 존재합니다.
 *
 *    배열에 저장된 값은...
 *    [11] [22] [33] [44] [55] [66] [77] [88] [99] [111]
 *    찾을 값을 입력하세요 : 13
 *    NotFound: 원소가 존재하지 않음
 *        at SearchArray.searchNum(Test2.java:69)
 *        at Test2.main(Test2.java:38)
 *
 * 포인트
 *  - 주어진 main 에는 try/catch 가 없다. 그래서 searchNum() 안에서 예외를 던지고(throw) 바로 잡아서(catch) 처리했다.
 *    (실습 Exception_OddNumber.java 의 방법 1 과 같은 구조)
 *  - 플래그 변수 found 로 끝까지 찾아본 뒤, 못 찾았을 때만 예외를 던진다. (반복문 안에서 바로 던지면 첫 칸만 보고 예외가 난다)
 *  - catch 에서 e.printStackTrace() 로 예외 종류, 메시지, 발생 위치를 출력한다.
 *
 * 💡 searchNum 안에서 예외를 잡았기 때문에 main 이 바뀌지 않아도 된다. 대신 searchNum 에 throws NotFound 를 붙이고 main 에서
 *    try/catch 로 잡는 방법도 있다. 문제의 실행 결과 스택 트레이스에 SearchArray.searchNum 과 Test2.main 이 모두 나오는 것은
 *    그 방식에 가깝다. 두 방법 모두 결과는 같다.
 * 💡 "11은", "33은" 처럼 숫자 뒤에 조사를 붙이면 받침에 따라 어색할 수 있다(예 : "22은"). 문제의 출력 형식 그대로 두었다.
 * 💡 size 필드 대신 arr.length 를 써도 된다. 생성자에 넘긴 10 이 배열 길이와 다르면 문제가 생길 수 있기 때문이다.
 * 💡 sc.close() 를 nextInt() 바로 다음에 했으므로, 그 뒤에는 Scanner 를 다시 쓸 수 없다. (2강)
 * 💡 이클립스는 NotFound 줄에 serialVersionUID 노란 경고를 표시한다. 무시해도 된다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 SearchArrayTest 로 이름을 바꿨다.
 *
 * 실행 결과 (입력 : 33)
 *  배열에 저장된 값은...
 *  [11] [22] [33] [44] [55] [66] [77] [88] [99] [111]
 *  찾을 값을 입력하세요 : 33
 *  33은 배열안에 존재합니다.
 *
 * 실행 결과 (입력 : 13, 줄 번호는 이 파일 기준)
 *  (java 파일이름.java 로 실행하면 맨 아래에 SourceLauncher 줄이 몇 줄 더 붙는다)
 *  배열에 저장된 값은...
 *  [11] [22] [33] [44] [55] [66] [77] [88] [99] [111]
 *  찾을 값을 입력하세요 : 13
 *  NotFound: 원소가 존재하지 않음
 *      at SearchArray.searchNum(SearchArrayTest.java:117)
 *      at SearchArrayTest.main(SearchArrayTest.java:77)
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
