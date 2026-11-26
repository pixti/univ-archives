/**
 * [11강 과제] 예외 처리 - 3번 문제 (Stack : Stack Underflow / Stack Overflow)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
