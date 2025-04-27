package concurrent;

import java.util.concurrent.*;

/**
 * @author 佳叙
 * @date 2025/4/26
 * @description <a href=""/>
 */
public class _ThreadPool {

    private void main(String[] args) {
        new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), new ThreadPoolExecutor.AbortPolicy());

        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(100);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(100);


        System.out.println();
    }

}