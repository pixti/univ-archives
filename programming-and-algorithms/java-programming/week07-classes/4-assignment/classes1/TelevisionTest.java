/**
 * [7강 과제] 클래스(1) - 3번 문제 (Television 클래스 - 전원 · 채널 · 볼륨, toString)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TelevisionTest {
    public static void main(String[] args) {
        Television tv = new Television();
        tv.turnOn();
        tv.setChannel(7);
        tv.setVolume(15);
        System.out.println(tv.toString());

        tv.setChannel(11);
        tv.setVolume(20);
        System.out.println(tv.toString());

        tv.turnOff();
        System.out.println(tv.toString());
    }
}

class Television {
    private boolean isOn;
    private int volume;
    private int channel;

    public void setChannel(int channel) { this.channel = channel; }
    public int getChannel() { return channel; }

    public void setVolume(int volume) { this.volume = volume; }
    public int getVolume() { return volume; }

    public void turnOn() { isOn = true; }
    public void turnOff() { isOn = false; }

    @Override       // 📝 Object 의 toString() 을 재정의
    public String toString() {
        return "TV 상태 [전원: " + (isOn ? "켜짐" : "꺼짐") + ", 채널: " + channel + ", 볼륨: " + volume + "]";
    }
}
