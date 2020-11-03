package effectiveJava;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 코드 81-3 동시 실행 시간을 재는 간단한 프레임워크 (433-434쪽)
public class ConcurrentTimer {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(10);
        System.out.println("time :" + time(e, 10, () -> System.out.println("Thread")));
        e.shutdown();
    }

    private ConcurrentTimer() { } // 인스턴스 생성 불가

    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done  = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // 타이머에게 준비를 마쳤음을 알린다.
                try {
                    start.await(); // 모든 작업자 스레드가 준비될 때까지 기다린다.
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();  // 타이머에게 작업을 마쳤음을 알린다.
                }
            });

/*
    ready.await();
    long startNanos = System.nanoTime();
    start.countDown();
    done.await();
    Thread
    Thread
    Thread
    Thread
    Thread
    Thread
    Thread
    Thread
    Thread
    Thread
    time :618814
 */


        }

        System.out.println("ready.await();");
        ready.await();     // 모든 작업자가 준비될 때까지 기다린다.
        System.out.println("long startNanos = System.nanoTime();");
        long startNanos = System.nanoTime();
        System.out.println("start.countDown();");
        start.countDown(); // 작업자들을 깨운다.
        System.out.println("done.await();");
        done.await();      // 모든 작업자가 일을 끝마치기를 기다린다.
        return System.nanoTime() - startNanos;
    }
}
