import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * [7강 과제] 클래스(1) - 4번 문제 (Stopwatch 클래스 - 경과 시간 측정)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
