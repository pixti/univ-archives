import java.time.Duration;
import java.time.Instant;

/**
 * [9-1 DateTime] 프로그램 실행 시간 측정하기 - 세 가지 방법 비교
 *
 * 포인트
 *  ① System.currentTimeMillis() : 밀리초(1/1,000초)
 *  ② System.nanoTime()          : 나노초(1/1,000,000,000초)
 *  ③ Instant.now() + Duration.between(start, finish)
 *
 * 💡 슬라이드에는 System. nanoTime() 처럼 점 뒤에 공백이 있다. 컴파일은 되지만 보통 붙여 쓴다.
 * 💡 currentTimeMillis() 는 "지금이 몇 시인지"(벽시계)라서 컴퓨터 시계가 바뀌면 측정값이 틀어질 수 있다.
 *    nanoTime() 은 경과 시간 측정 전용이라 영향이 없다. 단, 값 자체는 날짜와 관계없어 차이만 의미가 있다.
 * 💡 Duration 은 toMillis() 외에도 toNanos(), toSeconds(), toMinutes() 로 원하는 단위를 꺼낼 수 있다.
 * 💡 측정 대상으로 1 ~ 1억 합계 계산(work 메소드)을 넣었다. 슬라이드는 "// ..." / "// CODE HERE" 로 비워 둠.
 *
 * 실행 결과 (컴퓨터에 따라 다름)
 *  ① currentTimeMillis : 35 ms
 *  ② nanoTime          : 31254300 ns (31 ms)
 *  ③ Instant/Duration  : 31 ms
 */
public class ElapsedTimeTest {
    static long work() {
        long sum = 0;
        for (int i = 1; i <= 100_000_000; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        // ① currentTimeMillis()
        long start = System.currentTimeMillis();
        work();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("① currentTimeMillis : " + timeElapsed + " ms");

        // ② nanoTime()
        long nStart = System.nanoTime();
        work();
        long nFinish = System.nanoTime();
        long nElapsed = nFinish - nStart;
        System.out.println("② nanoTime          : " + nElapsed + " ns (" + nElapsed / 1_000_000 + " ms)");

        // ③ Instant + Duration
        Instant iStart = Instant.now();
        work(); // CODE HERE
        Instant iFinish = Instant.now();
        long iElapsed = Duration.between(iStart, iFinish).toMillis();
        System.out.println("③ Instant/Duration  : " + iElapsed + " ms");
    }
}
