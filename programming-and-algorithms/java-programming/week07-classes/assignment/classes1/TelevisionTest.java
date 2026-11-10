/**
 * [7강 과제] 클래스(1) - 3번 문제 (Television 클래스 - 전원 · 채널 · 볼륨, toString)
 *
 * 문제
 *  아래 UML 대로 Television 클래스를 작성하시오.
 *
 *      ┌──────────────────────────────┐
 *      │          Television          │
 *      ├──────────────────────────────┤
 *      │ - isOn                       │
 *      │ - volume                     │
 *      │ - channel                    │
 *      ├──────────────────────────────┤
 *      │ + setChannel() / getChannel()│
 *      │ + setVolume()  / getVolume() │
 *      │ + turnOn() / turnOff()       │
 *      │ + toString()                 │
 *      └──────────────────────────────┘
 *
 * 포인트
 *  - isOn 은 boolean : turnOn() 에서 true, turnOff() 에서 false
 *  - toString() 안에서 삼항 연산자로 true / false 를 "켜짐" / "꺼짐" 으로 바꿔 출력
 *        (isOn ? "켜짐" : "꺼짐")
 *  - 전원을 꺼도 채널 · 볼륨 값은 그대로 남는다. (세 번째 출력 : 꺼짐, 채널 11, 볼륨 20)
 *
 * 📝 필기 (질문) @Override 붙이는 이유는 뭐임
 * 📝 필기 (AI 설명)
 *   - @Override 는 "이 메서드는 부모 클래스(또는 인터페이스)의 메서드를 재정의(오버라이딩)한 것" 이라고
 *     컴파일러에게 알려 주는 어노테이션(annotation)이다.
 *     toString() 은 모든 클래스의 부모인 Object 클래스에 이미 있는 메서드라서 재정의하는 것이다.
 *   - 붙이지 않아도 동작은 같다. (선택 사항) 하지만 붙이는 것을 권장한다.
 *     ① 오타 방지
 *          public String tostring() { ... }               // 소문자 s → 재정의가 아니라 "새 메서드" 가 조용히 만들어짐
 *                                                          //   println(tv) 하면 Television@1b6d3586 이 출력됨
 *          @Override public String tostring() { ... }     // → 컴파일 에러 : method does not override or
 *                                                          //   implement a method from a supertype
 *     ② 가독성 : 코드를 읽는 사람이 "부모 메서드를 재정의한 것" 임을 바로 안다.
 *     ③ 유지보수 : 나중에 부모 클래스의 메서드 이름이나 매개변수가 바뀌면, @Override 가 붙은 곳에서
 *                 바로 컴파일 에러가 나서 고쳐야 할 곳을 놓치지 않는다.
 *   (상속과 오버라이딩은 뒤 주차에서 자세히 배움)
 *
 * 💡 System.out.println(tv.toString()) 은 System.out.println(tv) 로 써도 같다. (println 이 toString 을 자동 호출)
 *
 * 실행 결과
 *  TV 상태 [전원: 켜짐, 채널: 7, 볼륨: 15]
 *  TV 상태 [전원: 켜짐, 채널: 11, 볼륨: 20]
 *  TV 상태 [전원: 꺼짐, 채널: 11, 볼륨: 20]
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
