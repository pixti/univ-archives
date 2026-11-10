import java.util.Scanner;

/**
 * [9강 과제] 6번 문제 (MyWorld 클래스 - 일촌 맺기와 인기도)
 *
 * 문제 (요약)
 *  이름(name), 일촌(myFrd, MyWorld 객체), 인기도(loveP)를 필드로 가지는 MyWorld 클래스를 작성하시오.
 *  - 생성자 MyWorld(name) : 이름을 받고 일촌은 없음(null), 인기도는 0 으로 초기화한다.
 *  - getName(), setMyFrd(친구), incLoveP()(인기도 1 증가), print() 를 둔다.
 *  - 주어진 main 에서 Lee, Kim, Kang, Song 네 명을 만들고, 한 명씩 친구 이름을 입력받아 일촌을 맺는다.
 *    일촌으로 선택된 사람은 인기도가 1 올라간다.
 *
 * 포인트
 *  - 자기 자신과 같은 클래스(MyWorld)의 객체를 필드로 가진다. → 객체끼리 서로 "가리키는" 관계
 *  - 객체 배열 P[] 에서 입력한 이름과 같은 객체를 찾아 그 레퍼런스를 setMyFrd 로 넘긴다.
 *
 * 💡 myFrd 가 null 인 상태에서 myFrd.getName() 을 호출하면 NullPointerException 이 난다.
 *    그래서 print() 에서 (myFrd != null ? myFrd.getName() : "없음") 으로 먼저 검사했다.
 * 💡 문자열 비교는 == 가 아니라 equals() 를 쓴다. (6강 문자열)
 * 💡 P[j].incLoveP() 는 "친구로 선택된 사람" 의 인기도를 올린다. (내가 아니라 상대방)
 * 💡 입력한 이름이 목록에 없으면 아무 일도 일어나지 않는다(일촌 없음 유지). 주어진 main 그대로 두었다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. MyWorldTest 로 이름을 바꿨다.
 *
 * 실행 결과 (입력 : Kim, Kang, Kim, Lee)
 *  =======================
 *  이름 : Lee
 *  일촌 : 없음
 *  인기도 : 0
 *  =======================
 *  이름 : Kim
 *  일촌 : 없음
 *  인기도 : 0
 *  =======================
 *  이름 : Kang
 *  일촌 : 없음
 *  인기도 : 0
 *  =======================
 *  이름 : Song
 *  일촌 : 없음
 *  인기도 : 0
 *  Lee의 친구를 입력하세요 : Kim
 *  Kim의 친구를 입력하세요 : Kang
 *  Kang의 친구를 입력하세요 : Kim
 *  Song의 친구를 입력하세요 : Lee
 *  =======================
 *  이름 : Lee
 *  일촌 : Kim
 *  인기도 : 1
 *  =======================
 *  이름 : Kim
 *  일촌 : Kang
 *  인기도 : 2
 *  =======================
 *  이름 : Kang
 *  일촌 : Kim
 *  인기도 : 1
 *  =======================
 *  이름 : Song
 *  일촌 : Lee
 *  인기도 : 0
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
