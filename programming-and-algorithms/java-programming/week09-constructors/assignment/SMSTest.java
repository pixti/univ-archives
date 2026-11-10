/**
 * [9강 과제] 5번 문제 (SMS 클래스 - 문자 메시지)
 *
 * 문제 (요약)
 *  송신자(sender), 수신자(receiver), 메시지 내용(msgtext), 시각(time)을 필드로 가지는 SMS 클래스를 작성하시오.
 *  - 생성자 : SMS(sender, receiver), SMS(sender, receiver, msgtext, time)
 *  - setTime(), setText() 와 getter, 메시지를 출력하는 print() 를 둔다.
 *  - 주어진 main 으로 두 메시지를 출력한다.
 *
 * 포인트
 *  - SMS(sender, receiver) 는 아직 내용과 시각이 없는 메시지 → this(sender, receiver, "", "") 로 빈 문자열을 채운다.
 *    나중에 setTime(), setMsgtext() 로 값을 넣는다. (생성자 = 초기 상태, 세터 = 나중에 수정 → 퀴즈 📝 필기)
 *
 * 💡 문제는 메시지를 바꾸는 메소드를 setText() 로 요구하지만 주어진 main 은 setMsgtext() 를 호출한다.
 *    그래서 두 메소드를 모두 만들고 setText() 는 setMsgtext() 를 호출하게 했다.
 * 💡 빈 값을 null 대신 "" 로 넣으면 출력할 때 "null" 이 찍히지 않고, 문자열 메소드를 호출해도 NullPointerException 이 안 난다.
 * 💡 receiver 는 print() 에서 출력하지 않는다. (문제의 실행 결과 형식)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. SMSTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  송신자 : 010-555-2111
 *  시  각 : 03:10
 *  메시지 : Hi
 *  ===============================
 *  송신자 : 010-555-1111
 *  시  각 : 03:11
 *  메시지 : Hm..
 */
public class SMSTest {
    public static void main(String[] args) {
        SMS m1 = new SMS("010-555-2111", "010-555-1111", "Hi", "03:10");
        SMS m2 = new SMS("010-555-1111", "010-555-2111");
        m2.setTime("03:11");
        m2.setMsgtext("Hm..");

        m1.print();
        System.out.println("===============================");
        m2.print();
    }
}

class SMS {
    private String sender;
    private String receiver;
    private String msgtext;
    private String time;

    public SMS(String sender, String receiver) {
        this(sender, receiver, "", "");
    }

    public SMS(String sender, String receiver, String msgtext, String time) {
        this.sender = sender;
        this.receiver = receiver;
        this.msgtext = msgtext;
        this.time = time;
    }

    public void setTime(String time) { this.time = time; }
    public void setMsgtext(String msgtext) { this.msgtext = msgtext; }
    public void setText(String text) { setMsgtext(text); }   // 문제에서 요구한 이름

    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public String getMsgtext() { return msgtext; }
    public String getTime() { return time; }

    public void print() {
        System.out.println("송신자 : " + sender);
        System.out.println("시  각 : " + time);
        System.out.println("메시지 : " + msgtext);
    }
}
