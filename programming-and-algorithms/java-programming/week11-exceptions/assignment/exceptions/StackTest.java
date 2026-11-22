/**
 * [11강 과제] 예외 처리 - 3번 문제 (Stack : Stack Underflow / Stack Overflow)
 *
 * 문제
 *  스택(stack)은 먼저 들어온 요소가 먼저 나가는 자료 구조이다. 정수들이 저장된 Stack 클래스를 가정한다. Stack 은 정수 배열을
 *  필드로 가지며, 데이터를 추가하는 push() 와 데이터를 제거하는 pop() 메서드를 가진다. 만약 pop() 메서드가 호출이 되었는데
 *  데이터가 없으면 "Stack Underflow" 예외를 발생시키며, 반대로 데이터가 가득찬 상태에서 push() 메서드가 호출이 되면
 *  "Stack Overflow" 를 발생시키도록 한다. 단, 예외는 새로운 클래스로 정의하지 말고 Exception 클래스를 이용토록 한다.
 *  Stack 객체를 main() 안에서 생성하여서 테스트하라. try/catch 블록을 이용하여서 예외를 처리하도록 하라.
 *
 *    public class Test2 {
 *        public static void main(String[] args) {
 *            // Create instances of each vehicle type
 *            Stack s = new Stack();
 *
 *            s.push(3);
 *            s.display();
 *            s.push(4);
 *            s.display();
 *            s.pop();
 *            s.display();
 *            s.pop();
 *            s.display();
 *            s.pop();
 *        }
 *    }
 *
 *    실행 결과 :
 *    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *    스택[0]에 저장된값은 :3
 *    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 *    (... 생략 ...)
 *    Stack_Underflow: Stack Underflow
 *        at Stack.pop(Test2.java:76)
 *        at Test2.main(Test2.java:41)
 *
 * ⚠ 자주 틀리는 부분 : 스택은 "먼저 들어온 요소가 먼저 나가는" 구조가 아니다. 그건 큐(Queue, FIFO)다.
 *    스택은 "나중에 들어온 요소가 먼저 나가는" 구조(LIFO, Last In First Out)다. 접시를 쌓고 맨 위부터 꺼내는 것과 같다.
 *    이 코드도 push(3), push(4) 다음 pop() 하면 나중에 넣은 4 가 먼저 빠진다.
 * ⚠ 문제의 실행 결과는 "Stack_Underflow: Stack Underflow" 처럼 별도의 예외 클래스 이름이 찍혀 있지만, 문제 조건은
 *    "새로운 클래스로 정의하지 말고 Exception 을 이용" 하라고 한다. new Exception("Stack Underflow") 를 던지면 실제로는
 *    java.lang.Exception: Stack Underflow 로 출력된다.
 *
 * 포인트
 *  - top : 마지막으로 넣은 데이터의 인덱스. 비어 있을 때는 -1 이다.
 *  - push : top >= maxSize - 1 (이미 꽉 참)이면 Stack Overflow. 아니면 stack[++top] = data; (top 을 먼저 1 늘리고 그 칸에 저장)
 *  - pop  : top < 0 (비어 있음)이면 Stack Underflow. 아니면 return stack[top--]; (그 칸의 값을 돌려준 뒤 top 을 1 줄임)
 *  - 예외 클래스를 새로 만들지 않고 throw new Exception("Stack Underflow"); 처럼 Exception 에 메시지만 담아서 던진다.
 *    Exception 은 Checked 이므로 push, pop 에 throws Exception 이 필요하고, main 은 catch (Exception e) 로 잡는다.
 *  - 세 번째 pop() 에서 스택이 비어 있어서(top == -1) 예외가 난다.
 *
 * 💡 ++top 과 top-- 의 차이 (2강 증감 연산자) : ++top 은 먼저 증가시킨 값을 쓰고, top-- 는 지금 값을 쓴 뒤 감소시킨다.
 * 💡 pop() 은 꺼낸 값을 돌려주지만 main 에서는 받지 않는다. int x = s.pop(); 처럼 받아서 쓸 수도 있다.
 * 💡 pop 한 칸의 값은 배열에 그대로 남아 있지만 top 이 줄었기 때문에 display() 에서는 보이지 않는다.
 * 💡 자바에는 이미 java.util.Stack 클래스가 있다. 이 파일은 import 하지 않았기 때문에 직접 만든 Stack 이 쓰인다.
 *    (12강 컬렉션에서는 Deque / ArrayDeque 를 스택으로 쓰는 것을 권장한다)
 * 💡 printStackTrace() 의 줄 번호는 파일 구성에 따라 달라진다. (처음 작성한 코드는 27, 54)
 * 💡 원래 이클립스에서 Test2 클래스로 작성한 코드. 같은 폴더의 다른 문제도 Test2 라서 StackTest 로 이름을 바꿨다.
 *
 * 실행 결과 (줄 번호는 이 파일 기준, 맨 아래에 빈 줄 포함)
 *  (java 파일이름.java 로 실행하면 맨 아래에 SourceLauncher 줄이 몇 줄 더 붙는다)
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  스택[0]에 저장된값은 :3
 *  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 *
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  스택[0]에 저장된값은 :3
 *  스택[1]에 저장된값은 :4
 *  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 *
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  스택[0]에 저장된값은 :3
 *  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 *
 *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 *
 *  java.lang.Exception: Stack Underflow
 *      at Stack.pop(StackTest.java:128)
 *      at StackTest.main(StackTest.java:95)
 */
public class StackTest {
    public static void main(String[] args) {
        Stack s = new Stack();

        try {
            s.push(3);
            s.display();
            s.push(4);
            s.display();
            s.pop();
            s.display();
            s.pop();
            s.display();
            s.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Stack {
    private int[] stack;
    private int top;
    private int maxSize;

    public Stack() {
        this.maxSize = 10;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    public Stack(int size) {
        this.maxSize = size;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    public void push(int data) throws Exception {
        if (top >= maxSize - 1) {
            throw new Exception("Stack Overflow");
        }
        stack[++top] = data;
    }

    public int pop() throws Exception {
        if (top < 0) {
            throw new Exception("Stack Underflow");
        }
        return stack[top--];
    }

    public void display() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i <= top; i++) {
            System.out.println("스택[" + i + "]에 저장된값은 :" + stack[i]);
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
}
