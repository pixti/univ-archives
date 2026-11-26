import java.time.Duration;
import java.time.Instant;

/**
 * [9-1 DateTime] 프로그램 실행 시간 측정하기 - 세 가지 방법 비교
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
