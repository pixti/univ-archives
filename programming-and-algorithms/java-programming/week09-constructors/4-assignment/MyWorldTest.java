import java.util.Scanner;

/**
 * [9강 과제] 6번 문제 (MyWorld 클래스 - 일촌 맺기와 인기도)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MyWorldTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyWorld[] P = new MyWorld[4];
        P[0] = new MyWorld("Lee");
        P[1] = new MyWorld("Kim");
        P[2] = new MyWorld("Kang");
        P[3] = new MyWorld("Song");

        for (int i = 0; i < 4; i++) {
            P[i].print();
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(P[i].getName() + "의 친구를 입력하세요 : ");
            String frd = sc.next();
            for (int j = 0; j < 4; j++) {
                if (frd.equals(P[j].getName())) {
                    P[i].setMyFrd(P[j]);
                    P[j].incLoveP();
                    break;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            P[i].print();
        }
        sc.close();
    }
}

class MyWorld {
    private String name;
    private MyWorld myFrd;     // 일촌 (같은 클래스의 객체)
    private int loveP;         // 인기도

    public MyWorld(String name) {
        this.name = name;
        this.myFrd = null;
        this.loveP = 0;
    }

    public String getName() {
        return name;
    }

    public void setMyFrd(MyWorld myFrd) {
        this.myFrd = myFrd;
    }

    public void incLoveP() {
        loveP++;
    }

    public void print() {
        System.out.println("=======================");
        System.out.println("이름 : " + name);
        System.out.println("일촌 : " + (myFrd != null ? myFrd.getName() : "없음"));
        System.out.println("인기도 : " + loveP);
    }
}
