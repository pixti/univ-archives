import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * [7강 과제] 클래스(1) - 4번 문제 (Stopwatch 클래스 - 경과 시간 측정)
 *
 * 문제
 *  start() / stop() 으로 시간을 재는 Stopwatch 클래스를 작성하시오.
 *   - 이미 시작한 상태에서 start() 를 부르면 안내 메시지 출력
 *   - 시작하지 않은 상태에서 stop() 을 부르면 안내 메시지 출력
 *   - getElapsedTime()              : 경과 시간 (밀리초)
 *   - getElapsedTime(TimeUnit unit) : 경과 시간을 원하는 단위로 (오버로딩)
 *
 * 포인트
 *  - Instant.now()                 : 지금 이 순간의 시각
 *  - Duration.between(시작, 끝)    : 두 시각 사이의 시간 간격
 *        duration.toMillis()  → 밀리초 (1/1,000초)
 *        duration.toNanos()   → 나노초 (1/1,000,000,000초)
 *  - isRunning (boolean) 으로 상태를 기억해서 start 를 두 번, stop 을 먼저 부르는 잘못된 사용을 막는다.
 *        if (isRunning) { 메시지; return; }   ← return 으로 메서드를 바로 끝냄 (아래 코드 실행 X)
 *  - getElapsedTime() 과 getElapsedTime(TimeUnit) 은 이름이 같고 매개변수가 다른 메서드 오버로딩 (8-3)
 *  - getDuration() 은 두 getElapsedTime 이 같이 쓰는 private 도우미 메서드 (중복 코드 제거)
 *        - 아직 start 하지 않았으면 Duration.ZERO
 *        - 측정 중이면 지금까지, 멈췄으면 stop 한 시각까지
 *  - unit.convert(값, 원래 단위) : 나노초 값을 원하는 단위(unit)로 변환
 *        TimeUnit.NANOSECONDS.convert(n, TimeUnit.NANOSECONDS) → n 그대로
 *        TimeUnit.SECONDS.convert(n, TimeUnit.NANOSECONDS)     → 초 단위 (소수점 버림)
 *
 *  - Thread.sleep(150) : 150 밀리초 동안 멈춘다. 이 메서드는 InterruptedException 을 던질 수 있으므로
 *    main 에 throws InterruptedException 을 붙였다. (예외 처리는 뒤 주차에서 배움)
 *
 * 💡 sleep 은 "최소" 150ms 를 보장할 뿐이고 실행할 때마다 조금씩 달라서 나노초 값은 매번 다르다.
 *    밀리초도 151, 161 처럼 조금 더 크게 나올 수 있다.
 *
 * 실행 결과 (나노초는 실행할 때마다 다름)
 *  아직 시작하지 않았습니다. start 메서드를 호출하여 시작한 후 stop 메서드를 호출하시기 바랍니다.
 *  이미 시작 중입니다. stop 메서드를 호출하여 중단한 후 start 메서드를 호출 하시기 바랍니다.
 *  경과 시간(밀리초): 150
 *  경과 시간(나노초): 150516300
 */
public class StopwatchTest {
    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = new Stopwatch();
        sw.stop();                 // 시작 전에 stop → 안내 메시지
        sw.start();
        sw.start();                // 이미 시작됨 → 안내 메시지
        Thread.sleep(150);         // 150ms 대기
        sw.stop();

        long millis = sw.getElapsedTime();
        long nanos = sw.getElapsedTime(TimeUnit.NANOSECONDS);
        System.out.println("경과 시간(밀리초): " + millis);
        System.out.println("경과 시간(나노초): " + nanos);
    }
}

class Stopwatch {
    private Instant startTime;
    private Instant stopTime;
    private boolean isRunning;

    public void start() {
        if (isRunning) {
            System.out.println("이미 시작 중입니다. stop 메서드를 호출하여 중단한 후 start 메서드를 호출 하시기 바랍니다.");
            return;
        }
        this.isRunning = true;
        this.startTime = Instant.now();
    }

    public void stop() {
        if (!isRunning) {
            System.out.println("아직 시작하지 않았습니다. start 메서드를 호출하여 시작한 후 stop 메서드를 호출하시기 바랍니다.");
            return;
        }
        this.stopTime = Instant.now();
        this.isRunning = false;
    }

    private Duration getDuration() {
        if (startTime == null) return Duration.ZERO;           // 한 번도 시작하지 않음
        Instant end = isRunning ? Instant.now() : stopTime;    // 측정 중이면 지금까지
        return Duration.between(startTime, end);
    }

    public long getElapsedTime() {                             // 밀리초
        return getDuration().toMillis();
    }

    public long getElapsedTime(TimeUnit unit) {                // 오버로딩 : 원하는 단위
        return unit.convert(getDuration().toNanos(), TimeUnit.NANOSECONDS);
    }
}
