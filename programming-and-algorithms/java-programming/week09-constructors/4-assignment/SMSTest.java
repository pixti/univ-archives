/**
 * [9강 과제] 5번 문제 (SMS 클래스 - 문자 메시지)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
